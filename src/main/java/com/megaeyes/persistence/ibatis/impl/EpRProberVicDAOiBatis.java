/**   
* @Title: EpRProberVicDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-14 上午2:56:01 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.EpRProberVicDAOImpl;

/** 
 * @ClassName: EpRProberVicDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午2:56:01 
 *  
 */
public class EpRProberVicDAOiBatis extends EpRProberVicDAOImpl {
	
	/**
	* @Title: deleteByDeviceId 
	* @Description: 根据探测器ID删除关系表 
	* @param proberId 探测器ID
	* @return int    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public int deleteByProberId(String proberId){
		int rows = getSqlMapClientTemplate().delete(
				"EP_R_PROBER_VIC_VIEW.deleteByProberId",proberId);
		return rows;
	}
}
