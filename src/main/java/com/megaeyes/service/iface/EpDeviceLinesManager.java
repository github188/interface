/**   
* @Title: EpDeviceLinesManager.java 
* @Package com.megaeyes.service.iface 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-28 上午8:00:31 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpDevice;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;
import com.megaeyes.service.exception.BusinessException;

/** 
 * @ClassName: EpDeviceLinesManager 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-28 上午8:00:31 
 *  
 */
public interface EpDeviceLinesManager extends BaseManager {
	
	/**
	* @Title: createEDL 
	* @Description: 创建线路
	* @param name 线路名称
	* @param organId 机构ID
	* @param parentId 父ID
	* @param note 备注
	* @return String    返回类型 
	* @throws BusinessException
	 */
	public String createEDL(String name, String organId, String parentId, String note) throws BusinessException;

	
	/**
	* @Title: deleteEDL 
	* @Description: 删除线路 
	* @param id  线路ID
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void deleteEDL(String id)throws BusinessException;


	/**
	* @Title: listEDLByOrganId 
	* @Description: 根据机构ID查询所有线路列表
	* @param organId 机构ID
	* @return List<EpDevice>    返回类型 
	* @throws
	 */
	public List<EpDevice> listEDLByOrganId(String organId);


	/**
	* @Title: updateEDL 
	* @Description: 根据指定ID修改线路
	* @param id 线路ID 
	* @param name 线路名称
	* @param organId 机构ID
	* @param parentId 父ID
	* @param note    设定文件 
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void updateEDL(String id, String name, String organId,
			String parentId, String note) throws BusinessException;


	/**
	* @Title: listDeviceByLinesId 
	* @Description:  根据输电线路ID查询监控设备列表 
	* @param linesId
	* @return List<ListVicVO>    返回类型 
	* @throws BusinessException
	 */
	public List<ListVicVO> listDeviceByLinesId(String linesId)throws BusinessException;

}
