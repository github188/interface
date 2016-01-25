package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpRTaskstepMonitor implements Serializable {
    /**
     * EP_R_TASKSTEP_MONITOR.ID
     * null
     */
    private String id;

    /**
     * EP_R_TASKSTEP_MONITOR.STEP_ID
     * null
     */
    private String stepId;

    /**
     * EP_R_TASKSTEP_MONITOR.MONITOR_ID
     * null
     */
    private String monitorId;

    /**
     * EP_R_TASKSTEP_MONITOR.MONITOR_TYPE
     * null
     */
    private BigDecimal monitorType;

    /**
     * EP_R_TASKSTEP_MONITOR.TASK_ID
     * null
     */
    private String taskId;

    /**
     * EP_R_TASKSTEP_MONITOR.PRESET_ID
     * null
     */
    private String presetId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(String monitorId) {
        this.monitorId = monitorId;
    }

    public BigDecimal getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(BigDecimal monitorType) {
        this.monitorType = monitorType;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPresetId() {
        return presetId;
    }

    public void setPresetId(String presetId) {
        this.presetId = presetId;
    }
}