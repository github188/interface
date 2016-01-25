package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpIntelligentDetection implements Serializable {
    /**
     * EP_INTELLIGENT_DETECTION.DEVICE_ID
     * null
     */
    private String deviceId;

    /**
     * EP_INTELLIGENT_DETECTION.TYPE
     * null
     */
    private BigDecimal type;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }
}