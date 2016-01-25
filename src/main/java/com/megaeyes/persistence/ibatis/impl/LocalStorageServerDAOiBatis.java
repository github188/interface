/**   
 * @Title: LocalStorageServerDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-16 下午3:19:02 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.LocalStorageServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.LocalStorageServer;

/**
 * @ClassName: LocalStorageServerDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-16 下午3:19:02
 * 
 */
public class LocalStorageServerDAOiBatis extends LocalStorageServerDAOImpl {
	public LocalStorageServer findLocalStorageServerByVisId(String visId) {
		return (LocalStorageServer) getSqlMapClientTemplate().queryForObject(
				"LocalStorageServerView.getLocalStorageServerByVisId", visId);
	}
	
	public String findVisIdByLocalStorageServerId(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"LocalStorageServerView.getVisIdByLocalStorageServerId", id);
	}
}
