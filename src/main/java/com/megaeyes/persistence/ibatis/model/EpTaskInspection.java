package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpTaskInspection implements Serializable {
    /**
     * EP_TASK_INSPECTION.ITEM
     * null
     */
    private String item;

    /**
     * EP_TASK_INSPECTION.STANDARD
     * null
     */
    private String standard;

    /**
     * EP_TASK_INSPECTION.TYPE
     * null
     */
    private String type;

    /**
     * EP_TASK_INSPECTION.SEQ
     * null
     */
    private BigDecimal seq;

    /**
     * EP_TASK_INSPECTION.ID
     * null
     */
    private String id;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getSeq() {
        return seq;
    }

    public void setSeq(BigDecimal seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}