/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.equeim.libtremotesf;

public class ServerSettings {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ServerSettings(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ServerSettings obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtremotesfJNI.delete_ServerSettings(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public int rpcVersion() {
    return libtremotesfJNI.ServerSettings_rpcVersion(swigCPtr, this);
  }

  public int minimumRpcVersion() {
    return libtremotesfJNI.ServerSettings_minimumRpcVersion(swigCPtr, this);
  }

  public boolean canRenameFiles() {
    return libtremotesfJNI.ServerSettings_canRenameFiles(swigCPtr, this);
  }

  public boolean canShowFreeSpaceForPath() {
    return libtremotesfJNI.ServerSettings_canShowFreeSpaceForPath(swigCPtr, this);
  }

  public String downloadDirectory() {
    return libtremotesfJNI.ServerSettings_downloadDirectory(swigCPtr, this);
}

  public void setDownloadDirectory(String directory) {
    libtremotesfJNI.ServerSettings_setDownloadDirectory(swigCPtr, this, directory);
  }

  public boolean startAddedTorrents() {
    return libtremotesfJNI.ServerSettings_startAddedTorrents(swigCPtr, this);
  }

  public void setStartAddedTorrents(boolean start) {
    libtremotesfJNI.ServerSettings_setStartAddedTorrents(swigCPtr, this, start);
  }

  public boolean trashTorrentFiles() {
    return libtremotesfJNI.ServerSettings_trashTorrentFiles(swigCPtr, this);
  }

  public void setTrashTorrentFiles(boolean trash) {
    libtremotesfJNI.ServerSettings_setTrashTorrentFiles(swigCPtr, this, trash);
  }

  public boolean renameIncompleteFiles() {
    return libtremotesfJNI.ServerSettings_renameIncompleteFiles(swigCPtr, this);
  }

  public void setRenameIncompleteFiles(boolean rename) {
    libtremotesfJNI.ServerSettings_setRenameIncompleteFiles(swigCPtr, this, rename);
  }

  public boolean isIncompleteDirectoryEnabled() {
    return libtremotesfJNI.ServerSettings_isIncompleteDirectoryEnabled(swigCPtr, this);
  }

  public void setIncompleteDirectoryEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setIncompleteDirectoryEnabled(swigCPtr, this, enabled);
  }

  public String incompleteDirectory() {
    return libtremotesfJNI.ServerSettings_incompleteDirectory(swigCPtr, this);
}

  public void setIncompleteDirectory(String directory) {
    libtremotesfJNI.ServerSettings_setIncompleteDirectory(swigCPtr, this, directory);
  }

  public boolean isRatioLimited() {
    return libtremotesfJNI.ServerSettings_isRatioLimited(swigCPtr, this);
  }

  public void setRatioLimited(boolean limited) {
    libtremotesfJNI.ServerSettings_setRatioLimited(swigCPtr, this, limited);
  }

  public double ratioLimit() {
    return libtremotesfJNI.ServerSettings_ratioLimit(swigCPtr, this);
  }

  public void setRatioLimit(double limit) {
    libtremotesfJNI.ServerSettings_setRatioLimit(swigCPtr, this, limit);
  }

  public boolean isIdleSeedingLimited() {
    return libtremotesfJNI.ServerSettings_isIdleSeedingLimited(swigCPtr, this);
  }

  public void setIdleSeedingLimited(boolean limited) {
    libtremotesfJNI.ServerSettings_setIdleSeedingLimited(swigCPtr, this, limited);
  }

  public int idleSeedingLimit() {
    return libtremotesfJNI.ServerSettings_idleSeedingLimit(swigCPtr, this);
  }

  public void setIdleSeedingLimit(int limit) {
    libtremotesfJNI.ServerSettings_setIdleSeedingLimit(swigCPtr, this, limit);
  }

  public boolean isDownloadQueueEnabled() {
    return libtremotesfJNI.ServerSettings_isDownloadQueueEnabled(swigCPtr, this);
  }

  public void setDownloadQueueEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setDownloadQueueEnabled(swigCPtr, this, enabled);
  }

  public int downloadQueueSize() {
    return libtremotesfJNI.ServerSettings_downloadQueueSize(swigCPtr, this);
  }

  public void setDownloadQueueSize(int size) {
    libtremotesfJNI.ServerSettings_setDownloadQueueSize(swigCPtr, this, size);
  }

  public boolean isSeedQueueEnabled() {
    return libtremotesfJNI.ServerSettings_isSeedQueueEnabled(swigCPtr, this);
  }

  public void setSeedQueueEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setSeedQueueEnabled(swigCPtr, this, enabled);
  }

  public int seedQueueSize() {
    return libtremotesfJNI.ServerSettings_seedQueueSize(swigCPtr, this);
  }

  public void setSeedQueueSize(int size) {
    libtremotesfJNI.ServerSettings_setSeedQueueSize(swigCPtr, this, size);
  }

  public boolean isIdleQueueLimited() {
    return libtremotesfJNI.ServerSettings_isIdleQueueLimited(swigCPtr, this);
  }

  public void setIdleQueueLimited(boolean limited) {
    libtremotesfJNI.ServerSettings_setIdleQueueLimited(swigCPtr, this, limited);
  }

  public int idleQueueLimit() {
    return libtremotesfJNI.ServerSettings_idleQueueLimit(swigCPtr, this);
  }

  public void setIdleQueueLimit(int limit) {
    libtremotesfJNI.ServerSettings_setIdleQueueLimit(swigCPtr, this, limit);
  }

  public boolean isDownloadSpeedLimited() {
    return libtremotesfJNI.ServerSettings_isDownloadSpeedLimited(swigCPtr, this);
  }

  public void setDownloadSpeedLimited(boolean limited) {
    libtremotesfJNI.ServerSettings_setDownloadSpeedLimited(swigCPtr, this, limited);
  }

  public int downloadSpeedLimit() {
    return libtremotesfJNI.ServerSettings_downloadSpeedLimit(swigCPtr, this);
  }

  public void setDownloadSpeedLimit(int limit) {
    libtremotesfJNI.ServerSettings_setDownloadSpeedLimit(swigCPtr, this, limit);
  }

  public boolean isUploadSpeedLimited() {
    return libtremotesfJNI.ServerSettings_isUploadSpeedLimited(swigCPtr, this);
  }

  public void setUploadSpeedLimited(boolean limited) {
    libtremotesfJNI.ServerSettings_setUploadSpeedLimited(swigCPtr, this, limited);
  }

  public int uploadSpeedLimit() {
    return libtremotesfJNI.ServerSettings_uploadSpeedLimit(swigCPtr, this);
  }

  public void setUploadSpeedLimit(int limit) {
    libtremotesfJNI.ServerSettings_setUploadSpeedLimit(swigCPtr, this, limit);
  }

  public boolean isAlternativeSpeedLimitsEnabled() {
    return libtremotesfJNI.ServerSettings_isAlternativeSpeedLimitsEnabled(swigCPtr, this);
  }

  public void setAlternativeSpeedLimitsEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setAlternativeSpeedLimitsEnabled(swigCPtr, this, enabled);
  }

  public int alternativeDownloadSpeedLimit() {
    return libtremotesfJNI.ServerSettings_alternativeDownloadSpeedLimit(swigCPtr, this);
  }

  public void setAlternativeDownloadSpeedLimit(int limit) {
    libtremotesfJNI.ServerSettings_setAlternativeDownloadSpeedLimit(swigCPtr, this, limit);
  }

  public int alternativeUploadSpeedLimit() {
    return libtremotesfJNI.ServerSettings_alternativeUploadSpeedLimit(swigCPtr, this);
  }

  public void setAlternativeUploadSpeedLimit(int limit) {
    libtremotesfJNI.ServerSettings_setAlternativeUploadSpeedLimit(swigCPtr, this, limit);
  }

  public boolean isAlternativeSpeedLimitsScheduled() {
    return libtremotesfJNI.ServerSettings_isAlternativeSpeedLimitsScheduled(swigCPtr, this);
  }

  public void setAlternativeSpeedLimitsScheduled(boolean scheduled) {
    libtremotesfJNI.ServerSettings_setAlternativeSpeedLimitsScheduled(swigCPtr, this, scheduled);
  }

  public int alternativeSpeedLimitsBeginTime() {
    return libtremotesfJNI.ServerSettings_alternativeSpeedLimitsBeginTime(swigCPtr, this);
}

  public void setAlternativeSpeedLimitsBeginTime(int time) {
    libtremotesfJNI.ServerSettings_setAlternativeSpeedLimitsBeginTime(swigCPtr, this, time);
  }

  public int alternativeSpeedLimitsEndTime() {
    return libtremotesfJNI.ServerSettings_alternativeSpeedLimitsEndTime(swigCPtr, this);
}

  public void setAlternativeSpeedLimitsEndTime(int time) {
    libtremotesfJNI.ServerSettings_setAlternativeSpeedLimitsEndTime(swigCPtr, this, time);
  }

  public int alternativeSpeedLimitsDays() {
    return libtremotesfJNI.ServerSettings_alternativeSpeedLimitsDays(swigCPtr, this);
  }

  public void setAlternativeSpeedLimitsDays(int days) {
    libtremotesfJNI.ServerSettings_setAlternativeSpeedLimitsDays(swigCPtr, this, days);
  }

  public int peerPort() {
    return libtremotesfJNI.ServerSettings_peerPort(swigCPtr, this);
  }

  public void setPeerPort(int port) {
    libtremotesfJNI.ServerSettings_setPeerPort(swigCPtr, this, port);
  }

  public boolean isRandomPortEnabled() {
    return libtremotesfJNI.ServerSettings_isRandomPortEnabled(swigCPtr, this);
  }

  public void setRandomPortEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setRandomPortEnabled(swigCPtr, this, enabled);
  }

  public boolean isPortForwardingEnabled() {
    return libtremotesfJNI.ServerSettings_isPortForwardingEnabled(swigCPtr, this);
  }

  public void setPortForwardingEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setPortForwardingEnabled(swigCPtr, this, enabled);
  }

  public int encryptionMode() {
    return libtremotesfJNI.ServerSettings_encryptionMode(swigCPtr, this);
  }

  public void setEncryptionMode(int mode) {
    libtremotesfJNI.ServerSettings_setEncryptionMode(swigCPtr, this, mode);
  }

  public boolean isUtpEnabled() {
    return libtremotesfJNI.ServerSettings_isUtpEnabled(swigCPtr, this);
  }

  public void setUtpEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setUtpEnabled(swigCPtr, this, enabled);
  }

  public boolean isPexEnabled() {
    return libtremotesfJNI.ServerSettings_isPexEnabled(swigCPtr, this);
  }

  public void setPexEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setPexEnabled(swigCPtr, this, enabled);
  }

  public boolean isDhtEnabled() {
    return libtremotesfJNI.ServerSettings_isDhtEnabled(swigCPtr, this);
  }

  public void setDhtEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setDhtEnabled(swigCPtr, this, enabled);
  }

  public boolean isLpdEnabled() {
    return libtremotesfJNI.ServerSettings_isLpdEnabled(swigCPtr, this);
  }

  public void setLpdEnabled(boolean enabled) {
    libtremotesfJNI.ServerSettings_setLpdEnabled(swigCPtr, this, enabled);
  }

  public int maximumPeersPerTorrent() {
    return libtremotesfJNI.ServerSettings_maximumPeersPerTorrent(swigCPtr, this);
  }

  public void setMaximumPeersPerTorrent(int peers) {
    libtremotesfJNI.ServerSettings_setMaximumPeersPerTorrent(swigCPtr, this, peers);
  }

  public int maximumPeersGlobally() {
    return libtremotesfJNI.ServerSettings_maximumPeersGlobally(swigCPtr, this);
  }

  public void setMaximumPeersGlobally(int peers) {
    libtremotesfJNI.ServerSettings_setMaximumPeersGlobally(swigCPtr, this, peers);
  }

  public boolean saveOnSet() {
    return libtremotesfJNI.ServerSettings_saveOnSet(swigCPtr, this);
  }

  public void setSaveOnSet(boolean save) {
    libtremotesfJNI.ServerSettings_setSaveOnSet(swigCPtr, this, save);
  }

  public final static class AlternativeSpeedLimitsDays {
    public final static int Sunday = (1 << 0);
    public final static int Monday = (1 << 1);
    public final static int Tuesday = (1 << 2);
    public final static int Wednesday = (1 << 3);
    public final static int Thursday = (1 << 4);
    public final static int Friday = (1 << 5);
    public final static int Saturday = (1 << 6);
    public final static int Weekdays = (Monday|Tuesday|Wednesday|Thursday|Friday);
    public final static int Weekends = (Sunday|Saturday);
    public final static int All = (Weekdays|Weekends);
  }

  public final static class EncryptionMode {
    public final static int AllowedEncryption = 0;
    public final static int PreferredEncryption = AllowedEncryption + 1;
    public final static int RequiredEncryption = PreferredEncryption + 1;
  }

}
