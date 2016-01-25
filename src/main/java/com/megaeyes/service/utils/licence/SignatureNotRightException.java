/**   
* @Title: SignatureNotRightException.java 
* @Package com.megaeyes.service.utils.licence 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-4 下午3:22:32 
* @version V1.0   
*/ 
package com.megaeyes.service.utils.licence;

/** 
 * @ClassName: SignatureNotRightException 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-4 下午3:22:32 
 *  
 */
public class SignatureNotRightException extends Exception{

    public SignatureNotRightException()
    {
        super("License 签名不正确");
    }

    public SignatureNotRightException(String s)
    {
        super(s);
    }

}