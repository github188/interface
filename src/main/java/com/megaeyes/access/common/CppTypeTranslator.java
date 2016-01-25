package com.megaeyes.access.common;

import java.util.HashMap;
import java.util.Map;

import com.megaeyes.access.exception.UnknownDeviceTypeException;
import com.megaeyes.access.exception.UnknownOperationTypeException;

/**
 * 
 * @Title: CppTypeTranslator.java
 * @Package com.megaeyes.access
 * @Description: 日志操作辅助类
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-19 上午08:22:21
 * @version V1.0
 */

public class CppTypeTranslator {
	// 操作映射表
	static private Map<String, Object> operationTranslator = new HashMap<String, Object>();

	// 资源映射表
	static private Map<String, Object> resourceTranslator = new HashMap<String, Object>();

	// 设备类型映射表
	static private Map<String, Object> deviceTypeTranslator = new HashMap<String, Object>();

	// 资源　CMP　NAME　映射表
	static private Map<String, Object> cmpNameTranslator = new HashMap<String, Object>();

	// 用户操作日志映射表
	static private Map<String, Object> userOperationKeyTranslator = new HashMap<String, Object>();

	// 故障类型映射表
	static private Map<String, Object> notifyTypeTranslator = new HashMap<String, Object>();

	static {
		// 配置操作映射表
		operationTranslator.put("5004", "vic_history_video_play_operation"); // 用户请求历史视频
		operationTranslator.put("4032",	"vic_history_video_play_operation"); // 用户请求历史视频
		operationTranslator.put("5006", "vic_ptz_control_operation"); // 用户控制云台
		operationTranslator.put("5006-set", "vic_ptz_set_operation"); // 设置预置点
		operationTranslator.put("5010",	"vic_realtime_video_play_operation"); // 用户请求实时视频
		operationTranslator.put("5020", "aic_operation"); // 用户设置报警器报警策略
		// 用户登陆验证
		operationTranslator.put("5002", "MSG_ACCESSAUTH"); // 用户设置报警器报警策略

		// 无需验证
		// 新增指令START
		operationTranslator.put("5088", "MSG_USERCALL"); // 用户锁定视频
		operationTranslator.put("5090", "MSG_USERCALL"); // 用户解锁视频
		// 新增指令END

		operationTranslator.put("5008", "MSG_USERCALL"); // 用户呼叫控制
		operationTranslator.put("5012", "MSG_USERSETSTORESCHEME"); // 用户设置存储方案
		operationTranslator.put("5014", "MSG_USERSETSTORESCHEME");// 用户得到存储方案
		operationTranslator.put("5022", "MSG_USERGETALARMSTRATEGY_A"); // 用户得到报警器报警策略
		operationTranslator.put("5024", "MSG_USERSETALARMSTRATEGY_C"); // 用户设置摄像头报警策略
		operationTranslator.put("5026", "MSG_USERGETALARMSTRATEGY_C"); // 用户得到摄像头报警策略
		operationTranslator.put("5028", "MSG_USERSETMATRIXSTRATEGY"); // 用户设置矩阵论询策略
		operationTranslator.put("5030", "MSG_USERGETMATRIXSTRATEGY"); // 用户得到矩阵论询策略
		operationTranslator.put("5032", "MSG_USERSETVIDEOPARAM");// 用户设置视频参数策略
		operationTranslator.put("5034", "MSG_USERGETVIDEOPARAM");// 用户得到视频参数策略
		operationTranslator.put("5042", "MSG_USERGETPTZSTATUS");// 用户得到云台状态
		operationTranslator.put("5044", "MSG_USERSTOPALARMEVENT");// 用户中断报警事件
		operationTranslator.put("5050", "MSG_USERSETALARMINFO");
		operationTranslator.put("5052", "MSG_USERSETVIDEOQUALITY");
		operationTranslator.put("5058", "MSG_USERCTRLMATRIX");
		operationTranslator.put("5060", "MSG_USERSETMATRIXPOLICY");
		operationTranslator.put("5062", "MSG_USERGETMATRIXPOLICY");
		operationTranslator.put("5064", "MSG_USERSETALARMOUTSTATE");
		operationTranslator.put("5066", "MSG_USERGETALARMOUTSTATE");
		operationTranslator.put("5068", "MSG_USERSETMTRPOLICYSTATE");
		operationTranslator.put("5070", "MSG_USERGETMTRPOLICYSTATE");
		operationTranslator.put("6002", "MSG_DISPLAYREALTIMEVIDEO"); // 显示墙请求实时视频，无需权限验证
		operationTranslator.put("6006", "MSG_DISPLAYHISTORYTIMEVIDEO"); // 显示墙请求历史视频，无需权限验证
		operationTranslator.put("5080", "MSG_SETMOVECHECKSTARTANDENDTIME"); // 7.9.设置移动侦测的布撤防时间
		operationTranslator.put("5082", "MSG_QUERYMOVECHECKSTARTANDENDTIME"); // 7.10.查询移动侦测的布撤防时间
		operationTranslator.put("5084", "MSG_SETALARMINPUTSTARTANDENDTIME"); // 7.11.设置报警输入设备的布撤防时间
		operationTranslator.put("5086", "MSG_QUERYALARMINPUTSTARTANDENDTIME"); // 7.12查询报警输入设备的布撤防时间
		operationTranslator.put("10000", "MSG_VIC_REALTIMEVIEO"); // 新增操作码
		operationTranslator.put("10006", "MSG_VIC_REALTIMEVIEO"); // 新增操作码
		operationTranslator.put("10002", "MSG_VIC_REALTIMEVIEO"); // 新增操作码
		operationTranslator.put("10022", "MSG_VIC_REALTIMEVIEO"); // 新增操作码

		// 配置资源映射表
		resourceTranslator.put("1", ResourceType.USER);
		resourceTranslator.put("2", ResourceType.TERMINAL);
		resourceTranslator.put("3", ResourceType.DISPATCH);
		resourceTranslator.put("4", ResourceType.STORAGE);
		resourceTranslator.put("5", ResourceType.CAMERA);
		resourceTranslator.put("6", ResourceType.ALARM_IN);
		resourceTranslator.put("7", ResourceType.MONITOR);
		resourceTranslator.put("8", ResourceType.ALARM_OUT);
		resourceTranslator.put("9", ResourceType.DEPARTMENT);
		resourceTranslator.put("10", ResourceType.ROLE);
		resourceTranslator.put("20", ResourceType.INTELLIGENT_CHANNEL);

		// 配置设备类型映射表
		deviceTypeTranslator.put("2", DeviceType.TERMINAL);
		deviceTypeTranslator.put("3", DeviceType.DISPATCH);
		deviceTypeTranslator.put("4", DeviceType.STORAGE);
		deviceTypeTranslator.put("5", DeviceType.CAMERA);
		deviceTypeTranslator.put("6", DeviceType.ALARM_IN);
		deviceTypeTranslator.put("7", DeviceType.DISPLAY);
		deviceTypeTranslator.put("8", DeviceType.ALARM_OUT);
		deviceTypeTranslator.put("9", DeviceType.IP_CAMERA_VIC);
		deviceTypeTranslator.put("10", DeviceType.INTELLIGENT_CHANNEL);

		// 配置用户日志c++端操作码与j2ee端的映射
		userOperationKeyTranslator.put("5010",	"0000000000000000000000000000001");
		userOperationKeyTranslator.put("5004",	"0000000000000000000000000000002");
		userOperationKeyTranslator.put("5012",	"0000000000000000000000000000003");
		userOperationKeyTranslator.put("5074",	"0000000000000000000000000000004");
		userOperationKeyTranslator.put("5032",	"0000000000000000000000000000005");
		userOperationKeyTranslator.put("5006",	"0000000000000000000000000000006");
		userOperationKeyTranslator.put("6116",	"0000000000000000000000000000007");
		userOperationKeyTranslator.put("6110",	"0000000000000000000000000000008");

		// 设置遮挡区域 设置移动侦测区域 设置字幕使用一个操作码5032
		// userOperationKeyTranslator.put("5032","0000000000000000000000000000009");
		// userOperationKeyTranslator.put("5032","0000000000000000000000000000010");
		userOperationKeyTranslator.put("5024",	"0000000000000000000000000000011");
		userOperationKeyTranslator.put("5020",	"0000000000000000000000000000012");
		userOperationKeyTranslator.put("5044",	"0000000000000000000000000000013");
		userOperationKeyTranslator.put("6002",	"0000000000000000000000000000014");
		userOperationKeyTranslator.put("6006",	"0000000000000000000000000000015");
		userOperationKeyTranslator.put("5106",	"0000000000000000000000000000016");
		userOperationKeyTranslator.put("5102",	"0000000000000000000000000000017");
		userOperationKeyTranslator.put("5080",	"0000000000000000000000000000018"); // 7.9.设置移动侦测的布撤防时间
		userOperationKeyTranslator.put("5082",	"0000000000000000000000000000019"); // 7.10.查询移动侦测的布撤防时间
		userOperationKeyTranslator.put("5084",	"0000000000000000000000000000020"); // 7.11.设置报警输入设备的布撤防时间
		userOperationKeyTranslator.put("5086",	"0000000000000000000000000000021"); // 7.12 查询报警输入设备的布撤防时间
		userOperationKeyTranslator.put("5120",	"0000000000000000000000000000050");

		// 故障类型映射表
		notifyTypeTranslator.put("1", "0000000000000000000000000000001"); // 设备无心跳
		notifyTypeTranslator.put("2", "0000000000000000000000000000002"); // 磁盘空间满
		notifyTypeTranslator.put("3", "0000000000000000000000000000003"); // 视频丢失
		notifyTypeTranslator.put("4", "0000000000000000000000000000004"); // 磁盘损坏
		notifyTypeTranslator.put("5", "0000000000000000000000000000005"); // 磁盘故障

	}

	public static  String getJ2eeNotifyType(String type) throws UnknownOperationTypeException {
		String codeForJ2ee = (String) notifyTypeTranslator.get(type);
		if (codeForJ2ee == null) {
			throw new UnknownOperationTypeException("J2ee type code : "	+ codeForJ2ee);
		}
		return codeForJ2ee;
	}

	public static  String getJ2eeUserOperationLogKey(String cppOperationCode) throws UnknownOperationTypeException {
		String operationCodeForJ2ee = (String) userOperationKeyTranslator.get(cppOperationCode);

		if (operationCodeForJ2ee == null) {
			throw new UnknownOperationTypeException("J2ee operation code : " + cppOperationCode);
		}
		return operationCodeForJ2ee;
	}

	public static  String getJ2eeOperationCode(String cppOperationCode) throws UnknownOperationTypeException {
		String operationCodeForJ2ee = (String) operationTranslator.get(cppOperationCode);
		if (operationCodeForJ2ee == null) {
			if(cppOperationCode.indexOf("5006") > -1){
				return (String)operationTranslator.get("5006");
			}else{
				throw new UnknownOperationTypeException("Cpp operation code : "	+ cppOperationCode);
			}
		}
		return operationCodeForJ2ee;
	}

	public static  String getJ2eeResourceCode(String cppResourceCode) throws UnknownDeviceTypeException {
		String resourceCodeForJ2ee = (String) resourceTranslator.get(cppResourceCode);
		if (resourceCodeForJ2ee == null) {
			throw new UnknownDeviceTypeException("Cpp resource code : "	+ cppResourceCode);
		}
		return resourceCodeForJ2ee;
	}

	public static  String getJ2eeDeviceCode(String cppDeviceCode) throws UnknownDeviceTypeException {
		String deviceCodeForJ2ee = (String) deviceTypeTranslator.get(cppDeviceCode);
		if (deviceCodeForJ2ee == null) {
			throw new UnknownDeviceTypeException("Cpp device code : " + cppDeviceCode);
		}
		return deviceCodeForJ2ee;
	}

	public static  String getJ2eeCMPName(String cppResourceCode) {
		return (String) cmpNameTranslator.get(cppResourceCode);
	}

}