package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.iface.AcEmployeeScheduleDAO;
import com.megaeyes.persistence.ibatis.iface.AcWorkAttendanceRuleDAO;
import com.megaeyes.persistence.ibatis.iface.AcWorkRuleDAO;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcEmployeeScheduleExample;
import com.megaeyes.persistence.ibatis.model.AcWorkAttendanceRule;
import com.megaeyes.persistence.ibatis.model.AcWorkAttendanceRuleExample;
import com.megaeyes.persistence.ibatis.model.AcWorkRule;
import com.megaeyes.persistence.ibatis.model.AcWorkRuleExample;
import com.megaeyes.persistence.ibatis.model.UserSession;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcWorkRuleManager;

public class AcWorkRuleManagerImpl extends BaseManagerImpl implements
		AcWorkRuleManager {
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	AcWorkRuleDAO workRuleDAO;
	@Autowired
	AcWorkAttendanceRuleDAO attendanceRuleDAO;
	@Autowired
	AcEmployeeScheduleDAO employeeScheduleDAO;

	@Override
	public String createWorkAttendanceRule(String sessionId, String organId,
			String startDate, String lateOutMinutes, String leaveOutMinutes,
			String lateStat, String lateStatMinutes, String leaveStat,
			String leaveStatMinutes) {
		UserSession userSession = userSessionDAO.selectByPrimaryKey(sessionId);
		AcWorkAttendanceRule record = new AcWorkAttendanceRule();
		record.setCreateTime(new Date());
		record.setCreatorId(userSession.getUserId());
		record.setOrganId(organId);
		record.setStartDate(new BigDecimal(startDate));
		record.setLateOutMinutes(new BigDecimal(lateOutMinutes));
		record.setLeaveOutMinutes(new BigDecimal(leaveOutMinutes));
		record.setLateStat(new BigDecimal(lateStat));
		if("0".equals(lateStat)){
			record.setLateStatMinutes(new BigDecimal(lateStatMinutes));
		}
		record.setLeaveStat(new BigDecimal(leaveStat));
		if("0".equals(leaveStat)){
			record.setLeaveStatMinutes(new BigDecimal(leaveStatMinutes));
		}
		String id = sequenceDAO.getAcWorkAttendanceRuleSeq();
		record.setId(id);
		attendanceRuleDAO.insert(record);
		return id;
	}

	@Override
	public void updateWorkAttendanceRule(String id, String startDate,
			String lateOutMinutes, String leaveOutMinutes, String lateStat,
			String lateStatMinutes, String leaveStat, String leaveStatMinutes) {
		AcWorkAttendanceRule record = attendanceRuleDAO.selectByPrimaryKey(id);
		record.setStartDate(new BigDecimal(startDate));
		record.setLateOutMinutes(new BigDecimal(lateOutMinutes));
		record.setLeaveOutMinutes(new BigDecimal(leaveOutMinutes));
		record.setLateStat(new BigDecimal(lateStat));
		if("0".equals(lateStat)){
			record.setLateStatMinutes(new BigDecimal(lateStatMinutes));
		}
		record.setLeaveStat(new BigDecimal(leaveStat));
		if("0".equals(leaveStat)){
			record.setLeaveStatMinutes(new BigDecimal(leaveStatMinutes));
		}
		attendanceRuleDAO.updateByPrimaryKeySelective(record);
	}
	
	@SuppressWarnings("unchecked")
	public AcWorkAttendanceRule getWorkAttendanceRule(String organId){
		AcWorkAttendanceRuleExample example = new AcWorkAttendanceRuleExample();
		example.createCriteria().andOrganIdEqualTo(organId);
		List<AcWorkAttendanceRule> list = attendanceRuleDAO.selectByExample(example);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public String createWorkRule(String name, String organId,
			String periodStart, String periodEnd, String firstStartSigned,
			String secondStartSigned, String firstEndSigned,
			String secondEndSigned, String startPermitMinutes,
			String endPermitMinutes, String sessionId) {
		UserSession userSession = userSessionDAO.selectByPrimaryKey(sessionId);
		AcWorkRule record = new AcWorkRule();
		record.setCreateTime(new Date());
		record.setCreatorId(userSession.getUserId());
		record.setName(name);
		record.setOrganId(organId);
		record.setPeriodStart(periodStart);
		record.setPeriodEnd(periodEnd);
		record.setFirstStartSigned(firstStartSigned);//开始签到时间
		record.setSecondStartSigned(secondStartSigned);//结束签到时间
		record.setFirstEndSigned(firstEndSigned);//开始签退时间
		record.setSecondEndSigned(secondEndSigned);//结束签退时间
		record.setStartPermitMinutes(new BigDecimal(startPermitMinutes));
		record.setEndPermitMinutes(new BigDecimal(endPermitMinutes));
		String id = sequenceDAO.getAcWorkRuleSeq();
		record.setId(id);
		workRuleDAO.insert(record);
		return id;
	}

	@Override
	public void updateWorkRule(String id, String name, String periodStart,
			String periodEnd, String firstStartSigned,
			String secondStartSigned, String firstEndSigned,
			String secondEndSigned, String startPermitMinutes,
			String endPermitMinutes, String sessionId) {
		AcWorkRule record = workRuleDAO.selectByPrimaryKey(id);
		record.setName(name);
		record.setPeriodStart(periodStart);
		record.setPeriodEnd(periodEnd);
		record.setFirstStartSigned(firstStartSigned);//开始签到时间
		record.setSecondStartSigned(secondStartSigned);//结束签到时间
		record.setFirstEndSigned(firstEndSigned);//开始签退时间
		record.setSecondEndSigned(secondEndSigned);//结束签退时间
		record.setStartPermitMinutes(new BigDecimal(startPermitMinutes));
		record.setEndPermitMinutes(new BigDecimal(endPermitMinutes));
		workRuleDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public void deleteWorkRule(String id) {
		AcEmployeeScheduleExample example = new AcEmployeeScheduleExample();
		example.createCriteria().andRuleIdEqualTo(id);
		List<?> list = employeeScheduleDAO.selectByExample(example);
		if(list.size() >0){
			throw new BusinessException("时间段规则正在使用，不能删除", ErrorCode.HAVA_USER_DET_ERROR);
		}
		workRuleDAO.deleteByPrimaryKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AcWorkRule> getWorkRuleListByOrganId(String organId) {
		AcWorkRuleExample example = new AcWorkRuleExample(); 
		example.createCriteria().andOrganIdEqualTo(organId);
		return workRuleDAO.selectByExample(example);
	}

}
