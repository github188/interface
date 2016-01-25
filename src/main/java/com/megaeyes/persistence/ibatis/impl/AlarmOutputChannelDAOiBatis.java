/**   
 * @Title: AlarmOutputChannelDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-21 下午5:16:44 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.AlarmOutputChannelDAOImpl;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;

/**
 * @ClassName: AlarmOutputChannelDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-21 下午5:16:44
 * 
 */
public class AlarmOutputChannelDAOiBatis extends AlarmOutputChannelDAOImpl {
	/**
	 * 查询指定报警箱下属的报警输出列表
	 * 
	 * @param alarmBoxId
	 *            报警箱ID
	 * @return 报警输出列表
	 */
	@SuppressWarnings("unchecked")
	public List<AlarmOutputChannel> listAOCByAlarmBoxId(String alarmBoxId) {
		return getSqlMapClientTemplate().queryForList(
				"ALARM_OUTPUT_CHANNEL_VIEW.listAlarmOutputChannel", alarmBoxId);
	}

	/**
	 * 调用此方法返回AlarmOutputChannel的下一个ID，用于insert
	 * 
	 * @return ALARMOUTPUTCHANNEL_SEQ.nextval
	 */
	public String getAOCSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAlarmOutputChannelSeq", null);
	}

	/**
	 * 查询指定机构下面下属的报警输出列表
	 * 
	 * @param organId
	 *            机构ID
	 * @return 报警输出列表
	 */
	@SuppressWarnings("unchecked")
	public List<AlarmOutputChannel> listAOCByOrganId(Map queryMap) {
		return getSqlMapClientTemplate().queryForList(
				"ALARM_OUTPUT_CHANNEL_VIEW.listAlarmOutputChannelByOrganId",
				queryMap);
	}

	/**
	 * @Title: listAlarmOutPutByOrganId
	 * @Description: TODO(根据机构ID查询该机构以及子机构下所有报警输出)
	 * @param @param organId
	 * @param @return 设定文件
	 * @return List<AlarmOutputChannel> 返回类型
	 * @throws
	 */
	public List<AlarmOutputChannel> listAlarmOutPutByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"ALARM_OUTPUT_CHANNEL_VIEW.listAlarmOutPutByOrganId", organId);
	}
}
