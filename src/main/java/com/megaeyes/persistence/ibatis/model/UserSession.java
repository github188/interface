package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserSession implements Serializable {
    /**
     * USER_SESSION.ID
     * null
     */
    private String id;

    /**
     * USER_SESSION.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * USER_SESSION.LOGON_TIME
     * null
     */
    private BigDecimal logonTime;

    /**
     * USER_SESSION.HEARTBEAT_TIME
     * null
     */
    private BigDecimal heartbeatTime;

    /**
     * USER_SESSION.USER_ID
     * null
     */
    private String userId;

    /**
     * USER_SESSION.IP
     * null
     */
    private String ip;

    /**
     * USER_SESSION.CLIENT_TYPE
     * null
     */
    private String clientType;

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

    public BigDecimal getLogonTime() {
        return logonTime;
    }

    public void setLogonTime(BigDecimal logonTime) {
        this.logonTime = logonTime;
    }

    public BigDecimal getHeartbeatTime() {
        return heartbeatTime;
    }

    public void setHeartbeatTime(BigDecimal heartbeatTime) {
        this.heartbeatTime = heartbeatTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
}