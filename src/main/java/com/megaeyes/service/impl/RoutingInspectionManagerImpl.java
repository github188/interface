/**   
 * @Title: RoutingInspectionManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-7 下午5:26:37 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.AcEmployeesDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.BranchDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpPresetDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRTaskEmployeeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRTaskstepMonitorDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpTaskDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpTaskHistoryDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpTaskInspectionDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpTaskStepDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpTaskStepHistoryDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcEmployees;
import com.megaeyes.persistence.ibatis.model.Branch;
import com.megaeyes.persistence.ibatis.model.EpPreset;
import com.megaeyes.persistence.ibatis.model.EpRTaskEmployee;
import com.megaeyes.persistence.ibatis.model.EpRTaskstepMonitor;
import com.megaeyes.persistence.ibatis.model.EpRTaskstepMonitorExample;
import com.megaeyes.persistence.ibatis.model.EpTask;
import com.megaeyes.persistence.ibatis.model.EpTaskHistory;
import com.megaeyes.persistence.ibatis.model.EpTaskInspection;
import com.megaeyes.persistence.ibatis.model.EpTaskInspectionExample;
import com.megaeyes.persistence.ibatis.model.EpTaskStep;
import com.megaeyes.persistence.ibatis.model.EpTaskStepExample;
import com.megaeyes.persistence.ibatis.model.EpTaskStepHistory;
import com.megaeyes.persistence.ibatis.model.EpTaskStepHistoryExample;
import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.vo.EpRTaskEmployeeDetailVO;
import com.megaeyes.persistence.ibatis.vo.EpRTaskstepMonitorVO;
import com.megaeyes.persistence.ibatis.vo.EpTaskHistoryVO;
import com.megaeyes.persistence.ibatis.vo.EpTaskStepVO;
import com.megaeyes.persistence.ibatis.vo.EpTaskVO;
import com.megaeyes.persistence.ibatis.vo.ListEpRTaskstepMonitorVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.RoutingInspectionManager;

/**
 * @ClassName: RoutingInspectionManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-7 下午5:26:37
 * 
 */
public class RoutingInspectionManagerImpl extends BaseManagerImpl implements
		RoutingInspectionManager {
	@Autowired
	EpTaskInspectionDAOiBatis epTaskInspectionDAO;
	@Autowired
	EpTaskDAOiBatis epTaskDAO;
	@Autowired
	EpTaskStepDAOiBatis epTaskStepDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpRTaskstepMonitorDAOiBatis epRTaskstepMonitorDao;
	@Autowired
	EpRTaskEmployeeDAOiBatis epRTaskEmployeeDAO;
	@Autowired
	EpPresetDAOiBatis epPresetDAO;
	@Autowired
	AcEmployeesDAOiBatis acEmployeesDAO;
	@Autowired
	BranchDAOiBatis branchDAO;
	@Autowired
	OrganDAOiBatis organDAO;
	@Autowired
	EpTaskHistoryDAOiBatis epTaskHistoryDAO;
	@Autowired
	EpTaskStepHistoryDAOiBatis epTaskStepHistoryDAO;

	public List<EpTaskInspection> listEpTaskInspection() {
		EpTaskInspectionExample example = new EpTaskInspectionExample();
		String orderByClause = "type,seq";
		example.setOrderByClause(orderByClause);
		EpTaskInspectionExample.Criteria criteria = example.createCriteria();

		return epTaskInspectionDAO.selectByExample(example);
	}

	public void operateEpTaskInspection(String jsonString) throws JSONException {
		EpTaskInspectionExample example = new EpTaskInspectionExample();
		EpTaskInspectionExample.Criteria criteria = example.createCriteria();
		epTaskInspectionDAO.deleteByExample(example);
		JSONArray jsonArray = new JSONArray(jsonString);
		if (jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = new JSONObject(jsonArray.get(i)
						.toString());
				EpTaskInspection epTaskInspection = new EpTaskInspection();
				String id = sequenceDAO.getEpTaskInstanceSeq();
				String item = jsonObject.getString("item");
				String seq = jsonObject.getString("seq");
				String standard = jsonObject.getString("standard");
				String type = jsonObject.getString("type");
				epTaskInspection.setId(id);
				epTaskInspection.setItem(item);
				epTaskInspection.setSeq(new BigDecimal(seq));
				epTaskInspection.setStandard(standard);
				epTaskInspection.setType(type);
				epTaskInspectionDAO.insert(epTaskInspection);
			}
		}
	}

	public String createEpTask(String jsonString) throws JSONException {
		JSONObject jsonObj = new JSONObject(jsonString);
		String taskName = jsonObj.getString("taskName");
		if (StringUtils.isBlank(taskName)) {
			throw new BusinessException("taskName",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String taskType = jsonObj.getString("taskType");
		if (StringUtils.isBlank(taskType)) {
			throw new BusinessException("taskType",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String organId = jsonObj.getString("organId");
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String taskNote = jsonObj.getString("taskNote");
		String branchId = jsonObj.getString("branchId");
		/*
		 * EpTaskExample example = new EpTaskExample(); EpTaskExample.Criteria
		 * criteria = example.createCriteria();
		 * criteria.andNameEqualTo(taskName); List list =
		 * epTaskDAO.selectByExample(example); System.out.println(list.size());
		 * if (list.size() > 0) { throw new BusinessException("taskName",
		 * ErrorCode.NAME_EXIST); }
		 */
		Long time = System.currentTimeMillis();
		String id = sequenceDAO.getEpTaskSeq();
		EpTask epTask = new EpTask();
		epTask.setId(id);
		epTask.setCreateTime(new BigDecimal(time));
		epTask.setName(taskName);
		epTask.setType(new BigDecimal(taskType));
		epTask.setOrganId(organId);
		epTask.setNote(taskNote);
		epTask.setBranchId(branchId);
		epTaskDAO.insert(epTask);
		JSONArray jsonArray = jsonObj.getJSONArray("steps");
		if (jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonSteps = new JSONObject(jsonArray.getString(i));
				String sequence = jsonSteps.getString("sequence");
				String stepName = jsonSteps.getString("stepName");
				String deviceType = jsonSteps.getString("deviceType");
				String stepNote = jsonSteps.getString("stepNote");
				if (StringUtils.isBlank(sequence)) {
					throw new BusinessException("sequence",
							ErrorCode.PARAMETER_NOT_FOUND);
				}
				if (StringUtils.isBlank(stepName)) {
					throw new BusinessException("stepName",
							ErrorCode.PARAMETER_NOT_FOUND);
				}
				String stepId = sequenceDAO.getEpTaskStepSeq();
				EpTaskStep epts = new EpTaskStep();
				epts.setSeq(Integer.parseInt(sequence));
				epts.setName(stepName);
				epts.setNote(stepNote);
				epts.setTaskId(id);
				epts.setDeviceType(deviceType);
				epts.setId(stepId);
				epTaskStepDAO.insert(epts);
				JSONArray probers = jsonSteps.getJSONArray("probers");
				if (probers.length() > 0) {
					for (int j = 0; j < probers.length(); j++) {
						JSONObject jsonprobers = new JSONObject(
								probers.getString(j));
						String monitorId = jsonprobers.getString("id");
						if (StringUtils.isBlank(monitorId)) {
							throw new BusinessException("id",
									ErrorCode.PARAMETER_NOT_FOUND);
						}
						String epRTaskStepMonitorId = sequenceDAO
								.getEpRTaskStepMonitorSeq();
						EpRTaskstepMonitor ertsm = new EpRTaskstepMonitor();
						ertsm.setId(epRTaskStepMonitorId);
						ertsm.setMonitorId(monitorId);
						ertsm.setStepId(stepId);
						ertsm.setTaskId(id);
						ertsm.setMonitorType(new BigDecimal(2));
						epRTaskstepMonitorDao.insert(ertsm);
					}
				}
				JSONArray vics = jsonSteps.getJSONArray("vics");
				if (vics.length() > 0) {
					for (int k = 0; k < vics.length(); k++) {
						JSONObject jsonvics = new JSONObject(vics.getString(k));
						String monitorId = jsonvics.getString("id");
						JSONArray presetsnum = jsonvics.getJSONArray("presets");
						if (presetsnum.length() > 0) {
							for (int l = 0; l < presetsnum.length(); l++) {
								JSONObject jsonpresets = new JSONObject(
										presetsnum.getString(l));
								String presetsnumid = jsonpresets
										.getString("id");
								if (StringUtils.isBlank(monitorId)) {
									throw new BusinessException("id",
											ErrorCode.PARAMETER_NOT_FOUND);
								}
								String epRTaskStepMonitorId = sequenceDAO
										.getEpRTaskStepMonitorSeq();
								EpRTaskstepMonitor ertsm = new EpRTaskstepMonitor();
								ertsm.setPresetId(presetsnumid);
								ertsm.setId(epRTaskStepMonitorId);
								ertsm.setMonitorId(monitorId);
								ertsm.setStepId(stepId);
								ertsm.setTaskId(id);
								ertsm.setMonitorType(new BigDecimal(1));
								epRTaskstepMonitorDao.insert(ertsm);
							}
						} else {
							String epRTaskStepMonitorId = sequenceDAO
									.getEpRTaskStepMonitorSeq();
							EpRTaskstepMonitor ertsm = new EpRTaskstepMonitor();
							ertsm.setId(epRTaskStepMonitorId);
							ertsm.setMonitorId(monitorId);
							ertsm.setStepId(stepId);
							ertsm.setTaskId(id);
							ertsm.setMonitorType(new BigDecimal(1));
							epRTaskstepMonitorDao.insert(ertsm);
						}

					}
				}
			}
		}
		return id;
	}

	public void deleteTask(String taskId) {
		if (StringUtils.isBlank(taskId)) {
			throw new BusinessException("taskId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try {
			// 删除巡检计划时先删除EP_TASK_STEP表记录
			EpTaskStepExample TaskStepExample = new EpTaskStepExample();
			EpTaskStepExample.Criteria criteria = TaskStepExample
					.createCriteria();
			criteria.andTaskIdEqualTo(taskId);
			epTaskStepDAO.deleteByExample(TaskStepExample);
			// 删除巡检计划时先删除关系表记录
			EpRTaskstepMonitorExample epRTaskstepMonitorExample = new EpRTaskstepMonitorExample();
			EpRTaskstepMonitorExample.Criteria epRTaskstepMonitorCriteria = epRTaskstepMonitorExample
					.createCriteria();
			epRTaskstepMonitorCriteria.andTaskIdEqualTo(taskId);
			epRTaskstepMonitorDao.deleteByExample(epRTaskstepMonitorExample);

			epTaskDAO.deleteByPrimaryKey(taskId);
		} catch (Exception e) {
			throw new BusinessException("resourceBeUsed",
					ErrorCode.RESOURCE_BE_USED);
		}

	}

	public void updateEpTask(String jsonString) throws JSONException {
		JSONObject jsonObj = new JSONObject(jsonString);
		String taskName = jsonObj.getString("taskName");
		String taskType = jsonObj.getString("taskType");
		String organId = jsonObj.getString("organId");
		String id = jsonObj.getString("id");
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String taskNote = jsonObj.getString("taskNote");
		String branchId = jsonObj.getString("branchId");

		/*
		 * EpTaskExample example = new EpTaskExample(); EpTaskExample.Criteria
		 * criteria = example.createCriteria();
		 * criteria.andNameEqualTo(taskName); List<EpTask> list =
		 * epTaskDAO.selectByExample(example); System.out.println(list.size());
		 * if (list.size() > 1 && list.get(0).getId() != id) { throw new
		 * BusinessException("taskName", ErrorCode.NAME_EXIST); }
		 */
		Long time = System.currentTimeMillis();
		EpTask epTask = new EpTask();
		epTask.setId(id);
		epTask.setCreateTime(new BigDecimal(time));
		epTask.setName(taskName);
		epTask.setType(new BigDecimal(taskType));
		epTask.setOrganId(organId);
		epTask.setNote(taskNote);
		epTask.setBranchId(branchId);
		// 更新task表
		epTaskDAO.updateByPrimaryKeySelective(epTask);
		// 删除EpTaskStep
		EpTaskStepExample TaskStepExample = new EpTaskStepExample();
		EpTaskStepExample.Criteria EpTaskStepcriteria = TaskStepExample
				.createCriteria();
		EpTaskStepcriteria.andTaskIdEqualTo(id);
		epTaskStepDAO.deleteByExample(TaskStepExample);
		// 删除EpTaskStepMonitor
		EpRTaskstepMonitorExample epRTaskstepMonitorExample = new EpRTaskstepMonitorExample();
		EpRTaskstepMonitorExample.Criteria epRTaskstepMonitorCriteria = epRTaskstepMonitorExample
				.createCriteria();
		epRTaskstepMonitorCriteria.andTaskIdEqualTo(id);
		epRTaskstepMonitorDao.deleteByExample(epRTaskstepMonitorExample);

		JSONArray jsonArray = jsonObj.getJSONArray("steps");
		if (jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonSteps = new JSONObject(jsonArray.getString(i));
				String sequence = jsonSteps.getString("sequence");
				String stepName = jsonSteps.getString("stepName");
				String stepNote = jsonSteps.getString("stepNote");
				String deviceType = jsonSteps.getString("deviceType");
				if (StringUtils.isBlank(sequence)) {
					throw new BusinessException("sequence",
							ErrorCode.PARAMETER_NOT_FOUND);
				}
				if (StringUtils.isBlank(stepName)) {
					throw new BusinessException("stepName",
							ErrorCode.PARAMETER_NOT_FOUND);
				}
				String stepId = sequenceDAO.getEpTaskStepSeq();
				EpTaskStep epts = new EpTaskStep();
				epts.setSeq(Integer.parseInt(sequence));
				epts.setName(stepName);
				epts.setNote(stepNote);
				epts.setTaskId(id);
				epts.setDeviceType(deviceType);
				epts.setId(stepId);
				epTaskStepDAO.insert(epts);
				JSONArray probers = jsonSteps.getJSONArray("probers");
				if (probers.length() > 0) {
					for (int j = 0; j < probers.length(); j++) {
						JSONObject jsonprobers = new JSONObject(
								probers.getString(j));
						String monitorId = jsonprobers.getString("id");
						if (StringUtils.isBlank(monitorId)) {
							throw new BusinessException("id",
									ErrorCode.PARAMETER_NOT_FOUND);
						}
						String epRTaskStepMonitorId = sequenceDAO
								.getEpRTaskStepMonitorSeq();
						EpRTaskstepMonitor ertsm = new EpRTaskstepMonitor();
						ertsm.setId(epRTaskStepMonitorId);
						ertsm.setMonitorId(monitorId);
						ertsm.setStepId(stepId);
						ertsm.setTaskId(id);
						ertsm.setMonitorType(new BigDecimal(2));
						epRTaskstepMonitorDao.insert(ertsm);
					}
				}
				JSONArray vics = jsonSteps.getJSONArray("vics");
				if (vics.length() > 0) {
					for (int k = 0; k < vics.length(); k++) {
						JSONObject jsonvics = new JSONObject(vics.getString(k));
						String monitorId = jsonvics.getString("id");
						JSONArray presetsnum = jsonvics.getJSONArray("presets");
						if (presetsnum.length() > 0) {
							for (int l = 0; l < presetsnum.length(); l++) {
								JSONObject jsonpresets = new JSONObject(
										presetsnum.getString(l));
								String presetsnumid = jsonpresets
										.getString("id");
								if (StringUtils.isBlank(monitorId)) {
									throw new BusinessException("id",
											ErrorCode.PARAMETER_NOT_FOUND);
								}
								String epRTaskStepMonitorId = sequenceDAO
										.getEpRTaskStepMonitorSeq();
								EpRTaskstepMonitor ertsm = new EpRTaskstepMonitor();
								ertsm.setPresetId(presetsnumid);
								ertsm.setId(epRTaskStepMonitorId);
								ertsm.setMonitorId(monitorId);
								ertsm.setStepId(stepId);
								ertsm.setTaskId(id);
								ertsm.setMonitorType(new BigDecimal(1));
								epRTaskstepMonitorDao.insert(ertsm);
							}
						} else {
							String epRTaskStepMonitorId = sequenceDAO
									.getEpRTaskStepMonitorSeq();
							EpRTaskstepMonitor ertsm = new EpRTaskstepMonitor();
							ertsm.setId(epRTaskStepMonitorId);
							ertsm.setMonitorId(monitorId);
							ertsm.setStepId(stepId);
							ertsm.setTaskId(id);
							ertsm.setMonitorType(new BigDecimal(1));
							epRTaskstepMonitorDao.insert(ertsm);
						}

					}
				}
			}
		}
	}

	public String createEpRTaskEmployee(String taskId, String employeeId,
			String userId, String allotUserId, String executeTime,
			BigDecimal executeTimeType, BigDecimal taskType,
			String supportEmployee) {
		if (StringUtils.isBlank(taskId)) {
			throw new BusinessException("taskId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(employeeId)) {
			throw new BusinessException("employeeId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(allotUserId)) {
			throw new BusinessException("allotUserId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(executeTime)) {
			throw new BusinessException("executeTime",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getEpRTaskEmployeeSeq();
		EpRTaskEmployee erte = new EpRTaskEmployee();
		erte.setId(id);
		erte.setTaskId(taskId);
		erte.setEmployeeId(employeeId);
		erte.setUserId(userId);
		erte.setAllotUserId(allotUserId);
		erte.setExecuteTime(executeTime);
		erte.setExecuteTimeType(executeTimeType);
		erte.setTaskType(taskType);
		erte.setSupportEmployee(supportEmployee);
		epRTaskEmployeeDAO.insert(erte);
		return id;
	}

	public List<EpRTaskEmployeeDetailVO> ListEpRTaskEmployee(String taskId,
			String employeeId, String userId, String allotUserId,
			String executeTime) {
		EpRTaskEmployee epRTaskEmployee = new EpRTaskEmployee();
		epRTaskEmployee.setTaskId(taskId);
		epRTaskEmployee.setEmployeeId(employeeId);
		epRTaskEmployee.setUserId(userId);
		epRTaskEmployee.setAllotUserId(allotUserId);
		epRTaskEmployee.setExecuteTime(executeTime);

		List<EpRTaskEmployeeDetailVO> list = epRTaskEmployeeDAO
				.ListEpRTaskEmployee(epRTaskEmployee);
		return list;
	}

	public void deleteEpRTaskEmployee(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try {
			epRTaskEmployeeDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new BusinessException("resourceBeUsed",
					ErrorCode.RESOURCE_BE_USED);
		}
	}

	public List<EpTaskVO> listEpTaskByOrganId(String organId) {

		return epTaskDAO.listEpTaskByOrganId(organId);
	}

	public Map listTaskDetail(String taskId) {
		if (StringUtils.isBlank(taskId)) {
			throw new BusinessException("taskId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpTask epTask = epTaskDAO.selectByPrimaryKey(taskId);
		Map map = new HashMap();
		if (epTask != null) {
			map.put("id", epTask.getId());
			map.put("taskName", epTask.getName());
			map.put("taskType", epTask.getType());
			map.put("organId", epTask.getOrganId());
			map.put("taskNote", epTask.getNote());
			map.put("branchId", epTask.getBranchId());
			EpTaskStepExample stepexample = new EpTaskStepExample();
			String orderByClause = "seq";
			stepexample.setOrderByClause(orderByClause);
			EpTaskStepExample.Criteria criteria = stepexample.createCriteria();
			criteria.andTaskIdEqualTo(taskId);
			List<EpTaskStep> list = epTaskStepDAO.selectByExample(stepexample);
			// System.out.println("list:"+list.size());
			List stepList = new ArrayList();
			if (list.size() > 0) {
				for (EpTaskStep epTaskStep : list) {
					EpTaskStepVO epTaskStepVO = new EpTaskStepVO();
					epTaskStepVO.setId(epTaskStep.getId());
					epTaskStepVO.setDeviceType(epTaskStep.getDeviceType());
					epTaskStepVO.setStepName(epTaskStep.getName());
					epTaskStepVO.setStepNote(epTaskStep.getNote());
					epTaskStepVO.setSequence(epTaskStep.getSeq() + "");
					epTaskStepVO.setTaskId(epTaskStep.getTaskId());
					List<EpRTaskstepMonitor> monitorList = epRTaskstepMonitorDao
							.listEpRTaskstepMonitor(epTaskStep.getId());
					System.out.println("1:" + epTaskStep.getId());
					List probersList = new ArrayList();
					List vicList = new ArrayList();
					String lastMonitorId = null;
					// System.out.println("monitorList:"+monitorList.size());
					if (monitorList.size() > 0) {
						for (EpRTaskstepMonitor monitor : monitorList) {
							Map mMap = new HashMap();
							if (monitor.getMonitorType().equals(
									new BigDecimal(2))) {
								EpRTaskstepMonitorVO vo = new EpRTaskstepMonitorVO();
								vo.setId(monitor.getMonitorId());
								probersList.add(vo);
							}
							/*
							 * System.out .println("lastMonitorId:" +
							 * lastMonitorId);
							 * System.out.println("monitor.getMonitorId():" +
							 * monitor.getMonitorId()); System.out
							 * .println("lastMonitorId!=monitor.getMonitorId():"
							 * + lastMonitorId != monitor .getMonitorId());
							 * System.out
							 * .println("lastMonitorId!=monitor.getMonitorId():"
							 * + monitor.getMonitorId().equals( lastMonitorId));
							 * System.out.println(monitor.getMonitorId().equals(
							 * lastMonitorId));
							 */
							if (monitor.getMonitorType().equals(
									new BigDecimal(1))
									&& !monitor.getMonitorId().equals(
											lastMonitorId)) {

								ListEpRTaskstepMonitorVO vo = new ListEpRTaskstepMonitorVO();
								vo.setId(monitor.getMonitorId());
								List viclist = new ArrayList();
								for (EpRTaskstepMonitor vmonitor : monitorList) {
									if (monitor.getMonitorId().equals(
											vmonitor.getMonitorId())) {
										EpRTaskstepMonitorVO visvo = new EpRTaskstepMonitorVO();
										visvo.setId(vmonitor.getPresetId());
										EpPreset epPreset = epPresetDAO
												.selectByPrimaryKey(vmonitor
														.getPresetId());
										if (epPreset != null) {
											viclist.add(epPreset);
										}
									}
								}
								vo.setPresets(viclist);
								vicList.add(vo);
							}

							lastMonitorId = monitor.getMonitorId();
						}
					}
					epTaskStepVO.setProbers(probersList);
					epTaskStepVO.setVics(vicList);
					stepList.add(epTaskStepVO);
				}
				map.put("steps", stepList);
			}
		}
		return map;
	}

	public void finishTask(String jsonString) throws JSONException {
		JSONObject jsonObj = new JSONObject(jsonString);
		String epRtaskEmployeeId = jsonObj.getString("id");
		String taskResult = jsonObj.getString("result");
		EpRTaskEmployee epRTaskEmployee = epRTaskEmployeeDAO
				.selectByPrimaryKey(epRtaskEmployeeId);
		EpTask epTask = epTaskDAO.selectByPrimaryKey(epRTaskEmployee
				.getTaskId());
		EpTaskHistory taskHistory = new EpTaskHistory();
		String historyTaskId = sequenceDAO.getEpTaskHistoryeq();
		taskHistory.setId(historyTaskId);
		taskHistory.setAllotUserId(epRTaskEmployee.getAllotUserId());
		Branch branch = branchDAO.selectByPrimaryKey(epTask.getBranchId());
		String branchName = null;
		if (branch != null) {
			branchName = branch.getName();
		}

		taskHistory.setBranchName(branchName);
		String EmployeeId = epRTaskEmployee.getEmployeeId();
		AcEmployees acEmployees = acEmployeesDAO.selectByPrimaryKey(EmployeeId);
		String employeeName = null;
		if (acEmployees != null) {
			employeeName = acEmployees.getName();
		}
		taskHistory.setEmployeeName(employeeName);
		Long endTime = System.currentTimeMillis();
		taskHistory.setSupportEmployee(epRTaskEmployee.getSupportEmployee());
		taskHistory.setEmployeeId(EmployeeId);
		taskHistory.setEndTime(endTime.toString());
		taskHistory.setExecuteTime(epRTaskEmployee.getExecuteTime());
		taskHistory.setExecuteTimeType(epRTaskEmployee.getExecuteTimeType());
		taskHistory.setNote(epTask.getNote());
		String organName = null;
		Organ organ = organDAO.selectByPrimaryKey(epTask.getOrganId());
		if (organ != null) {
			organName = organ.getName();
		}
		taskHistory.setOrganName(organName);
		taskHistory.setResult(taskResult);
		taskHistory.setTaskId(epRTaskEmployee.getTaskId());
		taskHistory.setTaskName(epTask.getName());
		taskHistory.setTaskType(epTask.getType());
		taskHistory.setType(new BigDecimal(1));
		taskHistory.setUserId(epRTaskEmployee.getUserId());
		JSONArray jsonArray = jsonObj.getJSONArray("steps");
		epTaskHistoryDAO.insert(taskHistory);
		if (jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonSteps = new JSONObject(jsonArray.getString(i));
				String stepId = jsonSteps.getString("stepId");
				String result = jsonSteps.getString("result");
				System.out.println("result:" + result);
				String stepCaptureId = jsonSteps.getString("stepCaptureId");
				EpTaskStepHistory epTaskStepHistory = new EpTaskStepHistory();
				String taskStephistoryId = sequenceDAO.getEpTaskStepHistoryeq();
				EpTaskStep epTaskStep = epTaskStepDAO
						.selectByPrimaryKey(stepId);
				if (epTaskStep == null) {
					throw new BusinessException("EP_TASK_STEP  STEP_ID",
							ErrorCode.RESOURCE_NOT_FOUND);
				}
				epTaskStepHistory.setDeviceType(epTaskStep.getDeviceType());
				epTaskStepHistory.setHistoryTaskId(historyTaskId);
				epTaskStepHistory.setId(taskStephistoryId);
				epTaskStepHistory.setResult(result);
				epTaskStepHistory.setSeq(new BigDecimal(epTaskStep.getSeq()));
				epTaskStepHistory.setStepId(stepId);
				epTaskStepHistory.setStepCaptureId(stepCaptureId);
				epTaskStepHistory.setStepName(epTaskStep.getName());
				epTaskStepHistory.setStepNote(epTaskStep.getNote());
				epTaskStepHistoryDAO.insert(epTaskStepHistory);
			}
		}
		epRTaskEmployeeDAO.deleteByPrimaryKey(epRtaskEmployeeId);
	}

	public List<EpTaskHistory> listEpTaskHistory() {
		return null;

	}

	public List<EpTaskHistory> listEpTaskHistory(String startTime,
			String endTime, String taskId, String organName, String branchName,
			String employeeName, String userId, String allotUserId,
			String employeeId) {
		EpTaskHistoryVO epTaskHistory = new EpTaskHistoryVO();
		if (!StringUtils.isBlank(startTime)) {
			epTaskHistory.setStartTime(startTime);
		}
		if (!StringUtils.isBlank(endTime)) {
			epTaskHistory.setEndTime(endTime);
		}
		if (!StringUtils.isBlank(allotUserId)) {
			epTaskHistory.setAllotUserId(allotUserId);
		}
		if (!StringUtils.isBlank(taskId)) {
			epTaskHistory.setTaskId(taskId);
		}
		if (!StringUtils.isBlank(organName)) {
			epTaskHistory.setOrganName(organName);
		}
		if (!StringUtils.isBlank(branchName)) {
			epTaskHistory.setBranchName(branchName);
		}

		if (!StringUtils.isBlank(employeeName)) {
			epTaskHistory.setEmployeeName(employeeName);
		}
		if (!StringUtils.isBlank(userId)) {
			epTaskHistory.setUserId(userId);
		}
		if (!StringUtils.isBlank(employeeId)) {
			epTaskHistory.setEmployeeId(employeeId);
		}
		return epTaskStepHistoryDAO.listEpTaskStepHistory(epTaskHistory);
	}

	public List<EpTaskStepHistory> listEpTaskStepHistory(String historyTaskId) {
		if (StringUtils.isBlank(historyTaskId)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpTaskStepHistoryExample example = new EpTaskStepHistoryExample();
		EpTaskStepHistoryExample.Criteria criteria = example.createCriteria();
		criteria.andHistoryTaskIdEqualTo(historyTaskId);
		List<EpTaskStepHistory> list = epTaskStepHistoryDAO
				.selectByExample(example);
		return list;

	}
}
