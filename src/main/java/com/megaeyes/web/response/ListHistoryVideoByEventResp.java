package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.HistoryVideo;

/**
 * 根据报警事件查询录像列表返回对象
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-14 下午01:23:33
 */
public class ListHistoryVideoByEventResp extends BaseResponse {
	private List<HistoryVideo> videoList = new ArrayList<HistoryVideo>();

	public List<HistoryVideo> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<HistoryVideo> videoList) {
		this.videoList = videoList;
	}
}
