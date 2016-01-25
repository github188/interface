package com.megaeyes.access.exception;


/**
 * �豸��ѯʧ�ܡ�
 * <p>Title: megaeyes</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class DeviceQueryFailException  extends DeviceException
{

  public DeviceQueryFailException()
  {
  }


  public DeviceQueryFailException(String message)
  {
    super(message);
  }


  public DeviceQueryFailException(String message, Throwable cause)
  {
    super(message, cause);
  }


  public DeviceQueryFailException(Throwable cause)
  {
    super(cause);
  }
}