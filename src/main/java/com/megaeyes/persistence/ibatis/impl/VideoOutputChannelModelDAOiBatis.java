/**   
* @Title: VideoOutputChannelModelDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-1 上午8:54:30 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.VideoOutputChannelModelDAOImpl;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModel;

/** 
 * @ClassName: VideoOutputChannelModelDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-1 上午8:54:30 
 *  
 */
public class VideoOutputChannelModelDAOiBatis extends
		VideoOutputChannelModelDAOImpl {

	/**
	 * 
	 * listVOCModel 查询视频输出通道类型
	 * @return List<VideoOutputChannelModel>
	 */
	@SuppressWarnings("unchecked")
	public List<VideoOutputChannelModel> listVOCModel() {
		return getSqlMapClientTemplate().queryForList(
		"VIDEO_OUTPUT_CHANNEL_MODEL_VIEW.listVOCModel");
	}

}
