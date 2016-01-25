package com.megaeyes.web.common;

import java.util.List;
import java.util.TimeZone;
import java.util.Timer;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;

import com.megaeyes.persistence.ibatis.queryParameter.UserSessionParameter;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.web.common.task.CheckSessionTask;

/**
 * web应用启动初始化类
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-15 下午02:05:54
 */
public class StartUpListener extends ContextLoaderListener {

	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		/**
		 * 设置JVM时区，不保证有用，最好的方式是确保操作系统时区正确 linux操作系统在: vi /etc/sysconfig/clock
		 * windows操作系统在：控制面板--日期和时间里面设置
		 */
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));

		// 登出所有的当前在线用户
		final ApplicationContext ctx = ContextLoader
				.getCurrentWebApplicationContext();
		final UserManager userManager = (UserManager) ctx
				.getBean("userManager");
		UserSessionParameter parm = new UserSessionParameter();
		parm.setStart(0);
		parm.setLimit(1000);
		List<UserSessionVO> sessions = userManager.listUserSession(parm);
		for (UserSessionVO us : sessions) {
			try {
				userManager.logoff(us.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			// 检查用户会话
			Timer checkSessionTimer = new Timer("CheckSessionThread");
			checkSessionTimer.scheduleAtFixedRate(new CheckSessionTask(
					userManager), 0, UserManager.USER_HEARTBEAT_TIME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}
}
