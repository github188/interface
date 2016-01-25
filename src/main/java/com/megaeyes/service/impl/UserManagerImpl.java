/**   
 * @Title: UserLoginManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-2 下午1:44:16 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.megaeyes.persistence.ibatis.iface.UserSessionHistoryDAOImpl;
import com.megaeyes.persistence.ibatis.impl.AccessServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRUserRoleDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRoleDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.PlatformDAOIbatis;
import com.megaeyes.persistence.ibatis.impl.PlatformResourcesDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.RUserAccontrolDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.UserDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.UserSessionDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpRUserRole;
import com.megaeyes.persistence.ibatis.model.EpRUserRoleExample;
import com.megaeyes.persistence.ibatis.model.EpRole;
import com.megaeyes.persistence.ibatis.model.EpRoleExample;
import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.model.Platform;
import com.megaeyes.persistence.ibatis.model.PlatformExample;
import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.RUserAccontrolExample;
import com.megaeyes.persistence.ibatis.model.TUser;
import com.megaeyes.persistence.ibatis.model.TUserExample;
import com.megaeyes.persistence.ibatis.model.TUserExample.Criteria;
import com.megaeyes.persistence.ibatis.model.UserSession;
import com.megaeyes.persistence.ibatis.model.UserSessionExample;
import com.megaeyes.persistence.ibatis.model.UserSessionHistory;
import com.megaeyes.persistence.ibatis.queryParameter.UserSessionParameter;
import com.megaeyes.persistence.ibatis.vo.ListUserSessionAndUserVO;
import com.megaeyes.persistence.ibatis.vo.TUserVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.UserManager;

/**
 * @ClassName: UserLoginManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-2 下午1:44:16
 * 
 */
@Controller
public class UserManagerImpl extends BaseManagerImpl implements UserManager {
	@Autowired
	UserDAOiBatis userDAO;
	@Autowired
	PlatformDAOIbatis platformDAO;
	@Autowired
	OrganDAOiBatis organDAO;
	@Autowired
	EpRoleDAOiBatis epRoleDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	AccessServerDAOiBatis accessServerDAO;
	@Autowired
	PlatformResourcesDAOiBatis platformResourcesDAO;
	@Autowired
	UserSessionHistoryDAOImpl userSessionHistoryDAO;
	@Autowired
	EpRUserRoleDAOiBatis epRUserRoleDAO;
	@Autowired
	RUserAccontrolDAOiBatis rUserAccontrolDAO;
	@Autowired
	UserSessionDAOiBatis userSessionDAO;

	public UserSessionVO logon(String loginName, String password, String ip) {
		// 查询登陆的用户
		if (StringUtils.isBlank(loginName)) {
			throw new BusinessException("loginName",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(password)) {
			throw new BusinessException("password",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		TUserExample example = new TUserExample();

		Criteria criteria = example.createCriteria();
		criteria.andLogonNameEqualTo(loginName);
		// 检查登录名
		List users = userDAO.selectByExample(example);
		if (users.size() < 1) {
			throw new BusinessException("", ErrorCode.USER_NOT_FOUND);
		}
		// 检查密码
		criteria.andPasswordEqualTo(password);
		users = userDAO.selectByExample(example);
		if (users.size() < 1) {
			throw new BusinessException("", ErrorCode.AUTHORISE_FAILD);
		}
		
		TUser user = (TUser) users.get(0);
		int sessionMaxAmout = user.getSessionMaxAmount().intValue();

		// 检查平台状态是否为可登录状态
		/*
		 * PlatformExample pExample = new PlatformExample(); List<Platform> list
		 * = platformDAO.selectByExample(pExample); Platform record =
		 * list.get(0); if (!StringUtils.isBlank(record.getVerify()) ||
		 * !"0".equals(record.getVerify())) { // 除megaeyes用户和领导外的其他任何用户都不能登录 if
		 * ((!"megaeyes".equals(loginName)) && (user.getGrade() < 9)) { throw
		 * new BusinessException("password", ErrorCode.USER_ACCOUNT_ERROR); } }
		 */

		// 查询User
		// Session，如果大于sessionMaxAmout，logoff除开最近sessions.size()-sessionMaxAmout个session的其余session
		UserSessionExample use = new UserSessionExample();
		UserSessionExample.Criteria usc = use.createCriteria();
		usc.andUserIdEqualTo(user.getId());
		use.setOrderByClause("id desc");
		List sessions = userSessionDAO.selectByExample(use);
		if (sessions.size() >= sessionMaxAmout) {
			for (int i = sessions.size(); i >= sessionMaxAmout; i--) {
				try {
					logoff(((UserSession) sessions.get(i - 1)).getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// 生成新的session
		String id = userSessionDAO.getUserSessionSeq();
		UserSession us = new UserSession();
		us.setId(id);
		us.setLogonTime(new BigDecimal(System.currentTimeMillis()));
		us.setHeartbeatTime(new BigDecimal(System.currentTimeMillis()));
		us.setOptimisticLock(new BigDecimal(0));
		us.setIp(ip);
		us.setUserId(user.getId());
		us.setClientType(UserManager.USER_CLIENT);
		userSessionDAO.insert(us);

		UserSessionVO rtn = new UserSessionVO();
		rtn.setId(id);
		rtn.setIp(ip);
		rtn.setUserId(user.getId());
		rtn.setOrganId(user.getOrganId());
		rtn.setUserName(user.getLogonName());
		rtn.setIsAdmin(user.getUserAccount());
		rtn.setNaming(user.getNaming());
		rtn.setPriority(user.getPriority());
		rtn.setOrganName(organDAO.selectByPrimaryKey(user.getOrganId())
				.getName());
		rtn.setBranchId(user.getBranchId() == null ? "" : user.getBranchId());
		rtn.setIsBranchAdmin(user.getIsBranchManage() == null ? "" : user
				.getIsBranchManage().toString());
		rtn.setIsInnerUser(user.getIsInnerUser());
		return rtn;
	}

	public String getPlatformStatus() {
		PlatformExample example = new PlatformExample();
		List<Platform> list = platformDAO.selectByExample(example);
		return StringUtils.isBlank(list.get(0).getVerify()) ? "0" : list.get(0)
				.getVerify();
	}

	public String createUser(String logonName, String password, String organId,
			String accessServerId, String note, String name, String sex,
			Long age, String mobile, String phone, String email,
			Short isSuspend, Long maxSession, String userAccount,
			Short priority, String sipCode, String dispatchServerId, Short isInnerUser)
			throws BusinessException {
		if (StringUtils.isNotBlank(logonName)) {
			TUserExample userExample = new TUserExample();
			TUserExample.Criteria criteria = userExample.createCriteria();
			criteria.andLogonNameEqualTo(logonName);
			int count = userDAO.countByExample(userExample);
			if (count > 0) {
				throw new BusinessException("logonName", ErrorCode.NAME_EXIST);
			}
		}
		if (StringUtils.isBlank(logonName)) {
			throw new BusinessException("logonName",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
//		if (StringUtils.isBlank(sipCode)) {
//			throw new BusinessException("sipCode",
//					ErrorCode.PARAMETER_NOT_FOUND);
//		}
		if (StringUtils.isBlank(password)) {
			throw new BusinessException("password",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		TUser user = new TUser();
		String id = sequenceDAO.getTUserSeq();
		user.setId(id);
		user.setOptimisticLock(BigDecimal.valueOf(0));
		user.setLogonName(logonName);
		user.setPassword(password);
		user.setOrganId(organId);
		user.setAge(age);
		user.setNote(note);
		user.setName(name);
		user.setSex(sex);
		user.setMobile(mobile);
		user.setPhone(phone);
		user.setEmail(email);
		EpRoleExample example = new EpRoleExample();
		EpRoleExample.Criteria criteria = example.createCriteria();
		criteria.andOrganIdEqualTo(organId);
		String roleId;
		if (userAccount.equals("0")) {
			user.setUserAccount("0");
			criteria.andNameEqualTo("普通用户");
			List<EpRole> list = epRoleDAO.selectByExample(example);
			roleId = list.get(0).getId();
		} else {
			user.setUserAccount(userAccount);
			criteria.andNameEqualTo("管理员");
			List<EpRole> list = epRoleDAO.selectByExample(example);
			roleId = list.get(0).getId();
		}
		EpRUserRole epRUserRole = new EpRUserRole();
		epRUserRole.setRoleId(roleId);
		epRUserRole.setUserId(id);
		String epRUserRoleId = sequenceDAO.getTUserSeq();
		epRUserRole.setId(epRUserRoleId);
		epRUserRoleDAO.insert(epRUserRole);
		user.setPriority(priority);
		user.setCreatetime(BigDecimal.valueOf(new Date().getTime()));// 当前时间
		user.setBindSoftdog(Short.valueOf("0"));// 默认
		user.setMonitorRole(BigDecimal.valueOf(0));// 默认
		user.setPermissionChange(BigDecimal.valueOf(1));// 默认
		user.setIsPhoneNotify(Short.valueOf("0"));// 默认
		user.setIsEmailNotify(Short.valueOf("0"));// 默认
		user.setIsAudioNotify(Short.valueOf("0"));// 默认
		user.setIsMsp(Short.valueOf("0"));// 默认
		user.setDispatchServerId(dispatchServerId);
		user.setAccessServerId(accessServerId);
		user.setIsSuspended(isSuspend);
		user.setSessionMaxAmount(maxSession);
		String naming = "";
		if (StringUtils.isBlank(accessServerId)) {
			throw new BusinessException("accessServerId",
					ErrorCode.PARAMETER_NOT_FOUND);
		} else {
			String accessServerIP = accessServerDAO.selectByPrimaryKey(
					accessServerId).getIp();
			naming = user.getId() + ":" + accessServerIP + ":" + "010001";
			user.setNaming(naming);
		}
		
		user.setIsInnerUser(isInnerUser);
		userDAO.insert(user);

		saveOrUpdatePlatformResources(id, logonName, naming, organId, sipCode,
				null, null, "user", null);
		return id;
	}

	private void saveOrUpdatePlatformResources(String resourceId, String name,
			String naming, String organId, String sipCode, String longitude,
			String latitude, String type, Short isShare)
			throws BusinessException {

		PlatformResources record = platformResourcesDAO.getByResourceId(
				resourceId, type);
		if (null == record) {
			if (StringUtils.isNotBlank(sipCode)) {
				// 检查sipCode是否重复
				PlatformResources pr = platformResourcesDAO
						.getBySipCode(sipCode);
				if (pr != null) {
					 throw new BusinessException("sipCode",
					 ErrorCode.SIP_CODE_EXIST);
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
			// 检查sipCode是否重复
			if (!sipCode.equals(record.getSipCode())) {
				PlatformResources pr = platformResourcesDAO
						.getBySipCode(sipCode);
				if (pr != null) {
					throw new BusinessException("sipCode",
							 ErrorCode.SIP_CODE_EXIST);
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

	public void deleteUser(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String str_array[] = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			try {
				// userSessionDAO.deleteByPrimaryKey(str_array[i]);
				// 删除用户时先删除用户和门关联表
				RUserAccontrolExample ruaExample = new RUserAccontrolExample();
				RUserAccontrolExample.Criteria criteria1 = ruaExample
						.createCriteria();
				criteria1.andUserIdEqualTo(str_array[i]);
				rUserAccontrolDAO.deleteByExample(ruaExample);
				// 删除用户时先删除用户和角色的关系表记录
				EpRUserRoleExample erurExample = new EpRUserRoleExample();
				EpRUserRoleExample.Criteria criteria = erurExample
						.createCriteria();
				criteria.andUserIdEqualTo(str_array[i]);
				epRUserRoleDAO.deleteByExample(erurExample);
				// 删除用户时删除USER_SESSION表记录
				UserSessionExample usExample = new UserSessionExample();
				UserSessionExample.Criteria criteria2 = usExample
						.createCriteria();
				criteria2.andUserIdEqualTo(str_array[i]);
				userSessionDAO.deleteByExample(usExample);

				userDAO.deleteByPrimaryKey(str_array[i]);
			} catch (Exception e) {
				throw new BusinessException("resourceBeUsed",
						ErrorCode.RESOURCE_BE_USED);
			}
		}
		// TODO: 老中心， 删除相应的权限 未实现。
		// TODO: 老中心，修改跟此用户关联的老预案未实现。
	}

	public void updateUser(String id, String logonName, String password,
			String accessServerId, String note, String name, String naming,
			String sex, Long age, String mobile, String phone, String email,
			Long maxSession, String userAccount, Short priority,
			String sipCode, String dispatchServerId, Short isInnerUser) throws BusinessException {

		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}

		if (StringUtils.isNotBlank(logonName)) {

			TUserExample userExample = new TUserExample();
			TUserExample.Criteria criteria = userExample.createCriteria();
			criteria.andLogonNameEqualTo(logonName);
			List<TUser> list = userDAO.selectByExample(userExample);
			if (list.size() > 0) {
				if (!id.equals(list.get(0).getId())) {
					if (logonName.equals(list.get(0).getLogonName())) {
						throw new BusinessException("logonName",
								ErrorCode.DEVICE_NUMBER_DUPLICATE);
					}
				}
			}
		}
		if (StringUtils.isBlank(logonName)) {
			throw new BusinessException("logonName",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (maxSession == null || maxSession.equals("")) {
			throw new BusinessException("maxSession",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(password)) {
			throw new BusinessException("password",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		TUser user = new TUser();
		user.setId(id);
		user.setLogonName(logonName);
		user.setPassword(password);
		if (age != null && !age.equals("")) {
			user.setAge(age);
		}
		user.setNote(note);
		user.setName(name);
		user.setSex(sex);
		user.setMobile(mobile);
		user.setPhone(phone);
		user.setEmail(email);
		user.setUserAccount(userAccount);
		user.setPriority(priority);
		user.setDispatchServerId(StringUtils.isBlank(dispatchServerId) ? ""
				: dispatchServerId);
		user.setSessionMaxAmount(maxSession);
		user.setAccessServerId(accessServerId);
		user.setNaming(naming);
		if (StringUtils.isNotBlank(accessServerId)) {
			String accessServerIP = accessServerDAO.selectByPrimaryKey(
					accessServerId).getIp();
			naming = user.getId() + ":" + accessServerIP + ":" + "010001";
			user.setNaming(naming);
		}
		user.setIsInnerUser(isInnerUser);
		userDAO.updateByPrimaryKeySelective(user);

		// 修改platform_resource对应记录
		TUser u = userDAO.selectByPrimaryKey(id);
		System.out.println(id + ":" + logonName + ":" + naming + ":"
				+ u.getOrganId() + ":" + sipCode);
		saveOrUpdatePlatformResources(id, logonName, naming, u.getOrganId(),
				sipCode, null, null, "user", null);

	}

	public List<TUser> listUser() throws BusinessException {

		return userDAO.listUser();
	}

	public List<TUserVO> listUserByOrganId(String organId) {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organid",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return userDAO.getUsersByOrganId(organId);
	}

	public void logoff(String sessionId) {
		// 查询指定的会话
		UserSession userSession = userSessionDAO.selectByPrimaryKey(sessionId);
		if (null == userSession) {
			throw new BusinessException("userSession",
					ErrorCode.USER_SESSION_NOT_FOUND);
		}
		// 像会话历史中插入将要被注销的会话
		UserSessionHistory ush = new UserSessionHistory();
		String ushId = userSessionDAO.getUserSessionHistorySeq();
		ush.setId(ushId);
		ush.setLogoffTime(new BigDecimal(System.currentTimeMillis()));
		ush.setLogonTime(userSession.getLogonTime());
		ush.setOptimisticLock(new BigDecimal(0));
		ush.setUserId(userSession.getUserId());
		ush.setUserSessionId(sessionId);
		userSessionHistoryDAO.insert(ush);
		// 删除会话
		userSessionDAO.deleteByPrimaryKey(sessionId);
	}

	public List<UserSessionVO> listUserSession(UserSessionParameter parm)
			throws BusinessException {
		return userSessionDAO.listUserSession(parm);
	}

	public UserSessionVO getSessionById(String sessionId)
			throws BusinessException {
		UserSessionVO vo = userSessionDAO.getUserSessionById(sessionId);
		if (null == vo) {
			throw new BusinessException("user session: " + sessionId
					+ " not found !", ErrorCode.USER_SESSION_NOT_FOUND);
		}
		Organ organ = organDAO.selectByPrimaryKey(vo.getOrganId());
		vo.setOrganName(organ.getName());
		return vo;
	}

	public List<TUser> getAllChildUsersByOrganId(String organId) {
		return userDAO.getAllChildUsersByOrganId(organId);
	}

	public Integer countAllUser() {
		TUserExample userExample = new TUserExample();
		// TUserExample.Criteria criteria = userExample.createCriteria();
		return userDAO.countByExample(userExample);
	}

	public List<ListUserSessionAndUserVO> listUserSessionAndUserLogName() {

		return userDAO.listUserSessionAndUserLogName();
	}

	public void checkSession() {
		UserSessionExample example = new UserSessionExample();
		List<UserSession> list = userSessionDAO.selectByExample(example);
		for (UserSession us : list) {
			// 判断是否过期
			if (us.getHeartbeatTime().longValue() + USER_SESSION_EXPIRE_TIME < System
					.currentTimeMillis()) {
				try {
					logoff(us.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void updatePassword(String userId, String password) {
		if(StringUtils.isBlank(userId)){
			throw new BusinessException("userId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		TUser user = userDAO.selectByPrimaryKey(userId);
		user.setPassword(password);
		userDAO.updateByPrimaryKeySelective(user);
		
	}
	
	/**
	 * 
	 * @Description:查询用户是否具有云台控制权限
	 * @author zhuanqi@megaeyes.com
	 * @param @param userId
	 * @param @return 
	 * @return boolean 
	 * @throws
	 */
	public boolean checkUserPermissionByUserId(String userId,String operationNumber){
		int rows = epRUserRoleDAO.checkUserPermissionByUserId(userId,operationNumber);
		if(rows > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public String getAccessServerIp1(String ip){
		return accessServerDAO.getAccessServerIp1(ip);
	}
	
	public String getGisServerUrl (){
		PlatformExample example = new PlatformExample();
		example.createCriteria().andNameEqualTo("GISSERVER");
		List<Platform> list = platformDAO.selectByExample(example);
		if(list.size() > 0){
			return list.get(0).getUserNotifyServerUrl();
		}else{
			return null;
		}
	}
}
