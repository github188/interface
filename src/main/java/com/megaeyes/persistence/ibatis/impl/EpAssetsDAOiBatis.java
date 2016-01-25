/**   
* @Title: EpAssetsDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-5 上午9:18:15 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpAssetsDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpAssets;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.vo.EpAssetsAndDeviceVO;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;


/** 
 * @ClassName: EpAssetsDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-5 上午9:18:15 
 *  
 */
public class EpAssetsDAOiBatis extends EpAssetsDAOImpl {
	
	/**
	* @Title: listEpAssets 
	* @Description: 查询资产管理列表
	* @return List<EpAssetsAndDeviceVO>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpAssetsAndDeviceVO> listEpAssets() {
		return getSqlMapClientTemplate().queryForList(
				"EP_ASSETS_VIEW.listEpAssets");
	}
	
	/**
	* @Title: listEAByOrganId 
	* @Description: 根据机构ID查询资产管理列表
	* @return List<EpAssetsAndDeviceVO>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpAssetsAndDeviceVO> listEAByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_ASSETS_VIEW.listEAByOrganId",organId);
	}
	
	/**
	* @Title: listVicByAssetsId 
	* @Description: 根据资产管理ID查询摄像头 
	* @param @param assetsId
	* @param @return    设定文件 
	* @return List<VideoInputChannel>    返回类型 
	* @throws
	 */
	public List<ListVicVO> listVicByAssetsId(String assetsId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_ASSETS_VIEW.listVicByAssetsId",assetsId);
	}
}
