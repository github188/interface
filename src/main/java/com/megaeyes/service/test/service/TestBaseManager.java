/**   
* @Title: TestBaseManager.java 
* @Package com.megaeyes.service.test.service 
* @Description: BaseManager测试类
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-2-27 下午3:33:54 
* @version V1.0   
*/ 
package com.megaeyes.service.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.megaeyes.service.iface.BaseManager;

/** 
 * @ClassName: TestBaseManager 
 * @Description: BaseManager测试类 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-2-27 下午3:33:54 
 *  
 */
@ContextConfiguration   
(locations={"../resources/*.xml"}) 
public class TestBaseManager extends AbstractTestNGSpringContextTests {
	@Autowired  
	BaseManager baseManager;  
	 @Test  
	 public void test_inject_factory(){  
	  Assert.assertNotNull(baseManager);  
	 } 
	@Test
	public void test_checkSessionId(){
		Assert.assertNotNull(baseManager.checkSessionId("1"));
	}
}
