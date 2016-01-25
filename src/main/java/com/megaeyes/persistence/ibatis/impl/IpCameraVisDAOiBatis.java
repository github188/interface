/**   
* @Title: IpCameraVisDAO.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-3-16 下午3:18:09 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.IpCameraVisDAOImpl;

/** 
 * @ClassName: IpCameraVisDAO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com  
 * @date 2012-3-16 下午3:18:09 
 *  
 */
public class IpCameraVisDAOiBatis extends IpCameraVisDAOImpl {

	public void updateIpCameraVIC(String VIDEO_INPUT_SERVER_ID){
		getSqlMapClientTemplate().update("IP_CAMERA_VIS_VIEW.updateIpCameraVIC" ,VIDEO_INPUT_SERVER_ID);
	}
}
