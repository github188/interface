package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.vo.VideoInputChannelAndSchemeVO;

/**
 * ListVICAndSchemeResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com 
 * <p />
 * 2013-3-4 上午01:57:21
 */
public class ListVICAndSchemeResponse extends BaseResponse {
	private List<VideoInputChannelAndSchemeVO> vicAndShceme = new ArrayList();
	private String code;
	public List<VideoInputChannelAndSchemeVO> getVicAndShceme() {
		return vicAndShceme;
	}
	public void setVicAndShceme(List<VideoInputChannelAndSchemeVO> vicAndShceme) {
		this.vicAndShceme = vicAndShceme;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
