package com.megaeyes.access.exception;

/**
 * 
 * @Title: ExceptionHandler.java 
 * @Package com.megaeyes.access.exception 
 * @Description: 异常包装类
 * @author zhuanqi@megaeyes.com   
 * @date 2012-9-19 上午09:01:17 
 * @version V1.0
 */
public class ExceptionHandler
{
  public static void throwRuntimeException(Exception e)
  {
    throw new ProxyAppRuntimeException(e);
  }
}