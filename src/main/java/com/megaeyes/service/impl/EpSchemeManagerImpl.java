/**   
 * @Title: EpSchemeManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-16 上午2:21:12 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.AcAccessControlsDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AlarmOutputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpPresetDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpProberDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRSchemeAlarmSourceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpSchemeCommandDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpSchemeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpTrackDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.UserDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoOutputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmScheme;
import com.megaeyes.persistence.ibatis.model.EpPreset;
import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.persistence.ibatis.model.EpRSchemeAlarmSource;
import com.megaeyes.persistence.ibatis.model.EpRSchemeAlarmSourceExample;
import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.model.EpSchemeCommand;
import com.megaeyes.persistence.ibatis.model.EpSchemeCommandExample;
import com.megaeyes.persistence.ibatis.model.EpSchemeExample;
import com.megaeyes.persistence.ibatis.model.EpTrack;
import com.megaeyes.persistence.ibatis.model.OrganExample;
import com.megaeyes.persistence.ibatis.model.TUser;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.persistence.ibatis.vo.EpRSchemeAlarmSourceVO;
import com.megaeyes.persistence.ibatis.vo.EpSchemeVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelAndSchemeVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpSchemeManager;
import com.megaeyes.service.utils.DeviceType;

/**
 * @ClassName: EpSchemeManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-16 上午2:21:12
 * 
 */
public class EpSchemeManagerImpl extends BaseManagerImpl implements
		EpSchemeManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	OrganDAOiBatis organDAO;
	@Autowired
	EpSchemeDAOiBatis epSchemeDAO;
	@Autowired
	EpSchemeCommandDAOiBatis epSchemeCommandDAO;
	@Autowired
	UserDAOiBatis userDAO;
	@Autowired
	AlarmOutputChannelDAOiBatis alarmOutputChannelDAO;
	@Autowired
	VideoInputChannelDAOiBatis VideoInputChannelDAO;
	@Autowired
	EpPresetDAOiBatis epPresetDAO;
	@Autowired
	VideoOutputChannelDAOiBatis videoOutputChannelDAO;
	@Autowired
	EpTrackDAOiBatis epTrackDAO;
	@Autowired
	EpProberDAOiBatis epProberDAO;
	@Autowired
	EpRSchemeAlarmSourceDAOiBatis epRSchemeAlarmSourceDAO;
	@Autowired
	AcAccessControlsDAOiBatis acAccessControlDAO;

	public String createES(String name, String organId, String note,
			String type, Long lastUpdateTime, String actions, String userId)
			throws BusinessException, JSONException {
		if (StringUtils.isNotBlank(name)) {
			EpSchemeExample esExample = new EpSchemeExample();
			EpSchemeExample.Criteria criteria = esExample.createCriteria();
			criteria.andNameEqualTo(name);
			int count = epSchemeDAO.countByExample(esExample);
			if (count > 0) {
				throw new BusinessException("name", ErrorCode.NAME_EXIST);
			}
		} else {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
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
		} else {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getEpSchemeSeq();
		try {
			EpScheme es = new EpScheme();
			es.setId(id);
			es.setName(name);
			es.setOrganId(organId);
			es.setNote(note);
			es.setType(type);
			es.setLastUpdateTime(lastUpdateTime);
			epSchemeDAO.insert(es);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), ErrorCode.ERROR);
		}
		if (StringUtils.isNotBlank(actions)) {
			JSONObject jsonObject = new JSONObject(actions);
			String targetType[] = { "notifyUsers", "alarmOuts", "recorders",
					"presets", "tracks", "probers", "displays", "doors" };
			for (int i = 0; i < targetType.length; i++) {
				JSONArray jsonArray = new JSONArray();
				try {
					jsonArray = jsonObject.getJSONArray(targetType[i]);
				} catch (JSONException e) {
					e.printStackTrace();
					continue;
				}
				if (jsonArray.length() > 0) {
					for (int n = 0; n < jsonArray.length(); n++) {
						JSONObject jsonObj = new JSONObject(
								jsonArray.getString(n));
						String commandId = sequenceDAO.getEpSchemeCommandSeq();
						String targetId = jsonObj.getString("id");
						if (StringUtils.isBlank(targetId)) {
							System.out.println("targetType[i]" + targetType[i]);
							throw new BusinessException("id",
									ErrorCode.PARAMETER_NOT_FOUND);

						}
						// String value = jsonObj.getString("value");
						// String duration = jsonObj.getString("duration");
						EpSchemeCommand esc = new EpSchemeCommand();
						esc.setId(commandId);
						esc.setEpSchemeId(id);
						esc.setTargetId(targetId);
						// esc.setDuration(duration);
						// esc.setValue(value);
						if ("notifyUsers".equals(targetType[i])) {
							esc.setTargetType(DeviceType.TARGET_TYPE_NOTIFY_USER);
						}
						if ("alarmOuts".equals(targetType[i])) {
							String value = jsonObj.getString("value");
							String duration = jsonObj.getString("duration");
							esc.setDuration(duration);
							esc.setValue(value);
							esc.setTargetType(DeviceType.TARGET_TYPE_AOC);
						}
						if ("recorders".equals(targetType[i])) {
							String duration = jsonObj.getString("duration");
							esc.setDuration(duration);
							esc.setTargetType(DeviceType.TARGET_TYPE_RECORD);
						}
						if ("presets".equals(targetType[i])) {
							String duration = jsonObj.getString("duration");
							String value = jsonObj.getString("value");
							esc.setDuration(duration);
							esc.setValue(value);
							esc.setTargetType(DeviceType.TARGET_TYPE_PRESET);
						}
						if ("tracks".equals(targetType[i])) {
							esc.setTargetType(DeviceType.TARGET_TYPE_TRACK);
						}
						if ("probers".equals(targetType[i])) {
							String duration = jsonObj.getString("duration");
							String value = jsonObj.getString("value");
							esc.setDuration(duration);
							esc.setValue(value);
							esc.setTargetType(DeviceType.TARGET_TYPE_PROBER);
						}
						if ("displays".equals(targetType[i])) {
							String duration = jsonObj.getString("duration");
							String value = jsonObj.getString("value");
							esc.setDuration(duration);
							esc.setValue(value);
							String sSeq = jsonObj.getString("seq");
							int seq = StringUtils.isBlank(sSeq) ? 0 : Integer
									.parseInt(sSeq);
							esc.setSeq(seq);
							esc.setTargetType(DeviceType.TARGET_TYPE_DISPLAY);
						}
						if ("doors".equals(targetType[i])) {
							String value = jsonObj.getString("value");
							esc.setValue(value);
							esc.setTargetType(DeviceType.TARGET_TYPE_DOOR);
						}
						epSchemeCommandDAO.insert(esc);
					}
				}
			}
		}

		return id;
	}

	public void deleteES(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try {
			// 删除command
			epSchemeCommandDAO.deleteESCByEpSchemeId(id);

			// 删除与报警源的关联
			EpRSchemeAlarmSourceExample rSourceExample = new EpRSchemeAlarmSourceExample();
			EpRSchemeAlarmSourceExample.Criteria rSourceCriteria = rSourceExample
					.createCriteria();
			rSourceCriteria.andEpSchemeIdEqualTo(id);
			epRSchemeAlarmSourceDAO.deleteByExample(rSourceExample);
			// 删除预案自身
			epSchemeDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), ErrorCode.ERROR);
		}
	}

	public List<EpScheme> listESByOrganId(String organId)
			throws BusinessException {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epSchemeDAO.listESByOrganId(organId);
	}

	public void updateES(String id, String name, String organId, String note,
			String type, Long lastUpdateTime, String actions)
			throws BusinessException, JSONException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(name)) {
			EpSchemeExample esExample = new EpSchemeExample();
			EpSchemeExample.Criteria criteria = esExample.createCriteria();
			criteria.andNameEqualTo(name);
			List<EpScheme> list = epSchemeDAO.selectByExample(esExample);
			if (list.size() > 0) {
				if (!list.get(0).getId().equals(id)) {
					if (list.get(0).getName().equals(name)) {
						throw new BusinessException("name",
								ErrorCode.NAME_EXIST);
					}
				}
			}
		} else {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
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
		} else {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		try {
			EpScheme es = new EpScheme();
			es.setId(id);
			es.setName(name);
			es.setOrganId(organId);
			es.setNote(note);
			es.setType(type);
			es.setLastUpdateTime(lastUpdateTime);
			epSchemeDAO.updateByPrimaryKeySelective(es);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), ErrorCode.ERROR);
		}
		if (StringUtils.isNotBlank(actions)) {
			epSchemeCommandDAO.deleteESCByEpSchemeId(id);
			JSONObject jsonObject = new JSONObject(actions);
			String targetType[] = { "notifyUsers", "alarmOuts", "recorders",
					"presets", "tracks", "probers", "displays", "doors" };
			for (int i = 0; i < targetType.length; i++) {
				JSONArray jsonArray = new JSONArray();
				try {
					jsonArray = jsonObject.getJSONArray(targetType[i]);
				} catch (JSONException e) {
					e.printStackTrace();
					continue;
				}
				if (jsonArray.length() > 0) {
					for (int n = 0; n < jsonArray.length(); n++) {
						JSONObject jsonObj = new JSONObject(
								jsonArray.getString(n));
						String commandId = sequenceDAO.getEpSchemeCommandSeq();
						String targetId = jsonObj.getString("id");
						if (StringUtils.isBlank(targetId)) {
							System.out.println("targetType[i]" + targetType[i]);
							throw new BusinessException("targetId",
									ErrorCode.PARAMETER_NOT_FOUND);

						}
						// String value = jsonObj.getString("value");
						// String duration = jsonObj.getString("duration");
						EpSchemeCommand esc = new EpSchemeCommand();
						esc.setId(commandId);
						esc.setEpSchemeId(id);
						esc.setTargetId(targetId);
						// esc.setDuration(duration);
						// esc.setValue(value);
						if ("notifyUsers".equals(targetType[i])) {
							esc.setTargetType(DeviceType.TARGET_TYPE_NOTIFY_USER);
						}
						if ("alarmOuts".equals(targetType[i])) {
							String value = jsonObj.getString("value");
							String duration = jsonObj.getString("duration");
							esc.setDuration(duration);
							esc.setValue(value);
							esc.setTargetType(DeviceType.TARGET_TYPE_AOC);
						}
						if ("recorders".equals(targetType[i])) {
							String duration = jsonObj.getString("duration");
							esc.setDuration(duration);
							esc.setTargetType(DeviceType.TARGET_TYPE_RECORD);
						}
						if ("presets".equals(targetType[i])) {
							String duration = jsonObj.getString("duration");
							String value = jsonObj.getString("value");
							esc.setDuration(duration);
							esc.setValue(value);
							esc.setTargetType(DeviceType.TARGET_TYPE_PRESET);
						}
						if ("tracks".equals(targetType[i])) {
							esc.setTargetType(DeviceType.TARGET_TYPE_TRACK);
						}
						if ("probers".equals(targetType[i])) {
							String duration = jsonObj.getString("duration");
							String value = jsonObj.getString("value");
							esc.setDuration(duration);
							esc.setValue(value);
							esc.setTargetType(DeviceType.TARGET_TYPE_PROBER);
						}
						if ("displays".equals(targetType[i])) {
							String duration = jsonObj.getString("duration");
							String value = jsonObj.getString("value");
							esc.setDuration(duration);
							esc.setValue(value);
							String sSeq = jsonObj.getString("seq");
							int seq = StringUtils.isBlank(sSeq) ? 0 : Integer
									.parseInt(sSeq);
							esc.setSeq(seq);
							esc.setTargetType(DeviceType.TARGET_TYPE_DISPLAY);
						}
						if ("doors".equals(targetType[i])) {
							String value = jsonObj.getString("value");
							esc.setValue(value);
							esc.setTargetType(DeviceType.TARGET_TYPE_DOOR);
						}
						epSchemeCommandDAO.insert(esc);
					}
				}
			}
		}

	}

	public EpSchemeVO getEpScheme(String id) throws BusinessException {
		EpScheme epScheme = epSchemeDAO.selectByPrimaryKey(id);
		if (null == epScheme) {
			return null;
		}
		List<EpScheme> schemes = new ArrayList<EpScheme>();
		schemes.add(epScheme);
		List<EpSchemeVO> vos = getEpSchemeVOsFromEpSchemes(schemes);
		return vos.get(0);
	}

	private List<EpSchemeVO> getEpSchemeVOsFromEpSchemes(
			List<EpScheme> epSchemes) throws BusinessException {
		List<EpSchemeVO> epSchemeVOs = new LinkedList<EpSchemeVO>();
		for (EpScheme epScheme : epSchemes) {
			EpSchemeVO epSchemeVO = new EpSchemeVO();
			epSchemeVO.setId(epScheme.getId());
			epSchemeVO.setName(epScheme.getName());
			epSchemeVO.setOrganId(epScheme.getOrganId());
			epSchemeVO.setNote(epScheme.getNote());
			epSchemeVO.setType(epScheme.getType());

			EpSchemeVO.Action actions = epSchemeVO.new Action();
			List<EpSchemeVO.NotifyUser> notifyUsers = new LinkedList<EpSchemeVO.NotifyUser>();
			List<EpSchemeVO.AlarmOut> alarmOuts = new LinkedList<EpSchemeVO.AlarmOut>();
			List<EpSchemeVO.Recorder> recorders = new LinkedList<EpSchemeVO.Recorder>();
			List<EpSchemeVO.Preset> presets = new LinkedList<EpSchemeVO.Preset>();
			List<EpSchemeVO.Track> tracks = new LinkedList<EpSchemeVO.Track>();
			List<EpSchemeVO.Prober> probers = new LinkedList<EpSchemeVO.Prober>();
			List<EpSchemeVO.Display> displays = new LinkedList<EpSchemeVO.Display>();
			List<EpSchemeVO.Door> doors = new LinkedList<EpSchemeVO.Door>();
			EpSchemeCommandExample commandExample;
			// notifyUsers
			commandExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria notifyUsersCriteria = commandExample
					.createCriteria();
			notifyUsersCriteria
					.andTargetTypeEqualTo(DeviceType.TARGET_TYPE_NOTIFY_USER);
			notifyUsersCriteria.andEpSchemeIdEqualTo(epScheme.getId());
			List<EpSchemeCommand> notifyUsersCommands = epSchemeCommandDAO
					.selectByExample(commandExample);
			for (EpSchemeCommand command : notifyUsersCommands) {
				EpSchemeVO.NotifyUser notifyUser = epSchemeVO.new NotifyUser();
				TUser user = userDAO.selectByPrimaryKey(command.getTargetId());
				if (null == user) {
					continue;
				}
				notifyUser.setId(command.getTargetId());
				notifyUser.setName(user.getLogonName());
				notifyUsers.add(notifyUser);
			}

			// alarmOuts
			commandExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria alarmOutsCriteria = commandExample
					.createCriteria();
			alarmOutsCriteria.andTargetTypeEqualTo(DeviceType.TARGET_TYPE_AOC);
			alarmOutsCriteria.andEpSchemeIdEqualTo(epScheme.getId());
			List<EpSchemeCommand> alarmOutsCommands = epSchemeCommandDAO
					.selectByExample(commandExample);
			for (EpSchemeCommand command : alarmOutsCommands) {
				EpSchemeVO.AlarmOut alarmOut = epSchemeVO.new AlarmOut();
				AlarmOutputChannel aoc = alarmOutputChannelDAO
						.selectByPrimaryKey(command.getTargetId());
				if (null == aoc) {
					continue;
				}
				alarmOut.setId(command.getTargetId());
				alarmOut.setName(aoc.getName());
				alarmOut.setDuration(command.getDuration());
				alarmOut.setValue(command.getValue());
				alarmOuts.add(alarmOut);
			}

			// recorders
			commandExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria recordersCriteria = commandExample
					.createCriteria();
			recordersCriteria
					.andTargetTypeEqualTo(DeviceType.TARGET_TYPE_RECORD);
			recordersCriteria.andEpSchemeIdEqualTo(epScheme.getId());
			List<EpSchemeCommand> recordersCommands = epSchemeCommandDAO
					.selectByExample(commandExample);
			for (EpSchemeCommand command : recordersCommands) {
				EpSchemeVO.Recorder recorder = epSchemeVO.new Recorder();
				VideoInputChannel vic = VideoInputChannelDAO
						.selectByPrimaryKey(command.getTargetId());
				if (null == vic) {
					continue;
				}
				recorder.setId(command.getTargetId());
				recorder.setName(vic.getName());
				recorder.setDuration(command.getDuration());
				recorders.add(recorder);
			}

			// presets
			commandExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria presetsCriteria = commandExample
					.createCriteria();
			presetsCriteria.andTargetTypeEqualTo(DeviceType.TARGET_TYPE_PRESET);
			presetsCriteria.andEpSchemeIdEqualTo(epScheme.getId());
			List<EpSchemeCommand> presetsCommands = epSchemeCommandDAO
					.selectByExample(commandExample);
			for (EpSchemeCommand command : presetsCommands) {
				EpSchemeVO.Preset preset = epSchemeVO.new Preset();
				EpPreset epPreset = epPresetDAO.selectByPrimaryKey(command
						.getTargetId());
				if (null == epPreset) {
					continue;
				}
				VideoInputChannel vic = VideoInputChannelDAO
						.selectByPrimaryKey(epPreset.getVicId());
				if (null == vic) {
					continue;
				}
				preset.setId(command.getTargetId());
				preset.setName(vic.getName());
				preset.setDuration(command.getDuration());
				preset.setValue(epPreset.getPresetNumber() + "");
				preset.setPresetName(epPreset.getName());
				preset.setVicId(epPreset.getVicId());
				presets.add(preset);
			}

			// tracks
			commandExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria tracksCriteria = commandExample
					.createCriteria();
			tracksCriteria.andTargetTypeEqualTo(DeviceType.TARGET_TYPE_TRACK);
			tracksCriteria.andEpSchemeIdEqualTo(epScheme.getId());
			List<EpSchemeCommand> tracksCommands = epSchemeCommandDAO
					.selectByExample(commandExample);
			for (EpSchemeCommand command : tracksCommands) {
				EpSchemeVO.Track track = epSchemeVO.new Track();
				EpTrack epTrack = epTrackDAO.selectByPrimaryKey(command
						.getTargetId());
				if (null == epTrack) {
					continue;
				}
				track.setId(command.getTargetId());
				track.setName(epTrack.getName());
				tracks.add(track);
			}

			// probers
			commandExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria probersCriteria = commandExample
					.createCriteria();
			probersCriteria.andTargetTypeEqualTo(DeviceType.TARGET_TYPE_PROBER);
			probersCriteria.andEpSchemeIdEqualTo(epScheme.getId());
			List<EpSchemeCommand> probersCommands = epSchemeCommandDAO
					.selectByExample(commandExample);
			for (EpSchemeCommand command : probersCommands) {
				EpSchemeVO.Prober prober = epSchemeVO.new Prober();
				EpProber epProber = epProberDAO.selectByPrimaryKey(command
						.getTargetId());
				if (null == epProber) {
					continue;
				}
				prober.setId(command.getTargetId());
				prober.setName(epProber.getName());
				prober.setValue(command.getValue());
				prober.setDuration(command.getDuration());
				probers.add(prober);
			}

			// displays
			commandExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria displaysCriteria = commandExample
					.createCriteria();
			displaysCriteria
					.andTargetTypeEqualTo(DeviceType.TARGET_TYPE_DISPLAY);
			displaysCriteria.andEpSchemeIdEqualTo(epScheme.getId());
			List<EpSchemeCommand> displaysCommands = epSchemeCommandDAO
					.selectByExample(commandExample);
			for (EpSchemeCommand command : displaysCommands) {
				EpSchemeVO.Display display = epSchemeVO.new Display();
				VideoInputChannel vic = VideoInputChannelDAO
						.selectByPrimaryKey(command.getValue());
				if (null == vic) {
					continue;
				}
				VideoOutputChannel voc = videoOutputChannelDAO
						.selectByPrimaryKey(command.getTargetId());
				if (null == voc) {
					continue;
				}
				display.setId(command.getTargetId());
				display.setName(voc.getName());
				display.setDuration(command.getDuration());
				display.setSeq(command.getSeq().toString());
				display.setValue(command.getValue());
				display.setVicName(vic.getName());
				displays.add(display);
			}
			
			// doors
			commandExample = new EpSchemeCommandExample();
			EpSchemeCommandExample.Criteria doorsCriteria = commandExample.createCriteria();
			doorsCriteria.andTargetTypeEqualTo(DeviceType.TARGET_TYPE_DOOR);
			doorsCriteria.andEpSchemeIdEqualTo(epScheme.getId());
			List<EpSchemeCommand> doorsCommands = epSchemeCommandDAO.selectByExample(commandExample);
			for (EpSchemeCommand command : doorsCommands) {
				EpSchemeVO.Door door = epSchemeVO.new Door();
				AcAccessControls acAccessControls = acAccessControlDAO.selectByPrimaryKey(command.getTargetId());
				if (null == acAccessControls) {
					continue;
				}
				door.setId(command.getTargetId());
				door.setName(acAccessControls.getName());
				door.setValue(command.getValue());
				doors.add(door);
			}

			actions.setNotifyUsers(notifyUsers);
			actions.setAlarmOuts(alarmOuts);
			actions.setRecorders(recorders);
			actions.setPresets(presets);
			actions.setTracks(tracks);
			actions.setProbers(probers);
			actions.setDisplays(displays);
			actions.setDoors(doors);
			epSchemeVO.setActions(actions);

			epSchemeVOs.add(epSchemeVO);
		}

		return epSchemeVOs;
	}

	public String bindDeviceEpScheme(String deviceId, String deviceType,
			String schemeId, String alarmType) throws BusinessException {
		if (StringUtils.isBlank(deviceId)) {
			throw new BusinessException("deviceId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(deviceType)) {
			throw new BusinessException("deviceType",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(schemeId)) {
			throw new BusinessException("schemeId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		// if(StringUtils.isBlank(alarmType)){
		// throw new
		// BusinessException("alarmType",ErrorCode.PARAMETER_NOT_FOUND);
		// }

		// 删除对应设备老的关联
		EpRSchemeAlarmSourceExample example = new EpRSchemeAlarmSourceExample();
		EpRSchemeAlarmSourceExample.Criteria criteria = example
				.createCriteria();
		criteria.andSourceIdEqualTo(deviceId);
		criteria.andSourceTypeEqualTo(deviceType);
		if (StringUtils.isNotBlank(alarmType)) {
			criteria.andAlarmTypeEqualTo(alarmType);
		}
		epRSchemeAlarmSourceDAO.deleteByExample(example);

		// 插入新设备的预案关联
		// 如果报警类型未定义，默认为全部类型
		if (StringUtils.isBlank(alarmType)) {
			for (int i = 0; i < 32; i++) {
				String id = sequenceDAO.getEpRSchemeAlarmSourceSeq();
				EpRSchemeAlarmSource r = new EpRSchemeAlarmSource();
				r.setId(id);
				r.setEpSchemeId(schemeId);
				r.setSourceId(deviceId);
				r.setSourceType(deviceType);
				r.setAlarmType((long) Math.pow(2, i) + "");
				epRSchemeAlarmSourceDAO.insert(r);
			}
		} else {
			String id = sequenceDAO.getEpRSchemeAlarmSourceSeq();
			EpRSchemeAlarmSource r = new EpRSchemeAlarmSource();
			r.setId(id);
			r.setEpSchemeId(schemeId);
			r.setSourceId(deviceId);
			r.setSourceType(deviceType);
			r.setAlarmType(alarmType);
			epRSchemeAlarmSourceDAO.insert(r);
		}

		return "";
	}

	public List getEpRSchemeAlarmSource(String sourceIds) throws JSONException {
		if (StringUtils.isBlank(sourceIds)) {
			throw new BusinessException("sourceId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		System.out.println("sourceIds:" + sourceIds);
		JSONArray jsonArray = new JSONArray(sourceIds);

		List relist = new ArrayList();
		// JSONArray rejsonArray = new JSONArray();
		for (int i = 0; i < jsonArray.length(); i++) {
			// JSONObject rejson = new JSONObject();
			EpRSchemeAlarmSourceVO vo = new EpRSchemeAlarmSourceVO();
			JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
			String sourceId = jsonObj.get("sourceId").toString();
			EpRSchemeAlarmSourceExample example = new EpRSchemeAlarmSourceExample();
			EpRSchemeAlarmSourceExample.Criteria criteria = example
					.createCriteria();
			criteria.andSourceIdEqualTo(sourceId);
			List<EpRSchemeAlarmSource> list = epRSchemeAlarmSourceDAO
					.selectByExample(example);
			System.out.println("sourceId:" + sourceId);

			System.out.println("list.size:" + list.size());
			if (list.size() == 0) {
				continue;
			} else {
				vo.setSourceId(sourceId);
				EpRSchemeAlarmSource ersas = list.get(0);
				vo.setEpSchemeId(ersas.getEpSchemeId());
			}
			relist.add(vo);
		}
		return relist;
	}

	public void deleteDeviceEpScheme(String deviceId, String deviceType,
			String schemeId, String alarmType) throws BusinessException {
		EpRSchemeAlarmSourceExample example = new EpRSchemeAlarmSourceExample();
		EpRSchemeAlarmSourceExample.Criteria criteria = example
				.createCriteria();
		criteria.andSourceIdEqualTo(deviceId);
		criteria.andSourceTypeEqualTo(deviceType);
		if (StringUtils.isNotBlank(alarmType)) {
			criteria.andAlarmTypeEqualTo(alarmType);
		}
		epRSchemeAlarmSourceDAO.deleteByExample(example);
	}

	public void updateESTimeById(String schemeId) throws BusinessException {
		if (StringUtils.isNotBlank(schemeId)) {
			EpScheme scheme = new EpScheme();
			scheme.setId(schemeId);
			scheme.setLastUpdateTime(System.currentTimeMillis());
			epSchemeDAO.updateByPrimaryKeySelective(scheme);
		} else {
			throw new BusinessException("schemeId is null !",
					ErrorCode.PARAMETER_NOT_FOUND);
		}

	}

	public List<VideoInputChannelAndSchemeVO> listVICAndSchemeByOrganId(
			String organId) {
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		List<VideoInputChannelAndSchemeVO> list = epSchemeDAO.listVICAndScheme(organId);
			
		return list;
	}
}
