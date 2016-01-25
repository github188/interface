package com.megaeyes.access.util;

/**
 * 将相关对象转换成String,防止null值异常的情况
 */
public class StringUtil {
	/**
	 * 将String的object转换成String
	 * @param strObject
	 * @return
	 */
	public static String toString(String strObject){
		if(strObject==null){
			return "";
		}
		return strObject;
	}
	
	/**
	 * 转换Integer对象成String
	 * @param intObjext
	 * @return
	 */
	public static String toString(Integer intObjext){
		if(intObjext!=null){
			return intObjext.toString();
		}
		return "";
	}
	
	/**
	 * 转换double成string类型
	 * @param douObject
	 * @return
	 */
	public static String toString(Double douObject){
		if(douObject!=null){
			return douObject.toString();
		}
		return "";
	}
	
	/**
	 * 将floatObject对象转换成字符串
	 * @param floatObject
	 * @return
	 */
	public static String toString(Float floatObject){
		if(floatObject!=null){
			return floatObject.toString();
		}
		return "";
	}
	
	/**
	 * 转换long值成String
	 * @param longValue
	 * @return
	 */
	public static String toString(long longValue){
		return ""+longValue;
	}
	
	/**
	 * 将int对象返回成字符串
	 * @param intValue
	 * @return
	 */
	public static String toString(int intValue){
		return ""+intValue;
	}
	
	/**
	 * 将double返回成字符串
	 * @param douValue
	 * @return
	 */
	public static String toString(double douValue){
		return ""+douValue;
	}
	
	/**
	 * 将float转换成字符串
	 * @param floatValue
	 * @return
	 */
	public static String toString(float floatValue){
		return ""+floatValue;
	}
	
}
