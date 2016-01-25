package com.megaeyes.web.common.task;

import java.util.TimerTask;

import com.megaeyes.service.iface.UserManager;

/**
 * 检查用户会话是否过期的任务类
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-18 上午11:13:49
 */
public class CheckSessionTask extends TimerTask {

	private UserManager userManager;

	public CheckSessionTask(UserManager userManager) {
		this.userManager = userManager;
	}

	public void run() {
		userManager.checkSession();
	}

}
