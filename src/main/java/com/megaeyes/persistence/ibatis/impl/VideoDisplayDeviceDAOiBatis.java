/**   
* @Title: VideoDisplayDeviceDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-22 上午6:54:45 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.VideoDisplayDeviceDAOImpl;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;

/** 
 * @ClassName: VideoDisplayDeviceDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-22 上午6:54:45 
 *  
 */
public class VideoDisplayDeviceDAOiBatis extends VideoDisplayDeviceDAOImpl {
	/**
	* @Title: listVideoDisplayDevice 
	* @Description: 根据organId查询显示服务器列表 
	* @param @return    设定文件 
	* @return List<VideoDisplayDevice>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<VideoDisplayDevice> listVideoDisplayDevice(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_DISPLAY_DEVICE_VIEW.listVideoDisplayDevice",organId);
	}
}
