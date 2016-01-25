/**   
 * @Title: CheckSessionAspect.java 
 * @Package com.megaeyes.web.aop.aspect 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-5-25 下午3:44:34 
 * @version V1.0   
 */
package com.megaeyes.web.aop.aspect;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BaseManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.controller.BaseController;
import com.megaeyes.web.response.BaseResponse;

/**
 * @ClassName: CheckSessionAspect
 * @Description: 检查Session的切面
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-5-25 下午3:44:34
 * 
 */
@Aspect
public class CheckSessionAspect {

	@Autowired
	BaseManager baseManager;

	public static Logger log = Logger.getLogger(CheckSessionAspect.class);

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controllerBean() {

	}

	@Pointcut("execution(* *(..) )")
	public void checkSessionPointcut() {
	}

	@Around(value = "controllerBean() && checkSessionPointcut()")
	public void afterMethodInControllerClass(ProceedingJoinPoint pointcut)
			throws Throwable {
		Class c = pointcut.getTarget().getClass();

		Method method = pointcut
				.getTarget()
				.getClass()
				.getMethod(pointcut.getSignature().getName(),
						HttpServletRequest.class, HttpServletResponse.class);
		ControllerDescription descriptionAnnotation = method
				.getAnnotation(ControllerDescription.class);
		String interfaceName = method.getAnnotation(RequestMapping.class)
				.value()[0];
		log.info("in interface " + interfaceName + " ...............");
		HttpServletRequest request = (HttpServletRequest) pointcut.getArgs()[0];
		String sessionId = (String) request.getParameter("sessionId");
		Map<String, String[]> map = request.getParameterMap();
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String[] o = map.get(key);
			String value = o != null ? o[0] : null;
			if (null != value) {
				value = new String(value.getBytes("iso-8859-1"), "utf8");
			}
			request.setAttribute(key, value);
		}

		try {
			if (descriptionAnnotation.isCheckSession() == true) {

				baseManager.checkSessionId(sessionId);
			}
			pointcut.proceed();

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();
		} catch (BusinessException e) {
			HttpServletResponse response = (HttpServletResponse) pointcut
					.getArgs()[1];

			BaseResponse resp = new BaseResponse();
			resp.setCode(ErrorCode.USER_SESSION_NOT_FOUND);
			String jsonRtn = JSONObject.fromObject(resp).toString();
			response.addHeader("Access-Control-Allow-Origin", "*");
			try {
				response.getWriter().write(
						new String(jsonRtn.getBytes("UTF-8"), "iso-8859-1"));
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
}
