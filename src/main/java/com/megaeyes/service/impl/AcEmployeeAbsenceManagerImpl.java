package com.megaeyes.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import test.StringUtil;

import com.megaeyes.persistence.ibatis.impl.AcEmployeeAbsenceRecordDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcEmployeeAbsenceRecord;
import com.megaeyes.persistence.ibatis.model.AcEmployeeAbsenceRecordExample;
import com.megaeyes.persistence.ibatis.model.UserSession;
import com.megaeyes.persistence.ibatis.vo.AcEmployeeAbsentRecordVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.exception.ParameterUnavailableException;
import com.megaeyes.service.iface.AcEmployeeAbsenceManager;
import com.megaeyes.service.utils.DateTimeConvert;

/**
 * 
 * @Title: AcEmployeeAbsentManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhuanqi@megaeyes.com   
 * @date 2013-1-9 上午03:07:13 
 * @version V2.5
 */
public class AcEmployeeAbsenceManagerImpl extends BaseManagerImpl implements AcEmployeeAbsenceManager{
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	AcEmployeeAbsenceRecordDAOiBatis employeeAbsentDAO;

	@Override
	public String createEmployeeAbsent(String sessionId, String type, String employeeId, String startTime, String endTime, 
			String approver, String note,String branchId, String organId,String startDate,String endDate) {
		if(StringUtils.isBlank(type) || StringUtils.isBlank(employeeId)){
			throw new BusinessException("类型和员工编号不能为空", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		UserSession userSession = userSessionDAO.selectByPrimaryKey(sessionId);
		AcEmployeeAbsenceRecord record = new AcEmployeeAbsenceRecord();
		record.setCreatorId(userSession.getUserId());
		record.setCreateTime(new Date());
		record.setType(type);
		record.setEmployeeId(employeeId);
		record.setBranchId(branchId);
		record.setOrganId(organId);
		try {
			record.setStartDate(DateTimeConvert.convertTime4Date(startDate, 1));
			record.setEndDate(DateTimeConvert.convertTime4Date(endDate, 1));
		} catch (ParameterUnavailableException e) {
			throw new BusinessException("日期参数不正确", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		if(StringUtil.isNotBlank(startTime)){
			record.setStartTime(startTime);
		}
		if(StringUtil.isNotBlank(endTime)){
			record.setEndTime(endTime);
		}
		record.setApprover(approver);
		record.setNote(note);
		String id = sequenceDAO.getAcEmployeeAbsentSeq();
		record.setId(id);
		employeeAbsentDAO.insert(record);
		return id;
	}

	@Override
	public void updateEmployeeAbsent(String id , String type, String employeeId, String startTime, String endTime, 
			String approver, String note,String branchId, String organId,String startDate,String endDate) {
		if(StringUtils.isBlank(type) || StringUtils.isBlank(employeeId)){
			throw new BusinessException("类型和员工编号不能为空", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		AcEmployeeAbsenceRecord record = employeeAbsentDAO.selectByPrimaryKey(id);
		record.setType(type);
		record.setEmployeeId(employeeId);
		record.setBranchId(branchId);
		record.setOrganId(organId);
		
		try {
			record.setStartDate(DateTimeConvert.convertTime4Date(startDate, 1));
			record.setEndDate(DateTimeConvert.convertTime4Date(endDate, 1));
		} catch (ParameterUnavailableException e) {
			throw new BusinessException("日期参数不正确", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		record.setStartTime(startTime);
		record.setEndTime(endTime);
		record.setApprover(approver);
		record.setNote(note);
		employeeAbsentDAO.updateByPrimaryKey(record);
	}

	@Override
	public void deleteEmployeeAbsent(String id) {
		employeeAbsentDAO.deleteByPrimaryKey(id);
	}

	
	@SuppressWarnings("unchecked")
	public List<AcEmployeeAbsenceRecord> selectByExample(AcEmployeeAbsenceRecordExample example){
		return employeeAbsentDAO.selectByExample(example);
	}
	
	public List<AcEmployeeAbsentRecordVO> getAbsentListByBranchId(String branchId) {
		if(StringUtil.isBlank(branchId)){
			throw new BusinessException("部门ID不能为空", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		return employeeAbsentDAO.getAbsentListByBranchId(branchId);
	}
}
