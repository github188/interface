package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpRole implements Serializable {
    /**
     * EP_ROLE.ID
     * null
     */
    private String id;

    /**
     * EP_ROLE.NAME
     * null
     */
    private String name;

    /**
     * EP_ROLE.NOTE
     * null
     */
    private String note;

    /**
     * EP_ROLE.ORGAN_ID
     * null
     */
    private String organId;

    /**
     * EP_ROLE.IS_SUSPENDED
     * null
     */
    private BigDecimal isSuspended;

    /**
     * EP_ROLE.CREATE_USER_NAME
     * null
     */
    private String createUserName;

    /**
     * EP_ROLE.TYPE
     * null
     */
    private BigDecimal type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public BigDecimal getIsSuspended() {
        return isSuspended;
    }

    public void setIsSuspended(BigDecimal isSuspended) {
        this.isSuspended = isSuspended;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }
}