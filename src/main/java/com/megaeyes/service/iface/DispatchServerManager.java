package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.persistence.ibatis.model.DispatchServerExample;

/**
 * 
 * @Title: DispatchServerManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-23 下午02:51:55 
 * @version V1.0
 */
public interface DispatchServerManager extends BaseManager{
	
	/**
	 * 
	 * @Description: 根据ID查询分发服务器信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @return DispatchServer 
	 * @throws
	 */
	public DispatchServer getDispatchServerById(String id);
	
	/**
	 * 
	 * @Description: 根据设备编号查询分发服务器
	 * @author zhuanqi@megaeyes.com
	 * @param @param deviceNumber
	 * @param @return 
	 * @return DispatchServer 
	 * @throws
	 */
	public DispatchServer getDispatchServerByDeviceNumber(String deviceNumber);
	
	/**
	 * 
	 * @Description: 分发服务器注册
	 * @author zhuanqi@megaeyes.com
	 * @param @param dispatchServer 
	 * @return void 
	 * @throws
	 */
	public void dispatchRegister(DispatchServer dispatchServer);
	
	/**
	 * 
	 * @Description: 根据条件查询分发服务器列表 
	 * @author zhuanqi@megaeyes.com
	 * @param @param example
	 * @param @return 
	 * @return List<DispatchServer> 
	 * @throws
	 */
	public List<DispatchServer> selectByExample(DispatchServerExample example);
	
	

}
