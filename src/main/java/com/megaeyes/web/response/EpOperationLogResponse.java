/**   
 * @Title: EpOperationLogResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-25 下午2:45:47 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpOperationLog;

/**
 * @ClassName: EpOperationLogResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-25 下午2:45:47
 * 
 */
public class EpOperationLogResponse extends BaseResponse {
	private List<EpOperationLog> list;
	private String code;

	public List<EpOperationLog> getList() {
		return list;
	}

	public void setList(List<EpOperationLog> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
