/**   
* @Title: EpMonitorDeviceManager.java 
* @Package com.megaeyes.service.iface 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-27 上午5:21:34 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpMonitorDevice;
import com.megaeyes.service.exception.BusinessException;

/** 
 * @ClassName: EpMonitorDeviceManager 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-27 上午5:21:34 
 *  
 */
public interface EpMonitorDeviceManager extends BaseManager {
	/**
	* @Title: createEMD 
	* @Description: 创建监控设备
	* @param name 监控设备名称
	* @param type 监控设备类型
	* @param naming naming信息
	* @param organId 机构ID
	* @return String    返回类型 
	* @throws BusinessException
	 */
	public String createEMD(String name,BigDecimal type,String naming,String organId)throws BusinessException;
	
	/**
	* @Title: deleteEMD 
	* @Description: 删除监控设备
	* @param id 
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void deleteEMD(String id)throws BusinessException;
	
	
	/**
	* @Title: listEMD 
	* @Description: 查询监控设备列表
	* @return void    返回类型 
	* @throws
	 */
	public List<EpMonitorDevice> listEMD();

	/**
	* @Title: getEMD 
	* @Description: 根据指定ID查询监控设备
	* @param id
	* @return EpMonitorDevice    返回类型 
	* @throws BusinessException
	 */
	public EpMonitorDevice getEMD(String id)throws BusinessException;
	
	/**
	* @Title: updateEMD 
	* @Description: 根据指定ID修改监控设备
	* @param id 监控设备ID
	* @param name 监控设备名称
	* @param type 监控设备类型
	* @param naming naming信息
	* @param organId 机构ID
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void updateEMD(String id,String name,BigDecimal type,String naming,String organId)throws BusinessException;
}
