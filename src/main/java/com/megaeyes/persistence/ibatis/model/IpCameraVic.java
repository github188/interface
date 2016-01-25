package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class IpCameraVic implements Serializable {
    /**
     * IP_CAMERA_VIC.VIDEO_INPUT_CHANNEL_ID
     * null
     */
    private String videoInputChannelId;

    /**
     * IP_CAMERA_VIC.HOST
     * null
     */
    private String host;

    /**
     * IP_CAMERA_VIC.PORT
     * null
     */
    private Long port;

    /**
     * IP_CAMERA_VIC.PASSWORD
     * null
     */
    private String password;

    /**
     * IP_CAMERA_VIC.MOBILEPHONE1
     * null
     */
    private String mobilephone1;

    /**
     * IP_CAMERA_VIC.MOBILEPHONE2
     * null
     */
    private String mobilephone2;

    /**
     * IP_CAMERA_VIC.EMAIL
     * null
     */
    private String email;

    /**
     * IP_CAMERA_VIC.DEVICE_TYPE
     * null
     */
    private String deviceType;

    /**
     * IP_CAMERA_VIC.SD_SUPPORT
     * null
     */
    private Short sdSupport;

    public String getVideoInputChannelId() {
        return videoInputChannelId;
    }

    public void setVideoInputChannelId(String videoInputChannelId) {
        this.videoInputChannelId = videoInputChannelId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilephone1() {
        return mobilephone1;
    }

    public void setMobilephone1(String mobilephone1) {
        this.mobilephone1 = mobilephone1;
    }

    public String getMobilephone2() {
        return mobilephone2;
    }

    public void setMobilephone2(String mobilephone2) {
        this.mobilephone2 = mobilephone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Short getSdSupport() {
        return sdSupport;
    }

    public void setSdSupport(Short sdSupport) {
        this.sdSupport = sdSupport;
    }
}