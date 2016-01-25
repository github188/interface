package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import test.StringUtil;

import com.megaeyes.persistence.ibatis.iface.IpCameraVisDAOImpl;
import com.megaeyes.persistence.ibatis.impl.AlarmBoxDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AlarmInputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AlarmInputChannelTypeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AlarmOutputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AlarmOutputChannelTypeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.DispatchServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpPresetDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRDeviceVicDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRDoorVicDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRMapDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRProberVicDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRRoleResourceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRSchemeAlarmSourceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRTaskstepMonitorDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpSchemeCommandDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpSchemeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.GeneralCameraVicDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.GeneralCameraVisDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.IntelligentChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.IpCameraVicDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.LocalStorageServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.ManufacturerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.PlatformResourcesDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.RUserVisDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.StorageServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputChannelModelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputServerModelDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AlarmBox;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannelType;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannelTypeExample;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelType;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelTypeExample;
import com.megaeyes.persistence.ibatis.model.EpMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpPreset;
import com.megaeyes.persistence.ibatis.model.EpPresetExample;
import com.megaeyes.persistence.ibatis.model.EpRDeviceVicExample;
import com.megaeyes.persistence.ibatis.model.EpRDoorVicExample;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDeviceExample;
import com.megaeyes.persistence.ibatis.model.EpRProberVicExample;
import com.megaeyes.persistence.ibatis.model.EpRRoleResourceExample;
import com.megaeyes.persistence.ibatis.model.EpRSchemeAlarmSource;
import com.megaeyes.persistence.ibatis.model.EpRSchemeAlarmSourceExample;
import com.megaeyes.persistence.ibatis.model.EpRTaskstepMonitorExample;
import com.megaeyes.persistence.ibatis.model.EpSchemeCommandExample;
import com.megaeyes.persistence.ibatis.model.EpSchemeExample;
import com.megaeyes.persistence.ibatis.model.GeneralCameraVic;
import com.megaeyes.persistence.ibatis.model.GeneralCameraVis;
import com.megaeyes.persistence.ibatis.model.IntelligentChannel;
import com.megaeyes.persistence.ibatis.model.IntelligentChannelExample;
import com.megaeyes.persistence.ibatis.model.IpCameraVic;
import com.megaeyes.persistence.ibatis.model.IpCameraVis;
import com.megaeyes.persistence.ibatis.model.LocalStorageServer;
import com.megaeyes.persistence.ibatis.model.Manufacturer;
import com.megaeyes.persistence.ibatis.model.ManufacturerExample;
import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.PlatformResourcesExample;
import com.megaeyes.persistence.ibatis.model.RUserVisExample;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputChannelExample;
import com.megaeyes.persistence.ibatis.model.VideoInputChannelModel;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.model.VideoInputServerExample;
import com.megaeyes.persistence.ibatis.model.VideoInputServerModel;
import com.megaeyes.persistence.ibatis.model.VideoInputServerModelExample;
import com.megaeyes.persistence.ibatis.queryParameter.VisParameter;
import com.megaeyes.persistence.ibatis.vo.AlarmInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.AlarmOutputChannelVO;
import com.megaeyes.persistence.ibatis.vo.IpVICVO;
import com.megaeyes.persistence.ibatis.vo.Ip_VICVO;
import com.megaeyes.persistence.ibatis.vo.ListVideoInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.UserVisVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputServerVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.VISManager;
import com.megaeyes.service.utils.StdIdGenerator;

public class VISManagerImpl extends BaseManagerImpl implements VISManager {
	@Autowired
	VideoInputServerDAOiBatis videoInputServerDAO;
	@Autowired
	GeneralCameraVisDAOiBatis generalCameraVisDAO;
	@Autowired
	StorageServerDAOiBatis storageServerDAO;
	@Autowired
	LocalStorageServerDAOiBatis localStorageServerDAO;
	@Autowired
	IpCameraVisDAOImpl ipCameraVisDAO;
	@Autowired
	DispatchServerDAOiBatis dispatchServerDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	PlatformResourcesDAOiBatis platformResourcesDAO;
	@Autowired
	VideoInputChannelDAOiBatis VideoInputChannelDAO;
	@Autowired
	EpRDeviceVicDAOiBatis epRDeviceVicDAO;
	@Autowired
	EpPresetDAOiBatis epPresetDAO;
	@Autowired
	EpSchemeCommandDAOiBatis epSchemeCommandDAO;
	@Autowired
	EpRSchemeAlarmSourceDAOiBatis epRSchemeAlarmSourceDAO;
	@Autowired
	EpSchemeDAOiBatis epSchemeDAO;
	@Autowired
	EpRMapDeviceDAOiBatis epRMapDeviceDAO;
	@Autowired
	GeneralCameraVicDAOiBatis generalCameraVicDAO;
	@Autowired
	IpCameraVicDAOiBatis ipCameraVicDAO;
	@Autowired
	AlarmBoxDAOiBatis alarmBoxDAO;
	@Autowired
	AlarmInputChannelDAOiBatis alarmInputChannelDAO;
	@Autowired
	AlarmOutputChannelDAOiBatis alarmOutputChannelDAO;
	@Autowired
	IntelligentChannelDAOiBatis intelligentChannelDAO;
	@Autowired
	RUserVisDAOiBatis rUserVisDAO;
	@Autowired
	VideoInputServerModelDAOiBatis videoInputServerModelDAO;
	@Autowired
	ManufacturerDAOiBatis manufacturerDAO;
	@Autowired
	VideoInputChannelModelDAOiBatis videoInputChannelModelDAO;
	@Autowired
	AlarmInputChannelTypeDAOiBatis alarmInputChannelTypeDAO;
	@Autowired
	AlarmOutputChannelTypeDAOiBatis alarmOutputChannelTypeDAO;
	@Autowired
	EpMonitorDeviceDAOiBatis epMonitorDeviceDAO;
	@Autowired
	EpRTaskstepMonitorDAOiBatis epRTaskstepMonitorDao;
	@Autowired
	EpRRoleResourceDAOiBatis epRRoleResourceDAO;
	@Autowired
	EpRProberVicDAOiBatis epRProberVicDAO;
	@Autowired
	EpRMonitorDeviceDAOiBatis epRMonitorDeviceDAO;
	@Autowired
	EpRDoorVicDAOiBatis epRDoorVicDAO;
	public static final String TARGET_TYPE_PRESET = "22";
	public static final String TARGET_TYPE_DISPLAY = "26";
	public static final String DEVICE_TYPE_VIC = "1";
	public static final String DEVICE_TYPE_AIC = "6";
	public static final String DEVICE_TYPE_AOC = "7";
	public static final String DEVICE_TYPE_VOC = "8";
	public static final String DEVICE_TYPE_VIS = "9";

	public static final String TARGET_TYPE_AOC = "30";

	public String createVIS(String name, String deviceNumber,
			String installLocation, String ip, String linkType,
			Long heartCycle, String rebootTime, Long rebootCycle,
			Long maxConnectAmount, String videoInputServerModelId,
			String organId, Short isSupportScheme, String note, String type,
			String sipCode, String longitude, String latitude, String password) {
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(deviceNumber)) {
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(type)) {
			throw new BusinessException("type", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(videoInputServerModelId)) {
			throw new BusinessException("videoInputServerModelId",
					ErrorCode.ERROR);
		}
		// 判断设备名称是否重复
		VideoInputServerExample exampleName = new VideoInputServerExample();
		VideoInputServerExample.Criteria criteriaName = exampleName
				.createCriteria();
		criteriaName.andNameEqualTo(name);
		// criteriaName.andOOrganIdEqualTo(organId);
		List list = videoInputServerDAO.selectByExample(exampleName);
		if (null != list && list.size() > 0) {
			throw new BusinessException("name", ErrorCode.NAME_EXIST);
		}
		// 判断设备编号是否重复
		VideoInputServerExample example = new VideoInputServerExample();
		VideoInputServerExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceNumberEqualTo(deviceNumber);
		List<VideoInputServer> existViServer = (List<VideoInputServer>) videoInputServerDAO
				.selectByExample(example);
		if (existViServer.size() > 0) {
			throw new BusinessException("deviceNumber",
					ErrorCode.DEVICE_NUMBER_DUPLICATE);
		}

		VideoInputServer vis = new VideoInputServer();
		String id = videoInputServerDAO.getVISSeq();
		vis.setId(id);
		vis.setName(name);
		vis.setDeviceNumber(deviceNumber);
		vis.setCompanyId(organId);
		vis.setInstallLocation(installLocation);
		vis.setIp(ip);
		vis.setLinkType(linkType);
		vis.setHeartCycle(heartCycle);
		vis.setRebootTime(rebootTime);
		vis.setRebootCycle(rebootCycle);
		vis.setMaxConnectAmount(maxConnectAmount);
		vis.setVideoInputServerModelId(videoInputServerModelId);
		vis.setIsSupportScheme(isSupportScheme);
		vis.setNote(note);
		vis.setVisType(type);
		vis.setPassword(password);
		// 默认的一些值
		vis.setOptimisticLock(new BigDecimal(0));
		vis.setStdId(StdIdGenerator.getStdId());
		vis.setVideoIntputAmount(new Long("0"));
		vis.setIsNat(new Short("0"));
		// vis.setIsSupportScheme(new Short("0"));
		vis.setIsSupportVod2(new Short("0"));
		vis.setIsSupportPtzLock(new Short("1"));
		vis.setCreatetime(new BigDecimal(new Date().getTime()));
		vis.setStartOnlineTime(new BigDecimal(new Date().getTime()));
		vis.setIsSupportNat(new Short("0"));

		videoInputServerDAO.insert(vis);
		// 如果创建的是DVS
		if (type.equals("dvs")) {
			// insert GENERAL_CAMERA_VIS
			GeneralCameraVis dvs = new GeneralCameraVis();
			dvs.setVideoInputServerId(id);
			generalCameraVisDAO.insert(dvs);

		} else if (type.equals("ipvis")) {
			// insert IP_CAMERA_VIS
			IpCameraVis ipc = new IpCameraVis();
			ipc.setVideoInputServerId(id);
			ipc.setLocalAlarm1Flag((short) (1));
			ipc.setLocalAlarm2Flag((short) (1));
			ipc.setLocalAlarm3Flag((short) (1));
			ipc.setLocalTimingFlag((short) (1));
			ipc.setLocalTimingInterval(new Long(0));
			ipc.setLocalShootingFlag((short) (1));
			ipc.setSdCacheFlag(new Short("0"));
			ipc.setSdRedSaveFlag(new Short("0"));
			ipc.setIsDeleted(new Short("0"));
			ipc.setRemoteAlarm1Flag(new Short("0"));
			ipc.setRemoteAlarm2Flag(new Short("0"));
			ipc.setRemoteAlarm3Flag(new Short("0"));
			ipc.setRemoteTimingFlag(new Short("0"));
			ipc.setRemoteTimingInterval(new Long(0));
			ipc.setRemoteShootingFlag(new Short("0"));
			ipc.setTotalCapacity(new Long(0));
			ipc.setUsedCapacity(new Long(0));
			ipc.setRemainCapacity(new Long(0));
			ipc.setSdCardExistFlag(new Short("0"));
			ipc.setLowCapacityFlag(new Short("0"));
			ipc.setStoreCycle(new Long(0));
			ipc.setOverwriteFlag(new Short("0"));
			ipc.setBackupFlag(new Short("0"));
			ipc.setCleanFlag(new Short("0"));
			ipc.setBrightness(new Long(50));
			ipc.setContrast(new Long(50));
			ipc.setSaturation(new Long(50));
			ipc.setHue(new Long(50));
			ipc.setFrameNum(new Long(50));
			ipc.setFrameInterval(new Long(10));
			ipc.setTransmissionSpeed(new Long(50));
			ipc.setCaptionLocation(new Short("1"));
			ipc.setTimeLocation(new Short("3"));
			ipCameraVisDAO.insert(ipc);
		}

		// 添加对应的存储服务器
		StorageServer ss = new StorageServer();
		String storageServerId = storageServerDAO.getStorageServerSeq();
		ss.setId(storageServerId);
		ss.setDeviceNumber(deviceNumber + "_T");
		ss.setName(name + "_本地");
		ss.setInstallLocation(installLocation);
		ss.setOptimisticLock(new BigDecimal(0));
		ss.setIp(ip);
		ss.setLinkType(linkType);
		ss.setHeartCycle(new Long(120));
		ss.setFtpUserName("hxht");
		ss.setFtpPassword("hxht");
		ss.setMaxInputAmount(new Long(50));
		ss.setMaxOutputAmount(new Long(100));
		ss.setFtpPort(new Long(21));
		ss.setMessagePort(new Long(0));
		ss.setIsVirtualIp(new BigDecimal(0));
		storageServerDAO.insert(ss);

		// 添加对应的本地存储服务器
		LocalStorageServer lss = new LocalStorageServer();
		lss.setStorageServerId(storageServerId);
		lss.setVideoInputServerId(id);
		localStorageServerDAO.insert(lss);

		// 添加platform_resources对应记录

		saveOrUpdatePlatformResources(id, name, null, organId, sipCode,
				longitude, latitude, "vis", null);

		return id;
	}

	public void DeleteVis(String id, boolean forceDelete) {

		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try {
			// 删除下属的摄像头(vic)
			// 删除普通视频服务器摄像头
			List<VideoInputChannel> gvics = VideoInputChannelDAO
					.listGenVicByVisId(id);
			System.out.println("gvics.size():" + gvics.size());
			for (VideoInputChannel gvic : gvics) {
				System.out.println("gvic.getId():" + gvic.getId());
				deleteVic(gvic.getId(), forceDelete);
			}

			// 删除IP视频服务器摄像头
			List<IpVICVO> ipvics = listIpVicByVisId(id);
			for (IpVICVO ipvic : ipvics) {
				deleteIpVic(ipvic.getId(), forceDelete);
			}

			// 删除报警箱下的报警输入输出
			List<AlarmBox> abs = alarmBoxDAO.listAlarmBoxByVisId(id);
			for (AlarmBox ab : abs) {
				// 删除报警输入
				List<AlarmInputChannelVO> aics = alarmInputChannelDAO
						.listAICByAlarmBoxId(ab.getId());
				for (AlarmInputChannel aic : aics) {
					deleteAIC(aic.getId());
				}

				// 删除报警输出
				List<AlarmOutputChannel> aocs = alarmOutputChannelDAO
						.listAOCByAlarmBoxId(ab.getId());
				for (AlarmOutputChannel aoc : aocs) {
					deleteAOC(aoc.getId());
				}

				// 删除报警箱
				alarmBoxDAO.deleteByPrimaryKey(ab.getId());
			}

			// 删除智能分析单元
			IntelligentChannelExample icExample = new IntelligentChannelExample();
			icExample.createCriteria().andParentIdEqualTo(id);
			intelligentChannelDAO.deleteByExample(icExample);

			// 删除相应的本地存储服务器器local_storage_server
			LocalStorageServer lss = localStorageServerDAO
					.findLocalStorageServerByVisId(id);
			if (null != lss) {
				String storageServerId = lss.getStorageServerId();
				localStorageServerDAO.deleteByPrimaryKey(storageServerId);
				// 删除相应的存储服务器storage_server
				storageServerDAO.deleteByPrimaryKey(storageServerId);
			}

			// 删除其他一些关联部分（权限，报警等）
			RUserVisExample example = new RUserVisExample();
			example.createCriteria().andVisidEqualTo(id);
			rUserVisDAO.deleteByExample(example);

			// 删除视频服务器在地图上的关联
			epRMapDeviceDAO.deleteEpRMapDeviceByDeviceId(null, id,
					DEVICE_TYPE_VIS);

			// 删除general_camera_vis
			generalCameraVisDAO.deleteByPrimaryKey(id);
			// 删除ip_camera_vis
			ipCameraVisDAO.deleteByPrimaryKey(id);
			// 删除自身(vis)

			videoInputServerDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new BusinessException("resourcesByUsed",
					ErrorCode.RESOURCE_BE_USED);
		}
		// 删除platform_resource对应资源
		removePlatformResources(id, "vis");
	}

	public List<ListVideoInputChannelVO> listVicByVisId(String visId) {
		List<ListVideoInputChannelVO> vics = VideoInputChannelDAO
				.listVicByVisId(visId);
		return vics;
	}

	/**
	 * 添加或者修改平台资源
	 * 
	 * @param resourceId
	 *            资源ID，可以是：userId, visId, vicId, aicId, aocId, proberId
	 * @param name
	 *            资源名称
	 * @param naming
	 *            有naming的填入naming, 没有naming的填入ID
	 * @param organId
	 *            父机构ID
	 * @param sipCode
	 *            18位国标地址编码
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param type
	 *            资源类型，可以是："user", "vis", "vic", "aic", "aoc", "prober"
	 * @param isShare
	 *            是否共享，默认为共享"1"
	 * @throws SipCodeExistException
	 *             地址编码已经存在异常
	 */
	private void saveOrUpdatePlatformResources(String resourceId, String name,
			String naming, String organId, String sipCode, String longitude,
			String latitude, String type, Short isShare) {

		PlatformResources record = platformResourcesDAO.getByResourceId(
				resourceId, type);
		if (null == record) {
			if (StringUtils.isNotBlank(sipCode)) {
				// 检查sipCode是否重复
				PlatformResources pr = platformResourcesDAO
						.getBySipCode(sipCode);
				if (pr != null) {
					// throw new SipCodeExistException(new String[] { sipCode
					// });
				}
				// 生成对应记录
				record = new PlatformResources();
				record.setId(sequenceDAO.getPlatformResourcesSeq());
				record.setIsShare(isShare == null ? new Short("1") : isShare);
				record.setName(name);
				record.setNaming(naming);
				record.setOrganId(organId);
				record.setResourceId(resourceId);
				record.setSipCode(sipCode);
				record.setStatus(new Short("1"));
				record.setLongitude(longitude);
				record.setLatitude(latitude);
				record.setType(type);
				record.setStandardType("0");
				platformResourcesDAO.insert(record);
			}
		}
		// 修改platform_resource对应记录
		else {
			if (StringUtils.isBlank(sipCode)) {
				// 不修改sipcode
			} else {
				// 检查sipCode是否重复
				if (!sipCode.equals(record.getSipCode())) {
					PlatformResources pr = platformResourcesDAO
							.getBySipCode(sipCode);
					if (pr != null) {
						/*
						 * throw new SipCodeExistException( new String[] {
						 * sipCode });
						 */
					}
				}
			}
			// 修改sipCode,name和naming
			record.setName(name);
			record.setNaming(naming);
			record.setSipCode(sipCode);
			record.setLongitude(longitude);
			record.setLatitude(latitude);
			record.setIsShare(isShare);
			platformResourcesDAO.updateByPrimaryKeySelective(record);
		}
	}

	/**
	 * 删除平台资源
	 * 
	 * @param resourceId
	 *            资源ID，可以是：userId, visId, vicId, aicId, aocId, proberId
	 * @param type
	 *            资源类型，可以是："user", "vis", "vic", "aic", "aoc", "prober"
	 */
	private void removePlatformResources(String resourceId, String type) {
		PlatformResourcesExample prExample = new PlatformResourcesExample();
		prExample.createCriteria().andResourceIdEqualTo(resourceId)
				.andTypeEqualTo(type);
		platformResourcesDAO.deleteByExample(prExample);
	}

	public String deleteVic(String id, boolean forceDelete) {
		VideoInputChannel vic = VideoInputChannelDAO.selectByPrimaryKey(id);
		String name = vic.getName();
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try {
			// 查询是否关联了电力设备（电力任务）
			if (!forceDelete) {
				int count = epRDeviceVicDAO.countVicRelation(id);
				if (count > 0) {
					throw new BusinessException("", ErrorCode.ERROR);
				}
			}
			// 强制删除所有关联
			else {
				EpRDeviceVicExample example = new EpRDeviceVicExample();
				EpRDeviceVicExample.Criteria criteria = example
						.createCriteria();
				criteria.andVicIdEqualTo(id);
				epRDeviceVicDAO.deleteByExample(example);
			}
			// 查询此摄像头的所有预置点列表
			EpPresetExample presetExample = new EpPresetExample();
			EpPresetExample.Criteria presetCriteria = presetExample
					.createCriteria();
			presetCriteria.andVicIdEqualTo(id);
			List<EpPreset> presets = epPresetDAO.selectByExample(presetExample);
			List<String> presetIds = new LinkedList<String>();
			for (EpPreset preset : presets) {
				presetIds.add(preset.getId());
			}
			// 删除预案指令中有此摄像头的预置点的指令
			if (null != presetIds && presetIds.size() > 0) {
				EpSchemeCommandExample commandExample = new EpSchemeCommandExample();
				EpSchemeCommandExample.Criteria commandCriteria = commandExample
						.createCriteria();
				commandCriteria.andTargetIdIn(presetIds);
				commandCriteria.andTargetTypeEqualTo(TARGET_TYPE_PRESET);
				epSchemeCommandDAO.deleteByExample(commandExample);
			}

			// 删除此摄像头的所有预置点
			epPresetDAO.deleteByExample(presetExample);

			// 删除此摄像头做为预案中投墙时的设备的对应指令
			EpSchemeCommandExample displayExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria displayCriteria = displayExample
					.createCriteria();
			displayCriteria.andValueEqualTo(id);
			displayCriteria.andTargetTypeEqualTo(TARGET_TYPE_DISPLAY);
			epSchemeCommandDAO.deleteByExample(displayExample);

			// 查询此摄像头做为报警触发源的预案关联
			EpRSchemeAlarmSourceExample rExample = new EpRSchemeAlarmSourceExample();
			EpRSchemeAlarmSourceExample.Criteria rCriteria = rExample
					.createCriteria();
			rCriteria.andSourceIdEqualTo(id);
			rCriteria.andSourceTypeEqualTo(DEVICE_TYPE_VIC);
			List<EpRSchemeAlarmSource> rSchemeAlarmSources = epRSchemeAlarmSourceDAO
					.selectByExample(rExample);
			// 删除此摄像头做为报警触发源的预案关联
			epRSchemeAlarmSourceDAO.deleteByExample(rExample);
			List<String> schemeIds = new LinkedList<String>();
			// 拿到受到影响的预案ID列表
			for (EpRSchemeAlarmSource rSchemeAlarmSource : rSchemeAlarmSources) {
				schemeIds.add(rSchemeAlarmSource.getEpSchemeId());
			}
			// 删除此摄像头做为报警触发源的预案
			if (schemeIds.size() >= 1) {
				EpSchemeExample schemeExample = new EpSchemeExample();
				EpSchemeExample.Criteria schemeCriteria = schemeExample
						.createCriteria();
				schemeCriteria.andIdIn(schemeIds);
				epSchemeDAO.deleteByExample(schemeExample);
				// 删除与此预案关联的指令
				EpSchemeCommandExample command_example = new EpSchemeCommandExample();
				EpSchemeCommandExample.Criteria command_criteria = command_example
						.createCriteria();
				command_criteria.andEpSchemeIdIn(schemeIds);
				epSchemeCommandDAO.deleteByExample(command_example);
			}

			// 删除设备在地图上的关联信息
			epRMapDeviceDAO.deleteEpRMapDeviceByDeviceId(null, id,
					DEVICE_TYPE_VIC);
			// 删除巡检计划与摄像头的关联
			EpRTaskstepMonitorExample epRTaskstepMonitorExample = new EpRTaskstepMonitorExample();
			EpRTaskstepMonitorExample.Criteria epRTaskstepMonitorExampleCriteria = epRTaskstepMonitorExample
					.createCriteria();
			epRTaskstepMonitorExampleCriteria.andMonitorIdEqualTo(id);
			epRTaskstepMonitorExampleCriteria
					.andMonitorTypeEqualTo(new BigDecimal(1));
			epRTaskstepMonitorDao.deleteByExample(epRTaskstepMonitorExample);
			// 删除角色关联的摄像头
			EpRRoleResourceExample epRRoleResourceExample = new EpRRoleResourceExample();
			EpRRoleResourceExample.Criteria epRRoleResourceExampleCriteria = epRRoleResourceExample
					.createCriteria();
			epRRoleResourceExampleCriteria.andResourceIdEqualTo(id);
			epRRoleResourceDAO.deleteByExample(epRRoleResourceExample);
			// 删除探测器和摄像头关联
			EpRProberVicExample epRProberVicExample = new EpRProberVicExample();
			EpRProberVicExample.Criteria epRProberVicExampleCriteria = epRProberVicExample
					.createCriteria();
			epRProberVicExampleCriteria.andVicIdEqualTo(id);
			epRProberVicDAO.deleteByExample(epRProberVicExample);
			// 删除资产管理和摄像头关联
			EpRMonitorDeviceExample epRMonitorDeviceExample = new EpRMonitorDeviceExample();
			EpRMonitorDeviceExample.Criteria epRMonitorDeviceExampleCriteria = epRMonitorDeviceExample
					.createCriteria();
			epRMonitorDeviceExampleCriteria.andMonitorIdEqualTo(id);
			epRMonitorDeviceDAO.deleteByExample(epRMonitorDeviceExample);
			// 删除门禁网关和摄像头关联
			EpRDoorVicExample epRDoorVicExample = new EpRDoorVicExample();
			EpRDoorVicExample.Criteria epRDoorVicExampleCriteria = epRDoorVicExample
					.createCriteria();
			epRDoorVicExampleCriteria.andVicIdEqualTo(id);
			epRDoorVicDAO.deleteByExample(epRDoorVicExample);
			// 删除general_camera_vic
			generalCameraVicDAO.deleteByPrimaryKey(id);
			// 删除video_input_channel
			VideoInputChannelDAO.deleteByPrimaryKey(id);
			// 添加门和摄像头关联未做
			epMonitorDeviceDAO.deleteByPrimaryKey(id);
			// 删除platform_resource对应资源
			removePlatformResources(id, "vic");
		} catch (Exception e) {
			throw new BusinessException("resourceBeUsed",
					ErrorCode.RESOURCE_BE_USED);
		}
		return name;
	}

	public List<IpVICVO> listIpVicByVisId(String visId) {
		List<IpVICVO> vics = VideoInputChannelDAO.listIpVicByVisId(visId);
		return vics;
	}

	public String deleteIpVic(String id, boolean forceDelete) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		VideoInputChannel vic = VideoInputChannelDAO.selectByPrimaryKey(id);
		String name = vic.getName();
		try {
			// 查询是否关联了电力设备（电力任务）
			if (!forceDelete) {
				int count = epRDeviceVicDAO.countVicRelation(id);
				if (count > 0) {
					throw new BusinessException(" ", ErrorCode.ERROR);
				}
			}
			// 强制删除所有关联
			else {
				EpRDeviceVicExample example = new EpRDeviceVicExample();
				EpRDeviceVicExample.Criteria criteria = example
						.createCriteria();
				criteria.andVicIdEqualTo(id);
				epRDeviceVicDAO.deleteByExample(example);
			}

			// 查询此摄像头的所有预置点列表
			EpPresetExample presetExample = new EpPresetExample();
			EpPresetExample.Criteria presetCriteria = presetExample
					.createCriteria();
			presetCriteria.andVicIdEqualTo(id);
			List<EpPreset> presets = epPresetDAO.selectByExample(presetExample);
			List<String> presetIds = new LinkedList<String>();
			for (EpPreset preset : presets) {
				presetIds.add(preset.getId());
			}
			// 删除预案指令中有此摄像头的预置点的指令
			if (null != presetIds && presetIds.size() > 0) {
				EpSchemeCommandExample commandExample = new EpSchemeCommandExample();
				EpSchemeCommandExample.Criteria commandCriteria = commandExample
						.createCriteria();
				commandCriteria.andTargetIdIn(presetIds);
				commandCriteria.andTargetTypeEqualTo(TARGET_TYPE_PRESET);
				epSchemeCommandDAO.deleteByExample(commandExample);
			}

			// 删除此摄像头的所有预置点
			epPresetDAO.deleteByExample(presetExample);

			// 删除此摄像头做为预案中投墙时的设备的对应指令
			EpSchemeCommandExample displayExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria displayCriteria = displayExample
					.createCriteria();
			displayCriteria.andValueEqualTo(id);
			displayCriteria.andTargetTypeEqualTo(TARGET_TYPE_DISPLAY);
			epSchemeCommandDAO.deleteByExample(displayExample);

			// 查询此摄像头做为报警触发源的预案关联
			EpRSchemeAlarmSourceExample rExample = new EpRSchemeAlarmSourceExample();
			EpRSchemeAlarmSourceExample.Criteria rCriteria = rExample
					.createCriteria();
			rCriteria.andSourceIdEqualTo(id);
			rCriteria.andSourceTypeEqualTo(DEVICE_TYPE_VIC);
			List<EpRSchemeAlarmSource> rSchemeAlarmSources = epRSchemeAlarmSourceDAO
					.selectByExample(rExample);
			// 删除此摄像头做为报警触发源的预案关联
			epRSchemeAlarmSourceDAO.deleteByExample(rExample);
			List<String> schemeIds = new LinkedList<String>();
			// 拿到受到影响的预案ID列表
			for (EpRSchemeAlarmSource rSchemeAlarmSource : rSchemeAlarmSources) {
				schemeIds.add(rSchemeAlarmSource.getEpSchemeId());
			}
			// 删除此摄像头做为报警触发源的预案
			if (schemeIds.size() >= 1) {
				EpSchemeExample schemeExample = new EpSchemeExample();
				EpSchemeExample.Criteria schemeCriteria = schemeExample
						.createCriteria();
				schemeCriteria.andIdIn(schemeIds);
				epSchemeDAO.deleteByExample(schemeExample);

				// 删除与此预案关联的指令
				EpSchemeCommandExample command_example = new EpSchemeCommandExample();
				EpSchemeCommandExample.Criteria command_criteria = command_example
						.createCriteria();
				command_criteria.andEpSchemeIdIn(schemeIds);
				epSchemeCommandDAO.deleteByExample(command_example);
			}

			// 删除摄像头在地图上的关联
			epRMapDeviceDAO.deleteEpRMapDeviceByDeviceId(null, id,
					DEVICE_TYPE_VIC);

			// 删除巡检计划与摄像头的关联
			EpRTaskstepMonitorExample epRTaskstepMonitorExample = new EpRTaskstepMonitorExample();
			EpRTaskstepMonitorExample.Criteria epRTaskstepMonitorExampleCriteria = epRTaskstepMonitorExample
					.createCriteria();
			epRTaskstepMonitorExampleCriteria.andMonitorIdEqualTo(id);
			epRTaskstepMonitorExampleCriteria
					.andMonitorTypeEqualTo(new BigDecimal(1));
			epRTaskstepMonitorDao.deleteByExample(epRTaskstepMonitorExample);
			// 删除角色关联的摄像头
			EpRRoleResourceExample epRRoleResourceExample = new EpRRoleResourceExample();
			EpRRoleResourceExample.Criteria epRRoleResourceExampleCriteria = epRRoleResourceExample
					.createCriteria();
			epRRoleResourceExampleCriteria.andResourceIdEqualTo(id);
			epRRoleResourceDAO.deleteByExample(epRRoleResourceExample);
			// 删除探测器和摄像头关联
			EpRProberVicExample epRProberVicExample = new EpRProberVicExample();
			EpRProberVicExample.Criteria epRProberVicExampleCriteria = epRProberVicExample
					.createCriteria();
			epRProberVicExampleCriteria.andVicIdEqualTo(id);
			epRProberVicDAO.deleteByExample(epRProberVicExample);
			// 删除资产管理和摄像头关联
			EpRMonitorDeviceExample epRMonitorDeviceExample = new EpRMonitorDeviceExample();
			EpRMonitorDeviceExample.Criteria epRMonitorDeviceExampleCriteria = epRMonitorDeviceExample
					.createCriteria();
			epRMonitorDeviceExampleCriteria.andMonitorIdEqualTo(id);
			epRMonitorDeviceDAO.deleteByExample(epRMonitorDeviceExample);
			// 删除门禁网关和摄像头关联
			EpRDoorVicExample epRDoorVicExample = new EpRDoorVicExample();
			EpRDoorVicExample.Criteria epRDoorVicExampleCriteria = epRDoorVicExample
					.createCriteria();
			epRDoorVicExampleCriteria.andVicIdEqualTo(id);
			epRDoorVicDAO.deleteByExample(epRDoorVicExample);

			// 删除ip_camera_vic
			ipCameraVicDAO.deleteByPrimaryKey(id);
			// 删除video_input_channel
			VideoInputChannelDAO.deleteByPrimaryKey(id);

			epMonitorDeviceDAO.deleteByPrimaryKey(id);

			// 删除platform_resource对应资源
			removePlatformResources(id, "vic");
		} catch (Exception e) {
			throw new BusinessException("resourceBeUsed",
					ErrorCode.RESOURCE_BE_USED);
		}
		return name;
	}

	public String deleteAIC(String id) {
		AlarmInputChannel aic = alarmInputChannelDAO.selectByPrimaryKey(id);
		String name = aic.getName();
		try {
			// 删除报警输入在地图上的关联
			epRMapDeviceDAO.deleteEpRMapDeviceByDeviceId(null, id,
					DEVICE_TYPE_AIC);

			// 删除预案中有此设备的记录（报警输入只能作为触发发源）

			// 查询此报警输入做为报警触发源的预案关联
			EpRSchemeAlarmSourceExample rExample = new EpRSchemeAlarmSourceExample();
			EpRSchemeAlarmSourceExample.Criteria rCriteria = rExample
					.createCriteria();
			rCriteria.andSourceIdEqualTo(id);
			rCriteria.andSourceTypeEqualTo(DEVICE_TYPE_VIC);
			List<EpRSchemeAlarmSource> rSchemeAlarmSources = epRSchemeAlarmSourceDAO
					.selectByExample(rExample);

			// 删除以此报警设备为触发源的预案
			EpRSchemeAlarmSourceExample r_example = new EpRSchemeAlarmSourceExample();
			EpRSchemeAlarmSourceExample.Criteria r_criteria = r_example
					.createCriteria();
			r_criteria.andSourceIdEqualTo(id);
			r_criteria.andSourceTypeEqualTo(DEVICE_TYPE_VIC);
			List<EpRSchemeAlarmSource> r_list = epRSchemeAlarmSourceDAO
					.selectByExample(r_example);

			for (EpRSchemeAlarmSource r : r_list) {
				String schemeId = r.getEpSchemeId();
				// 删除与此预案关联的command
				EpSchemeCommandExample command_example = new EpSchemeCommandExample();
				EpSchemeCommandExample.Criteria command_criteria = command_example
						.createCriteria();
				command_criteria.andEpSchemeIdEqualTo(schemeId);
				epSchemeCommandDAO.deleteByExample(command_example);
				// 删除预案本身
				epSchemeDAO.deleteByPrimaryKey(schemeId);
			}
			// 删除关联
			epRSchemeAlarmSourceDAO.deleteByExample(r_example);

			alarmInputChannelDAO.deleteByPrimaryKey(id);

			// 删除platform_resource对应资源
			removePlatformResources(id, "aic");
		} catch (Exception e) {
			throw new BusinessException("resourceBeUsed",
					ErrorCode.RESOURCE_BE_USED);
		}
		return name;
	}

	public String deleteAOC(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		AlarmOutputChannel aoc = alarmOutputChannelDAO.selectByPrimaryKey(id);
		String name = aoc.getName();
		try {
			// 删除报警输出在地图上的关联
			epRMapDeviceDAO.deleteEpRMapDeviceByDeviceId(null, id,
					DEVICE_TYPE_AOC);

			// 删除预案中有此设备的记录
			EpSchemeCommandExample commandExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria commandcriteria = commandExample
					.createCriteria();
			commandcriteria.andTargetIdEqualTo(id);
			commandcriteria.andTargetTypeEqualTo(TARGET_TYPE_AOC);
			epSchemeCommandDAO.deleteByExample(commandExample);

			alarmOutputChannelDAO.deleteByPrimaryKey(id);

			// 删除platform_resource对应资源
			removePlatformResources(id, "aoc");
		} catch (Exception e) {
			throw new BusinessException("resourceBeUsed",
					ErrorCode.RESOURCE_BE_USED);
		}
		return name;
	}

	public List<VideoInputChannel> listVicByOrganId(String organId,
			boolean isQueryReg) {
		Map map = new HashMap();
		map.put("organId", organId);
		map.put("isQueryReg", isQueryReg);
		return VideoInputChannelDAO.listVicByOrganId(map);
	}

	public void updateVIS(String id, String name, String deviceNumber,
			String installLocation, String ip, String linkType,
			Long heartCycle, String rebootTime, Long rebootCycle,
			Long maxConnectAmount, String videoInputServerModelId,
			Short isSupportScheme, String note, String sipCode,
			String longitude, String latitude) {
		System.out.println(id);
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		// 判断设备名称是否重复
		VideoInputServerExample exampleName = new VideoInputServerExample();
		VideoInputServerExample.Criteria criteriaName = exampleName
				.createCriteria();
		criteriaName.andNameEqualTo(name);
		criteriaName.andIdEqualTo(id);
		List<VideoInputServer> list = videoInputServerDAO
				.selectByExample(exampleName);
		if (list.size() > 1) {
			throw new BusinessException("name", ErrorCode.NAME_EXIST);
		}
		// 判断设备编号是否重复
		if (null != deviceNumber && !"".equals(deviceNumber)) {
			VideoInputServerExample example = new VideoInputServerExample();
			VideoInputServerExample.Criteria criteria = example
					.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			criteria.andIdEqualTo(id);
			List<VideoInputServer> existViServer = (List<VideoInputServer>) videoInputServerDAO
					.selectByExample(example);
			if (list.size() > 1) {
				throw new BusinessException("deviceNumber",
						ErrorCode.STD_ID_DUPLICATE);
			}
		}
		VideoInputServer vis = new VideoInputServer();
		vis.setId(id);
		vis.setName(name);
		vis.setDeviceNumber(deviceNumber);
		vis.setInstallLocation(installLocation);
		vis.setIp(ip);
		vis.setLinkType(linkType);
		vis.setHeartCycle(heartCycle);
		vis.setRebootTime(rebootTime);
		vis.setRebootCycle(rebootCycle);
		vis.setMaxConnectAmount(maxConnectAmount);
		if (videoInputServerModelId == null
				|| videoInputServerModelId.length() == 0) {
			List<VideoInputServerModel> visModels = videoInputServerModelDAO
					.selectByExample(new VideoInputServerModelExample());
			if (visModels.size() < 1) {
				throw new BusinessException("", ErrorCode.ERROR);
			} else {
				videoInputServerModelId = visModels.get(0).getId();
			}
		}
		vis.setVideoInputServerModelId(videoInputServerModelId);
		vis.setIsSupportScheme(isSupportScheme);
		vis.setNote(note);

		videoInputServerDAO.updateByPrimaryKeySelective(vis);

		// 更新相应的本地存储服务器器名称
		LocalStorageServer lss = localStorageServerDAO
				.findLocalStorageServerByVisId(id);
		if (null != lss) {
			String storageServerId = lss.getStorageServerId();
			if (null != storageServerId) {
				StorageServer ss = new StorageServer();
				ss.setId(storageServerId);
				if (null != name) {
					ss.setName(name + "_本地");
				}
				if (null != deviceNumber) {
					ss.setDeviceNumber(deviceNumber + "_T");
				}
				storageServerDAO.updateByPrimaryKeySelective(ss);
			}
		}
		VideoInputServer record = videoInputServerDAO.selectByPrimaryKey(id);
		// 同步修改platform_resources
		saveOrUpdatePlatformResources(id, name, record.getNaming(),
				record.getCompanyId(), deviceNumber, longitude, latitude, "vis",
				null);
	}

	public List<UserVisVO> getVISByOrganId(String start, String limit,
			String name, String address, String deviceNumber,
			String lineBackFew, String towerNumber, String switchesIp,
			String serialServerIp, String voltageLevel, String areaBelongs,
			String type, String organId) {
		VisParameter visParameter = new VisParameter();
		try {
			if (!StringUtils.isBlank(start)) {
				visParameter.setStart(Integer.valueOf(start));
			}
			if (!StringUtils.isBlank(limit)) {
				visParameter.setLimit(Integer.valueOf(limit));
			}
		} catch (BusinessException be) {
			throw new BusinessException(" start or limit", ErrorCode.ERROR);
		}
		visParameter.setOrganId(organId);
		visParameter.setName(name);
		visParameter.setAddress(address);
		visParameter.setDeviceNumber(deviceNumber);
		visParameter.setLineBackFew(lineBackFew);
		visParameter.setTowerNumber(towerNumber);
		visParameter.setSwitchesIp(switchesIp);
		visParameter.setSerialServerIp(serialServerIp);
		visParameter.setVoltageLevel(voltageLevel);
		visParameter.setAreaBelongs(areaBelongs);
		visParameter.setType(type);
		return videoInputServerDAO.getVISByOrganId(visParameter);
	}

	public List<UserVisVO> getVISByUserId(String start, String limit,
			String name, String address, String deviceNumber,
			String lineBackFew, String towerNumber, String switchesIp,
			String serialServerIp, String voltageLevel, String areaBelongs,
			String type, String userId) {
		VisParameter visParameter = new VisParameter();
		try {
			if (!StringUtils.isBlank(start)) {
				visParameter.setStart(Integer.valueOf(start));
			}
			if (!StringUtils.isBlank(limit)) {
				visParameter.setLimit(Integer.valueOf(limit));
			}
		} catch (BusinessException be) {
			throw new BusinessException(" start or limit", ErrorCode.ERROR);
		}
		visParameter.setUserId(userId);
		visParameter.setName(name);
		visParameter.setAddress(address);
		visParameter.setDeviceNumber(deviceNumber);
		visParameter.setLineBackFew(lineBackFew);
		visParameter.setTowerNumber(towerNumber);
		visParameter.setSwitchesIp(switchesIp);
		visParameter.setSerialServerIp(serialServerIp);
		visParameter.setVoltageLevel(voltageLevel);
		visParameter.setAreaBelongs(areaBelongs);
		visParameter.setType(type);
		return videoInputServerDAO.getVISByUserId(visParameter);
	}

	public int getVISByOrganIdCount(String name, String address,
			String deviceNumber, String lineBackFew, String towerNumber,
			String switchesIp, String serialServerIp, String voltageLevel,
			String areaBelongs, String type, String organId) {
		VisParameter visParameter = new VisParameter();
		visParameter.setOrganId(organId);
		visParameter.setName(name);
		visParameter.setAddress(address);
		visParameter.setDeviceNumber(deviceNumber);
		visParameter.setLineBackFew(lineBackFew);
		visParameter.setTowerNumber(towerNumber);
		visParameter.setSwitchesIp(switchesIp);
		visParameter.setSerialServerIp(serialServerIp);
		visParameter.setVoltageLevel(voltageLevel);
		visParameter.setAreaBelongs(areaBelongs);
		visParameter.setType(type);
		return videoInputServerDAO.getVISByOrganIdCount(visParameter);
	}

	public int getVISByUserIdCount(String name, String address,
			String deviceNumber, String lineBackFew, String towerNumber,
			String switchesIp, String serialServerIp, String voltageLevel,
			String areaBelongs, String type, String userId) {
		VisParameter visParameter = new VisParameter();
		visParameter.setUserId(userId);
		visParameter.setName(name);
		visParameter.setAddress(address);
		visParameter.setDeviceNumber(deviceNumber);
		visParameter.setLineBackFew(lineBackFew);
		visParameter.setTowerNumber(towerNumber);
		visParameter.setSwitchesIp(switchesIp);
		visParameter.setSerialServerIp(serialServerIp);
		visParameter.setVoltageLevel(voltageLevel);
		visParameter.setAreaBelongs(areaBelongs);
		visParameter.setType(type);
		return videoInputServerDAO.getVISByUserIdCount(visParameter);
	}

	public String createVic(String visId, String name, String installLocation,
			String channelId, String hasPan, String storageType,
			String storageServer, String dispatchServer, String note,
			String isSuspended, String organId, String epDeviceType,
			String communion, String sipCode, String longitude,
			String latitude, String assId) {
		VideoInputChannelExample vicExample = new VideoInputChannelExample();
		VideoInputChannelExample.Criteria criteria = vicExample
				.createCriteria();
		criteria.andChannelIdEqualTo(new Short(channelId));
		criteria.andVideoInputServerIdEqualTo(visId);
		int count = VideoInputChannelDAO.selectByExample(vicExample).size();
		if (count > 0) {
			throw new BusinessException("channelId",
					ErrorCode.CHANNEL_DUPLICATE);
		}
		// name
		VideoInputChannelExample vicExampleNmae = new VideoInputChannelExample();
		VideoInputChannelExample.Criteria criteriaName = vicExampleNmae
				.createCriteria();
		criteriaName.andNameEqualTo(name);
		int countName = VideoInputChannelDAO.selectByExample(vicExampleNmae)
				.size();
		if (countName > 0) {
			// throw new DeviceNameExistException();
		}
		VideoInputChannel vic = new VideoInputChannel();
		String id = VideoInputChannelDAO.getVICSeq();
		vic.setId(id);
		vic.setOptimisticLock(new BigDecimal(0));
		List<VideoInputChannelModel> models = videoInputChannelModelDAO
				.listVicModel(0, 1);
		// 如果没有model，创建一个
		if (null == models || models.size() <= 0) {
			VideoInputChannelModel vicModel = new VideoInputChannelModel();
			String vicModelId = videoInputChannelModelDAO.getVICModelSeq();
			vicModel.setId(vicModelId);
			vicModel.setName("Default");
			vicModel.setNote("Default");
			List<Manufacturer> manufacturers = manufacturerDAO
					.selectByExample(new ManufacturerExample());
			// 如果没有manufacturer，创建一个
			if (null == manufacturers || manufacturers.size() <= 0) {
				Manufacturer manufacturer = new Manufacturer();
				String manufacturerId = manufacturerDAO.getManufacturerSeq();
				manufacturer.setId(manufacturerId);
				manufacturer.setName("Default");
				manufacturer.setNote("Default");
				manufacturer.setOptimisticLock(new BigDecimal(0));
				manufacturerDAO.insert(manufacturer);
				vicModel.setManufacturerId(manufacturerId);
			} else {
				vicModel.setManufacturerId(manufacturers.get(0).getId());
			}
			vicModel.setHasPtz(new Short("1"));
			vicModel.setHasPtzAperture(new Short("1"));
			vicModel.setHasPtzAsw1(new Short("1"));
			vicModel.setHasPtzAsw2(new Short("1"));
			vicModel.setHasPtzAsw3(new Short("1"));
			vicModel.setHasPtzAsw4(new Short("1"));
			vicModel.setHasPtzAuto(new Short("1"));
			vicModel.setHasPtzFoci(new Short("1"));
			vicModel.setHasPtzZoom(new Short("1"));
			vicModel.setHasSense(new Short("1"));
			vicModel.setHasShelter(new Short("1"));
			vicModel.setHasTextLabel(new Short("1"));
			vicModel.setHasTimeLabel(new Short("1"));
			vicModel.setOptimisticLock(new BigDecimal(0));
			videoInputChannelModelDAO.insert(vicModel);
			vic.setVideoInputChannelModelId(vicModelId);
			// System.out.println("------------vicModelId:"+vicModelId);
		} else {
			vic.setVideoInputChannelModelId(models.get(0).getId());
			// System.out.println("------------vicModelId:"+models.get(0).getId());
		}
		// System.out.println("------------visId:"+visId);
		// System.out.println("------------storageServer:"+storageServer);
		// System.out.println("------------dispatchServer:"+dispatchServer);

		vic.setVideoInputServerId(visId);
		vic.setName(name);
		vic.setInstallLocation(installLocation);
		vic.setHasPan(new Short(hasPan));
		vic.setVideoFormat("HIKMP4.2.5");
		vic.setStoreCycle(new Long(7));
		vic.setStorePlanHourFlag("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		vic.setFrameRate(new Long(0));
		vic.setMaxBps(new Long(0));
		vic.setBrightness(new Long(0));
		vic.setHue(new Long(0));
		vic.setContrast(new Long(0));
		vic.setSaturation(new Long(0));
		vic.setNote(note);
		vic.setLocalStoreCycle(7);
		vic.setSchemeType(new Short("0"));
		vic.setLocalSchemeType(new Short("0"));
		vic.setOverWriteFlag(new BigDecimal(0));
		vic.setSchemeType(new Short("0"));
		vic.setDispatchServerId(dispatchServer);
		vic.setRemoteStorageServerId(storageServer);
		vic.setIsSuspended(new Short(isSuspended));
		vic.setStdId(StdIdGenerator.getStdId());
		vic.setIsSupportScheme(new Short("0"));
		vic.setPreRecordTime(new Short("0"));
		vic.setStoreType(new Short(storageType));
		vic.setChannelId(new Short(channelId));
		vic.setStreamType(new Short("0"));
		vic.setIsShare(0);
		if ("0".equals(storageType)) {
			vic.setPullMode(new BigDecimal(0));
		} else {
			vic.setPullMode(new BigDecimal(1));
			vic.setRemoteStorePlanHourFlag("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		}
		// 如果父机构为空，使用视频服务器的机构
		if (StringUtils.isBlank(organId)) {
			VideoInputServer vis = videoInputServerDAO
					.selectByPrimaryKey(visId);
			organId = vis.getCompanyId();
		}
		vic.setOrganId(organId);
		// System.out.println("------------organId:"+organId);
		// 设备资源共享
		vic.setIsShare("1".equals(communion) ? 1 : 0);
		vic.setAlarmStorageServerId(assId);
		VideoInputChannelDAO.insert(vic);

		// insert GENERAL_CAMERA_VIC
		GeneralCameraVic gVic = new GeneralCameraVic();
		gVic.setVideoInputChannelId(id);
		gVic.setAddressNumber("00000000000" + new Random().nextInt(999999999));
		generalCameraVicDAO.insert(gVic);

		EpMonitorDevice epMonitorDevice = new EpMonitorDevice();
		epMonitorDevice.setId(id);
		epMonitorDevice.setName(name);
		epMonitorDevice.setNaming("");
		epMonitorDevice.setOrganId(organId);
		epMonitorDevice.setType(new BigDecimal("1"));
		epMonitorDeviceDAO.insert(epMonitorDevice);
		// 添加platform_resources对应记录
		saveOrUpdatePlatformResources(id, name, null, organId, sipCode,
				longitude, latitude, "vic", "1".equals(communion) ? new Short(
						"1") : new Short("0"));
		return id;
	}

	public void updateVic(String id, String name, String installLocation,
			String hasPan, String channelId, String storageType,
			String storageServer, String dispatchServer, String note,
			String isSuspended, String organId, String visID, String communion,
			String sipCode, String longitude, String latitude, String assId) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		// 查询名称是否存在
		VideoInputChannelExample videoExample = new VideoInputChannelExample();
		VideoInputChannelExample.Criteria criteria = videoExample
				.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andOrganIdEqualTo(organId);
		List<VideoInputChannel> list = VideoInputChannelDAO
				.selectByExample(videoExample);
		if (list.size() > 0) {
			if (!id.equals(list.get(0).getId())) {
				if (name.equals(list.get(0).getName())) {
					throw new BusinessException("", ErrorCode.ERROR);
				}
			}
		}
		// 通道号针对视频服务器而言
		// channelId
		VideoInputChannelExample videoExample1 = new VideoInputChannelExample();
		VideoInputChannelExample.Criteria criteria1 = videoExample1
				.createCriteria();
		if (!StringUtils.isBlank(channelId)) {
			criteria1.andChannelIdEqualTo(new Short(channelId));
		}
		criteria1.andVideoInputServerIdEqualTo(visID);
		List<VideoInputChannel> list1 = VideoInputChannelDAO
				.selectByExample(videoExample1);
		if (list1.size() > 0) {
			if (!id.equals(list1.get(0).getId())) {
				if (channelId.equals(list1.get(0).getChannelId() + "")) {
					throw new BusinessException("", ErrorCode.ERROR);
				}
			}
		}
		VideoInputChannel vic = new VideoInputChannel();
		vic.setId(id);
		vic.setName(name);
		vic.setInstallLocation(installLocation);
		vic.setHasPan(new Short(hasPan));
		vic.setChannelId(new Short(channelId));
		vic.setStoreType(new Short(storageType));
		vic.setRemoteStorageServerId(storageServer);
		vic.setDispatchServerId(dispatchServer);
		vic.setNote(note);
		vic.setOrganId(organId);
		vic.setIsSuspended(new Short(isSuspended));
		vic.setIsShare("1".equals(communion) ? 1 : 0);
		vic.setAlarmStorageServerId(assId);
		VideoInputChannelDAO.updateByPrimaryKeySelective(vic);

		VideoInputChannel record = VideoInputChannelDAO.selectByPrimaryKey(id);
		// 同步修改platform_resources
		saveOrUpdatePlatformResources(id, name, record.getNaming(), organId,
				sipCode, longitude, latitude, "vic",
				"1".equals(communion) ? new Short("1") : new Short("0"));
	}

	public VideoInputChannelVO getVicById(String vicId) {
		VideoInputChannelVO v = new VideoInputChannelVO();
		VideoInputChannel vic = VideoInputChannelDAO.selectByPrimaryKey(vicId);
		v.setId(vic.getId());
		v.setName(vic.getName());
		v.setNaming(vic.getNaming());
		v.setInstallLocation(vic.getInstallLocation());
		v.setHasPan(vic.getHasPan());
		v.setChannelId(vic.getChannelId());
		v.setStoreType(vic.getStoreType());
		v.setRemoteStorageServerId(vic.getRemoteStorageServerId());
		v.setDispatchServerId(vic.getDispatchServerId());
		v.setIsSuspended(vic.getIsSuspended());
		v.setNote(vic.getNote());
		v.setStorePlanHourFlag(vic.getStorePlanHourFlag());
		v.setRemoteStorePlanHourFlag(vic.getRemoteStorePlanHourFlag());
		v.setOrganId(vic.getOrganId());
		v.setEp_codeid("");
		v.setSubdivision_name("");
		v.setIsShare(vic.getIsShare());
		v.setAlarmStorageServerId(vic.getAlarmStorageServerId());
		v.setVideoInputServerId(vic.getVideoInputServerId());
		v.setVideoFormat(vic.getVideoFormat());

		// 获取platform_resources对应资源
		PlatformResources record = platformResourcesDAO.getByResourceId(vicId, "vic");
		if (null != record) {
			v.setSipCode(record.getSipCode());
			v.setLongitude(record.getLongitude());
			v.setLatitude(record.getLatitude());
		}
		return v;
	}

	public String createIpVic(String visId, String name,
			String installLocation, String password, String hasPan,
			String host, String port, String storageType, String storageServer,
			String dispatchServer, String organId, String communion,
			String sipCode, String longitude, String latitude,String alarmStorageServerId,String note) {
		VideoInputChannel vic = new VideoInputChannel();
		String id = VideoInputChannelDAO.getVICSeq();
		vic.setId(id);
		vic.setOptimisticLock(new BigDecimal(0));
		List<VideoInputChannelModel> models = videoInputChannelModelDAO
				.listVicModel(0, 1);
		// 如果没有model，创建一个
		if (null == models || models.size() <= 0) {
			VideoInputChannelModel vicModel = new VideoInputChannelModel();
			String vicModelId = videoInputChannelModelDAO.getVICModelSeq();
			vicModel.setId(vicModelId);
			vicModel.setName("Default");
			vicModel.setNote("Default");
			List<Manufacturer> manufacturers = manufacturerDAO
					.selectByExample(new ManufacturerExample());
			// 如果没有manufacturer，创建一个
			if (null == manufacturers || manufacturers.size() <= 0) {
				Manufacturer manufacturer = new Manufacturer();
				String manufacturerId = manufacturerDAO.getManufacturerSeq();
				manufacturer.setId(manufacturerId);
				manufacturer.setName("Default");
				manufacturer.setNote("Default");
				manufacturer.setOptimisticLock(new BigDecimal(0));
				manufacturerDAO.insert(manufacturer);
				vicModel.setManufacturerId(manufacturerId);
			} else {
				vicModel.setManufacturerId(manufacturers.get(0).getId());
			}
			vicModel.setHasPtz(new Short("1"));
			vicModel.setHasPtzAperture(new Short("1"));
			vicModel.setHasPtzAsw1(new Short("1"));
			vicModel.setHasPtzAsw2(new Short("1"));
			vicModel.setHasPtzAsw3(new Short("1"));
			vicModel.setHasPtzAsw4(new Short("1"));
			vicModel.setHasPtzAuto(new Short("1"));
			vicModel.setHasPtzFoci(new Short("1"));
			vicModel.setHasPtzZoom(new Short("1"));
			vicModel.setHasSense(new Short("1"));
			vicModel.setHasShelter(new Short("1"));
			vicModel.setHasTextLabel(new Short("1"));
			vicModel.setHasTimeLabel(new Short("1"));
			vicModel.setOptimisticLock(new BigDecimal(0));
			videoInputChannelModelDAO.insert(vicModel);
			vic.setVideoInputChannelModelId(vicModelId);
			// System.out.println("------------vicModelId1:"+vicModelId);
		} else {
			// System.out.println("------------vicModelId2:"+models.get(0).getId());
			vic.setVideoInputChannelModelId(models.get(0).getId());
		}

		vic.setVideoInputServerId(visId);
		System.out.println(vic.getVideoInputServerId());
		vic.setName(name);
		vic.setInstallLocation(installLocation);
		vic.setHasPan(new Short(hasPan));
		vic.setVideoFormat("HIKMP4.2.5");
		vic.setStoreCycle(new Long(7));
		vic.setStorePlanHourFlag("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		vic.setFrameRate(new Long(0));
		vic.setMaxBps(new Long(0));
		vic.setBrightness(new Long(0));
		vic.setHue(new Long(0));
		vic.setContrast(new Long(0));
		vic.setSaturation(new Long(0));
		vic.setLocalStoreCycle(7);
		vic.setSchemeType(new Short("0"));
		vic.setLocalSchemeType(new Short("0"));
		vic.setOverWriteFlag(new BigDecimal(0));
		vic.setSchemeType(new Short("0"));
		vic.setDispatchServerId(dispatchServer);
		vic.setRemoteStorageServerId(storageServer);
		vic.setAlarmStorageServerId(alarmStorageServerId);
		vic.setStdId(StdIdGenerator.getStdId());
		vic.setIsSupportScheme(new Short("0"));
		vic.setPreRecordTime(new Short("0"));
		vic.setStoreType(new Short(storageType));
		vic.setStreamType(new Short("0"));
		vic.setPullMode(new BigDecimal(1));
		vic.setRemoteStorePlanHourFlag("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		vic.setIsSuspended(new Short("0"));
		vic.setNote(note);

		// 如果父机构为空，使用视频服务器的机构
		if (StringUtils.isBlank(organId)) {
			VideoInputServer vis = videoInputServerDAO
					.selectByPrimaryKey(visId);
			organId = vis.getCompanyId();
		}
		vic.setOrganId(organId);
		// System.out.println("------------organId:"+organId);
		// 设备资源共享
		vic.setIsShare("1".equals(communion) ? 1 : 0);

		VideoInputChannelDAO.insert(vic);

		// 插入IP_CAMERA_VIC
		IpCameraVic ipvic = new IpCameraVic();
		ipvic.setVideoInputChannelId(id);
		ipvic.setHost(host);
		ipvic.setPort(new Long(port));
		ipvic.setPassword(password);
		ipvic.setSdSupport(new Short("1"));
		ipvic.setDeviceType("EYE-IPC-200S");
		ipCameraVicDAO.insert(ipvic);

		EpMonitorDevice epMonitorDevice = new EpMonitorDevice();
		epMonitorDevice.setId(id);
		epMonitorDevice.setName(name);
		epMonitorDevice.setNaming("");
		epMonitorDevice.setOrganId(organId);
		epMonitorDevice.setType(new BigDecimal("1"));
		epMonitorDeviceDAO.insert(epMonitorDevice);
		// 添加platform_resources对应记录
		saveOrUpdatePlatformResources(id, name, null, organId, sipCode,
				longitude, latitude, "vic", "1".equals(communion) ? new Short(
						"1") : new Short("0"));
		return id;
	}

	public Ip_VICVO getIpVicById(String id) {
		Ip_VICVO v = new Ip_VICVO();
		IpVICVO vo = VideoInputChannelDAO.getIpVicById(id);
		v.setDispatchServerId(vo.getDispatchServerId());
		v.setEp_codeid("");
		v.setHasPan(vo.getHasPan());
		v.setHost(vo.getHost());
		v.setId(id);
		v.setInstallLocation(vo.getInstallLocation());
		v.setIsSuspended(vo.getIsSuspended());
		v.setLocalStoreCycle(vo.getLocalStoreCycle());
		v.setName(vo.getName());
		v.setNaming(vo.getNaming());
		v.setNote(vo.getNote());
		v.setOrganId(vo.getOrganId());
		v.setPassword(vo.getPassword());
		v.setPort(vo.getPort());
		v.setRemoteStorageServerId(vo.getRemoteStorageServerId());
		v.setRemoteStorePlanHourFlag(vo.getRemoteStorePlanHourFlag());
		v.setStoreCycle(vo.getStoreCycle());
		v.setStorePlanHourFlag(vo.getStorePlanHourFlag());
		v.setStoreType(vo.getStoreType());
		v.setSubdivision_name("");
		// 获取platform_resources对应资源
		PlatformResources record = platformResourcesDAO.getByResourceId(id,
				"vic");
		if (null != record) {
			v.setSipCode(record.getSipCode());
			v.setLongitude(record.getLongitude());
			v.setLatitude(record.getLatitude());
			v.setCommunion(record.getIsShare().intValue() == 1);
		}
		return v;
	}

	public List<VideoInputChannel> listRegisteredIpVicByVisId(String visId) {
		return VideoInputChannelDAO.listRegisteredIpVicByVisId(visId);
	}

	public String createAIC(String visId, String name, String typeId,
			String location, String note, String organId, String epDeviceType,
			String sipCode, String longitude, String latitude,
			String channelId, String isShare) {
		String alarmBoxId = null;

		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(visId)) {
			throw new BusinessException("visId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		List<AlarmBox> abs = alarmBoxDAO.listAlarmBoxByVisId(visId);
		// 如果还不存在报警箱，首先创建一个报警箱
		if (abs.size() == 0) {
			alarmBoxId = insertAlarmBox(visId,
					"报警箱" + StdIdGenerator.getDate(), null, "自动创建");
		} else {
			alarmBoxId = abs.get(0).getId();
		}
		AlarmInputChannel aic = new AlarmInputChannel();
		String id = alarmInputChannelDAO.getAICSeq();
		aic.setId(id);
		aic.setAlarmBoxId(alarmBoxId);
		aic.setName(name);
		aic.setOptimisticLock(new BigDecimal(0));
		aic.setInstallLocation(location);
		aic.setAddressNumberOnAlarmBox(StdIdGenerator.getDeviceNumber());
		aic.setAlarmInputChannelTypeId(typeId);
		aic.setIsSupportScheme(new Short("0"));
		aic.setIsShare(Integer.parseInt(isShare));
		aic.setNote(note);
		if (StringUtils.isNotBlank(channelId)) {
			aic.setChannelId(new Short(channelId));
		}
		// 如果父机构为空，使用视频服务器的机构
		if (StringUtils.isBlank(organId)) {
			VideoInputServer vis = videoInputServerDAO
					.selectByPrimaryKey(visId);
			organId = vis.getCompanyId();
		}
		aic.setOrganId(organId);
		alarmInputChannelDAO.insert(aic);
		// 添加platform_resources对应记录
		saveOrUpdatePlatformResources(id, name, null, organId, sipCode,
				longitude, latitude, "aic", new Short(isShare));
		return id;
	}

	public AlarmInputChannelVO getAIC(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		AlarmInputChannelVO vo = new AlarmInputChannelVO();
		AlarmInputChannel aic = alarmInputChannelDAO.selectByPrimaryKey(id);
		vo.setId(aic.getId());
		vo.setIsSupportScheme(aic.getIsSupportScheme());
		vo.setInstallLocation(aic.getInstallLocation());
		vo.setName(aic.getName());
		vo.setAlarmInputChannelTypeId(aic.getAlarmInputChannelTypeId());
		vo.setNote(aic.getNote());
		vo.setOrganId(aic.getOrganId());
		vo.setSubdivision_name("");
		vo.setEp_codeid("");
		vo.setChannelId(aic.getChannelId());

		// 获取platform_resources对应资源
		PlatformResources record = platformResourcesDAO.getByResourceId(id,
				"aic");
		if (null != record) {
			vo.setSipCode(record.getSipCode());
			vo.setLongitude(record.getLongitude());
			vo.setLatitude(record.getLatitude());
		}
		return vo;
	}

	public void updateAIC(String id, String name, String typeId,
			String location, String note, String isSupportScheme,
			String organId, String epDeviceType, String sipCode,
			String longitude, String latitude, String channelId, String isShare) {
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		AlarmInputChannel aic = new AlarmInputChannel();
		aic.setId(id);
		aic.setName(name);
		aic.setAlarmInputChannelTypeId(typeId);
		aic.setInstallLocation(location);
		aic.setNote(note);
		aic.setOrganId(organId);
		aic.setIsShare(Integer.parseInt(isShare));
		if (StringUtils.isNotBlank(channelId)) {
			aic.setChannelId(new Short(channelId));
		}
		alarmInputChannelDAO.updateByPrimaryKeySelective(aic);
		AlarmInputChannel record = alarmInputChannelDAO.selectByPrimaryKey(id);
		saveOrUpdatePlatformResources(id, name, aic.getNaming(), organId,
				sipCode, longitude, latitude, "aic", new Short(isShare));
	}

	public List<AlarmInputChannelVO> listAICByVisId(String visId) {
		List<AlarmBox> abs = alarmBoxDAO.listAlarmBoxByVisId(visId);
		// 如果不存在报警箱
		if (abs.size() == 0) {
			return new ArrayList<AlarmInputChannelVO>();
		}
		String alarmBoxId = abs.get(0).getId();
		return alarmInputChannelDAO.listAICByAlarmBoxId(alarmBoxId);
	}

	public String insertAlarmBox(String visId, String name, String location,
			String note) {
		String id = alarmBoxDAO.getAlarmBoxSeq();
		AlarmBox ab = new AlarmBox();
		ab.setId(id);
		ab.setName(name);
		ab.setInstallLocation(location);
		ab.setNote(note);
		ab.setVideoInputServerId(visId);
		ab.setAddressNumber(StdIdGenerator.getDeviceNumber());
		ab.setOptimisticLock(new BigDecimal(1));
		alarmBoxDAO.insert(ab);
		return id;
	}

	public List<AlarmInputChannelType> listAICType() {
		AlarmInputChannelTypeExample example = new AlarmInputChannelTypeExample();
		AlarmInputChannelTypeExample.Criteria criteria = example
				.createCriteria();
		return alarmInputChannelTypeDAO.selectByExample(example);
	}

	public List<AlarmOutputChannelType> listAOCType() {
		AlarmOutputChannelTypeExample example = new AlarmOutputChannelTypeExample();
		AlarmOutputChannelTypeExample.Criteria criteria = example
				.createCriteria();
		return alarmOutputChannelTypeDAO.selectByExample(example);
	}

	public String createAOC(String visId, String name, String typeId,
			String location, String note, String organId, String epDeviceType,
			String sipCode, String longitude, String latitude, String channelId) {
		String alarmBoxId = null;
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(visId)) {
			throw new BusinessException("visId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		List<AlarmBox> abs = alarmBoxDAO.listAlarmBoxByVisId(visId);
		// 如果还不存在报警箱，首先创建一个报警箱
		if (abs.size() == 0) {
			alarmBoxId = insertAlarmBox(visId,
					"报警箱" + StdIdGenerator.getDate(), null, "自动创建");
		} else {
			alarmBoxId = abs.get(0).getId();
		}
		AlarmOutputChannel aoc = new AlarmOutputChannel();
		String id = alarmOutputChannelDAO.getAOCSeq();
		aoc.setId(id);
		aoc.setAlarmBoxId(alarmBoxId);
		aoc.setName(name);
		aoc.setOptimisticLock(new BigDecimal(0));
		aoc.setInstallLocation(location);
		aoc.setAddressNumberOnAlarmBox(StdIdGenerator.getDeviceNumber());
		aoc.setAlarmOutputChannelTypeId(typeId);
		aoc.setIsSupportScheme(new Short("0"));
		aoc.setIsShare(0);
		aoc.setNote(note);
		if (StringUtils.isNotBlank(channelId)) {
			aoc.setChannelId(new Short(channelId));

		}
		// 如果父机构为空，使用视频服务器的机构
		if (StringUtils.isBlank(organId)) {
			VideoInputServer vis = videoInputServerDAO
					.selectByPrimaryKey(visId);
			organId = vis.getCompanyId();
		}
		aoc.setOrganId(organId);
		alarmOutputChannelDAO.insert(aoc);
		// 添加platform_resources对应记录
		saveOrUpdatePlatformResources(id, name, null, organId, sipCode,
				longitude, latitude, "aoc", null);
		return id;
	}

	public AlarmOutputChannelVO getAOC(String id) {
		AlarmOutputChannelVO vo = new AlarmOutputChannelVO();
		AlarmOutputChannel aoc = alarmOutputChannelDAO.selectByPrimaryKey(id);
		vo.setId(aoc.getId());
		vo.setIsSupportScheme(aoc.getIsSupportScheme());
		vo.setInstallLocation(aoc.getInstallLocation());
		vo.setName(aoc.getName());
		vo.setNaming(aoc.getNaming());
		vo.setAlarmOutputChannelTypeId(aoc.getAlarmOutputChannelTypeId());
		vo.setNote(aoc.getNote());
		vo.setOrganId(aoc.getOrganId());
		vo.setEp_codeid("");
		vo.setSubdivision_name("");
		vo.setChannelId(aoc.getChannelId());

		// 获取platform_resources对应资源
		PlatformResources record = platformResourcesDAO.getByResourceId(id,
				"aoc");
		if (null != record) {
			vo.setSipCode(record.getSipCode());
			vo.setLongitude(record.getLongitude());
			vo.setLatitude(record.getLatitude());
		}
		return vo;
	}

	public void updateAOC(String id, String name, String visId, String typeId,
			String location, String note, String isSupportScheme,
			String organId, String epDeviceType, String sipCode,
			String longitude, String latitude, String channelId) {
		AlarmOutputChannel aoc = new AlarmOutputChannel();
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		aoc.setId(id);
		aoc.setName(name);
		aoc.setAlarmOutputChannelTypeId(typeId);
		aoc.setInstallLocation(location);
		aoc.setNote(note);
		aoc.setOrganId(organId);
		if (StringUtils.isNotBlank(channelId)) {
			aoc.setChannelId(new Short(channelId));
		}
		alarmOutputChannelDAO.updateByPrimaryKeySelective(aoc);
		AlarmOutputChannel record = alarmOutputChannelDAO
				.selectByPrimaryKey(id);
		// 同步修改platform_resources
		saveOrUpdatePlatformResources(id, name, record.getNaming(), organId,
				sipCode, longitude, latitude, "aoc", null);
	}

	public List<AlarmOutputChannel> listAOCByVisId(String visId) {
		List<AlarmBox> abs = alarmBoxDAO.listAlarmBoxByVisId(visId);
		// 如果不存在报警箱
		if (abs.size() == 0) {
			return new ArrayList<AlarmOutputChannel>();
		}
		String alarmBoxId = abs.get(0).getId();
		return alarmOutputChannelDAO.listAOCByAlarmBoxId(alarmBoxId);
	}

	public List<AlarmOutputChannel> listAOCByOrganId(Map queryMap) {
		return alarmOutputChannelDAO.listAOCByOrganId(queryMap);
	}

	public int getVISByOrganIdCount(VisParameter parm) {
		return videoInputServerDAO.getVISByOrganIdCount(parm);
	}

	public List<VideoInputServerVO> listVisByOrganId(String organId) {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organid",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return videoInputServerDAO.listVisByOrganId(organId);
	}

	public List<VideoInputServerModel> listVisModel() {
		VideoInputServerModelExample example = new VideoInputServerModelExample();
		List<VideoInputServerModel> list = videoInputServerModelDAO
				.selectByExample(example);
		System.out.println(list);
		return list;
	}

	public void updateStoreScheme(String vicId, String storePlanHourFlag,
			String remoteStorePlanHourFlag, String isOverwriteFlag) {
		if (StringUtils.isBlank(vicId)) {
			throw new BusinessException("vicId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		VideoInputChannel vic = new VideoInputChannel();
		vic.setId(vicId);
		vic.setStorePlanHourFlag(storePlanHourFlag);
		vic.setRemoteStorePlanHourFlag(remoteStorePlanHourFlag);
		String defaultIsOverwrite = "1";
		try {
			if (isOverwriteFlag != null && isOverwriteFlag.length() != 0
					&& !"null".equals(isOverwriteFlag))
				defaultIsOverwrite = isOverwriteFlag;
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		vic.setOverWriteFlag(new BigDecimal(defaultIsOverwrite));
		VideoInputChannelDAO.updateByPrimaryKeySelective(vic);
	}

	public List<AlarmInputChannel> listAlarmInPutByOrganId(String organId) {

		return alarmInputChannelDAO.listAlarmInPutByOrganId(organId);
	}

	public List<AlarmOutputChannel> listAlarmOutPutByOrganId(String organId) {

		return alarmOutputChannelDAO.listAlarmOutPutByOrganId(organId);
	}

	public Integer countAllVic() {
		VideoInputChannelExample example = new VideoInputChannelExample();
		// VideoInputChannelExample.Criteria criteria = example
		// .createCriteria();
		return VideoInputChannelDAO.countByExample(example);
	}

	public void updateIpVic(String id, String name, String installLocation,
			String password, String hasPan, String host, String port,
			String storageType, String storageServer, String dispatchServer,
			String organId, String communion, String sipCode, String longitude,
			String latitude, String note, String channelId,String alarmStorageServerId) {
		// 更改video_input_channel
		VideoInputChannel vic = new VideoInputChannel();
		vic.setId(id);
		// System.out.println(id);
		vic.setName(name);
		vic.setInstallLocation(installLocation);
		vic.setHasPan(new Short(hasPan));
		// System.out.println(storageType);
		vic.setStoreType(new Short(storageType));
		vic.setRemoteStorageServerId(storageServer);
		vic.setAlarmStorageServerId(alarmStorageServerId);
		vic.setDispatchServerId(dispatchServer);
		vic.setNote(note);
		vic.setIsShare("1".equals(communion) ? 1 : 0);
		if (!StringUtils.isBlank(channelId)) {
			Short cid = Short.valueOf(channelId);
			try {
				vic.setChannelId(cid);
			} catch (Exception e) {
				throw new BusinessException("channelId",
						ErrorCode.PARAMETER_VALUE_INVALIDED);
			}
		}
		// System.out.println(vic.getChannelId());
		vic.setOrganId(organId);
		VideoInputChannelDAO.updateByPrimaryKeySelective(vic);
		// 更改ip_camera_vic
		IpCameraVic ipvic = new IpCameraVic();
		ipvic.setVideoInputChannelId(id);
		ipvic.setHost(host);
		ipvic.setPort(new Long(port));
		ipvic.setPassword(password);
		ipCameraVicDAO.updateByPrimaryKeySelective(ipvic);

		VideoInputChannel record = VideoInputChannelDAO.selectByPrimaryKey(id);
		// 同步修改platform_resources
		saveOrUpdatePlatformResources(id, name, null, organId, sipCode,
				longitude, latitude, "vic", "1".equals(communion) ? new Short(
						"1") : new Short("0"));

	}
	
	/**
	 * 
	 * @Description: 根据设备编号查询视频服务器信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param devcieNumber
	 * @param @return 
	 * @return VideoInputServer 
	 * @throws
	 */
	public VideoInputServer getVisByDeviceNumber(String deviceNumber){
		return videoInputServerDAO.getByDeviceNumber(deviceNumber);
	}
	
	/**
	 * 
	 * @Description: 根据主键查询视频服务器信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param id
	 * @param @return 
	 * @return VideoInputServer 
	 * @throws
	 */
	public VideoInputServer getVisById(String id){
		return videoInputServerDAO.selectByPrimaryKey(id);
	}
	
	/**
	 * 
	 * @Description: 注册普通视频服务器
	 * @author zhuanqi@megaeyes.com
	 * @param @param vis
	 * @param @param registerFlag 
	 * @return void 
	 * @throws
	 */
	public void registerGeneralCameraVis(VideoInputServer vis,boolean registerFlag){
		if(registerFlag){
			vis.setIsRegisterd(new BigDecimal(1));
			vis.setStartOnlineTime(BigDecimal.valueOf(new Date().getTime()));
		}
		videoInputServerDAO.updateByPrimaryKeySelective(vis);
	}
	
	/**
	 * 
	 * @Description: 注册IP视频服务器
	 * @author zhuanqi@megaeyes.com
	 * @param @param vis
	 * @param @param registerFlag 
	 * @return void 
	 * @throws
	 */
	public void registerIpCameraVis(VideoInputServerVO visRegisterVo,boolean registerFlag){
		VideoInputServer visRecord = visRegisterVo.getVisRecord();
		if(registerFlag){
			visRecord.setIsRegisterd(new BigDecimal(1));
			visRecord.setStartOnlineTime(BigDecimal.valueOf(new Date().getTime()));
		}
		videoInputServerDAO.updateByPrimaryKeySelective(visRecord);
		//更新IpCameraVis
		IpCameraVis ipVisRecord = visRegisterVo.getIpVisRecord();
		ipCameraVisDAO.updateByPrimaryKeySelective(ipVisRecord);
	}
	
	/**
	 * 
	 * @Description: 视频服务器注册时更新设备Naming
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @param accessId
	 * @param @param cmsId
	 * @param @param isSupportScheme
	 * @param @param company 
	 * @return void 
	 * @throws
	 */
	public void updateTernimalNaming (String visId,String accessId, String cmsId,short isSupportScheme,String company){
		videoInputServerDAO.updateTernimalNaming(visId, accessId, cmsId, isSupportScheme, company);
	}
	
	/**
	 * 
	 * @Description: IpCamera注册时，更新IpVic信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param ipVic
	 * @param @param visId 
	 * @return void 
	 * @throws
	 */
	public void updateIpCameraVic(IpCameraVic ipVic,String visId){
		ipCameraVicDAO.updateIpCameraVicByVisId(ipVic, visId);
	}
	
	/**
	 * 
	 * @Description: 查询视频服务器下的智能分析单元
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return List<IntelligentChannel> 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<IntelligentChannel> getIntelligentChannelListByVisId(String visId){
		IntelligentChannelExample example = new IntelligentChannelExample();
		example.createCriteria().andParentIdEqualTo(visId).andParentTypeEqualTo(new Short("1"));
		return intelligentChannelDAO.selectByExample(example);
	}
	
	/**
	 * 
	 * @Description: 查询视频服务器下的摄像头列表及配置信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return List<VideoInputChannelVO> 
	 * @throws
	 */
	public List<VideoInputChannelVO> getVicListByVisId(String visId){
		return VideoInputChannelDAO.getVicListByVisId(visId);
	}
	
	/**
	 * 
	 * @Description: 查询IpCameraVis信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return IpCameraVis 
	 * @throws
	 */
	public IpCameraVis getIpCameraVisByVisId(String visId){
		return ipCameraVisDAO.selectByPrimaryKey(visId);
	}
	
	/**
	 * 
	 * @Description: 查询视频服务器下的IP摄像头列表及配置信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param visId
	 * @param @return 
	 * @return List<VideoInputChannelVO> 
	 * @throws
	 */
	public List<VideoInputChannelVO> getIpVicListByVisId(String visId){
		return VideoInputChannelDAO.getVicListByVisId(visId);
	}
	
	/**
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author zhuanqi@megaeyes.com
	 * @param @param fName
	 * @param @param type
	 * @param @param encode
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public String getVideoInputServerModelId(String fName,String fType,String encode){
		String modelId = "";
        if (StringUtil.isBlank(fName)) {
        	if(StringUtil.isBlank(encode)){
        		return null;
        	}else{
        		// 若DeviceModel为空，以Protocol作为fName
        		fName = encode;
        	}
        }
        VideoInputServerModelExample example = new VideoInputServerModelExample();
        example.createCriteria().andNameEqualTo(fName);
		List<VideoInputServerModel> visModels = videoInputServerModelDAO.selectByExample(example);
		if (visModels.size() < 1) {
			// 新增IpCameraVIS 型号
			VideoInputServerModel record = new VideoInputServerModel();
			record.setId(sequenceDAO.getVideoInputServerModelSeq());
			record.setName(fName);
			record.setOptimisticLock(BigDecimal.valueOf(0));
			record.setfType(fType);
			record.setEncode(encode);
			record.setManufacturerId("0000000000900000000000001400000");
			record.setRtpPayload("111");
			record.setNote("register create on" + new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date()));
            videoInputServerModelDAO.insert(record);
            return record.getId();
		} else {
			modelId = visModels.get(0).getId();
			return modelId;
		}
		
	}
}
