/**   
 * @Title: VISManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-16 下午3:10:34 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannelType;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelType;
import com.megaeyes.persistence.ibatis.model.IntelligentChannel;
import com.megaeyes.persistence.ibatis.model.IpCameraVic;
import com.megaeyes.persistence.ibatis.model.IpCameraVis;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.model.VideoInputServerModel;
import com.megaeyes.persistence.ibatis.queryParameter.VisParameter;
import com.megaeyes.persistence.ibatis.vo.AlarmInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.AlarmOutputChannelVO;
import com.megaeyes.persistence.ibatis.vo.IpVICVO;
import com.megaeyes.persistence.ibatis.vo.Ip_VICVO;
import com.megaeyes.persistence.ibatis.vo.ListVideoInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.UserVisVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputServerVO;

/**
 * @ClassName: VISManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-16 下午3:10:34
 * 
 */
public interface VISManager extends BaseManager {
	/**
	 * @Title: createVIS
	 * @Description:创建视频服务器
	 * @param name
	 *            名称
	 * @param deviceNumber
	 *            物理编号
	 * @param installLocation
	 *            安装位置
	 * @param ip
	 *            IP
	 * @param linkType
	 *            连接方式：lan或者adsl
	 * @param heartCycle
	 *            心跳周期
	 * @param rebootTime
	 *            重启时间
	 * @param rebootCycle
	 *            重启周期
	 * @param maxConnectAmount
	 *            最大连接数
	 * @param videoInputServerModelId
	 *            视频服务器类型
	 * @param organId
	 *            所属机构ID
	 * @param isSupportScheme
	 *            是否支持预案
	 * @param note
	 *            备注
	 * @param type
	 *            类型: "dvs"或者"ipvis"
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @return String[0]:创建成功的visId,String[1]:成功或失败编码
	 */
	public String createVIS(String name, String deviceNumber,
			String installLocation, String ip, String linkType,
			Long heartCycle, String rebootTime, Long rebootCycle,
			Long maxConnectAmount, String videoInputServerModelId,
			String organId, Short isSupportScheme, String note, String type,
			String sipCode, String longitude, String latitude, String password);

	/**
	 * @Title: DeleteVis
	 * @Description:批量删除显示服务器
	 * @param ids
	 *            以逗号间隔开的多个视频服务器ID
	 */
	public void DeleteVis(String id, boolean forceDelete);

	/**
	 * @Title: deleteVic
	 * @Description:根据ID删除普通视频服务器摄像头
	 * @param id
	 *            摄像头ID
	 * @param forceDelete
	 *            是否强制删除
	 * @return 成功或失败编码
	 */
	public String deleteVic(String id, boolean forceDelete);

	/**
	 * @Title: listIpVicByVisId
	 * @Description: 查询指定IP视频服务器下的摄像头列表
	 * @param visId
	 *            普通视频服务器ID
	 * @return
	 */
	public List<IpVICVO> listIpVicByVisId(String visId);

	/**
	 * @Title: deleteIpVic
	 * @Description:删除指定ID的IP摄像头
	 * 
	 * @param id
	 *            摄像头ID
	 * @param forceDelete
	 *            是否强制删除
	 * @return 成功或失败编码
	 */
	public String deleteIpVic(String id, boolean forceDelete);

	/**
	 * @Title: deleteAIC
	 * @Description:删除报警输入
	 * 
	 * @param id
	 *            报警输入ID
	 * @return 成功或失败编码
	 */
	public String deleteAIC(String id);

	/**
	 * @Title: deleteAOC
	 * @Description: 删除报警输出
	 * @param id
	 *            报警输出ID
	 * @return 成功或失败编码
	 */
	public String deleteAOC(String id);

	/**
	 * @Title: listGenVicByOrganId
	 * @Description: 根据机构ID查询摄像头列表
	 * @param organId
	 * @param isQueryReg
	 *            是否只查询已注册了的,true是 false 否
	 * @return
	 */
	public List<VideoInputChannel> listVicByOrganId(String organId,
			boolean isQueryReg);

	/**
	 * @Title: listVisByOrganId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param organId
	 * @param @return 设定文件
	 * @return List<VideoInputServer> 返回类型
	 * @throws
	 */
	public List<VideoInputServerVO> listVisByOrganId(String organId);

	/**
	 * @Title: updateVIS
	 * @Description: 修改视频服务器，null项不会被修改
	 * @param id
	 *            视频服务器ID（必要）
	 * @param name
	 *            名称
	 * @param deviceNumber
	 *            物理编号
	 * @param installLocation
	 *            安装位置
	 * @param ip
	 *            IP
	 * @param linkType
	 *            连接方式：lan或者adsl
	 * @param heartCycle
	 *            心跳周期
	 * @param rebootTime
	 *            重启时间
	 * @param rebootCycle
	 *            重启周期
	 * @param maxConnectAmount
	 *            最大连接数
	 * @param videoInputServerModelId
	 *            视频服务器类型
	 * @param isSupportScheme
	 *            是否支持预案
	 * @param note
	 *            备注
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @return 成功或失败编码
	 */
	public void updateVIS(String id, String name, String deviceNumber,
			String installLocation, String ip, String linkType,
			Long heartCycle, String rebootTime, Long rebootCycle,
			Long maxConnectAmount, String videoInputServerModelId,
			Short isSupportScheme, String note, String sipCode,
			String longitude, String latitude);

	/**
	 * @Title: getVISByOrganId
	 * @Description: TODO(根据机构查询视频服务器)
	 * @param start
	 *            起始记录数
	 * @param limit
	 *            每页多少条记录
	 * @param name
	 *            名称
	 * @param address
	 *            地址
	 * @param deviceNumber
	 *            设备编码
	 * @param lineBackFew
	 * @param towerNumber
	 * @param switchesIp
	 * @param serialServerIp
	 * @param voltageLevel
	 * @param areaBelongs
	 * @param type
	 *            类型: "dvs"或者"ipvis"
	 * @param organId
	 *            机构ID
	 * @param @return 设定文件
	 * @return List<UserVisVO> 返回类型
	 * @throws
	 */
	public List<UserVisVO> getVISByOrganId(String start, String limit,
			String name, String address, String deviceNumber,
			String lineBackFew, String towerNumber, String switchesIp,
			String serialServerIp, String voltageLevel, String areaBelongs,
			String type, String organId);

	/**
	 * @Title: getVISByOrganIdCount
	 * @Description: TODO(根据机构查询视频服务器总数)
	 * @param name
	 *            名称
	 * @param address
	 *            地址
	 * @param deviceNumber
	 *            设备编码
	 * @param lineBackFew
	 * @param towerNumber
	 * @param switchesIp
	 * @param serialServerIp
	 * @param voltageLevel
	 * @param areaBelongs
	 * @param type
	 *            类型: "dvs"或者"ipvis"
	 * @param organId
	 *            机构ID
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int getVISByOrganIdCount(String name, String address,
			String deviceNumber, String lineBackFew, String towerNumber,
			String switchesIp, String serialServerIp, String voltageLevel,
			String areaBelongs, String type, String organId);

	/**
	 * @Title: getVISByUserId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param start
	 *            起始记录数
	 * @param limit
	 *            每页多少条记录
	 * @param name
	 *            名称
	 * @param address
	 *            地址
	 * @param deviceNumber
	 *            设备编码
	 * @param lineBackFew
	 * @param towerNumber
	 * @param switchesIp
	 * @param serialServerIp
	 * @param voltageLevel
	 * @param areaBelongs
	 * @param type
	 *            类型: "dvs"或者"ipvis"
	 * @param userId
	 *            用户ID
	 * @param @return 设定文件
	 * @return List<UserVisVO> 返回类型
	 * @throws
	 */
	public List<UserVisVO> getVISByUserId(String start, String limit,
			String name, String address, String deviceNumber,
			String lineBackFew, String towerNumber, String switchesIp,
			String serialServerIp, String voltageLevel, String areaBelongs,
			String type, String userId);

	/**
	 * @Title: getVISByUserIdCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param name
	 *            名称
	 * @param address
	 *            地址
	 * @param deviceNumber
	 *            设备编码
	 * @param lineBackFew
	 * @param towerNumber
	 * @param switchesIp
	 * @param serialServerIp
	 * @param voltageLevel
	 * @param areaBelongs
	 * @param type
	 *            类型: "dvs"或者"ipvis"
	 * @param userId
	 *            用户ID
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int getVISByUserIdCount(String name, String address,
			String deviceNumber, String lineBackFew, String towerNumber,
			String switchesIp, String serialServerIp, String voltageLevel,
			String areaBelongs, String type, String userId);

	/**
	 * 
	 * @Title: listGenVicByVisId
	 * @Description: TODO(查询指定普通视频服务器下的摄像头列表)
	 * @param @param visId
	 * @param @return 设定文件
	 * @return List<VideoInputChannel> 返回类型
	 * @throws
	 */
	public List<ListVideoInputChannelVO> listVicByVisId(String visId);

	/**
	 * @Title: createVic
	 * @Description:创建普通视频服务器摄像头GVIC
	 * @param visId
	 *            普通视频服务器ID
	 * @param name
	 *            摄像头名称
	 * @param installLocation
	 *            安装位置
	 * @param channelId
	 *            通道数量
	 * @param hasPan
	 *            是否有云台控制
	 * @param storageType
	 *            存储方式
	 * @param storageServer
	 *            远程存储服务器ID
	 * @param dispatchServer
	 *            分发服务器ID
	 * @param note
	 *            备注
	 * @param isSuspended
	 *            是否停用
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param assId
	 *            报警存储ID
	 * @return String[0]:创建成功的VICID
	 */
	public String createVic(String visId, String name, String installLocation,
			String channelId, String hasPan, String storageType,
			String storageServer, String dispatchServer, String note,
			String isSuspended, String organId, String epDeviceType,
			String communion, String sipCode, String longitude,
			String latitude, String assId);

	/**
	 * @Title: createIpVic
	 * @Description:更改普通视频服务器摄像头
	 * @param id
	 *            摄像头ID
	 * @param name
	 *            摄像头名称
	 * @param installLocation
	 *            安装位置
	 * @param hasPan
	 *            是否有云台控制
	 * @param channelId
	 *            通道数量
	 * @param storageType
	 *            存储方式
	 * @param storageServer
	 *            远程存储服务器ID
	 * @param dispatchServer
	 *            分发服务器ID
	 * @param note
	 *            备注
	 * @param isSuspended
	 *            是否停用
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param assId
	 *            报警存储ID
	 * @return 成功或失败编码
	 */
	public void updateVic(String id, String name, String installLocation,
			String hasPan, String channelId, String storageType,
			String storageServer, String dispatchServer, String note,
			String isSuspended, String organId, String visID, String communion,
			String sipCode, String longitude, String latitude, String assId);

	/**
	 * @Title: getGenVicById
	 * @Description: 查询指定ID的普通摄像头
	 * @param vicId
	 *            摄像头ID
	 * @param @return 设定文件
	 * @return VideoInputChannelVO 返回类型
	 * @throws
	 */
	public VideoInputChannelVO getVicById(String vicId);

	/**
	 * @Title: getGenVicById
	 * @Description: 创建IP视频服务器摄像头
	 * @param visId
	 *            所属VISID
	 * @param name
	 *            名称
	 * @param installLocation
	 *            安装位置
	 * @param password
	 *            密码
	 * @param hasPan
	 *            是否有云台
	 * @param host
	 *            域名
	 * @param port
	 *            端口
	 * @param storageType
	 *            存储方式
	 * @param storageServer
	 *            中心存储服务器ID
	 * @param dispatchServer
	 *            分发服务器ID
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param alarmStorageServerId
	 *            报警存储服务器ID 
	 * @param note
	 *            备注       
	 * @return String[0]创建成功的ID，String[1]成功或失败的编码
	 */
	public String createIpVic(String visId, String name,
			String installLocation, String password, String hasPan,
			String host, String port, String storageType, String storageServer,
			String dispatchServer, String organId, String communion,
			String sipCode, String longitude, String latitude,String alarmStorageServerId,String note);

	/**
	 * @Title: updateIpVic
	 * @Description: 更新IP视频服务器摄像头
	 * @param visId
	 *            所属VISID
	 * @param name
	 *            名称
	 * @param installLocation
	 *            安装位置
	 * @param password
	 *            密码
	 * @param hasPan
	 *            是否有云台
	 * @param host
	 *            域名
	 * @param port
	 *            端口
	 * @param storageType
	 *            存储方式
	 * @param storageServer
	 *            中心存储服务器ID
	 * @param dispatchServer
	 *            分发服务器ID
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param latitude
	 * 			  报警存储服务器ID
	 * @return String[0]创建成功的ID，String[1]成功或失败的编码
	 */
	public void updateIpVic(String id, String name, String installLocation,
			String password, String hasPan, String host, String port,
			String storageType, String storageServer, String dispatchServer,
			String organId, String communion, String sipCode, String longitude,
			String latitude, String note, String channelId,String alarmStorageServerId);

	/**
	 * @Title: getIpVicById
	 * @Description: 查询指定ID的IP摄像头
	 * @param id
	 *            IP摄像头ID
	 * @return IpVICVO
	 */
	public Ip_VICVO getIpVicById(String id);

	/**
	 * @Title: listRegisteredIpVicByVisId
	 * @Description:查询指定IP视频服务器下属已经注册的摄像头列表
	 * @param visId
	 *            视频服务器ID
	 * @return
	 */
	public List<VideoInputChannel> listRegisteredIpVicByVisId(String visId);

	/**
	 * @Title: createAIC
	 * @Description: 创建报警输入
	 * @param visId
	 *            视频服务器ID
	 * @param name
	 *            名称
	 * @param typeId
	 *            报警输入类型ID
	 * @param location
	 *            安装位置
	 * @param note
	 *            备注
	 * @param organId
	 *            所属机构ID
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param channelId
	 *            通道号
	 * @param isShare
	 *            是否共享： 0-不共享，1-共享
	 * @return 创建成功的ID
	 */
	public String createAIC(String visId, String name, String typeId,
			String location, String note, String organId, String epDeviceType,
			String sipCode, String longitude, String latitude,
			String channelId, String isShare);

	/**
	 * @Title: AlarmInputChannelVO
	 * @Description: 查询指定ID的报警输入信息
	 * @param id
	 *            报警输入ID
	 * @return AlarmInputChannel
	 */
	public AlarmInputChannelVO getAIC(String id);

	/**
	 * @Title: updateAIC
	 * @Description: 修改报警输入
	 * @param id
	 *            报警输入ID
	 * @param name
	 *            名称
	 * @param typeId
	 *            报警输入类型ID
	 * @param location
	 *            安装位置
	 * @param note
	 *            备注
	 * @param isSupportScheme
	 *            是否支持预案
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param channelId
	 *            通道号
	 * @param isShare
	 *            是否共享： 0-不共享，1-共享
	 */
	public void updateAIC(String id, String name, String typeId,
			String location, String note, String isSupportScheme,
			String organId, String epDeviceType, String sipCode,
			String longitude, String latitude, String channelId, String isShare);

	/**
	 * @Title: listAICByVisId
	 * @Description: 查询指定视频服务器下属的报警输入列表
	 * @param visId
	 *            视频服务器ID
	 * @return 报警输入列表
	 */
	public List<AlarmInputChannelVO> listAICByVisId(String visId);

	/**
	 * @Title: listAICType
	 * @Description: 查询报警输入类型总列表
	 * @return 报警输入类型总列表
	 */
	public List<AlarmInputChannelType> listAICType();

	/**
	 * @Title: listAOCType
	 * @Description: 查询报警输出类型总列表
	 * 
	 * @return 报警输出类型总列表
	 */
	public List<AlarmOutputChannelType> listAOCType();

	/**
	 * 创建报警输出
	 * 
	 * @param visId
	 *            视频服务器ID
	 * @param name
	 *            名称
	 * @param typeId
	 *            报警输出类型ID
	 * @param location
	 *            安装位置
	 * @param note
	 *            备注
	 * @param organId
	 *            所属机构
	 * @param channelId
	 *            通道号
	 * @return 创建成功的ID
	 */
	public String createAOC(String visId, String name, String typeId,
			String location, String note, String organId, String epDeviceType,
			String sipCode, String longitude, String latitude, String channelId);

	/**
	 * @Title: getAOC
	 * @Description: 查询指定ID的报警输出信息
	 * 
	 * @param id
	 *            报警输出ID
	 * @return AlarmOutputChannel
	 */
	public AlarmOutputChannelVO getAOC(String id);

	/**
	 * @Title: updateAOC
	 * @Description: 修改报警输出
	 * @param id
	 *            报警输出ID
	 * @param name
	 *            名称
	 * @param typeId
	 *            报警输出类型ID
	 * @param location
	 *            安装位置
	 * @param note
	 *            备注
	 * @param isSupportScheme
	 *            是否支持预案
	 * @param channelId
	 *            通道号
	 * @return 成功或失败编码
	 */
	public void updateAOC(String id, String name, String visId, String typeId,
			String location, String note, String isSupportScheme,
			String organId, String epDeviceType, String sipCode,
			String longitude, String latitude, String channelId);

	/**
	 * @Title: listAOCByVisId
	 * @Description: 查询指定视频服务器下属的报警输出列表
	 * @param visId
	 *            视频服务器ID
	 * @return 报警输出列表
	 */
	public List<AlarmOutputChannel> listAOCByVisId(String visId);

	/**
	 * @Title: listAOCByOrganId
	 * @Description: 查询指定机构下属的报警输出列表
	 * @param queryMap
	 * @return 报警输出列表
	 */
	public List<AlarmOutputChannel> listAOCByOrganId(Map queryMap);

	/**
	 * @Title: getVISByOrganIdCount
	 * @Description: TODO(查询符合条件的视频服务器总数量)
	 * @param @param parm
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int getVISByOrganIdCount(VisParameter parm);

	/**
	 * @Title: list
	 * @Description: TODO(查询设备型号)
	 * @param @return 设定文件
	 * @return List<VideoInputServerModel> 返回类型
	 * @throws
	 */
	public List<VideoInputServerModel> listVisModel();

	/**
	 * @Title: updateStoreScheme
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param vicId
	 *            摄像头ID
	 * @param storePlanHourFlag
	 *            本地存储方案flag
	 * @param remoteStorePlanHourFlag
	 *            远程存储方案flag
	 * @param isOverwriteFlag
	 *            是否覆盖flag
	 * @throws
	 */
	public void updateStoreScheme(String vicId, String storePlanHourFlag,
			String remoteStorePlanHourFlag, String isOverwriteFlag);

	/**
	 * @Title: listAlarmInPutByOrganId
	 * @Description: TODO(根据organid查询当前机构以及子机构所有报警输入设备)
	 * @param organId
	 * @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	public List<AlarmInputChannel> listAlarmInPutByOrganId(String organId);

	/**
	 * @Title: listAlarmOutPutByOrganId
	 * @Description: TODO(根据organid查询当前机构以及子机构所有报警输出设备)
	 * @param @param organId
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	public List<AlarmOutputChannel> listAlarmOutPutByOrganId(String organId);

	/**
	 * 
	 * @Title: countAllVic
	 * @Description: 统计平台所有摄像头
	 * @param @return 设定文件
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer countAllVic();
	
	/**
	 * 
	 * @Description: 根据设备编号查询视频服务器信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param devcieNumber
	 * @param @return 
	 * @return VideoInputServer 
	 * @throws
	 */
	public VideoInputServer getVisByDeviceNumber(String devcieNumber);
	
	/**
	 * 
	 * @Description: 根据主键查询视频服务器信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @return 
	 * @return VideoInputServer 
	 * @throws
	 */
	public VideoInputServer getVisById(String id);
	
	/**
	 * 
	 * @Description: 注册普通视频服务器
	 * @author zhuanqi@megaeyes.com
	 * @param @param vis
	 * @param @param registerFlag 
	 * @return void 
	 * @throws
	 */
	public void registerGeneralCameraVis(VideoInputServer vis,boolean registerFlag);
	
	/**
	 * 
	 * @Description: 注册IP视频服务器
	 * @author zhuanqi@megaeyes.com
	 * @param @param vis
	 * @param @param registerFlag 
	 * @return void 
	 * @throws
	 */
	public void registerIpCameraVis(VideoInputServerVO vis,boolean registerFlag);
	
	/**
	 * 
	 * @Description: 视频服务器注册时更新设备Naming
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @param accessId
	 * @param @param cmsId
	 * @param @param isSupportScheme
	 * @param @param company 
	 * @return void 
	 * @throws
	 */
	public void updateTernimalNaming (String visId,String accessId, String cmsId,short isSupportScheme,String company);
	
	/**
	 * 
	 * @Description: 查询视频服务器下的智能分析单元
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return List<IntelligentChannel> 
	 * @throws
	 */
	public List<IntelligentChannel> getIntelligentChannelListByVisId(String visId);
	
	/**
	 * 
	 * @Description: 查询视频服务器下的摄像头列表及配置信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return List<VideoInputChannelVO> 
	 * @throws
	 */
	public List<VideoInputChannelVO> getVicListByVisId(String visId);
	
	/**
	 * 
	 * @Description: IpCamera注册时，更新IpVic信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param ipVic
	 * @param @param visId 
	 * @return void 
	 * @throws
	 */
	public void updateIpCameraVic(IpCameraVic ipVic,String visId);
	
	/**
	 * 
	 * @Description: 查询IpCameraVis信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return IpCameraVis 
	 * @throws
	 */
	public IpCameraVis getIpCameraVisByVisId(String visId);
	
	/**
	 * 
	 * @Description: 查询视频服务器下的IP摄像头列表及配置信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return List<VideoInputChannelVO> 
	 * @throws
	 */
	public List<VideoInputChannelVO> getIpVicListByVisId(String visId);
	
	/**
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author zhuanqi@megaeyes.com
	 * @param @param fName
	 * @param @param type
	 * @param @param encode
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getVideoInputServerModelId(String fName,String fType,String encode);
}
