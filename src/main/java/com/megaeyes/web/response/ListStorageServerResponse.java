/**   
 * @Title: ListStorageServerResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-11 上午11:13:14 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.vo.ListRemoteStorageServerVO;

/**
 * @ClassName: ListStorageServerResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-11 上午11:13:14
 * 
 */
public class ListStorageServerResponse extends BaseResponse {

	private List<ListRemoteStorageServerVO> list;
	private String code;

	public List<ListRemoteStorageServerVO> getList() {
		return list;
	}

	public void setList(List<ListRemoteStorageServerVO> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
