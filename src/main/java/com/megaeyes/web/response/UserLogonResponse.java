/**   
 * @Title: UserLogonResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用户登录返回对象) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-2 下午1:06:56 
 * @version V1.0   
 */
package com.megaeyes.web.response;

/**
 * @ClassName: UserLogonResponse
 * @Description: TODO(用户登录返回对象)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-2 下午1:06:56
 * 
 */
public class UserLogonResponse extends BaseResponse {
	private String userId;
	private String sessionId;
	private String naming;
	private String isAdmin;
	private String priority;
	private String organId; // 用户所属机构ID
	private String organName;// 用户所属机构名
	private String userName;
	private String gis; // GIS地图视图可视权限
	private String video; // 视频监控可视权限
	private String historyVideo; // 录像可视权限
	private String door; // 门禁管理可视权限
	private String environment; // 环控界面可视权限
	private String solar; // 太阳能电池可视权限
	private String alarm; // 报警管理可视权限
	private String gatherServerIp;// 采集服务器IP
	private String gatherServerHttpPort;// 采集服务器端口
	private String platformStatus; // 平台状态
	private String branchId;// 部门id
	private String isBranchAdmin;// 是否部门管理员
	private String code;
	private String[] operations;// 所拥有的操作权限列表
	private String clientGatewayIp;// 客户端网关IP
	private String clientGatewayPort;// 客户端网关端口

	public String[] getOperations() {
		return operations;
	}

	public void setOperations(String[] operations) {
		this.operations = operations;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public String getGatherServerIp() {
		return gatherServerIp;
	}

	public void setGatherServerIp(String gatherServerIp) {
		this.gatherServerIp = gatherServerIp;
	}

	public String getGatherServerHttpPort() {
		return gatherServerHttpPort;
	}

	public void setGatherServerHttpPort(String gatherServerHttpPort) {
		this.gatherServerHttpPort = gatherServerHttpPort;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getGis() {
		return gis;
	}

	public void setGis(String gis) {
		this.gis = gis;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getHistoryVideo() {
		return historyVideo;
	}

	public void setHistoryVideo(String historyVideo) {
		this.historyVideo = historyVideo;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getSolar() {
		return solar;
	}

	public void setSolar(String solar) {
		this.solar = solar;
	}

	public String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

	public String getPlatformStatus() {
		return platformStatus;
	}

	public void setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
	}

	public String getClientGatewayIp() {
		return clientGatewayIp;
	}

	public void setClientGatewayIp(String clientGatewayIp) {
		this.clientGatewayIp = clientGatewayIp;
	}

	public String getClientGatewayPort() {
		return clientGatewayPort;
	}

	public void setClientGatewayPort(String clientGatewayPort) {
		this.clientGatewayPort = clientGatewayPort;
	}
}
