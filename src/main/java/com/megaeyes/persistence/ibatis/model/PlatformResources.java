package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class PlatformResources implements Serializable {
    /**
     * PLATFORM_RESOURCES.ID
     * null
     */
    private String id;

    /**
     * PLATFORM_RESOURCES.RESOURCE_ID
     * null
     */
    private String resourceId;

    /**
     * PLATFORM_RESOURCES.NAME
     * null
     */
    private String name;

    /**
     * PLATFORM_RESOURCES.NAMING
     * null
     */
    private String naming;

    /**
     * PLATFORM_RESOURCES.SIP_CODE
     * null
     */
    private String sipCode;

    /**
     * PLATFORM_RESOURCES.ORGAN_ID
     * null
     */
    private String organId;

    /**
     * PLATFORM_RESOURCES.IS_SHARE
     * null
     */
    private Short isShare;

    /**
     * PLATFORM_RESOURCES.STATUS
     * null
     */
    private Short status;

    /**
     * PLATFORM_RESOURCES.LONGITUDE
     * null
     */
    private String longitude;

    /**
     * PLATFORM_RESOURCES.LATITUDE
     * null
     */
    private String latitude;

    /**
     * PLATFORM_RESOURCES.TYPE
     * null
     */
    private String type;

    /**
     * PLATFORM_RESOURCES.STANDARD_TYPE
     * null
     */
    private String standardType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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

    public String getSipCode() {
        return sipCode;
    }

    public void setSipCode(String sipCode) {
        this.sipCode = sipCode;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public Short getIsShare() {
        return isShare;
    }

    public void setIsShare(Short isShare) {
        this.isShare = isShare;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStandardType() {
        return standardType;
    }

    public void setStandardType(String standardType) {
        this.standardType = standardType;
    }
}