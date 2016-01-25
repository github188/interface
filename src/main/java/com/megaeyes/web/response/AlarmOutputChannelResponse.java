/**   
 * @Title: AlarmOutputChannelResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-27 上午10:26:22 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;

/**
 * @ClassName: AlarmOutputChannelResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-27 上午10:26:22
 * 
 */
public class AlarmOutputChannelResponse extends BaseResponse {
	private AlarmOutputChannel aoc;
	private String code;

	public AlarmOutputChannel getAoc() {
		return aoc;
	}

	public void setAoc(AlarmOutputChannel aoc) {
		this.aoc = aoc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
