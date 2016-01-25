/**   
* @Title: BranchDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-5-3 上午10:31:19 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.BranchDAOImpl;
import com.megaeyes.persistence.ibatis.model.Branch;

/** 
 * @ClassName: BranchDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-5-3 上午10:31:19 
 *  
 */
public class BranchDAOiBatis extends BranchDAOImpl {
	
	@SuppressWarnings("unchecked")
	public List<Branch> getBranchListByBranchId(String parentId,String parentPath){
		Map<String,String> param = new HashMap<String,String>();
		param.put("parentId", parentId);
		param.put("parentPath", parentPath);
		return getSqlMapClientTemplate().queryForList("BRANCH.getBranchListByBranchId", param);
	}
}
