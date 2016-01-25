package com.megaeyes.access.action.data;

import java.util.List;

import org.jdom.Element;

/**
 * 
 * @Title: FindDeviceNamingListData.java
 * @Package com.megaeyes.access.action.data
 * @Description: 请求参数模型
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-18 上午08:44:37
 * @version V1.0
 */
public class FindDeviceNamingListData {

	private Element userList = null;
	private Element plan = null;
	private Element alarmOutTime = null;
	private Element kinescopeTime = null;
	private Element aheadTime = null;
	private List<?> aoclist;
	private List<?> cameralist;

	public Element getUserList() {
		return userList;
	}

	public void setUserList(Element userList) {
		this.userList = userList;
	}

	public Element getPlan() {
		return plan;
	}

	public void setPlan(Element plan) {
		this.plan = plan;
	}

	public Element getAlarmOutTime() {
		return alarmOutTime;
	}

	public void setAlarmOutTime(Element alarmOutTime) {
		this.alarmOutTime = alarmOutTime;
	}

	public Element getKinescopeTime() {
		return kinescopeTime;
	}

	public void setKinescopeTime(Element kinescopeTime) {
		this.kinescopeTime = kinescopeTime;
	}

	public Element getAheadTime() {
		return aheadTime;
	}

	public void setAheadTime(Element aheadTime) {
		this.aheadTime = aheadTime;
	}

	public FindDeviceNamingListData() {
		super();
	}

	public List<?> getAoclist() {
		return aoclist;
	}

	public void setAoclist(List<?> aoclist) {
		this.aoclist = aoclist;
	}

	public List<?> getCameralist() {
		return cameralist;
	}

	public void setCameralist(List<?> cameralist) {
		this.cameralist = cameralist;
	}

}