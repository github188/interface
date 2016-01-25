/**   
 * @Title: ListOrganVOResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-29 下午2:36:22 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListOrganVO;

/**
 * @ClassName: ListOrganVOResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-29 下午2:36:22
 * 
 */
public class ListOrganVOResponse extends BaseResponse {
	private List<ListOrganVO> organs;
	private String code;

	public List<ListOrganVO> getOrgans() {
		return organs;
	}

	public void setOrgans(List<ListOrganVO> organs) {
		this.organs = organs;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
