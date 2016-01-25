/**   
 * @Title: ListOperationByRoleId.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-6 下午4:48:52 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

/**
 * @ClassName: ListOperationByRoleId
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-6 下午4:48:52
 * 
 */
public class ListOperationByRoleId {
	private String operationId;
	private String roleId;
	private String roleName;
	private String organId;
	private String createUserName;
	private String operationName;
	private String note;
	private String operationParentId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOperationParentId() {
		return operationParentId;
	}

	public void setOperationParentId(String operationParentId) {
		this.operationParentId = operationParentId;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

}
