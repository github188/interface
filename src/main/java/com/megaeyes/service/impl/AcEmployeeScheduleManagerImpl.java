package com.megaeyes.service.impl;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.iface.AcEmployeeScheduleDAO;
import com.megaeyes.persistence.ibatis.iface.AcRScheduleGroupDAO;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcEmployeeSchedule;
import com.megaeyes.persistence.ibatis.model.AcEmployeeScheduleExample;
import com.megaeyes.persistence.ibatis.model.AcRScheduleGroup;
import com.megaeyes.persistence.ibatis.model.AcRScheduleGroupExample;
import com.megaeyes.persistence.ibatis.model.UserSession;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.exception.ParameterUnavailableException;
import com.megaeyes.service.iface.AcEmployeeScheduleManager;
import com.megaeyes.service.utils.DateTimeConvert;

public class AcEmployeeScheduleManagerImpl extends BaseManagerImpl implements
		AcEmployeeScheduleManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	AcEmployeeScheduleDAO employeeScheduleDAO;
	@Autowired
	AcRScheduleGroupDAO rScheduleGroupDAO;

	@Override
	public String createEmployeeSchedule(String name, String organId,
			String startDate, String note,String sessionId) throws BusinessException {
		if (StringUtils.isBlank(sessionId)) {
			throw new BusinessException("sessionId不能为空",
					ErrorCode.USER_SESSION_NOT_FOUND);
		}
		UserSession userSession = userSessionDAO.selectByPrimaryKey(sessionId);
		AcEmployeeSchedule record = new AcEmployeeSchedule();
		record.setName(name);
		record.setOrganId(organId);
		try {
			record.setStartDate(DateTimeConvert.convertTime4Date(startDate, 1));
		} catch (ParameterUnavailableException e) {
			e.printStackTrace();
			throw new BusinessException("startDate格式错误",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		record.setNote(note);
		String id = sequenceDAO.getAcEmployeeScheduleSeq();
		record.setId(id);
		record.setCreateTime(new Date());
		record.setCreatorId(userSession.getUserId());
		employeeScheduleDAO.insert(record);
		return id;
	}

	@Override
	public void updateEmployeeSchedule(String name, String id,
			String startDate, String note) throws BusinessException {
		AcEmployeeSchedule record = employeeScheduleDAO.selectByPrimaryKey(id);
		record.setName(name);
		try {
			record.setStartDate(DateTimeConvert.convertTime4Date(startDate, 1));
		} catch (ParameterUnavailableException e) {
			e.printStackTrace();
			throw new BusinessException("startDate格式错误",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		record.setNote(note);
		employeeScheduleDAO.updateByPrimaryKey(record);

	}

	@Override
	public void deleteEmployeeSchedule(String id) {
		AcRScheduleGroupExample example = new AcRScheduleGroupExample();
		example.createCriteria().andScheduleIdEqualTo(id);
		rScheduleGroupDAO.deleteByExample(example);
		// 删除排班计划
		employeeScheduleDAO.deleteByPrimaryKey(id);
	}

	@Override
	public void bindScheduleGroup(String jsonString) throws BusinessException {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		String scheduleId = jsonObject.getString("scheduleId");
		if (StringUtils.isBlank(scheduleId)) {
			throw new BusinessException("scheduleId",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		JSONArray jsonArray = jsonObject.getJSONArray("groupIds");
		AcRScheduleGroupExample example = new AcRScheduleGroupExample();
		example.createCriteria().andScheduleIdEqualTo(scheduleId);
		rScheduleGroupDAO.deleteByExample(example);
		if (jsonArray.size() > 0) {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				String groupId = jsonObj.getString("groupId");
				if (StringUtils.isNotBlank(groupId)) {
					AcRScheduleGroup record = new AcRScheduleGroup();
					record.setScheduleId(scheduleId);
					record.setGroupId(groupId);
					String id = sequenceDAO.getAcRScheduleGroupSeq();
					record.setId(id);
					rScheduleGroupDAO.insert(record);
				}

			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<AcEmployeeSchedule> getScheduleListByOrganId(String organId) {
		AcEmployeeScheduleExample example = new AcEmployeeScheduleExample();
		example.createCriteria().andOrganIdEqualTo(organId);
		return employeeScheduleDAO.selectByExample(example);
	}

	@Override
	public void setScheduleWorkRule(String scheduleId, String ruleId) {
		AcEmployeeSchedule record = employeeScheduleDAO.selectByPrimaryKey(scheduleId);
		record.setRuleId(ruleId);
		employeeScheduleDAO.updateByPrimaryKey(record);
	}
}
