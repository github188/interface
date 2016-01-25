/**   
* @Title: EpAlarmEventVO.java 
* @Package com.megaeyes.persistence.ibatis.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-4 上午5:27:40 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/** 
 * @ClassName: EpAlarmEventVO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-4 上午5:27:40 
 *  
 */
public class EpAlarmEventVO {
	private String naming;
	private String note;
	private BigDecimal confirmTime;
	public String getNaming() {
		return naming;
	}
	public void setNaming(String naming) {
		this.naming = naming;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public BigDecimal getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(BigDecimal confirmTime) {
		this.confirmTime = confirmTime;
	}
}
