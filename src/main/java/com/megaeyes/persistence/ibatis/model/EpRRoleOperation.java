package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class EpRRoleOperation implements Serializable {
    /**
     * EP_R_ROLE_OPERATION.ID
     * null
     */
    private String id;

    /**
     * EP_R_ROLE_OPERATION.ROLE_ID
     * null
     */
    private String roleId;

    /**
     * EP_R_ROLE_OPERATION.OPERATION_ID
     * null
     */
    private String operationId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
}