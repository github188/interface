/**   
* @Title: VideoOutputChannelDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-26 上午6:00:09 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.VideoOutputChannelDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpGatherServer;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;

/** 
 * @ClassName: VideoOutputChannelDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-26 上午6:00:09 
 *  
 */
public class VideoOutputChannelDAOiBatis extends VideoOutputChannelDAOImpl {
	/**
	* @Title: listVideoOutputChannel 
	* @Description: 根据显示服务器ID查询视频输出通道列表 
	* @param @return    设定文件 
	* @return List<VideoOutputChannel>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<VideoOutputChannel> listVocByDisplayId(String displayId) {
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_OUTPUT_CHANNEL_VIEW.listVocByDisplayId", displayId);
	}
	
	/**
	* @Title: listVocByOrganId 
	* @Description: 根据机构ID查询视频输出通道列表
	* @param organId
	* @return List<VideoOutputChannel>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<VideoOutputChannel> listVocByOrganId(String organId){
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_OUTPUT_CHANNEL_VIEW.listVocByOrganId", organId);
	}
	/**
	 * 
	* @Title: listVOCByOrganIdWithChild 
	* @Description: 查询本机构以及子机构下的所有视频输出通道
	* @param @param organId
	* @param @return    设定文件 
	* @return List<VideoOutputChannel>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<VideoOutputChannel> listVOCByOrganIdWithChild(String organId){
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_OUTPUT_CHANNEL_VIEW.listVOCByOrganIdWithChild", organId);
	}
	
	
}
