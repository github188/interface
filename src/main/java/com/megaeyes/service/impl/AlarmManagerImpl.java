package com.megaeyes.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.avalon.framework.service.ServiceException;
import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.JDOMParseException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.AlarmInputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AlarmInputChannelTypeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpAlarmEventDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpEventTypeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpProberDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpProberTypeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRSchemeAlarmSourceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpSchemeCommandDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpSchemeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.PlatformResourcesDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SipServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.StorageServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannelType;
import com.megaeyes.persistence.ibatis.model.EpAlarmEvent;
import com.megaeyes.persistence.ibatis.model.EpAlarmEventExample;
import com.megaeyes.persistence.ibatis.model.EpEventType;
import com.megaeyes.persistence.ibatis.model.EpEventTypeExample;
import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.persistence.ibatis.model.EpProberType;
import com.megaeyes.persistence.ibatis.model.EpRSchemeAlarmSource;
import com.megaeyes.persistence.ibatis.model.EpRSchemeAlarmSourceExample;
import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.model.EpSchemeCommand;
import com.megaeyes.persistence.ibatis.model.EpSchemeCommandExample;
import com.megaeyes.persistence.ibatis.model.EpSchemeExample;
import com.megaeyes.persistence.ibatis.model.HistoryVideo;
import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.SipServer;
import com.megaeyes.persistence.ibatis.model.SipServerExample;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.vo.ResourceVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AlarmManager;
import com.megaeyes.service.utils.DeviceType;
import com.megaeyes.service.utils.socket.MegaSocketClient;

public class AlarmManagerImpl extends BaseManagerImpl implements AlarmManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	OrganDAOiBatis organDAO;
	@Autowired
	EpSchemeDAOiBatis epSchemeDAO;
	@Autowired
	EpSchemeCommandDAOiBatis epSchemeCommandDAO;
	@Autowired
	EpRSchemeAlarmSourceDAOiBatis epRSchemeAlarmSourceDAO;
	@Autowired
	EpAlarmEventDAOiBatis epAlarmEventDAO;
	@Autowired
	AlarmInputChannelDAOiBatis alarmInputChannelDAO;
	@Autowired
	AlarmInputChannelTypeDAOiBatis AlarmInputChannelTypeDAO;
	@Autowired
	EpEventTypeDAOiBatis epEventTypeDAO;
	@Autowired
	PlatformResourcesDAOiBatis platformResourcesDAO;
	@Autowired
	SipServerDAOiBatis sipServerDAO;
	@Autowired
	EpProberDAOiBatis epProberDAO;
	@Autowired
	EpProberTypeDAOiBatis epProberTypeDAO;
	@Autowired
	VideoInputChannelDAOiBatis VideoInputChannelDAO;
	@Autowired
	StorageServerDAOiBatis storageServerDAO;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");

	public Document listSchemesDetail(String[] ids) throws ServiceException {
		if (ids == null || ids.length < 1) {
			throw new BusinessException("ids", ErrorCode.PARAMETER_NOT_FOUND);
		}
		// 返回xml
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText("Y");
		root.addContent(success);
		Element schemes = new Element("Schemes");
		root.addContent(schemes);
		for (int i = 0; i < ids.length; i++) {
			EpScheme scheme = epSchemeDAO.selectByPrimaryKey(ids[i]);
			if (scheme == null) {
				throw new BusinessException("EpScheme",
						ErrorCode.RESOURCE_NOT_FOUND);
			}
			Element schemeElement = new Element("Scheme");
			schemeElement.setAttribute("Id", scheme.getId());
			schemeElement.setAttribute("Name", scheme.getName());
			schemes.addContent(schemeElement);
			// 获取预案指令
			Element commandsElement = new Element("Commands");
			schemeElement.addContent(commandsElement);
			EpSchemeCommandExample escExample = new EpSchemeCommandExample();
			escExample.createCriteria().andEpSchemeIdEqualTo(ids[i]);
			List<EpSchemeCommand> commands = epSchemeCommandDAO
					.selectByExample(escExample);
			for (EpSchemeCommand command : commands) {
				Element commandElement = new Element("Command");
				String naming = findNamingByIdAndType(command.getTargetId(),
						command.getTargetType());
				if (null == naming) {
					naming = "";
				}
				commandElement.setAttribute("TargetId", naming);
				commandElement.setAttribute("TargetType",
						command.getTargetType());
				// 如果是报警录像指令需要获取存储的IP和端口
				if (DeviceType.TARGET_TYPE_RECORD.equals(command
						.getTargetType())) {
					String ssIp = getVicAlarmStorageServerIp(command
							.getTargetId());
					if (StringUtils.isBlank(ssIp)) {
						System.out
								.println("Alarm storage server ip is null, ignore command !");
						continue;
					}
					commandElement.setAttribute("Value", ssIp);
				}
				// 如果是显示墙投墙，根据value中的摄像头ID，查询处摄像头Naming
				else if (DeviceType.TARGET_TYPE_DISPLAY.equals(command
						.getTargetType())) {
					String vicId = command.getValue();
					VideoInputChannel vic = VideoInputChannelDAO
							.selectByPrimaryKey(vicId);
					if (null == vic) {
						throw new BusinessException("vic[" + vicId
								+ "] not found !", ErrorCode.RESOURCE_NOT_FOUND);
					}
					if (StringUtils.isBlank(vic.getNaming())) {
						throw new BusinessException("vic[" + vicId
								+ "] not registered !",
								ErrorCode.DEVICE_NOT_REGISTERED);
					}
					commandElement.setAttribute("Value", vic.getNaming());
				} else {
					commandElement.setAttribute("Value",
							command.getValue() != null ? command.getValue()
									: "");
				}
				commandElement.setAttribute("Seq",
						command.getSeq() != null ? command.getSeq().toString()
								: "");
				commandElement.setAttribute("Duration",
						command.getDuration() != null ? command.getDuration()
								: "");
				commandsElement.addContent(commandElement);
			}
			// 获取关联报警源
			Element sourcesElement = new Element("Sources");
			schemeElement.addContent(sourcesElement);
			EpRSchemeAlarmSourceExample erasExample = new EpRSchemeAlarmSourceExample();
			erasExample.createCriteria().andEpSchemeIdEqualTo(ids[i]);
			List<EpRSchemeAlarmSource> sources = epRSchemeAlarmSourceDAO
					.selectByExample(erasExample);
			for (EpRSchemeAlarmSource source : sources) {
				Element sourceElement = new Element("Source");
				sourceElement.setAttribute("Id", source.getSourceId());
				sourceElement.setAttribute("Type", source.getSourceType());
				sourceElement.setAttribute("AlarmType",
						source.getAlarmType() != null ? source.getAlarmType()
								: "");
				sourcesElement.addContent(sourceElement);
			}
		}
		return doc;
	}

	/**
	 * 根据资源ID和预案指令类型，获取资源Naming
	 * 
	 * @param id
	 *            资源ID
	 * @param type
	 *            预案指令类型，参见
	 *            {@link com.megaeyes.consoleinterface.web.common.DeviceType}
	 * @return
	 */
	public String findNamingByIdAndType(String id, String type) {
		if (DeviceType.TARGET_TYPE_RECORD.equals(type)) {
			return epSchemeCommandDAO.getVicNaming(id);
		} else if (DeviceType.TARGET_TYPE_PRESET.equals(type)) {
			return epSchemeCommandDAO.getVicNamingByPresetId(id);
		} else if (DeviceType.TARGET_TYPE_NOTIFY_USER.equals(type)) {
			return epSchemeCommandDAO.getUserNaming(id);
		} else if (DeviceType.TARGET_TYPE_DISPLAY.equals(type)) {
			return epSchemeCommandDAO.getVocNaming(id);
		} else if (DeviceType.TARGET_TYPE_AOC.equals(type)) {
			return epSchemeCommandDAO.getAocNaming(id);
		} else if (DeviceType.TARGET_TYPE_PROBER.equals(type)) {
			return epSchemeCommandDAO.getProberNaming(id);
		} else if (DeviceType.TARGET_TYPE_DOOR.equals(type)) {
			return epSchemeCommandDAO.getDoorNaming(id);
		}
		return "";
	}

	/**
	 * 根据资源ID和预案类型，获取指令的输出Value
	 * 
	 * @param id
	 *            资源ID
	 * @param type
	 *            预案指令类型
	 * @return
	 */
	public String getVicAlarmStorageServerIp(String id) {
		return epSchemeCommandDAO.getVicAlarmStorageServerIp(id);
	}

	public Long getSchemesLastUpdateTime() throws ServiceException {
		return epSchemeDAO.getSchemesLastUpdateTime();
	}

	public List<EpScheme> listEpScheme(String organId) throws ServiceException {
		EpSchemeExample example = new EpSchemeExample();
		if (StringUtils.isNotBlank(organId)) {
			EpSchemeExample.Criteria criteria = example.createCriteria();
			criteria.andOrganIdEqualTo(organId);
		}
		List<EpScheme> list = epSchemeDAO.selectByExample(example);
		return list;
	}

	public String insertEpAlarmEvent(String sessionId, String sourceId,
			String sourceType, String threshold, String value, Long beginTime,
			Long endTime, String note, String naming, String eventTypeName,
			String level) {
		EpAlarmEvent event = new EpAlarmEvent();
		String id = epAlarmEventDAO.getEpAlarmEventSeq();
		event.setId(id);
		event.setSessionId(sessionId);
		event.setSourceId(sourceId);
		event.setSourceType(sourceType);
		event.setThreshold(threshold);
		event.setValue(value);
		event.setBeginTime(beginTime != null ? new BigDecimal(beginTime) : null);
		event.setEndTime(endTime != null ? new BigDecimal(endTime) : null);
		event.setNote(note);
		event.setNaming(naming);
		ResourceVO source = findTargetNameByIdAndType(sourceId, sourceType);
		if (null == source) {
			throw new BusinessException("sourceId=" + sourceId
					+ " and sourceType=" + sourceType + " not found !",
					ErrorCode.RESOURCE_NOT_FOUND);
		}
		event.setOrganId(source.getOrganId());
		event.setSourceName(source.getName());
		event.setEventTypeName(eventTypeName);
		event.setEventLevel(level);
		// 默认没有报警存储关联
		event.setRecordFlag("0");

		// 查询报警源有否关联预案
		EpRSchemeAlarmSourceExample rExample = new EpRSchemeAlarmSourceExample();
		rExample.createCriteria().andSourceIdEqualTo(sourceId)
				.andSourceTypeEqualTo(sourceType);
		List<EpRSchemeAlarmSource> list = epRSchemeAlarmSourceDAO
				.selectByExample(rExample);
		for (EpRSchemeAlarmSource r : list) {
			// 查询对应的预案
			EpSchemeCommandExample commandExample = new EpSchemeCommandExample();
			commandExample.createCriteria().andEpSchemeIdEqualTo(
					r.getEpSchemeId());
			List<EpSchemeCommand> commands = epSchemeCommandDAO
					.selectByExample(commandExample);
			// 判断关联的预案中有否有报警存储指令
			for (EpSchemeCommand command : commands) {
				if (command.getTargetType().equals(
						DeviceType.TARGET_TYPE_RECORD)) {
					event.setRecordFlag("1");
					break;
				}
			}
			if (event.getRecordFlag().equals("1")) {
				break;
			}
		}
		epAlarmEventDAO.insert(event);
		return id;
	}

	public ResourceVO findTargetNameByIdAndType(String id, String type) {
		if (DeviceType.DEVICE_TYPE_ORGAN.equals(type)) {
			return epAlarmEventDAO.getOrganNameById(id);
		} else if (DeviceType.DEVICE_TYPE_VIC.equals(type)) {
			return epAlarmEventDAO.getVicNameById(id);
		} else if (DeviceType.DEVICE_TYPE_VIC.equals(type)) {
			return epAlarmEventDAO.getVicNameById(id);
		} else if (DeviceType.DEVICE_TYPE_DI.equals(type)) {
			return epAlarmEventDAO.getEpProberNameById(id);
		} else if (DeviceType.DEVICE_TYPE_DO.equals(type)) {
			return epAlarmEventDAO.getEpProberNameById(id);
		} else if (DeviceType.DEVICE_TYPE_ANALOG.equals(type)) {
			return epAlarmEventDAO.getEpProberNameById(id);
		} else if (DeviceType.DEVICE_TYPE_EP_DEVICE.equals(type)) {
			return epAlarmEventDAO.getEpDeviceNameById(id);
		} else if (DeviceType.DEVICE_TYPE_AIC.equals(type)) {
			return epAlarmEventDAO.getAicNameById(id);
		} else if (DeviceType.DEVICE_TYPE_AOC.equals(type)) {
			return epAlarmEventDAO.getAocNameById(id);
		} else if (DeviceType.DEVICE_TYPE_VOC.equals(type)) {
			return epAlarmEventDAO.getVocNameById(id);
		} else if (DeviceType.DEVICE_TYPE_VIS.equals(type)) {
			return epAlarmEventDAO.getVisNameById(id);
		} else if (DeviceType.DEVICE_TYPE_IC.equals(type)) {
			return epAlarmEventDAO.getICNameById(id);
		} else if (DeviceType.DEVICE_TYPE_AC_ACCESS_CONTROL.equals(type)) {
			return epAlarmEventDAO.getACAccessControlNameById(id);
		} else if (DeviceType.DEVICE_TYPE_AC_AREA.equals(type)) {
			return epAlarmEventDAO.getACAccessControlNameById(id);
		} else {
			return epAlarmEventDAO.getEpDeviceNameById(id);
		}
	}

	public String getEventTypeName(String eventNaming) {
		if (StringUtils.isBlank(eventNaming)) {
			throw new BusinessException("eventNaming",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] params = eventNaming.split("_");
		if (params.length < 3) {
			throw new BusinessException("eventNaming",
					ErrorCode.RESOURCE_NOT_FOUND);
		}
		// 如果是报警输入报警
		if ("131072".equals(params[1])) {
			AlarmInputChannel aic = alarmInputChannelDAO
					.selectByPrimaryKey(params[2]);
			if (aic == null) {
				throw new BusinessException("eventNaming",
						ErrorCode.RESOURCE_NOT_FOUND);
			}
			AlarmInputChannelType aicType = AlarmInputChannelTypeDAO
					.selectByPrimaryKey(aic.getAlarmInputChannelTypeId());
			return aicType.getName() + "报警";
		} else if ("4096".equals(params[1])) {
			EpProber prober = epProberDAO.selectByPrimaryKey(params[2]);
			if (null == prober) {
				throw new BusinessException(params[2] + " not found !",
						ErrorCode.RESOURCE_NOT_FOUND);
			}
			EpProberType type = epProberTypeDAO.selectByPrimaryKey(prober
					.getEpProberTypeId());
			return type.getName() + "报警";

		} else {
			EpEventTypeExample example = new EpEventTypeExample();
			example.createCriteria().andCodeEqualTo(new BigDecimal(params[1]));
			List<EpEventType> list = epEventTypeDAO.selectByExample(example);
			if (list.size() < 1) {
				throw new BusinessException("eventNaming",
						ErrorCode.RESOURCE_NOT_FOUND);
			}
			return list.get(0).getName();
		}
	}

	public List<PlatformResources> listSharedAlarmDevice(int begin, int limit) {
		return platformResourcesDAO.listSharedAlarmDevice(begin, limit);
	}

	public int countSharedAlarmDevice() {
		return platformResourcesDAO.countSharedAlarmDevice().intValue();
	}

	public SipServer getSipServer() throws BusinessException {
		SipServerExample example = new SipServerExample();
		List<SipServer> list = sipServerDAO.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("No sip server register !",
					ErrorCode.RESOURCE_NOT_FOUND);
		}

		return list.get(0);
	}

	public void updateEpAlarmEvent(String naming, String note,
			String confirmTime) throws BusinessException {
		if (StringUtils.isBlank(naming)) {
			throw new BusinessException("naming", ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpAlarmEventExample eaeExample = new EpAlarmEventExample();
		EpAlarmEventExample.Criteria criteria = eaeExample.createCriteria();
		criteria.andNamingEqualTo(naming);
		List<EpAlarmEvent> list = epAlarmEventDAO.selectByExample(eaeExample);
		EpAlarmEvent event;
		if (list.size() == 0) {
			throw new BusinessException("naming",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		} else {
			event = list.get(0);
		}

		event.setNote(note);
		event.setConfirmTime(new BigDecimal(confirmTime));

		epAlarmEventDAO.updateEpAlarmEvent(event);

	}

	public List<EpAlarmEvent> listHistoryAlarmEvent(List<String> organIds,
			Long begin, Long end, int start, int limit)
			throws BusinessException {
		return epAlarmEventDAO.listAlarmEvent(organIds, begin, end, start,
				limit);
	}

	public Integer countHistoryAlarmEvent(List<String> organIds, Long begin,
			Long end) {
		return epAlarmEventDAO.countAlarmEvent(organIds, begin, end);
	}

	public List<EpAlarmEvent> listEpAlarmEventInDevices(List<String> sourceIds,
			List<String> types, Long beginTime, Long endTime, String level,
			int start, int length) {
		List<String> typeNames = new ArrayList<String>();
		if (types.get(0).equals("-1")) {
			typeNames = null;
		} else {
			for (String type : types) {
				EpEventTypeExample example = new EpEventTypeExample();
				example.createCriteria().andCodeEqualTo(new BigDecimal(type));
				List<EpEventType> names = epEventTypeDAO
						.selectByExample(example);
				if (names.size() < 1) {
					throw new BusinessException(
							"type[" + type + "] not found!",
							ErrorCode.ALARM_EVENT_TYPE_NOT_FOUND);
				}
				typeNames.add(names.get(0).getName());
			}
		}
		return epAlarmEventDAO.listEpAlarmEventInDevices(sourceIds, typeNames,
				beginTime, endTime, level, start, length);
	}

	public int countEpAlarmEventInDevices(List<String> sourceIds,
			List<String> types, Long beginTime, Long endTime, String level) {
		List<String> typeNames = new ArrayList<String>();
		if (types.get(0).equals("-1")) {
			typeNames = null;
		} else {
			for (String type : types) {
				EpEventTypeExample example = new EpEventTypeExample();
				example.createCriteria().andCodeEqualTo(new BigDecimal(type));
				List<EpEventType> names = epEventTypeDAO
						.selectByExample(example);
				if (names.size() < 1) {
					throw new BusinessException(
							"type[" + type + "] not found!",
							ErrorCode.ALARM_EVENT_TYPE_NOT_FOUND);
				}
				typeNames.add(names.get(0).getName());
			}
		}
		int rtn = epAlarmEventDAO.countEpAlarmEventInDevices(sourceIds,
				typeNames, beginTime, endTime, level);
		return rtn;
	}

	public String getDeviceTypeByEventNaming(String naming)
			throws BusinessException {
		if (StringUtils.isBlank(naming)) {
			throw new BusinessException("eventNaming",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] params = naming.split("_");
		if (params.length < 3) {
			throw new BusinessException("eventNaming",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		// 如果是采集服务器过来的报警
		if ("4096".equals(params[1])) {
			// EpProber prober = epProberDAO.selectByPrimaryKey(params[2]);
			// if (null == prober) {
			// throw new BusinessException(params[2] + " not found !",
			// ErrorCode.RESOURCE_NOT_FOUND);
			// }
			// return prober.getEpProberTypeId();
			return "3";
		}

		return "100";
	}

	public List<HistoryVideo> listHistoryVideoByEventId(String eventId)
			throws BusinessException {
		// 得到报警源ID
		EpAlarmEvent event = epAlarmEventDAO.selectByPrimaryKey(eventId);
		// 获取报警产生后触发的预案
		EpRSchemeAlarmSourceExample example = new EpRSchemeAlarmSourceExample();
		example.createCriteria().andSourceIdEqualTo(event.getSourceId())
				.andSourceTypeEqualTo(event.getSourceType());
		List<EpRSchemeAlarmSource> list = epRSchemeAlarmSourceDAO
				.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("no scheme found for eventId["
					+ eventId + "] !", ErrorCode.RESOURCE_NOT_FOUND);
		}
		String schemeId = list.get(0).getEpSchemeId();

		// 查询对应预案中的录像通知指令列表
		EpSchemeCommandExample commandExample = new EpSchemeCommandExample();
		commandExample.createCriteria().andEpSchemeIdEqualTo(schemeId)
				.andTargetTypeEqualTo(DeviceType.TARGET_TYPE_RECORD);
		List<EpSchemeCommand> commands = epSchemeCommandDAO
				.selectByExample(commandExample);

		// 返回列表
		List<HistoryVideo> historyVideos = new ArrayList<HistoryVideo>();
		// 根据eventNaming分解出报警类型
		String eventNaming = event.getNaming();
		String[] eventParam = eventNaming.split("_");
		if (eventParam.length < 3) {
			throw new BusinessException("event naming[" + eventNaming
					+ "] invalide !", ErrorCode.ALARM_EVENT_TYPE_NOT_FOUND);
		}
		String eventAlarmType = eventParam[1];

		// 依次根据指令所对应的摄像头，得到需要发出查询录像请求的报警存储列表
		// 需要发出查询请求的报警存储列表
		Set<String> alarmStorageServerSet = new HashSet<String>();
		for (EpSchemeCommand command : commands) {
			String vicId = command.getTargetId();
			VideoInputChannel vic = VideoInputChannelDAO
					.selectByPrimaryKey(vicId);
			if (StringUtils.isBlank(vic.getAlarmStorageServerId())) {
				continue;
			}
			alarmStorageServerSet.add(vic.getAlarmStorageServerId());
		}

		// 依次去各报警存储上获取录像列表
		for (String alarmStorageServerId : alarmStorageServerSet) {
			StorageServer ass = storageServerDAO
					.selectByPrimaryKey(alarmStorageServerId);
			String ip = ass.getIp();
			int port = 5606;
			int number = 16100;

			// 请求xml内容
			Document reqDoc = new Document();
			Element root = new Element("Action");
			Element query = new Element("Query");

			Element variable = new Element("Variable");
			variable.setText("FileList");
			query.addContent(variable);

			Element indexType = new Element("IndexType");
			indexType.setText("0");
			query.addContent(indexType);

			Element address = new Element("Address");
			address.setText("");
			query.addContent(address);

			Element alarmType = new Element("AlarmType");
			alarmType.setText("");
			query.addContent(alarmType);

			Element begin = new Element("BeginTime");
			begin.setText(sdf.format(new Date()));
			query.addContent(begin);

			Element end = new Element("EndTime");
			end.setText(sdf.format(new Date()));
			query.addContent(end);

			Element fromIndex = new Element("FromIndex");
			fromIndex.setText(0 + "");
			query.addContent(fromIndex);

			Element toIndex = new Element("ToIndex");
			toIndex.setText(100 + "");
			query.addContent(toIndex);

			Element eventIdElement = new Element("EventID");
			eventIdElement.setText(event.getNaming());
			query.addContent(eventIdElement);

			root.addContent(query);
			reqDoc.setRootElement(root);
			XMLOutputter out = new XMLOutputter("  ", true, "UTF-8");

			// 向存储发送请求
			try {
				String content = out.outputString(reqDoc);
				MegaSocketClient client = new MegaSocketClient(number, null,
						alarmStorageServerId, content, ip, port);
				SocketChannel channel = client.sendWithResponse();
				int sequence = client.getSeq();
				byte[] resp = client.parseResponse(channel, sequence);
				if (null == resp || resp.length < 10) {
					return null;
				}

				InputStream in = new ByteArrayInputStream(resp);
				// 解析xml数据放到到返回列表中
				SAXBuilder builder = new SAXBuilder();
				Document respDoc = builder.build(in);
				Element response = respDoc.getRootElement();
				String decoderTag = response.getChildText("DecoderTag");
				int realNum = Integer
						.parseInt(response.getChildText("RealNum"));
				// FromIndex必定等于请求中的FromIndex，因此不需要解析
				// int fi = Integer.parseInt(response
				// .getChildText("FromIndex"));
				int ti = Integer.parseInt(response.getChildText("ToIndex"));

				Element sublist = response.getChild("Sublist");
				List<Element> itemList = sublist.getChildren("Item");
				for (Element e : itemList) {
					String id = e.getChildText("Id");
					String fileName = e.getChildText("FileName");
					long videoBeginTime = sdf
							.parse(e.getChildText("BeginTime")).getTime();
					long videoEndTime = sdf.parse(e.getChildText("EndTime"))
							.getTime();
					long fileSize = Long.parseLong(e.getChildText("FileSize"));
					String playUrl = e.getChildText("FileUrl");

					HistoryVideo record = new HistoryVideo();
					record.setVicId(id);
					record.setType(eventAlarmType);
					record.setBeginTime(videoBeginTime);
					record.setDecoderTag(decoderTag);
					record.setEndTime(videoEndTime);
					record.setFileName(fileName);
					record.setFileSize(fileSize);
					record.setPlayUrl(playUrl);
					historyVideos.add(record);
				}
			} catch (JDOMParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return historyVideos;
	}

	public void confirmAlarm(String id) throws BusinessException {
		EpAlarmEvent event = epAlarmEventDAO.selectByPrimaryKey(id);
		event.setConfirmTime(new BigDecimal(System.currentTimeMillis()));
		epAlarmEventDAO.updateByPrimaryKeySelective(event);
	}
}
