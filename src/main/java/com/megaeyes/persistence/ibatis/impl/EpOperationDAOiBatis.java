/**   
 * @Title: EpOperationDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-5 下午1:36:13 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpOperationDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpOperation;

/**
 * @ClassName: EpOperationDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-5 下午1:36:13
 * 
 */
public class EpOperationDAOiBatis extends EpOperationDAOImpl {
	/**
	 * @Title: listAllEpOperation
	 * @Description: TODO()
	 * @param @return 设定文件
	 * @return List<EpOperation> 返回类型
	 * @throws
	 */
	public List<EpOperation> listAllEpOperation() {
		return getSqlMapClientTemplate().queryForList(
				"EP_OPERATION_VIEW.listAllEpOperation");
	}
	/**
	 * 
	* @Title: listEpOperationByUserId 
	* @Description: 根据用户查询操作
	* @param @return    设定文件 
	* @return List<EpOperation>    返回类型 
	* @throws
	 */
	public List<EpOperation> listEpOperationByUserId(String userId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_OPERATION_VIEW.listEpOperationByUserId",userId);
	}
	
}
