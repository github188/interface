package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpMonitorDevice implements Serializable {
    /**
     * EP_MONITOR_DEVICE.ID
     * null
     */
    private String id;

    /**
     * EP_MONITOR_DEVICE.NAME
     * null
     */
    private String name;

    /**
     * EP_MONITOR_DEVICE.TYPE
     * null
     */
    private BigDecimal type;

    /**
     * EP_MONITOR_DEVICE.NAMING
     * null
     */
    private String naming;

    /**
     * EP_MONITOR_DEVICE.ORGAN_ID
     * null
     */
    private String organId;

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

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }
}