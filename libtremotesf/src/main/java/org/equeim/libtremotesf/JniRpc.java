/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.1.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.equeim.libtremotesf;

public class JniRpc {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected JniRpc(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(JniRpc obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtremotesfJNI.delete_JniRpc(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    libtremotesfJNI.JniRpc_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    libtremotesfJNI.JniRpc_change_ownership(this, swigCPtr, true);
  }

  public JniRpc() {
    this(libtremotesfJNI.new_JniRpc(), true);
    libtremotesfJNI.JniRpc_director_connect(this, swigCPtr, true, true);
  }

  public void init() {
    libtremotesfJNI.JniRpc_init(swigCPtr, this);
  }

  public void setServer(Server server) {
    libtremotesfJNI.JniRpc_setServer(swigCPtr, this, Server.getCPtr(server), server);
  }

  public void resetServer() {
    libtremotesfJNI.JniRpc_resetServer(swigCPtr, this);
  }

  public void connect() {
    libtremotesfJNI.JniRpc_connect(swigCPtr, this);
  }

  public void disconnect() {
    libtremotesfJNI.JniRpc_disconnect(swigCPtr, this);
  }

  public void setUpdateDisabled(boolean disabled) {
    libtremotesfJNI.JniRpc_setUpdateDisabled(swigCPtr, this, disabled);
  }

  public void addTorrentFile(int fd, String downloadDirectory, int[] unwantedFiles, int[] highPriorityFiles, int[] lowPriorityFiles, StringMap renamedFiles, int bandwidthPriority, boolean start) {
    libtremotesfJNI.JniRpc_addTorrentFile(swigCPtr, this, fd, downloadDirectory, unwantedFiles, highPriorityFiles, lowPriorityFiles, StringMap.getCPtr(renamedFiles), renamedFiles, bandwidthPriority, start);
  }

  public void addTorrentLink(String link, String downloadDirectory, int bandwidthPriority, boolean start) {
    libtremotesfJNI.JniRpc_addTorrentLink(swigCPtr, this, link, downloadDirectory, bandwidthPriority, start);
  }

  public void startTorrents(int[] ids) {
    libtremotesfJNI.JniRpc_startTorrents(swigCPtr, this, ids);
  }

  public void pauseTorrents(int[] ids) {
    libtremotesfJNI.JniRpc_pauseTorrents(swigCPtr, this, ids);
  }

  public void removeTorrents(int[] ids, boolean deleteFiles) {
    libtremotesfJNI.JniRpc_removeTorrents(swigCPtr, this, ids, deleteFiles);
  }

  public void checkTorrents(int[] ids) {
    libtremotesfJNI.JniRpc_checkTorrents(swigCPtr, this, ids);
  }

  public void reannounceTorrents(int[] ids) {
    libtremotesfJNI.JniRpc_reannounceTorrents(swigCPtr, this, ids);
  }

  public void setTorrentsLocation(int[] ids, String location, boolean moveFiles) {
    libtremotesfJNI.JniRpc_setTorrentsLocation(swigCPtr, this, ids, location, moveFiles);
  }

  public void renameTorrentFile(int torrentId, String filePath, String newName) {
    libtremotesfJNI.JniRpc_renameTorrentFile(swigCPtr, this, torrentId, filePath, newName);
  }

  public void getDownloadDirFreeSpace() {
    libtremotesfJNI.JniRpc_getDownloadDirFreeSpace(swigCPtr, this);
  }

  public void getFreeSpaceForPath(String path) {
    libtremotesfJNI.JniRpc_getFreeSpaceForPath(swigCPtr, this, path);
  }

  public void setTorrentDownloadSpeedLimited(TorrentData data, boolean limited) {
    libtremotesfJNI.JniRpc_setTorrentDownloadSpeedLimited(swigCPtr, this, TorrentData.getCPtr(data), data, limited);
  }

  public void setTorrentDownloadSpeedLimit(TorrentData data, int limit) {
    libtremotesfJNI.JniRpc_setTorrentDownloadSpeedLimit(swigCPtr, this, TorrentData.getCPtr(data), data, limit);
  }

  public void setTorrentUploadSpeedLimited(TorrentData data, boolean limited) {
    libtremotesfJNI.JniRpc_setTorrentUploadSpeedLimited(swigCPtr, this, TorrentData.getCPtr(data), data, limited);
  }

  public void setTorrentUploadSpeedLimit(TorrentData data, int limit) {
    libtremotesfJNI.JniRpc_setTorrentUploadSpeedLimit(swigCPtr, this, TorrentData.getCPtr(data), data, limit);
  }

  public void setTorrentRatioLimitMode(TorrentData data, int mode) {
    libtremotesfJNI.JniRpc_setTorrentRatioLimitMode(swigCPtr, this, TorrentData.getCPtr(data), data, mode);
  }

  public void setTorrentRatioLimit(TorrentData data, double limit) {
    libtremotesfJNI.JniRpc_setTorrentRatioLimit(swigCPtr, this, TorrentData.getCPtr(data), data, limit);
  }

  public void setTorrentPeersLimit(TorrentData data, int limit) {
    libtremotesfJNI.JniRpc_setTorrentPeersLimit(swigCPtr, this, TorrentData.getCPtr(data), data, limit);
  }

  public void setTorrentHonorSessionLimits(TorrentData data, boolean honor) {
    libtremotesfJNI.JniRpc_setTorrentHonorSessionLimits(swigCPtr, this, TorrentData.getCPtr(data), data, honor);
  }

  public void setTorrentBandwidthPriority(TorrentData data, int priority) {
    libtremotesfJNI.JniRpc_setTorrentBandwidthPriority(swigCPtr, this, TorrentData.getCPtr(data), data, priority);
  }

  public void setTorrentIdleSeedingLimitMode(TorrentData data, int mode) {
    libtremotesfJNI.JniRpc_setTorrentIdleSeedingLimitMode(swigCPtr, this, TorrentData.getCPtr(data), data, mode);
  }

  public void setTorrentIdleSeedingLimit(TorrentData data, int limit) {
    libtremotesfJNI.JniRpc_setTorrentIdleSeedingLimit(swigCPtr, this, TorrentData.getCPtr(data), data, limit);
  }

  public void setTorrentFilesEnabled(TorrentData data, boolean enabled) {
    libtremotesfJNI.JniRpc_setTorrentFilesEnabled(swigCPtr, this, TorrentData.getCPtr(data), data, enabled);
  }

  public void setTorrentFilesWanted(TorrentData data, int[] files, boolean wanted) {
    libtremotesfJNI.JniRpc_setTorrentFilesWanted(swigCPtr, this, TorrentData.getCPtr(data), data, files, wanted);
  }

  public void setTorrentFilesPriority(TorrentData data, int[] files, int priority) {
    libtremotesfJNI.JniRpc_setTorrentFilesPriority(swigCPtr, this, TorrentData.getCPtr(data), data, files, priority);
  }

  public void torrentAddTrackers(TorrentData data, StringsVector announceUrls) {
    libtremotesfJNI.JniRpc_torrentAddTrackers(swigCPtr, this, TorrentData.getCPtr(data), data, StringsVector.getCPtr(announceUrls), announceUrls);
  }

  public void torrentSetTracker(TorrentData data, int trackerId, String announce) {
    libtremotesfJNI.JniRpc_torrentSetTracker(swigCPtr, this, TorrentData.getCPtr(data), data, trackerId, announce);
  }

  public void torrentRemoveTrackers(TorrentData data, int[] ids) {
    libtremotesfJNI.JniRpc_torrentRemoveTrackers(swigCPtr, this, TorrentData.getCPtr(data), data, ids);
  }

  public void setTorrentPeersEnabled(TorrentData data, boolean enabled) {
    libtremotesfJNI.JniRpc_setTorrentPeersEnabled(swigCPtr, this, TorrentData.getCPtr(data), data, enabled);
  }

  public void updateData() {
    libtremotesfJNI.JniRpc_updateData(swigCPtr, this);
  }

  protected void onAboutToDisconnect() {
    libtremotesfJNI.JniRpc_onAboutToDisconnect(swigCPtr, this);
  }

  protected void onStatusChanged(int status) {
    libtremotesfJNI.JniRpc_onStatusChanged(swigCPtr, this, status);
  }

  protected void onErrorChanged(int error, String errorMessage) {
    libtremotesfJNI.JniRpc_onErrorChanged(swigCPtr, this, error, errorMessage);
  }

  protected void onServerSettingsChanged(JniServerSettingsData data) {
    libtremotesfJNI.JniRpc_onServerSettingsChanged(swigCPtr, this, JniServerSettingsData.getCPtr(data), data);
  }

  protected void onTorrentsUpdated(IntVector removed, TorrentDataVector changed, TorrentDataVector added) {
    libtremotesfJNI.JniRpc_onTorrentsUpdated(swigCPtr, this, IntVector.getCPtr(removed), removed, TorrentDataVector.getCPtr(changed), changed, TorrentDataVector.getCPtr(added), added);
  }

  protected void onTorrentFilesUpdated(int torrentId, TorrentFilesVector changed) {
    libtremotesfJNI.JniRpc_onTorrentFilesUpdated(swigCPtr, this, torrentId, TorrentFilesVector.getCPtr(changed), changed);
  }

  protected void onTorrentPeersUpdated(int torrentId, IntVector removed, TorrentPeersVector changed, TorrentPeersVector added) {
    libtremotesfJNI.JniRpc_onTorrentPeersUpdated(swigCPtr, this, torrentId, IntVector.getCPtr(removed), removed, TorrentPeersVector.getCPtr(changed), changed, TorrentPeersVector.getCPtr(added), added);
  }

  protected void onServerStatsUpdated(long downloadSpeed, long uploadSpeed, SessionStats currentSession, SessionStats total) {
    libtremotesfJNI.JniRpc_onServerStatsUpdated(swigCPtr, this, downloadSpeed, uploadSpeed, SessionStats.getCPtr(currentSession), currentSession, SessionStats.getCPtr(total), total);
  }

  protected void onTorrentAdded(int id, String hashString, String name) {
    libtremotesfJNI.JniRpc_onTorrentAdded(swigCPtr, this, id, hashString, name);
  }

  protected void onTorrentFinished(int id, String hashString, String name) {
    libtremotesfJNI.JniRpc_onTorrentFinished(swigCPtr, this, id, hashString, name);
  }

  protected void onTorrentAddDuplicate() {
    libtremotesfJNI.JniRpc_onTorrentAddDuplicate(swigCPtr, this);
  }

  protected void onTorrentAddError() {
    libtremotesfJNI.JniRpc_onTorrentAddError(swigCPtr, this);
  }

  protected void onTorrentFileRenamed(int torrentId, String filePath, String newName) {
    libtremotesfJNI.JniRpc_onTorrentFileRenamed(swigCPtr, this, torrentId, filePath, newName);
  }

  protected void onGotDownloadDirFreeSpace(long bytes) {
    libtremotesfJNI.JniRpc_onGotDownloadDirFreeSpace(swigCPtr, this, bytes);
  }

  protected void onGotFreeSpaceForPath(String path, boolean success, long bytes) {
    libtremotesfJNI.JniRpc_onGotFreeSpaceForPath(swigCPtr, this, path, success, bytes);
  }

}