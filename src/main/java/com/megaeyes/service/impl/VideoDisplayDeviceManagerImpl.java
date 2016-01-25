package com.megaeyes.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.iface.VideoDisplayDeviceDAO;
import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;
import com.megaeyes.persistence.ibatis.model.VideoDisplayDeviceExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.VideoDisplayDeviceManager;

/**
 *
 * @Title: VideoDisplayDeviceManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: 显示服务器接口实现类
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-24 下午01:41:49 
 * @version V1.0
 */
public class VideoDisplayDeviceManagerImpl extends BaseManagerImpl implements VideoDisplayDeviceManager{

	@Autowired
	private VideoDisplayDeviceDAO videoDisplayDeviceDAO;
	
	@SuppressWarnings("unchecked")
	public VideoDisplayDevice getVideoDisplayByDeviceNumber(String deviceNumber) {
		VideoDisplayDeviceExample example = new VideoDisplayDeviceExample();
		example.createCriteria().andDeviceNumberEqualTo(deviceNumber);
		List<VideoDisplayDevice> list = videoDisplayDeviceDAO.selectByExample(example);
		if(list != null && list.size() >0){
			return list.get(0);
		}else{
			throw new BusinessException("deviceNumber", ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}
	}

	
	public void displayRegister(VideoDisplayDevice display){
		videoDisplayDeviceDAO.updateByPrimaryKeySelective(display);
	}
}
