package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class VideoInputChannelModel implements Serializable {
    /**
     * VIDEO_INPUT_CHANNEL_MODEL.ID
     * null
     */
    private String id;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.OPTIMISTIC_LOCK
     * null
     */
    private BigDecimal optimisticLock;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.MANUFACTURER_ID
     * null
     */
    private String manufacturerId;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.F_NAME
     * null
     */
    private String name;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_PTZ
     * null
     */
    private Short hasPtz;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_PTZ_APERTURE
     * null
     */
    private Short hasPtzAperture;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_PTZ_FOCI
     * null
     */
    private Short hasPtzFoci;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_PTZ_ZOOM
     * null
     */
    private Short hasPtzZoom;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_PTZ_ASW_1
     * null
     */
    private Short hasPtzAsw1;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_PTZ_ASW_2
     * null
     */
    private Short hasPtzAsw2;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_PTZ_ASW_3
     * null
     */
    private Short hasPtzAsw3;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_PTZ_ASW_4
     * null
     */
    private Short hasPtzAsw4;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_PTZ_AUTO
     * null
     */
    private Short hasPtzAuto;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_SENSE
     * null
     */
    private Short hasSense;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_SHELTER
     * null
     */
    private Short hasShelter;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_TIME_LABEL
     * null
     */
    private Short hasTimeLabel;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.HAS_TEXT_LABEL
     * null
     */
    private Short hasTextLabel;

    /**
     * VIDEO_INPUT_CHANNEL_MODEL.NOTE
     * null
     */
    private String note;

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

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getHasPtz() {
        return hasPtz;
    }

    public void setHasPtz(Short hasPtz) {
        this.hasPtz = hasPtz;
    }

    public Short getHasPtzAperture() {
        return hasPtzAperture;
    }

    public void setHasPtzAperture(Short hasPtzAperture) {
        this.hasPtzAperture = hasPtzAperture;
    }

    public Short getHasPtzFoci() {
        return hasPtzFoci;
    }

    public void setHasPtzFoci(Short hasPtzFoci) {
        this.hasPtzFoci = hasPtzFoci;
    }

    public Short getHasPtzZoom() {
        return hasPtzZoom;
    }

    public void setHasPtzZoom(Short hasPtzZoom) {
        this.hasPtzZoom = hasPtzZoom;
    }

    public Short getHasPtzAsw1() {
        return hasPtzAsw1;
    }

    public void setHasPtzAsw1(Short hasPtzAsw1) {
        this.hasPtzAsw1 = hasPtzAsw1;
    }

    public Short getHasPtzAsw2() {
        return hasPtzAsw2;
    }

    public void setHasPtzAsw2(Short hasPtzAsw2) {
        this.hasPtzAsw2 = hasPtzAsw2;
    }

    public Short getHasPtzAsw3() {
        return hasPtzAsw3;
    }

    public void setHasPtzAsw3(Short hasPtzAsw3) {
        this.hasPtzAsw3 = hasPtzAsw3;
    }

    public Short getHasPtzAsw4() {
        return hasPtzAsw4;
    }

    public void setHasPtzAsw4(Short hasPtzAsw4) {
        this.hasPtzAsw4 = hasPtzAsw4;
    }

    public Short getHasPtzAuto() {
        return hasPtzAuto;
    }

    public void setHasPtzAuto(Short hasPtzAuto) {
        this.hasPtzAuto = hasPtzAuto;
    }

    public Short getHasSense() {
        return hasSense;
    }

    public void setHasSense(Short hasSense) {
        this.hasSense = hasSense;
    }

    public Short getHasShelter() {
        return hasShelter;
    }

    public void setHasShelter(Short hasShelter) {
        this.hasShelter = hasShelter;
    }

    public Short getHasTimeLabel() {
        return hasTimeLabel;
    }

    public void setHasTimeLabel(Short hasTimeLabel) {
        this.hasTimeLabel = hasTimeLabel;
    }

    public Short getHasTextLabel() {
        return hasTextLabel;
    }

    public void setHasTextLabel(Short hasTextLabel) {
        this.hasTextLabel = hasTextLabel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}