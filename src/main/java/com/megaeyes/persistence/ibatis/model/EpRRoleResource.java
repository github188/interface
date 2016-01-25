package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class EpRRoleResource implements Serializable {
    /**
     * EP_R_ROLE_RESOURCE.ID
     * null
     */
    private String id;

    /**
     * EP_R_ROLE_RESOURCE.ROLE_ID
     * null
     */
    private String roleId;

    /**
     * EP_R_ROLE_RESOURCE.RESOURCE_ID
     * null
     */
    private String resourceId;

    /**
     * EP_R_ROLE_RESOURCE.RESOURCE_TYPE
     * null
     */
    private String resourceType;

    /**
     * EP_R_ROLE_RESOURCE.RESOURCE_ORGAN_ID
     * null
     */
    private String resourceOrganId;

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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceOrganId() {
        return resourceOrganId;
    }

    public void setResourceOrganId(String resourceOrganId) {
        this.resourceOrganId = resourceOrganId;
    }
}