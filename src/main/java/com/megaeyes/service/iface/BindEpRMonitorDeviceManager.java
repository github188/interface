/**   
* @Title: BindEpRMonitorDeviceManager.java 
* @Package com.megaeyes.service.iface 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-3 上午2:16:50 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;

import com.megaeyes.persistence.ibatis.vo.ListVicVO;
import com.megaeyes.service.exception.BusinessException;

/** 
 * @ClassName: BindEpRMonitorDeviceManager 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-3 上午2:16:50 
 *  
 */
public interface BindEpRMonitorDeviceManager extends BaseManager {


	/**
	* @Title: bindEpRMonitorDevice 
	* @Description: 绑定监控设备 
	* @param deviceType 设备类型
	* @param monitorType 监控设备类型
	* @param deviceId 设备ID
	* @param monitorId 监控设备ID
	* @throws BusinessException JSONException
	 */
	public void bindEpRMonitorDevice(BigDecimal deviceType, BigDecimal monitorType, String deviceId, String monitorId)throws BusinessException, JSONException;

	/**
	* @Title: deleteByDevice 
	* @Description: 根据设备ID删除监控设备
	* @param deviceId    设定文件 
	* @return void    返回类型 
	* @throws throws BusinessException
	 */
	public void deleteByDevice(String deviceId)throws BusinessException;

	/**
	 * 
	 * addOrUpdateEIDAndEpRMonitorDevice 绑定智能环控设备区和探测器
	 * @param deviceType 设备类型
	 * @param monitorType 监控设备类型
	 * @param deviceId 设备ID
	 * @param monitorId 监控设备ID
	 */
	public void addOrUpdateEIDAndEpRMonitorDevice(BigDecimal deviceType,
			BigDecimal monitorType, String deviceId, String monitorId);

}
