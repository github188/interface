package com.megaeyes.access.action.data;

import java.io.Serializable;


/**
 * 
 * @Title: DeviceInfoDTO.java 
 * @Package com.megaeyes.access.action.data 
 * @Description: 权限验证返回实体
 * @author zhuanqi@megaeyes.com   
 * @date 2012-11-29 上午07:28:24 
 * @version V1.0
 */
public class DeviceInfoDTO implements Serializable

{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2013504053677942914L;

	private String userId;

	private String id;

	private String naming;

	private String deviceType;

	private String deviceNumber;

	private String name;

	private String deviceIp;

	private String address;

	private String note;

	private String alarmOutTypeID;

	private String alarmOutTypeName;

	private int totalpage = 0;

	private String dispatchServerId;

	public String getDispatchServerId() {
		return dispatchServerId;
	}

	public void setDispatchServerId(String dispatchServerId) {
		this.dispatchServerId = dispatchServerId;
	}

	public void setAlarmOutTypeID(String alarmOutTypeID) {

		this.alarmOutTypeID = alarmOutTypeID;
	}

	public String getAlarmOutTypeID() {

		return alarmOutTypeID;
	}

	public void setAlarmOutTypeName(String alarmOutTypeName) {

		this.alarmOutTypeName = alarmOutTypeName;
	}

	public String getAlarmOutTypeName() {

		return alarmOutTypeName;
	}

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getNaming() {

		return naming;
	}

	public void setNaming(String naming) {

		this.naming = naming;
	}

	public String getDeviceType() {

		return deviceType;
	}

	public void setDeviceType(String deviceType) {

		this.deviceType = deviceType;
	}

	public void setDeviceNumber(String deviceNumber) {

		this.deviceNumber = deviceNumber;
	}

	public void setName(String name) {

		this.name = name;
	}

	public void setNote(String note) {

		this.note = note;
	}

	public String getNote() {

		return note;
	}

	public void setDeviceIp(String deviceIp) {

		this.deviceIp = deviceIp;
	}

	public String getDeviceNumber() {

		return deviceNumber;
	}

	public String getName() {

		return name;
	}

	public String getDeviceIp() {

		return deviceIp;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public int getTotalpage() {

		return totalpage;
	}

	public void setTotalpage(int totalpage) {

		this.totalpage = totalpage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}