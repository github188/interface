package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Platform implements Serializable {
    /**
     * PLATFORM.ID
     * null
     */
    private String id;

    /**
     * PLATFORM.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * PLATFORM.F_NAME
     * null
     */
    private String name;

    /**
     * PLATFORM.CMS_ID
     * null
     */
    private String cmsId;

    /**
     * PLATFORM.LOCATION
     * null
     */
    private String location;

    /**
     * PLATFORM.VERIFY
     * null
     */
    private String verify;

    /**
     * PLATFORM.NOTE
     * null
     */
    private String note;

    /**
     * PLATFORM.PASSWORD
     * null
     */
    private String password;

    /**
     * PLATFORM.USER_NOTIFY_SERVER_IP
     * null
     */
    private String userNotifyServerIp;

    /**
     * PLATFORM.USER_NOTIFY_SERVER_PORT
     * null
     */
    private BigDecimal userNotifyServerPort;

    /**
     * PLATFORM.USER_NOTIFY_SERVER_URL
     * null
     */
    private String userNotifyServerUrl;

    /**
     * PLATFORM.USER_NOTIFY_SERVER_LOGINNAME
     * null
     */
    private String userNotifyServerLoginname;

    /**
     * PLATFORM.USER_NOTIFY_SERVER_PASSWORD
     * null
     */
    private String userNotifyServerPassword;

    /**
     * PLATFORM.SMS_NOTIFY_TYPE
     * null
     */
    private Short smsNotifyType;

    /**
     * PLATFORM.SP_CODE
     * null
     */
    private String spCode;

    /**
     * PLATFORM.CDR_SERVER_IP
     * null
     */
    private String cdrServerIp;

    /**
     * PLATFORM.CDR_SERVER_PORT
     * null
     */
    private BigDecimal cdrServerPort;

    /**
     * PLATFORM.HTTPS_FLAG
     * null
     */
    private BigDecimal httpsFlag;

    /**
     * PLATFORM.IS_CONN_AUTH_CENTER
     * null
     */
    private Short isConnAuthCenter;

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

    public String getCmsId() {
        return cmsId;
    }

    public void setCmsId(String cmsId) {
        this.cmsId = cmsId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNotifyServerIp() {
        return userNotifyServerIp;
    }

    public void setUserNotifyServerIp(String userNotifyServerIp) {
        this.userNotifyServerIp = userNotifyServerIp;
    }

    public BigDecimal getUserNotifyServerPort() {
        return userNotifyServerPort;
    }

    public void setUserNotifyServerPort(BigDecimal userNotifyServerPort) {
        this.userNotifyServerPort = userNotifyServerPort;
    }

    public String getUserNotifyServerUrl() {
        return userNotifyServerUrl;
    }

    public void setUserNotifyServerUrl(String userNotifyServerUrl) {
        this.userNotifyServerUrl = userNotifyServerUrl;
    }

    public String getUserNotifyServerLoginname() {
        return userNotifyServerLoginname;
    }

    public void setUserNotifyServerLoginname(String userNotifyServerLoginname) {
        this.userNotifyServerLoginname = userNotifyServerLoginname;
    }

    public String getUserNotifyServerPassword() {
        return userNotifyServerPassword;
    }

    public void setUserNotifyServerPassword(String userNotifyServerPassword) {
        this.userNotifyServerPassword = userNotifyServerPassword;
    }

    public Short getSmsNotifyType() {
        return smsNotifyType;
    }

    public void setSmsNotifyType(Short smsNotifyType) {
        this.smsNotifyType = smsNotifyType;
    }

    public String getSpCode() {
        return spCode;
    }

    public void setSpCode(String spCode) {
        this.spCode = spCode;
    }

    public String getCdrServerIp() {
        return cdrServerIp;
    }

    public void setCdrServerIp(String cdrServerIp) {
        this.cdrServerIp = cdrServerIp;
    }

    public BigDecimal getCdrServerPort() {
        return cdrServerPort;
    }

    public void setCdrServerPort(BigDecimal cdrServerPort) {
        this.cdrServerPort = cdrServerPort;
    }

    public BigDecimal getHttpsFlag() {
        return httpsFlag;
    }

    public void setHttpsFlag(BigDecimal httpsFlag) {
        this.httpsFlag = httpsFlag;
    }

    public Short getIsConnAuthCenter() {
        return isConnAuthCenter;
    }

    public void setIsConnAuthCenter(Short isConnAuthCenter) {
        this.isConnAuthCenter = isConnAuthCenter;
    }
}