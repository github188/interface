/**   
 * @Title: EpSchemeDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-21 下午4:43:03 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpSchemeDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelAndSchemeVO;

/**
 * @ClassName: EpSchemeDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-21 下午4:43:03
 * 
 */
public class EpSchemeDAOiBatis extends EpSchemeDAOImpl {
	/**
	* @Title: listESByOrganId 
	* @Description: 根据机构ID查询预案列表 
	* @param organId
	* @return List<EpScheme>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpScheme> listESByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_SCHEME_VIEW.listESByOrganId",organId);
	}
	public String getSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpSchemeSeq");
	}

	public Long getSchemesLastUpdateTime() {
		return (Long) getSqlMapClientTemplate().queryForObject(
				"EP_SCHEME_VIEW.getSchemesLastUpdateTime");
	}
	public List<VideoInputChannelAndSchemeVO> listVICAndScheme(String organId) {
		
		return getSqlMapClientTemplate().queryForList(
				"EP_SCHEME_VIEW.listVICAndScheme",organId);
	}
}
