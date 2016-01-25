package com.megaeyes.access.common;

/**
 * 
 * @Title: MessageType.java
 * @Package com.megaeyes.access.common
 * @Description: MessageType
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-21 上午06:35:12
 * @version V1.0
 */
public class MessageType {
	// 版本号
	public static final int PROTOCOL_VERSION = 257;

	// 消息命令类型（同接入服务器相关）

	// J2EE主动请求消息类型

	// 设备参数配置（参数保存在数据库中）
	public static final int DEVICE_CONFIGURE = 1008;

	// 设备参数查询（参数保存在数据库中）
	public static final int DEVICE_QUERY = 1010;

	// 用户登陆
	public static final int USER_LOGON = 1006;

	// 用户注销
	public static final int USER_LOG_OFF = 1016;

	// 自动更新开始
	public static final int AUTO_UPDATE_REQUEST = 8010;

	// 自动更新的连接请求
	public static final int AUTO_UPDATE_CONNECT = 8012;

	// 自动更新开始
	public static final int IPCAMERA_UPDATE_REQUEST = 8014;

	// 自动更新的连接请求
	public static final int IPCAMERA_UPDATE_CONNECT = 8016;

	// 存储服务器状态查询 （状态不保存到数据库中）
	public static final int STORAGE_STATUS_QUERY = 4004;

	public static final int Device_STATUS_QUERY = 4008;

	// J2EE提供服务消息类型
	// 前端注册
	public static final int MSG_TERMINAL_REGISTER = 2002;

	// 分发注册
	public static final int MSG_DISPATCH_REGISTER = 3002;

	// 存储注册
	public static final int MSG_STORAGE_REGISTER = 4002;

	// 显示设备注册
	public static final int MSG_DISPLAY_REGISTER = 6000;

	// 认证
	public static final int MSG_AUTHORIZATION = 1002;

	// 客户端监视器权限验证
	public static final int MSG_MONITOR_AUTH = 1018;

	// 心跳
	public static final int MSG_HEARTBEAT = 2;

	// 协议下载
	public static final int MSG_PROTOCOL_DOWNLOAD = 2004;

	// 报警通知
	public static final int MSG_ALARM_NOTIFY = 2008;

	// 报警确认
	public static final int MSG_ALARM_CONFIRM = 1012;

	// 报警结束
	public static final int MSG_ALARM_STOP = 2010;

	// 故障通知
	public static final int MSG_DEVICE_NOTIFY = 1014;

	// 请求历史视频
	public static final int MSG_HISTORY_VIDEO = 5004;

	// 查询存储方案
	public static final int MSG_QUERY_STORE_SCHEMA = 5014;
	// 设置图象质量参数
	public static final int MSG_SETVIDEO_PARAM = 5074;
	// 获取图象质量参数
	public static final int MSG_GETVIDEO_PARAM = 5076;
	// 恢复摄像头默认参数设置
	public static final int MSG_VIDEO_DEFAULTPARAM = 5078;

	// 前端参数设置
	public static final int MSG_TERMINAL_PARAM = 5046;

	// 在线用户查询
	public static final int MSG_ONLINE_USER_STATUS = 5048;

	// 报警说明信息
	public static final int MSG_ALARM_INFO = 5050;

	// 图像质量参数设置
	public static final int MSG_IMAGE_QUALITY = 5052;

	// 为客户端提供camera的图像质量参数
	public static final int MSG_IMAGE_QUALITY_FOR_CLIENT = 5054;

	// 为客户端提供报警输出设备的状态
	public static final int MSG_ALARM_OUT_STATUS = 5056;

	// 客户端根据camera请求矩阵信息
	public static final int MSG_MATRIX_INFO = 5058;

	// 用户日志
	public static final int USEROPERATIONLOG = 1004;

	// 时间段流量计费
	public static final int USERVIDEOBILL = 5072;

	// 向接入查询在线视频信息
	public static final int MSG_ONLINE_VIDEO_INFO = 1020;

	// 向接入查询一批视频服务器版本信息
	public static final int MSG_DEVICE_VERSION = 1022;

	public static final int MSG_NO_HEART_BEAT = 1024;

	public static final int MSG_ACCESS_REBOOT = 1026;

	public static final int FORMAT_SD_CARD = 1046;

	public static final int SHOOTING = 1048;

	public static final int CAMERA_STATUS_QUERY = 9300;

	public static final int SD_STATUS_QUERY = 1044;

	public static final int IP_CAMERA_RESET = 1050;

	public static final int IP_CAMERA_PARAM_SET = 1052;

	// 摄像头信息变更通知
	public static final int VIC_CHANGE_NOTIFY_REMOVE_STORE_SERVER = 4024;

	public static final int PLAN_QUERY = 5086;
	public static final int ALARM_CONFIG_QUERY = 6090;
	public static final int ALARM_CONFIG_SET = 6092;
	public static final int TIMING_SHOOTING_QUERY = 6094;
	public static final int TIMING_SHOOTING_SET = 6096;
	public static final int ALARM_QUERY = 5026;
	public static final int DETECT_QUERY = 5034;
	public static final int PLAN_SET = 5084;
	public static final int ALARM_SET = 5024;
	public static final int DETECT_SET = 5032;

	// J2EE自反消息类型
	// 服务关闭
	public static final int MSG_SHUT_DOWN = 9999;

	// 源ID定义
	public static final String J2EE_ID = "j2ee_id";

	// 本平台id
	public static final String CENTER_ID = "center_" + getCMSId();

	public static String getCMSId() {

		String id = "error";
		try {
			id = "010001";
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return id;
	}
}
