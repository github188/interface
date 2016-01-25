/**   
 * @Title: EpTaskStepVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-14 下午2:05:40 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import java.util.List;

/**
 * @ClassName: EpTaskStepVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-14 下午2:05:40
 * 
 */
public class EpTaskStepVO {
	private String id;
	private String deviceType;
	private String stepName;
	private String stepNote;
	private String sequence;
	private String taskId;
	private List probers;
	private List vics;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getStepNote() {
		return stepNote;
	}

	public void setStepNote(String stepNote) {
		this.stepNote = stepNote;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public List getProbers() {
		return probers;
	}

	public void setProbers(List probers) {
		this.probers = probers;
	}

	public List getVics() {
		return vics;
	}

	public void setVics(List vics) {
		this.vics = vics;
	}
}
