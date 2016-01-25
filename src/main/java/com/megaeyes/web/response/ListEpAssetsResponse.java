/**   
* @Title: ListEpAssetsResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-6 上午1:41:35 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpAssets;
import com.megaeyes.persistence.ibatis.vo.EpAssetsAndDeviceVO;

/** 
 * @ClassName: ListEpAssetsResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-6 上午1:41:35 
 *  
 */
public class ListEpAssetsResponse extends BaseResponse {
	private List<EpAssetsAndDeviceVO> epAssets;

	public List<EpAssetsAndDeviceVO> getEpAssets() {
		return epAssets;
	}

	public void setEpAssets(List<EpAssetsAndDeviceVO> epAssets) {
		this.epAssets = epAssets;
	}

	
}
