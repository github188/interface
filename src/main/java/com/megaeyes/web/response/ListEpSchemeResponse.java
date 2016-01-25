/**   
* @Title: ListEpSchemeResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-16 上午8:36:17 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpScheme;

/** 
 * @ClassName: ListEpSchemeResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-16 上午8:36:17 
 *  
 */
public class ListEpSchemeResponse extends BaseResponse {
	private List<EpScheme> es;
	private String code;
	public List<EpScheme> getEs() {
		return es;
	}
	public void setEs(List<EpScheme> es) {
		this.es = es;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
