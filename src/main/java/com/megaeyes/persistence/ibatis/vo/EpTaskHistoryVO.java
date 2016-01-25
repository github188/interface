/**   
 * @Title: EpTaskHistoryVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-16 上午10:46:47 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

/**
 * @ClassName: EpTaskHistoryVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-16 上午10:46:47
 * 
 */
public class EpTaskHistoryVO {
	private String startTime;
	private String endTime;
	private String taskId;
	private String organName;
	private String branchName;
	private String employeeName;
	private String userId;
	private String allotUserId;
	private String employeeId;
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
}
