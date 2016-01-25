package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.VideoInputChannel;

/**
 * 
 * @Title: VICManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: VICManager接口类
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-27 下午04:06:32 
 * @version V1.0
 */
public interface VICManager extends BaseManager{

	/**
	 * 
	 * @Description: 根据中心存储(3.0)编号查询其下挂的摄像头列表
	 * @author zhuanqi@megaeyes.com
	 * @param @param remoteStorageServerId
	 * @param @return 
	 * @return List<VideoInputChannel> 
	 * @throws
	 */
	public List<VideoInputChannel> getVicListByRemoteStorageServerId(String remoteStorageServerId);
	
	/**
	 * 
	 * @Description: 获取中心存储下挂的摄像头数目 
	 * @author zhuanqi@megaeyes.com
	 * @param @param remoteStorageServerId
	 * @param @return 
	 * @return int 
	 * @throws
	 */
	public int getVicCountByRemoteStorageId(String remoteStorageServerId);
	
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
	public List<VideoInputChannel> getVicListByRemoteStorageIdWithPage(String remoteStorageServerId,int start,int end);
}
