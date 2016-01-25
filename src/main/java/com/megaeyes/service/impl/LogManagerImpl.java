/**   
 * @Title: LogManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-3-7 上午6:31:09 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.AcLogDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpOperationLogDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpOperationLog;
import com.megaeyes.persistence.ibatis.model.EpOperationLogExample;
import com.megaeyes.persistence.ibatis.vo.EpOperationLogVO;
import com.megaeyes.persistence.ibatis.vo.ListLogAndEmployeeVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.LogManager;

/**
 * @ClassName: LogManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-7 上午6:31:09
 * 
 */
public class LogManagerImpl extends BaseManagerImpl implements LogManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;

	@Autowired
	EpOperationLogDAOiBatis epOperationLogDAO;
	
	@Autowired
	AcLogDAOiBatis acLogDAO;

	public String createLog(String userId, String userLoginName,
			String userSessionId, BigDecimal operateTime,
			String operateDescription, String operateorIp, String interfaceName) {

		EpOperationLog rol = new EpOperationLog();
		String id = sequenceDAO.getEpOperationLogSeq();
		rol.setId(id);
		rol.setUserId(userId);
		rol.setUserLoginName(userLoginName);
		rol.setUserSessionId(userSessionId);
		rol.setOperateTime(operateTime);
		rol.setOperateDescription(operateDescription);
		rol.setOperateorIp(operateorIp);
		rol.setInterfaceName(interfaceName);

		epOperationLogDAO.insert(rol);
		return id;
	}

	public void deleteLogById(String[] id) {
		for (int i = 0; i < id.length; i++) {
			epOperationLogDAO.deleteByPrimaryKey(id[i]);
		}
	}

	public EpOperationLog getLogById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epOperationLogDAO.selectByPrimaryKey(id);
	}

	public void updateLog(String id, String userId, String userLoginName,
			String userSessionId, BigDecimal operateTime,
			String operateDescription, String operateorIp, String interfaceName) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(userId)) {
			throw new BusinessException("userId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(userLoginName)) {
			throw new BusinessException("userLoginName",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(userSessionId)) {
			throw new BusinessException("userSessionId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(operateDescription)) {
			throw new BusinessException("operateTime",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(operateorIp)) {
			throw new BusinessException("operateorIp",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(interfaceName)) {
			throw new BusinessException("interfaceName",
					ErrorCode.PARAMETER_NOT_FOUND);
		}

		EpOperationLog rol = new EpOperationLog();
		rol.setId(id);
		rol.setUserId(userId);
		rol.setUserLoginName(userLoginName);
		rol.setUserSessionId(userSessionId);
		rol.setOperateTime(operateTime);
		rol.setOperateDescription(operateDescription);
		rol.setOperateorIp(operateorIp);
		rol.setInterfaceName(interfaceName);
		epOperationLogDAO.updateByPrimaryKeySelective(rol);
	}

	public List<EpOperationLog> listEpOperationLog(String startTime,
			String endTime, String userLoginName) {
		EpOperationLogVO vo = new EpOperationLogVO();

		if (!StringUtils.isBlank(startTime)) {
			vo.setStartTime(startTime);
		}
		if (!StringUtils.isBlank(endTime)) {
			vo.setEndTime(endTime);
		}
		if (!StringUtils.isBlank(userLoginName)) {
			vo.setUserLoginName(userLoginName);
		}
		return epOperationLogDAO.listEpOperationLog(vo);
	}

	
	public List<ListLogAndEmployeeVO> listLogEmployeeByDoorId(String doorId,String startTime,String endTime) {
		
		return acLogDAO.listLogEmployeeByDoorId(doorId,startTime,endTime);
	}
}
