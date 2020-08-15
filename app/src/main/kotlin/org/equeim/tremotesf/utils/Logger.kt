/*
 * Copyright (C) 2017-2020 Alexey Rochev <equeim@gmail.com>
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

package org.equeim.tremotesf.utils

import android.util.Log

private val Class<*>.loggerTag: String
    get() {
        var decl: Class<*>? = declaringClass ?: return simpleName.ifEmpty { name }
        val builder = StringBuilder(simpleName)
        while (decl != null) {
            val name = decl.simpleName
            builder.apply {
                ensureCapacity(name.length + 1)
                insert(0, ".")
                insert(0, name)
            }
            decl = decl.declaringClass
        }
        return builder.toString()
    }

interface Logger {
    private val loggerTag: String
        get() = javaClass.loggerTag

    fun verbose(msg: String, tr: Throwable? = null) {
        Log.v(loggerTag, msg, tr)
    }

    fun debug(msg: String, tr: Throwable? = null) {
        Log.d(loggerTag, msg, tr)
    }

    fun info(msg: String, tr: Throwable? = null) {
        Log.i(loggerTag, msg, tr)
    }

    fun warn(msg: String, tr: Throwable? = null) {
        Log.w(loggerTag, msg, tr)
    }

    fun error(msg: String, tr: Throwable? = null) {
        Log.e(loggerTag, msg, tr)
    }
}
