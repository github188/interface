package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RUserVis implements Serializable {
    /**
     * R_USER_VIS.ID
     * null
     */
    private String id;

    /**
     * R_USER_VIS.USERID
     * null
     */
    private String userid;

    /**
     * R_USER_VIS.VISID
     * null
     */
    private String visid;

    /**
     * R_USER_VIS.TYPE
     * null
     */
    private BigDecimal type;

    /**
     * R_USER_VIS.PERMISSION
     * null
     */
    private String permission;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getVisid() {
        return visid;
    }

    public void setVisid(String visid) {
        this.visid = visid;
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}