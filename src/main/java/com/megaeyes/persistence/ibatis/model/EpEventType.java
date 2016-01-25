package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpEventType implements Serializable {
    /**
     * EP_EVENT_TYPE.ID
     * null
     */
    private String id;

    /**
     * EP_EVENT_TYPE.CODE
     * null
     */
    private BigDecimal code;

    /**
     * EP_EVENT_TYPE.NAME
     * null
     */
    private String name;

    /**
     * EP_EVENT_TYPE.STANDARD_TYPE
     * null
     */
    private String standardType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getCode() {
        return code;
    }

    public void setCode(BigDecimal code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandardType() {
        return standardType;
    }

    public void setStandardType(String standardType) {
        this.standardType = standardType;
    }
}