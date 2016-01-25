/**   
* @Title: EpProberManager.java 
* @Package com.megaeyes.service.iface 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-10 上午10:00:21 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpProber;

import com.megaeyes.persistence.ibatis.vo.EpProberVO;

import com.megaeyes.persistence.ibatis.vo.ListVicIdVO;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;

import com.megaeyes.service.exception.BusinessException;

/** 
 * @ClassName: EpProberManager 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-10 上午10:00:21 
 *  
 */
public interface EpProberManager extends BaseManager {

	
	/**
	* @Title: createEpProber 
	* @Description: 创建探测器
	* @param controlServerId 控制器ID
	* @param epProberTypeId 探测器类型ID
	* @param name 探测器名称
	* @param maxLimit 阀值大
	* @param minLimit 阀值小
	* @param cycle 采样频率
	* @param address 寄存器起始地址
	* @param isWarn 是否报警 
	* @param boolWarn 开关量报警值
	* @param position 安装地址
	* @param registerReverse 是否需要反转寄存器顺序
	* @param plcIoSaveCycle 数据保存间隔
	* @param plcIoSaveType 数据保存类型
	* @param organId 机构ID
	* @param dataType 数据类型
	* @return String    返回类型 
	* @throws BusinessException
	 */
	public String createEpProber(String controlServerId, String epProberTypeId,
			String name, Integer maxLimit, Integer minLimit, Integer cycle,
			String address, Integer isWarn, Integer boolWarn, String position,
			Integer registerReverse, Integer plcIoSaveCycle,
			String plcIoSaveType, String organId,String dataType)throws BusinessException;

	/**
	* @Title: deleteEpProber 
	* @Description: 删除探测器 
	* @param id   探测器ID
	* @return void    返回类型 
	* @throws deleteEpProber
	 */
	public void deleteEpProber(String id)throws BusinessException;

	/**
	* @Title: updateEpProber 
	* @Description: 根据ID修改探测器
	* @param id 探测器ID
	* @param controlServerId 控制器ID
	* @param epProberTypeId 探测器类型ID
	* @param name 探测器名称
	* @param maxLimit 阀值大
	* @param minLimit 阀值小
	* @param cycle 采样频率
	* @param address 寄存器起始地址
	* @param isWarn 是否报警 
	* @param boolWarn 开关量报警值
	* @param position 安装地址
	* @param registerReverse 是否需要反转寄存器顺序
	* @param plcIoSaveCycle 数据保存间隔
	* @param plcIoSaveType 数据保存类型
	* @param organId 机构ID
	* @param dataType 数据类型 
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void updateEpProber(String id,String controlServerId, String epProberTypeId,
			String name, Integer maxLimit, Integer minLimit, Integer cycle,
			String address, Integer isWarn, Integer boolWarn, String position,
			Integer registerReverse, Integer plcIoSaveCycle,
			String plcIoSaveType, String organId,String dataType)throws BusinessException;

	/**
	* @Title: getEpProberById 
	* @Description: 根据ID查询探测器
	* @param id
	* @return EpProber    返回类型 
	* @throws BusinessException
	 */
	public EpProber getEpProberById(String id)throws BusinessException;
	/**
	 * 查询机构以及子机构的探测器
	* @Title: listProberByOrganId 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param organId
	* @param @return
	* @param @throws BusinessException    设定文件 
	* @return List<EpProberVO>    返回类型 
	* @throws
	 */
	public List<EpProberVO> listProberByOrganId(String organId)throws BusinessException;

	/**
	* @Title: listVicByAssetsId 
	* @Description: 根据探测器ID查询摄像头ID 
	* @param proberId 探测器ID
	* @return List<ListVicVO>    返回类型 
	* @throws
	 */
	public List<ListVicIdVO> listVicIdByProberId(String proberId);

	

}
