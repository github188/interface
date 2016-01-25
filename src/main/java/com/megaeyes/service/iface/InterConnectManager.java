package com.megaeyes.service.iface;

import java.util.List;
import java.util.Set;

import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.RtpPayload;
import com.megaeyes.persistence.ibatis.model.SipServer;
import com.megaeyes.persistence.ibatis.model.TempResources;
import com.megaeyes.persistence.ibatis.model.ThirdPartyPlatform;
import com.megaeyes.persistence.ibatis.model.UserSubscribe;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.vo.PlatformVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.persistence.ibatis.vo.VicStorageServerVO;
import com.megaeyes.service.exception.BusinessException;

/**
 * 平台互联接口要用到的方法都放在这里
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-20 下午02:26:22
 */
public interface InterConnectManager extends BaseManager {
	
	/**
	 * 信令网关注册为对外信令服务器的类型
	 */
	public static final String SIP_SERVER_REGISTER_TYPE_WAN = "1";

	/**
	 * 收到下级平台报警后，查询需要通知的本平台用户31位ID
	 * 
	 * @param code
	 *            18位设备地址编码
	 * @param event
	 *            事件类型，目前只有alarm
	 * @return 需要通知的31位平台用户ID
	 */
	public Set<String> listNotifyUser(String code, String event);

	/**
	 * 根据用户ID列表查询，在线用户session和user naming
	 * 
	 * @param ids
	 *            用户ID列表
	 * @return
	 */
	public List<UserSessionVO> listOnlineNotifyUsers(List<String> ids);

	/**
	 * 信令网关注册
	 * 
	 * @param lanIp
	 *            内网服务IP
	 * @param wanIp
	 *            外网服务IP
	 * @param httpPort
	 *            HTTP服务端口
	 * @param sipPort
	 *            信令服务端口
	 * @param megaPort
	 *            内部megaeyes协议通信端口
	 * @param deviceNumber
	 *            14位服务器物理编号，设备唯一标识
	 * @param registerType
	 *            注册类型，0-注册为内部接入模块，1-注册为对外信令模块
	 * @return 注册成功的信令网关
	 * @throws BusinessException
	 */
	public SipServer sipServerRegister(String lanIp, String wanIp,
			int httpPort, int sipPort, int megaPort, String deviceNumber,
			String registerType) throws BusinessException;

	/**
	 * 获取平台的18位SIP地址编码
	 * 
	 * @return
	 */
	public String getPlatformSipCode() throws BusinessException;

	/**
	 * 接收信令网关心跳，修改信令网关心跳时间
	 * 
	 * @param deviceNumber
	 *            物理编号
	 * @return 大于0成功，小于等于0失败
	 */
	public int sipServerHeartbeat(String deviceNumber);

	/**
	 * 获取所有的第三方平台，第三方平台的数据来自下级平台的上线通知
	 * 
	 * @return
	 */
	public List<ThirdPartyPlatform> listThirdPartyPlatform();

	/**
	 * 平台内部资源Naming(没有Naming的则是ID)，转换为18位国网标准sip code
	 * 
	 * @param naming
	 *            资源Naming(没有Naming的则是ID)
	 * @return 18位code
	 */
	public String namingToCode(String naming) throws BusinessException;

	/**
	 * 用户订阅
	 * 
	 * @param userId
	 *            31位平台用户ID
	 * @param platformCode
	 *            平台18位地址编码
	 * @param code
	 *            18位全网SIP资源地址编码（设备，机构）
	 * @param updateTime
	 *            上次修改时间，为空自动填为当前时间
	 * @param event
	 *            订阅类型，默认为alarm
	 * @param type
	 *            32位int报警类型
	 * @throws BusinessException
	 */
	public void userSubscribe(String userId, String platformCode, String code,
			Long updateTime, String event, String type)
			throws BusinessException;

	/**
	 * 18位全网互联SIP地址编码转SIP服务地址
	 * 
	 * @param code
	 *            18位全网互联SIP地址编码，如：180110000001030001
	 * @return sip:180110000001030001@192.168.50.94:5015
	 * @throws BusinessException
	 */
	public String codeToSipUrl(String code) throws BusinessException;

	/**
	 * 平台订阅
	 * 
	 * @param platformCode
	 *            18位全网SIP平台地址编码
	 * @param code
	 *            18位全网SIP资源地址编码（设备，机构）
	 * @param updateTime
	 *            上次修改时间，为空自动填为当前时间
	 * @param event
	 *            订阅类型，默认为alarm
	 * @param type
	 *            32位int报警类型
	 * @throws BusinessException
	 */
	public void platformSubscribe(String platformCode, String code,
			Long updateTime, String event, String type)
			throws BusinessException;

	/**
	 * 取消用户订阅
	 * 
	 * @param userId
	 *            31位平台用户ID
	 * @param code
	 *            18位全网SIP资源地址编码（设备，机构）
	 * @param event
	 *            订阅的类型，默认取消所有类型的订阅
	 * @throws BusinessException
	 */
	public void cancelUserSubscribe(String userId, String code, String event)
			throws BusinessException;

	/**
	 * 取消平台订阅
	 * 
	 * @param platformCode
	 *            18位全网SIP平台地址编码
	 * @param code
	 *            18位全网SIP资源地址编码（设备，机构）
	 * @param type
	 *            32位int告警类型
	 * @param event
	 *            订阅的类型，默认取消所有类型的订阅
	 * @throws BusinessException
	 */
	public void cancelPlatformSubscribe(String platformCode, String code,
			String type, String event) throws BusinessException;

	/**
	 * 获取摄像头rtp payload
	 * 
	 * @param code
	 *            摄像头18sipcode，查找本平台或外平台的资源获取payload值
	 * @return
	 */
	public RtpPayload getRtpPayload(String code) throws BusinessException;

	/**
	 * 平台内设备报警后，查询需要通知出去的平台18位地址编码列表
	 * 
	 * @param code
	 *            18位设备地址编码
	 * @param event
	 *            事件类型，目前只有alarm
	 * @return 需要通知出去的平台18位地址编码列表
	 */
	public Set<String> listNotifyPlatform(String code, String event)
			throws BusinessException;

	/**
	 * 根据18位地址编码获取资源名称
	 * 
	 * @param code
	 *            18位地址编码
	 * @return 资源名称
	 * @throws BusinessException
	 */
	public String codeToName(String code) throws BusinessException;

	/**
	 * 根据SIP编码查询对应的平台资源
	 * 
	 * @param code
	 *            SIP编码
	 * @return
	 */
	public PlatformResources getResourceByCode(String code)
			throws BusinessException;

	/**
	 * 根据31位用户会话ID获取18位用户Code
	 * 
	 * @param sessionId
	 *            用户会话ID
	 * @return 18位用户Code
	 */
	public String getUserCodeBySessionId(String sessionId)
			throws BusinessException;

	/**
	 * 系统上下线通知
	 * 
	 * @param sipCode
	 *            sip服务器编码
	 * @param status
	 *            状态 0:下线 1:上线
	 * @param httpUrl
	 *            http服务的url
	 * @param sipUrl
	 *            sip url
	 * @param name
	 *            平台名称
	 * @param heartbeatTime
	 *            上一次心跳时间
	 * @return
	 */
	public void platformUpdateStatus(String sipCode, Short status,
			String httpUrl, String sipUrl, String name, Long heartbeatTime);

	/**
	 * 列表查询平台中针对某个下级平台资源的报警订阅关系。收到下级平台上线消息，发起重订阅时调用
	 * 
	 * @param platformCode
	 *            下级平台18位地址编码
	 * @return
	 */
	public List<UserSubscribe> listUserSubscribeByPlatformCode(
			String platformCode);

	/**
	 * 获取摄像头的存储服务器地址信息
	 * 
	 * @param id
	 *            摄像头ID
	 * @return
	 */
	public VicStorageServerVO getVicStorageServer(String id);

	/**
	 * 清空父节点下的外平台资源
	 * 
	 * @param parentCode
	 *            父节点
	 */
	public void removeTempResources(String parentCode);

	/**
	 * 获取平台注册的信令网关服务器
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public SipServer getSipServer() throws BusinessException;

	/**
	 * 插入一条外平台资源数据
	 * 
	 * @param code
	 *            资源18位地址编码
	 * @param name
	 *            资源名称
	 * @param status
	 *            状态
	 * @param decodeTag
	 *            解码标签
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param subNum
	 *            子节点数量
	 * @param parentCode
	 *            父节点18位地址编码
	 * @param sipServerIp
	 *            对外信令IP
	 * @throws BusinessException
	 */
	public void addThirdPartyResource(String code, String name, Short status,
			String decodeTag, String longitude, String latitude,
			Integer subNum, String parentCode, String sipServerIp)
			throws BusinessException;

	/**
	 * 根据18位地址编码，获取资源类型。转换依据platform_code_definition.properties。 返回具体类型参见
	 * {@link com.megaeyes.consoleinterface.web.common.DeviceType}
	 * 
	 * @param code
	 *            18位地址编码
	 * @return 资源类型
	 */
	public String getDeviceTypeByCode(String code);

	/**
	 * 获取视频服务器鉴权密码
	 * 
	 * @param code
	 *            视频服务器18位地址编码
	 * @return 鉴权密码
	 * @throws BusinessException
	 */
	public String getVisPassword(String code) throws BusinessException;

	/**
	 * 国标接口B，前端DVR注册
	 * 
	 * @param code
	 *            18位国标地址编码
	 * @param password
	 *            鉴权密码
	 * @param algorithm
	 *            加密方式"MD5"
	 * @param sipServerIp
	 *            设备所注册的信令网关服务器IP
	 * @param deviceIp
	 *            视频服务器IP地址
	 * @param sipPort
	 *            前端信令通信端口
	 * @return 注册成功的31位ID
	 * @throws BusinessException
	 */
	public String visRegister(String code, String password, String algorithm,
			String sipServerIp, String deviceIp, Integer sipPort)
			throws BusinessException;

	/**
	 * 根据设备物理编号（国标地址编码）获取视频服务器
	 * 
	 * @param deviceNumber
	 *            物理编号（国标地址编码）
	 * @return
	 */
	public VideoInputServer getVisByDeviceNumber(String deviceNumber)
			throws BusinessException;

	/**
	 * 国标接口B摄像头注册
	 * 
	 * @param code
	 *            摄像头18位地址编码（物理编号）
	 * @param visId
	 *            所属视频服务器ID
	 * @param status
	 *            摄像头状态0不可用，1可用
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param visNaming
	 *            视频服务器Naming
	 * @throws BusinessException
	 */
	public void vicRegister(String code, String visId, String status,
			String longitude, String latitude, String visNaming)
			throws BusinessException;

	/**
	 * 国标接口B报警输入注册
	 * 
	 * @param code
	 *            18位地址编码（物理编号）
	 * @param visId
	 *            所属视频服务器ID
	 * @param status
	 *            状态0不可用，1可用
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param visNaming
	 *            视频服务器Naming
	 * @throws BusinessException
	 */
	public void aicRegister(String code, String visId, String status,
			String longitude, String latitude, String visNaming)
			throws BusinessException;

	/**
	 * 分页查询平台资源 当父节点是视频服务器的时候，分页没有效果，直接返回视频服务器下的所有摄像头资源
	 * 
	 * @param parentCode
	 *            父节点sip code
	 * @param userCode
	 *            用户sip code
	 * @param start
	 *            查询起始行
	 * @param end
	 *            查询结束行
	 * @return 平台资源列表
	 */
	public List<PlatformResources> listResources(String parentCode,
			String userCode, int start, int end) throws BusinessException;

	/**
	 * 统计满足条件的平台资源节点数量,当父节点是视频服务器的时候，返回视频服务器下的所有摄像头资源数量
	 * 
	 * @param parentCode
	 *            父节点sip code
	 * @param userCode
	 *            用户sip code
	 * @return 平台资源节点数量
	 */
	public Integer countResources(String parentCode, String userCode);

	/**
	 * 查询视频服务器下面所有的共享摄像头和报警输入ID列表
	 * 
	 * @param visId
	 *            视频服务器ID
	 * @return
	 */
	public List<String> listVisSharedChildIds(String visId);

	/**
	 * 根据设备ID查询设备在互联平台中的属性
	 * 
	 * @param id
	 *            设备ID
	 * @return
	 */
	public PlatformResources getPlatformResourceByResourceId(String id);

	/**
	 * 判断是否外平台的设备
	 * 
	 * @param code
	 *            18位国标地址编码
	 * @return 是-true， 不是-false
	 */
	public boolean isThirdPartyResource(String code);

	/**
	 * 查询单个摄像头的历史视频列表
	 * 
	 * @param code
	 *            摄像头的18位sip地址编码，或31位摄像头ID
	 * @param type
	 *            32位录像类型定义
	 * @param userCode
	 *            18位全网用户地址编码
	 * @param beginTime
	 *            录像开始时间
	 * @param endTime
	 *            录像结束时间
	 * @param from
	 *            起始记录数，用于分页
	 * @param to
	 *            结束记录数，用于分页
	 * @return 返回xml，或者没有数据null
	 * @throws BusinessException
	 */
	public String listVicHistoryVideo(String code, String type,
			String userCode, Long beginTime, Long endTime, int from, int to)
			throws BusinessException;

	/**
	 * 根据设备编码，获取外平台对象
	 * 
	 * @param code
	 *            设备编码
	 * @return 外平台对象
	 */
	public ThirdPartyPlatform getThirdPartyPlatformByResourceCode(String code)
			throws BusinessException;

	/**
	 * 获取指定资源的上级资源编码
	 * 
	 * @param code
	 *            资源18位地址编码
	 * @return 上级资源的18位地址编码
	 * @throws BusinessException
	 */
	public String getParentCode(String code) throws BusinessException;

	/**
	 * 系统连接保活
	 * 
	 * @param from
	 *            发送端编码
	 * @param to
	 *            接收端编码
	 * @param heartbeatTime
	 *            心跳时间
	 * @throws BusinessException
	 */
	public void keepAlive(String sipCode, Long heartbeatTime)
			throws BusinessException;

	/**
	 * 根据upper_platform.properties中的配置，获取上级平台列表
	 * 
	 * @return 上级平台列表
	 * @throws BusinessException
	 */
	public List<PlatformVO> listPlatform() throws BusinessException;

	/**
	 * 获取第三方平台的资源列表
	 * 
	 * @param parentCode
	 *            父节点18位国标地址编码
	 * @param platformCode
	 *            第三方平台18位国标地址编码
	 * @return
	 * @throws BusinessException
	 */
	public List<TempResources> listThirdPartyResource(String parentCode,
			String platformCode) throws BusinessException;
}
