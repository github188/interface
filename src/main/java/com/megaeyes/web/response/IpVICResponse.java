/**   
 * @Title: IpVICResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-26 下午3:59:02 
 * @version V1.0   
 */
package com.megaeyes.web.response;

/**
 * @ClassName: IpVICResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-26 下午3:59:02
 * 
 */
public class IpVICResponse extends BaseResponse {
	private String id;
	private String name;
	private String installLocation;
	private String password;
	private boolean hasPan;
	private String host;
	private String port;
	private String storeType;
	private String storageServerId;
	private String dispatchServerId;
	private String note;
	private String storeCycle;
	private String remoteStorePlanHourFlag;
	private String localStoreCycle;
	private String storePlanHourFlag;
	private String message;
	private String organId;
	private String naming;
	private String subdivision_name;
	private String Ep_codeid;
	private boolean isCommunion;
	private String sipCode;
	private String longitude;
	private String latitude;
	private String alarmStorageServerId;

	public String getAlarmStorageServerId() {
		return alarmStorageServerId;
	}

	public void setAlarmStorageServerId(String alarmStorageServerId) {
		this.alarmStorageServerId = alarmStorageServerId;
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

	public boolean isHasPan() {
		return hasPan;
	}

	public void setHasPan(boolean hasPan) {
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

	public String getStorageServerId() {
		return storageServerId;
	}

	public void setStorageServerId(String storageServerId) {
		this.storageServerId = storageServerId;
	}

	public String getDispatchServerId() {
		return dispatchServerId;
	}

	public void setDispatchServerId(String dispatchServerId) {
		this.dispatchServerId = dispatchServerId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStoreCycle() {
		return storeCycle;
	}

	public void setStoreCycle(String storeCycle) {
		this.storeCycle = storeCycle;
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

	public String getStorePlanHourFlag() {
		return storePlanHourFlag;
	}

	public void setStorePlanHourFlag(String storePlanHourFlag) {
		this.storePlanHourFlag = storePlanHourFlag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}

	public String getSubdivision_name() {
		return subdivision_name;
	}

	public void setSubdivision_name(String subdivision_name) {
		this.subdivision_name = subdivision_name;
	}

	public String getEp_codeid() {
		return Ep_codeid;
	}

	public void setEp_codeid(String ep_codeid) {
		Ep_codeid = ep_codeid;
	}

	public boolean isCommunion() {
		return isCommunion;
	}

	public void setCommunion(boolean isCommunion) {
		this.isCommunion = isCommunion;
	}

	public String getSipCode() {
		return sipCode;
	}

	public void setSipCode(String sipCode) {
		this.sipCode = sipCode;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
