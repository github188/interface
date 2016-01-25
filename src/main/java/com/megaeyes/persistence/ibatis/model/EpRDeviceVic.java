package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpRDeviceVic implements Serializable {
    /**
     * EP_R_DEVICE_VIC.DEVICE_ID
     * null
     */
    private String deviceId;

    /**
     * EP_R_DEVICE_VIC.VIC_ID
     * null
     */
    private String vicId;

    /**
     * EP_R_DEVICE_VIC.PRESET_ID
     * null
     */
    private String presetId;

    /**
     * EP_R_DEVICE_VIC.TASK_TYPE
     * null
     */
    private BigDecimal taskType;

    /**
     * EP_R_DEVICE_VIC.STEP_ID
     * null
     */
    private String stepId;

    /**
     * EP_R_DEVICE_VIC.IS_DEFAULT
     * null
     */
    private Short isDefault;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getVicId() {
        return vicId;
    }

    public void setVicId(String vicId) {
        this.vicId = vicId;
    }

    public String getPresetId() {
        return presetId;
    }

    public void setPresetId(String presetId) {
        this.presetId = presetId;
    }

    public BigDecimal getTaskType() {
        return taskType;
    }

    public void setTaskType(BigDecimal taskType) {
        this.taskType = taskType;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public Short getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Short isDefault) {
        this.isDefault = isDefault;
    }
}