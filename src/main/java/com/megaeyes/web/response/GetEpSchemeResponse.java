/**   
* @Title: GetEpSchemeResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-18 上午2:03:20 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import com.megaeyes.persistence.ibatis.vo.EpSchemeVO;



/** 
 * @ClassName: GetEpSchemeResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-18 上午2:03:20 
 *  
 */
public class GetEpSchemeResponse extends BaseResponse {
	private EpSchemeVO scheme;

	public EpSchemeVO getScheme() {
		return scheme;
	}

	public void setScheme(EpSchemeVO scheme) {
		this.scheme = scheme;
	}
}
