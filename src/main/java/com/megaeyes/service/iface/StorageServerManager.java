package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.StorageServer;

/**
 * 
 * @Title: StorageServerManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description:存储服务器管理接口
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-23 下午04:42:04 
 * @version V1.0
 */
public interface StorageServerManager extends BaseManager{
	
	/**
	 * 
	 * @Description: 存储服务器注册
	 * @author zhuanqi@megaeyes.com
	 * @param @param storageServer 
	 * @return void 
	 * @throws
	 */
	public void registerStorageServer(StorageServer storageServer);
	
	/**
	 * 
	 * @Description: 根据设备编号查询存储服务器信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param deviceNumber
	 * @param @return 
	 * @return StorageServer 
	 * @throws
	 */
	public StorageServer getStorageServerByDeviceNumber(String deviceNumber);
	
	/**
	 * 
	 * @Description: 查询中心存储版本
	 * @author zhuanqi@megaeyes.com
	 * @param @param deviceNumber
	 * @param @return 
	 * @return boolean 
	 * @throws
	 */
	public int hasVod (String deviceNumber);
	
	/**
	 * 
	 * @Description: 查询所有中心存储列表
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return List<StorageServer> 
	 * @throws
	 */
	public List<StorageServer> findAllRemoteStorageServer();
	

	/**
	 * 
	 * @Description: 根据ID查询存储设备
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @return 
	 * @return StorageServer 
	 * @throws
	 */
	public StorageServer getStorageServerById(String id);
	
	/**
	 * 
	 * @Description: 根据本地存储ID查询所属视频服务器ID
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getVisIdByLocalStorageServerId(String id);

}
