/**   
* @Title: GetOrganByIdResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-3-14 下午4:09:00 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import com.megaeyes.persistence.ibatis.vo.OrganVO;

/** 
 * @ClassName: GetOrganByIdResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com  
 * @date 2012-3-14 下午4:09:00 
 *  
 */
public class GetOrganByIdResponse extends BaseResponse {
	private OrganVO organ;
	public OrganVO getOrgan() {
		return organ;
	}
	public void setOrgan(OrganVO organ) {
		this.organ = organ;
	}
	
}
