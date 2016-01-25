/**   
 * @Title: ListTaskDetailResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-11 上午11:18:06 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.vo.TaskStepVO;

/**
 * @ClassName: ListTaskDetailResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-11 上午11:18:06
 * 
 */
public class ListTaskDetailResponse extends BaseResponse {
	private Map list;
	private String code;

	public Map getList() {
		return list;
	}

	public void setList(Map list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
