/**   
* @Title: GetVideoInputServerResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-3-23 下午2:05:06 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.UserVisVO;


/** 
 * @ClassName: GetVideoInputServerResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-3-23 下午2:05:06 
 *  
 */
public class GetVideoInputServerResponse extends BaseResponse {
	private List<UserVisVO> vis;
	
	private String totalCount;//符合查询条件的vis总数量

	private String message; // 成功或失败返回编码，成功为"０"

	public List<UserVisVO> getVis() {
		return vis;
	}

	public void setVis(List<UserVisVO> vis) {
		this.vis = vis;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
