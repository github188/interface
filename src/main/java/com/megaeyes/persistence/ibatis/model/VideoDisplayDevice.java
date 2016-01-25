package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class VideoDisplayDevice implements Serializable {
    /**
     * VIDEO_DISPLAY_DEVICE.ID
     * null
     */
    private String id;

    /**
     * VIDEO_DISPLAY_DEVICE.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * VIDEO_DISPLAY_DEVICE.F_NAME
     * null
     */
    private String name;

    /**
     * VIDEO_DISPLAY_DEVICE.NAMING
     * null
     */
    private String naming;

    /**
     * VIDEO_DISPLAY_DEVICE.INSTALL_LOCATION
     * null
     */
    private String installLocation;

    /**
     * VIDEO_DISPLAY_DEVICE.NOTE
     * null
     */
    private String note;

    /**
     * VIDEO_DISPLAY_DEVICE.DEVICE_NUMBER
     * null
     */
    private String deviceNumber;

    /**
     * VIDEO_DISPLAY_DEVICE.IP
     * null
     */
    private String ip;

    /**
     * VIDEO_DISPLAY_DEVICE.LINK_TYPE
     * null
     */
    private String linkType;

    /**
     * VIDEO_DISPLAY_DEVICE.HEART_CYCLE
     * null
     */
    private Long heartCycle;

    /**
     * VIDEO_DISPLAY_DEVICE.REBOOT_TIME
     * null
     */
    private String rebootTime;

    /**
     * VIDEO_DISPLAY_DEVICE.REBOOT_CYCLE
     * null
     */
    private Long rebootCycle;

    /**
     * VIDEO_DISPLAY_DEVICE.VIDEO_INTPUT_AMOUNT
     * null
     */
    private Long videoIntputAmount;

    /**
     * VIDEO_DISPLAY_DEVICE.VIDEO_OUTPUT_AMOUNT
     * null
     */
    private Long videoOutputAmount;

    /**
     * VIDEO_DISPLAY_DEVICE.COMPANY_ID
     * null
     */
    private String companyId;

    /**
     * VIDEO_DISPLAY_DEVICE.O_ORGAN_ID
     * null
     */
    private String oOrganId;

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

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public Long getHeartCycle() {
        return heartCycle;
    }

    public void setHeartCycle(Long heartCycle) {
        this.heartCycle = heartCycle;
    }

    public String getRebootTime() {
        return rebootTime;
    }

    public void setRebootTime(String rebootTime) {
        this.rebootTime = rebootTime;
    }

    public Long getRebootCycle() {
        return rebootCycle;
    }

    public void setRebootCycle(Long rebootCycle) {
        this.rebootCycle = rebootCycle;
    }

    public Long getVideoIntputAmount() {
        return videoIntputAmount;
    }

    public void setVideoIntputAmount(Long videoIntputAmount) {
        this.videoIntputAmount = videoIntputAmount;
    }

    public Long getVideoOutputAmount() {
        return videoOutputAmount;
    }

    public void setVideoOutputAmount(Long videoOutputAmount) {
        this.videoOutputAmount = videoOutputAmount;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getoOrganId() {
        return oOrganId;
    }

    public void setoOrganId(String oOrganId) {
        this.oOrganId = oOrganId;
    }
}