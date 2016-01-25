package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.megaeyes.persistence.ibatis.iface.VideoInputChannelDAOImpl;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.vo.IpVICVO;
import com.megaeyes.persistence.ibatis.vo.ListVideoInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.ListVisByOrganIdVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;

public class VideoInputChannelDAOiBatis extends VideoInputChannelDAOImpl {

	/**
	 * 查询指定普通视频服务器下属的摄像头列表
	 * 
	 * @param visId
	 *            视频服务器ID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ListVideoInputChannelVO> listVicByVisId(String visId) {
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_VIEW.listVicByVisId", visId);
	}

	/**
	 * 查询指定IP视频服务器下属的摄像头列表
	 * 
	 * @param visId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<IpVICVO> listIpVicByVisId(String visId) {
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_VIEW.listIpVicByVisId", visId);
	}

	/**
	* @Title: listVicByOrganId 
	* @Description: TODO(根据organid查询摄像头列表) 
	* @param @param queryMap
	* @param @return    设定文件 
	* @return List<VideoInputChannel>    返回类型 
	* @throws
	 */
	public List<VideoInputChannel> listVicByOrganId(Map queryMap) {
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_VIEW.listGenVicByOrganId", queryMap);
	}
	
	/**
	* @Title: getVICSeq 
	* @Description: TODO(调用此方法返回VIC的下一个ID，用于insert) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String getVICSeq() {
		String id = (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getVideoInputChannelSeq", null);
		String prefix = "";
		for (int i = 31; i > id.length(); i--) {
			prefix += "0";
		}
		id = prefix + id;
		return id;
	}
	
	/**
	 * 查询指定普通视频服务器下属的摄像头列表
	 * 
	 * @param visId
	 *            视频服务器ID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<VideoInputChannel> listGenVicByVisId(String visId) {
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_VIEW.listGenVicByVisId", visId);
	}
	/**
	 * 查询指定ID的IP摄像头信息
	 * 
	 * @param id
	 *            摄像头ID
	 * @return IpVICVO
	 */
	public IpVICVO getIpVicById(String id) {
		return (IpVICVO) getSqlMapClientTemplate().queryForObject(
				"VIDEO_INPUT_CHANNEL_VIEW.getIpVicById", id);
	}
	/**
	 * 查询指定IP视频服务器下属已经注册的摄像头列表
	 * 
	 * @param visId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<VideoInputChannel> listRegisteredIpVicByVisId(String visId) {
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_VIEW.listRegisteredIpVicByVisId", visId);
	}
	
	/**
	 * 
	 * @Description: 查询中心存储下挂的摄像头列表 
	 * @author zhuanqi@megaeyes.com
	 * @param @param remoteStorageServerId
	 * @param @return 
	 * @return List<VideoInputChannel> 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<VideoInputChannel> getVicListByRemoteStorageServerId(String remoteStorageServerId){
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_VIEW.getVicListOfRemoteStorageServer",remoteStorageServerId);
	}
	
	/**
	 * 
	 * @Description: 查询视频服务器下的摄像头列表及配置信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return List<VideoInputChannelVO> 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<VideoInputChannelVO> getVicListByVisId(String visId){
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_VIEW.getVicListByVisId",visId);
	}
	
	/**
	 * 
	 * @Description: 查询视频服务器下的IP摄像头列表及配置信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return List<VideoInputChannelVO> 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<VideoInputChannelVO> getIpVicListByVisId(String visId){
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_VIEW.getIpVicListByVisId",visId);
	}
	
	/**
	 * 
	 * @Description: 分页获取指定中心存储下的摄像头列表
	 * @author zhuanqi@megaeyes.com
	 * @param @param remoteStorageServerId
	 * @param @param start
	 * @param @param end
	 * @param @return 
	 * @return List<VideoInputChannel> 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<VideoInputChannel> getVicListByRemoteStorageIdWithPage(String rssId,int start,int end){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("rssId", rssId);
		param.put("start", start);
		param.put("end", end);
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_CHANNEL_VIEW.getVicListByRemoteStorageId",param);
	}
	
	/**
	 * 
	 * @Description: 获取中心存储下挂的摄像头数目 
	 * @author zhuanqi@megaeyes.com
	 * @param @param remoteStorageServerId
	 * @param @return 
	 * @return int 
	 * @throws
	 */
	public int getVicCountByRemoteStorageId(String rssId){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("rssId", rssId);
		return (Integer)getSqlMapClientTemplate().queryForObject(
				"VIDEO_INPUT_CHANNEL_VIEW.getVicCountByRemoteStorageId",param);
	}
}
