/**   
 * @Title: BranchManager.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-2 下午3:39:21 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.BranchDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.Branch;
import com.megaeyes.persistence.ibatis.model.BranchExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BranchManager;

/**
 * @ClassName: BranchManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-2 下午3:39:21
 * 
 */
public class BranchManagerImpl extends BaseManagerImpl implements BranchManager {
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	BranchDAOiBatis branchDAO;

	public String careateBranch(String name, String organId, String person,
			String contact, String parentId) throws BusinessException {
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		Branch branch = new Branch();
		String id = sequenceDAO.getBranchSeq();
		branch.setId(id);
		branch.setName(name);
		branch.setPerson(person);
		branch.setOrganId(organId);
		branch.setContact(contact);
		if (StringUtils.isNotBlank(parentId)) {
			try {
				// 子部门，则根据父部门path生成子部门path
				String path = branchDAO.selectByPrimaryKey(parentId).getPath();
				branch.setParentId(parentId);
				branch.setPath(path + "/" + id);
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException("parentId[" + parentId
						+ "] not found !", ErrorCode.RESOURCE_NOT_FOUND);
			}
		} else {
			// 根部门
			branch.setPath("/" + id);
		}
		branchDAO.insert(branch);
		return id;
	}

	public void deleteBranch(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try {
			branchDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new BusinessException("resourceBeUsed",
					ErrorCode.RESOURCE_BE_USED);
		}
	}

	public List<Branch> listBranchByOrganId(String organId) {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		BranchExample example = new BranchExample();
		BranchExample.Criteria criteria = example.createCriteria();
		criteria.andOrganIdEqualTo(organId);
		return branchDAO.selectByExample(example);
	}

	public void updateBranch(String id, String name, String organId,
			String person, String contact) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		Branch branch = new Branch();

		branch.setId(id);
		branch.setName(name);
		// branch.setOrganId(organId);
		branch.setPerson(person);
		branch.setContact(contact);
		branchDAO.updateByPrimaryKeySelective(branch);
	}

	public List<Branch> getBranchListByBranchId(String branchId) {
		if (StringUtils.isBlank(branchId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		Branch parent = branchDAO.selectByPrimaryKey(branchId);
		return branchDAO.getBranchListByBranchId(branchId, parent.getPath());
	}

}
