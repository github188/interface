package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.EpSchemeCommandDAOImpl;

public class EpSchemeCommandDAOiBatis extends EpSchemeCommandDAOImpl {
	/**
	 * @Title: listVocByDisplayId
	 * @Description: 根据预案ID删除预案动作
	 * @param id
	 * @param @return 设定文件
	 * @return 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public int deleteESCByEpSchemeId(String id) {
		int rows = getSqlMapClientTemplate().delete(
				"EP_SCHEME_COMMAND_VIEW.deleteESCByEpSchemeId", id);
		return rows;
	}

	public String getVicNaming(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"EP_SCHEME_COMMAND_VIEW.getVicNaming", id);
	}

	public String getUserNaming(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"EP_SCHEME_COMMAND_VIEW.getUserNaming", id);
	}

	public String getVocNaming(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"EP_SCHEME_COMMAND_VIEW.getVocNaming", id);
	}

	public String getAocNaming(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"EP_SCHEME_COMMAND_VIEW.getAocNaming", id);
	}

	public String getProberNaming(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"EP_SCHEME_COMMAND_VIEW.getProberNaming", id);
	}

	public String getVicAlarmStorageServerIp(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"EP_SCHEME_COMMAND_VIEW.getVicAlarmStorageServerIp", id);
	}

	public String getVicNamingByPresetId(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"EP_SCHEME_COMMAND_VIEW.getVicNamingByPresetId", id);
	}

	public String getDoorNaming(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"EP_SCHEME_COMMAND_VIEW.getDoorNaming", id);
	}
}
