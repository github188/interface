package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class GeneralCameraVic implements Serializable {
    /**
     * GENERAL_CAMERA_VIC.VIDEO_INPUT_CHANNEL_ID
     * null
     */
    private String videoInputChannelId;

    /**
     * GENERAL_CAMERA_VIC.ADDRESS_NUMBER
     * null
     */
    private String addressNumber;

    public String getVideoInputChannelId() {
        return videoInputChannelId;
    }

    public void setVideoInputChannelId(String videoInputChannelId) {
        this.videoInputChannelId = videoInputChannelId;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
}