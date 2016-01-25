package com.megaeyes.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.VideoInputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.service.iface.VICManager;

/**
 * 
 * @Title: VICManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: 摄像头管理接口实现类
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-27 下午04:13:30 
 * @version V1.0
 */
public class VICManagerImpl extends BaseManagerImpl implements VICManager{

	@Autowired
	private VideoInputChannelDAOiBatis VideoInputChannelDAO;
	
	@Override
	public List<VideoInputChannel> getVicListByRemoteStorageServerId(String remoteStorageServerId) {
		return VideoInputChannelDAO.getVicListByRemoteStorageServerId(remoteStorageServerId);
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
	public int getVicCountByRemoteStorageId(String remoteStorageServerId){
		return VideoInputChannelDAO.getVicCountByRemoteStorageId(remoteStorageServerId);
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
	public List<VideoInputChannel> getVicListByRemoteStorageIdWithPage(String remoteStorageServerId,int start,int end){
		return VideoInputChannelDAO.getVicListByRemoteStorageIdWithPage(remoteStorageServerId, start, end);
	}

}
