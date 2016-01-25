package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpSchemeCommandDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoDisplayDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoOutputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoOutputChannelModelDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpSchemeCommandExample;
import com.megaeyes.persistence.ibatis.model.OrganExample;
import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;
import com.megaeyes.persistence.ibatis.model.VideoDisplayDeviceExample;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModelExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.VOCManager;

/**
 * VOCManagerImpl(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-6-19 上午02:04:03
 */
public class VOCManagerImpl extends BaseManagerImpl implements VOCManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	VideoDisplayDeviceDAOiBatis videoDisplayDeviceDAO;
	@Autowired
	VideoOutputChannelDAOiBatis videoOutputChannelDAO;
	@Autowired
	EpSchemeCommandDAOiBatis epSchemeCommandDAO;
	@Autowired
	VideoOutputChannelModelDAOiBatis videoOutputChannelModelDAO;
	@Autowired
	OrganDAOiBatis organDAO;
	
	public String createVOC(String name, String naming, String installLocation,
			String note, String displayId, String modelId,
			String dispatchServer, String organId, String addressNumber,
			Integer isShare, String stdId) throws BusinessException {
		// VideoOutputChannelExample vocExample = new
		// VideoOutputChannelExample();
		// VideoOutputChannelExample.Criteria criteria = vocExample
		// .createCriteria();
		// criteria.andNameEqualTo(name);
		// int nameCount = videoOutputChannelDAO.countByExample(vocExample);
		// if (nameCount > 0) {
		// throw new BusinessException("name", ErrorCode.NAME_EXIST);
		// }
		if (StringUtils.isNotBlank(displayId)) {
			VideoDisplayDeviceExample vddExample = new VideoDisplayDeviceExample();
			VideoDisplayDeviceExample.Criteria criteria = vddExample
					.createCriteria();
			criteria.andIdEqualTo(displayId);
			int count = videoDisplayDeviceDAO.countByExample(vddExample);
			if (count == 0) {
				throw new BusinessException("displayId",
						ErrorCode.PARAMETER_VALUE_INVALIDED);
			}// 从数据库里边判断有没有displayId，没有就抛异常
		}else{
			throw new BusinessException("displayId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(modelId)) {
			VideoOutputChannelModelExample vocmExample = new VideoOutputChannelModelExample();
			VideoOutputChannelModelExample.Criteria criteria = vocmExample
					.createCriteria();
			criteria.andIdEqualTo(modelId);
			int count = videoOutputChannelModelDAO.countByExample(vocmExample);
			if (count == 0) {
				throw new BusinessException("modelId",
						ErrorCode.PARAMETER_VALUE_INVALIDED);
			}// 从数据库里边判断有没有modelId，没有就抛异常
		}else{
			throw new BusinessException("modelId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		if (StringUtils.isBlank(addressNumber)) {
			throw new BusinessException("addressNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		VideoDisplayDevice vdd = videoDisplayDeviceDAO
				.selectByPrimaryKey(displayId);
		String companyId = vdd.getCompanyId();
		VideoOutputChannel voc = new VideoOutputChannel();
		String id = sequenceDAO.getVideOutputChannelSeq();
		voc.setId(id);
		voc.setName(name);
		voc.setNaming(naming);
		voc.setInstallLocation(installLocation);
		voc.setDispatchServerId(dispatchServer);
		voc.setNote(note);
		voc.setVideoDisplayDeviceId(displayId);
		voc.setVideoOutputChannelModelId(modelId);
		voc.setOrganId(organId == null ? companyId : organId);
		voc.setDevicePhysicalRelationId("");
		voc.setAddressNumber(addressNumber);
		voc.setIsShare(isShare);
		voc.setStdId(stdId);
		voc.setOptimisticLock(new BigDecimal(0));

		videoOutputChannelDAO.insert(voc);
		return id;

	}

	public void deleteVOC(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			//删除输出通道时删除EP_SCHEME_COMMAND表记录
			EpSchemeCommandExample example = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria criteria = example.createCriteria();
			criteria.andTargetIdEqualTo(id);
			criteria.andTargetTypeEqualTo("20");
			epSchemeCommandDAO.deleteByExample(example);
		
			videoOutputChannelDAO.deleteByPrimaryKey(id);
		}catch(Exception e){
			throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
		}
	}

	public List<VideoOutputChannel> listVocByDisplayId(String displayId) {
		if (StringUtils.isBlank(displayId)) {
			throw new BusinessException("displayId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return videoOutputChannelDAO.listVocByDisplayId(displayId);

	}

	public List<VideoOutputChannel> listVocByOrganId(String organId) {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return videoOutputChannelDAO.listVocByOrganId(organId);
	}

	public VideoOutputChannel getVOC(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return videoOutputChannelDAO.selectByPrimaryKey(id);
	}

	public void updateVOC(String id, String name, String naming,
			String installLocation, String note, String displayId,
			String modelId, String dispatchServer, String organId,
			String addressNumber, int isShare, String stdId)
			throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(displayId)) {
			VideoDisplayDeviceExample vddExample = new VideoDisplayDeviceExample();
			VideoDisplayDeviceExample.Criteria criteria = vddExample
					.createCriteria();
			criteria.andIdEqualTo(displayId);
			int count = videoDisplayDeviceDAO.countByExample(vddExample);
			if (count == 0) {
				throw new BusinessException("displayId",
						ErrorCode.PARAMETER_VALUE_INVALIDED);
			}// 从数据库里边判断有没有displayId，没有就抛异常
		}else{
			throw new BusinessException("displayId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(modelId)) {
			VideoOutputChannelModelExample vocmExample = new VideoOutputChannelModelExample();
			VideoOutputChannelModelExample.Criteria criteria = vocmExample
					.createCriteria();
			criteria.andIdEqualTo(modelId);
			int count = videoOutputChannelModelDAO.countByExample(vocmExample);
			if (count == 0) {
				throw new BusinessException("modelId",
						ErrorCode.PARAMETER_VALUE_INVALIDED);
			}// 从数据库里边判断有没有modelId，没有就抛异常
		}else{
			throw new BusinessException("modelId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		// DispatchServerExample dsExample = new DispatchServerExample();
		// DispatchServerExample.Criteria criteria1 =
		// dsExample.createCriteria();
		// criteria1.andIdEqualTo(dispatchServer);
		// int count1 = dispatchServerDAO.countByExample(dsExample);
		// if(count1 == 0){
		// throw new BusinessException("dispatchServer",
		// ErrorCode.PARAMETER_VALUE_INVALIDED);
		// }//判断数据库里伴有没有dispatchServer，没有就抛异常
	
		if (StringUtils.isBlank(addressNumber)) {
			throw new BusinessException("addressNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		VideoDisplayDevice vdd = videoDisplayDeviceDAO
				.selectByPrimaryKey(displayId);
		VideoOutputChannel voc = new VideoOutputChannel();
		voc.setId(id);
		voc.setName(name);
		voc.setNaming(naming);
		voc.setInstallLocation(installLocation);
		voc.setDispatchServerId(dispatchServer);
		voc.setNote(note);
		voc.setVideoDisplayDeviceId(displayId);
		voc.setVideoOutputChannelModelId(modelId);
		voc.setOrganId(organId == null ? vdd.getCompanyId() : organId);
		voc.setAddressNumber(addressNumber);
		voc.setIsShare(isShare);
		voc.setStdId(stdId);

		videoOutputChannelDAO.updateByPrimaryKeySelective(voc);

	}

	@Override
	public List<VideoOutputChannelModel> listVOCModel() {
		return videoOutputChannelModelDAO.listVOCModel();
	}
	
	
	public String createVideoDisplayDevice(String name, String naming,
			String installLocation, String note, String deviceNumber,
			String ip, String linkType, Long heartCycle, String rebootTime,
			Long rebootCycle, String organId) throws BusinessException {
		if (StringUtils.isNotBlank(deviceNumber)) {
			VideoDisplayDeviceExample vddExample = new VideoDisplayDeviceExample();
			VideoDisplayDeviceExample.Criteria criteria = vddExample
					.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			int count = videoDisplayDeviceDAO.countByExample(vddExample);
			if (count > 0) {
				throw new BusinessException("deviceNumber",
						ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		// if(StringUtils.isNotBlank(name)){
		// VideoDisplayDeviceExample videoExample1 = new
		// VideoDisplayDeviceExample();
		// VideoDisplayDeviceExample.Criteria criteria1 = videoExample1
		// .createCriteria();
		// criteria1.andNameEqualTo(name);
		// int nameCount = videoDisplayDeviceDAO.countByExample(videoExample1);
		// if (nameCount > 0) {
		// throw new BusinessException("name", ErrorCode.NAME_EXIST);
		// }
		// }
		if (StringUtils.isNotBlank(organId)) {
			OrganExample oExample = new OrganExample();
			OrganExample.Criteria criteria2 = oExample.createCriteria();
			criteria2.andIdEqualTo(organId);
			int organIdCount = organDAO.countByExample(oExample);
			if (organIdCount == 0) {
				throw new BusinessException("organId",
						ErrorCode.ORGAN_NOT_FOUND);
			}
		}
		if (StringUtils.isNotBlank(name)) {
			VideoDisplayDeviceExample vddExample = new VideoDisplayDeviceExample();
			VideoDisplayDeviceExample.Criteria criteria = vddExample.createCriteria();
			criteria.andNameEqualTo(name);
			int count = videoDisplayDeviceDAO.countByExample(vddExample);
			if (count > 0) {
				throw new BusinessException("name",
						ErrorCode.NAME_EXIST);
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}

		VideoDisplayDevice vdd = new VideoDisplayDevice();
		String id = sequenceDAO.getVideoDisPlayDeviceSeq();
		vdd.setId(id);
		vdd.setCompanyId(organId);
		vdd.setDeviceNumber(deviceNumber);
		vdd.setName(name);
		vdd.setNaming(naming);
		vdd.setHeartCycle(heartCycle == null ? heartCycle = (long) 120
				: heartCycle);
		vdd.setInstallLocation(installLocation);
		vdd.setIp(ip);
		vdd.setLinkType(linkType);
		vdd.setNote(note);
		vdd.setRebootCycle(rebootCycle);
		vdd.setRebootTime(rebootTime);
		vdd.setOptimisticLock(BigDecimal.valueOf(0));
		vdd.setVideoIntputAmount(Long.valueOf(32));
		vdd.setVideoOutputAmount(Long.valueOf(32));

		videoDisplayDeviceDAO.insert(vdd);

		return id;
	}

	public void deleteVideoDisplayDevice(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String str_array[] = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			List<VideoOutputChannel> vocs = listVocByDisplayId(str_array[i]);
			try{
				for (VideoOutputChannel voc : vocs) {
					deleteVOC(voc.getId());
				}
			
				videoDisplayDeviceDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
		}

	}

	public List<VideoDisplayDevice> listVideoDisplayDeviceByOrganId(
			String organId) throws BusinessException {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return videoDisplayDeviceDAO.listVideoDisplayDevice(organId);
	}

	public VideoDisplayDevice getVideoDisplayDevice(String id)
			throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return videoDisplayDeviceDAO.selectByPrimaryKey(id);
	}

	public void updateVideoDisplayDevice(String id, String name, String naming,
			String installLocation, String note, String deviceNumber,
			String ip, String linkType, Long heartCycle, String rebootTime,
			Long rebootCycle, String organId) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}

		if (StringUtils.isNotBlank(deviceNumber)) {
			VideoDisplayDeviceExample videoExample1 = new VideoDisplayDeviceExample();
			VideoDisplayDeviceExample.Criteria criteria1 = videoExample1
					.createCriteria();
			criteria1.andDeviceNumberEqualTo(deviceNumber);
			List<VideoDisplayDevice> numberList = videoDisplayDeviceDAO
					.selectByExample(videoExample1);
			if (null != numberList && numberList.size() > 0) {
				if (!id.equals(numberList.get(0).getId())
						&& deviceNumber.equals(numberList.get(0)
								.getDeviceNumber()))
					throw new BusinessException("deviceNumber",
							ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}

		if (StringUtils.isNotBlank(organId)) {
			OrganExample oExample = new OrganExample();
			OrganExample.Criteria criteria2 = oExample.createCriteria();
			criteria2.andIdEqualTo(organId);
			int organIdCount = organDAO.countByExample(oExample);
			if (organIdCount == 0) {
				throw new BusinessException("organId",
						ErrorCode.ORGAN_NOT_FOUND);
			}
		}
		// if(StringUtils.isNotBlank(name)){
		// VideoDisplayDeviceExample videoExample = new
		// VideoDisplayDeviceExample();
		// VideoDisplayDeviceExample.Criteria criteria = videoExample
		// .createCriteria();
		// criteria.andNameEqualTo(name);
		// List<VideoDisplayDevice> nameList = videoDisplayDeviceDAO
		// .selectByExample(videoExample);
		// if (null != nameList && nameList.size() > 0) {
		// if (!id.equals(nameList.get(0).getId())
		// && name.equals(nameList.get(0).getName()))
		// throw new BusinessException("name",ErrorCode.NAME_EXIST);
		// }
		// }
		
		if (StringUtils.isNotBlank(name)) {
			VideoDisplayDeviceExample videoExample1 = new VideoDisplayDeviceExample();
			VideoDisplayDeviceExample.Criteria criteria1 = videoExample1
					.createCriteria();
			criteria1.andNameEqualTo(name);
			List<VideoDisplayDevice> numberList = videoDisplayDeviceDAO
					.selectByExample(videoExample1);
			if (null != numberList && numberList.size() > 0) {
				if (!id.equals(numberList.get(0).getId())){
					if(name.equals(numberList.get(0)
							.getName())){
								throw new BusinessException("name",
										ErrorCode.NAME_EXIST);
						}
					}
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}

		// if (StringUtils.isBlank(name)) {
		// throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		// }

		VideoDisplayDevice vdd = new VideoDisplayDevice();
		vdd.setId(id);
		vdd.setCompanyId(organId);
		vdd.setDeviceNumber(deviceNumber);
		vdd.setName(name);
		vdd.setNaming(naming);
		vdd.setHeartCycle(heartCycle == null ? heartCycle = (long) 120
				: heartCycle);
		vdd.setInstallLocation(installLocation);
		vdd.setIp(ip);
		vdd.setLinkType(linkType);
		vdd.setNote(note);
		vdd.setRebootCycle(rebootCycle);
		vdd.setRebootTime(rebootTime);
		vdd.setOptimisticLock(BigDecimal.valueOf(0));
		vdd.setVideoIntputAmount(Long.valueOf(32));
		vdd.setVideoOutputAmount(Long.valueOf(32));

		videoDisplayDeviceDAO.updateByPrimaryKeySelective(vdd);
	}

	public List<VideoDisplayDevice> listDDS() {
		VideoDisplayDeviceExample example = new VideoDisplayDeviceExample();
		List<VideoDisplayDevice> list = videoDisplayDeviceDAO.selectByExample(example);
		return list;
	}
	
	public List<VideoOutputChannel> listVOCByOrganIdWithChild(String organId){
		return videoOutputChannelDAO.listVOCByOrganIdWithChild(organId);
	}
	
	public void updateByPrimaryKeySelective(VideoOutputChannel voc){
		videoOutputChannelDAO.updateByPrimaryKeySelective(voc);
	}
}
