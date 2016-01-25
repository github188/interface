/**   
 * @Title: TaskStepVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-11 上午10:06:20 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpRTaskstepMonitor;

/**
 * @ClassName: TaskStepVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-11 上午10:06:20
 * 
 */
public class TaskStepVO {
	private String id;

	private String name;

	private Integer seq;

	private String taskId;

	private String note;
	private List<EpRTaskstepMonitor> list;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<EpRTaskstepMonitor> getList() {
		return list;
	}

	public void setList(List<EpRTaskstepMonitor> list) {
		this.list = list;
	}

}
