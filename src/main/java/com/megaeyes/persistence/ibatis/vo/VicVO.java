/**
 * 
 */
package com.megaeyes.persistence.ibatis.vo;

/**
 * 摄像头业务模型(合并普通摄像头和IP摄像头两张表的数据)
 * 
 * @author HBJ
 * 
 */
public class VicVO {
	private String id; // 摄像头ID
	private String naming;//
	private String name; // 摄像头名称
	private String hasPan; // 有无云台，0:没有，1:有
	private String storeCycle; // 远程存储周期
	private String localStoreCycle; // 本地存储周期
	private String vicModelId; // 摄像头类型ID
	private String dispatchServerId; // 分发服务器ID
	private String remoteStorageServerId; // 中心存储服务器ID
	private String storeType; // 存储方式
	private String visName; // 所属视频服务器名称
	private String visType; // 摄像头种类, "dvs":普通摄像头, "ipvis":IP摄像头
	private String organName; // 所属机构名称
	private String note; // 备注
	private String localStoragePlanFlag; // 本地存储方案
	private String remoteStoragePlanFlag; // 远程存储方案

	
	
	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}

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

	public String getHasPan() {
		return hasPan;
	}

	public void setHasPan(String hasPan) {
		this.hasPan = hasPan;
	}

	public String getStoreCycle() {
		return storeCycle;
	}

	public void setStoreCycle(String storeCycle) {
		this.storeCycle = storeCycle;
	}

	public String getLocalStoreCycle() {
		return localStoreCycle;
	}

	public void setLocalStoreCycle(String localStoreCycle) {
		this.localStoreCycle = localStoreCycle;
	}

	public String getVicModelId() {
		return vicModelId;
	}

	public void setVicModelId(String vicModelId) {
		this.vicModelId = vicModelId;
	}

	public String getDispatchServerId() {
		return dispatchServerId;
	}

	public void setDispatchServerId(String dispatchServerId) {
		this.dispatchServerId = dispatchServerId;
	}

	public String getRemoteStorageServerId() {
		return remoteStorageServerId;
	}

	public void setRemoteStorageServerId(String remoteStorageServerId) {
		this.remoteStorageServerId = remoteStorageServerId;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getVisName() {
		return visName;
	}

	public void setVisName(String visName) {
		this.visName = visName;
	}

	public String getVisType() {
		return visType;
	}

	public void setVisType(String visType) {
		this.visType = visType;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLocalStoragePlanFlag() {
		return localStoragePlanFlag;
	}

	public void setLocalStoragePlanFlag(String localStoragePlanFlag) {
		this.localStoragePlanFlag = localStoragePlanFlag;
	}

	public String getRemoteStoragePlanFlag() {
		return remoteStoragePlanFlag;
	}

	public void setRemoteStoragePlanFlag(String remoteStoragePlanFlag) {
		this.remoteStoragePlanFlag = remoteStoragePlanFlag;
	}

}
