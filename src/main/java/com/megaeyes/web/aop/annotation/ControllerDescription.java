/**   
* @Title: ControllerDescrition.java 
* @Package com.megaeyes.web.aop.annotation 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-6-6 上午10:59:46 
* @version V1.0   
*/ 
package com.megaeyes.web.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @ClassName: ControllerDescrition 
 * @Description: 用于描述接口方法的属性 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-6-6 上午10:59:46 
 *  
 */
@Target({ElementType.METHOD}) 
@Retention(RetentionPolicy.RUNTIME) 
@Documented 
@Inherited
public @interface ControllerDescription {
	/** 
	* @Title: description 
	* @Description: 是否记录日志
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	boolean isLog();
	/**
	 * 
	* @Title: Description 
	* @Description: 接口描述
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	String description();
	/**
	 * 
	* @Title: isCheckSession 
	* @Description: 是否校验session 
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	boolean isCheckSession();
}
