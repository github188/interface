package com.megaeyes.access.action.data;

import com.megaeyes.persistence.ibatis.model.AlarmScheme;


public class SetDeviceAlarmData {

	private String sourceNaming;

	private String sourceType;

	private String userNaming;

	private String schemeId;

	private String associateId;

	private AlarmScheme dto = new AlarmScheme();

	/**
	 * 
	 */
	public SetDeviceAlarmData() {
		super();
	}

	public String getSchemeId() {

		return schemeId;
	}

	public void setSchemeId(String schemeId) {

		this.schemeId = schemeId;
	}

	public String getSourceNaming() {

		return sourceNaming;
	}

	public void setSourceNaming(String sourceNaming) {

		this.sourceNaming = sourceNaming;
	}

	public String getSourceType() {

		return sourceType;
	}

	public void setSourceType(String sourceType) {

		this.sourceType = sourceType;
	}

	public String getUserNaming() {

		return userNaming;
	}

	public void setUserNaming(String userNaming) {

		this.userNaming = userNaming;
	}

	public String getAssociateId() {

		return associateId;
	}

	public void setAssociateId(String associateId) {

		this.associateId = associateId;
	}

	public AlarmScheme getDto() {
		return dto;
	}

	public void setDto(AlarmScheme dto) {
		this.dto = dto;
	}

}