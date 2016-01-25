/**   
 * @Title: ListAlarmInputChannelResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-26 下午5:11:54 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.vo.AlarmInputChannelVO;

/**
 * @ClassName: ListAlarmInputChannelResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-26 下午5:11:54
 * 
 */
public class ListAlarmInputChannelResponse extends BaseResponse {
	private List<AlarmInputChannelVO> aics;

	private String message;

	public List<AlarmInputChannelVO> getAics() {
		return aics;
	}

	public void setAics(List<AlarmInputChannelVO> aics) {
		this.aics = aics;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
