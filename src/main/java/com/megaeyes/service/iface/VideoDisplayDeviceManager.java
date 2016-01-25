package com.megaeyes.service.iface;

import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;

/**
 * 
 * @Title: VdieoDisplayDeviceManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: 显示服务器管理接口
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-24 上午10:49:11 
 * @version V1.0
 */
public interface VideoDisplayDeviceManager extends BaseManager{
	
	/**
	 * 
	 * @Description:根据设备编号查询显示服务器
	 * @author zhuanqi@megaeyes.com
	 * @param @param deviceNumber
	 * @param @return 
	 * @return VideoDisplayDevice 
	 * @throws
	 */
	public VideoDisplayDevice getVideoDisplayByDeviceNumber(String deviceNumber);
	
	
	/**
	 * 
	 * @Description: 显示服务器注册
	 * @author zhuanqi@megaeyes.com
	 * @param @param display 
	 * @return void 
	 * @throws
	 */
	public void displayRegister(VideoDisplayDevice display);
	
}
