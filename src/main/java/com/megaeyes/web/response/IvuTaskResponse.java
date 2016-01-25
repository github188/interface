/**   
 * @Title: IvuTaskResponse.java 
 * @Package com.megaeyes.consoleinterface.web.response.bean.manager 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-6-18 下午4:37:56 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.IvuTask;


/**
 * @ClassName: IvuTaskResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-6-18 下午4:37:56
 * 
 */
public class IvuTaskResponse extends BaseResponse {
	private List<IvuTask> list;
	private String code;

	public List<IvuTask> getList() {
		return list;
	}

	public void setList(List<IvuTask> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
