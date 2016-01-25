/**   
 * @Title: EpRSchemeAlarmSourceVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-7 下午1:48:51 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

/**
 * @ClassName: EpRSchemeAlarmSourceVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-7 下午1:48:51
 * 
 */
public class EpRSchemeAlarmSourceVO {
	private String sourceId;
	private String epSchemeId;

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getEpSchemeId() {
		return epSchemeId;
	}

	public void setEpSchemeId(String epSchemeId) {
		this.epSchemeId = epSchemeId;
	}
}
