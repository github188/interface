/**   
 * @Title: GeneralVICResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-26 上午10:33:46 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import com.megaeyes.service.impl.BaseManagerImpl;

/**
 * @ClassName: GeneralVICResponse
 * @Description: TODO( 普通摄像头)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-26 上午10:33:46
 * 
 */
public class GeneralVICResponse extends BaseResponse{
	private String id;
	private String name;
	private String installLocation;
	private boolean hasPan;
	private String channelId;
	private String storeType;
	private String storageServerId;
	private String dispatchServerId;
	private boolean isSuspended;
	private String note;
	private String storePlanHourFlag;
	private String remoteStorePlanHourFlag;
	private String organId;
	private String naming;
	private String subdivision_name;
	private String Ep_codeid;
	private boolean isCommunion;
	private String overWirteFlag;
	private String sipCode;
	private String longitude;
	private String latitude;
	private String assId;

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

	public boolean isHasPan() {
		return hasPan;
	}

	public void setHasPan(boolean hasPan) {
		this.hasPan = hasPan;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
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

	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStorePlanHourFlag() {
		return storePlanHourFlag;
	}

	public void setStorePlanHourFlag(String storePlanHourFlag) {
		this.storePlanHourFlag = storePlanHourFlag;
	}

	public String getRemoteStorePlanHourFlag() {
		return remoteStorePlanHourFlag;
	}

	public void setRemoteStorePlanHourFlag(String remoteStorePlanHourFlag) {
		this.remoteStorePlanHourFlag = remoteStorePlanHourFlag;
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

	public String getOverWirteFlag() {
		return overWirteFlag;
	}

	public void setOverWirteFlag(String overWirteFlag) {
		this.overWirteFlag = overWirteFlag;
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

	public String getAssId() {
		return assId;
	}

	public void setAssId(String assId) {
		this.assId = assId;
	}
}
