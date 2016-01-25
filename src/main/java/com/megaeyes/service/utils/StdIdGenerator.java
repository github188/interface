/**
 * 
 */
package com.megaeyes.service.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 业务编号ID生成器
 * 
 * @author HBJ
 * 
 */
public class StdIdGenerator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2744399961488966008L;
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	synchronized public static String getStdId() {
		String id = sdf.format(new Date());
		id = "00000000000000" + id;
		return id;
	}

	synchronized public static String getDeviceNumber() {
		String deviceNumber = sdf.format(new Date());
		deviceNumber = "000" + deviceNumber;
		return deviceNumber;
	}

	public static String getDate() {
		return sdf2.format(new Date());
	}
}
