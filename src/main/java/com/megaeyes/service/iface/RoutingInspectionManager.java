/**   
 * @Title: RoutingInspectionManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-7 下午5:23:55 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.json.JSONException;

import com.megaeyes.persistence.ibatis.model.EpTaskHistory;
import com.megaeyes.persistence.ibatis.model.EpTaskInspection;
import com.megaeyes.persistence.ibatis.model.EpTaskStepHistory;
import com.megaeyes.persistence.ibatis.vo.EpRTaskEmployeeDetailVO;
import com.megaeyes.persistence.ibatis.vo.EpTaskVO;

/**
 * @ClassName: RoutingInspectionManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-7 下午5:23:55
 * 
 */
public interface RoutingInspectionManager extends BaseManager {
	/**
	 * @Title: listEpTaskInspection
	 * @Description: TODO(查询所有巡查任务)
	 * @param @return 设定文件
	 * @return List<EpTaskInspection> 返回类型
	 * @throws
	 */
	public List<EpTaskInspection> listEpTaskInspection() ;

	/**
	 * @throws JSONException 
	* @Title: operateEpTaskInspection 
	* @Description: TODO(增加删除修改所有检查项) 
	* @param jsonString
	* @param @return    设定文件 
	* @return List<EpTaskInspection>    返回类型 
	* @throws
	 */
	public void operateEpTaskInspection(String jsonString) throws JSONException;
	/**
	 * @Title: createEpTask
	 * @Description: TODO(创建巡检计划)
	 * @param jsonString
	 * @param @return
	 * @param @throws JSONException 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String createEpTask(String jsonString) throws JSONException;

	/**
	 * @Title: deleteTask
	 * @Description: TODO(删除巡检计划)
	 * @param taskId
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteTask(String taskId);

	/**
	 * @Title: listEpTask
	 * @Description: TODO(根据机构ID查询巡检计划)
	 * @param organId
	 * @param @return 设定文件
	 * @return List<EpTask> 返回类型
	 * @throws
	 */
	public List<EpTaskVO> listEpTaskByOrganId(String organId);

	/**
	 * @Title: listTaskDetail
	 * @Description: TODO(根据taskid查询巡检佳话详细信息)
	 * @param taskId
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */

	public Map listTaskDetail(String taskId);

	/**
	 * @Title: updateEpTask
	 * @Description: TODO(更新巡检计划)
	 * @param jsonString
	 * @param @throws JSONException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateEpTask(String jsonString) throws JSONException;

	/**
	 * 
	 * @Title: createEpRTaskEmployee
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param taskId
	 *            巡检计划ID
	 * @param employeeId
	 *            职工ID
	 * @param userId
	 *            登录用户ID
	 * @param allotUserId
	 *            发布巡检任务用户ID
	 * @param executeTime
	 *            执行时间
	 * @param executeTimeType
	 *            执行类型
	 * @param taskType
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String createEpRTaskEmployee(String taskId, String employeeId,
			String userId, String allotUserId, String executeTime,
			BigDecimal executeTimeType, BigDecimal taskType,
			String supportEmployee);

	/**
	 * @Title: ListEpRTaskEmployee
	 * @Description: TODO(根据条件查询巡检计划)
	 * @param taskId
	 *            巡检计划ID
	 * @param employeeId
	 *            职工ID
	 * @param userId
	 *            登录用户ID
	 * @param allotUserId
	 *            发布巡检任务用户ID
	 * @param executeTime
	 *            执行时间
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public List<EpRTaskEmployeeDetailVO> ListEpRTaskEmployee(String taskId,
			String employeeId, String userId, String allotUserId,
			String executeTime);

	/**
	 * @Title: deleteEpRTaskEmployee
	 * @Description: TODO(删除巡检任务分配)
	 * @param id
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteEpRTaskEmployee(String id);

	/**
	 * 
	 * @Title: finishTask
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param jsonString
	 * @param @throws JSONException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void finishTask(String jsonString) throws JSONException;

	/**
	 * 
	 * @Title: listEpTaskHistory
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param startTime
	 * @param endTime
	 * @param taskId
	 * @param organName
	 * @param branchName
	 * @param employeeName
	 * @param userId
	 * @param allotUserId
	 * @param @return 设定文件
	 * @return List<EpTaskHistory> 返回类型
	 * @throws
	 */
	public List<EpTaskHistory> listEpTaskHistory(String startTime,
			String endTime, String taskId, String organName, String branchName,
			String employeeName, String userId, String allotUserId,String employeeId);

	/**
	 * 
	 * @Title: listEpTaskStepHistory
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param historyTaskId
	 * @param @return 设定文件
	 * @return List<EpTaskStepHistory> 返回类型
	 * @throws
	 */
	public List<EpTaskStepHistory> listEpTaskStepHistory(String historyTaskId);
}
