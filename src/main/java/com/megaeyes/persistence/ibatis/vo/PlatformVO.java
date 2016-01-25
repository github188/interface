package com.megaeyes.persistence.ibatis.vo;

/**
 * 互联平台配置属性对象，对应upper_platform.properties的配置
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-12 下午02:56:24
 */
public class PlatformVO {
	private String ip; // 上级平台IP
	private String port; // 上级平台http协议通信端口
	private String code; // 上级平台18位国标地址编码

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
