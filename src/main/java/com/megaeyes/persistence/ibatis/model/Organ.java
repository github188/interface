package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Organ implements Serializable {
    /**
     * ORGAN.ID
     * null
     */
    private String id;

    /**
     * ORGAN.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * ORGAN.F_NAME
     * null
     */
    private String name;

    /**
     * ORGAN.PARENT_ORGAN_ID
     * null
     */
    private String parentOrganId;

    /**
     * ORGAN.PATH
     * null
     */
    private String path;

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

    public String getParentOrganId() {
        return parentOrganId;
    }

    public void setParentOrganId(String parentOrganId) {
        this.parentOrganId = parentOrganId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}