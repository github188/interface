package com.megaeyes.access.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.megaeyes.access.exception.ExceptionHandler;

/**
 * 
 * @Title: Utility.java 
 * @Package com.megaeyes.access.util 
 * @Description: 工具类 
 * @author zhuanqi@megaeyes.com   
 * @date 2012-9-19 上午09:02:09 
 * @version V1.0
 */
public class Utility {

	private static String CPP_DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 字符串编码转换，主要用于生成XML（JSP中）
	 */
	public static String charsetConvertForXMLJSP(String str) {

		return Utility.charsetConvert(str, "GBK", "ISO-8859-1");
	}

	/**
	 * 字符串编码转换
	 */
	public static String charsetConvert(String originalString,
			String originalCharset, String targetCharset) {

		if (null == originalString) {
			return null;
		}

		String rtn = null;

		try {
			rtn = new String(originalString.getBytes(originalCharset),	targetCharset);
		} catch (java.io.UnsupportedEncodingException uee) {
			ExceptionHandler.throwRuntimeException(uee);
		}

		return rtn;
	}

	/**
	 * 把日期（Date类型）转换成字符串（与C++约定的格式）。
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToCppString(Date date) {

		if (null == date) {
			return null;
		}

		return new SimpleDateFormat(CPP_DATE_FORMATE).format(date);
	}

	/**
	 * 把字符串（与C++约定的格式）转换成日期（Date类型）。
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date cppStringToDate(String cppDate) {
		if (null == cppDate) {
			return null;
		}

		Date date = null;
		try {
			date = new SimpleDateFormat(CPP_DATE_FORMATE).parse(cppDate);
		} catch (ParseException pe) {
			ExceptionHandler.throwRuntimeException(pe);
		}
		return date;
	}

	static public String bytesToString(byte[] bytes) {

		StringBuffer bytesString = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			bytesString.append(new Byte(bytes[i]).toString());
		}
		return bytesString.toString();

	}


	public static long getLongDateValueFromString(String datestring, boolean isStartTime) {

		String beginTime = null;
		String endTime = null;
		long result = 0;
		if (isStartTime) {
			beginTime = datestring + " 00:00:00";
			System.out.println("getLongDateValueFromString beginTime:" + beginTime);
			Date cppDate = cppStringToDate(beginTime);
			long beginDT = cppDate.getTime();
			result = beginDT;

		} else {
			endTime = datestring + " 23:59:59";
			System.out.println("getLongDateValueFromString endTime:" + endTime);
			Date cppDate = cppStringToDate(endTime);
			long endDT = cppDate.getTime();
			result = endDT;
		}
		return result;

	}

}