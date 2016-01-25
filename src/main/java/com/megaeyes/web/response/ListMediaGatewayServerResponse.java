package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.MediaGatewayServer;

/**
 * ListMediaGatewayServerResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-7-19 上午06:02:31
 */
public class ListMediaGatewayServerResponse extends BaseResponse{
	List<MediaGatewayServer> mediaGatewayServer = new ArrayList();

	public List<MediaGatewayServer> getMediaGatewayServer() {
		return mediaGatewayServer;
	}

	public void setMediaGatewayServer(List<MediaGatewayServer> mediaGatewayServer) {
		this.mediaGatewayServer = mediaGatewayServer;
	}
	
}
