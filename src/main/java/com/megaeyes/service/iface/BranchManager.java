/**   
 * @Title: Branch.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-2 下午3:38:18 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.Branch;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: Branch
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-2 下午3:38:18
 * 
 */
public interface BranchManager extends BaseManager {
	/**
	 * @Title: careateBranch
	 * @Description: TODO(创建部门)
	 * @param name
	 *            名称
	 * @param organid
	 *            机构ID
	 * @param person
	 *            联系人
	 * @param contact
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String careateBranch(String name, String organId, String person,
			String contact, String parentId) throws BusinessException;

	/**
	 * @Title: deleteBranch
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteBranch(String id);

	/**
	 * @Title: listBranchByOrganId
	 * @Description: TODO(根据机构ID查询部门)
	 * @param organId
	 * @return 设定文件
	 * @return List<Branch> 返回类型
	 * @throws
	 */
	public List<Branch> listBranchByOrganId(String organId);

	/**
	 * @Title: updateBranch
	 * @Description: TODO(更新部门)
	 * @param id
	 * @param name
	 * @param organid
	 * @param person
	 * @param contact
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateBranch(String id, String name, String organId,
			String person, String contact);

	/**
	 * 
	 * @Description: 根据部门ID查询子部门列表
	 * @author zhuanqi@megaeyes.com
	 * @param @param branchId
	 * @param @return
	 * @return List<Branch>
	 * @throws
	 */
	public List<Branch> getBranchListByBranchId(String branchId);
}
