package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.Manufacturer;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModel;

/**
 * ListManufacturerResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-6-15 上午08:30:26
 */
public class ListVOCModelResponse extends BaseResponse {
	private List<VideoOutputChannelModel> vocModel = new ArrayList();

	public List<VideoOutputChannelModel> getVocModel() {
		return vocModel;
	}

	public void setVocModel(List<VideoOutputChannelModel> vocModel) {
		this.vocModel = vocModel;
	}

	
}
