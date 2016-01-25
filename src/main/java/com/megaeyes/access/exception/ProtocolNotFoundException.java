package com.megaeyes.access.exception;


/**
 * 协议没找到。
 * <p>Title: megaeyes</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class ProtocolNotFoundException extends ProtocolException
{

  public ProtocolNotFoundException()
  {
  }


  public ProtocolNotFoundException(String message)
  {
    super(message);
  }


  public ProtocolNotFoundException(String message, Throwable cause)
  {
    super(message, cause);
  }


  public ProtocolNotFoundException(Throwable cause)
  {
    super(cause);
  }
}