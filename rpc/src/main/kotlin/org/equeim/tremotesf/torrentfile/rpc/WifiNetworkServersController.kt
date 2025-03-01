/*
 * Copyright (C) 2017-2021 Alexey Rochev <equeim@gmail.com>
 *
 * This file is part of Tremotesf.
 *
 * Tremotesf is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Tremotesf is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

@file:Suppress("DEPRECATION")

package org.equeim.tremotesf.torrentfile.rpc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import androidx.annotation.MainThread
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import androidx.core.net.ConnectivityManagerCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus
import timber.log.Timber


class WifiNetworkServersController(private val servers: Servers, scope: CoroutineScope, private val context: Context) {
    private val wifiManager by lazy { context.getSystemService<WifiManager>() }
    private val connectivityManager by lazy { context.getSystemService<ConnectivityManager>() }

    val enabled = MutableStateFlow(false)

    private val _observingActiveWifiNetwork = MutableStateFlow(false)
    val observingActiveWifiNetwork: StateFlow<Boolean> by ::_observingActiveWifiNetwork

    private var wifiNetworkObserverScope: CoroutineScope? = null

    val currentWifiSsid: String?
        get() = currentWifiInfo?.knownSsidOrNull

    init {
        Timber.i("init")

        val hasServerWithWifiNetwork = servers.servers.map { servers ->
            val has =
                servers.find { it.autoConnectOnWifiNetworkEnabled && it.autoConnectOnWifiNetworkSSID.isNotBlank() } != null
            if (has) {
                Timber.i("There are servers with Wi-Fi networks configured")
            } else {
                Timber.i("There are no servers with Wi-Fi networks configured")
            }
            has
        }

        combine(hasServerWithWifiNetwork, enabled, Boolean::and)
            .distinctUntilChanged()
            .dropWhile { !it }
            .onEach { shouldObserveWifiNetworks ->
                _observingActiveWifiNetwork.value = shouldObserveWifiNetworks
                if (shouldObserveWifiNetworks) {
                    startObservingActiveWifiNetwork()
                } else {
                    stopObservingActiveWifiNetwork()
                }
            }
            .launchIn(scope + Dispatchers.Main)
    }

    @MainThread
    private fun startObservingActiveWifiNetwork() {
        Timber.i("startObservingActiveWifiNetwork() called")

        val connectivityManager = connectivityManager
        if (connectivityManager == null) {
            Timber.e("startObservingActiveWifiNetwork: ConnectivityManager is null")
            return
        }

        val scope = CoroutineScope(Dispatchers.Main).also { wifiNetworkObserverScope = it }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            observeActiveWifiNetworkV24(connectivityManager)
        } else {
            observeActiveWifiNetworkV16(connectivityManager)
        }.onEach { onActiveWifiNetworkChanged() }.launchIn(scope)
    }

    @MainThread
    private fun stopObservingActiveWifiNetwork() {
        Timber.i("stopObservingActiveWifiNetwork() called")
        wifiNetworkObserverScope?.apply {
            cancel()
            wifiNetworkObserverScope = null
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun observeActiveWifiNetworkV24(connectivityManager: ConnectivityManager): Flow<Unit> {
        Timber.i("observeActiveWifiNetworkV24() called with: context = $context")
        @Suppress("EXPERIMENTAL_API_USAGE")
        return callbackFlow<Unit> {
            Timber.i("observeActiveWifiNetworkV24: registering network callback")
            val callback = DefaultNetworkCallback(channel)
            connectivityManager.registerDefaultNetworkCallback(callback)
            awaitClose {
                Timber.i("observeActiveWifiNetworkV24: unregister network callback")
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }.buffer(Channel.CONFLATED)
    }

    // TODO: extract WifiInfo from NetworkCapabilities on Android S
    @RequiresApi(Build.VERSION_CODES.N)
    private class DefaultNetworkCallback(private val channel: SendChannel<Unit>) :
        ConnectivityManager.NetworkCallback() {
        private var waitingForCapabilities = false

        override fun onAvailable(network: Network) {
            Timber.i("onAvailable() called with: network = $network")
            waitingForCapabilities = true
        }

        override fun onLost(network: Network) {
            Timber.i("onLost() called with: network = $network")
            waitingForCapabilities = false
        }

        override fun onLosing(network: Network, maxMsToLive: Int) {
            Timber.i("onLosing() called with: network = $network, maxMsToLive = $maxMsToLive")
        }

        override fun onUnavailable() {
            Timber.i("onUnavailable() called")
        }

        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            if (!waitingForCapabilities) return

            Timber.i("onCapabilitiesChanged: networkCapabilities = $networkCapabilities")

            if (!networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Timber.i("onCapabilitiesChanged: not Wi-Fi network, ignore")
                waitingForCapabilities = false
                return
            }

            if (wifiNetworkCapabilities.all { networkCapabilities.hasCapability(it) }) {
                Timber.i("onCapabilitiesChanged: supported Wi-Fi network")
                waitingForCapabilities = false
                channel.offer(Unit)
            } else {
                Timber.i("onCapabilitiesChanged: unsupported network, wait")
            }
        }
    }

    private fun observeActiveWifiNetworkV16(connectivityManager: ConnectivityManager): Flow<Unit> {
        Timber.i("observeActiveWifiNetworkV16() called")
        @Suppress("EXPERIMENTAL_API_USAGE")
        return callbackFlow<Unit> {
            Timber.i("observeActiveWifiNetworkV16: registering receiver")
            val receiver = ConnectivityReceiver(connectivityManager, channel)
            context.registerReceiver(
                receiver,
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
            awaitClose {
                Timber.i("observeActiveWifiNetworkV16: unregister receiver")
                context.unregisterReceiver(receiver)
            }
        }.buffer(Channel.CONFLATED)
    }

    private class ConnectivityReceiver(private val connectivityManager: ConnectivityManager, private val channel: SendChannel<Unit>) :
        BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val networkInfo = ConnectivityManagerCompat.getNetworkInfoFromBroadcast(connectivityManager, intent)
            Timber.i("onReceive: networkInfo = $networkInfo")
            if (networkInfo?.isConnected == true && networkInfo.type == ConnectivityManager.TYPE_WIFI) {
                Timber.i("onReceive: Wi-Fi connected")
                channel.offer(Unit)
            }
        }
    }

    @MainThread
    private fun onActiveWifiNetworkChanged() {
        Timber.i("onActiveWifiNetworkChanged() called")

        val wifiInfo = currentWifiInfo
        Timber.i("onActiveWifiNetworkChanged: current WifiInfo: $currentWifiInfo")

        val ssid = wifiInfo?.knownSsidOrNull
        if (ssid != null) {
            Timber.i("onActiveWifiNetworkChanged: SSID = '$ssid'")
            setCurrentServerFromWifiNetwork(lazyOf(ssid))
        } else {
            Timber.e("onActiveWifiNetworkChanged: SSID is null")
        }
    }

    @MainThread
    fun setCurrentServerFromWifiNetwork(ssidLazy: Lazy<String?> = lazy { currentWifiSsid }): Boolean {
        Timber.i("setCurrentServerFromWifiNetwork() called")

        val ssid by ssidLazy

        val currentServer = servers.currentServer.value
        for (server in servers.servers.value) {
            if (server.autoConnectOnWifiNetworkEnabled) {
                if (ssid == null) {
                    Timber.i("setCurrentServerFromWifiNetwork: SSID is null")
                    return false
                }
                if (server.autoConnectOnWifiNetworkSSID == ssid) {
                    Timber.i("setCurrentServerFromWifiNetwork: server with name = ${server.name}, address = ${server.address}, port = ${server.port} matches Wi-Fi SSID = '$ssid'")
                    if (server != currentServer) {
                        Timber.i("setCurrentServerFromWifiNetwork: setting current server")
                        servers.setCurrentServer(server)
                        return true
                    } else {
                        Timber.i("setCurrentServerFromWifiNetwork: current server is already the same")
                        return false
                    }
                }
            }
        }
        Timber.i("setCurrentServerFromWifiNetwork: no matching servers found")
        return false
    }

    private val currentWifiInfo: WifiInfo?
        get() {
            val wifiManager = wifiManager
            return if (wifiManager != null) {
                wifiManager.connectionInfo.also {
                    if (it == null) {
                        Timber.e("currentWifiInfo: getConnectionInfo() returned null")
                    }
                }
            } else {
                Timber.e("currentWifiInfo: WifiManager is null")
                null
            }
        }

    private val WifiInfo.knownSsidOrNull: String?
        get() = ssid.takeIf { ssid: String? ->
            when {
                ssid == null -> Timber.e("knownSsidOrNull: SSID is null")
                ssid.isEmpty() -> Timber.e("knownSsidOrNull: SSID is empty")
                ssid == UNKNOWN_SSID -> Timber.e("knownSsidOrNull: SSID is unknown")
                else -> return@takeIf true
            }
            false
        }?.removeSsidQuotes()?.takeIf {
            val notBlank = it.isNotBlank()
            if (!notBlank) Timber.e("knownSsidOrNull: SSID = '$it' is empty or blank")
            notBlank
        }

    private val UNKNOWN_SSID = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        WifiManager.UNKNOWN_SSID
    } else {
        "<unknown ssid>"
    }

    private fun String.removeSsidQuotes(): String? {
        return if (startsWith(quoteChar) && endsWith(quoteChar)) {
            drop(1).dropLast(1)
        } else {
            Timber.e("removeQuotes: SSID = '$this' is not surrounded by quotation marks, unsupported")
            null
        }
    }

    private companion object {
        const val quoteChar = '"'

        @RequiresApi(Build.VERSION_CODES.N)
        val wifiNetworkCapabilities = arrayOf(
            NetworkCapabilities.NET_CAPABILITY_NOT_RESTRICTED,
            NetworkCapabilities.NET_CAPABILITY_TRUSTED,
            NetworkCapabilities.NET_CAPABILITY_NOT_VPN
        ).let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                it + arrayOf(
                    NetworkCapabilities.NET_CAPABILITY_FOREGROUND,
                    NetworkCapabilities.NET_CAPABILITY_NOT_SUSPENDED
                )
            } else {
                it
            }
        }
    }
}
