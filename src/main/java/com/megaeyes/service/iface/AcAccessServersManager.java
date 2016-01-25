/**   
 * @Title: AcAccessServerManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-5-14 上午7:56:45 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.model.AcAccessServers;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: AcAccessServerManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午7:56:45
 * 
 */
public interface AcAccessServersManager extends BaseManager {

	/**
	 * @Title: createAcAccessServers
	 * @Description: 创建门禁控制器
	 * @param name
	 *            控制器名称
	 * @param accessPassword
	 *            控制器密码
	 * @param installLocation
	 *            安装位置
	 * @param deviceNumber
	 *            物理编号
	 * @param ip
	 *            ip地址
	 * @param note
	 *            备注
	 * @param messagePort
	 *            消息端口
	 * @param deviceType
	 *            设备厂家
	 * @param organId
	 *            机构ID
	 * @param gatewayId
	 *            门禁网关ID
	 * @return String 返回类型
	 * @throws BusinessException
	 */
	public String createAcAccessServers(String name, String accessPassword,
			String installLocation, String deviceNumber, String ip,
			String note, Integer messagePort, String deviceType,
			String organId, String gatewayId) throws BusinessException;

	/**
	 * @Title: deleteAcAccessServers
	 * @Description: 删除门禁控制器
	 * @param id
	 *            门禁控制器ID
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteAcAccessServers(String id);

	/**
	 * @Title: updateAcAccessServers
	 * @Description: 更新门禁控制器
	 * @param id
	 *            门禁控制器ID
	 * @param name
	 *            控制器名称
	 * @param accessPassword
	 *            控制器密码
	 * @param installLocation
	 *            安装位置
	 * @param deviceNumber
	 *            物理编号
	 * @param ip
	 *            ip地址
	 * @param note
	 *            备注
	 * @param messagePort
	 *            消息端口
	 * @param deviceType
	 *            设备厂家
	 * @param organId
	 *            机构ID
	 * @param gatewayId
	 *            门禁网关ID
	 * @return void 返回类型
	 * @throws
	 */
	public void updateAcAccessServers(String id, String name,
			String accessPassword, String installLocation, String deviceNumber,
			String ip, String note, Integer messagePort, String deviceType,
			String organId, String gatewayId);

	/**
	 * @Title: listAcAccessServersByOrganId
	 * @Description: 根据机构ID查询门禁控制器列表
	 * @param organId
	 *            根据机构ID查询门禁控制器列表
	 * @return List<AcAccessServers> 返回类型
	 * @throws BusinessException
	 */
	public List<AcAccessServers> listAcAccessServersByOrganId(String organId)
			throws BusinessException;

	/**
	 * 
	 * listAcAccessServersByGatewayId 根据机构ID查询门禁控制器列表
	 * 
	 * @param gatewayId
	 *            门禁网关ID
	 * @return List<AcAccessServers>
	 * @throws BusinessException
	 */
	public List<AcAccessServers> listAcAccessServersByGatewayId(String gatewayId)
			throws BusinessException;

	/**
	 * 根据机构ID查询该机构及其子机构下的所有门的列表
	 * 
	 * @param organId
	 *            机构ID
	 * @return 门列表
	 */
	public List<AcAccessControls> listDoorByOrganId(String organId);

}
