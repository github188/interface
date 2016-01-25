/**   
* @Title: EpRTaskEmployeeDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-5-10 下午5:11:09 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpRTaskEmployeeDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpRTaskEmployee;
import com.megaeyes.persistence.ibatis.model.EpRTaskEmployeeExample;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.persistence.ibatis.vo.EpRTaskEmployeeDetailVO;

/** 
 * @ClassName: EpRTaskEmployeeDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-5-10 下午5:11:09 
 *  
 */
public class EpRTaskEmployeeDAOiBatis extends EpRTaskEmployeeDAOImpl {
	
	public List<EpRTaskEmployeeDetailVO> ListEpRTaskEmployee(EpRTaskEmployee epRTaskEmployee) {
		return getSqlMapClientTemplate().queryForList(
				"EP_R_TASK_EMPLOYEE_VIEW.ListEpRTaskEmployee",epRTaskEmployee);
	}
}
