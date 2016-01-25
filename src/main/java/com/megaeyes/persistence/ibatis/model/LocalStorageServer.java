package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class LocalStorageServer implements Serializable {
    /**
     * LOCAL_STORAGE_SERVER.STORAGE_SERVER_ID
     * null
     */
    private String storageServerId;

    /**
     * LOCAL_STORAGE_SERVER.COMPANY_ID
     * null
     */
    private String companyId;

    /**
     * LOCAL_STORAGE_SERVER.VIDEO_INPUT_SERVER_ID
     * null
     */
    private String videoInputServerId;

    /**
     * LOCAL_STORAGE_SERVER.O_ORGAN_ID
     * null
     */
    private String oOrganId;

    public String getStorageServerId() {
        return storageServerId;
    }

    public void setStorageServerId(String storageServerId) {
        this.storageServerId = storageServerId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getVideoInputServerId() {
        return videoInputServerId;
    }

    public void setVideoInputServerId(String videoInputServerId) {
        this.videoInputServerId = videoInputServerId;
    }

    public String getoOrganId() {
        return oOrganId;
    }

    public void setoOrganId(String oOrganId) {
        this.oOrganId = oOrganId;
    }
}