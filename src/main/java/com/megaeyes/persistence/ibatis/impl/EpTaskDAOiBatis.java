/**   
* @Title: EpTaskDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-5-8 下午2:58:23 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpTaskDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.vo.EpTaskVO;

/** 
 * @ClassName: EpTaskDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-5-8 下午2:58:23 
 *  
 */
public class EpTaskDAOiBatis extends EpTaskDAOImpl {
   
	public List<EpTaskVO> listEpTaskByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_TASK_VIEW.listEpTaskByOrganId",organId);
	}
}
