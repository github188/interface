/**   
 * @Title: AlarmInputChannelResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-26 下午4:49:38 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;

/**
 * @ClassName: AlarmInputChannelResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-26 下午4:49:38
 * 
 */
public class AlarmInputChannelResponse extends BaseResponse {

	private AlarmInputChannel aic;
	private String code;

	public AlarmInputChannel getAic() {
		return aic;
	}

	public void setAic(AlarmInputChannel aic) {
		this.aic = aic;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
