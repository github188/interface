package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class VideoOutputChannelModel implements Serializable {
    /**
     * VIDEO_OUTPUT_CHANNEL_MODEL.ID
     * null
     */
    private String id;

    /**
     * VIDEO_OUTPUT_CHANNEL_MODEL.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * VIDEO_OUTPUT_CHANNEL_MODEL.MANUFACTURER_ID
     * null
     */
    private String manufacturerId;

    /**
     * VIDEO_OUTPUT_CHANNEL_MODEL.F_NAME
     * null
     */
    private String name;

    /**
     * VIDEO_OUTPUT_CHANNEL_MODEL.NOTE
     * null
     */
    private String note;

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

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
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
}