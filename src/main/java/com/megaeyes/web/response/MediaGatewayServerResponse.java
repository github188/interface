package com.megaeyes.web.response;

import java.math.BigDecimal;

/**
 * MediaGatewayServerResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-7-19 上午05:50:27
 */
public class MediaGatewayServerResponse extends BaseResponse {

	private String id;
    private String deviceNumber;
    private String lanIp;
    private String wanIp;
    private Integer msgPort;
    private BigDecimal heartbeatTime;
    private Short status;
    private String installLocation;
    private Integer heartbeatCycle;
    private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public String getLanIp() {
		return lanIp;
	}
	public void setLanIp(String lanIp) {
		this.lanIp = lanIp;
	}
	public String getWanIp() {
		return wanIp;
	}
	public void setWanIp(String wanIp) {
		this.wanIp = wanIp;
	}
	public Integer getMsgPort() {
		return msgPort;
	}
	public void setMsgPort(Integer msgPort) {
		this.msgPort = msgPort;
	}
	public BigDecimal getHeartbeatTime() {
		return heartbeatTime;
	}
	public void setHeartbeatTime(BigDecimal heartbeatTime) {
		this.heartbeatTime = heartbeatTime;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getInstallLocation() {
		return installLocation;
	}
	public void setInstallLocation(String installLocation) {
		this.installLocation = installLocation;
	}
	public Integer getHeartbeatCycle() {
		return heartbeatCycle;
	}
	public void setHeartbeatCycle(Integer heartbeatCycle) {
		this.heartbeatCycle = heartbeatCycle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
