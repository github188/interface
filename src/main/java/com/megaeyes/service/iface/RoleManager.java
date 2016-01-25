/**   
 * @Title: RoleManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-31 上午10:46:16 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;
import com.megaeyes.persistence.ibatis.vo.ListDeviceByRoleId;
import com.megaeyes.persistence.ibatis.model.EpOperation;
import com.megaeyes.persistence.ibatis.model.EpRole;
import com.megaeyes.persistence.ibatis.vo.ListOperationByRoleId;

/**
 * @ClassName: RoleManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-31 上午10:46:16
 * 
 */
public interface RoleManager extends BaseManager {
	/**
	 * 
	 * @Title: createRole
	 * @Description: TODO(创建角色)
	 * @param name 名称
	 * @param note	备注
	 * @param organId	机构ID
	 * @param isSuspended 是否停用: 0:停用 1:不停用
	 * @param createUserName 创建机构的用户登录loginname
	 * @param type 1:系统生成 2:用户创建
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String createRole(String name, String note, String organId,
			BigDecimal isSuspended, String createUserName, BigDecimal type);

	/**
	 * @Title: deleteRole
	 * @Description: TODO(删除角色)
	 * @param id 角色ID
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteRole(String id);

	/**
	 * @Title: ListRoleByOrganId
	 * @Description: TODO(根据机构查询角色列表)
	 * @param organId 机构ID
	 * @param @return 设定文件
	 * @return List<EpRole> 返回类型
	 * @throws
	 */
	public List<EpRole> listRoleByOrganId(String organId);

	/**
	 * @Title: ListRoleByUserId
	 * @Description: TODO(根据用户查询角色列表)
	 * @param userId 用户ID	
	 * @param @return 设定文件
	 * @return List<EpRole> 返回类型
	 * @throws
	 */
	public List<EpRole> listRoleByUserId(String userId);

	/**
	 * @Title: updateRole
	 * @Description: TODO(更新角色)
	 * @param id 角色ID
	 * @param name 名称
	 * @param note	备注
	 * @param organId	机构ID
	 * @param isSuspended 是否停用: 0:停用 1:不停用
	 * @param createUserName 创建机构的用户登录loginname
	 * @param type 1:系统生成 2:用户创建
	 * @return void 返回类型
	 * @throws
	 */
	public void updateRole(String id, String name, String note, String organId,
			BigDecimal isSuspended, String createUserName, BigDecimal type);
	/**
	 * @Title: addRoleToUser 
	 * @Description: TODO(对用户添加角色) 
	 * @param userId
	 * @param roleId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void updateRoleToUser(String jsonString) throws JSONException;
	
	/**
	* @Title: listAllEpOperation 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<EpOperation>    返回类型 
	* @throws
	 */
	public List<EpOperation> listAllEpOperation();

	/**
	 * @throws JSONException 
	 * @Title: addorupdateEpRRoleOperation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param jsonString 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void addorupdateEpRRoleOperation(String jsonString) throws JSONException;
	
	/**
	 * @Title: listOperationByRoleId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param roleId
	 * @param @return 设定文件
	 * @return List<ListOperationByRoleId> 返回类型
	 * @throws
	 */
	public List<ListOperationByRoleId> listOperationByRoleId(String roleId);

	/**
	 * @Title: addorupdateEpRRoleResource
	 * @Description: TODO(角色与设备关联增删查改)
	 * @param @param jsonString
	 * @param @throws JSONException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void addorupdateEpRRoleResource(String jsonString) throws JSONException;

	/**
	 * @Title: ListDeviceByRoleId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param roleId
	 * @param @return 设定文件
	 * @return List<ListDeviceByRoleId> 返回类型
	 * @throws
	 */
	public List<ListDeviceByRoleId> ListDeviceByRoleId(String roleId);
	
	/**
	 * 
	* @Title: listEpOperationByUserId 
	* @Description:查询某用户
	* @param @param userId
	* @param @return    设定文件 
	* @return List<EpOperation>    返回类型 
	* @throws
	 */
	public List<EpOperation> listEpOperationByUserId(String userId);
}
