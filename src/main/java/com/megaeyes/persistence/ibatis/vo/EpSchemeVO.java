/**   
 * @Title: EpSchemeVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-18 上午2:05:36 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import java.util.List;

/**
 * @ClassName: EpSchemeVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-18 上午2:05:36
 * 
 */
public class EpSchemeVO {
	private String id;
	private String name;
	private String organId;
	private String note;
	private String type;
	private Action actions;

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

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Action getActions() {
		return actions;
	}

	public void setActions(Action actions) {
		this.actions = actions;
	}

	public class Action {
		private List<NotifyUser> notifyUsers;
		private List<AlarmOut> alarmOuts;
		private List<Recorder> recorders;
		private List<Preset> presets;
		private List<Track> tracks;
		private List<Prober> probers;
		private List<Display> displays;
		private List<Door> doors;

		public List<NotifyUser> getNotifyUsers() {
			return notifyUsers;
		}

		public void setNotifyUsers(List<NotifyUser> notifyUsers) {
			this.notifyUsers = notifyUsers;
		}

		public List<AlarmOut> getAlarmOuts() {
			return alarmOuts;
		}

		public void setAlarmOuts(List<AlarmOut> alarmOuts) {
			this.alarmOuts = alarmOuts;
		}

		public List<Recorder> getRecorders() {
			return recorders;
		}

		public void setRecorders(List<Recorder> recorders) {
			this.recorders = recorders;
		}

		public List<Preset> getPresets() {
			return presets;
		}

		public void setPresets(List<Preset> presets) {
			this.presets = presets;
		}

		public List<Track> getTracks() {
			return tracks;
		}

		public void setTracks(List<Track> tracks) {
			this.tracks = tracks;
		}

		public List<Prober> getProbers() {
			return probers;
		}

		public void setProbers(List<Prober> probers) {
			this.probers = probers;
		}

		public List<Display> getDisplays() {
			return displays;
		}

		public void setDisplays(List<Display> displays) {
			this.displays = displays;
		}

		public List<Door> getDoors() {
			return doors;
		}

		public void setDoors(List<Door> doors) {
			this.doors = doors;
		}

	}

	public class NotifyUser {
		private String id;
		private String name;

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
	}

	public class AlarmOut {
		private String id;
		private String name;
		private String duration;
		private String value;

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

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	public class Recorder {
		private String id;
		private String name;
		private String duration;

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

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}
	}

	public class Preset {
		private String id; // 预置点ID
		private String name; // 摄像头名称
		private String duration;
		private String value; // 预置点位
		private String presetName; // 预置点名称
		private String vicId; // 所属摄像头ID

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

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getPresetName() {
			return presetName;
		}

		public void setPresetName(String presetName) {
			this.presetName = presetName;
		}

		public String getVicId() {
			return vicId;
		}

		public void setVicId(String vicId) {
			this.vicId = vicId;
		}

	}

	public class Track {
		private String id;
		private String name;

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

	}

	public class Prober {
		private String id;
		private String name;
		private String duration;
		private String value;

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

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	public class Display {
		private String id; // 监视器ID
		private String name; // 监视器名称
		private String duration; // 投墙持续时间
		private String value; // 摄像头ID
		private String vicName; // 摄像头名称
		private String seq; // 执行序号

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

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getVicName() {
			return vicName;
		}

		public void setVicName(String vicName) {
			this.vicName = vicName;
		}

		public String getSeq() {
			return seq;
		}

		public void setSeq(String seq) {
			this.seq = seq;
		}

	}

	public class Door {
		private String id;
		private String name;
		private String value;

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

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
