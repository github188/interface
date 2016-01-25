package com.megaeyes.access.common;

import java.util.HashMap;

/**
 * 
 * @Title: J2eeTypeTranslator.java
 * @Package com.megaeyes.access.common
 * @Description: 设备类型映射
 * @author zhuanqi@megaeyes.com
 * @date 2012-11-29 上午06:47:44
 * @version V1.0
 */
public class J2eeTypeTranslator {
	// 设备CMP映射表
	private static HashMap<String, String> deviceTypeTranslator = new HashMap<String, String>();
	// 操作类型映射
	private static HashMap<String, String> operationTranslator = new HashMap<String, String>();

	static {
		// 设备类型　到　设备CMP名称　映射表
		deviceTypeTranslator.put(DeviceType.TERMINAL, "2");
		deviceTypeTranslator.put(DeviceType.DISPATCH, "3");
		deviceTypeTranslator.put(DeviceType.STORAGE, "4");
		deviceTypeTranslator.put(DeviceType.CAMERA, "5");
		deviceTypeTranslator.put(DeviceType.ALARM_IN, "6");
		deviceTypeTranslator.put(DeviceType.DISPLAY, "7");
		deviceTypeTranslator.put(DeviceType.ALARM_OUT, "8");
		deviceTypeTranslator.put(DeviceType.INTELLIGENT_CHANNEL, "9");

		operationTranslator.put(Operations.VIC_REALTIME_VIDEO_PLAY, "0101");
		operationTranslator.put(Operations.VIC_HISTORY_VIDEO_PLAY, "0102");
		operationTranslator.put(Operations.VIC_PTZ_CONTROL, "0103");
		operationTranslator.put(Operations.VIC_PTZ_SET_CONTROL, "0103");
		operationTranslator.put(Operations.VIC_PTZ_CALL_CONTROL, "0103");
	}

	public static String getCppResourceCodeFromDeviceType(String deviceType) {
		return deviceTypeTranslator.get(deviceType);
	}

	public static String getOPerationNumberFromOperationType(
			String operationType) {
		return operationTranslator.get(operationType);
	}
}