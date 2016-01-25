package com.megaeyes.access.exception;

/**
 * 所有（企业）用户会话异常的父类。
 * <p>Title: megaeyes</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public abstract class UserSessionException extends ProxyAppException
{

  public UserSessionException()
  {
  }


  public UserSessionException(String message)
  {
    super(message);
  }


  public UserSessionException(String message, Throwable cause)
  {
    super(message, cause);
  }


  public UserSessionException(Throwable cause)
  {
    super(cause);
  }
}