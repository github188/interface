/**   
 * @Title: UserSessionDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-2 下午2:05:39 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.UserSessionDAOImpl;
import com.megaeyes.persistence.ibatis.queryParameter.UserSessionParameter;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;

/**
 * @ClassName: UserSessionDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-2 下午2:05:39
 * 
 */
public class UserSessionDAOiBatis extends UserSessionDAOImpl {

	/**
	 * @Title: getUserSessionSeq
	 * @Description: TODO(调用此方法返回用户登陆会话的下一个ID，用于insert)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getUserSessionSeq() {
		String id = (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getUserSessionSeq", null);
		String prefix = "";
		for (int i = 31; i > id.length(); i--) {
			prefix += "0";
		}
		id = prefix + id;
		return id;
	}

	/**
	 * @Title: getUserSessionHistorySeq
	 * @Description: TODO( 调用此方法返回用户登陆会话历史的下一个ID，用于insert)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getUserSessionHistorySeq() {
		String id = (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getUserSessionHistorySeq", null);
		String prefix = "";
		for (int i = 31; i > id.length(); i--) {
			prefix += "0";
		}
		id = prefix + id;
		return id;
	}

	/**
	 * 条件查询在线用户列表
	 * 
	 * @param parm
	 *            查询条件，详见
	 *            {@link com.megaeyes.persistence.ibatis.queryParameter.UserSessionParameter}
	 * @return List<UserSessionVO> 在线用户列表
	 */
	@SuppressWarnings("unchecked")
	public List<UserSessionVO> listUserSession(UserSessionParameter parm) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("start", parm.getStart());
		queryMap.put("end", parm.getStart() + parm.getLimit());
		queryMap.put("userName", parm.getUserName());
		queryMap.put("organName", parm.getOrganName());
		queryMap.put("ip", parm.getIp());
		return getSqlMapClientTemplate().queryForList(
				"USER_SESSION_VIEW.listUserSession", queryMap);
	}

	/**
	 * 查询指定用户ID列表中的，在线用户session列表
	 * 
	 * @param ids
	 *            用户ID列表
	 * @return
	 */
	public List<UserSessionVO> listOnlineUserByIds(List<String> ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		return getSqlMapClientTemplate().queryForList(
				"USER_SESSION_VIEW.listOnlineUserByIds", map);
	}

	/**
	 * 根据sessionId，获取相应的用户登录信息
	 * 
	 * @param sessionId
	 *            用户回话ID
	 * @return
	 */
	public UserSessionVO getUserSessionById(String sessionId) {
		return (UserSessionVO) getSqlMapClientTemplate().queryForObject(
				"USER_SESSION_VIEW.getUserBySessionId", sessionId);
	}
}
