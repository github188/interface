package com.megaeyes.web.response;

import com.megaeyes.persistence.ibatis.model.EpClientGateway;

/**
 * GetEpClientGateway(类说明)
 * 
 * @author tangjianyang tangjianyang@megaeyes.com
 *         <p />
 *         2012-12-27 下午4:51:38
 */
public class GetEpClientGatewayResponse extends BaseResponse {
	private EpClientGateway epClientGateway;

	public EpClientGateway getEpClientGateway() {
		return epClientGateway;
	}

	public void setEpClientGateway(EpClientGateway epClientGateway) {
		this.epClientGateway = epClientGateway;
	}
}
