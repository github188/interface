package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class EpRMapDevice implements Serializable {
    /**
     * EP_R_MAP_DEVICE.ID
     * null
     */
    private String id;

    /**
     * EP_R_MAP_DEVICE.EP_MAP_ID
     * null
     */
    private String epMapId;

    /**
     * EP_R_MAP_DEVICE.DEVICE_ID
     * null
     */
    private String deviceId;

    /**
     * EP_R_MAP_DEVICE.DEVICE_TYPE
     * null
     */
    private Short deviceType;

    /**
     * EP_R_MAP_DEVICE.COORDINATE_X
     * null
     */
    private String coordinateX;

    /**
     * EP_R_MAP_DEVICE.COORDINATE_Y
     * null
     */
    private String coordinateY;

    /**
     * EP_R_MAP_DEVICE.LEFT
     * null
     */
    private String left;

    /**
     * EP_R_MAP_DEVICE.RIGHT
     * null
     */
    private String right;

    /**
     * EP_R_MAP_DEVICE.TOP
     * null
     */
    private String top;

    /**
     * EP_R_MAP_DEVICE.BOTTOM
     * null
     */
    private String bottom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEpMapId() {
        return epMapId;
    }

    public void setEpMapId(String epMapId) {
        this.epMapId = epMapId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Short getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Short deviceType) {
        this.deviceType = deviceType;
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX;
    }

    public String getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(String coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }
}