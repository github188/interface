/**   
 * @Title: EpOperation.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-5 下午4:11:53 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import org.yaml.snakeyaml.representer.BaseRepresenter;

import com.megaeyes.persistence.ibatis.model.EpOperation;

/**
 * @ClassName: EpOperation
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-5 下午4:11:53
 * 
 */
public class EpOperationResponse extends BaseResponse {

	private List<EpOperation> list;
	private String code;

	public List<EpOperation> getList() {
		return list;
	}

	public void setList(List<EpOperation> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
