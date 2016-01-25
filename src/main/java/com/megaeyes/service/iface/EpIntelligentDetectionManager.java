/**   
* @Title: EpIntelligentDetectionManager.java 
* @Package com.megaeyes.service.iface 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-2 上午2:42:28 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpDevice;
import com.megaeyes.persistence.ibatis.vo.EpIntelligentDetectionAndDeviceVO;
import com.megaeyes.persistence.ibatis.vo.ListDeviceByIntelligentVO;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;
import com.megaeyes.service.exception.BusinessException;

/** 
 * @ClassName: EpIntelligentDetectionManager 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-2 上午2:42:28 
 *  
 */
public interface EpIntelligentDetectionManager extends BaseManager {

	/**
	* @Title: createEID 
	* @Description: 创建智能监测设备 
	* @param name 监测设备名称
	* @param organId 机构ID
	* @param parentId 父ID
	* @param note 备注
	* @param type 监测设备类型
	* @param operation 操作描述
	* @return String    返回类型 
	* @throws BusinessException
	 */
	public String createEID(String name, String organId, String parentId, String note, BigDecimal type,String operation)throws BusinessException;

	
	/**
	* @Title: deleteEID 
	* @Description: 删除智能监测设备 
	* @param id   智能监测设备ID
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void deleteEID(String id)throws BusinessException;

	/**
	* @Title: updateEID 
	* @Description: 更新智能监测设备
	* @param id 智能监测设备
	* @param name 智能监测名称
	* @param organId 机构ID
	* @param parentId 父ID
	* @param note 备注
	* @param type 类型
	* @param operation 操作描述
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void updateEID(String id, String name, String organId,
			String parentId, String note, BigDecimal type,String operation)throws BusinessException;

	
	/**
	* @Title: listEIDByOrganId 
	* @Description: 根据机构ID查询智能监测列表
	* @param organId 机构ID
	* @return List<EpIntelligentDetectionAndDeviceVO>    返回类型 
	* @throws BusinessException
	 */
	public List<EpIntelligentDetectionAndDeviceVO> listEIDByOrganId(
			String organId)throws BusinessException;
	/**
	 * 
	* @Title: listEIDAndDomainByOrganId 
	* @Description: 根据机构ID查询智能监测树装结构（包括功能区）
	* @param @param organId
	* @param @return
	* @param @throws BusinessException    设定文件 
	* @return List<EpIntelligentDetectionAndDeviceVO>    返回类型 
	* @throws
	 */
	public List<EpDevice> listEIDAndDomainByOrganId(
			String organId)throws BusinessException;


	/**
	* @Title: listDeviceByIntelligentId 
	* @Description: 根据智能监测设备ID查询监控设备ID 
	* @param intelligentId 设备ID
	* @param organId 机构ID
	* @return List<ListDeviceByIntelligentVO>    返回类型 
	* @throws BusinessException
	 */
	public List<ListDeviceByIntelligentVO> listDeviceByIntelligentId(String intelligentId,String organId)throws BusinessException;

}
