package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class VideoInputChannel implements Serializable {
    /**
     * VIDEO_INPUT_CHANNEL.ID
     * null
     */
    private String id;

    /**
     * VIDEO_INPUT_CHANNEL.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * VIDEO_INPUT_CHANNEL.F_NAME
     * null
     */
    private String name;

    /**
     * VIDEO_INPUT_CHANNEL.NAMING
     * null
     */
    private String naming;

    /**
     * VIDEO_INPUT_CHANNEL.INSTALL_LOCATION
     * null
     */
    private String installLocation;

    /**
     * VIDEO_INPUT_CHANNEL.NOTE
     * null
     */
    private String note;

    /**
     * VIDEO_INPUT_CHANNEL.HAS_PAN
     * null
     */
    private Short hasPan;

    /**
     * VIDEO_INPUT_CHANNEL.PTZ_DECODE_TYPE
     * null
     */
    private String ptzDecodeType;

    /**
     * VIDEO_INPUT_CHANNEL.VIDEO_FORMAT
     * null
     */
    private String videoFormat;

    /**
     * VIDEO_INPUT_CHANNEL.STORE_CYCLE
     * null
     */
    private Long storeCycle;

    /**
     * VIDEO_INPUT_CHANNEL.STORE_PLAN_HOUR_FLAG
     * null
     */
    private String storePlanHourFlag;

    /**
     * VIDEO_INPUT_CHANNEL.FRAME_RATE
     * null
     */
    private Long frameRate;

    /**
     * VIDEO_INPUT_CHANNEL.MAX_BPS
     * null
     */
    private Long maxBps;

    /**
     * VIDEO_INPUT_CHANNEL.BRIGHTNESS
     * null
     */
    private Long brightness;

    /**
     * VIDEO_INPUT_CHANNEL.HUE
     * null
     */
    private Long hue;

    /**
     * VIDEO_INPUT_CHANNEL.CONTRAST
     * null
     */
    private Long contrast;

    /**
     * VIDEO_INPUT_CHANNEL.SATURATION
     * null
     */
    private Long saturation;

    /**
     * VIDEO_INPUT_CHANNEL.VIDEO_INPUT_CHANNEL_MODEL_ID
     * null
     */
    private String videoInputChannelModelId;

    /**
     * VIDEO_INPUT_CHANNEL.VIDEO_INPUT_SERVER_ID
     * null
     */
    private String videoInputServerId;

    /**
     * VIDEO_INPUT_CHANNEL.IMAGE_QUALITY_LEVEL_ID
     * null
     */
    private String imageQualityLevelId;

    /**
     * VIDEO_INPUT_CHANNEL.DISPATCH_SERVER_ID
     * null
     */
    private String dispatchServerId;

    /**
     * VIDEO_INPUT_CHANNEL.REMOTE_STORAGE_SERVER_ID
     * null
     */
    private String remoteStorageServerId;

    /**
     * VIDEO_INPUT_CHANNEL.ORGAN_ID
     * null
     */
    private String organId;

    /**
     * VIDEO_INPUT_CHANNEL.DEVICE_PHYSICAL_RELATION_ID
     * null
     */
    private String devicePhysicalRelationId;

    /**
     * VIDEO_INPUT_CHANNEL.IS_SUSPENDED
     * null
     */
    private Short isSuspended;

    /**
     * VIDEO_INPUT_CHANNEL.STD_ID
     * null
     */
    private String stdId;

    /**
     * VIDEO_INPUT_CHANNEL.IS_SUPPORT_SCHEME
     * null
     */
    private Short isSupportScheme;

    /**
     * VIDEO_INPUT_CHANNEL.PRE_RECORD_TIME
     * null
     */
    private Short preRecordTime;

    /**
     * VIDEO_INPUT_CHANNEL.REMOTE_STORE_PLAN_HOUR_FLAG
     * null
     */
    private String remoteStorePlanHourFlag;

    /**
     * VIDEO_INPUT_CHANNEL.STORE_TYPE
     * null
     */
    private Short storeType;

    /**
     * VIDEO_INPUT_CHANNEL.PATH
     * null
     */
    private String path;

    /**
     * VIDEO_INPUT_CHANNEL.LONGITUDE
     * null
     */
    private String longitude;

    /**
     * VIDEO_INPUT_CHANNEL.LATITUDE
     * null
     */
    private String latitude;

    /**
     * VIDEO_INPUT_CHANNEL.PULL_MODE
     * null
     */
    private BigDecimal pullMode;

    /**
     * VIDEO_INPUT_CHANNEL.IS_SHARE
     * null
     */
    private Integer isShare;

    /**
     * VIDEO_INPUT_CHANNEL.CHANNEL_ID
     * null
     */
    private Short channelId;

    /**
     * VIDEO_INPUT_CHANNEL.OVER_WRITE_FLAG
     * null
     */
    private BigDecimal overWriteFlag;

    /**
     * VIDEO_INPUT_CHANNEL.LOCAL_STORE_CYCLE
     * null
     */
    private Integer localStoreCycle;

    /**
     * VIDEO_INPUT_CHANNEL.SCHEME_TYPE
     * null
     */
    private Short schemeType;

    /**
     * VIDEO_INPUT_CHANNEL.LOCAL_SCHEME_TYPE
     * null
     */
    private Short localSchemeType;

    /**
     * VIDEO_INPUT_CHANNEL.STREAM_TYPE
     * null
     */
    private Short streamType;

    /**
     * VIDEO_INPUT_CHANNEL.ALARM_STORAGE_SERVER_ID
     * null
     */
    private String alarmStorageServerId;

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
}