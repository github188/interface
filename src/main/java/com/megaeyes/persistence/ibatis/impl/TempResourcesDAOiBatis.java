package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.TempResourcesDAOImpl;

/**
 * TempResourcesDAOiBatis
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-20 下午03:22:52
 */
public class TempResourcesDAOiBatis extends TempResourcesDAOImpl {

	/**
	 * 递归查询整个父节点树的18位地址编码列表
	 * 
	 * @param code
	 *            18位设备地址编码
	 * @return 父节点树的18位地址编码列表
	 */
	public List<String> listParentTree(String code) {
		return getSqlMapClientTemplate().queryForList(
				"TEMP_RESOURCES_VIEW.listParentTree", code);
	}
}
