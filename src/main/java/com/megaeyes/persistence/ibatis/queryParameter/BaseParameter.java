/**   
* @Title: BaseParameter.java 
* @Package com.megaeyes.persistence.ibatis.queryParameter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-3-23 上午10:37:08 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.queryParameter;

/** 
 * @ClassName: BaseParameter 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-3-23 上午10:37:08 
 *  
 */
//查询参数的基类
public class BaseParameter {
	
	private int start=0; //分页参数
	
	private int limit=26; //分页参数

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}			

}
