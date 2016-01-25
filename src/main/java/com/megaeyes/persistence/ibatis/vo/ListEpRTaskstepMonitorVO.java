/**   
 * @Title: ListEpRTaskstepMonitorVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-11 下午6:19:39 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import java.util.List;

/**
 * @ClassName: ListEpRTaskstepMonitorVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-11 下午6:19:39
 * 
 */
public class ListEpRTaskstepMonitorVO {
	private List<EpRTaskstepMonitorVO> presets;
	private String id;

	public List<EpRTaskstepMonitorVO> getPresets() {
		return presets;
	}

	public void setPresets(List<EpRTaskstepMonitorVO> presets) {
		this.presets = presets;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
