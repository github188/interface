package com.megaeyes.access.action.proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.megaeyes.access.exception.UnknownEJBProxyType;

/**
 * 
 * @Title: MegaeyesEJBProxyFactory.java 
 * @Package com.megaeyes.access.action.proxy 
 * @Description: 代理服务类型
 * @author zhuanqi@megaeyes.com   
 * @date 2012-12-3 上午05:51:14 
 * @version V1.0
 */
public class MegaeyesEJBProxyFactory {
	// 代理服务类型
	public static final String CAMERA_FRAME_RATE_PROXY = "camera_frame_rate_proxy";

	public static final String CAMERA_MAX_BPS_PROXY = "camera_max_bps_proxy";
	
	public static final String CAMERA_CAPTION_PROXY = "camera_caption_proxy";

	public static final String CAMERA_PIC_FORMAT_PROXY = "camera_pic_format_proxy";

	public static final String CAMERA_PIC_QUANTITY_PROXY = "camera_pic_quantity_proxy";

	public static final String CAMERA_VIDEO_PARA_PROXY = "camera_video_para_proxy";

	public static final String USER_SESSION_PROXY = "user_session_proxy";

	public static final String AUTO_UPDATE_PROXY = "auto_update_proxy";

	public static final String STORAGE_STATUS_PROXY = "storage_status_proxy";

	public static final String TERMINAL_PARAM_PROXY = "terminal_param_proxy";

	public static final String DEVICE_STATUS_PROXY = "device_status_proxy";

	public static final String VIDEO_INFO_PROXY = "video_info_proxy";

	public static final String TERMINAL_VERSION_PROXY = "terminal_version_proxy";

	public static final String GET_DEVICES_VERSION_PROXY = "get_devices_version_proxy";

	public static final String SD_CARD_PROXY = "sd_card_proxy";
	
	public static final String SHOOTING_PROXY = "shooting_proxy";
	
	public static final String CAMERA_STATUS_QUERY_PROXY = "camera_status_query_proxy";
	
	public static final String GET_ALARM_CONFIG_PROXY = "get_alarm_config_proxy";
	
	public static final String UPDATE_ALARM_CONFIG_PROXY = "update_alarm_config_proxy";
	
	public static final String CAMERA_CHANGE_NOTIFY_STORE_SERVER="camera_change_notify_store_server";
	
	public static final String IP_CAMERA_CHANGE_NOTIFY_STORE_SERVER="ip_camera_change_notify_store_server";
	
	public static final String CONFIG_BACKUP_NOTIFY_PROXY = "config_backup_notify_proxy";
	
	/**
	 * 获得代理服务实例
	 * 
	 */

    public static MegaeyesEJBProxy getMegaeyesEJBProxy(String proxyType, String accessServerIP) {
		Log Logger = LogFactory.getLog(MegaeyesEJBProxyFactory.class);
		// 获取服务的端口号
		int port = 6003;
		Logger.info("requesting service [ service type: " + proxyType + " IP: "	+ accessServerIP + " port: " + port + " ]");

		// 产生相应的代理服务实例
		if (proxyType.equals(CAMERA_FRAME_RATE_PROXY)) {
			return new CameraFrameRateProxy(accessServerIP, port);
		} else if (proxyType.equals(CAMERA_MAX_BPS_PROXY)) {
			return new CameraMaxBPSProxy(accessServerIP, port);
		} else if (proxyType.equals(CAMERA_PIC_FORMAT_PROXY)) {
			return new CameraPicFormatProxy(accessServerIP, port);
		} else if (proxyType.equals(CAMERA_PIC_QUANTITY_PROXY)) {
			return new CameraPicQuantityProxy(accessServerIP, port);
		} else if (proxyType.equals(CAMERA_VIDEO_PARA_PROXY)) {
			return new CameraVideoParaProxy(accessServerIP, port);
		} else {
			throw new UnknownEJBProxyType("proxy type : " + proxyType);
		}
	}
}