/**   
* @Title: EpProberTypeDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-10 上午7:58:10 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpProberTypeDAOImpl;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.EpProberType;

/** 
 * @ClassName: EpProberTypeDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-10 上午7:58:10 
 *  
 */
public class EpProberTypeDAOiBatis extends EpProberTypeDAOImpl {
	
	/**
	* @Title: listProberType 
	* @Description: 查询探测器类型列表
	* @return List<EpProberType>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpProberType> listProberType() {
		return getSqlMapClientTemplate().queryForList(
				"EP_PROBER_TYPE_VIEW.ListProberType");
	}
}
