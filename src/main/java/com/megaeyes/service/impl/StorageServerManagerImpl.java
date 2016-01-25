package com.megaeyes.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.LocalStorageServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.StorageServerDAOiBatis;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.model.StorageServerExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.StorageServerManager;

/**
 * 
 * @Title: StorageServerManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: 存储服务器管理接口实现类 
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-23 下午04:46:36 
 * @version V1.0
 */
public class StorageServerManagerImpl extends BaseManagerImpl implements StorageServerManager{

	@Autowired
	private StorageServerDAOiBatis storageServerDAO;
	@Autowired
	private LocalStorageServerDAOiBatis localStorageServerDAO;
	
	public void registerStorageServer(StorageServer storageServer){
		storageServerDAO.updateByPrimaryKeySelective(storageServer);
	}
	
	@SuppressWarnings("unchecked")
	public StorageServer getStorageServerByDeviceNumber(String deviceNumber) {
		StorageServerExample example = new StorageServerExample();
		example.createCriteria().andDeviceNumberEqualTo(deviceNumber);
		List<StorageServer> list = storageServerDAO.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			throw new BusinessException("deviceNumber", ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}
	}
	
	/**
	 * 
	 * @Description: 根据ID查询存储设备
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @return 
	 * @return StorageServer 
	 * @throws
	 */
	public StorageServer getStorageServerById(String id){
		StorageServerExample example = new StorageServerExample();
		example.createCriteria().andIdEqualTo(id);
		List<StorageServer> list = storageServerDAO.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			throw new BusinessException("id", ErrorCode.RESOURCE_NOT_FOUND);
		}
	}
	
	/**
	 * 
	 * @Description: 查询中心存储版本
	 * @author zhuanqi@megaeyes.com
	 * @param @param deviceNumber
	 * @param @return 
	 * @return boolean 
	 * @throws
	 */
	public int hasVod (String deviceNumber){
		return storageServerDAO.hasVod(deviceNumber);
	}
	
	/**
	 * 
	 * @Description: 查询所有中心存储列表
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return List<StorageServer> 
	 * @throws
	 */
	public List<StorageServer> findAllRemoteStorageServer(){
		return storageServerDAO.findAllRemoteStorageServer();
	}
	
	/**
	 * 
	 * @Description: 查询视频服务器ID
	 * @author zhuanqi@megaeyes.com
	 * @param @param deviceNumber
	 * @param @return 
	 * @return boolean 
	 * @throws
	 */
	public String getVisIdByLocalStorageServerId(String id){
		return localStorageServerDAO.findVisIdByLocalStorageServerId(id);
	}

}
