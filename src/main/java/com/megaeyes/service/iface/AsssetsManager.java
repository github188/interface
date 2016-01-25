/**   
* @Title: AsssetsManager.java 
* @Package com.megaeyes.service.iface 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-5 上午8:38:33 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.megaeyes.persistence.ibatis.model.EpAssets;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.vo.EpAssetsAndDeviceVO;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;
import com.megaeyes.service.exception.BusinessException;

/** 
 * @ClassName: AsssetsManager 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-5 上午8:38:33 
 *  
 */
public interface AsssetsManager extends BaseManager {
	/**
	* @Title: createEpAssets 
	* @Description: 创建资产管理
	* @param name 资产管理名称
	* @param type 类型
	* @param useTime 投运时间
	* @param expirationTime 到期时间
	* @param significantLevel 重要级别
	* @param parentId 父ID
	* @param note 备注
	* @param deviceNumber 设备编号
	* @param organId 机构ID
	* @param installLocation 安装地址
	* @return String    返回类型 
	* @throws BusinessException
	 */
	public String createEpAssets(String name, BigDecimal type, BigDecimal useTime,
			BigDecimal expirationTime, BigDecimal significantLevel,
		 String note, String deviceNumber, String organId,String installLocation)throws BusinessException;
	
	
	/**
	* @Title: deleteEpAssets 
	* @Description: 删除资产管理
	* @param id    设定文件 
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void deleteEpAssets(String id)throws BusinessException;
	
	/**
	* @Title: listEpAssets 
	* @Description: 查询资产管理列表
	* @return List<EpAssets>    返回类型 
	* @throws BusinessException
	 */
	public List<EpAssetsAndDeviceVO> listEpAssets()throws BusinessException;
	
	/**
	* @Title: getEAByOrganId 
	* @Description: 根据指定机构ID查询资产管理列表
	* @param organId
	* @return EpAssets    返回类型 
	* @throws BusinessException
	 */
	public List<EpAssetsAndDeviceVO> listEAByOrganId(String organId)throws BusinessException;
	
	/**
	* @Title: updateEpAssets 
	* @Description: 更新资产管理
	* @param id 资产管理ID
	* @param name 资产管理名称
	* @param type 资产管理类型
	* @param useTime 投运时间
	* @param expirationTime 到期时间 
	* @param significantLevel 重要级别
	* @param parentId 父ID
	* @param note 备注
	* @param deviceNumber 设备编号
	* @param organId   机构ID
	* @param installLocation 安装地址
	* @return void    返回类型 
	* @throws BusinessException
	 */
	public void updateEpAssets(String id, String name, BigDecimal type,
			BigDecimal useTime, BigDecimal expirationTime,
			BigDecimal significantLevel,  String note,
			String deviceNumber, String organId,String installLocation);
	
	/**
	 * @throws JSONException 
	* @Title: addOrUpdateEpRAssetsVicOperation 
	* @Description: 更新资产管理摄像头
	* @param @param jsonString 字符串
	* @return void    返回类型 
	* @throws
	 */
	public void addOrUpdateEpRAssetsVic(String jsonString)throws BusinessException, JSONException;
	
	/**
	* @Title: listVicByAssetsId 
	* @Description: 根据资产管理ID查询摄像头
	* @return List<VideoInputChannel>    返回类型 
	* @throws
	 */
	public List<ListVicVO> listVicByAssetsId(String assetsId);

}
