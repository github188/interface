/**   
 * @Title: EpGatherServerMananger.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-13 上午6:05:33 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpControlServer;
import com.megaeyes.persistence.ibatis.model.EpGatherServer;
import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: EpGatherServerMananger
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-13 上午6:05:33
 * 
 */
public interface EpGatherServerMananger extends BaseManager {
	/**
	 * @Title: createEpGatherServer
	 * @Description: 创建采集服务器
	 * @param organId
	 *            机构ID
	 * @param ip
	 *            采集服务器ID
	 * @param name
	 *            采集服务器名称
	 * @param note
	 *            备注
	 * @param heartCycle
	 *            心跳周期
	 * @param eventServerId
	 *            事件服务器ID
	 * @param eventPort
	 *            事件服务器端口
	 * @param clientPort
	 *            客户端端口
	 * @param consoleListenerIp
	 *            WEB服务IP
	 * @param consoleListenerPort
	 *            WEB服务端口
	 * @param consolePassword
	 *            WEB服务密码
	 * @param clientIp
	 *            客户端IP
	 * @param eventIp
	 *            事件服务器IP
	 * @param deviceNumber
	 *            物理编码
	 * @return String 返回类型
	 * @throws BusinessException
	 */
	public String createEpGatherServer(String organId, String ip, String name,
			String note, Long heartCycle, String eventServerId,
			String eventPort, String clientPort, String consoleListenerIp,
			String consoleListenerPort, String consolePassword,
			String clientIp, String eventIp, String deviceNumber)
			throws BusinessException;

	/**
	 * @Title: deleteEpGatherServer
	 * @Description: 删除采集服务器
	 * @param id
	 * @throws BusinessException
	 *             设定文件
	 * @return void 返回类型
	 */
	public void deleteEpGatherServer(String id) throws BusinessException;

	/**
	 * @Title: listEpGatherServer
	 * @Description: 查询采集服务器列表
	 * @return
	 * @throws BusinessException
	 *             设定文件
	 * @return List<EpGatherServer> 返回类型
	 */
	public List<EpGatherServer> listEpGatherServer() throws BusinessException;

	/**
	 * @Title: getEpGatherServer
	 * @Description: 根据ID查询采集服务器
	 * @param id
	 * @throws BusinessException
	 *             设定文件
	 * @return EpGatherServer 返回类型
	 */
	public EpGatherServer getEpGatherServer(String id) throws BusinessException;

	/**
	 * @Title: updateEpGatherServer
	 * @Description: 根据ID更新采集服务器
	 * @param id
	 *            采集服务器ID
	 * @param organId
	 *            机构ID
	 * @param ip
	 *            采集服务器IP
	 * @param name
	 *            采集服务器名称
	 * @param note
	 *            备注
	 * @param heartCycle
	 *            心跳周期
	 * @param eventServerId
	 *            事件服务器ID
	 * @param eventPort
	 *            事件服务器端口
	 * @param clientPort
	 *            客户端端口
	 * @param consoleListenerIp
	 *            WEB服务IP
	 * @param consoleListenerPort
	 *            WEB服务端口
	 * @param consolePassword
	 *            WEB服务密码
	 * @param clientIp
	 *            客户端IP
	 * @param eventIp
	 *            事件服务器IP
	 * @param deviceNumber
	 *            物理编码
	 * @param @throws BusinessException 设定文件
	 * @return void 返回类型
	 */
	public void updateEpGatherServer(String id, String organId, String ip,
			String name, String note, Long heartCycle, String eventServerId,
			String eventPort, String clientPort, String consoleListenerIp,
			String consoleListenerPort, String consolePassword,
			String clientIp, String eventIp, String deviceNumber)
			throws BusinessException;

	/**
	 * 采集服务器注册
	 * 
	 * @param deviceNumber
	 *            设备物理编号
	 * @param addr
	 *            采集服务器的服务地址
	 * @return 注册成功的ID
	 * @throws BusinessException
	 */
	public String epGatherServerRegister(String deviceNumber, String addr)
			throws BusinessException;

	/**
	 * 查询指定采集服务器管理的控制器（PLC）列表
	 * 
	 * @param gatherServerId
	 *            采集服务器ID
	 * @return
	 */
	public List<EpControlServer> listEpControlServerByGatherServerId(
			String gatherServerId);

	/**
	 * 查询指定控制器下面的IO探测器列表
	 * 
	 * @param epControlServerId
	 *            控制器ID
	 * @return
	 */
	public List<EpProber> listEpProberByControlServerId(String epControlServerId);

	/**
	 * 
	 * deleteForceEpGatherServer 强制删除采集服务器
	 * @param id 采集服务器ID
	 */ 
	public void deleteForceEpGatherServer(String id);
}
