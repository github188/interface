/**   
* @Title: BindEpRProberVICManager.java 
* @Package com.megaeyes.service.iface 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-14 上午2:13:44 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

/** 
 * @ClassName: BindEpRProberVICManager 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午2:13:44 
 *  
 */
public interface BindEpRProberVICManager extends BaseManager {

	/**
	* @Title: deleteByProberId 
	* @Description: 根据探测器ID删除关系表记录
	* @param proberId    探测器ID
	* @return void    返回类型 
	* @throws
	 */
	public void deleteByProberId(String proberId);

	
	/**
	* @Title: bindEpRProberVIC 
	* @Description:绑定探测器摄像头
	* @param proberId 探测器ID
	* @param vicId    摄像头ID 
	* @return void    返回类型 
	* @throws
	 */
	public void bindEpRProberVIC(String proberId, String vicId);

}
