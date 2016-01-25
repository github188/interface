package com.megaeyes.persistence.ibatis.vo;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.RemoteStorageServer;
import com.megaeyes.persistence.ibatis.model.StorageServer;

/**
 * 
 * @Title: StorageServerVO.java
 * @Package com.megaeyes.persistence.ibatis.vo
 * @Description:存储服务器分为前端存储和中心存储两种
 * @author zhuanqi@megaeyes.com
 * @date 2012-8-23 下午05:25:55
 * @version V1.0
 */
public class StorageServerVO {

	private String id;
	
	private List<?> cameraList;
	  
	private StorageServer storageServer;
	
	private RemoteStorageServer remoteStorageServer;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public List<?> getCameraList() {
		return cameraList;
	}

	public void setCameraList(List<?> cameraList) {
		this.cameraList = cameraList;
	}
	
	public StorageServer getStorageServer() {
		return storageServer;
	}

	public void setStorageServer(StorageServer storageServer) {
		this.storageServer = storageServer;
	}
	
	public RemoteStorageServer getRemoteStorageServer() {
		return remoteStorageServer;
	}

	public void setRemoteStorageServer(RemoteStorageServer remoteStorageServer) {
		this.remoteStorageServer = remoteStorageServer;
	}

}
