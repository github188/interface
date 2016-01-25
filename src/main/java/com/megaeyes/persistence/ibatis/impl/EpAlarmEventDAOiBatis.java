/**   
 * @Title: EpAlarmEventDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-18 下午5:10:47 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.EpAlarmEventDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpAlarmEvent;
import com.megaeyes.persistence.ibatis.vo.ResourceVO;

/**
 * @ClassName: EpAlarmEventDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-18 下午5:10:47
 * 
 */
public class EpAlarmEventDAOiBatis extends EpAlarmEventDAOImpl {
	/**
	 * 调用此方法返回EpAlarmEvent的下一个ID，用于insert
	 * 
	 * @return EP_ALARM_EVENT_SEQ.nextval
	 */
	public String getEpAlarmEventSeq() {
		String id = (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpAlarmEventSeq", null);
		String prefix = "";
		for (int i = 31; i > id.length(); i--) {
			prefix += "0";
		}
		id = prefix + id;
		return id;
	}

	public List<EpAlarmEvent> getEpAlarmEvents(String eventtype, String level,
			String start, String limit, String beginTime, String endTime) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("level", level);
		map.put("start", start);
		map.put("limit", limit);
		map.put("sourceType", eventtype);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		return getSqlMapClientTemplate().queryForList(
				"EP_ALARM_EVENT_VIEW.abatorgenerated_selectByPrimaryKey", map);
	}

	/**
	 * @Title: updateEpAlarmEvent
	 * @Description: 根据naming修改note
	 * @param eae
	 *            报警对象
	 * @return void 返回类型
	 * @throws
	 */
	public void updateEpAlarmEvent(EpAlarmEvent eae) {
		Map map = new HashMap();
		map.put("naming", eae.getNaming());
		map.put("note", eae.getNote());
		map.put("confirmTime", eae.getConfirmTime());
		getSqlMapClientTemplate().update(
				"EP_ALARM_EVENT_VIEW.updateEpAlarmEvent", map);
	}

	/**
	 * 列表条件查询历史报警信息
	 * 
	 * @param organIds
	 *            报警预源设备所属机构ID列表
	 * @param begin
	 *            时间范围，起始时间
	 * @param end
	 *            时间范围， 结束时间
	 * @param start
	 *            分页起始行
	 * @param limit
	 *            分页要查询的总行数
	 * @return 历史报警信息列表
	 */
	public List<EpAlarmEvent> listAlarmEvent(List<String> organIds, Long begin,
			Long end, int start, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("organIds", organIds);
		map.put("begin", begin);
		map.put("end", end);
		map.put("start", start);
		map.put("limit", start + limit);
		return getSqlMapClientTemplate().queryForList(
				"EP_ALARM_EVENT_VIEW.listAlarmEvent", map);
	}

	/**
	 * 统计满足条件的历史报警信息条数
	 * 
	 * @param organIds
	 *            报警预源设备所属机构ID列表
	 * @param begin
	 *            时间范围，起始时间
	 * @param end
	 *            时间范围， 结束时间
	 * @return 满足条件的历史报警信息条数
	 */
	public Integer countAlarmEvent(List<String> organIds, Long begin, Long end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("organIds", organIds);
		map.put("begin", begin);
		map.put("end", end);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.countAlarmEvent", map);
	}

	/**
	 * 分页查询符合条件的指定报警源集合的报警信息
	 * 
	 * @param sourceIds
	 *            报警源集合ID列表
	 * @param eventTypeName
	 *            事件类型名称
	 * @param beginTime
	 *            按照时间段进行查询，起始时间
	 * @param endTime
	 *            按照时间段进行查询，结束时间
	 * @param level
	 *            报警级别
	 * @param start
	 *            查询起始行
	 * @param length
	 *            要查询的条数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EpAlarmEvent> listEpAlarmEventInDevices(List<String> sourceIds,
			List<String> eventTypeNames, Long beginTime, Long endTime,
			String level, int start, int length) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sourceIds", sourceIds);
		map.put("eventTypeName", eventTypeNames);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		map.put("eventLevel", level);
		map.put("begin", start);
		map.put("end", start + length);
		return getSqlMapClientTemplate().queryForList(
				"EP_ALARM_EVENT_VIEW.listEpAlarmEventInDevices", map);
	}

	/**
	 * 统计符合条件的指定报警源集合的报警信息条数
	 * 
	 * @param sourceIds
	 *            报警源集合ID列表
	 * @param eventTypeName
	 *            事件类型名称
	 * @param beginTime
	 *            按照时间段进行查询，起始时间
	 * @param endTime
	 *            按照时间段进行查询，结束时间
	 * @param level
	 *            报警级别
	 * @return
	 */
	public Integer countEpAlarmEventInDevices(List<String> sourceIds,
			List<String> eventTypeNames, Long beginTime, Long endTime,
			String level) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sourceIds", sourceIds);
		map.put("eventTypeName", eventTypeNames);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		map.put("eventLevel", level);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.countEpAlarmEventInDevices", map);
	}
	
	public ResourceVO getOrganNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getOrganNameById", id);
	}

	public ResourceVO getVicNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getVicNameById", id);
	}

	public ResourceVO getEpProberNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getEpProberNameById", id);
	}

	public ResourceVO getEpDeviceNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getEpDeviceNameById", id);
	}

	public ResourceVO getAicNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getAicNameById", id);
	}

	public ResourceVO getAocNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getAocNameById", id);
	}

	public ResourceVO getVocNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getVocNameById", id);
	}

	public ResourceVO getVisNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getVisNameById", id);
	}

	public ResourceVO getACAccessServerNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getACAccessServerNameById", id);
	}

	public ResourceVO getACAccessControlNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getACAccessControlNameById", id);
	}

	public ResourceVO getACAccessCardNumberById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getACAccessCardNumberById", id);
	}

	public ResourceVO getACGatewayNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getACGatewayNameById", id);
	}

	public ResourceVO getACEmployeeNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getACEmployeeNameById", id);
	}

	public ResourceVO getICNameById(String id) {
		return (ResourceVO) getSqlMapClientTemplate().queryForObject(
				"EP_ALARM_EVENT_VIEW.getICNameById", id);
	}
}
