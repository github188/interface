/**   
* @Title: ListEpProberTypeResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-10 上午7:49:57 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpProberType;

/** 
 * @ClassName: ListEpProberTypeResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-10 上午7:49:57 
 *  
 */
public class ListEpProberTypeResponse extends BaseResponse{
	private List<EpProberType> epProberType;

	public List<EpProberType> getEpProberType() {
		return epProberType;
	}

	public void setEpProberType(List<EpProberType> epProberType) {
		this.epProberType = epProberType;
	}
}
