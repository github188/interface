package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcWorkAttendanceRule;
import com.megaeyes.persistence.ibatis.model.AcWorkRule;

public interface AcWorkRuleManager extends BaseManager {

	/**
	 * 
	 * @Description: 创建考勤制度规则
	 * @author zhuanqi@megaeyes.com
	 * @param @param sessionId
	 * @param @param organId
	 * @param @param startDate
	 * @param @param lateOutMinutes
	 * @param @param leaveOutMinutes
	 * @param @param lateStat
	 * @param @param lateStatMinutes
	 * @param @param leaveStat
	 * @param @param leaveStatMinutes
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String createWorkAttendanceRule(String sessionId, String organId,
			String startDate, String lateOutMinutes, String leaveOutMinutes,
			String lateStat, String lateStatMinutes, String leaveStat,
			String leaveStatMinutes);

	/**
	 * 
	 * @Description: 修改考勤制度规则
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @param startDate
	 * @param @param lateOutMinutes
	 * @param @param leaveOutMinutes
	 * @param @param lateStat
	 * @param @param lateStatMinutes
	 * @param @param leaveStat
	 * @param @param leaveStatMinutes 
	 * @return void 
	 * @throws
	 */
	public void updateWorkAttendanceRule(String id, String startDate,
			String lateOutMinutes, String leaveOutMinutes, String lateStat,
			String lateStatMinutes, String leaveStat, String leaveStatMinutes);

	/**
	 * 
	 * @Description: 根据机构ID查询考勤规则信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param organId
	 * @param @return 
	 * @return AcWorkAttendanceRule 
	 * @throws
	 */
	public AcWorkAttendanceRule getWorkAttendanceRule(String organId);
	
	/**
	 * 
	 * @Description: 创建时间段规则
	 * @author zhuanqi@megaeyes.com
	 * @param @param name
	 * @param @param organId
	 * @param @param periodStart
	 * @param @param periodEnd
	 * @param @param firstStartSigned
	 * @param @param secondStartSigned
	 * @param @param firstEndSigned
	 * @param @param secondEndSigned
	 * @param @param startPermitMinutes
	 * @param @param endPermitMinutes
	 * @param @param sessionId
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String createWorkRule(String name, String organId,
			String periodStart, String periodEnd, String firstStartSigned,
			String secondStartSigned, String firstEndSigned,
			String secondEndSigned, String startPermitMinutes,
			String endPermitMinutes, String sessionId);

	/**
	 * 
	 * @Description: 修改时间段规则
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @param name
	 * @param @param periodStart
	 * @param @param periodEnd
	 * @param @param firstStartSigned
	 * @param @param secondStartSigned
	 * @param @param firstEndSigned
	 * @param @param secondEndSigned
	 * @param @param startPermitMinutes
	 * @param @param endPermitMinutes
	 * @param @param sessionId
	 * @param @return
	 * @return String
	 * @throws
	 */
	public void updateWorkRule(String id, String name, String periodStart,
			String periodEnd, String firstStartSigned,
			String secondStartSigned, String firstEndSigned,
			String secondEndSigned, String startPermitMinutes,
			String endPermitMinutes, String sessionId);

	/**
	 * 
	 * @Description: 删除时间段规则
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @return void
	 * @throws
	 */
	public void deleteWorkRule(String id);
	
	
	/**
	 * 
	 * @Description:根据机构ID查询时间段规则列表 
	 * @author zhuanqi@megaeyes.com
	 * @param @param organId
	 * @param @return 
	 * @return List<AcWorkRule> 
	 * @throws
	 */
	public List<AcWorkRule> getWorkRuleListByOrganId(String organId);

}
