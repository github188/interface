/**   
 * @Title: StorageServerDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com     
 * @date 2012-2-27 下午4:23:18 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.StorageServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.vo.ListRemoteStorageServerVO;
import com.megaeyes.persistence.ibatis.vo.StorageInfoQueryVO;

/**
 * @ClassName: StorageServerDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-2-27 下午4:23:18
 * 
 */
public class StorageServerDAOiBatis extends StorageServerDAOImpl {
	/**
	 * @Title: getStorageServerSeq
	 * @Description: 调用此方法返回存储服务器的下一个ID，用于insert
	 * 
	 * @return STORAGESERVER_SEQ.nextval
	 */
	public String getStorageServerSeq() {
		String id = (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getStorageServerSeq", null);
		String prefix = "";
		for (int i = 31; i > id.length(); i--) {
			prefix += "0";
		}
		id = prefix + id;
		return id;
	}

	/**
	 * @Title: listRemoteStorageServer
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<StorageServer> 返回类型
	 * @throws
	 */
	public List<ListRemoteStorageServerVO> listRemoteStorageServer() {
		return getSqlMapClientTemplate().queryForList(
				"STORAGE_SERVER_VIEW.listRemoteStorageServer");
	}

	public int countStorageServer(String name, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("id", id);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"STORAGE_SERVER_VIEW.countStorageServer", map);
	}
	/**
	 * @Title: listStorageInfoOfCamera
	 * @Description: 视频服务器的存储服务器查询
	 * @param accessId
	 * @return List<StorageInfoQueryVO> 返回类型
	 * @throws 
	 */
	public StorageInfoQueryVO getStorageInfoOfCamera(String accessId) {
		return (StorageInfoQueryVO)getSqlMapClientTemplate().queryForObject("STORAGE_SERVER_VIEW.getStorageInfoOfCamera", accessId);
	}
	
	/**
	 * 
	 * @Description: 查询中心存储版本
	 * @author zhuanqi@megaeyes.com
	 * @param @param deviceNumber
	 * @param @return 
	 * @return int 
	 * @throws
	 */
	public int hasVod(String deviceNumber){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("deviceNumber", deviceNumber);
		return (Integer)getSqlMapClientTemplate().queryForObject("STORAGE_SERVER_VIEW.getStorageHasVod",param);
	}
	
	/**
	 * 
	 * @Description: 查询中心存储列表 
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return List<StorageServer> 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<StorageServer> findAllRemoteStorageServer(){
		return getSqlMapClientTemplate().queryForList("STORAGE_SERVER_VIEW.findAllRemoteStorageServer");
	}
}
