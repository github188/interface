package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class EpRAssetsVic implements Serializable {
    /**
     * EP_R_ASSETS_VIC.ID
     * null
     */
    private String id;

    /**
     * EP_R_ASSETS_VIC.ASSETS_ID
     * null
     */
    private String assetsId;

    /**
     * EP_R_ASSETS_VIC.VIC_ID
     * null
     */
    private String vicId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public String getVicId() {
        return vicId;
    }

    public void setVicId(String vicId) {
        this.vicId = vicId;
    }
}