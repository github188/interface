package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.AcRDoorCardDAOImpl;

/**
 * AcRDoorCardDAOiBatis(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-17 上午05:59:23
 */
public class AcRDoorCardDAOiBatis extends AcRDoorCardDAOImpl {

	/**
	 * 
	 * updateTypeByDoorIdAndCardId 根据门ID和卡ID修改状态
	 * @param doorId 
	 * @param cardId
	 * @param authorizeType
	 */
	public void updateTypeByDoorIdAndCardId(String doorId, String cardId,
			String authorizeType) {
		Map map = new HashMap();
		map.put("doorId",doorId);
		map.put("cardId",cardId);
		map.put("authorizeType", authorizeType);
		getSqlMapClientTemplate().update("AC_R_DOOR_CARD_VIEW.updateTypeByDoorIdAndCardId",map);
		
	}

}
