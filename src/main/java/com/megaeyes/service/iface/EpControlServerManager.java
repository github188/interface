/**   
* @Title: EpControlServerManager.java 
* @Package com.megaeyes.service.iface 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-7 上午2:36:41 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpControlServer;
import com.megaeyes.persistence.ibatis.model.EpProberType;
import com.megaeyes.persistence.ibatis.vo.ListEpMonitorDeviceAndEpProberVO;
import com.megaeyes.service.exception.BusinessException;

/** 
 * @ClassName: EpControlServerManager 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-7 上午2:36:41 
 *  
 */
public interface EpControlServerManager extends BaseManager {

	
	/**
	* @Title: createECS 
	* @Description: 创建太阳能控制器
	* @param gatherServerId 采集服务器ID
	* @param name 控制器名称
	* @param position 物理位置
	* @param organId 机构ID
	* @param cycle 采样频率
	* @param url url地址
	* @param isWarn 是否报警
	* @param plcIoSaveCycle 数据保存间隔
	* @param plcIoSaveType 数据保存类型
	* @return String    返回类型 
	* @throws BusinessException
	 */
	public String createECS(String gatherServerId, String name, String position,
			String organId, Integer cycle,String url,Integer isWarn,Integer plcIoSaveCycle,String plcIoSaveType)throws BusinessException;

	/**
	* @Title: deleteECS 
	* @Description: 删除太阳能控制器
	* @param id    设定文件 
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void deleteECS(String id)throws BusinessException;

	/**
	* @Title: updateECS 
	* @Description: 修改太阳能控制器 
	* @param id 太阳能控制器ID
	* @param name 控制器名称
	* @param position 物理地址
	* @param organId 机构ID
	* @param cycle  采集频率
	* @param url url地址
	* @param isWarn 是否报警
	* @param plcIoSaveCycle 数据保存间隔
	* @param plcIoSaveType 数据保存类型
	* @return void    返回类型 
	* @throws
	 */
	public void updateECS(String id, String name,String position, String organId, Integer cycle,String url,
			Integer isWarn,Integer plcIoSaveCycle,String plcIoSaveType);

	/**
	 * @param deviceId 
	* @Title: listEMDandEpProber 
	* @Description: 根据设备（输电线路）ID查询太阳能探测器列表
	* @param name 控制器名称
	* @return List<ListEpMonitorDeviceAndEpProberVO>    返回类型 
	* @throws
	 */
	public List<ListEpMonitorDeviceAndEpProberVO> listEMDandEpProber(String deviceId);

	

	/**
	* @Title: createECS 
	* @Description: 创建太阳能控制器
	* @param gatherServerId 采集服务器ID
	* @param name 控制器名称
	* @param position 物理位置
	* @param organId 机构ID
	* @param url url地址
	* @return String    返回类型 
	* @throws BusinessException
	 */
	public String createPlcECS(String gatherServerId, String name,
			String position, String organId, String url)throws BusinessException;

	
	/**
	* @Title: updatePlcECS 
	* @Description: 更新PLC
	* @param id PLCID
	* @param name PLC名称
	* @param position 物理地址
	* @param organId 机构ID
	* @param cycle 采样频率
	* @param url url地址  
	* @param gatherServerId 采集服务器ID
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void updatePlcECS(String id, String name, String position,
			String organId, String url,String gatherServerId)throws BusinessException;

	/**
	* @Title: deletePlcECS 
	* @Description: 删除PLC
	* @param id    PLCID
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void deletePlcECS(String id)throws BusinessException;

	
	/**
	* @Title: listPLCByGatherServerId 
	* @Description: 根据采集服务器ID查询PLC列表
	* @return List<EpControlServer>    返回类型 
	* @throws
	 */
	public List<EpControlServer> listPLC();

	/**
	* @Title: ListProberType 
	* @Description: 查询探测器类型
	* @param @return    设定文件 
	* @return List<EpProberType>    返回类型 
	* @throws
	 */
	public List<EpProberType> listProberType();

}
