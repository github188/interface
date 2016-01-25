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

public class ResponseDataPackage extends DataPackage {

	private int nSuccess; // 成功标志

	public void setNSuccess(int success) {
		nSuccess = success;
	}

	public int getNSuccess() {
		return nSuccess;
	}

	public String toString() {
		return new StringBuffer().append(super.toString())
				.append(", nSuccess:").append(nSuccess).append(" ]").toString();
	}
}