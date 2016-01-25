package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.AcAccessCardsDAO;
import com.megaeyes.persistence.ibatis.iface.AcAccessCardsDAOImpl;
import com.megaeyes.persistence.ibatis.model.AcAccessCards;
import com.megaeyes.persistence.ibatis.model.AcAccessCardsExample;
import com.megaeyes.service.impl.BaseManagerImpl;

/**
 * AcAccessCardsDAOiBatis(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-16 上午03:12:15
 */
public class AcAccessCardsDAOiBatis extends AcAccessCardsDAOImpl{

	/**
	 * 
	 * listAcAccessCards 查询卡列表
	 * @return List<AcAccessCards>
	 */
	public List<AcAccessCards> listAcAccessCards() {
		return getSqlMapClientTemplate().queryForList(
		"AC_ACCESS_CARDS_VIEW.listAcAccessCards");
	}

	/**
	 *
	 * getCardByCardNumber 根据卡号查询卡
	 * @param cardNumber 卡号
	 * @return AcAccessCards
	 */
	public AcAccessCards getCardByCardNumber(String cardNumber) {
		return (AcAccessCards) getSqlMapClientTemplate().queryForObject("AC_ACCESS_CARDS_VIEW.getCardByCardNumber", cardNumber);
	}

	
	/**
	 * 
	 * updateStatus 根据职工ID更新卡状态
	 * @param doorId
	 */
	public void updateStatus(String employeeId) {
		getSqlMapClientTemplate().update("AC_ACCESS_CARDS_VIEW.updateStatus", employeeId);
		
	}

	/**
	 * 
	 * updateStatusByDoorId 根据卡ID更新卡状态
	 * @param doorId
	 */
	public void updateStatusByCard(String card) {
		getSqlMapClientTemplate().update("AC_ACCESS_CARDS_VIEW.updateStatusByCard", card);
		
	}

}
