package com.megaeyes.web.response.xml;

/**
 * 信令网关的注册返回对象
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-5-2 上午11:22:43
 */
public class SipServerRegisterResponse extends BaseXMLResponse {
	private String code; // 18位平台地址编码
	private String eventIp; // 与信令绑定的事件服务器IP
	private String eventPort; // 与信令绑定的事件服务器端口
	private String mediaIp; // 媒体网关局域网IP
	private String mediaPort; // 媒体网关局域网端口

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEventIp() {
		return eventIp;
	}

	public void setEventIp(String eventIp) {
		this.eventIp = eventIp;
	}

	public String getEventPort() {
		return eventPort;
	}

	public void setEventPort(String eventPort) {
		this.eventPort = eventPort;
	}

	public String getMediaIp() {
		return mediaIp;
	}

	public void setMediaIp(String mediaIp) {
		this.mediaIp = mediaIp;
	}

	public String getMediaPort() {
		return mediaPort;
	}

	public void setMediaPort(String mediaPort) {
		this.mediaPort = mediaPort;
	}

}
