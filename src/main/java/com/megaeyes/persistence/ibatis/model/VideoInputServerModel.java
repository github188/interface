package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class VideoInputServerModel implements Serializable {
    /**
     * VIDEO_INPUT_SERVER_MODEL.ID
     * null
     */
    private String id;

    /**
     * VIDEO_INPUT_SERVER_MODEL.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * VIDEO_INPUT_SERVER_MODEL.F_NAME
     * null
     */
    private String name;

    /**
     * VIDEO_INPUT_SERVER_MODEL.F_TYPE
     * null
     */
    private String fType;

    /**
     * VIDEO_INPUT_SERVER_MODEL.ENCODE
     * null
     */
    private String encode;

    /**
     * VIDEO_INPUT_SERVER_MODEL.NOTE
     * null
     */
    private String note;

    /**
     * VIDEO_INPUT_SERVER_MODEL.MANUFACTURER_ID
     * null
     */
    private String manufacturerId;

    /**
     * VIDEO_INPUT_SERVER_MODEL.DECODE
     * null
     */
    private String decode;

    /**
     * VIDEO_INPUT_SERVER_MODEL.RTP_PAYLOAD
     * null
     */
    private String rtpPayload;

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

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getDecode() {
        return decode;
    }

    public void setDecode(String decode) {
        this.decode = decode;
    }

    public String getRtpPayload() {
        return rtpPayload;
    }

    public void setRtpPayload(String rtpPayload) {
        this.rtpPayload = rtpPayload;
    }
}