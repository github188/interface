package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class EpRUserRole implements Serializable {
    /**
     * EP_R_USER_ROLE.ID
     * null
     */
    private String id;

    /**
     * EP_R_USER_ROLE.USER_ID
     * null
     */
    private String userId;

    /**
     * EP_R_USER_ROLE.ROLE_ID
     * null
     */
    private String roleId;

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}