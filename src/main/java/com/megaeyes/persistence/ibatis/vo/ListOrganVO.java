/**   
 * @Title: ListOrganVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-29 下午2:05:19 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import com.megaeyes.persistence.ibatis.model.Organ;

/**
 * @ClassName: ListOrganVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-29 下午2:05:19
 * 
 */
public class ListOrganVO extends Organ {
	private String sipCode;

	public String getSipCode() {
		return sipCode;
	}

	public void setSipCode(String sipCode) {
		this.sipCode = sipCode;
	}
}
