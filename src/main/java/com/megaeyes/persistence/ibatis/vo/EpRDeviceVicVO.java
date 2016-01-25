package com.megaeyes.persistence.ibatis.vo;

import com.megaeyes.persistence.ibatis.model.EpRDeviceVic;


public class EpRDeviceVicVO extends EpRDeviceVic {
	
	private String presetName;
	
	private Integer presetNumber;

	public String getPresetName() {
		return presetName;
	}

	public void setPresetName(String presetName) {
		this.presetName = presetName;
	}

	public Integer getPresetNumber() {
		return presetNumber;
	}

	public void setPresetNumber(Integer presetNumber) {
		this.presetNumber = presetNumber;
	}

	
	
	

}
