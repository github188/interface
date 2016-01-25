/**   
 * @Title: AlarmBoxDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-21 下午5:09:42 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.AlarmBoxDAOImpl;
import com.megaeyes.persistence.ibatis.model.AlarmBox;

/**
 * @ClassName: AlarmBoxDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-21 下午5:09:42
 * 
 */
public class AlarmBoxDAOiBatis extends AlarmBoxDAOImpl {
	/**
	 * @Title: listAlarmBoxByVisId
	 * @Description: 查询指定视频服务器下属的报警箱列表
	 * @param visId
	 *            视频服务器ID
	 * @return 报警箱列表
	 */
	public List<AlarmBox> listAlarmBoxByVisId(String visId) {
		return getSqlMapClientTemplate().queryForList(
				"ALARM_BOX_VIEW.listAlarmBoxByVisId", visId);
	}

	/**
	 * @Title: getAlarmBoxSeq
	 * @Description:  调用此方法返回AlarmBox的下一个ID，用于insert
	 * @return ALARMBOX_SEQ.nextval
	 */
	public String getAlarmBoxSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAlarmBoxSeq", null);
	}
}
