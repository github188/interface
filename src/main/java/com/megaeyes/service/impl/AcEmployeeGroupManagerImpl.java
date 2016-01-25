package com.megaeyes.service.impl;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.iface.AcREmployeeGroupDAO;
import com.megaeyes.persistence.ibatis.impl.AcEmployeeGroupDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcEmployeeGroup;
import com.megaeyes.persistence.ibatis.model.AcEmployeeGroupExample;
import com.megaeyes.persistence.ibatis.model.AcREmployeeGroup;
import com.megaeyes.persistence.ibatis.model.AcREmployeeGroupExample;
import com.megaeyes.persistence.ibatis.model.UserSession;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcEmployeeGroupManager;

public class AcEmployeeGroupManagerImpl extends BaseManagerImpl implements AcEmployeeGroupManager{

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	AcEmployeeGroupDAOiBatis employeeGroupDAO;
	@Autowired
	AcREmployeeGroupDAO rEmployeeGroupDAO;
	
	@Override
	public String createEmployeeGroup(String organId, String name, String note, String sessionId) throws BusinessException {
		if(StringUtils.isBlank(sessionId)) {
			throw new BusinessException("sessionId不能为空",ErrorCode.USER_SESSION_NOT_FOUND);
		}
		UserSession userSession = userSessionDAO.selectByPrimaryKey(sessionId);
		AcEmployeeGroup record = new AcEmployeeGroup();
		if(StringUtils.isBlank(organId) || StringUtils.isBlank(name)){
			throw new BusinessException("机构ID和组名称不能为空", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		record.setOrganId(organId);
		record.setName(name);
		record.setNote(note);
		String id = sequenceDAO.getAcEmployeeGroupSeq();
		record.setId(id);
		record.setCreatorId(userSession.getUserId());
		record.setCreateTime(new Date());

		employeeGroupDAO.insert(record);
		return id;
	}

	@Override
	public void deleteEmployeeGroup(String id) throws BusinessException {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("ID不能为空", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		AcREmployeeGroupExample example = new AcREmployeeGroupExample();
		example.createCriteria().andGroupIdEqualTo(id);
		rEmployeeGroupDAO.deleteByExample(example);
		
		employeeGroupDAO.deleteByPrimaryKey(id);
		
	}

	@Override
	public void updateEmployeeGroup(String id, String name, String note) throws BusinessException {
		if(StringUtils.isBlank(name)){
			throw new BusinessException("机构ID和组名称不能为空", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		AcEmployeeGroup record = employeeGroupDAO.selectByPrimaryKey(id);
		record.setName(name);
		record.setNote(note);
		employeeGroupDAO.updateByPrimaryKey(record);
	}

	@Override
	public void bindEmployeesToGroup(String jsonString) throws BusinessException {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		String groupId = jsonObject.getString("groupId");
		if(StringUtils.isBlank(groupId)){
			throw new BusinessException("groupId",ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		JSONArray jsonArray = jsonObject.getJSONArray("employeeIds");
		AcREmployeeGroupExample example = new AcREmployeeGroupExample();
		example.createCriteria().andGroupIdEqualTo(groupId);
		rEmployeeGroupDAO.deleteByExample(example);
		if(jsonArray.size() > 0){
			for(int i = 0; i < jsonArray.size(); i++){
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				String employeeId = jsonObj.getString("employeeId");
				if(StringUtils.isNotBlank(employeeId)){
					AcREmployeeGroup record = new AcREmployeeGroup();
					record.setGroupId(groupId);
					record.setEmployeeId(employeeId);
					String id = sequenceDAO.getAcREmployeeGroupSeq();
					record.setId(id);
					rEmployeeGroupDAO.insert(record);
				}
				
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AcEmployeeGroup> getGroupListByOrganId(String organId){
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("机构ID不能为空", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		AcEmployeeGroupExample example = new AcEmployeeGroupExample();
		example.createCriteria().andOrganIdEqualTo(organId);
		List<AcEmployeeGroup> list = employeeGroupDAO.selectByExample(example);
		return list;
	}
	
	public List<AcEmployeeGroup> getGroupListByScheduleId(String scheduleId){
		if(StringUtils.isBlank(scheduleId)){
			throw new BusinessException("排班计划ID不能为空", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		return employeeGroupDAO.getGroupListByScheduleId(scheduleId);
	}

}
