package com.megaeyes.persistence.ibatis.vo;

/**
 * 摄像头存储服务器对象
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-5-10 上午09:14:57
 */
public class VicStorageServerVO {
	private String planServerIp;
	private String planServerPort;
	private String alarmServerIp;
	private String alarmServerPort;

	public String getPlanServerIp() {
		return planServerIp;
	}

	public void setPlanServerIp(String planServerIp) {
		this.planServerIp = planServerIp;
	}

	public String getPlanServerPort() {
		return planServerPort;
	}

	public void setPlanServerPort(String planServerPort) {
		this.planServerPort = planServerPort;
	}

	public String getAlarmServerIp() {
		return alarmServerIp;
	}

	public void setAlarmServerIp(String alarmServerIp) {
		this.alarmServerIp = alarmServerIp;
	}

	public String getAlarmServerPort() {
		return alarmServerPort;
	}

	public void setAlarmServerPort(String alarmServerPort) {
		this.alarmServerPort = alarmServerPort;
	}
}
