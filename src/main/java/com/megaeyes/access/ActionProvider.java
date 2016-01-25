package com.megaeyes.access;

import java.util.Map;

import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;

/**
 * Action实现类的spring容器动态注入类
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-25 下午01:53:35
 */
public class ActionProvider {

	private Map<String, Action> actionMap;

	public Map<String, Action> getActionMap() {
		return actionMap;
	}

	public void setActionMap(Map<String, Action> actionMap) {
		this.actionMap = actionMap;
	}

	public Action get(String key) throws BusinessException {
		Action action = this.actionMap.get(key);
		if (null == action) {
			throw new BusinessException("messageId[" + key
					+ "] found no mapping Action !",
					ErrorCode.COMMAND_NOT_SUPPORT);
		}
		return action;
	}
}
