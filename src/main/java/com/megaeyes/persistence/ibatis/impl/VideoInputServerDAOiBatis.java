/**   
 * @Title: VideoInputServerDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-16 下午3:19:20 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.VideoInputServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.queryParameter.VisParameter;
import com.megaeyes.persistence.ibatis.vo.UserVisVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputServerVO;

/**
 * @ClassName: VideoInputServerDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-16 下午3:19:20
 * 
 */
public class VideoInputServerDAOiBatis extends VideoInputServerDAOImpl {
	/**
	 * @Title: getVISSeq
	 * @Description: 调用此方法返回VIS的下一个ID，用于insert
	 * @return VIDEOINPUTSERVER_SEQ.nextval
	 */
	public String getVISSeq() {
		String id = (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getVISSeq", null);
		String prefix = "";
		for (int i = 31; i > id.length(); i--) {
			prefix += "0";
		}
		id = prefix + id;
		return id;
	}

	public List<UserVisVO> getVISByOrganId(VisParameter parm) {
		Map queryMap = new HashMap();
		queryMap.put("start", parm.getStart());
		queryMap.put("end", parm.getStart() + parm.getLimit());
		queryMap.put("name", parm.getName());
		queryMap.put("address", parm.getAddress());
		queryMap.put("deviceNumber", parm.getDeviceNumber());
		queryMap.put("organId", parm.getOrganId());
		queryMap.put("lineBackFew", parm.getLineBackFew());
		queryMap.put("towerNumber", parm.getTowerNumber());
		queryMap.put("switchesIp", parm.getSwitchesIp());
		queryMap.put("serialServerIp", parm.getSerialServerIp());
		queryMap.put("voltageLevel", parm.getVoltageLevel());
		queryMap.put("areaBelongs", parm.getAreaBelongs());
		queryMap.put("type", parm.getType());
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_SERVER_VIEW.getVISByOrganId", queryMap);
	}

	public int getVISByOrganIdCount(VisParameter parm) {
		Map queryMap = new HashMap();
		queryMap.put("name", parm.getName());
		queryMap.put("address", parm.getAddress());
		queryMap.put("deviceNumber", parm.getDeviceNumber());
		queryMap.put("organId", parm.getOrganId());
		queryMap.put("lineBackFew", parm.getLineBackFew());
		queryMap.put("towerNumber", parm.getTowerNumber());
		queryMap.put("switchesIp", parm.getSwitchesIp());
		queryMap.put("serialServerIp", parm.getSerialServerIp());
		queryMap.put("voltageLevel", parm.getVoltageLevel());
		queryMap.put("areaBelongs", parm.getAreaBelongs());
		queryMap.put("type", parm.getType());
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"VIDEO_INPUT_SERVER_VIEW.getVISByOrganIdCount", queryMap);
	}

	public List<UserVisVO> getVISByUserId(VisParameter parm) {
		Map queryMap = new HashMap();
		queryMap.put("start", parm.getStart());
		queryMap.put("end", parm.getStart() + parm.getLimit());
		queryMap.put("name", parm.getName());
		queryMap.put("address", parm.getAddress());
		queryMap.put("deviceNumber", parm.getDeviceNumber());
		queryMap.put("organId", parm.getOrganId());
		queryMap.put("userId", parm.getUserId());
		// System.out.println("userid:"+queryMap.get("userId"));
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_SERVER_VIEW.getVISByUserId", queryMap);
	}

	public int getVISByUserIdCount(VisParameter parm) {
		Map queryMap = new HashMap();
		queryMap.put("name", parm.getName());
		queryMap.put("address", parm.getAddress());
		queryMap.put("deviceNumber", parm.getDeviceNumber());
		queryMap.put("organId", parm.getOrganId());
		queryMap.put("userId", parm.getUserId());
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"VIDEO_INPUT_SERVER_VIEW.getVISByUserIdCount", queryMap);
	}

	public List<VideoInputServerVO> listVisByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"VIDEO_INPUT_SERVER_VIEW.listVisByOrganId", organId);
	}

	public VideoInputServer getByDeviceNumber(String deviceNumber) {
		return (VideoInputServer) getSqlMapClientTemplate().queryForObject(
				"VIDEO_INPUT_SERVER_VIEW.getByDeviceNumber", deviceNumber);
	}
	
	public void updateTernimalNaming (String visId,String accessId, String cmsId,short isSupportScheme,String company){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("visId", visId);
		param.put("accessId", accessId);
		param.put("cmsId", cmsId);
		param.put("isSupportScheme", isSupportScheme);
		param.put("company", company);
		getSqlMapClientTemplate().update("VIDEO_INPUT_SERVER_VIEW.registerTerminal", param);
	}
}
