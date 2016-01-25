/**   
 * @Title: ListSchemeResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-18 下午4:44:07 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.web.response.xml.BaseXMLResponse;

/**
 * @ClassName: ListSchemeResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-18 下午4:44:07
 * 
 */
public class ListSchemeResponse extends  BaseXMLResponse {
	public List<EpScheme> getList() {
		return list;
	}

	public void setList(List<EpScheme> list) {
		this.list = list;
	}

	private List<EpScheme> list = new ArrayList<EpScheme>(); // 预案列表
}
