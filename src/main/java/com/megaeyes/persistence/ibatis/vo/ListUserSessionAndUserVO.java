package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/**
 * ListUserSessionAndUserVO(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-25 上午03:16:30
 */
public class ListUserSessionAndUserVO {
	private String id;
	private BigDecimal optimisticLock;
	private BigDecimal logonTime;
	private BigDecimal heartbeatTime;
	private String userId;
	private String ip;
	private String clientType;
	private String logonName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getOptimisticLock() {
		return optimisticLock;
	}
	public void setOptimisticLock(BigDecimal optimisticLock) {
		this.optimisticLock = optimisticLock;
	}
	public BigDecimal getLogonTime() {
		return logonTime;
	}
	public void setLogonTime(BigDecimal logonTime) {
		this.logonTime = logonTime;
	}
	public BigDecimal getHeartbeatTime() {
		return heartbeatTime;
	}
	public void setHeartbeatTime(BigDecimal heartbeatTime) {
		this.heartbeatTime = heartbeatTime;
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
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getLogonName() {
		return logonName;
	}
	public void setLogonName(String logonName) {
		this.logonName = logonName;
	}
}
