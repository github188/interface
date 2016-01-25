package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcAccessControls;

/**
 * ListAcAccessControlsResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-15 上午10:02:24
 */
public class ListAcAccessControlsResponse extends BaseResponse {
	private List<AcAccessControls> acAccessControls;
	public List<AcAccessControls> getAcAccessControls() {
		return acAccessControls;
	}
	public void setAcAccessControls(List<AcAccessControls> acAccessControls) {
		this.acAccessControls = acAccessControls;
	}
}
