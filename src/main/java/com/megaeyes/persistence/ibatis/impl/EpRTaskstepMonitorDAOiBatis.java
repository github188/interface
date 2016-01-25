/**   
* @Title: EpRTaskstepMonitorDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-5-9 上午10:27:22 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpRTaskstepMonitorDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpGatherServer;
import com.megaeyes.persistence.ibatis.model.EpRTaskstepMonitor;

/** 
 * @ClassName: EpRTaskstepMonitorDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-5-9 上午10:27:22 
 *  
 */
public class EpRTaskstepMonitorDAOiBatis extends EpRTaskstepMonitorDAOImpl {
	
	public List<EpRTaskstepMonitor> listEpRTaskstepMonitor(String stepId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_R_TASKSTEP_MONITOR_VIEW.listEpRTaskstepMonitor",stepId);
	}

}
