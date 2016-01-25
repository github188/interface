/**   
* @Title: ListAcEmployeesResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-24 上午5:36:23 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.megaeyes.persistence.ibatis.vo.AcEmployeesVO;

/** 
 * @ClassName: ListAcEmployeesResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-24 上午5:36:23 
 *  
 */
public class ListAcEmployeesResponse extends BaseResponse {
	private List<AcEmployeesVO> acEmployees;

	public List<AcEmployeesVO> getAcEmployees() {
		return acEmployees;
	}

	public void setAcEmployees(List<AcEmployeesVO> acEmployees) {
		this.acEmployees = acEmployees;
	}

	
	public static void main(String args[]){
		AcEmployeesVO vo  = new AcEmployeesVO();
		ListAcEmployeesResponse resp = new ListAcEmployeesResponse();
		List<AcEmployeesVO> list = new ArrayList<AcEmployeesVO>();
		list.add(vo);
		resp.setAcEmployees(list);
		String jsonRtn = JSONObject.fromObject(resp).toString();
		System.out.println(jsonRtn);
	}
	
}
