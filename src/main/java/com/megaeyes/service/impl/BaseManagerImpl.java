package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.megaeyes.persistence.ibatis.impl.UserSessionDAOiBatis;
import com.megaeyes.persistence.ibatis.model.UserSession;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BaseManager;

@Controller
public class BaseManagerImpl implements BaseManager {
	@Autowired
	UserSessionDAOiBatis userSessionDAO;

	public String checkSessionId(String sessionId) {
		if (sessionId == null || sessionId.equals("")) {
			throw new BusinessException(ErrorCode.USER_SESSION_NOT_FOUND,
					"sessionId");
		}
		UserSession userSession = userSessionDAO.selectByPrimaryKey(sessionId);
		String reMsg;
		if (userSession == null) {
			throw new BusinessException(ErrorCode.USER_SESSION_NOT_FOUND,
					"sessionId");
		} else {
			reMsg = userSession.getUserId();
		}
		return reMsg;
	}

	public String heartBeat(String sessionId) throws BusinessException {
		UserSession userSession = userSessionDAO.selectByPrimaryKey(sessionId);
		String reMsg;
		if (userSession == null) {
			throw new BusinessException(ErrorCode.USER_SESSION_NOT_FOUND,
					"sessionId");
		} else {
			reMsg = userSession.getUserId();
		}
		userSession
				.setHeartbeatTime(BigDecimal.valueOf((new Date().getTime())));
		userSessionDAO.updateByPrimaryKey(userSession);
		return reMsg;
	}

}
