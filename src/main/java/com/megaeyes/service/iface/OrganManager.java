/**   
 * @Title: OrganManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-8 下午3:52:10 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.vo.ListOrganVO;
import com.megaeyes.persistence.ibatis.vo.OrganVO;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: OrganManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-8 下午3:52:10
 * 
 */
public interface OrganManager extends BaseManager {
	/**
	 * @Title: createOrgan
	 * @Description: 创建机构方法
	 * @param parentOrganId父机构ID
	 * @param name
	 *            机构名称（不能为空，不能重复）
	 * @param linkMan
	 *            联系人
	 * @param phone
	 *            电话
	 * @param email
	 *            邮件
	 * @param fax
	 *            传真
	 * @param address
	 *            地址
	 * @param postalCode
	 *            邮编
	 * @param number
	 *            业务编号（不能为空，不能重复）
	 * @param isSuspended
	 *            是否停用
	 * @param isMSP
	 *            是否MSP
	 * @param note
	 *            备注
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @return 返回字符串数组 第一位为机构id，第二位为信息
	 * @return String 返回类型
	 * @throws
	 */

	public String createOrgan(String parentOrganId, String name,
			String linkMan, String phone, String email, String fax,
			String address, String postalCode, Integer isSuspended,
			Integer isMSP, String note, String sipCode, String longitude,
			String latitude) throws BusinessException;

	/**
	 * @Title: deleteOrgan
	 * @Description: 删除机构
	 * @param id
	 *            机构ID
	 * @return String 返回类型
	 * @throws
	 */
	public String deleteOrgan(String id) throws BusinessException;

	/**
	 * @Title: updateOrgan
	 * @Description: 根据机构id获取下属机构树（包含本身）
	 * @param organId
	 *            机构id
	 * @return List<Organ> 返回类型
	 * @throws
	 */
	public List<Organ> getChildOrganById(String organId);

	/**
	 * @Title: updateOrgan
	 * @Description: 修改机构信息方法
	 * @param id
	 *            机构ID
	 * @param name
	 *            机构名称
	 * @param number
	 *            业务编号
	 * @param linkMan
	 *            联系人
	 * @param phone
	 *            联系电话
	 * @param email
	 *            邮箱
	 * @param fax
	 *            传真
	 * @param address
	 *            地址
	 * @param postalCode
	 *            邮编
	 * @param isSuspended
	 *            是否停用，1表示停用，0表示没有停用
	 * @param isMSP
	 *            是否MSP，1表示是，0表示不是
	 * @param note
	 *            备注
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @return void 返回类型
	 * @throws
	 */

	public void updateOrgan(String id, String name, String number,
			String linkMan, String phone, String email, String fax,
			String address, String postalCode, short isSuspended, short isMSP,
			String note, String sipCode, String longitude, String latitude)
			throws BusinessException;

	/**
	 * @Title: listAllSameLevelAndChildrenOrgans
	 * @Description: 查询指定机构的所有的平级机构及下级子机构列表
	 * @param organId
	 *            指定机构ID
	 * @return
	 */
	public List<Organ> listAllSameLevelAndChildrenOrgans(String organId);

	/**
	 * @Title: listOrganByOrganIdNextLevel
	 * @Description: 查询指定机构的所有的平级机构及下级子机构列表
	 * @param map
	 *            包含多个指定机构ID
	 * @return
	 */
	public List<Organ> listOrganByOrganIdNextLevel(Map map);

	/**
	 * @Title: countListOrganByOrganIdNextLevel
	 * @Description: 查询指定机构的所有的平级机构及下级子机构列表总数
	 * @param map
	 *            包含多个指定机构ID
	 * @return
	 */
	public int countListOrganByOrganIdNextLevel(Map map);

	/**
	 * @Title: listAllChildren
	 * @Description: 递归查询指定机构和所有子机构列表
	 * @param organId
	 *            机构ID
	 * @param 是否增加本机构的信息返回
	 *            （true表示查询本机构和所有子机构，false表示只查询子机构）
	 * @return
	 */
	public List<Organ> listAllChildren(String organId, boolean isRoot);

	/**
	 * @Title: listSameLevelOrgans
	 * @Description: 查询指定机构的所有平级机构，包括自身
	 * 
	 * @param organId
	 *            指定机构ID
	 * @return
	 */
	public List<Organ> listSameLevelOrgans(String organId);

	/**
	 * @Title: getOrganById
	 * @Description: TODO(根据ID查询机构)
	 * @param @param id
	 * @param @return 设定文件
	 * @return OrganVO 返回类型
	 * @throws
	 */
	public OrganVO getOrganById(String id);

	/**
	 * @Title: updateOrgan
	 * @Description: TODO(根据ID查询机构信息)
	 * @param @param id
	 * @param @return 设定文件
	 * @return Organ 返回类型
	 * @throws
	 */
	public Organ getOrgan(String id);

	/**
	 * 
	 * @Title: listOrganById
	 * @Description: TODO(根据机构Id查询该机构所有的子机构)
	 * @param @param organId
	 * @param @return 设定文件
	 * @return List<ListOrganVO> 返回类型
	 * @throws
	 */
	public List<ListOrganVO> listOrganById(String organId);
}
