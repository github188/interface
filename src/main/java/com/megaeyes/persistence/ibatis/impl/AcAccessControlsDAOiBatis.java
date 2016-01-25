package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.AcAccessControlsDAOImpl;
import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.vo.ListDoorAndUserVO;
import com.megaeyes.persistence.ibatis.vo.ListDoorAndVicVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;

/**
 * AcAccessControlsDAOiBatis
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-20 上午09:21:26
 */
public class AcAccessControlsDAOiBatis extends AcAccessControlsDAOImpl {

	public int countAccessControl(String serverId, String name,
			String deviceType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serverId", serverId);
		map.put("name", name);
		map.put("deviceType", deviceType);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"AC_ACCESS_CONTROLS_VIEW.countAccessControl", map);
	}

	public List<AcAccessControls> listAccessControl(String serverId,
			String name, String deviceType, int begin, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serverId", serverId);
		map.put("name", name);
		map.put("deviceType", deviceType);
		map.put("begin", begin);
		map.put("end", end);
		return getSqlMapClientTemplate().queryForList(
				"AC_ACCESS_CONTROLS_VIEW.listAccessControl", map);
	}

	public int countUserAuthControl(String userId, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("name", name);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"AC_ACCESS_CONTROLS_VIEW.countUserAuthControl", map);
	}

	public List<AcAccessControls> listUserAuthControl(String userId,
			String name, int begin, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("name", name);
		map.put("begin", begin);
		map.put("end", end);
		return getSqlMapClientTemplate().queryForList(
				"AC_ACCESS_CONTROLS_VIEW.listUserAuthControl", map);
	}

	public int countUserNotAuthControl(String userId, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("name", name);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"AC_ACCESS_CONTROLS_VIEW.countUserNotAuthControl", map);
	}

	public List<AcAccessControls> listUserNotAuthControl(String userId,
			String name, int begin, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("name", name);
		map.put("begin", begin);
		map.put("end", end);
		return getSqlMapClientTemplate().queryForList(
				"AC_ACCESS_CONTROLS_VIEW.listUserNotAuthControl", map);
	}

	public List<UserSessionVO> listDoorNotifyUsers(String id) {
		return getSqlMapClientTemplate().queryForList(
				"AC_ACCESS_CONTROLS_VIEW.listDoorNotifyUsers", id);
	}

	/**
	 * getOrganIdByAccessServerId 根据门禁控制器ID查询机构ID
	 * 
	 * @param accessServerId
	 *            门禁控制器ID
	 * @return String
	 */
	public String getOrganIdByAccessServerId(String accessServerId) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"AC_ACCESS_CONTROLS_VIEW.getOrganIdByAccessServerId",
				accessServerId);
	}

	/**
	 * getNamingByAccessServerId 根据门禁控制器ID查询naming
	 * 
	 * @param accessServerId
	 *            门禁控制器ID
	 * @return String
	 */
	public String getNamingByAccessServerId(String accessServerId) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"AC_ACCESS_CONTROLS_VIEW.getNamingByAccessServerId",
				accessServerId);
	}

	public List<AcAccessControls> listAcAccessControlByGatewayId(
			String gatewayId) {
		return getSqlMapClientTemplate().queryForList(
				"AC_ACCESS_CONTROLS_VIEW.listAcAccessControlByGatewayId",
				gatewayId);
	}

	/**
	 * 
	 * listControlAndVic 查询门和摄像头列表
	 * @param organId 机构ID
	 * @return List<AcAccessControls>
	 */
	public List<ListDoorAndVicVO> listControlAndVic(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"AC_ACCESS_CONTROLS_VIEW.listControlAndVic",organId);

	}

	/**
	 * 
	 * listControlAndUser 查询门和用户列表
	 * @param organId 机构ID
	 * @return
	 */
	public List<ListDoorAndUserVO> listControlAndUser(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"AC_ACCESS_CONTROLS_VIEW.listControlAndUser",organId);
	}

	public List<String> listDoorBindVics(String doorId) {
		return getSqlMapClientTemplate().queryForList(
				"AC_ACCESS_CONTROLS_VIEW.listDoorBindVics", doorId);
	}
	
	public List<AcAccessControls> listDoorByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList("AC_ACCESS_CONTROLS_VIEW.listDoorByOrganId", organId);
	}
}
