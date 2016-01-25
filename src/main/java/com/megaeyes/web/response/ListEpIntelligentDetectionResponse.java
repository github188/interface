/**   
* @Title: ListEpIntelligentDetectionResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-2 上午7:17:23 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.EpIntelligentDetectionAndDeviceVO;

/** 
 * @ClassName: ListEpIntelligentDetectionResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-2 上午7:17:23 
 *  
 */
public class ListEpIntelligentDetectionResponse extends BaseResponse {

	private List<EpIntelligentDetectionAndDeviceVO> epIntelligentDetection;

	public List<EpIntelligentDetectionAndDeviceVO> getEpIntelligentDetection() {
		return epIntelligentDetection;
	}

	public void setEpIntelligentDetection(
			List<EpIntelligentDetectionAndDeviceVO> epIntelligentDetection) {
		this.epIntelligentDetection = epIntelligentDetection;
	}
}
