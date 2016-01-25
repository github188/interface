package com.megaeyes.persistence.ibatis.vo;

public class StorageInfoQueryVO{
    
	private String cameraId;

	private Integer storeType;
	
	
	private String localId;
	
	private String localIp;
	
	
	private String remoteId;
	
	private String remoteIp;
	
	private Integer hasVOD; //中心存储是否支持VOD(视频点播)
	
	private boolean hasFTP; //暂未使用
	
	private String encodeType;

	public Integer getStoreType() {
		return storeType;
	}

	public void setStoreType(Integer storeType) {
		this.storeType = storeType;
	}

	

	public Integer getHasVOD() {
		return hasVOD;
	}

	public void setHasVOD(Integer hasVOD) {
		this.hasVOD = hasVOD;
	}

	public String getCameraId() {
		return cameraId;
	}

	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getLocalIp() {
		return localIp;
	}

	public void setLocalIp(String localIp) {
		this.localIp = localIp;
	}

	public String getRemoteId() {
		return remoteId;
	}

	public void setRemoteId(String remoteId) {
		this.remoteId = remoteId;
	}

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public boolean isHasFTP() {
		return hasFTP;
	}

	public void setHasFTP(boolean hasFTP) {
		this.hasFTP = hasFTP;
	}

	public String getEncodeType() {
		return encodeType;
	}

	public void setEncodeType(String encodeType) {
		this.encodeType = encodeType;
	}
}
