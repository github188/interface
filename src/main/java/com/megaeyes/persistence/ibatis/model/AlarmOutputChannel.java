package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AlarmOutputChannel implements Serializable {
    /**
     * alarm_output_channel.ID
     * 
     */
    private String id;

    /**
     * alarm_output_channel.OPTIMISTIC_LOCK
     * 
     */
    private BigDecimal optimisticLock;

    /**
     * alarm_output_channel.F_NAME
     * 
     */
    private String name;

    /**
     * alarm_output_channel.NAMING
     * 
     */
    private String naming;

    /**
     * alarm_output_channel.INSTALL_LOCATION
     * 
     */
    private String installLocation;

    /**
     * alarm_output_channel.NOTE
     * 
     */
    private String note;

    /**
     * alarm_output_channel.ALARM_BOX_ID
     * 
     */
    private String alarmBoxId;

    /**
     * alarm_output_channel.ADDRESS_NUMBER_ON_ALARM_BOX
     * 
     */
    private String addressNumberOnAlarmBox;

    /**
     * alarm_output_channel.ALARM_OUTPUT_CHANNEL_TYPE_ID
     * 
     */
    private String alarmOutputChannelTypeId;

    /**
     * alarm_output_channel.ORGAN_ID
     * 
     */
    private String organId;

    /**
     * alarm_output_channel.DEVICE_PHYSICAL_RELATION_ID
     * 
     */
    private String devicePhysicalRelationId;

    /**
     * alarm_output_channel.IS_SUPPORT_SCHEME
     * 
     */
    private Short isSupportScheme;

    /**
     * alarm_output_channel.IS_SHARE
     * 
     */
    private Integer isShare;

    /**
     * alarm_output_channel.CHANNEL_ID
     * 
     */
    private Short channelId;

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

    public String getAlarmOutputChannelTypeId() {
        return alarmOutputChannelTypeId;
    }

    public void setAlarmOutputChannelTypeId(String alarmOutputChannelTypeId) {
        this.alarmOutputChannelTypeId = alarmOutputChannelTypeId;
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
}