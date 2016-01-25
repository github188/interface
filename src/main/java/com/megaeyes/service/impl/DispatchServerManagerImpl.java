package com.megaeyes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.iface.DispatchServerDAO;
import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.persistence.ibatis.model.DispatchServerExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.DispatchServerManager;

/**
 * 
 * @Title: DispatchServerManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: 分发服务器管理类
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-23 下午03:08:30 
 * @version V1.0
 */
public class DispatchServerManagerImpl extends BaseManagerImpl implements DispatchServerManager{
	
	@Autowired
	private DispatchServerDAO dispatchServerDAO;
	
	public DispatchServer getDispatchServerById(String id) {
		return dispatchServerDAO.selectByPrimaryKey(id);
	}

	/**
	 * 
	 * @Description: 根据设备编号查找分发服务器
	 * @author zhuanqi@megaeyes.com
	 * @param @param deviceNumber
	 * @return DispatchServer 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DispatchServer getDispatchServerByDeviceNumber(String deviceNumber){
		DispatchServerExample example = new DispatchServerExample();
		example.createCriteria().andDeviceNumberEqualTo(deviceNumber);
		List<DispatchServer> list = dispatchServerDAO.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}
	}
	
	/**
	 * 
	 * @Description: 更新分发服务器注册信息
	 * @author zhuanqi@megaeyes.com
	 * @return void 
	 * @throws
	 */
	public void dispatchRegister(DispatchServer dispatchServer) {
		dispatchServerDAO.updateByPrimaryKeySelective(dispatchServer);
	}

	/**
	 * 
	 * @Description: 根据条件查询分发服务器列表 
	 * @author zhuanqi@megaeyes.com
	 * @param @param example
	 * @param @return 
	 * @return List<DispatchServer> 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DispatchServer> selectByExample(DispatchServerExample example){
		return dispatchServerDAO.selectByExample(example);
	}
	

}
