package com.megaeyes.access.action.datapackage;

import com.megaeyes.access.exception.ExceptionHandler;

/**
 * 
 * @Title: DataPackage.java 
 * @Package com.megaeyes.access.action.datapackage 
 * @Description: megaeyes数据包 
 * @author zhuanqi@megaeyes.com   
 * @date 2012-12-3 上午05:34:52 
 * @version V1.0
 */
public abstract class DataPackage {
	static public int VERSION = 0x0001;

	protected int version; // 版本号

	protected int length; // BODY长度

	protected int messageID; // 指令编号

	protected int messageNo; // 指令序号

	protected byte[] body; // XML封装的数据内容

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setLength(int len) {
		length = len;
	}

	public int getLength() {
		return length;
	}

	public void setMessageID(int msgID) {
		messageID = msgID;
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageNo(int msgNo) {
		messageNo = msgNo;
	}

	public int getMessageNo() {
		return messageNo;
	}

	public void setBody(byte[] xmlBody) {
		body = xmlBody;
	}

	public byte[] getBody() {
		return body;
	}

	public String toString() {
		String strBody = null;

		try {
			strBody = new String(body == null ? new byte[0] : body, "UTF-8");
		} catch (java.io.UnsupportedEncodingException uee) {
			ExceptionHandler.throwRuntimeException(uee);
		}

		return new StringBuffer().append("[ version:").append(version)
				.append(", length:").append(length).append(", messageID:")
				.append(messageID).append(", messageNo:").append(messageNo)
				.append(", body:").append(strBody).toString();
	}

}