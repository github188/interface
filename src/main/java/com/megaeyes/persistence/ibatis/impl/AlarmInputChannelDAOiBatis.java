/**   
* @Title: AlarmInputChannelDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-3-21 下午5:11:52 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.AlarmInputChannelDAOImpl;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.vo.AlarmInputChannelVO;

/** 
 * @ClassName: AlarmInputChannelDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com  
 * @date 2012-3-21 下午5:11:52 
 *  
 */
public class AlarmInputChannelDAOiBatis extends AlarmInputChannelDAOImpl {

	/**
	 * 查询指定报警箱下属的报警输入列表
	 * 
	 * @param alarmBoxId
	 *            报警箱ID
	 * @return 报警输入列表
	 */
	public List<AlarmInputChannelVO> listAICByAlarmBoxId(String alarmBoxId) {
		return getSqlMapClientTemplate().queryForList(
				"ALARM_INPUT_CHANNEL_VIEW.listAlarmInputChannel", alarmBoxId);
	}
	/**
	 * 调用此方法返回AlarmInputChannel的下一个ID，用于insert
	 * 
	 * @return ALARMINPUTCHANNEL_SEQ.nextval
	 */
	public String getAICSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAlarmInputChannelSeq", null);
	}

	/**
	 * @Title: listAlarmOutPutByOrganId
	 * @Description: TODO(根据机构ID查询该机构以及子机构下所有报警輸入)
	 * @param @param organId
	 * @param @return 设定文件
	 * @return List<AlarmOutputChannel> 返回类型
	 * @throws
	 */
	public List<AlarmInputChannel> listAlarmInPutByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"ALARM_INPUT_CHANNEL_VIEW.listAlarmInPutByOrganId", organId);
	}
}
