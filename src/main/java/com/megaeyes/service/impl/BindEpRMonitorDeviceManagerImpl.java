/**   
* @Title: BindEpRMonitorDeviceManagerImpl.java 
* @Package com.megaeyes.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-3 上午2:20:33 
* @version V1.0   
*/ 
package com.megaeyes.service.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpRMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDeviceExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BindEpRMonitorDeviceManager;

/** 
 * @ClassName: BindEpRMonitorDeviceManagerImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-3 上午2:20:33 
 *  
 */
public class BindEpRMonitorDeviceManagerImpl extends BaseManagerImpl implements
		BindEpRMonitorDeviceManager {

	@Autowired
	EpRMonitorDeviceDAOiBatis epRMonitorDeviceDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	
	
	public void bindEpRMonitorDevice(BigDecimal deviceType, BigDecimal monitorType, String deviceId, String monitorId)
			throws BusinessException, JSONException {
		
//		jsonString='{"deviceId":"0000000000200020000000000400000","monitorIds":[{"monitorId":"0000000000000000000000000000001"},
//				{"monitorId":"0000000000000000000000000000002"},{"monitorId":"0000000000000000000000000000003"}]}
		
		if(StringUtils.isBlank(deviceId)){
			throw new BusinessException("deviceId",ErrorCode.PARAMETER_NOT_FOUND);
		}
//		//判断探测器ID是否存在
//		EpRMonitorDeviceExample ermdExample = new EpRMonitorDeviceExample();
//		EpRMonitorDeviceExample.Criteria criteria = ermdExample.createCriteria();
//		criteria.andMonitorIdEqualTo(monitorId);
//		int i = epRMonitorDeviceDAO.countByExample(ermdExample);
//		if(i>0){
//			epRMonitorDeviceDAO.deleteByExample(ermdExample);
//		}
		
		String id = sequenceDAO.getEpRMonitorDeviceSeq();
		EpRMonitorDevice ermd = new EpRMonitorDevice();
		ermd.setId(id);
		ermd.setDeviceId(deviceId);
		ermd.setDeviceType(deviceType);
		ermd.setMonitorId(monitorId);
		ermd.setMonitorType(monitorType);
		epRMonitorDeviceDAO.insert(ermd);
		
	}

	
	public void deleteByDevice(String deviceId) throws BusinessException {
		if(StringUtils.isBlank(deviceId)){
			throw new BusinessException("deviceId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		epRMonitorDeviceDAO.deleteByDeviceId(deviceId);
	}


	@Override
	public void addOrUpdateEIDAndEpRMonitorDevice(BigDecimal deviceType,
			BigDecimal monitorType, String deviceId, String monitorId) {
		if(StringUtils.isBlank(deviceId)){
			throw new BusinessException("deviceId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		//判断探测器ID是否存在
		EpRMonitorDeviceExample ermdExample = new EpRMonitorDeviceExample();
		EpRMonitorDeviceExample.Criteria criteria = ermdExample.createCriteria();
		criteria.andMonitorIdEqualTo(monitorId);
		int i = epRMonitorDeviceDAO.countByExample(ermdExample);
		if(i>0){
			epRMonitorDeviceDAO.deleteByExample(ermdExample);
		}
		
		String id = sequenceDAO.getEpRMonitorDeviceSeq();
		EpRMonitorDevice ermd = new EpRMonitorDevice();
		ermd.setId(id);
		ermd.setDeviceId(deviceId);
		ermd.setDeviceType(deviceType);
		ermd.setMonitorId(monitorId);
		ermd.setMonitorType(monitorType);
		epRMonitorDeviceDAO.insert(ermd);
		
	}

}
