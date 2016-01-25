package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserSessionHistory implements Serializable {
    /**
     * USER_SESSION_HISTORY.ID
     * null
     */
    private String id;

    /**
     * USER_SESSION_HISTORY.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * USER_SESSION_HISTORY.USER_SESSION_ID
     * null
     */
    private String userSessionId;

    /**
     * USER_SESSION_HISTORY.LOGON_TIME
     * null
     */
    private BigDecimal logonTime;

    /**
     * USER_SESSION_HISTORY.LOGOFF_TIME
     * null
     */
    private BigDecimal logoffTime;

    /**
     * USER_SESSION_HISTORY.USER_ID
     * null
     */
    private String userId;

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

    public String getUserSessionId() {
        return userSessionId;
    }

    public void setUserSessionId(String userSessionId) {
        this.userSessionId = userSessionId;
    }

    public BigDecimal getLogonTime() {
        return logonTime;
    }

    public void setLogonTime(BigDecimal logonTime) {
        this.logonTime = logonTime;
    }

    public BigDecimal getLogoffTime() {
        return logoffTime;
    }

    public void setLogoffTime(BigDecimal logoffTime) {
        this.logoffTime = logoffTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}