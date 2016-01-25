/**   
 * @Title: CreateVicResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-23 下午4:49:34 
 * @version V1.0   
 */
package com.megaeyes.web.response;

/**
 * @ClassName: CreateVicResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-23 下午4:49:34
 * 
 */
public class CreateVicResponse extends BaseResponse {
	private String vicId; // 创建成功的vicId
	private String message; // 成功或失败编码

	public String getVicId() {
		return vicId;
	}

	public void setVicId(String vicId) {
		this.vicId = vicId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
