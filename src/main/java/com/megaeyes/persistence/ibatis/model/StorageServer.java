package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class StorageServer implements Serializable {
    /**
     * STORAGE_SERVER.ID
     * null
     */
    private String id;

    /**
     * STORAGE_SERVER.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * STORAGE_SERVER.F_NAME
     * null
     */
    private String name;

    /**
     * STORAGE_SERVER.NAMING
     * null
     */
    private String naming;

    /**
     * STORAGE_SERVER.INSTALL_LOCATION
     * null
     */
    private String installLocation;

    /**
     * STORAGE_SERVER.NOTE
     * null
     */
    private String note;

    /**
     * STORAGE_SERVER.DEVICE_NUMBER
     * null
     */
    private String deviceNumber;

    /**
     * STORAGE_SERVER.IP
     * null
     */
    private String ip;

    /**
     * STORAGE_SERVER.LINK_TYPE
     * null
     */
    private String linkType;

    /**
     * STORAGE_SERVER.HEART_CYCLE
     * null
     */
    private Long heartCycle;

    /**
     * STORAGE_SERVER.MAX_OUTPUT_AMOUNT
     * null
     */
    private Long maxOutputAmount;

    /**
     * STORAGE_SERVER.MAX_INPUT_AMOUNT
     * null
     */
    private Long maxInputAmount;

    /**
     * STORAGE_SERVER.FTP_PORT
     * null
     */
    private Long ftpPort;

    /**
     * STORAGE_SERVER.FTP_USER_NAME
     * null
     */
    private String ftpUserName;

    /**
     * STORAGE_SERVER.FTP_PASSWORD
     * null
     */
    private String ftpPassword;

    /**
     * STORAGE_SERVER.IP2
     * null
     */
    private String ip2;

    /**
     * STORAGE_SERVER.MESSAGE_PORT
     * null
     */
    private Long messagePort;

    /**
     * STORAGE_SERVER.STD_ID
     * null
     */
    private String stdId;

    /**
     * STORAGE_SERVER.IS_VIRTUAL_IP
     * null
     */
    private BigDecimal isVirtualIp;

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

    public Long getMaxOutputAmount() {
        return maxOutputAmount;
    }

    public void setMaxOutputAmount(Long maxOutputAmount) {
        this.maxOutputAmount = maxOutputAmount;
    }

    public Long getMaxInputAmount() {
        return maxInputAmount;
    }

    public void setMaxInputAmount(Long maxInputAmount) {
        this.maxInputAmount = maxInputAmount;
    }

    public Long getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(Long ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUserName() {
        return ftpUserName;
    }

    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public String getIp2() {
        return ip2;
    }

    public void setIp2(String ip2) {
        this.ip2 = ip2;
    }

    public Long getMessagePort() {
        return messagePort;
    }

    public void setMessagePort(Long messagePort) {
        this.messagePort = messagePort;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public BigDecimal getIsVirtualIp() {
        return isVirtualIp;
    }

    public void setIsVirtualIp(BigDecimal isVirtualIp) {
        this.isVirtualIp = isVirtualIp;
    }
}