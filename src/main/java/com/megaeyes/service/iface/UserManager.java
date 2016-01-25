/**   
 * @Title: UserManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-2-20 上午10:09:56 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.TUser;
import com.megaeyes.persistence.ibatis.queryParameter.UserSessionParameter;
import com.megaeyes.persistence.ibatis.vo.ListUserSessionAndUserVO;
import com.megaeyes.persistence.ibatis.vo.TUserVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: UserManager
 * @Description: 用户管理类接口
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-2-20 上午10:09:56
 * 
 */
public interface UserManager extends BaseManager {
	public static final String USER_CLIENT = "0";
	/**
	 * 用户会话过期时间
	 */
	public static final long USER_SESSION_EXPIRE_TIME = 360000L;
	/**
	 * 用户心跳验证时间间隔
	 */
	public static final long USER_HEARTBEAT_TIME = 60000L;

	/**
	 * @Title: logon
	 * @Description: TODO(用户登录返回UserSessionVO对象)
	 * @param @param loginName
	 * @param @param password
	 * @param @param ip
	 * @param @return 设定文件
	 * @return UserSessionVO 返回类型
	 * @throws
	 */
	public UserSessionVO logon(String loginName, String password, String ip);

	/**
	 * @Title: getPlatformStatus
	 * @Description: TODO(获取当前平台状态)
	 * @param @return 设定文件
	 * @return String 平台状态: "0"为可登录状态, "1"不可登录状态
	 * @throws
	 */
	public String getPlatformStatus();

	/**
	 * @Title: createUser
	 * @Description: 创建用户
	 * @param logonName
	 *            登录名
	 * @param password
	 *            密码
	 * @param organId
	 *            机构ID
	 * @param accessServerId
	 *            接入服务器ID
	 * @param note
	 *            备注
	 * @param name
	 *            真实姓名
	 * @param sex
	 *            性别
	 * @param age
	 *            年龄
	 * @param mobile
	 *            手机
	 * @param phone
	 *            座机
	 * @param email
	 *            电子邮件
	 * @param isSuspend
	 *            是否停用
	 * @param maxSession
	 *            最大登录数
	 * @param userAccount
	 *            用户是否管理员
	 * @param priority
	 *            云台操作优先权
	 * @param sipCode
	 *            18位国标地址编码
	 * @param dispatchServerId
	 *            分发服务器ID
	 * @param isInnerUser
	 *            是否内网用户，1-是，0-不是
	 * @throws BusinessException
	 *             设定文件
	 * @return String 返回类型
	 * @throws BusinessException
	 */
	public String createUser(String logonName, String password, String organId,
			String accessServerId, String note, String name, String sex,
			Long age, String mobile, String phone, String email,
			Short isSuspend, Long maxSession, String userAccount,
			Short priority, String sipCode, String dispatchServerId,
			Short isInnerUser) throws BusinessException;

	/**
	 * @Title: deleteUserById
	 * @Description: 根据ID删除用户
	 * @param userId
	 *            用户ID
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public void deleteUser(String id) throws BusinessException;

	/**
	 * @Title: updateUser
	 * @Description: 根据用户ID更新
	 * @param id
	 *            用户ID
	 * @param logonName
	 *            登录名
	 * @param password
	 *            密码
	 * @param accessServerId
	 *            接入服务器ID
	 * @param note
	 *            备注
	 * @param name
	 *            真实姓名
	 * @param sex
	 *            性别
	 * @param age
	 *            年龄
	 * @param mobile
	 *            手机
	 * @param phone
	 *            座机
	 * @param email
	 *            电子邮件
	 * @param maxSession
	 *            最大登录数
	 * @param userAccount
	 *            用户是否是管理员
	 * @param priority
	 *            云台操作优先权
	 * @param sipCode
	 *            18位国际地址编码
	 * @param dispatchServerId
	 *            分发服务器ID
	 * @param isInnerUser
	 *            是否内网用户，1-是，0-不是
	 * @throws BusinessException
	 *             设定文件
	 * @return void 返回类型
	 * @throws BusinessException
	 */
	public void updateUser(String id, String logonName, String password,
			String accessServerId, String note, String name, String naming,
			String sex, Long age, String mobile, String phone, String email,
			Long maxSession, String userAccount, Short priority,
			String sipCode, String dispatchServerId, Short isInnerUser)
			throws BusinessException;

	/**
	 * @Title: listUser
	 * @Description: 返回用户所有数据
	 * @param @return
	 * @param @throws BusinessException 设定文件
	 * @return List<TUser> 返回类型
	 * @throws
	 */
	public List<TUser> listUser() throws BusinessException;

	/**
	 * @Title: listUserByOrganId
	 * @Description: TODO(根据机构id查询用户)
	 * @param @param organId
	 * @param @return 设定文件
	 * @return List<TUser> 返回类型
	 * @throws
	 */
	public List<TUserVO> listUserByOrganId(String organId);

	/**
	 * 
	 * @Title: logoff
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param sessionId
	 *            要注销的会话ID
	 * @return void 返回类型
	 * @throws
	 */
	public void logoff(String sessionId);

	/**
	 * 条件查询在线用户列表
	 * 
	 * @param parm
	 *            查询条件，详见
	 *            {@link com.megaeyes.persistence.ibatis.queryParameter.UserSessionParameter}
	 * @return List<UserSessionVO> 在线用户列表
	 * @throws BusinessException
	 */
	public List<UserSessionVO> listUserSession(UserSessionParameter parm)
			throws BusinessException;

	/**
	 * 根据sessionId，获取相应的用户登录信息
	 * 
	 * @param sessionId
	 *            sessionId
	 * @return UserSessionVO
	 */
	public UserSessionVO getSessionById(String sessionId)
			throws BusinessException;

	/**
	 * @Title: getAllChildUsersByOrganId
	 * @Description: TODO(根据机构id查询所有子机构用户)
	 * @param @param organId
	 * @param @return 设定文件
	 * @return List<TUser> 返回类型
	 * @throws
	 */
	public List<TUser> getAllChildUsersByOrganId(String organId);

	/**
	 * 
	 * @Title: countAllUser
	 * @Description: 统计平台所有用户
	 * @param @return 设定文件
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer countAllUser();

	/**
	 * 
	 * listUserSessionAndUserLogName 查询在线用户列表
	 * 
	 * @return List<ListUserSessionAndUserVO>
	 */
	public List<ListUserSessionAndUserVO> listUserSessionAndUserLogName();

	/**
	 * 检查用户会话，过期的移除
	 */
	public void checkSession();

	/**
	 * 
	 * updatePassword 根据用户ID修改密码
	 * 
	 * @param userId
	 *            用户id
	 * @param password
	 *            密码
	 */
	public void updatePassword(String userId, String password);

	/**
	 * 
	 * @Description: 查询用户是否具有云台控制权限
	 * @author zhuanqi@megaeyes.com
	 * @param @param userId
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean checkUserPermissionByUserId(String userId,
			String operationNumber);

	public String getAccessServerIp1(String ip);
	
	public String getGisServerUrl();
}
