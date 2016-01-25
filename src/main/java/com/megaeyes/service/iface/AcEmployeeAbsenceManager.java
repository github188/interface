package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcEmployeeAbsenceRecord;
import com.megaeyes.persistence.ibatis.model.AcEmployeeAbsenceRecordExample;
import com.megaeyes.persistence.ibatis.vo.AcEmployeeAbsentRecordVO;

/**
 * 
 * @Title: AcEmployeeAbsentManager.java
 * @Package com.megaeyes.service.iface
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhuanqi@megaeyes.com
 * @date 2013-1-9 上午03:06:04
 * @version V2.5
 */
public interface AcEmployeeAbsenceManager extends BaseManager {

	/**
	 * 
	 * @Description: 创建员工请假记录
	 * @author zhuanqi@megaeyes.com
	 * @param @param type
	 * @param @param employeeId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param approver
	 * @param @param note
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String createEmployeeAbsent(String sessionId,String type, String employeeId, String startTime, String endTime, 
			String approver, String note,String branchId, String organId,String startDate,String endDate);

	/**
	 * 
	 * @Description: 修改员工请假记录
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @param type
	 * @param @param employeeId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param approver
	 * @param @param note
	 * @return void
	 * @throws
	 */
	public void updateEmployeeAbsent(String id , String type, String employeeId, String startTime, String endTime, 
			String approver, String note,String branchId, String organId,String startDate,String endDate) ;
	
	/**
	 * 
	 * @Description: 删除员工请假记录
	 * @author zhuanqi@megaeyes.com
	 * @param @param id 
	 * @return void 
	 * @throws
	 */
	public void deleteEmployeeAbsent(String id);
	
	/**
	 * 
	 * @Description: 根据条件查询请假记录 
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return List<AcEmployeeAbsentRecord> 
	 * @throws
	 */
	public List<AcEmployeeAbsenceRecord> selectByExample(AcEmployeeAbsenceRecordExample example);
	
	/**
	 * 
	 * @Description: 根据部门ID查询员工请假记录
	 * @author zhuanqi@megaeyes.com
	 * @param @param branchId
	 * @param @return 
	 * @return List<AcEmployeeAbsentRecordVO> 
	 * @throws
	 */
	public List<AcEmployeeAbsentRecordVO> getAbsentListByBranchId(String branchId);

}
