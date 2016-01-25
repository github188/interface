package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcEmployeeGroup;
import com.megaeyes.service.exception.BusinessException;

/**
 * 
 * @Title: AcEmployeeGroupManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhuanqi@megaeyes.com   
 * @date 2013-1-8 上午09:14:24 
 * @version V2.5
 */
public interface AcEmployeeGroupManager extends BaseManager{
	
	/**
	 * 
	 * @Description: 创建员工组 
	 * @author zhuanqi@megaeyes.com
	 * @param @param organId
	 * @param @param name
	 * @param @param note
	 * @param @return
	 * @param @throws BusinessException 
	 * @return String 
	 * @throws
	 */
	public String createEmployeeGroup(String organId,String name,String note,String sessionId) throws BusinessException;


	/**
	 * 
	 * @Description: 删除员工组
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @throws BusinessException 
	 * @return void 
	 * @throws
	 */
	public void deleteEmployeeGroup(String id) throws BusinessException;

	/**
	 * 
	 * @Description: 修改员工组
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @param name
	 * @param @param note
	 * @param @return
	 * @param @throws BusinessException 
	 * @throws
	 */
	public void updateEmployeeGroup(String id,String name,String note) throws BusinessException;

	
	/**
	 * 
	 * @Description: 员工-员工组绑定
	 * @author zhuanqi@megaeyes.com
	 * @param @param jsonString
	 * @param @return
	 * @param @throws BusinessException 
	 * @throws
	 */
	public void bindEmployeesToGroup(String jsonString) throws BusinessException;


	/**
	 * 
	 * @Description: 根据机构ID查询员工组列表
	 * @author zhuanqi@megaeyes.com
	 * @param @param organId
	 * @param @return 
	 * @return List<AcEmployeeGroup> 
	 * @throws
	 */
	public List<AcEmployeeGroup> getGroupListByOrganId(String organId);
	
	/**
	 * 
	 * @Description:根据排班计划ID查询员工组列表
	 * @author zhuanqi@megaeyes.com
	 * @param @param scheduleId
	 * @param @return 
	 * @return List<AcEmployeeGroup> 
	 * @throws
	 */
	public List<AcEmployeeGroup> getGroupListByScheduleId(String scheduleId);

}
