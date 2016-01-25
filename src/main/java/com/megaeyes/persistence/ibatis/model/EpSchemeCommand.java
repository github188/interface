package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class EpSchemeCommand implements Serializable {
    /**
     * EP_SCHEME_COMMAND.ID
     * null
     */
    private String id;

    /**
     * EP_SCHEME_COMMAND.EP_SCHEME_ID
     * null
     */
    private String epSchemeId;

    /**
     * EP_SCHEME_COMMAND.TARGET_ID
     * null
     */
    private String targetId;

    /**
     * EP_SCHEME_COMMAND.TARGET_TYPE
     * null
     */
    private String targetType;

    /**
     * EP_SCHEME_COMMAND.VALUE
     * null
     */
    private String value;

    /**
     * EP_SCHEME_COMMAND.DURATION
     * null
     */
    private String duration;

    /**
     * EP_SCHEME_COMMAND.SEQ
     * null
     */
    private Integer seq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEpSchemeId() {
        return epSchemeId;
    }

    public void setEpSchemeId(String epSchemeId) {
        this.epSchemeId = epSchemeId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}