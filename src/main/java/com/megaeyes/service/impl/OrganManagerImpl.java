/**   
 * @Title: UserLoginManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-2 下午1:44:16 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.megaeyes.persistence.ibatis.impl.CompanyDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRoleDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.PlatformResourcesDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.UserDAOiBatis;
import com.megaeyes.persistence.ibatis.model.Company;
import com.megaeyes.persistence.ibatis.model.CompanyExample;
import com.megaeyes.persistence.ibatis.model.EpRoleExample;
import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.model.OrganExample;
import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.PlatformResourcesExample;
import com.megaeyes.persistence.ibatis.model.TUserExample;
import com.megaeyes.persistence.ibatis.vo.ListOrganVO;
import com.megaeyes.persistence.ibatis.vo.OrganVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.OrganManager;

/**
 * @ClassName: UserLoginManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-2 下午1:44:16
 * 
 */
@Controller
public class OrganManagerImpl extends BaseManagerImpl implements OrganManager {
	@Autowired
	OrganDAOiBatis organDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	CompanyDAOiBatis companyDAO;
	@Autowired
	PlatformResourcesDAOiBatis platformResourcesDAO;
	@Autowired
	UserDAOiBatis userDAO;
	@Autowired
	EpRoleDAOiBatis epRoleDAO;

	public String createOrgan(String parentOrganId, String name,
			String linkMan, String phone, String email, String fax,
			String address, String postalCode, Integer isSuspended,
			Integer isMSP, String note, String sipCode, String longitude,
			String latitude) throws BusinessException {
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("Name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		// 机构名称是否存在
		OrganExample organExample = new OrganExample();
		OrganExample.Criteria criteria = organExample.createCriteria();
		criteria.andNameEqualTo(name);
		List list = organDAO.selectByExample(organExample);
		if (null != list && list.size() > 0) {
			throw new BusinessException("Name", ErrorCode.NAME_EXIST);
		}
		String id = sequenceDAO.getOrganSeq();
		Organ organ = new Organ();
		Company company = new Company();
		organ.setParentOrganId(parentOrganId);
		organ.setName(name);
		organ.setId(id);
		organ.setOptimisticLock(new BigDecimal(0));
		String path = "";
		if ((null != parentOrganId) && (!"".equals(parentOrganId))) {
			Organ parentOrgan = organDAO.selectByPrimaryKey(parentOrganId);
			// 获取辅机构Path
			System.out.println(parentOrgan.getPath());
			path += parentOrgan.getPath();

		}
		// 拼接当前机构PATH
		path += "/" + id;
		organ.setPath(path);
		organDAO.insert(organ);
		company.setLinkman(linkMan);
		company.setPhone(phone);
		company.setEmail(email);
		company.setFax(fax);
		company.setfNumber(id);
		company.setAddress(address);
		company.setOrganId(id);
		company.setPostalcode(postalCode);
		CompanyExample companyExample = new CompanyExample();
		CompanyExample.Criteria companycriteria = companyExample
				.createCriteria();
		/*
		 * companycriteria.andFNumberEqualTo(number); List comlist =
		 * companyDAO.selectByExample(companyExample); if (null != list &&
		 * list.size() > 0) { throw new BusinessException("fNumber",
		 * ErrorCode.STD_ID_DUPLICATE); }
		 */
		company.setfNumber(id);
		company.setIsSuspended(isSuspended.shortValue());
		company.setIsMsp(isMSP.shortValue());
		company.setNote(note);
		companyDAO.insert(company);
		// 记录到platform_resources
		saveOrUpdatePlatformResources(id, name, id, parentOrganId, sipCode,
				longitude, latitude, "organ", null);
		return id;
	}

	public String deleteOrgan(String id) throws BusinessException {
		Organ o = organDAO.selectByPrimaryKey(id);
		String name = o.getName();
		// 机构下看是否有用户
		TUserExample userExample = new TUserExample();
		TUserExample.Criteria criteria = userExample.createCriteria();
		criteria.andOrganIdEqualTo(o.getId());
		int count = userDAO.countByExample(userExample);
		if (count > 0) {
			throw new BusinessException("", ErrorCode.HAVA_USER);
		}
		// 机构下是否还有机构存在
		OrganExample organExample = new OrganExample();
		OrganExample.Criteria organCriteria = organExample.createCriteria();
		organCriteria.andParentOrganIdEqualTo(o.getId());
		List list = organDAO.selectByExample(organExample);
		if (null != list && list.size() > 0) {
			throw new BusinessException("child organ found, can not delete !",
					ErrorCode.HAVA_CHILDREN);
		}

		List listuser = userDAO.getUsersByOrganId(id);
		if (null != listuser && listuser.size() > 0) {
			throw new BusinessException(" ", ErrorCode.HAVA_USER);
		}
		// int devicecount=organDevicesDAO.deviceByorganIdcount(id);

		try {
			// TODO: 如果存在设备，不允许删除
			companyDAO.deleteByPrimaryKey(id);

			organDAO.deleteByPrimaryKey(id);
			// 删除机构时应先把对应的普通角色和管理员角色删除
			EpRoleExample erExample = new EpRoleExample();
			EpRoleExample.Criteria criteria1 = erExample.createCriteria();
			criteria1.andOrganIdEqualTo(id);
			epRoleDAO.deleteByExample(erExample);
		} catch (Exception e) {
			throw new BusinessException("resourceBeUsed",
					ErrorCode.RESOURCE_BE_USED);
		}
		removePlatformResources(id, "organ");

		return name;
	}

	public List<Organ> getChildOrganById(String organId) {
		return organDAO.getChildOrganById(organId);
	}

	public void updateOrgan(String id, String name, String number,
			String linkMan, String phone, String email, String fax,
			String address, String postalCode, short isSuspended, short isMSP,
			String note, String sipCode, String longitude, String latitude)
			throws BusinessException {
		// 机构名称是否存在
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}

		OrganExample organExample = new OrganExample();
		OrganExample.Criteria criteria = organExample.createCriteria();
		criteria.andNameEqualTo(name);
		List<Organ> list = organDAO.selectByExample(organExample);
		if (null != list && list.size() > 0) {
			if (!id.equals(list.get(0).getId())
					&& name.equals(list.get(0).getName())) {
				throw new BusinessException("name", ErrorCode.NAME_EXIST);
			}
		}
		Organ organ = new Organ();
		organ.setId(id);
		organ.setOptimisticLock(new BigDecimal(0));
		organ.setName(name);
		organDAO.updateByPrimaryKeySelective(organ);
		Company company = new Company();
		company.setOrganId(id);
		company.setLinkman(linkMan);
		company.setPhone(phone);
		company.setEmail(email);
		company.setFax(fax);
		company.setAddress(address);
		company.setPostalcode(postalCode);
		company.setfNumber(id);
		company.setIsSuspended(isSuspended);
		company.setIsMsp(isMSP);
		company.setNote(note);
		companyDAO.updateByPrimaryKeySelective(company);
		// 同步修改platform_resources
		saveOrUpdatePlatformResources(id, name, id, organDAO
				.selectByPrimaryKey(id).getParentOrganId(), sipCode, longitude,
				latitude, "organ", null);
	}

	public OrganVO getOrganById(String id) {
		OrganVO organ = organDAO.getOrganById(id);
		// 查询platform_resources
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		PlatformResources record = platformResourcesDAO.getByResourceId(id,
				"organ");
		if (record != null) {
			organ.setSipCode(record.getSipCode());
			organ.setLongitude(record.getLongitude());
			organ.setLatitude(record.getLatitude());
		}
		return organ;
	}

	public Organ getOrgan(String id) {
		return organDAO.selectByPrimaryKey(id);
	}

	private void saveOrUpdatePlatformResources(String resourceId, String name,
			String naming, String organId, String sipCode, String longitude,
			String latitude, String type, Short isShare) {

		PlatformResources record = platformResourcesDAO.getByResourceId(
				resourceId, type);
		if (null == record) {
			if (StringUtils.isNotBlank(sipCode)) {
				// 检查sipCode是否重复
				PlatformResources pr = platformResourcesDAO
						.getBySipCode(sipCode);
				if (pr != null) {
					throw new BusinessException("sipCode exist !",
							ErrorCode.SIP_CODE_EXIST);
				}
				// 生成对应记录
				record = new PlatformResources();
				record.setId(sequenceDAO.getPlatformResourcesSeq());
				record.setIsShare(isShare == null ? new Short("1") : isShare);
				record.setName(name);
				record.setNaming(naming);
				record.setOrganId(organId);
				record.setResourceId(resourceId);
				record.setSipCode(sipCode);
				record.setStatus(new Short("1"));
				record.setLongitude(longitude);
				record.setLatitude(latitude);
				record.setType(type);
				record.setStandardType("0");
				platformResourcesDAO.insert(record);
			}
		}
		// 修改platform_resource对应记录
		else {
			// 检查sipCode是否重复
			if (!sipCode.equals(record.getSipCode())) {
				PlatformResources pr = platformResourcesDAO
						.getBySipCode(sipCode);
				if (pr != null) {
					throw new BusinessException("sipcode exist !",
							ErrorCode.SIP_CODE_EXIST);
				}
			}
			// 修改sipCode,name和naming
			record.setName(name);
			record.setNaming(naming);
			record.setSipCode(sipCode);
			record.setLongitude(longitude);
			record.setLatitude(latitude);
			record.setIsShare(isShare);
			platformResourcesDAO.updateByPrimaryKeySelective(record);
		}
	}

	private void removePlatformResources(String resourceId, String type) {
		PlatformResourcesExample prExample = new PlatformResourcesExample();
		prExample.createCriteria().andResourceIdEqualTo(resourceId)
				.andTypeEqualTo(type);
		platformResourcesDAO.deleteByExample(prExample);
	}

	public List<Organ> listSameLevelOrgans(String organId) {
		List<Organ> organs = new LinkedList<Organ>();
		Organ o = organDAO.selectByPrimaryKey(organId);

		// 判断是否为根机构，如果为根机构直接返回
		String parentId = o.getParentOrganId();
		if (StringUtils.isBlank(parentId)) {
			organs.add(o);
			return organs;
		}

		OrganExample example = new OrganExample();
		OrganExample.Criteria criteria = example.createCriteria();
		criteria.andParentOrganIdEqualTo(parentId);
		organs = organDAO.selectByExample(example);
		return organs;
	}

	public List<Organ> listAllChildren(String organId, boolean isRoot) {
		List<Organ> organs = new LinkedList<Organ>();
		if (isRoot) {
			Organ root = organDAO.selectByPrimaryKey(organId);
			organs.add(root);
		}
		List<Organ> children = getChildOrganById(organId);
		organs.addAll(children);
		for (Organ organ : children) {
			organs.addAll(listAllChildren(organ.getId(), false));
		}
		return organs;
	}

	public List<Organ> listAllSameLevelAndChildrenOrgans(String organId) {
		List<Organ> list = new LinkedList<Organ>();
		List<Organ> sameLevelOrgans = listSameLevelOrgans(organId);
		for (Organ organ : sameLevelOrgans) {
			list.addAll(listAllChildren(organ.getId(), true));
		}
		return list;
	}

	public List<Organ> listOrganByOrganIdNextLevel(Map map) {
		return organDAO.listOrganByOrganIdNextLevel(map);
	}

	public int countListOrganByOrganIdNextLevel(Map map) {
		return organDAO.countListOrganByOrganIdNextLevel(map);
	}

	public List<ListOrganVO> listOrganById(String organId) {
		return organDAO.listOrganById(organId);
	}
}
