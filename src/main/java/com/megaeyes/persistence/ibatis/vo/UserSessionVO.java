/**   
 * @Title: UserSessionVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-2 下午1:41:59 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

/**
 * @ClassName: UserSessionVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-2 下午1:41:59
 * 
 */
public class UserSessionVO {
	private String id; // sessionId
	private String logonTime; // 登录时间
	private String userId; // 登录用户ID
	private String ip; // 登录IP
	private String userName; // 用户LogonName
	private String organId; // 用户的机构Id
	private String organName; // 用户所属的机构名称
	private String isAdmin;// 是否管理员
	private String naming;// 用户naming
	private short priority;// 优先权
	private String grade; // 用户等级
	private String branchId;// 部门
	private String isBranchAdmin;//
	private String dispatchServerId; // 用户分发
	private Short isInnerUser; // 是否内网用户

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getIsBranchAdmin() {
		return isBranchAdmin;
	}

	public void setIsBranchAdmin(String isBranchAdmin) {
		this.isBranchAdmin = isBranchAdmin;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogonTime() {
		return logonTime;
	}

	public void setLogonTime(String logonTime) {
		this.logonTime = logonTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}

	public short getPriority() {
		return priority;
	}

	public void setPriority(short priority) {
		this.priority = priority;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDispatchServerId() {
		return dispatchServerId;
	}

	public void setDispatchServerId(String dispatchServerId) {
		this.dispatchServerId = dispatchServerId;
	}

	public Short getIsInnerUser() {
		return isInnerUser;
	}

	public void setIsInnerUser(Short isInnerUser) {
		this.isInnerUser = isInnerUser;
	}

}
