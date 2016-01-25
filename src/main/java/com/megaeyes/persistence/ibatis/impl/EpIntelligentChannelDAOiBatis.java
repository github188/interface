/**   
* @Title: EpIntelligentChannelDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-29 上午8:37:09 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpIntelligentChannelDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpIntelligentChannel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;

/** 
 * @ClassName: EpIntelligentChannelDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-29 上午8:37:09 
 *  
 */
public class EpIntelligentChannelDAOiBatis extends EpIntelligentChannelDAOImpl {
	/**
	* @Title: listEICByParentId 
	* @Description: 根据视频服务器ID查询智能分析单元 
	* @param parentId
	* @return List<VideoOutputChannel>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpIntelligentChannel> listEICByParentId(String parentId){
		return getSqlMapClientTemplate().queryForList(
				"EP_INTELLIGENT_CHANNEL_VIEW.listEICByParentId", parentId);
	}
	
	/**
	* @Title: listEICByOrganId 
	* @Description:根据机构ID查询智能分析单元列表
	* @param organId
	* @return List<EpIntelligentChannel>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpIntelligentChannel> listEICByOrganId(String organId){
		return getSqlMapClientTemplate().queryForList(
				"EP_INTELLIGENT_CHANNEL_VIEW.listEICByOrganId", organId);
	}
}
