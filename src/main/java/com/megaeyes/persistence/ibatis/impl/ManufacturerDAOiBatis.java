/**   
* @Title: ManufacturerDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-3-23 下午2:27:21 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.ManufacturerDAOImpl;
import com.megaeyes.persistence.ibatis.model.Manufacturer;

/** 
 * @ClassName: ManufacturerDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-3-23 下午2:27:21 
 *  
 */
public class ManufacturerDAOiBatis extends ManufacturerDAOImpl {
	/**
	 * 调用此方法返回Manufacturer的下一个ID，用于insert
	 * 
	 * @return MANUFACTURER_SEQ.nextval
	 */
	public String getManufacturerSeq() {
		String id = (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getManufacturerSeq", null);
		String prefix = "";
		for (int i = 31; i > id.length(); i--) {
			prefix += "0";
		}
		id = prefix + id;
		return id;
	}
}
