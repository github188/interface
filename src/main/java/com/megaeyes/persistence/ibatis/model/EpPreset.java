package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EpPreset implements Serializable {
    /**
     * EP_PRESET.ID
     * null
     */
    private String id;

    /**
     * EP_PRESET.NAME
     * null
     */
    private String name;

    /**
     * EP_PRESET.PRESET_NUMBER
     * null
     */
    private Short presetNumber;

    /**
     * EP_PRESET.VIC_ID
     * null
     */
    private String vicId;

    /**
     * EP_PRESET.NOTE
     * null
     */
    private String note;

    /**
     * EP_PRESET.TYPE
     * null
     */
    private Long type;

    /**
     * EP_PRESET.SET_FLAG
     * null
     */
    private BigDecimal setFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getPresetNumber() {
        return presetNumber;
    }

    public void setPresetNumber(Short presetNumber) {
        this.presetNumber = presetNumber;
    }

    public String getVicId() {
        return vicId;
    }

    public void setVicId(String vicId) {
        this.vicId = vicId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public BigDecimal getSetFlag() {
        return setFlag;
    }

    public void setSetFlag(BigDecimal setFlag) {
        this.setFlag = setFlag;
    }
}