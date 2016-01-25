package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AlarmBox implements Serializable {
    /**
     * ALARM_BOX.ID
     * null
     */
    private String id;

    /**
     * ALARM_BOX.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * ALARM_BOX.F_NAME
     * null
     */
    private String name;

    /**
     * ALARM_BOX.NAMING
     * null
     */
    private String naming;

    /**
     * ALARM_BOX.INSTALL_LOCATION
     * null
     */
    private String installLocation;

    /**
     * ALARM_BOX.NOTE
     * null
     */
    private String note;

    /**
     * ALARM_BOX.VIDEO_INPUT_SERVER_ID
     * null
     */
    private String videoInputServerId;

    /**
     * ALARM_BOX.ADDRESS_NUMBER
     * null
     */
    private String addressNumber;

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

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getVideoInputServerId() {
        return videoInputServerId;
    }

    public void setVideoInputServerId(String videoInputServerId) {
        this.videoInputServerId = videoInputServerId;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
}