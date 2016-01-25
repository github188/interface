package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.AcLogDAOImpl;
import com.megaeyes.persistence.ibatis.vo.ListLogAndEmployeeVO;

/**
 * AcLogDAOiBatis(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-28 上午02:59:35
 */
public class AcLogDAOiBatis extends AcLogDAOImpl {

	
	/**
	 * 
	 * listLogEmployeeByDoorId 根据门ID和时间段查询员工信息
	 * @param doorId 门ID
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	public List<ListLogAndEmployeeVO> listLogEmployeeByDoorId(String doorId,
			String startTime, String endTime) {
		Map map = new HashMap();
		map.put("doorId",doorId);
		map.put("startTime",startTime);
		map.put("endTime",endTime);
		return getSqlMapClientTemplate().queryForList(
				"AC_LOG_VIEW.listLogEmployeeByDoorId",map);
		
	}

}
