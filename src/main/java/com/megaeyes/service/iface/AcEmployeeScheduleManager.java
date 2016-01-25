package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcEmployeeSchedule;
import com.megaeyes.service.exception.BusinessException;

/**
 * 
 * @Title: AcEmployeeScheduleManager.java
 * @Package com.megaeyes.service.iface
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhuanqi@megaeyes.com
 * @date 2013-1-8 上午08:19:38
 * @version V2.5
 */
public interface AcEmployeeScheduleManager extends BaseManager {

	/**
	 * 
	 * @Description: 创建排班班次
	 * @author zhuanqi@megaeyes.com
	 * @param @param name
	 * @param @param organId
	 * @param @param startDate
	 * @param @param sessionId
	 * @param @return
	 * @param @throws BusinessException 
	 * @return String 
	 * @throws
	 */
	public String createEmployeeSchedule(String name, String organId,
			String startDate, String note,String sessionId) throws BusinessException;

	/**
	 * 
	 * @Description: 更新班次信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param name
	 * @param @param id
	 * @param @param startDate
	 * @param @throws BusinessException 
	 * @return void 
	 * @throws
	 */
	public void updateEmployeeSchedule(String name, String id,
			String startDate, String note) throws BusinessException;

	/**
	 * 删除班次信息
	 * 
	 * @param id
	 */
	public void deleteEmployeeSchedule(String id);

	/**
	 * 班次与员工组建立绑定关系
	 * 
	 * @param jsonString
	 */
	public void bindScheduleGroup(String jsonString) throws BusinessException;
	
	/**
	 * 
	 * @Description: 班次时间段规则设置
	 * @author zhuanqi@megaeyes.com
	 * @param @param scheduleId
	 * @param @param ruleId 
	 * @return void 
	 * @throws
	 */
	public void setScheduleWorkRule(String scheduleId,String ruleId);

	/**
	 * 
	 * @Description: 根据机构查询排班班次列表
	 * @author zhuanqi@megaeyes.com
	 * @param @param organId
	 * @param @return
	 * @return List<AcEmployeeSchedule>
	 * @throws
	 */
	public List<AcEmployeeSchedule> getScheduleListByOrganId(String organId);

}
