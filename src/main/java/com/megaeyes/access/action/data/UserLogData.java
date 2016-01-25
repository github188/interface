package com.megaeyes.access.action.data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Title: UserLogData.java
 * @Package com.megaeyes.access.action.data
 * @Description: 操作日志模型
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-19 上午08:14:57
 * @version V1.0
 */
public class UserLogData implements Serializable {

	private static final long serialVersionUID = 723655162286948830L;

	public UserLogData() {

		super();
	}

	/** id */

	private String m_naming;

	private String m_id;

	/** 运营商用户id（日志性质决定，需要冗余） */
	private String m_userId;

	/** 运营商用户名（日志性质决定，需要冗余） */
	private String m_userName;

	/** 用户会话id（日志性质决定，需要冗余） */
	private String m_userSessionId;

	/** 目标的类型（日志性质决定，需要冗余） */
	private String m_targetType;

	/** 时间 */
	private long m_time;

	/** IP地址 */
	private String m_ip;

	/** 目标的id（日志性质决定，需要冗余） */
	private String m_targetId;

	/** 运营商用户操作id（日志性质决定，需要冗余） */
	private String m_operationId;

	/** 目标的名字或描述（日志性质决定，需要冗余） */
	private String m_targetName;

	/** 运营商用户操作结果id（日志性质决定，需要冗余） */
	private String m_effectId;

	/** 运营商用户操作结果的名称（日志性质决定，需要冗余） */
	private String m_effectName;

	/** 运营商用户操作的名称（日志性质决定，需要冗余） */
	private String m_operationName;

	public String getNaming() {

		return this.m_naming;
	}

	public void setNaming(String naming) {

		this.m_naming = naming;
	}

	public String getId() {

		return this.m_id;
	}

	public void setId(String id) {

		this.m_id = id;
	}

	public String getUserId() {

		return this.m_userId;
	}

	public void setUserId(String userId) {

		this.m_userId = userId;
	}

	public String getUserName() {

		return this.m_userName;
	}

	public void setUserName(String userName) {

		this.m_userName = userName;
	}

	public String getUserSessionId() {

		return this.m_userSessionId;
	}

	public Date getTime() {

		return new Date(this.m_time);
	}

	public void setTime(long time) {

		this.m_time = time;
	}

	public String getIp() {
		return m_ip;
	}

	public void setIp(String ip) {
		this.m_ip = ip;
	}

	public String getTargetType() {

		return this.m_targetType;
	}

	public void setTargetType(String targetType) {

		this.m_targetType = targetType;
	}

	public String getTargetId() {

		return this.m_targetId;
	}

	public void setTargetId(String targetId) {

		this.m_targetId = targetId;
	}

	public String getTargetName() {

		return this.m_targetName;
	}

	public void setTargetName(String targetName) {

		this.m_targetName = targetName;
	}

	public String getOperationId() {

		return this.m_operationId;
	}

	public void setOperationId(String operationId) {

		this.m_operationId = operationId;
	}

	public String getOperationName() {

		return this.m_operationName;
	}

	public void setOperationName(String operationName) {

		this.m_operationName = operationName;
	}

	public String getEffectId() {

		return this.m_effectId;
	}

	public void setEffectId(String effectId) {

		this.m_effectId = effectId;
	}

	public String getEffectName() {

		return this.m_effectName;
	}

	public void setEffectName(String effectName) {

		this.m_effectName = effectName;
	}

}