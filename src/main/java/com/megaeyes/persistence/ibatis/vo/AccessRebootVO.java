package com.megaeyes.persistence.ibatis.vo;

import java.util.List;

/**
 * 
 * @Title: AccessRebootVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: 接入重启注册VO
 * @author zhuanqi@megaeyes.com   
 * @date 2012-9-4 下午02:36:42 
 * @version V1.0
 */
public class AccessRebootVO {
	private String m_ip = null;

	private List<?> storageServerList;
	
	private List<?> dispatchServerList;

	public void setIp(String ip) {
		this.m_ip = ip;
	}

	public String getIp() {

		return this.m_ip;
	}
	
	public List<?> getStorageServerList() {
		return storageServerList;
	}

	public void setStorageServerList(List<?> storageServerList) {
		this.storageServerList = storageServerList;
	}
	
	public List<?> getDispatchServerList() {
		return dispatchServerList;
	}

	public void setDispatchServerList(List<?> dispatchServerList) {
		this.dispatchServerList = dispatchServerList;
	}
}
