/**
 * 
 */
package com.megaeyes.persistence.ibatis.vo;

/**
 * IP摄像头业务模型(合并VIDEO_INPUT_CHANNEL与IP_CAMERA_VIC两张表的数据)
 * 
 * @author HBJ
 * 
 */
public class IpVICVO {
	private String id;
	private String name;
	private String installLocation;
	private String password;
	private String hasPan;
	private String host;
	private String port;
	private String storeType;
	private String remoteStorageServerId;
	private String dispatchServerId;
	private String storeCycle;
	private String storePlanHourFlag;
	private String remoteStorePlanHourFlag;
	private String localStoreCycle;
	private String note;
	private String isSuspended;
	private String organId;
	private String naming;
	private String longitude;
	private String sipCode;
	private String latitude;
	private String isShare;
	private String alarmStorageServerId;

	public String getIsShare() {
		return isShare;
	}

	public String getAlarmStorageServerId() {
		return alarmStorageServerId;
	}

	public void setAlarmStorageServerId(String alarmStorageServerId) {
		this.alarmStorageServerId = alarmStorageServerId;
	}

	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getSipCode() {
		return sipCode;
	}

	public void setSipCode(String sipCode) {
		this.sipCode = sipCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstallLocation() {
		return installLocation;
	}

	public void setInstallLocation(String installLocation) {
		this.installLocation = installLocation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHasPan() {
		return hasPan;
	}

	public void setHasPan(String hasPan) {
		this.hasPan = hasPan;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getRemoteStorageServerId() {
		return remoteStorageServerId;
	}

	public void setRemoteStorageServerId(String remoteStorageServerId) {
		this.remoteStorageServerId = remoteStorageServerId;
	}

	public String getDispatchServerId() {
		return dispatchServerId;
	}

	public void setDispatchServerId(String dispatchServerId) {
		this.dispatchServerId = dispatchServerId;
	}

	public String getStoreCycle() {
		return storeCycle;
	}

	public void setStoreCycle(String storeCycle) {
		this.storeCycle = storeCycle;
	}

	public String getStorePlanHourFlag() {
		return storePlanHourFlag;
	}

	public void setStorePlanHourFlag(String storePlanHourFlag) {
		this.storePlanHourFlag = storePlanHourFlag;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIsSuspended() {
		return isSuspended;
	}

	public void setIsSuspended(String isSuspended) {
		this.isSuspended = isSuspended;
	}

	public String getRemoteStorePlanHourFlag() {
		return remoteStorePlanHourFlag;
	}

	public void setRemoteStorePlanHourFlag(String remoteStorePlanHourFlag) {
		this.remoteStorePlanHourFlag = remoteStorePlanHourFlag;
	}

	public String getLocalStoreCycle() {
		return localStoreCycle;
	}

	public void setLocalStoreCycle(String localStoreCycle) {
		this.localStoreCycle = localStoreCycle;
	}
}
