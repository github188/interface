/**   
 * @Title: ErrorCode.java 
 * @Package com.megaeyes.web 
 * @Description: 中心返回的错误编码 
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-2-17 上午10:59:46 
 * @version V1.0   
 */
package com.megaeyes.service.exception;

/**
 * @ClassName: ErrorCode
 * @Description: 中心返回的错误编码
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-2-17 上午10:59:46
 * 
 */

public class ErrorCode {

	/**
	 * 未知错误
	 */
	public static final String ERROR = "99999";
	/**
	 * 成功
	 */
	public static final String SUCCESS = "0";

	/**
	 * 缺少参数
	 */
	public static final String PARAMETER_NOT_FOUND = "100";

	/**
	 * 无效的参数值
	 */
	public static final String PARAMETER_VALUE_INVALIDED = "101";

	/**
	 * 用户会话没找到
	 */
	public static final String USER_SESSION_NOT_FOUND = "102";

	/**
	 * 资源类型未知
	 */
	public static final String RESOURCE_TYPE_UNKNOWN = "103";

	/**
	 * 资源未找到
	 */
	public static final String RESOURCE_NOT_FOUND = "104";
	/**
	 * 通道未找到
	 */
	public static final String CHANNEL_NOT_FOUND = "105";

	/**
	 * 开始时间晚于结束时间
	 */
	public static final String TIME_AFTER = "106";

	/**
	 * 正在使用的无法删除
	 */

	public static final String HAVA_USER_DET_ERROR = "107";

	/**
	 * 物理编号重复
	 */
	public static final String DEVICE_NUMBER_DUPLICATE = "108";

	/**
	 * 业务编号重复
	 */
	public static final String STD_ID_DUPLICATE = "109";

	/**
	 * IP重复
	 */
	public static final String IP_EXIST = "110";

	/**
	 * 名称重复
	 */
	public static final String NAME_EXIST = "111";
	/**
	 * 资源使用中无法删除
	 */
	public static final String RESOURCE_BE_USED = "112";

	/**
	 * 通道重复
	 */
	public static final String CHANNEL_DUPLICATE = "113";

	/**
	 * 设备物理编号未找到
	 */
	public static final String DEVICE_NUMBER_NOT_FOUND = "114";

	/**
	 * 18位国标地址编码重复
	 */
	public static final String SIP_CODE_EXIST = "115";
	/**
	 * 没有找到licence
	 */
	public static final String LICENCE_NOT_FOUND = "201";

	/**
	 * 错误的签名
	 */
	public static final String WRONG_SIGNATURE = "202";

	/**
	 * 摄像头个数溢出
	 */
	public static final String VIDEO_COUNT_OVERFLOW = "203";

	/**
	 * 用户个数溢出
	 */
	public static final String USER_COUNT_OVERFLOW = "204";

	/**
	 * 平台过期
	 */
	public static final String PLATFORM_EXPIRE = "205";

	/**
	 * 无法连接接入服务器
	 */
	public static final String ACCESS_SERVER_EXCEPTION = "206";

	/**
	 * 无法连接数据采集服务器
	 */
	public static final String DATA_SERVER_EXCEPTION = "207";

	/**
	 * 用户登陆名或密码错误
	 */
	public static final String USER_ACCOUNT_ERROR = "300";

	/**
	 * 不是管理员用户
	 */
	public static final String NOT_ADMIN_ACCOUNT = "301";

	/**
	 * 不是根机构管理员
	 */
	public static final String NOT_SUPER_ADMIN = "302";

	/**
	 * 领导用户登录中，其他用户禁止登录
	 */
	public static final String LEADER_USING_STATUS = "303";

	/**
	 * 用户账户被停用
	 */
	public static final String USER_ACCOUNT_SUSPENDED = "304";

	/**
	 * 用户达到最大登陆数
	 */
	public static final String USER_SESSION_MAX_AMOUNT_EXCEEDED = "305";

	/**
	 * 用户没有找到
	 */
	public static final String USER_NOT_FOUND = "306";

	/**
	 * 用户过期
	 */
	public static final String USER_EXPIRE = "307";

	/**
	 * 机构中还存在设备
	 */
	public static final String HAVE_DEVICE_IN_USE = "401";

	/**
	 * 机构业务编号重复
	 */
	public static final String ORGAN_NUMBER_DUPLICATE = "402";

	/**
	 * 机构删除错误
	 */
	public static final String ORGAN_DELETE_EXCEPTION = "403";

	/**
	 * 机构没找到
	 */
	public static final String ORGAN_NOT_FOUND = "404";

	/**
	 * 机构下用户在使用
	 */
	public static final String HAVA_USER = "406";
	
	/**
	 * 存在子节点机构
	 */
	public static final String HAVA_CHILDREN = "407";

	/**
	 * 门禁部分异常 和北京通用：成功标志
	 */
	public static final String AC_SUCCESS = "00000";

	/**
	 * 门禁部分异常 和北京通用 ：失败标志
	 */
	public static final String AC_FAILED = "00001";

	/**
	 * 门禁部分异常 和北京通用：无效参数
	 */
	public static final String AC_PARAMETER_INVALID = "00002";

	/**
	 * 门禁部分异常 和北京通用：对象参数
	 */
	public static final String AC_TARGET_NOT_FOUND = "00003";

	/**
	 * 注册的服务器已经存在异常
	 */
	public static final String REGISTER_SERVER_EXIST = "500";
	/**
	 * 平台没有编码，平台没有互联
	 */
	public static final String NO_PLATFORM_CODE = "501";
	/**
	 * 查找的payload值不存在
	 */
	public static final String RTP_PAYLOAD_NOT_FOUND = "502";
	/**
	 * 设备未注册
	 */
	public static final String DEVICE_NOT_REGISTERED = "503";
	/**
	 * 没有已注册的信令网关，平台并没有互联功能
	 */
	public static final String NO_SIP_SERVER_REGISTERED = "504";
	/**
	 * 鉴权失败，密码错误
	 */
	public static final String AUTHORISE_FAILD = "505";
	/**
	 * 父节点错误，设备资源推送时父节点不符合的错误
	 */
	public static final String PARENT_WRONG = "506";
	/**
	 * 报警类型不存在
	 */
	public static final String ALARM_EVENT_TYPE_NOT_FOUND = "507";
	/**
	 * 配置文件解析错误
	 */
	public static final String CONFIG_FILE_PARSE_ERROR = "600";
	/**
	 * 不支持的接口指令号
	 */
	public static final String COMMAND_NOT_SUPPORT = "777";
	
	// 认证无权限
	public static final String NOT_PRIVILEGE = "2001";
}
