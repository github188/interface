package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Company implements Serializable {
    /**
     * COMPANY.ORGAN_ID
     * null
     */
    private String organId;

    /**
     * COMPANY.NOTE
     * null
     */
    private String note;

    /**
     * COMPANY.LINKMAN
     * null
     */
    private String linkman;

    /**
     * COMPANY.EMAIL
     * null
     */
    private String email;

    /**
     * COMPANY.PHONE
     * null
     */
    private String phone;

    /**
     * COMPANY.FAX
     * null
     */
    private String fax;

    /**
     * COMPANY.ADDRESS
     * null
     */
    private String address;

    /**
     * COMPANY.POSTALCODE
     * null
     */
    private String postalcode;

    /**
     * COMPANY.IS_SUSPENDED
     * null
     */
    private Short isSuspended;

    /**
     * COMPANY.F_NUMBER
     * null
     */
    private String fNumber;

    /**
     * COMPANY.O_ORGAN_ID
     * null
     */
    private String oOrganId;

    /**
     * COMPANY.CREATETIME
     * null
     */
    private BigDecimal createtime;

    /**
     * COMPANY.IS_MSP
     * null
     */
    private Short isMsp;

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public Short getIsSuspended() {
        return isSuspended;
    }

    public void setIsSuspended(Short isSuspended) {
        this.isSuspended = isSuspended;
    }

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public String getoOrganId() {
        return oOrganId;
    }

    public void setoOrganId(String oOrganId) {
        this.oOrganId = oOrganId;
    }

    public BigDecimal getCreatetime() {
        return createtime;
    }

    public void setCreatetime(BigDecimal createtime) {
        this.createtime = createtime;
    }

    public Short getIsMsp() {
        return isMsp;
    }

    public void setIsMsp(Short isMsp) {
        this.isMsp = isMsp;
    }
}