package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcGateway;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.EpClientGateway;
import com.megaeyes.persistence.ibatis.vo.ClientGatewayHeartbeatVO;

/**
 * EpClientGatewayManager(类说明)
 * 
 * @author tangjianyang tangjianyang@megaeyes.com
 *         <p />
 *         2012-12-27 下午3:42:53
 */
public interface EpClientGatewayManager extends BaseManager {
	/**
	 * createEpClientGateway (创建客户端网管)
	 * 
	 * @param name
	 *            名称
	 * @param deviceNumber
	 *            物理编码
	 * @param ip1
	 * @param ip2
	 * @param naming
	 * @param port
	 *            端口
	 * @param note
	 *            备注
	 * @return
	 */
	public String createEpClientGateway(String name, String deviceNumber,
			String ip1, String ip2, String naming, Long port, String note,
			Integer heartbeatCycle, String address);

	/**
	 * deleteEpClientGateway (删除客户端网管)
	 * 
	 * @param id
	 */
	public void deleteEpClientGateway(String id);

	/**
	 * listEpClientGateway (查询客户端网管列表)
	 * 
	 * @return
	 */
	public List<EpClientGateway> listEpClientGateway();

	/**
	 * 
	 * getEpClientGateway (查询客户端网管详细信息)
	 * 
	 * @param id
	 * @return
	 */
	public EpClientGateway getEpClientGateway(String id);

	/**
	 * updateEpClientGateway (更新)
	 * 
	 * @param id
	 * @param name
	 *            名称
	 * @param deviceNumber
	 *            物理编码
	 * @param ip1
	 * @param ip2
	 * @param naming
	 * @param port
	 *            端口
	 * @param note
	 *            备注
	 */
	public void updateEpClientGateway(String id, String name,
			String deviceNumber, String ip1, String ip2, String naming,
			Long port, String note, Integer heartbeatCycle, String address);

	/**
	 * clientGatewayRegister (注册)
	 * 
	 * @param deviceNumber
	 * @param lanIp
	 * @param wanIp
	 * @param port
	 * @return
	 */
	public List<EpClientGateway> clientGatewayRegister(String deviceNumber,
			String lanIp, String wanIp, Long port);

	/**
	 * 
	 * listAccessServer (接入服务器)
	 * 
	 * @return
	 */
	public List<AccessServer> listAccessServer();

	/**
	 * 
	 * listAcGateway (门禁网关)
	 * 
	 * @return
	 */
	public List<AcGateway> listAcGateway();
	/**
	 * 
	 * clientGatewayHeartbeat (心跳)
	 * @param deviceNumber
	 * @return
	 */
	public ClientGatewayHeartbeatVO clientGatewayHeartbeat(String deviceNumber);
}
