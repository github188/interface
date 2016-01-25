/**   
* @Title: BaseManager.java 
* @Package com.megaeyes.service.iface 
* @Description: 业务层接口基类
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-2-27 上午9:48:03 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

import com.megaeyes.service.exception.BusinessException;

/** 
 * @ClassName: BaseManager 
 * @Description: 业务层接口基类
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-2-27 上午9:48:03 
 *  
 */
public interface BaseManager {
	/**
	 * 
	* @Title: checkSessionId 
	* @Description: 检查sessionId的正确性
	* @param  sessionId
	* @return 此session登陆的用户ID，如果失败则返回字符串"0"
	* @throws BusinessException
	 */
	public String checkSessionId(String sessionId) throws BusinessException;
	/**
	 * 
	* @Title: heartBeat  
	* @Description: 客户端心跳 
	* @param @param sessionId
	* @param @return
	* @param @throws BusinessException    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String heartBeat(String sessionId) throws BusinessException;
}
