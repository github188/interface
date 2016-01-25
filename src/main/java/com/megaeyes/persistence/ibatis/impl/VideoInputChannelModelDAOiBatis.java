/**   
* @Title: VideoInputChannelModelDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-3-23 下午2:29:44 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.VideoInputChannelModelDAOImpl;
import com.megaeyes.persistence.ibatis.model.VideoInputChannelModel;

/** 
 * @ClassName: VideoInputChannelModelDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-3-23 下午2:29:44 
 *  
 */
public class VideoInputChannelModelDAOiBatis extends
		VideoInputChannelModelDAOImpl {
	
	public List<VideoInputChannelModel> listVicModel(int start, int limit) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("start", start);
		queryMap.put("end", start + limit);
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_MODEL_VIEW.listVicModel", queryMap);
	}
	
	/**
	 * 调用此方法返回VIC Model的下一个ID，用于insert
	 * 
	 * @return VIDEOINPUTCHANNELMODEL_SEQ.nextval
	 */
	public String getVICModelSeq() {
		String id = (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getVideoInputChannelModelSeq", null);
		String prefix = "";
		for (int i = 31; i > id.length(); i--) {
			prefix += "0";
		}
		id = prefix + id;
		return id;
	}
}
