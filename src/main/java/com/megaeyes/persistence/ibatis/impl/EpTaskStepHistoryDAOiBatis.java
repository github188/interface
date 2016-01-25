/**   
* @Title: EpTaskStepHistoryDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-5-16 上午9:52:13 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpTaskStepHistoryDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpTaskHistory;
import com.megaeyes.persistence.ibatis.model.EpTaskStepHistory;
import com.megaeyes.persistence.ibatis.vo.EpTaskHistoryVO;

/** 
 * @ClassName: EpTaskStepHistoryDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-5-16 上午9:52:13 
 *  
 */
public class EpTaskStepHistoryDAOiBatis extends EpTaskStepHistoryDAOImpl {

	public List<EpTaskHistory> listEpTaskStepHistory(EpTaskHistoryVO epTaskHistory){
		
		return getSqlMapClientTemplate().queryForList(
				"EP_TASK_HISTORY_VIEW.listEpTaskStepHistory", epTaskHistory);
		
	}
}
