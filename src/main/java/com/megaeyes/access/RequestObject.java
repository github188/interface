package com.megaeyes.access;

/**
 * 请求参数
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-25 下午02:20:01
 */
public class RequestObject {

	private String messageId;
	private String accessId;
	private String xml;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}
}
