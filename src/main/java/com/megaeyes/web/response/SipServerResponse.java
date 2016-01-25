package com.megaeyes.web.response;

import java.math.BigDecimal;

/**
 * SipServerResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-7-18 上午02:42:12
 */
public class SipServerResponse extends BaseResponse {
	private String id;
    private String name;
    private String lanIp;
    private Integer httpPort;
    private BigDecimal heartbeatTime;
    private String deviceNumber;
    private String registerType;
    private String wanIp;
    private Integer sipPort;
    private Integer megaPort;
    private String eventServerId;
    private String mediaGatewayServerId;
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
	public String getLanIp() {
		return lanIp;
	}
	public void setLanIp(String lanIp) {
		this.lanIp = lanIp;
	}
	public Integer getHttpPort() {
		return httpPort;
	}
	public void setHttpPort(Integer httpPort) {
		this.httpPort = httpPort;
	}
	public BigDecimal getHeartbeatTime() {
		return heartbeatTime;
	}
	public void setHeartbeatTime(BigDecimal heartbeatTime) {
		this.heartbeatTime = heartbeatTime;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public String getRegisterType() {
		return registerType;
	}
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	public String getWanIp() {
		return wanIp;
	}
	public void setWanIp(String wanIp) {
		this.wanIp = wanIp;
	}
	public Integer getSipPort() {
		return sipPort;
	}
	public void setSipPort(Integer sipPort) {
		this.sipPort = sipPort;
	}
	public Integer getMegaPort() {
		return megaPort;
	}
	public void setMegaPort(Integer megaPort) {
		this.megaPort = megaPort;
	}
	public String getEventServerId() {
		return eventServerId;
	}
	public void setEventServerId(String eventServerId) {
		this.eventServerId = eventServerId;
	}
	public String getMediaGatewayServerId() {
		return mediaGatewayServerId;
	}
	public void setMediaGatewayServerId(String mediaGatewayServerId) {
		this.mediaGatewayServerId = mediaGatewayServerId;
	}
    
}
