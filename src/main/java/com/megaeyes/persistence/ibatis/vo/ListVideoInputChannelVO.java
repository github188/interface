/**   
 * @Title: ListVideoInputChannelVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-22 下午3:14:46 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/**
 * @ClassName: ListVideoInputChannelVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-22 下午3:14:46
 * 
 */
public class ListVideoInputChannelVO {
	private String id;

	private BigDecimal optimisticLock;

	private String name;

	private String naming;

	private String installLocation;

	private String note;

	private Short hasPan;

	private String ptzDecodeType;

	private String videoFormat;

	private Long storeCycle;

	private String storePlanHourFlag;

	private Long frameRate;

	private Long maxBps;

	private Long brightness;

	private Long hue;

	private Long contrast;

	private Long saturation;

	private String videoInputChannelModelId;

	private String videoInputServerId;

	private String imageQualityLevelId;

	private String dispatchServerId;

	private String remoteStorageServerId;

	private String organId;

	private String devicePhysicalRelationId;

	private Short isSuspended;

	private String stdId;

	private Short isSupportScheme;

	private Short preRecordTime;

	private String remoteStorePlanHourFlag;

	private Short storeType;

	private String path;

	private String longitude;

	private String latitude;

	private BigDecimal pullMode;

	private Integer isShare;

	private Short channelId;

	private BigDecimal overWriteFlag;

	private Integer localStoreCycle;

	private Short schemeType;

	private Short localSchemeType;

	private Short streamType;

	private String alarmStorageServerId;
	
	private String sipCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getOptimisticLock() {
		return optimisticLock;
	}

	public void setOptimisticLock(BigDecimal optimisticLock) {
		this.optimisticLock = optimisticLock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}

	public String getInstallLocation() {
		return installLocation;
	}

	public void setInstallLocation(String installLocation) {
		this.installLocation = installLocation;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Short getHasPan() {
		return hasPan;
	}

	public void setHasPan(Short hasPan) {
		this.hasPan = hasPan;
	}

	public String getPtzDecodeType() {
		return ptzDecodeType;
	}

	public void setPtzDecodeType(String ptzDecodeType) {
		this.ptzDecodeType = ptzDecodeType;
	}

	public String getVideoFormat() {
		return videoFormat;
	}

	public void setVideoFormat(String videoFormat) {
		this.videoFormat = videoFormat;
	}

	public Long getStoreCycle() {
		return storeCycle;
	}

	public void setStoreCycle(Long storeCycle) {
		this.storeCycle = storeCycle;
	}

	public String getStorePlanHourFlag() {
		return storePlanHourFlag;
	}

	public void setStorePlanHourFlag(String storePlanHourFlag) {
		this.storePlanHourFlag = storePlanHourFlag;
	}

	public Long getFrameRate() {
		return frameRate;
	}

	public void setFrameRate(Long frameRate) {
		this.frameRate = frameRate;
	}

	public Long getMaxBps() {
		return maxBps;
	}

	public void setMaxBps(Long maxBps) {
		this.maxBps = maxBps;
	}

	public Long getBrightness() {
		return brightness;
	}

	public void setBrightness(Long brightness) {
		this.brightness = brightness;
	}

	public Long getHue() {
		return hue;
	}

	public void setHue(Long hue) {
		this.hue = hue;
	}

	public Long getContrast() {
		return contrast;
	}

	public void setContrast(Long contrast) {
		this.contrast = contrast;
	}

	public Long getSaturation() {
		return saturation;
	}

	public void setSaturation(Long saturation) {
		this.saturation = saturation;
	}

	public String getVideoInputChannelModelId() {
		return videoInputChannelModelId;
	}

	public void setVideoInputChannelModelId(String videoInputChannelModelId) {
		this.videoInputChannelModelId = videoInputChannelModelId;
	}

	public String getVideoInputServerId() {
		return videoInputServerId;
	}

	public void setVideoInputServerId(String videoInputServerId) {
		this.videoInputServerId = videoInputServerId;
	}

	public String getImageQualityLevelId() {
		return imageQualityLevelId;
	}

	public void setImageQualityLevelId(String imageQualityLevelId) {
		this.imageQualityLevelId = imageQualityLevelId;
	}

	public String getDispatchServerId() {
		return dispatchServerId;
	}

	public void setDispatchServerId(String dispatchServerId) {
		this.dispatchServerId = dispatchServerId;
	}

	public String getRemoteStorageServerId() {
		return remoteStorageServerId;
	}

	public void setRemoteStorageServerId(String remoteStorageServerId) {
		this.remoteStorageServerId = remoteStorageServerId;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getDevicePhysicalRelationId() {
		return devicePhysicalRelationId;
	}

	public void setDevicePhysicalRelationId(String devicePhysicalRelationId) {
		this.devicePhysicalRelationId = devicePhysicalRelationId;
	}

	public Short getIsSuspended() {
		return isSuspended;
	}

	public void setIsSuspended(Short isSuspended) {
		this.isSuspended = isSuspended;
	}

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	public Short getIsSupportScheme() {
		return isSupportScheme;
	}

	public void setIsSupportScheme(Short isSupportScheme) {
		this.isSupportScheme = isSupportScheme;
	}

	public Short getPreRecordTime() {
		return preRecordTime;
	}

	public void setPreRecordTime(Short preRecordTime) {
		this.preRecordTime = preRecordTime;
	}

	public String getRemoteStorePlanHourFlag() {
		return remoteStorePlanHourFlag;
	}

	public void setRemoteStorePlanHourFlag(String remoteStorePlanHourFlag) {
		this.remoteStorePlanHourFlag = remoteStorePlanHourFlag;
	}

	public Short getStoreType() {
		return storeType;
	}

	public void setStoreType(Short storeType) {
		this.storeType = storeType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	public BigDecimal getPullMode() {
		return pullMode;
	}

	public void setPullMode(BigDecimal pullMode) {
		this.pullMode = pullMode;
	}

	public Integer getIsShare() {
		return isShare;
	}

	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}

	public Short getChannelId() {
		return channelId;
	}

	public void setChannelId(Short channelId) {
		this.channelId = channelId;
	}

	public BigDecimal getOverWriteFlag() {
		return overWriteFlag;
	}

	public void setOverWriteFlag(BigDecimal overWriteFlag) {
		this.overWriteFlag = overWriteFlag;
	}

	public Integer getLocalStoreCycle() {
		return localStoreCycle;
	}

	public void setLocalStoreCycle(Integer localStoreCycle) {
		this.localStoreCycle = localStoreCycle;
	}

	public Short getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(Short schemeType) {
		this.schemeType = schemeType;
	}

	public Short getLocalSchemeType() {
		return localSchemeType;
	}

	public void setLocalSchemeType(Short localSchemeType) {
		this.localSchemeType = localSchemeType;
	}

	public Short getStreamType() {
		return streamType;
	}

	public void setStreamType(Short streamType) {
		this.streamType = streamType;
	}

	public String getAlarmStorageServerId() {
		return alarmStorageServerId;
	}

	public void setAlarmStorageServerId(String alarmStorageServerId) {
		this.alarmStorageServerId = alarmStorageServerId;
	}

	public String getSipCode() {
		return sipCode;
	}

	public void setSipCode(String sipCode) {
		this.sipCode = sipCode;
	}



}
