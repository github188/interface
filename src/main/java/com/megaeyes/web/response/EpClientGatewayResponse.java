package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpClientGateway;

/**
 * EpClientGatewayResponse(类说明)
 * 
 * @author tangjianyang tangjianyang@megaeyes.com
 *         <p />
 *         2012-12-27 下午4:46:56
 */
public class EpClientGatewayResponse extends BaseResponse {
	private List<EpClientGateway> epClientGateway;

	public List<EpClientGateway> getEpClientGateway() {
		return epClientGateway;
	}

	public void setEpClientGateway(List<EpClientGateway> epClientGateway) {
		this.epClientGateway = epClientGateway;
	}
}
