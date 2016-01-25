package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpOperationLog implements Serializable {
    /**
     * EP_OPERATION_LOG.ID
     * null
     */
    private String id;

    /**
     * EP_OPERATION_LOG.USER_ID
     * null
     */
    private String userId;

    /**
     * EP_OPERATION_LOG.USER_LOGIN_NAME
     * null
     */
    private String userLoginName;

    /**
     * EP_OPERATION_LOG.USER_SESSION_ID
     * null
     */
    private String userSessionId;

    /**
     * EP_OPERATION_LOG.OPERATE_TIME
     * null
     */
    private BigDecimal operateTime;

    /**
     * EP_OPERATION_LOG.OPERATE_DESCRIPTION
     * null
     */
    private String operateDescription;

    /**
     * EP_OPERATION_LOG.OPERATEOR_IP
     * null
     */
    private String operateorIp;

    /**
     * EP_OPERATION_LOG.INTERFACE_NAME
     * null
     */
    private String interfaceName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserSessionId() {
        return userSessionId;
    }

    public void setUserSessionId(String userSessionId) {
        this.userSessionId = userSessionId;
    }

    public BigDecimal getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(BigDecimal operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateDescription() {
        return operateDescription;
    }

    public void setOperateDescription(String operateDescription) {
        this.operateDescription = operateDescription;
    }

    public String getOperateorIp() {
        return operateorIp;
    }

    public void setOperateorIp(String operateorIp) {
        this.operateorIp = operateorIp;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
}