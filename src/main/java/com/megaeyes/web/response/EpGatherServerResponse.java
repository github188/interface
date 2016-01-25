/**   
* @Title: EpGatherServerResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-21 上午8:55:38 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

/** 
 * @ClassName: EpGatherServerResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-21 上午8:55:38 
 *  
 */
public class EpGatherServerResponse extends BaseResponse {
	private String id;
	private String organId;
	private String ip;
	private String name;
	private String note;
	private Long heartCycle;
	private String eventServerId;
	private String eventPort;
	private String clientPort;
	private String consoleListenerIp;
	private String consoleListenerPort;
	private String consolePassword;
	private String clientIp;
	private String eventIp;
	private String deviceNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getHeartCycle() {
		return heartCycle;
	}
	public void setHeartCycle(Long heartCycle) {
		this.heartCycle = heartCycle;
	}
	public String getEventServerId() {
		return eventServerId;
	}
	public void setEventServerId(String eventServerId) {
		this.eventServerId = eventServerId;
	}
	public String getEventPort() {
		return eventPort;
	}
	public void setEventPort(String eventPort) {
		this.eventPort = eventPort;
	}
	public String getClientPort() {
		return clientPort;
	}
	public void setClientPort(String clientPort) {
		this.clientPort = clientPort;
	}
	public String getConsoleListenerIp() {
		return consoleListenerIp;
	}
	public void setConsoleListenerIp(String consoleListenerIp) {
		this.consoleListenerIp = consoleListenerIp;
	}
	public String getConsoleListenerPort() {
		return consoleListenerPort;
	}
	public void setConsoleListenerPort(String consoleListenerPort) {
		this.consoleListenerPort = consoleListenerPort;
	}
	public String getConsolePassword() {
		return consolePassword;
	}
	public void setConsolePassword(String consolePassword) {
		this.consolePassword = consolePassword;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getEventIp() {
		return eventIp;
	}
	public void setEventIp(String eventIp) {
		this.eventIp = eventIp;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
}
