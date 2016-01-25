package com.megaeyes.access.common;

/**
 * 
 * @Title: DeviceType.java 
 * @Package com.megaeyes.access.common 
 * @Description: 设备类型
 * @author zhuanqi@megaeyes.com   
 * @date 2012-9-19 上午08:53:44 
 * @version V1.0
 */
public class DeviceType
{
	//为3.2权限更改,ORGAN_DEVICE表中的设备类型---
	public static final String VIC = "VIC";
	public static final String IPVIC = "IPVIC";
	public static final String VOC = "VOC";
	public static final String AIC = "AIC";
	public static final String AOC = "AOC";
    public static final String IAU = "IAU";//智能分析单元
	
	
	public static final String CAMERA = "VideoInputChannel";
	public static final String IP_CAMERA_VIS = "IpCameraVIS";
	public static final String GENERAL_CAMERA_VIS = "GeneralCameraVIS";
	public static final String ALARM_IN = "AlarmInputChannel";
	public static final String ALARM_OUT = "AlarmOutputChannel";
	public static final String DISPATCH = "DispatchServer";
	public static final String TERMINAL = "VideoInputServer";
	public static final String STORAGE = "StorageServer";
	public static final String DISPLAY = "VideoDisplayDevice";
	public static final String MONITOR = "VideoOutputChannel";
	public static final String IP_CAMERA_200S = "IpCamera200S";
	
	//增加IP_CAMERA_VIC的定义，主要用来对报警进行区分，不需要查找其他vic
	public static final String IP_CAMERA_VIC = "IpCameraVIS";
    public static final String INTELLIGENT_CHANNEL = "IntelligentChannel";
    
    public static String getDeviceTypeFromInt(int typeInt){
    	String retStr = null;
    	switch(typeInt){
    		case 0:
    			retStr = VIC;
    			break;
    		case 1:
    			retStr = IPVIC;
    			break;
    		case 2:
    			retStr = AIC;
    			break;
    		case 3:
    			retStr = AOC;
    			break;
    		case 4:
    			retStr = VOC;
    			break;
    		case 5:
    			retStr = IAU;
    			break;
    	}
    	return retStr;
    }
}
