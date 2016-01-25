/**   
 * @Title: OrganDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-2 下午2:16:31 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.OrganDAOImpl;
import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.vo.ListOrganVO;
import com.megaeyes.persistence.ibatis.vo.OrganVO;

/**
 * @ClassName: OrganDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-2 下午2:16:31
 * 
 */
public class OrganDAOiBatis extends OrganDAOImpl {
	public List<Organ> getChildOrganById(String organId) {

		return getSqlMapClientTemplate().queryForList(
				"OrganView.getChildOrganById", organId);
	}

	public OrganVO getOrganById(String id) {
		return (OrganVO) getSqlMapClientTemplate().queryForObject(
				"OrganView.getOrganById", id);
	}

	public List<Organ> listOrganByOrganIdNextLevel(Map map) {
		return getSqlMapClientTemplate().queryForList(
				"OrganView.listOrganByOrganIdNextLevel", map);
	}

	public int countListOrganByOrganIdNextLevel(Map map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"OrganView.countListOrganByOrganIdNextLevel", map);
	}

	public List<ListOrganVO> listOrganById(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"OrganView.listOrganById", organId);
	}

	/**
	 * @Title: listChidOrgan
	 * @Description: TODO(查询当前机构下需哦有子机构)
	 * @param @param parentId
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	public List listChidOrgan(String parentId) {
		return getSqlMapClientTemplate().queryForList(
				"OrganView.listChidOrgan", parentId);
	}
}
