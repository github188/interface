/**   
 * @Title: CenterDeviceManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-2-20 上午10:20:49 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import org.apache.avalon.framework.service.ServiceException;

import com.megaeyes.persistence.ibatis.model.AcGateway;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.persistence.ibatis.model.EpIntelligentChannel;
import com.megaeyes.persistence.ibatis.model.MediaGatewayServer;
import com.megaeyes.persistence.ibatis.model.SipServer;
import com.megaeyes.persistence.ibatis.vo.ListRemoteStorageServerVO;
import com.megaeyes.persistence.ibatis.vo.StorageInfoQueryVO;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: CenterDeviceManager
 * @Description: 中心设备管理类
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-2-20 上午10:20:49
 * 
 */
public interface CenterDeviceManager extends BaseManager {

	/**
	 * @Title: createAccessServer
	 * @Description: 创建接入服务器
	 * @param name
	 *            接入服务器名称
	 * @param naming
	 *            接入服务器naming信息
	 * @param location
	 *            接入服务器安装地址
	 * @param number
	 *            接入服务器设备号
	 * @param note
	 *            接入服务器备注
	 * @param ip
	 *            接入服务器内网ip
	 * @param stdId
	 *            接入服务器业务编码
	 * @param ip1
	 *            接入服务器外网ip
	 * @param epDeviceType
	 *            暂时不用
	 * @return 接入服务器id（字符串类型）
	 * @throws BusinessException
	 */
	public String createAccessServer(String name, String naming,
			String location, String number, String note, String ip, String ip1)
			throws BusinessException;

	/**
	 ** @Title: deleteAccessServer
	 * @Description: 删除接入服务器
	 * @param accessServerId
	 *            接入服务器ID
	 * @throws BusinessException
	 */

	public void deleteAccessServer(String accessServerId)
			throws BusinessException;

	/**
	 * Title: updateAccessServer
	 * 
	 * @Description:获取所有接入服务器
	 * @throws BusinessException
	 */
	public List<AccessServer> listAccessServer() throws BusinessException;

	/**
	 * @Title: updateAccessServer
	 * @Description:更改接入服务器
	 * @param accessServerId
	 *            接入服务器ID
	 * @param name
	 *            名称
	 * @param naming
	 *            接入服务器naming信息
	 * @param deviceNumber
	 *            物理编号
	 * @param installLocation
	 *            安装位置
	 * @param ip
	 *            广域网IP
	 * @param ip1
	 *            局域网IP
	 * @param stdId
	 *            业务编号
	 * @param note
	 *            备注
	 * @throws BusinessException
	 */
	public void updateAccessServer(String accessServerId, String name,
			String naming, String deviceNumber, String installLocation,
			String ip, String ip1, String stdId, String note)
			throws BusinessException;

	/**
	 * @Title: getAccessServerById
	 * @Description: 获取指定ID的接入服务器信息
	 * @param id
	 * @return 设定文件
	 * @return AccessServerResponse 返回类型
	 * @throws
	 */
	public AccessServer getAccessServerById(String id);

	/**
	 * @Title: createDispatchServer
	 * @Description: 创建分发服务器
	 * @param name
	 *            名称
	 * @param naming
	 *            分发服务器naming信息
	 * @param deviceNumber
	 *            物理编号
	 * @param stdId
	 *            业务编号
	 * @param heartCycle
	 *            心跳周期
	 * @param location
	 *            安装位置
	 * @param maxInputAmount
	 *            最大输入视频流路数
	 * @param maxOutputAmount
	 *            最大输出视频流路数
	 * @param msgPort
	 *            消息端口
	 * @param note
	 *            备注
	 * @param reservedOutputAmount
	 *            预留连接数目
	 * @param ownerShip
	 *            是否能被接入所调度。 private:不能， public:能
	 * @param videoPort
	 *            视频流监听端口
	 * @return 创建成功的分发ID
	 * @throws BusinessException
	 */
	public String createDispatchServer(String name, String naming,
			String deviceNumber, String stdId, Long heartCycle,
			String location, Long maxInputAmount, Long maxOutputAmount,
			Long msgPort, String note, Long reservedOutputAmount,
			String ownerShip, Long videoPort) throws BusinessException;

	/**
	 * @Title: deleteDispatchServer
	 * @Description: 删除分发服务器
	 * @param id
	 *            要删除的分发服务器ID
	 * @throws BusinessException
	 */
	public void deleteDispatchServer(String id) throws BusinessException;

	/**
	 * @Title: listDispatchServer
	 * @Description: 查询所有的分发服务器
	 * @return 分发服务器列表
	 * @throws BusinessException
	 */
	public List<DispatchServer> listDispatchServer() throws BusinessException;

	/**
	 * @Title: getDispatchServerById
	 * @Description: 获取指定ID的分发服务器信息
	 * @param id
	 *            分发服务器ID
	 * @return DispatchServer
	 * @throws BusinessException
	 */
	public DispatchServer getDispatchServerById(String id)
			throws BusinessException;

	/**
	 * @Title: updateDispatchServer
	 * @Description: 更改分发服务器
	 * @param id
	 *            分发服务器ID
	 * @param name
	 *            名称
	 * @param naming
	 *            分发服务器naming信息
	 * @param deviceNumber
	 *            物理编号
	 * @param stdId
	 *            业务编号
	 * @param heartCycle
	 *            心跳周期
	 * @param location
	 *            安装位置
	 * @param maxInputAmount
	 *            最大输入视频流路数
	 * @param maxOutputAmount
	 *            最大输出视频流路数
	 * @param msgPort
	 *            消息端口
	 * @param note
	 *            备注
	 * @param reservedOutputAmount
	 *            预留连接数目
	 * @param ownerShip
	 *            是否能被接入所调度。 private:不能， public:能
	 * @throws BusinessException
	 */
	public void updateDispatchServer(String id, String name, String naming,
			String deviceNumber, String stdId, Long heartCycle,
			String location, Long maxInputAmount, Long maxOutputAmount,
			Long msgPort, String note, Long reservedOutputAmount,
			String ownerShip) throws BusinessException;

	/**
	 * @Title: createACGateway
	 * @Description: 创建门禁网关
	 * @param name
	 *            名称
	 * @param lanIp
	 *            局域网IP
	 * @param wanIp
	 *            广域网IP
	 * @param installLocation
	 *            安装位置
	 * @param note
	 *            备注
	 * @param naming
	 *            Naming
	 * @param port
	 *            端口
	 * @param organId
	 *            所属机构
	 * @param deviceNumber
	 *            物理编号
	 * @return 创建成功的ID
	 * @throws BusinessException
	 */
	public String createACGateway(String name, String lanIp, String wanIp,
			String installLocation, String note, String naming, Integer port,
			String organId, String deviceNumber) throws BusinessException;

	/**
	 * @Title: deleteACGateway
	 * @Description:删除门禁网关
	 * @param id
	 *            ID
	 * @param forceDelete
	 *            true-强制删除，false-不强制删除
	 * @return 被删除的门禁网关名称
	 * @throws ServiceException
	 * @throws BusinessException
	 */
	public String deleteACGateway(String id) throws BusinessException;

	/**
	 * @Title: listAcGateway
	 * @Description: 列表查询所有的门禁网关
	 * @return
	 * @throws BusinessException
	 */
	public List<AcGateway> listAcGateway() throws BusinessException;

	/**
	 * @Title: getAcGateway
	 * @Description: TODO(根据ID查询门禁网关)
	 * @param @param id
	 * @param @return 设定文件
	 * @return AcGateway 返回类型
	 * @throws
	 */
	public AcGateway getAcGateway(String id);

	/**
	 * 
	 * @Title: getAcGatewayByDeviceNumber
	 * @Description: 根据设备号查询门禁网关
	 * @param @param deviceNumber 设备编号
	 * @param @return 设定文件
	 * @return AcGateway 返回类型
	 * @throws
	 */
	public AcGateway getAcGatewayByDeviceNumber(String deviceNumber);

	/**
	 * @Title: updateACGateway
	 * @Description: 修改门禁网关
	 * @param id
	 *            ID
	 * @param name
	 *            名称
	 * @param lanIp
	 *            局域网IP
	 * @param wanIp
	 *            广域网IP
	 * @param installLocation
	 *            安装位置
	 * @param note
	 *            备注
	 * @param naming
	 *            Naming
	 * @param port
	 *            端口
	 * @param organId
	 *            所属机构
	 * @param deviceNumber
	 *            物理编号
	 * @throws BusinessException
	 */
	public void updateACGateway(String id, String name, String lanIp,
			String wanIp, String installLocation, String note, String naming,
			Integer port, String organId, String deviceNumber)
			throws BusinessException;

	/**
	 * @Title: createStorageServer
	 * @Description: 修改门禁网关创建中心存储服务器
	 * @param name
	 *            名称
	 * @param deviceNumber
	 *            物理编号
	 * @param stdId
	 *            业务编号
	 * @param ip
	 *            双网卡IP1，一般为主IP
	 * @param ip2
	 *            双网卡IP2，一般为副IP
	 * @param location
	 *            安装位置
	 * @param heartCycle
	 *            心跳周期
	 * @param linkType
	 *            连接方式"lan":局域网，"wan":广域网
	 * @param maxInputAmount
	 *            最大输入连接数
	 * @param maxOutputAmount
	 *            最大输出连接数
	 * @param ftpPort
	 *            FTP端口
	 * @param ftpUserName
	 *            FTP用户名
	 * @param ftpPassword
	 *            FTP用户密码
	 * @param messagePort
	 *            消息端口
	 * @param note
	 *            备注
	 * @return String[0]:创建成功的存储ID，String[1]:成功或失败编码
	 * @throws BusinessException
	 */
	public String createStorageServer(String name, String deviceNumber,
			String stdId, String ip, String ip2, String location,
			long heartCycle, String linkType, long maxInputAmount,
			long maxOutputAmount, long ftpPort, String ftpUserName,
			String ftpPassword, long messagePort, String note, boolean hasVod,
			String epDeviceType) throws BusinessException;

	/**
	 * @Title: deleteStorageServer
	 * @Description: 删除中心存储服务器
	 * @param id
	 *            要删除的存储服务器ID
	 * @throws BusinessException
	 */
	public void deleteStorageServer(String id) throws BusinessException;

	// 待定 public RSSVO getStorageServerById(String id);
	/**
	 * @Title: ListStorageServer
	 * @Description: TODO(查询远程存储)
	 * @param @return 设定文件
	 * @return List<StorageServer> 返回类型
	 * @throws
	 */
	public List<ListRemoteStorageServerVO> ListStorageServer();

	/**
	 * @Title: updateStorageServer
	 * @Description: 更新存储服务器
	 * @param id
	 *            存储服务器ID
	 * @param name
	 *            名称
	 * @param deviceNumber
	 *            物理编号
	 * @param stdId
	 *            业务编号
	 * @param ip
	 *            双网卡IP1，一般为主IP
	 * @param ip2
	 *            双网卡IP2，一般为副IP
	 * @param location
	 *            安装位置
	 * @param heartCycle
	 *            心跳周期
	 * @param linkType
	 *            连接方式"lan":局域网，"wan":广域网
	 * @param maxInputAmount
	 *            最大输入连接数
	 * @param maxOutputAmount
	 *            最大输出连接数
	 * @param ftpPort
	 *            FTP端口
	 * @param ftpUserName
	 *            FTP用户名
	 * @param ftpPassword
	 *            FTP用户密码
	 * @param messagePort
	 *            消息端口
	 * @param hasVod
	 *            是否支持视频点播
	 * @param note
	 *            备注
	 * @param isLocal
	 *            判断是中心存储还是本地存储，true:本地，false:中心
	 * @throws BusinessException
	 */
	public void updateStorageServer(String id, String name,
			String deviceNumber, String stdId, String ip, String ip2,
			String location, long heartCycle, String linkType,
			long maxInputAmount, long maxOutputAmount, long ftpPort,
			String ftpUserName, String ftpPassword, long messagePort,
			boolean hasVod, String note, boolean isLocal, String epDeviceType,
			BigDecimal isVirtualIp) throws BusinessException;

	/**
	 * @Title: createEIC
	 * @Description: 创建智能分析单元
	 * @param name
	 *            智能分析单元名称
	 * @param installLocation
	 *            安装地址
	 * @param parentId
	 *            视频服务器ID
	 * @param parentType
	 *            视频服务器类型
	 * @param description
	 *            描述
	 * @param note
	 *            备注
	 * @param company
	 *            生产厂家
	 * @param channelId
	 *            通道号
	 * @param organId
	 *            机构ID
	 * @return String 返回类型
	 * @throws BusinessException
	 */
	public String createEIC(String name, String naming, String installLocation,
			String parentId, Short parentType, String description, String note,
			String company, Short channelId, String organId)
			throws BusinessException;

	/**
	 * @Title: deleteEIC
	 * @Description: 删除智能分析单元
	 * @param id
	 *            智能分析单元ID
	 * @throws BusinessException
	 *             设定文件
	 * @return void 返回类型
	 */
	public void deleteEIC(String id) throws BusinessException;

	/**
	 * @Title: listEIC
	 * @Description: 查询智能单元列表
	 * @param parentId
	 * @param parentType
	 * @return List<EpIntelligentChannel> 返回类型
	 * @throws BusinessException
	 */
	public List<EpIntelligentChannel> listEICByParentId(String parentId)
			throws BusinessException;

	/**
	 * @Title: updateEIC
	 * @Description: 更新智能分析单元
	 * @param id
	 *            智能分析单元ID
	 * @param name
	 *            智能分析单元名称
	 * @param naming
	 *            智能分析单元naming信息
	 * @param installLocation
	 *            安装地址
	 * @param parentId
	 *            视频服务器ID
	 * @param parentType
	 *            视频服务器类型
	 * @param description
	 *            描述
	 * @param note
	 *            备注
	 * @param company
	 *            生产厂家
	 * @param channelId
	 *            通道号
	 * @param organId
	 *            机构ID
	 * @return void 返回类型
	 * @throws BusinessException
	 */
	public void updateEIC(String id, String name, String naming,
			String installLocation, String parentId, Short parentType,
			String description, String note, String company, Short channelId,
			String organId) throws BusinessException;

	/**
	 * @Title: listEICByOrganId
	 * @Description: 根据机构ID查询智能分析单元列表
	 * @param organId
	 * @return List<EpIntelligentChannel> 返回类型
	 * @throws BusinessException
	 */
	public List<EpIntelligentChannel> listEICByOrganId(String organId)
			throws BusinessException;

	/**
	 * @Title: getEIC
	 * @Description: 根据ID查询智能分析单元
	 * @param id
	 * @return EpIntelligentChannel 返回类型
	 * @throws BusinessException
	 */
	public EpIntelligentChannel getEIC(String id) throws BusinessException;

	/**
	 * 媒体网关注册
	 * 
	 * @param deviceNumber
	 *            设备物理编号，唯一标识
	 * @param lanIp
	 *            局域网IP
	 * @param wanIp
	 *            广域网IP
	 * @param msgPort
	 *            内部mega协议监听端口
	 * @param heartbeatCycle
	 *            心跳周期，整型，单位秒。默认120
	 * @return
	 * @throws BusinessException
	 */
	public MediaGatewayServer mediaGatewayServerRegister(String deviceNumber,
			String lanIp, String wanIp, Integer msgPort, Integer heartbeatCycle)
			throws BusinessException;

	/**
	 * 媒体网关心跳
	 * 
	 * @param deviceNumber
	 *            设备物理编号，唯一标识
	 * @throws BusinessException
	 */
	public void mediaGatewayServerHeartbeat(String deviceNumber)
			throws BusinessException;

	/**
	 * 获取指定ID的媒体网关详细信息
	 * 
	 * @param id
	 *            媒体网关ID
	 * @return
	 */
	public MediaGatewayServer getMediaGatewayServerById(String id);
	/**
	 * @Title: getStorageInfoOfCamera
	 * @Description: 视频服务器的存储服务器查询
	 * @param accessId
	 * @return StorageInfoQueryVO 返回类型
	 * @throws 
	 */
	public StorageInfoQueryVO getStorageInfoOfCamera(String accessId);

	/**
	 * @Title: updateIpCameraVIC
	 * @Description: 修改IP摄像头SD卡消失报告
	 * @param ipCameraId 摄像头ID
	 * @param accessId
	 * @return StorageInfoQueryVO 返回类型
	 * @throws 
	 */
	public void updateIpCameraVIC(String  ipCameraId,String accessId);

	/**
	 * 
	 * createSipServer 创建信令网关
	 * @param name 信令网关名称
	 * @param lanIp 内网服务IP
	 * @param httpPort http服务端口
	 * @param deviceNumber 物理编号
	 * @param registerType 注册类型
	 * @param wanIp 外网服务IP
	 * @param sipPort 信令服务端口
	 * @param megaPort 内部megaeyes协议通信端口
	 * @param eventServerId 事件服务器ID
	 * @param mediaGatewayServerId 媒体网关服务器ID
	 * @return
	 */
	public String createSipServer(String name, String lanIp, Integer httpPort,
			 String deviceNumber, String registerType,
			String wanIp, Integer sipPort, Integer megaPort,
			String eventServerId, String mediaGatewayServerId);

	/**
	 * 
	 * deleteSipServer 删除信令网关
	 * @param id 信令网关ID
	 */
	public void deleteSipServer(String id);

	/**
	 * 
	 * updateSipServer 更新信令网关
	 * @param id 信令网关ID
	 * @param name 信令网关名称
	 * @param lanIp 内网服务IP
	 * @param httpPort http服务端口
	 * @param deviceNumber 物理编号
	 * @param registerType 注册类型
	 * @param wanIp 外网服务IP
	 * @param sipPort 信令服务端口
	 * @param megaPort 内部megaeyes协议通信端口
	 * @param eventServerId 事件服务器ID
	 * @param mediaGatewayServerId 媒体网关服务器ID
	 * @return
	 */
	public void updateSipServer(String id, String name, String lanIp,
			Integer httpPort, String deviceNumber,
			String registerType, String wanIp, Integer sipPort,
			Integer megaPort, String eventServerId, String mediaGatewayServerId);

	/**
	 * 
	 * getSipServerById 根据ID查询信令网关
	 * @param id 信令网关ID
	 * @return SipServer
	 */
	public SipServer getSipServerById(String id);

	/**
	 * 
	 * listSipServer 查询信令网关列表
	 * @return List<SipServer>
	 */
	public List<SipServer> listSipServer();

	/**
	 * 
	 * createMediaGatewayServer 创建媒体网关
	 * @param deviceNumber 物理编号
	 * @param lanIp 局域网IP
	 * @param wanIp 广域网IP 
	 * @param msgPort 内部协议监听端口
	 * @param status 状态
	 * @param installLocation 安装位置 
	 * @param heartbeatCycle 心跳时间
	 * @param name 媒体网关名称
	 * @return String
	 */
	public String createMediaGatewayServer(String deviceNumber, String lanIp,
			String wanIp, Integer msgPort, Short status, String installLocation,
			Integer heartbeatCycle,String name);

	/**
	 * 
	 * deleteMediaGatewayServer 删除媒体网关
	 * @param id 媒体网关ID
	 */
	public void deleteMediaGatewayServer(String id);

	/**
	 * 
	 * updateMediaGatewayServer 更新媒体网关
	 * @param id 媒体网关ID
	 * @param deviceNumber 物理编号
	 * @param lanIp 局域网IP
	 * @param wanIp 广域网IP 
	 * @param msgPort 内部协议监听端口
	 * @param installLocation 安装位置 
	 * @param heartbeatCycle 心跳间隔时间
	 * @param name 媒体网关名称
	 */
	public void updateMediaGatewayServer(String id, String deviceNumber,
			String lanIp, String wanIp, Integer msgPort,
			 String installLocation,Integer heartbeatCycle, String name);

	/**
	 * 
	 * listMediaGatewayServer 查询媒体网关
	 * @return List<MediaGatewayServer>
	 */
	public List<MediaGatewayServer> listMediaGatewayServer();
}
