/**   
* @Title: EpRAssetsVicDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-9 上午5:50:07 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpRAssetsVicDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpRole;

/** 
 * @ClassName: EpRAssetsVicDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-9 上午5:50:07 
 *  
 */
public class EpRAssetsVicDAOiBatis extends EpRAssetsVicDAOImpl {
	
	/**
	* @Title: deleteByAssetsId 
	* @Description: 根据资产管理ID删除记录
	* @param assetsId  资产管理ID
	* @return void    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public int deleteByAssetsId(String assetsId){
		int rows = getSqlMapClientTemplate().delete(
				"EP_R_ASSETS_VIC_VIEW.deleteByAssetsId",assetsId);
		return rows;
	}
}
