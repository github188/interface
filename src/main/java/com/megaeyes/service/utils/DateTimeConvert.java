package com.megaeyes.service.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.megaeyes.service.exception.ParameterUnavailableException;

/**
 * 
 * @Title: DateTimeConvert.java
 * @Package com.megaeyes.service.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhuanqi@megaeyes.com
 * @date 2013-1-8 上午08:21:47
 * @version V2.5
 */
public class DateTimeConvert {
	private static Log logger = LogFactory.getLog(DateTimeConvert.class);

	public static String getFormatStr(int formatType) {
		String formatStr = null;
		switch (formatType) {
		case 1:
			formatStr = "yyyy-MM-dd";
			break;
		case 2:
			formatStr = "yyyy-MM-dd HH:mm:ss";
			break;
		case 3:
			formatStr = "yyyy-MM-dd HH:mm:ss SSS";
			break;
		case 4:
			formatStr = "yyyyMMdd";
			break;
		case 5:
			formatStr = "yyyyMMddHHmmss";
			break;
		case 6:
			formatStr = "yyyyMMddHHmmssSSS";
			break;
		case 7:
			formatStr = "yyyyMM";
			break;
		case 8:
			formatStr = "HH:mm:ss";
			break;
		default:
			formatStr = "yyyy-MM-dd HH:mm:ss";
		}
		return formatStr;
	}

	public static long getLongFromStr(String timeStr, int formatType) {
		long time = 0;
		String formatStr = getFormatStr(formatType);
		if (timeStr != null && timeStr.length() > 0) {
			DateFormat df = new SimpleDateFormat(formatStr);
			try {
				time = df.parse(timeStr).getTime();
			} catch (ParseException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return time;
	}

	public static long getLongFromLong(long timeLong, int formatType) {
		long time = 0;
		if (timeLong > 0) {
			String formatStr = getFormatStr(formatType);
			DateFormat df = new SimpleDateFormat(formatStr);
			time = Long.parseLong(df.format(timeLong));
		}
		return time;
	}

	public static String getStringTime(long timeLong, int formatType) {
		String time = "";
		if (timeLong > 0) {
			String formatStr = getFormatStr(formatType);
			DateFormat df = new SimpleDateFormat(formatStr);
			time = df.format(timeLong);
		}
		return time;
	}

	public static long convertTime4Long(String stime, int formatType)
			throws ParameterUnavailableException {
		Date date = null;
		DateFormat df = new SimpleDateFormat(getFormatStr(formatType));
		try {
			date = df.parse(stime);
		} catch (ParseException e) {
			throw new ParameterUnavailableException();
		}
		return date.getTime();
	}

	public static Date convertTime4Date(String stime, int formatType)
			throws ParameterUnavailableException {
		Date date = null;
		DateFormat df = new SimpleDateFormat(getFormatStr(formatType));
		try {
			date = df.parse(stime);
		} catch (ParseException e) {
			throw new ParameterUnavailableException();
		}
		return date;
	}

	public static String convertTimeString(long time) {
		String s = String.valueOf(time);
		StringBuffer sb = new StringBuffer();
		return sb.append(s.substring(0, 4)).append("-")
				.append(s.substring(4, 6)).append("-")
				.append(s.substring(6, 8)).append(" ")
				.append(s.substring(8, 10)).append(":")
				.append(s.substring(10, 12)).append(":")
				.append(s.substring(12, 14)).toString();
	}

	public static String getMonth(int month) {
		Calendar strDate = Calendar.getInstance();
		strDate.add(Calendar.MONTH, month);
		return DateTimeConvert.getStringTime(strDate.getTime().getTime(), 7);
	}

	/**
	 * 取当前月份第一天日期<br>
	 * 返回yyyy-mm-dd 00:00:00
	 * 
	 * @return String
	 */
	public static Date getCurrMothFirDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar cpcalendar = (Calendar) calendar.clone();
		cpcalendar.set(Calendar.DAY_OF_MONTH, 1);
		cpcalendar.set(Calendar.HOUR_OF_DAY, 0);
		cpcalendar.set(Calendar.MINUTE, 0);
		cpcalendar.set(Calendar.SECOND, 0);
		return new Date(cpcalendar.getTimeInMillis());
	}

	/**
	 * 取当前月份下一月第一天日期<br>
	 * 返回yyyy-mm-dd 00:00:00
	 * 
	 * @return String
	 */
	public static Date getCurrMothLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar cpcalendar = (Calendar) calendar.clone();
		cpcalendar.set(Calendar.DAY_OF_MONTH, 1);
		cpcalendar.add(Calendar.MONTH, 1);
		cpcalendar.add(Calendar.DATE, 0);
		cpcalendar.set(Calendar.HOUR_OF_DAY, 0);
		cpcalendar.set(Calendar.MINUTE, 0);
		cpcalendar.set(Calendar.SECOND, 0);
		return new Date(cpcalendar.getTimeInMillis());
	}

	/**
	 * 获取某年第一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getCurrYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取某年最后一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getCurrYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		return currYearLast;
	}

	/**
	 * 获取当前年份
	 * 
	 * @author: zaq
	 * @date：May 30, 2012 6:17:45 PM
	 * @return
	 * @version 1.0
	 */
	public static String getNowYear() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return formatter.format(new Date());
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 * @throws ParameterUnavailableException
	 */
	public static Date getNowDate(int formatType)
			throws ParameterUnavailableException {
		DateFormat df = new SimpleDateFormat(getFormatStr(formatType));
		String str = df.format(new Date());
		return DateTimeConvert.convertTime4Date(str, formatType);
	}

	public static void main(String args[]){

	}
}
