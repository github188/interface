/**   
* @Title: AcGatewayDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(门禁网管) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-2-27 下午4:19:01 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.AcGatewayDAOImpl;
import com.megaeyes.persistence.ibatis.model.AcGateway;

/** 
 * @ClassName: AcGatewayDAOiBatis 
 * @Description: TODO(门禁网管) 
 * @author tangjianyang tangjianyang@megaeyes.com    
 * @date 2012-2-27 下午4:19:01 
 *  
 */
public class AcGatewayDAOiBatis extends AcGatewayDAOImpl {
	/**
	 * 统计满足条件的门禁网关数量
	 * 
	 * @param organId
	 *            所属机构
	 * @param name
	 *            模糊查询，名称
	 * @param deviceNumber
	 *            精确查询，物理编号
	 * @param wanIp
	 *            精确查询，广域网IP
	 * @param lanIp
	 *            精确查询，局域网IP
	 * @param installLocation
	 *            精确查询，安装位置
	 * @return
	 */
	public int countAcGateway(String organId, String name, String deviceNumber,
			String wanIp, String lanIp, String installLocation) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("organId", organId);
		map.put("name", name);
		map.put("deviceNumber", deviceNumber);
		map.put("wanIp", wanIp);
		map.put("lanIp", lanIp);
		map.put("installLocation", installLocation);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"AC_GATEWAY_VIEW.countAcGateway", map);
	}

	/**
	 * 分页查询满足条件的门禁网关
	 * 
	 * @param organId
	 *            所属机构
	 * @param name
	 *            模糊查询，名称
	 * @param deviceNumber
	 *            精确查询，物理编号
	 * @param wanIp
	 *            精确查询，广域网IP
	 * @param lanIp
	 *            精确查询，局域网IP
	 * @param installLocation
	 *            精确查询，安装位置
	 * @param begin
	 *            起始行
	 * @param end
	 *            结束行
	 * @return
	 */
	public List<AcGateway> listAcGateway(String organId, String name,
			String deviceNumber, String wanIp, String lanIp,
			String installLocation, int begin, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("organId", organId);
		map.put("name", name);
		map.put("deviceNumber", deviceNumber);
		map.put("wanIp", wanIp);
		map.put("lanIp", lanIp);
		map.put("installLocation", installLocation);
		map.put("begin", begin);
		map.put("end", end);
		return getSqlMapClientTemplate().queryForList(
				"AC_GATEWAY_VIEW.listAcGateway", map);
	}
}