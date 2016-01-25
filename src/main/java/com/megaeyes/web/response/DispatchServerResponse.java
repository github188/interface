/**   
* @Title: DispatchServerResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-2 上午5:58:20 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

/** 
 * @ClassName: DispatchServerResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-2 上午5:58:20 
 *  
 */
public class DispatchServerResponse extends BaseResponse {
	private String id;
	private String name;
	private String deviceNumber;
	private String installLocation;
	private String ip1; // 广域网IP
	private String ip2; // 局域网IP
	private String maxInputAmount;
	private String maxOutputAmount;
	private String reservedOutputAmount;
	private String heartCycle;
	private String ownerShip; // 所有权
	private String note;
	private String code; // 成功或者失败编码
	private String naming;

	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getInstallLocation() {
		return installLocation;
	}

	public void setInstallLocation(String installLocation) {
		this.installLocation = installLocation;
	}

	public String getIp1() {
		return ip1;
	}

	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}

	public String getIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public String getMaxInputAmount() {
		return maxInputAmount;
	}

	public void setMaxInputAmount(String maxInputAmount) {
		this.maxInputAmount = maxInputAmount;
	}

	public String getMaxOutputAmount() {
		return maxOutputAmount;
	}

	public void setMaxOutputAmount(String maxOutputAmount) {
		this.maxOutputAmount = maxOutputAmount;
	}

	public String getReservedOutputAmount() {
		return reservedOutputAmount;
	}

	public void setReservedOutputAmount(String reservedOutputAmount) {
		this.reservedOutputAmount = reservedOutputAmount;
	}

	public String getHeartCycle() {
		return heartCycle;
	}

	public void setHeartCycle(String heartCycle) {
		this.heartCycle = heartCycle;
	}

	public String getOwnerShip() {
		return ownerShip;
	}

	public void setOwnerShip(String ownerShip) {
		this.ownerShip = ownerShip;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
