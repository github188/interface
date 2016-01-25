package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class RemoteStorageServer implements Serializable {
    /**
     * REMOTE_STORAGE_SERVER.STORAGE_SERVER_ID
     * null
     */
    private String storageServerId;

    /**
     * REMOTE_STORAGE_SERVER.O_ORGAN_ID
     * null
     */
    private String oOrganId;

    /**
     * REMOTE_STORAGE_SERVER.HAS_VOD
     * null
     */
    private Short hasVod;

    public String getStorageServerId() {
        return storageServerId;
    }

    public void setStorageServerId(String storageServerId) {
        this.storageServerId = storageServerId;
    }

    public String getoOrganId() {
        return oOrganId;
    }

    public void setoOrganId(String oOrganId) {
        this.oOrganId = oOrganId;
    }

    public Short getHasVod() {
        return hasVod;
    }

    public void setHasVod(Short hasVod) {
        this.hasVod = hasVod;
    }
}