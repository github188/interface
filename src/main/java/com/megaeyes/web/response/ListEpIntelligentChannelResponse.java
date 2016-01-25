/**   
* @Title: EpIntelligentChannelResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-30 上午2:54:56 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpIntelligentChannel;

/** 
 * @ClassName: EpIntelligentChannelResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-30 上午2:54:56 
 *  
 */
public class ListEpIntelligentChannelResponse extends BaseResponse {
	private List<EpIntelligentChannel> epIntelligentChannel;

	public List<EpIntelligentChannel> getEpIntelligentChannel() {
		return epIntelligentChannel;
	}

	public void setEpIntelligentChannel(
			List<EpIntelligentChannel> epIntelligentChannel) {
		this.epIntelligentChannel = epIntelligentChannel;
	}
	
}
