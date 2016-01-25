/**   
* @Title: EpMapDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-4-25 上午10:35:33 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.EpMapDAOImpl;

/** 
 * @ClassName: EpMapDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-4-25 上午10:35:33 
 *  
 */
public class EpMapDAOiBatis extends EpMapDAOImpl {
	
	/**
	* @Title: getEpMapSeq 
	* @Description: TODO( 调用此方法返回EpMap的下一个ID，用于insert) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String getEpMapSeq() {
		String id = (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpMapSeq", null);
		String prefix = "";
		for (int i = 31; i > id.length(); i--) {
			prefix += "0";
		}
		id = prefix + id;
		return id;
	}
}
