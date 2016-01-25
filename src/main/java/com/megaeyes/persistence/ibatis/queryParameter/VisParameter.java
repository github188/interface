/**   
 * @Title: VisParameter.java 
 * @Package com.megaeyes.persistence.ibatis.queryParameter 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-23 上午10:37:48 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.queryParameter;

/**
 * @ClassName: VisParameter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-23 上午10:37:48
 * 
 */
public class VisParameter extends BaseParameter {
	private String name;

	private String address;

	private String deviceNumber;

	private String organId;

	private String userId;

	private String lineBackFew;
	private String towerNumber;
	private String switchesIp;
	private String serialServerIp;
	private String voltageLevel;
	private String areaBelongs;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLineBackFew() {
		return lineBackFew;
	}

	public void setLineBackFew(String lineBackFew) {
		this.lineBackFew = lineBackFew;
	}

	public String getTowerNumber() {
		return towerNumber;
	}

	public void setTowerNumber(String towerNumber) {
		this.towerNumber = towerNumber;
	}

	public String getSwitchesIp() {
		return switchesIp;
	}

	public void setSwitchesIp(String switchesIp) {
		this.switchesIp = switchesIp;
	}

	public String getSerialServerIp() {
		return serialServerIp;
	}

	public void setSerialServerIp(String serialServerIp) {
		this.serialServerIp = serialServerIp;
	}

	public String getVoltageLevel() {
		return voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getAreaBelongs() {
		return areaBelongs;
	}

	public void setAreaBelongs(String areaBelongs) {
		this.areaBelongs = areaBelongs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
