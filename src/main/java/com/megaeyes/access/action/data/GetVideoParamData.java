package com.megaeyes.access.action.data;

import org.jdom.Element;

import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;

/**
 * 
 * @Title: GetVideoParamData.java
 * @Package com.megaeyes.access.action.data
 * @Description: 获取视频参数-5076
 * @author zhuanqi@megaeyes.com
 * @date 2012-12-3 上午02:33:10
 * @version V1.0
 */
public class GetVideoParamData extends VideoInputChannelVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4825639525612215295L;

	private int type;

	private String streamTypeStr;

	private int keyFrameInterval;

	private String supportFormat;

	private int imageFormat;

	private String supportFormatStr;

	private String imageFormatStr;

	private Element requestElement;
	
    private Object[][] objResult;


    public void setPicSupprotFormat(Object[][] obj)
    {

        this.objResult = obj;
    }

    public Object[][] getPicSupprotFormat()
    {

        return this.objResult;
    }

	public void setType(int type) {

		this.type = type;
	}

	public int getType() {

		return this.type;
	}

	public Element getRequestElement() {
		return requestElement;
	}

	public void setRequestElement(Element requestElement) {
		this.requestElement = requestElement;
	}

	public String getStreamTypeStr() {
		return streamTypeStr;
	}

	public void setStreamTypeStr(String streamTypeStr) {
		this.streamTypeStr = streamTypeStr;
	}
	
	public int getKeyFrameInterval() {
		return keyFrameInterval;
	}

	public void setKeyFrameInterval(int keyFrameInterval) {
		this.keyFrameInterval = keyFrameInterval;
	}

	public String getSupportFormat() {
		return supportFormat;
	}

	public void setSupportFormat(String supportFormat) {
		this.supportFormat = supportFormat;
	}

	public int getImageFormat() {
		return imageFormat;
	}

	public void setImageFormat(int imageFormat) {
		this.imageFormat = imageFormat;
	}

	public String getSupportFormatStr() {
		return supportFormatStr;
	}

	public void setSupportFormatStr(String supportFormatStr) {
		this.supportFormatStr = supportFormatStr;
	}

	public String getImageFormatStr() {
		return imageFormatStr;
	}

	public void setImageFormatStr(String imageFormatStr) {
		this.imageFormatStr = imageFormatStr;
	}
}
