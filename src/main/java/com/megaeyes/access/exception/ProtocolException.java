package com.megaeyes.access.exception;

/**
 * 所有协议异常的父类。
 * <p>Title: megaeyes</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class ProtocolException  extends ProxyAppException
{

  public ProtocolException()
  {
  }


  public ProtocolException(String message)
  {
    super(message);
  }


  public ProtocolException(String message, Throwable cause)
  {
    super(message, cause);
  }


  public ProtocolException(Throwable cause)
  {
    super(cause);
  }
}