package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpIntelligentChannel implements Serializable {
    /**
     * EP_INTELLIGENT_CHANNEL.ID
     * null
     */
    private String id;

    /**
     * EP_INTELLIGENT_CHANNEL.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * EP_INTELLIGENT_CHANNEL.F_NAME
     * null
     */
    private String name;

    /**
     * EP_INTELLIGENT_CHANNEL.NAMING
     * null
     */
    private String naming;

    /**
     * EP_INTELLIGENT_CHANNEL.INSTALL_LOCATION
     * null
     */
    private String installLocation;

    /**
     * EP_INTELLIGENT_CHANNEL.PARENT_ID
     * null
     */
    private String parentId;

    /**
     * EP_INTELLIGENT_CHANNEL.PARENT_TYPE
     * null
     */
    private Short parentType;

    /**
     * EP_INTELLIGENT_CHANNEL.DESCRIPTION
     * null
     */
    private String description;

    /**
     * EP_INTELLIGENT_CHANNEL.NOTE
     * null
     */
    private String note;

    /**
     * EP_INTELLIGENT_CHANNEL.COMPANY
     * null
     */
    private String company;

    /**
     * EP_INTELLIGENT_CHANNEL.CHANNEL_ID
     * null
     */
    private Short channelId;

    /**
     * EP_INTELLIGENT_CHANNEL.ORGAN_ID
     * null
     */
    private String organId;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Short getParentType() {
        return parentType;
    }

    public void setParentType(Short parentType) {
        this.parentType = parentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Short getChannelId() {
        return channelId;
    }

    public void setChannelId(Short channelId) {
        this.channelId = channelId;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }
}