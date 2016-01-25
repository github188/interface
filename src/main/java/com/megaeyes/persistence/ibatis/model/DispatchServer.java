package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DispatchServer implements Serializable {
    /**
     * DISPATCH_SERVER.ID
     * null
     */
    private String id;

    /**
     * DISPATCH_SERVER.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * DISPATCH_SERVER.F_NAME
     * null
     */
    private String name;

    /**
     * DISPATCH_SERVER.NAMING
     * null
     */
    private String naming;

    /**
     * DISPATCH_SERVER.INSTALL_LOCATION
     * null
     */
    private String installLocation;

    /**
     * DISPATCH_SERVER.NOTE
     * null
     */
    private String note;

    /**
     * DISPATCH_SERVER.DEVICE_NUMBER
     * null
     */
    private String deviceNumber;

    /**
     * DISPATCH_SERVER.IP
     * null
     */
    private String ip;

    /**
     * DISPATCH_SERVER.IP2
     * null
     */
    private String ip2;

    /**
     * DISPATCH_SERVER.VIDEOPORT
     * null
     */
    private Long videoport;

    /**
     * DISPATCH_SERVER.MSGPORT
     * null
     */
    private Long msgport;

    /**
     * DISPATCH_SERVER.LINK_TYPE
     * null
     */
    private String linkType;

    /**
     * DISPATCH_SERVER.HEART_CYCLE
     * null
     */
    private Long heartCycle;

    /**
     * DISPATCH_SERVER.MAX_OUTPUT_AMOUNT
     * null
     */
    private Long maxOutputAmount;

    /**
     * DISPATCH_SERVER.MAX_INPUT_AMOUNT
     * null
     */
    private Long maxInputAmount;

    /**
     * DISPATCH_SERVER.RESERVED_OUTPUT_AMOUNT
     * null
     */
    private Long reservedOutputAmount;

    /**
     * DISPATCH_SERVER.O_ORGAN_ID
     * null
     */
    private String oOrganId;

    /**
     * DISPATCH_SERVER.WEIGHT
     * null
     */
    private String weight;

    /**
     * DISPATCH_SERVER.STD_ID
     * null
     */
    private String stdId;

    /**
     * DISPATCH_SERVER.OWNER_SHIP
     * null
     */
    private String ownerShip;

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

    public String getIp2() {
        return ip2;
    }

    public void setIp2(String ip2) {
        this.ip2 = ip2;
    }

    public Long getVideoport() {
        return videoport;
    }

    public void setVideoport(Long videoport) {
        this.videoport = videoport;
    }

    public Long getMsgport() {
        return msgport;
    }

    public void setMsgport(Long msgport) {
        this.msgport = msgport;
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

    public Long getReservedOutputAmount() {
        return reservedOutputAmount;
    }

    public void setReservedOutputAmount(Long reservedOutputAmount) {
        this.reservedOutputAmount = reservedOutputAmount;
    }

    public String getoOrganId() {
        return oOrganId;
    }

    public void setoOrganId(String oOrganId) {
        this.oOrganId = oOrganId;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(String ownerShip) {
        this.ownerShip = ownerShip;
    }
}