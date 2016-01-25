package com.megaeyes.access.action.datapackage;


/**
 * <p>
 * Title: 服务代理程序
 * </p>
 * <p>
 * Description: 负责J2EE平台同接入服务器之间的数据交互
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: 北京互信互通信息技术有限公司
 * </p>
 * 
 * @author 潘登
 * @version 0.1
 */

public class RequestDataPackage extends DataPackage {
	private byte[] sourceID; // 源编号

	private byte[] destinationID; // 目标编号

	public void setSourceID(byte[] srcID) {
		sourceID = srcID;
	}

	public byte[] getSourceID() {
		return sourceID;
	}

	public void setDestinationID(byte[] destID) {
		destinationID = destID;
	}

	public byte[] getDestinationID() {
		return destinationID;
	}

	public String toString() {
		return new StringBuffer().append(super.toString())
				.append(", sourceID:").append(new String(sourceID))
				.append(", destinationID:").append(new String(destinationID))
				.append(" ]").toString();
	}
}