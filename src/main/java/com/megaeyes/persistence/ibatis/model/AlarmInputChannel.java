package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AlarmInputChannel implements Serializable {
    /**
     * ALARM_INPUT_CHANNEL.ID
     * null
     */
    private String id;

    /**
     * ALARM_INPUT_CHANNEL.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * ALARM_INPUT_CHANNEL.F_NAME
     * null
     */
    private String name;

    /**
     * ALARM_INPUT_CHANNEL.NAMING
     * null
     */
    private String naming;

    /**
     * ALARM_INPUT_CHANNEL.INSTALL_LOCATION
     * null
     */
    private String installLocation;

    /**
     * ALARM_INPUT_CHANNEL.NOTE
     * null
     */
    private String note;

    /**
     * ALARM_INPUT_CHANNEL.ALARM_BOX_ID
     * null
     */
    private String alarmBoxId;

    /**
     * ALARM_INPUT_CHANNEL.ADDRESS_NUMBER_ON_ALARM_BOX
     * null
     */
    private String addressNumberOnAlarmBox;

    /**
     * ALARM_INPUT_CHANNEL.ALARM_INPUT_CHANNEL_TYPE_ID
     * null
     */
    private String alarmInputChannelTypeId;

    /**
     * ALARM_INPUT_CHANNEL.ORGAN_ID
     * null
     */
    private String organId;

    /**
     * ALARM_INPUT_CHANNEL.DEVICE_PHYSICAL_RELATION_ID
     * null
     */
    private String devicePhysicalRelationId;

    /**
     * ALARM_INPUT_CHANNEL.IS_SUPPORT_SCHEME
     * null
     */
    private Short isSupportScheme;

    /**
     * ALARM_INPUT_CHANNEL.IS_SHARE
     * null
     */
    private Integer isShare;

    /**
     * ALARM_INPUT_CHANNEL.CHANNEL_ID
     * null
     */
    private Short channelId;

    /**
     * ALARM_INPUT_CHANNEL.ALARM_STORAGE_SERVER_ID
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

    public String getAlarmBoxId() {
        return alarmBoxId;
    }

    public void setAlarmBoxId(String alarmBoxId) {
        this.alarmBoxId = alarmBoxId;
    }

    public String getAddressNumberOnAlarmBox() {
        return addressNumberOnAlarmBox;
    }

    public void setAddressNumberOnAlarmBox(String addressNumberOnAlarmBox) {
        this.addressNumberOnAlarmBox = addressNumberOnAlarmBox;
    }

    public String getAlarmInputChannelTypeId() {
        return alarmInputChannelTypeId;
    }

    public void setAlarmInputChannelTypeId(String alarmInputChannelTypeId) {
        this.alarmInputChannelTypeId = alarmInputChannelTypeId;
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

    public Short getIsSupportScheme() {
        return isSupportScheme;
    }

    public void setIsSupportScheme(Short isSupportScheme) {
        this.isSupportScheme = isSupportScheme;
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

    public String getAlarmStorageServerId() {
        return alarmStorageServerId;
    }

    public void setAlarmStorageServerId(String alarmStorageServerId) {
        this.alarmStorageServerId = alarmStorageServerId;
    }
}