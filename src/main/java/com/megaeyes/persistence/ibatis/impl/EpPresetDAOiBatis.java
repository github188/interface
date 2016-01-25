package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpPresetDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpPreset;
import com.megaeyes.persistence.ibatis.model.EpRole;

public class EpPresetDAOiBatis extends EpPresetDAOImpl {
	/**
	 * @Title: listEpPresetByVicId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param vicId
	 * @return 设定文件
	 * @return List<EpRole> 返回类型
	 * @throws
	 */
	public List<EpPreset> listEpPresetByVicId(String vicId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_PRESET_VIEW.listEpPresetByVicId", vicId);
	}

	public int deleteByvicId(String vicId) {
		int rows = getSqlMapClientTemplate().delete(
				"EP_PRESET_VIEW.deleteByvicId", vicId);
		return rows;
	}
}
