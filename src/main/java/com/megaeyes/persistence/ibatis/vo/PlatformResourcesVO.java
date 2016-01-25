/**   
* @Title: PlatformResourcesVO.java 
* @Package com.megaeyes.persistence.ibatis.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-15 上午3:03:39 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.vo;

import com.megaeyes.persistence.ibatis.model.PlatformResources;

/** 
 * @ClassName: PlatformResourcesVO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-15 上午3:03:39 
 *  
 */
public class PlatformResourcesVO extends PlatformResources {

	private String modelName;

	private String parentId;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}