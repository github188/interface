package com.megaeyes.access.common;

/**
 * 
 * @Title: Operations.java
 * @Package com.megaeyes.access.common
 * @Description: 操作类型
 * @author zhuanqi@megaeyes.com
 * @date 2012-11-29 上午07:07:40
 * @version V1.0
 */
public class Operations {
	// 报警输入联动
	public static final String AIC_CONTROL = "aic_operation";
	// 用户是否登陆
	public static final String MSG_ACCESSAUTH = "MSG_ACCESSAUTH";

	// 实时视频
	public static final String VIC_REALTIME_VIDEO_PLAY = "vic_realtime_video_play_operation";

	// 历史视频
	public static final String VIC_HISTORY_VIDEO_PLAY = "vic_history_video_play_operation";

	// 云台控制
	public static final String VIC_PTZ_CONTROL = "vic_ptz_control_operation";

	// 云台预置位设置
	public static final String VIC_PTZ_SET_CONTROL = "vic_ptz_set_operation";

	// 云台预置位调用
	public static final String VIC_PTZ_CALL_CONTROL = "vic_ptz_init_operation";
}
