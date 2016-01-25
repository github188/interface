/**   
 * @Title: MapManagerImple.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-25 上午9:33:37 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpMapDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRMapDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpMap;
import com.megaeyes.persistence.ibatis.model.EpMapExample;
import com.megaeyes.persistence.ibatis.model.EpRMapDevice;
import com.megaeyes.persistence.ibatis.model.EpRMapDeviceExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.MapManager;

/**
 * @ClassName: MapManagerImple
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-25 上午9:33:37
 * 
 */
public class MapManagerImple extends BaseManagerImpl implements MapManager {
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpMapDAOiBatis epMapDAO;
	@Autowired
	EpRMapDeviceDAOiBatis epRMapDAO;

	public String createEpMap(String organId, String name, String type,
			String note, byte[] image) {
		EpMap map = new EpMap();
		String id = epMapDAO.getEpMapSeq();
		map.setId(id);
		map.setOrganId(organId);
		map.setName(null == name ? id : name);
		map.setEpMapTypeId(type);
		map.setImage(image);
		map.setNote(note);
		epMapDAO.insert(map);
		return id;
	}

	public void deleteEpMap(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			//删除地图时先把关系表里记录删除
			EpRMapDeviceExample example=new EpRMapDeviceExample();
			EpRMapDeviceExample.Criteria criteria = example.createCriteria();
			criteria.andEpMapIdEqualTo(id);
			epRMapDAO.deleteByExample(example);
		
			epMapDAO.deleteByPrimaryKey(id);
		}catch(Exception e){
			throw new BusinessException("resourceBeUsed", ErrorCode.RESOURCE_BE_USED);
		}
	}

	public List listEpMap(String organId) {
		EpMapExample example = new EpMapExample();
		EpMapExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(organId)) {
			criteria.andOrganIdEqualTo(organId);
		}
		List list = epMapDAO.selectByExampleWithoutBLOBs(example);
		return list;
	}

	public EpMap getEpMap(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpMap map = epMapDAO.selectByPrimaryKey(id);
		return map;
	}

	public void updateEpMap(String id, String organId, String name,
			String type, String note, byte[] image) {
		EpMap map = new EpMap();
		map.setId(id);
		map.setId(id);
		map.setOrganId(organId);
		map.setName(null == name ? id : name);
		map.setEpMapTypeId(type);
		map.setImage(image);
		map.setNote(note);
		epMapDAO.updateByPrimaryKeyWithBLOBs(map);
		
	}

	public String createEpEpRMapDevice(String epMapId, String deviceId,
			Short deviceType, String coordinateX, String coordinateY,
			String left, String right, String top, String bottom) {
		if (StringUtils.isBlank(epMapId)) {
			throw new BusinessException("epMapId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(deviceId)) {
			throw new BusinessException("deviceId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getEpRMapDeviceSeq();
		EpRMapDevice epRMapDevice = new EpRMapDevice();
		epRMapDevice.setId(id);
		epRMapDevice.setEpMapId(epMapId);
		epRMapDevice.setDeviceId(deviceId);
		epRMapDevice.setDeviceType(deviceType);
		epRMapDevice.setCoordinateX(coordinateX);
		epRMapDevice.setCoordinateY(coordinateY);
		epRMapDevice.setLeft(left);
		epRMapDevice.setRight(right);
		epRMapDevice.setTop(top);
		epRMapDevice.setBottom(bottom);
		epRMapDAO.insert(epRMapDevice);
		return id;
	}

	public void deleteEpRMapDevice(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			epRMapDAO.deleteByPrimaryKey(id);
		}catch(Exception e){
			throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
		}
	}

	public List<EpRMapDevice> ListEpRMapDeviceByMapId(String epMapId) {
		if (StringUtils.isBlank(epMapId)) {
			throw new BusinessException("epMapId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpRMapDeviceExample example=new EpRMapDeviceExample();
		EpRMapDeviceExample.Criteria criteria = example.createCriteria();
		criteria.andEpMapIdEqualTo(epMapId);
		//EpRMapDevice epRMapDevice=	epRMapDAO.selectByPrimaryKey(id);
		 List<EpRMapDevice> list=epRMapDAO.selectByExample(example);
		return list;
	}

	
	public void updateEpRMapDevice(String id, String epMapId, String deviceId,
			Short deviceType, String coordinateX, String coordinateY,
			String left, String right, String top, String bottom) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpRMapDevice epRMapDevice = new EpRMapDevice();
		epRMapDevice.setId(id);
		epRMapDevice.setEpMapId(epMapId);
		epRMapDevice.setDeviceId(deviceId);
		epRMapDevice.setDeviceType(deviceType);
		epRMapDevice.setCoordinateX(coordinateX);
		epRMapDevice.setCoordinateY(coordinateY);
		epRMapDevice.setLeft(left);
		epRMapDevice.setRight(right);
		epRMapDevice.setTop(top);
		epRMapDevice.setBottom(bottom);
		epRMapDAO.updateByPrimaryKeySelective(epRMapDevice);
	}

}
