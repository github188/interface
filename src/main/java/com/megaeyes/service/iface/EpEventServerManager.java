/**   
 * @Title: EpEventServerManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-13 上午5:50:50 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpEventServer;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: EpEventServerManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-13 上午5:50:50
 * 
 */
public interface EpEventServerManager extends BaseManager {
	/**
	 * @Title: createEpEventServer
	 * @Description: 创建事件服务器
	 * @param name
	 *            事件服务器名称
	 * @param naming
	 *            事物服务器naming信息
	 * @param deviceNumber
	 *            设备编号
	 * @param installLocation
	 *            安装地址
	 * @param ip1
	 *            事件服务器IP
	 * @param ip2
	 *            本地IP
	 * @param note
	 *            备注
	 * @param alarmFrequency 
	 * 			     报警频率               
	 * @throws BusinessException
	 *             设定文件
	 * @return 返回事件服务器ID
	 * @throws
	 */
	public String createEpEventServer(String name, String naming,
			String deviceNumber, String installLocation, String ip1,
			String ip2, String note, Long port, Integer heartbeatCycle,
			Short alarmFrequency) throws BusinessException;

	/**
	 * @Title: deleteEpEventServer
	 * @Description: 删除事件服务器
	 * @param id
	 * @throws BusinessException
	 *             设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteEpEventServer(String id) throws BusinessException;

	/**
	 * @Title: listEpEventServer
	 * @Description: 查询所有事件服务器列表
	 * @throws BusinessException
	 *             设定文件
	 * @return 事件服务器列表
	 * @throws
	 */
	public List<EpEventServer> listEpEventServer() throws BusinessException;

	/**
	 * @Title: getByEpEventServerId
	 * @Description: 根据ID查询事件服务器一条记录
	 * @param id
	 * @throws BusinessException
	 *             设定文件
	 * @return 事件服务器一条记录
	 * @throws
	 */
	public EpEventServer getByEpEventServerId(String id)
			throws BusinessException;

	/**
	 * @Title: updateEpEventServer
	 * @Description: 更新事件服务器
	 * @param id
	 *            事件服务器ID
	 * @param name
	 *            事件服务器名称
	 * @param naming
	 *            事物服务器naming信息
	 * @param deviceNumber
	 *            设备编号
	 * @param installLocation
	 *            安装地址
	 * @param ip1
	 *            事件服务器IP
	 * @param ip2
	 *            本地IP
	 * @param note
	 *            备注
	 * @param alarmFrequency 
	 * 			     报警频率    
	 * @throws BusinessException
	 *             设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateEpEventServer(String id, String name, String naming,
			String deviceNumber, String installLocation, String ip1,
			String ip2, String note, Long port, Integer heartbeatCycle,
			Short alarmFrequency) throws BusinessException;

	/**
	 * @Title: eventServerRegister
	 * @Description: TODO(事件服务器注册)
	 * @param deviceNumber
	 *            物理编号，唯一标识
	 * @param ip1
	 *            局域网IP
	 * @param ip2
	 *            广域网IP
	 * @param port
	 *            通信端口
	 * @param @return 设定文件
	 * @return EpEventServer 返回类型
	 * @throws
	 */
	public EpEventServer eventServerRegister(String deviceNumber, String ip1,
			String ip2, Long port);
}
