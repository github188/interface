/**   
 * @Title: EpTaskResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-11 上午11:07:39 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpTask;
import com.megaeyes.persistence.ibatis.vo.EpTaskVO;

/**
 * @ClassName: EpTaskResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-11 上午11:07:39
 * 
 */
public class EpTaskResponse extends BaseResponse {
	private List<EpTaskVO> list;
	private String code;
	public List<EpTaskVO> getList() {
		return list;
	}
	public void setList(List<EpTaskVO> list) {
		this.list = list;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
