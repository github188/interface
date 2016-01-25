/**   
* @Title: LicenceNotFoundException.java 
* @Package com.megaeyes.service.utils.licence 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-4 下午3:21:05 
* @version V1.0   
*/ 
package com.megaeyes.service.utils.licence;

/** 
 * @ClassName: LicenceNotFoundException 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-4 下午3:21:05 
 *  
 */
public class LicenceNotFoundException extends Exception
{

    public LicenceNotFoundException()
    {
    	  super("License 文件不存在");
    }

    public LicenceNotFoundException(String s)
    {
        super(s);
    }
    public LicenceNotFoundException(Exception e)
    {
        super(e);
    }
}