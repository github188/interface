/**   
 * @Title: OrganController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-13 下午5:30:01 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.EpRole;
import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.persistence.ibatis.queryParameter.VisParameter;
import com.megaeyes.persistence.ibatis.vo.EpProberVO;
import com.megaeyes.persistence.ibatis.vo.ListDeviceByRoleId;
import com.megaeyes.persistence.ibatis.vo.OrganVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcAccessServersManager;
import com.megaeyes.service.iface.EpProberManager;
import com.megaeyes.service.iface.OrganManager;
import com.megaeyes.service.iface.RoleManager;
import com.megaeyes.service.iface.VISManager;
import com.megaeyes.service.iface.VOCManager;
import com.megaeyes.service.utils.DeviceType;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.GetOrganByIdResponse;
import com.megaeyes.web.response.GetOrganDeviceResponse;
import com.megaeyes.web.response.ListOrganResponse;
import com.megaeyes.web.response.ListOrganVOResponse;
import com.megaeyes.web.response.organdevicetree.AicNode;
import com.megaeyes.web.response.organdevicetree.AocNode;
import com.megaeyes.web.response.organdevicetree.DoorNode;
import com.megaeyes.web.response.organdevicetree.OrganNode;
import com.megaeyes.web.response.organdevicetree.ProberNode;
import com.megaeyes.web.response.organdevicetree.VicNode;
import com.megaeyes.web.response.organdevicetree.VocNode;

/**
 * @ClassName: OrganController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-13 下午5:30:01
 * 
 */
@Controller
public class OrganController extends BaseController {
	@Autowired
	OrganManager organManager;
	@Autowired
	VISManager visManager;
	@Autowired
	EpProberManager epProberManager;
	@Autowired
	RoleManager roleManager;
	@Autowired
	VOCManager vocManager;
	@Autowired
	private AcAccessServersManager acAccessServersManager;

	@ControllerDescription(description = "创建机构", isLog = true, isCheckSession = true)
	@RequestMapping("/createOrgan.json")
	public void createOrgan(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String parentOrganId = (String) request.getAttribute("parentOrganId");
		String name = (String) request.getAttribute("name");

		String linkMan = (String) request.getAttribute("linkMan");

		String phone = (String) request.getAttribute("phone");

		String email = (String) request.getAttribute("email");

		String fax = (String) request.getAttribute("fax");

		String address = (String) request.getAttribute("address");

		String postalCode = (String) request.getAttribute("postalCode");

		/*
		 * String number = (String) request.getAttribute("number"); if
		 * (StringUtils.isBlank(number)) { number = StdIdGenerator.getStdId(); }
		 */
		String suspend = (String) request.getAttribute("isSuspended");
		Integer isSuspended = new Integer(0);
		if (!StringUtils.isBlank(suspend)) {
			try {
				isSuspended = new Integer(Integer.parseInt(suspend));
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage("isSuspended");
			}
		}

		String msp = (String) request.getAttribute("isMSP");
		Integer isMSP = new Integer(0);
		if (!StringUtils.isBlank(msp)) {
			try {
				isMSP = new Integer(Integer.parseInt(msp));
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage("isMSP");
			}
		}

		String note = (String) request.getAttribute("note");

		String sipCode = (String) request.getAttribute("sipCode");

		String longitude = (String) request.getAttribute("longitude");

		String latitude = (String) request.getAttribute("latitude");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = organManager.createOrgan(parentOrganId, name,
						linkMan, phone, email, fax, address, postalCode,
						isSuspended, isMSP, note, sipCode, longitude, latitude);
				// 创建机构是系统自动创建两个角色：管理员，普通用户
				roleManager.createRole("管理员", note, id, new BigDecimal(
						isSuspended), "系统创建", new BigDecimal(1));
				roleManager.createRole("普通用户", note, id, new BigDecimal(
						isSuspended), "系统创建", new BigDecimal(1));
				resp.setMessage(id);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除机构", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteOrgan.json")
	public void deleteOrganServer(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = "Na";
		try {
			// 获取机构名称
			OrganVO organ = organManager.getOrganById(id);
			name = organ.getName();
			// 判断机构下面是否存在设备
			VisParameter param = new VisParameter();
			param.setOrganId(id);
			if (visManager.getVISByOrganIdCount(param) < 1) {
				organManager.deleteOrgan(id);
			} else {
				resp.setCode(ErrorCode.HAVE_DEVICE_IN_USE);
			}

			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询机构", isLog = false, isCheckSession = true)
	@RequestMapping("/listOrganChildren.json")
	public void ListOrganAllChildren(HttpServletRequest request,
			HttpServletResponse response) {
		ListOrganResponse resp = new ListOrganResponse();
		resp.setCode(ErrorCode.SUCCESS);
		JSONObject json = null;
		String jsonString = (String) request.getAttribute("jsonString");
		if (jsonString != null && jsonString.length() != 0)
			json = JSONObject.fromObject(jsonString);
		// 取参数
		String organId = (String) request.getAttribute("organId");
		if (StringUtils.isBlank(organId)) {
			try {
				if (json != null)
					organId = json.getString("organId");
			} catch (Exception ex) {

			}
		}
		if (StringUtils.isBlank(organId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND + "");
			resp.setMessage("organId");
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				List<Organ> children = null;
				try {
					int i_start = 0;
					int i_end = 99999999;
					i_start = Integer.parseInt(json.getString("start"));
					i_end = i_start + Integer.parseInt(json.getString("limit"));
					Map map = new HashMap();
					map.put("organId", organId);
					map.put("start", i_start);
					map.put("end", i_end);
					children = organManager.listOrganByOrganIdNextLevel(map);
					resp.setNumber(organManager
							.countListOrganByOrganIdNextLevel(map));
				} catch (Exception ex) {
					children = organManager
							.listAllSameLevelAndChildrenOrgans(organId);
				}
				resp.setOrgans(children);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新机构", isLog = false, isCheckSession = true)
	@RequestMapping("/updateOrgan.json")
	public void updateOrgan(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		// 取参数
		String id = (String) request.getAttribute("organId");
		String name = (String) request.getAttribute("name");
		String linkMan = (String) request.getAttribute("linkMan");
		String phone = (String) request.getAttribute("phone");
		String email = (String) request.getAttribute("email");
		String fax = (String) request.getAttribute("fax");
		String number = (String) request.getAttribute("number");
		String address = (String) request.getAttribute("address");
		String postalCode = (String) request.getAttribute("postalCode");
		String note = (String) request.getAttribute("note");
		String suspend = (String) request.getAttribute("isSuspended");
		Integer isSuspended = new Integer(0);
		if (!StringUtils.isBlank(suspend)) {
			try {
				isSuspended = new Integer(Integer.parseInt(suspend));
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage("isSuspended");
			}
		}
		String msp = (String) request.getAttribute("isMSP");
		Integer isMSP = new Integer(0);
		if (!StringUtils.isBlank(msp)) {
			try {
				isMSP = new Integer(Integer.parseInt(msp));
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage("isSuspended");
			}
		}
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				organManager.updateOrgan(id, name, number, linkMan, phone,
						email, fax, address, postalCode,
						isSuspended.shortValue(), isMSP.shortValue(), note,
						sipCode, longitude, latitude);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "查询机构", isLog = false, isCheckSession = true)
	@RequestMapping("/getOrganById.json")
	public void GetOrganById(HttpServletRequest request,
			HttpServletResponse response) {
		GetOrganByIdResponse resp = new GetOrganByIdResponse();
		// 取参数
		String organId = (String) request.getAttribute("organId");
		try {
			OrganVO organ = organManager.getOrganById(organId);
			resp.setOrgan(organ);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		// 返回
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "查询机构下所有子机构", isLog = false, isCheckSession = true)
	@RequestMapping("/getallChildById.json")
	public void listAllChildren(HttpServletRequest request,
			HttpServletResponse response) {
		ListOrganVOResponse resp = new ListOrganVOResponse();
		String id = (String) request.getAttribute("id");
		String isRootstr = (String) request.getAttribute("isRoot");
		boolean isRoot = Boolean.valueOf(isRootstr);
		// System.out.println("++++++++++++++++++=="+isRoot);
		try {
			List list = organManager.listOrganById(id);
			resp.setOrgans(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		// 返回
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "获取机构设备树", isLog = false, isCheckSession = true)
	@RequestMapping("/getOrganDevice.json")
	public void GetOrganDevice(HttpServletRequest request,
			HttpServletResponse response) {
		String organId = (String) request.getAttribute("organId");
		String sessionId = request.getParameter("sessionId");
		GetOrganDeviceResponse resp = new GetOrganDeviceResponse();
		try {
			// 获取所有的子机构
			List<Organ> organs = new ArrayList();
			organs = organManager.listAllChildren(organId, true);

			// 获取用户信息
			UserSessionVO user = userManager.getSessionById(sessionId);
			// 获取用户角色信息
			List<EpRole> roles = roleManager.listRoleByUserId(user.getUserId());
			// 获取角色列表资源信息，目前只有摄像头
			Set<String> authVics = new HashSet<String>();
			for (EpRole role : roles) {
				// 只考虑非系统创建的角色
				if (role.getType().intValue() == 1) {
					continue;
				}
				// 非系统创建的角色，获取角色资源
				List<ListDeviceByRoleId> devices = roleManager.ListDeviceByRoleId(role.getId());
				// ID添加到authVics里面
				for (ListDeviceByRoleId device : devices) {
					// 摄像头的加入
					if (device.getResourceType().equals(DeviceType.DEVICE_TYPE_VIC)) {
						authVics.add(device.getResourceId());
					}
				}
			}

			List<OrganNode> nodes = new ArrayList();
			OrganNode root = new OrganNode();
			// 取摄像头
			List<VideoInputChannel> vics = visManager.listVicByOrganId(organId,
					false);

			List rootVics = new ArrayList();
			for (VideoInputChannel vic : vics) {
				if (organId.equals(vic.getOrganId())) {
					// 判断是否被角色权限过滤
					if (!authVics.isEmpty() && !authVics.contains(vic.getId())) {
						continue;
					}
					VicNode vicNode = new VicNode();
					vicNode.setId(vic.getId());
					vicNode.setName(vic.getName());
					vicNode.setNaming(vic.getNaming());
					vicNode.setIsSupportScheme(vic.getIsSupportScheme()
							.toString());
					vicNode.setInstallLocation(vic.getInstallLocation());
					rootVics.add(vicNode);
				}
			}
			// 取报警输入
			List<AlarmInputChannel> aics = visManager
					.listAlarmInPutByOrganId(organId);
			List rootAics = new ArrayList();
			for (AlarmInputChannel aic : aics) {
				if (organId.equals(aic.getOrganId())) {
					AicNode aicNode = new AicNode();
					aicNode.setId(aic.getId());
					aicNode.setName(aic.getName());
					aicNode.setNaming(aic.getNaming());
					aicNode.setIsSupportScheme(aic.getIsSupportScheme()
							.toString());
					aicNode.setInstallLocation(aic.getInstallLocation());
					rootAics.add(aicNode);
				}
			}
			// 取报警输出
			List<AlarmOutputChannel> aocs = visManager
					.listAlarmOutPutByOrganId(organId);

			List rootAocs = new ArrayList();
			for (AlarmOutputChannel aoc : aocs) {
				if (organId.equals(aoc.getOrganId())) {
					AocNode aocNode = new AocNode();
					aocNode.setId(aoc.getId());
					aocNode.setName(aoc.getName());
					aocNode.setNaming(aoc.getNaming());
					aocNode.setIsSupportScheme(aoc.getIsSupportScheme()
							.toString());
					aocNode.setInstallLocation(aoc.getInstallLocation());
					rootAocs.add(aocNode);
				}
			}
			// 取探测器
			List<EpProberVO> proberVOs = epProberManager
					.listProberByOrganId(organId);
			List rootProbers = new ArrayList();
			for (EpProberVO proberVO : proberVOs) {
				if (organId.equals(proberVO.getOrganId())) {
					ProberNode proberNode = new ProberNode();
					proberNode.setId(proberVO.getId());
					proberNode.setName(proberVO.getName());
					proberNode.setGantherServerId(proberVO.getGatherServerId());
					proberNode.setType(proberVO.getType());
					proberNode.setTypeId(proberVO.getTypeId());
					proberNode.setGantherServerIp(proberVO.getGatherServerIp());
					proberNode.setDeviceId(proberVO.getDeviceId());
					rootProbers.add(proberNode);
				}
			}
			// 取视频输出通道
			List<VideoOutputChannel> vocs = vocManager
					.listVOCByOrganIdWithChild(organId);
			List rootVocs = new ArrayList();
			for (VideoOutputChannel voc : vocs) {
				if (organId.equals(voc.getOrganId())) {
					VocNode vocNode = new VocNode();
					vocNode.setId(voc.getId());
					vocNode.setName(voc.getName());
					vocNode.setOrganId(voc.getOrganId());
					vocNode.setNaming(voc.getNaming());
					rootVocs.add(vocNode);
				}
			}
			// 门(门禁控制器)列表
			List<AcAccessControls> doors = acAccessServersManager.listDoorByOrganId(organId);
			List<DoorNode> rootDoors = new ArrayList<DoorNode>();
			for (AcAccessControls door : doors) {
				if (organId.equals(door.getOrganId())) {
					DoorNode doorNode = new DoorNode();
					doorNode.setId(door.getId());
					doorNode.setName(door.getName());
					doorNode.setAccessServerId(door.getAccessServerId());
					doorNode.setChannelId(door.getChannelId().toString());
					doorNode.setInstallLocation(door.getInstallLocation());
					doorNode.setNaming(door.getNaming());
					rootDoors.add(doorNode);
				}
			}

			for (Organ organ : organs) {
				if (organId.equals(organ.getId())) {
					root.setId(organ.getId());
					root.setName(organ.getName());
					root.setParentId(organ.getParentOrganId());
				}
				OrganNode node = new OrganNode();
				List<VicNode> vicNodes = new ArrayList();
				for (VideoInputChannel vic : vics) {
					if (vic.getOrganId().equals(organ.getId())) {
						// 判断是否被角色权限过滤
						if (!authVics.isEmpty() && !authVics.contains(vic.getId())) {
							continue;
						}
						VicNode vicNode = new VicNode();
						vicNode.setId(vic.getId());
						vicNode.setName(vic.getName());
						vicNode.setNaming(vic.getNaming());
						vicNode.setIsSupportScheme(vic.getIsSupportScheme()
								.toString());
						vicNode.setInstallLocation(vic.getInstallLocation());
						vicNodes.add(vicNode);
					}
				}
				node.setVics(vicNodes);

				List<AicNode> aicNodes = new ArrayList();
				for (AlarmInputChannel aic : aics) {
					if (aic.getOrganId().equals(organ.getId())) {
						AicNode aicNode = new AicNode();
						aicNode.setId(aic.getId());
						aicNode.setName(aic.getName());
						aicNode.setNaming(aic.getNaming());
						aicNode.setIsSupportScheme(aic.getIsSupportScheme()
								.toString());
						aicNode.setInstallLocation(aic.getInstallLocation());
						aicNodes.add(aicNode);
					}
				}
				node.setAics(aicNodes);

				List<AocNode> aocNodes = new ArrayList();
				for (AlarmOutputChannel aoc : aocs) {
					if (aoc.getOrganId().equals(organ.getId())) {
						AocNode aocNode = new AocNode();
						aocNode.setId(aoc.getId());
						aocNode.setName(aoc.getName());
						aocNode.setNaming(aoc.getNaming());
						aocNode.setIsSupportScheme(aoc.getIsSupportScheme()
								.toString());
						aocNode.setInstallLocation(aoc.getInstallLocation());
						aocNodes.add(aocNode);
					}
				}
				node.setAocs(aocNodes);

				List<ProberNode> proberNodes = new ArrayList();
				for (EpProberVO proberVO : proberVOs) {
					if (proberVO.getOrganId().equals(organ.getId())) {
						ProberNode proberNode = new ProberNode();
						proberNode.setId(proberVO.getId());
						proberNode.setName(proberVO.getName());
						proberNode.setGantherServerId(proberVO
								.getGatherServerId());
						proberNode.setGantherServerIp(proberVO
								.getGatherServerIp());
						proberNode.setType(proberVO.getType());
						proberNode.setTypeId(proberVO.getTypeId());
						proberNodes.add(proberNode);
					}
				}
				node.setProbers(proberNodes);

				List<VocNode> vocNodes = new ArrayList();
				for (VideoOutputChannel voc : vocs) {
					if (voc.getOrganId().equals(organ.getId())) {
						VocNode vocNode = new VocNode();
						vocNode.setId(voc.getId());
						vocNode.setName(voc.getName());
						vocNode.setNaming(voc.getNaming());
						vocNode.setOrganId(voc.getOrganId());
						vocNodes.add(vocNode);
					}
				}
				node.setVocs(vocNodes);

				node.setId(organ.getId());
				node.setName(organ.getName());
				node.setParentId(organ.getParentOrganId());
				nodes.add(node);

			}
			root.setVics(rootVics);
			root.setAics(rootAics);
			root.setAocs(rootAocs);
			root.setProbers(rootProbers);
			root.setVocs(rootVocs);
			root.setDoors(rootDoors);
			OrganNode tree = new OrganNode();
			tree = OrganNode.generateTree(nodes, root);

			resp.setRoot(tree);
		} catch (BusinessException e) {
			e.printStackTrace();
			resp.setCode(e.getCode());
			resp.setMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode(ErrorCode.ERROR);
			resp.setMessage(e.getMessage());
		}
		writePage(response, resp);
	}

}
