package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.PlatformResourcesDAOImpl;
import com.megaeyes.persistence.ibatis.model.PlatformResources;

public class PlatformResourcesDAOiBatis extends PlatformResourcesDAOImpl {

	/**
	 * 
	 * @Title: getByResourceId
	 * @Description: TODO(根据平台资源31位ID，获取平台对应的资源)
	 * @param id
	 *            平台资源31位ID
	 * @param type
	 * @param @return 设定文件
	 * @return PlatformResources 返回类型
	 * @throws
	 */
	public PlatformResources getByResourceId(String id, String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("type", type);
		return (PlatformResources) getSqlMapClientTemplate().queryForObject(
				"PLATFORM_RESOURCES_VIEW.getByResourceId", map);
	}

	/**
	 * 
	 * @Title: getBySipCode
	 * @Description: TODO(根据18位地址编码，获取平台对应的资源)
	 * @param code
	 *            18位地址编码
	 * @param @return 设定文件
	 * @return PlatformResources 返回类型
	 * @throws
	 */
	public PlatformResources getBySipCode(String code) {
		return (PlatformResources) getSqlMapClientTemplate().queryForObject(
				"PLATFORM_RESOURCES_VIEW.getBySipCode", code);
	}

	/**
	 * 
	 * @Title: listSharedAlarmDevice
	 * @Description: TODO 分页查询所有共享的报警源设备（预案报警源设备）
	 * @param begin
	 *            起始行，从1开始
	 * @param limit
	 *            要查询的行数
	 * @param @return 设定文件
	 * @return List<PlatformResources> 返回类型
	 * @throws
	 */
	public List<PlatformResources> listSharedAlarmDevice(int begin, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", begin + limit);
		return getSqlMapClientTemplate().queryForList(
				"PLATFORM_RESOURCES_VIEW.listSharedAlarmDevice", map);
	}

	/**
	 * 
	 * @Title: countSharedAlarmDevice
	 * @Description: TODO(统计所有共享的报警源设备（预案报警源设备）的记录数 )
	 * @param @return 设定文件
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer countSharedAlarmDevice() {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"PLATFORM_RESOURCES_VIEW.countSharedAlarmDevice");
	}

	/**
	 * 分页查询平台资源
	 * 
	 * @param parentId
	 *            父节点平台31位ID
	 * @param userId
	 *            用户18位编码，权限验证
	 * @param start
	 *            分页起始行
	 * @param end
	 *            分页结束行
	 * @return 平台资源 列表
	 */
	public List<PlatformResources> listResources(String parentId,
			String userId, int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		map.put("userId", userId);
		map.put("start", start);
		map.put("end", end);
		return getSqlMapClientTemplate().queryForList(
				"PLATFORM_RESOURCES_VIEW.listResources", map);
	}

	/**
	 * 统计指定节点的下属资源数量
	 * 
	 * @param parentId
	 *            父节点平台31位ID
	 * @param userId
	 *            用户18位编码，权限验证
	 * @return 资源数量
	 */
	public Integer countResources(String parentId, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		map.put("userId", userId);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"PLATFORM_RESOURCES_VIEW.countResources", map);
	}
	
	/**
	 * 查询vis下面的共享的vic和aic
	 * 
	 * @param visId
	 *            视频服务器ID
	 * @return
	 */
	public List<String> listVisSharedChildrenId(String visId) {
		return getSqlMapClientTemplate().queryForList(
				"PLATFORM_RESOURCES_VIEW.listVisSharedChildrenId", visId);
	}

	/**
	 * 查询使用指定中心存储的所有共享摄像头列表
	 */
	public List<PlatformResources> listSharedVICWithRSS(String rssId) {
		return getSqlMapClientTemplate().queryForList(
				"PLATFORM_RESOURCES_VIEW.listSharedVICWithRSS", rssId);
	}
}
