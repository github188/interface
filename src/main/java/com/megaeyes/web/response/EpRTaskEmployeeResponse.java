/**   
 * @Title: EpRTaskEmployeeResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-11 上午9:43:31 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpRTaskEmployee;
import com.megaeyes.persistence.ibatis.vo.EpRTaskEmployeeDetailVO;

/**
 * @ClassName: EpRTaskEmployeeResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-11 上午9:43:31
 * 
 */
public class EpRTaskEmployeeResponse extends BaseResponse {
	private List<EpRTaskEmployeeDetailVO> list;
	private String code;

	public List<EpRTaskEmployeeDetailVO> getList() {
		return list;
	}

	public void setList(List<EpRTaskEmployeeDetailVO> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
