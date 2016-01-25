/**   
* @Title: EpIntelligentDetectionDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-2 上午6:22:44 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpIntelligentChannelDAOImpl;
import com.megaeyes.persistence.ibatis.iface.EpIntelligentDetectionDAOImpl;
import com.megaeyes.persistence.ibatis.vo.EpAssetsAndDeviceVO;
import com.megaeyes.persistence.ibatis.vo.EpIntelligentDetectionAndDeviceVO;

/** 
 * @ClassName: EpIntelligentDetectionDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-2 上午6:22:44 
 *  
 */
public class EpIntelligentDetectionDAOiBatis extends EpIntelligentDetectionDAOImpl {
	
	/**
	* @Title: listEAByOrganId 
	* @Description: 根据机构ID查询列表 
	* @param organId 机构ID
	* @return List<EpAssetsAndDeviceVO>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpIntelligentDetectionAndDeviceVO> listEIDByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_INTELLIGENT_DETECTION_VIEW.listEIDByOrganId",organId);
	}
}
