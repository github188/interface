/**   
 * @Title: listVisModelResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-11 上午9:54:35 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.VideoInputServerModel;

/**
 * @ClassName: listVisModelResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-11 上午9:54:35
 * 
 */
public class listVisModelResponse extends BaseResponse {
	private List<VideoInputServerModel> list;
	private String code;

	public List<VideoInputServerModel> getList() {
		return list;
	}

	public void setList(List<VideoInputServerModel> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
