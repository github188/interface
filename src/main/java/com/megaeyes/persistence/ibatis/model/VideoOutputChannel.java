package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class VideoOutputChannel implements Serializable {
    /**
     * VIDEO_OUTPUT_CHANNEL.ID
     * null
     */
    private String id;

    /**
     * VIDEO_OUTPUT_CHANNEL.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * VIDEO_OUTPUT_CHANNEL.F_NAME
     * null
     */
    private String name;

    /**
     * VIDEO_OUTPUT_CHANNEL.NAMING
     * null
     */
    private String naming;

    /**
     * VIDEO_OUTPUT_CHANNEL.INSTALL_LOCATION
     * null
     */
    private String installLocation;

    /**
     * VIDEO_OUTPUT_CHANNEL.NOTE
     * null
     */
    private String note;

    /**
     * VIDEO_OUTPUT_CHANNEL.VIDEO_DISPLAY_DEVICE_ID
     * null
     */
    private String videoDisplayDeviceId;

    /**
     * VIDEO_OUTPUT_CHANNEL.ADDRESS_NUMBER
     * null
     */
    private String addressNumber;

    /**
     * VIDEO_OUTPUT_CHANNEL.VIDEO_OUTPUT_CHANNEL_MODEL_ID
     * null
     */
    private String videoOutputChannelModelId;

    /**
     * VIDEO_OUTPUT_CHANNEL.ORGAN_ID
     * null
     */
    private String organId;

    /**
     * VIDEO_OUTPUT_CHANNEL.DEVICE_PHYSICAL_RELATION_ID
     * null
     */
    private String devicePhysicalRelationId;

    /**
     * VIDEO_OUTPUT_CHANNEL.STD_ID
     * null
     */
    private String stdId;

    /**
     * VIDEO_OUTPUT_CHANNEL.IS_SHARE
     * null
     */
    private Integer isShare;

    /**
     * VIDEO_OUTPUT_CHANNEL.DISPATCH_SERVER_ID
     * null
     */
    private String dispatchServerId;

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

    public String getVideoDisplayDeviceId() {
        return videoDisplayDeviceId;
    }

    public void setVideoDisplayDeviceId(String videoDisplayDeviceId) {
        this.videoDisplayDeviceId = videoDisplayDeviceId;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getVideoOutputChannelModelId() {
        return videoOutputChannelModelId;
    }

    public void setVideoOutputChannelModelId(String videoOutputChannelModelId) {
        this.videoOutputChannelModelId = videoOutputChannelModelId;
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

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public Integer getIsShare() {
        return isShare;
    }

    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    public String getDispatchServerId() {
        return dispatchServerId;
    }

    public void setDispatchServerId(String dispatchServerId) {
        this.dispatchServerId = dispatchServerId;
    }
}