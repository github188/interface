package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AlarmInputChannelType implements Serializable {
    /**
     * ALARM_INPUT_CHANNEL_TYPE.ID
     * null
     */
    private String id;

    /**
     * ALARM_INPUT_CHANNEL_TYPE.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * ALARM_INPUT_CHANNEL_TYPE.F_NAME
     * null
     */
    private String name;

    /**
     * ALARM_INPUT_CHANNEL_TYPE.IS_CONTROLLABLE_BY_USER
     * null
     */
    private Short isControllableByUser;

    /**
     * ALARM_INPUT_CHANNEL_TYPE.DESCRIBE
     * null
     */
    private String describe;

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

    public Short getIsControllableByUser() {
        return isControllableByUser;
    }

    public void setIsControllableByUser(Short isControllableByUser) {
        this.isControllableByUser = isControllableByUser;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}