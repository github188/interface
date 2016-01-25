/**   
 * @Title: EpTaskVO.java 
 * @Package com.megaeyes.persistence.ibatis.model 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-14 上午10:01:33 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/**
 * @ClassName: EpTaskVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-14 上午10:01:33
 * 
 */
public class EpTaskVO {
	private String id;

	private String name;

	private String organId;

	private BigDecimal type;

	private String note;

	private BigDecimal createTime;

	private String branchId;

	private String supportEmployee;

	private String employeeId;

	private String userId;

	private String taskEmployeeId;
	
	private String executeTime;

	public String getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}

	public String getTaskEmployeeId() {
		return taskEmployeeId;
	}

	public void setTaskEmployeeId(String taskEmployeeId) {
		this.taskEmployeeId = taskEmployeeId;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public BigDecimal getType() {
		return type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getCreateTime() {
		return createTime;
	}

	public void setCreateTime(BigDecimal createTime) {
		this.createTime = createTime;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getSupportEmployee() {
		return supportEmployee;
	}

	public void setSupportEmployee(String supportEmployee) {
		this.supportEmployee = supportEmployee;
	}
}
