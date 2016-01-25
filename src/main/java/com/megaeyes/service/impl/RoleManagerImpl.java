/**   
 * @Title: RoleManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-31 上午10:47:09 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.megaeyes.persistence.ibatis.impl.EpOperationDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRRoleOperationDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRRoleResourceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRUserRoleDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRoleDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.UserDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpOperation;
import com.megaeyes.persistence.ibatis.model.EpOperationExample;
import com.megaeyes.persistence.ibatis.model.EpRRoleOperation;
import com.megaeyes.persistence.ibatis.model.EpRRoleResource;
import com.megaeyes.persistence.ibatis.model.EpRUserRole;
import com.megaeyes.persistence.ibatis.model.EpRole;
import com.megaeyes.persistence.ibatis.model.EpRoleExample;
import com.megaeyes.persistence.ibatis.model.TUser;
import com.megaeyes.persistence.ibatis.vo.ListDeviceByRoleId;
import com.megaeyes.persistence.ibatis.vo.ListOperationByRoleId;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.RoleManager;

/**
 * @ClassName: RoleManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-31 上午10:47:09
 * 
 */
@Controller
public class RoleManagerImpl extends BaseManagerImpl implements RoleManager {
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpRoleDAOiBatis epRoleDAO;
	@Autowired
	EpRUserRoleDAOiBatis epRUserRoleDAO;
	@Autowired
	EpOperationDAOiBatis epOperationDAO;
	@Autowired
	EpRRoleOperationDAOiBatis epRRoleOperationDAO;
	@Autowired
	EpRRoleResourceDAOiBatis epRRoleResourceDAO;
	@Autowired
	UserDAOiBatis userDAO;

	public String createRole(String name, String note, String organId,
			BigDecimal isSuspended, String createUserName, BigDecimal type) {
		if (StringUtils.isNotBlank(name)) {
			EpRoleExample erExample = new EpRoleExample();
			EpRoleExample.Criteria criteria = erExample.createCriteria();
			criteria.andNameEqualTo(name);
			criteria.andOrganIdEqualTo(organId);
			int i = epRoleDAO.countByExample(erExample);
			if (i > 0) {
				throw new BusinessException("name", ErrorCode.NAME_EXIST);
			}

		} else {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(createUserName)) {
			throw new BusinessException("createUserName",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpRole role = new EpRole();
		String id = sequenceDAO.getEpRoleSeq();
		role.setId(id);
		role.setName(name);
		role.setOrganId(organId);
		role.setIsSuspended(isSuspended);
		role.setCreateUserName(createUserName);
		role.setType(type);
		epRoleDAO.insert(role);
		if (name.equals("管理员")) {
			epRRoleOperationDAO.adminUser(id);
		} else {
			epRRoleOperationDAO.generalUser(id);
		}
		return id;
	}

	public void deleteRole(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try {
			// 删除角色时删除关系表记录
			epRRoleOperationDAO.deleteByRoleId(id);

			epRoleDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new BusinessException("resourceBeUsed",
					ErrorCode.RESOURCE_BE_USED);
		}
	}

	public List<EpRole> listRoleByOrganId(String organId) {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epRoleDAO.listRoleByOrganId(organId);
	}

	public List<EpRole> listRoleByUserId(String userId) {
		if (StringUtils.isBlank(userId)) {
			throw new BusinessException("userId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epRoleDAO.listRoleByUserId(userId);
	}

	public void updateRole(String id, String name, String note, String organId,
			BigDecimal isSuspended, String createUserName, BigDecimal type) {
		if (StringUtils.isNotBlank(name)) {
			EpRoleExample erExample = new EpRoleExample();
			EpRoleExample.Criteria criteria = erExample.createCriteria();
			criteria.andNameEqualTo(name);
			criteria.andOrganIdEqualTo(organId);
			List<EpRole> list = epRoleDAO.selectByExample(erExample);
			if (list.size() > 0) {
				if (!list.get(0).getId().equals(id)) {
					if (list.get(0).getName().equals(name)) {
						throw new BusinessException("name",
								ErrorCode.NAME_EXIST);
					}
				}
			}

		} else {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}

		EpRole role = new EpRole();
		role.setId(id);
		role.setName(name);
		role.setNote(note);
		role.setOrganId(organId);
		role.setIsSuspended(isSuspended);
		role.setCreateUserName(createUserName);
		role.setType(type);
		epRoleDAO.updateByPrimaryKeySelective(role);
	}

	public void updateRoleToUser(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);
		if (StringUtils.isBlank(jsonString)) {
			throw new BusinessException("jsonString",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String userId = jsonObject.getString("userId");
		epRUserRoleDAO.deleteByUserId(userId);
		// System.out.println("userId is:" + userId);
		JSONArray jsonArray = jsonObject.getJSONArray("roleIds");
		if (jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
				String roleId = jsonObj.getString("roleId");
				// System.out.println("item " + i + " :" + roleId);
				EpRUserRole userRole = new EpRUserRole();
				String id = sequenceDAO.getEpRUserRoleSeq();
				userRole.setRoleId(roleId);
				userRole.setUserId(userId);
				userRole.setId(id);
				epRUserRoleDAO.insert(userRole);
			}
		}
	}

	public List<EpOperation> listAllEpOperation() {
		return epOperationDAO.listAllEpOperation();
	}

	public void addorupdateEpRRoleOperation(String jsonString)
			throws JSONException {
		if (StringUtils.isBlank(jsonString)) {
			throw new BusinessException("jsonString",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		JSONObject jsonObject = new JSONObject(jsonString);
		String roleId = jsonObject.getString("roleId");
		epRRoleOperationDAO.deleteByRoleId(roleId);
		JSONArray jsonArray = jsonObject.getJSONArray("operationIds");
		if (jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
				String operationId = jsonObj.getString("operationId");
				EpRRoleOperation epRRoleOperation = new EpRRoleOperation();
				String id = sequenceDAO.getEpRRoleOperationSeq();
				epRRoleOperation.setId(id);
				epRRoleOperation.setRoleId(roleId);
				epRRoleOperation.setOperationId(operationId);
				epRRoleOperationDAO.insert(epRRoleOperation);
			}
		}
	}

	public List<ListOperationByRoleId> listOperationByRoleId(String roleId) {
		if (StringUtils.isBlank(roleId)) {
			throw new BusinessException("roleId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epRoleDAO.listOperationByRoleId(roleId);
	}

	public void addorupdateEpRRoleResource(String jsonString)
			throws JSONException {
		if (StringUtils.isBlank(jsonString)) {
			throw new BusinessException("jsonString",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		JSONObject jsonObject = new JSONObject(jsonString);
		String roleId = jsonObject.getString("roleId");
		epRRoleResourceDAO.deleteByRoleId(roleId);
		JSONArray jsonArray = jsonObject.getJSONArray("resource");
		if (jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				EpRRoleResource epRRoleResource = new EpRRoleResource();
				String id = sequenceDAO.getEpRRoleResourceSeq();
				JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
				String resourceId = jsonObj.getString("resourceId");
				String resourceType = jsonObj.getString("resourceType");
				String resourceOrganId = jsonObj.getString("resourceOrganId");
				epRRoleResource.setResourceId(resourceId);
				epRRoleResource.setResourceOrganId(resourceOrganId);
				epRRoleResource.setResourceType(resourceType);
				epRRoleResource.setId(id);
				epRRoleResource.setRoleId(roleId);
				epRRoleResourceDAO.insert(epRRoleResource);
			}
		}
	}

	public List<ListDeviceByRoleId> ListDeviceByRoleId(String roleId) {
		if (StringUtils.isAlpha(roleId)) {
			throw new BusinessException("roleId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		List<ListDeviceByRoleId> list = epRRoleResourceDAO
				.listVICByRoleId(roleId);
		return list;
	}

	public List<EpOperation> listEpOperationByUserId(String userId) {
		TUser user = userDAO.selectByPrimaryKey(userId);
		if (user.getUserAccount().equals("1")) {
			return epOperationDAO.listAllEpOperation();
		}
		// List<EpRole> roles = epRoleDAO.listRoleByUserId(userId);
		// for (EpRole role : roles) {
		// if (role.getType().toString().equals("1")) {
		// EpOperationExample example = new EpOperationExample();
		// example.createCriteria().andOperationNumberNotEqualTo("90");
		// return epOperationDAO.selectByExample(example);
		// }
		// }
		return epOperationDAO.listEpOperationByUserId(userId);
	}
}
