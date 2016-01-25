/**   
 * @Title: EpRTaskstepMonitorDetailVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-18 上午10:15:36 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/**
 * @ClassName: EpRTaskstepMonitorDetailVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-18 上午10:15:36
 * 
 */
public class EpRTaskEmployeeDetailVO {
	private String id;

	private String taskId;

	private String employeeId;

	private String userId;

	private String allotUserId;

	private String executeTime;

	private BigDecimal executeTimeType;

	private BigDecimal taskType;

	private String supportEmployee;

	private String taskname;

	private String taskNote;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAllotUserId() {
		return allotUserId;
	}

	public void setAllotUserId(String allotUserId) {
		this.allotUserId = allotUserId;
	}

	public String getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}

	public BigDecimal getExecuteTimeType() {
		return executeTimeType;
	}

	public void setExecuteTimeType(BigDecimal executeTimeType) {
		this.executeTimeType = executeTimeType;
	}

	public BigDecimal getTaskType() {
		return taskType;
	}

	public void setTaskType(BigDecimal taskType) {
		this.taskType = taskType;
	}

	public String getSupportEmployee() {
		return supportEmployee;
	}

	public void setSupportEmployee(String supportEmployee) {
		this.supportEmployee = supportEmployee;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskNote() {
		return taskNote;
	}

	public void setTaskNote(String taskNote) {
		this.taskNote = taskNote;
	}

}
