/**   
 * @Title: IvuTaskManagerImpl.java 
 * @Package com.megaeyes.consoleinterface.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-6-18 下午1:15:18 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.IvuTaskDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.IvuTask;
import com.megaeyes.persistence.ibatis.model.IvuTaskExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.IvuTaskManager;

/**
 * @ClassName: IvuTaskManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-6-18 下午1:15:18
 * 
 */
public class IvuTaskManagerImpl extends BaseManagerImpl implements
		IvuTaskManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	IvuTaskDAOiBatis ivuTaskDAO;

	public String createIvuTask(BigDecimal ivuTaskId, String cmsAccount,
			String taskId, String cmsAccountPassword, String ivuCode,
			Long algCode, Long algSupplierCode, Long videoSource, String rtsp,
			String http, String customerUserName, String customerUserPassword,
			String cmsIp, Long cmsPort, String cmsGuid, Long resultUpType,
			String resultUpUrl, String resultUpIp, Long resultUpPort,
			String picDataUpIp, Long picDataUpPort, String algPolicy,
			String taskStatus, String actionType, String cameraId,
			String organId) {
		IvuTask task = new IvuTask();
		String id = sequenceDAO.getIvuTaskSeq();
		task.setId(id);
		task.setIvuTaskId(ivuTaskId);
		task.setCmsAccount(cmsAccount);
		task.setTaskId(taskId);
		task.setCmsAccountPassword(cmsAccountPassword);
		task.setIvuCode(ivuCode);
		task.setAlgCode(algCode);
		task.setAlgSupplierCode(algSupplierCode);
		task.setVideoSource(videoSource);
		task.setRtsp(rtsp);
		task.setHttp(http);
		task.setCustomerUserName(customerUserName);
		task.setCustomerUserPassword(customerUserPassword);
		task.setCmsIp(cmsIp);
		task.setCmsPort(cmsPort);
		task.setCmsGuid(cmsGuid);
		task.setResultUpType(resultUpType);
		task.setResultUpUrl(resultUpUrl);
		task.setResultUpPort(resultUpPort);
		task.setAlgPolicy(algPolicy);
		task.setTaskStatus(taskStatus);
		task.setActionType(actionType);
		task.setCameraId(cameraId);
		task.setOrganId(organId);
		ivuTaskDAO.insert(task);
		return id;
	}

	public void deleteIvuTask(String id) {
		ivuTaskDAO.deleteByPrimaryKey(id);
	}

	public List<IvuTask> listIvuTask(String organId) {
		IvuTaskExample example = new IvuTaskExample();
		IvuTaskExample.Criteria criteria = example.createCriteria();
		criteria.andOrganIdEqualTo(organId);
		return ivuTaskDAO.selectByExample(example);
	}

	public void updateIvuTask(String id, BigDecimal ivuTaskId,
			String cmsAccount, String taskId, String cmsAccountPassword,
			String ivuCode, Long algCode, Long algSupplierCode,
			Long videoSource, String rtsp, String http,
			String customerUserName, String customerUserPassword, String cmsIp,
			Long cmsPort, String cmsGuid, Long resultUpType,
			String resultUpUrl, String resultUpIp, Long resultUpPort,
			String picDataUpIp, Long picDataUpPort, String algPolicy,
			String taskStatus, String actionType, String cameraId,
			String organId) {
		IvuTask task = new IvuTask();
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		task.setId(id);
		task.setIvuTaskId(ivuTaskId);
		task.setCmsAccount(cmsAccount);
		task.setTaskId(taskId);
		task.setCmsAccountPassword(cmsAccountPassword);
		task.setIvuCode(ivuCode);
		task.setAlgCode(algCode);
		task.setAlgSupplierCode(algSupplierCode);
		task.setVideoSource(videoSource);
		task.setRtsp(rtsp);
		task.setHttp(http);
		task.setCustomerUserName(customerUserName);
		task.setCustomerUserPassword(customerUserPassword);
		task.setCmsIp(cmsIp);
		task.setCmsPort(cmsPort);
		task.setCmsGuid(cmsGuid);
		task.setResultUpType(resultUpType);
		task.setResultUpUrl(resultUpUrl);
		task.setResultUpPort(resultUpPort);
		task.setAlgPolicy(algPolicy);
		task.setTaskStatus(taskStatus);
		task.setActionType(actionType);
		task.setCameraId(cameraId);
		task.setOrganId(organId);
		ivuTaskDAO.updateByPrimaryKeySelective(task);

	}

}
