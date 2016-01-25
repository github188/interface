package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpRMonitorDevice implements Serializable {
    /**
     * EP_R_MONITOR_DEVICE.ID
     * null
     */
    private String id;

    /**
     * EP_R_MONITOR_DEVICE.MONITOR_ID
     * null
     */
    private String monitorId;

    /**
     * EP_R_MONITOR_DEVICE.DEVICE_ID
     * null
     */
    private String deviceId;

    /**
     * EP_R_MONITOR_DEVICE.MONITOR_TYPE
     * null
     */
    private BigDecimal monitorType;

    /**
     * EP_R_MONITOR_DEVICE.DEVICE_TYPE
     * null
     */
    private BigDecimal deviceType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(String monitorId) {
        this.monitorId = monitorId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public BigDecimal getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(BigDecimal monitorType) {
        this.monitorType = monitorType;
    }

    public BigDecimal getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(BigDecimal deviceType) {
        this.deviceType = deviceType;
    }
}