/**   
 * @Title: LogAspect.java 
 * @Package com.megaeyes.web.aop 
 * @Description: 系统记录日志的切面
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-3-5 上午11:00:28 
 * @version V1.0   
 */
package com.megaeyes.web.aop.aspect;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.iface.LogManager;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;

/**
 * @ClassName: LogAspect
 * @Description: 系统记录日志的切面
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-3-5 上午11:00:28
 * 
 */
@Aspect
public class LogAspect {
	/**
	 * @Title: controllerBean
	 * @Description: 所有Controller层都有日志记录
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@Autowired
	LogManager logManager;
	@Autowired
	UserManager userManager;

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controllerBean() {
	}

	/**
	 * @Title: logPointcut
	 * @Description: 日志切点（所有以create、update、delete、login、logout开头的方法 a）
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@Pointcut("execution(* create*(..)) || execution(* update*(..)) || execution(* delete*(..)) || execution(* login*(..)) || execution(* logout*(..))")
	public void logPointcut() {
	}

	/**
	 * @throws UnsupportedEncodingException
	 * @Title: afterMethodInControllerClass
	 * @Description: 调用日志方法
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@AfterReturning(pointcut = "controllerBean() && logPointcut()")
	public void afterMethodInControllerClass(JoinPoint pointcut)
			throws UnsupportedEncodingException {

		try {
			Class c = pointcut.getTarget().getClass();
			Method method = pointcut
					.getTarget()
					.getClass()
					.getMethod(pointcut.getSignature().getName(),
							HttpServletRequest.class, HttpServletResponse.class);
			ControllerDescription descriptionAnnotation = method
					.getAnnotation(ControllerDescription.class);
			if (descriptionAnnotation.isLog() == false)
				return;
			String interfaceName = method.getAnnotation(RequestMapping.class)
					.value()[0];
			HttpServletRequest request = (HttpServletRequest) pointcut
					.getArgs()[0];
			String ip = "";
			if (request.getHeader("X-Forwarded-For") != null) {
				ip = request.getHeader("X-Forwarded-For");
			} else {
				ip = request.getRemoteAddr();
			}
			if (method.getName().equals("login")) {
				logManager
						.createLog(
								null,
								(String) request.getAttribute("loginName"),
								null,
								BigDecimal.valueOf((new Date().getTime())),
								new String(descriptionAnnotation.description()),
								ip, interfaceName);
				return;
			}

			String sessionId = (String) request.getAttribute("sessionId");

			UserSessionVO user = userManager.getSessionById(sessionId);
			logManager.createLog(user.getUserId(), user.getUserName(),
					sessionId, BigDecimal.valueOf(System.currentTimeMillis()),
					new String(descriptionAnnotation.description()), ip,
					interfaceName);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}
}
