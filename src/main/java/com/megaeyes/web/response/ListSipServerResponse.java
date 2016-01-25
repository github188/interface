package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.SipServer;

/**
 * ListSipServerResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-7-18 上午02:50:59
 */
public class ListSipServerResponse extends BaseResponse {

	private List<SipServer> sipServer = new ArrayList();

	public List<SipServer> getSipServer() {
		return sipServer;
	}

	public void setSipServer(List<SipServer> sipServer) {
		this.sipServer = sipServer;
	}
	
	
}
