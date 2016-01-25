package test;

import java.util.List;
import java.util.regex.Pattern;
/**
 * 字符串工具类
 * @author zhuanqi@megaeyes.com
 *
 * Sep 17, 2010
 */
public class StringUtil {
	/**
	 * 判断String是否为空 eg "" null --------- true
	 * 
	 * @param src
	 * @return
	 */
	public static boolean isBlank(String src) {
		boolean flag = false;
		if (src == null || "".equals(src) || "null".equals(src)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断字符串是否不为空 和isBlank相反 eg "" null ------------false
	 * 
	 * @param src
	 * @return
	 */
	public static boolean isNotBlank(String src) {
		return !isBlank(src);
	}

	/**
	 * 
	 * 将list中的所有ID转成 0000000001,0000000002
	 * @param ids
	 * @return
	 */
	public static String array2String(List<String> ids) {
		String idString = ids.toString();
		idString = idString.substring(1, idString.length() - 1);
		return idString;
	}
	/**
	 * 统计某个字符串指定字符出现的次数
	 * @param src
	 * @param ch
	 * @return
	 * @author gzx
	 */
	public static int countChar(String src,char ch) {
		if(src == null || src.equals("")){
			return 0 ;
		}
		int count = 0 ;
		for (int i = 0; i < src.length(); i++) {
			if(src.charAt(i) == ch){
				count ++ ;
			}
		}
		return count ;
	}
	
	/**
	 * 将字符串数组转换成为字符串表示形式(用于组拼sql语句)
	 * @param array
	 * @return
	 * @author gzx
	 */
	public static String array2SqlString(Object[] array) {
		if(array == null || array.length == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder() ;
		for (int i = 0; i < array.length; i++) {
			String item = "'" + array[i] + "'" + "," ;
//			if (array[i] instanceof Number) {
//				item = array[i] + "," ;
//			}
			sb.append(item);
		}
		sb.deleteCharAt(sb.length() - 1) ;
		return sb.toString() ;
	}
	
	/**
	 * 将字符串集合转换成为字符串表示形式(用于组拼sql语句)
	 * @param list
	 * @return
	 * @author gzx
	 */
	public static String list2SqlString(List<String> list) {
		if(list == null || list.size() == 0){
			return "";
		}
		Object[] array = list.toArray() ;
		String[] strArr = new String[array.length] ;
		for (int i = 0; i < array.length; i++) {
			strArr[i] = array[i].toString() ;
		}
		return array2SqlString(strArr) ;
	}
	
	/**
	 * 将字符串转换为数组,以,分割
	 * @param arrayString
	 * @return
	 * @author gzx
	 */
	public static String[] string2Array(String arrayString) {
		if(arrayString == null){
			return new String[0];
		}
		if(arrayString.indexOf(",") == -1){
			return new String[]{arrayString} ;
		}
		return arrayString.split(",") ;
	}
	
	/**
	 * 判断字符串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		Pattern pattern = Pattern.compile("[0-9]*"); 
		return pattern.matcher(str).matches(); 
	}
	
	/**
	 * 从path中提取顶层机构id
	 * @param path
	 * @return
	 * @author gzx
	 */
	public static String getTopIdFromPath(String path) {
		if(path != null){
			String[] arr = path.split("/") ;
			if(arr != null && arr.length > 0){
				return arr[1] ;
			}
		}
		return null ;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 * @author gzx
	 */
	public static String upperIndexString(String str) {
		if(str != null && !str.trim().equals("")) {
			String index = str.substring(0, 1) ;
			return index.toUpperCase() + str.substring(1) ;
		}
		return "" ;
	}
	
	/**
	 * 取得dao名称
	 * @param className
	 * @return
	 * @author gzx
	 */
	public static String getDaoNameByClassName(String className) {
		return className.substring(0, 1).toLowerCase() + className.substring(1) + "Dao" ;
	}
	/**
	 * 格式化时间
	 * @param timeStr 20101117-102411
	 * @return 2010-11-17 10:24:11
	 * @author gzx
	 */
	public static String formatTimeFromString(String timeStr) {
		try {
			if(timeStr != null) {
				String[] arr = timeStr.split("-") ;
				String year = arr[0].substring(0, 4) ;
				String month = arr[0].substring(4, 6) ;
				String day = arr[0].substring(6, 8) ;
				String hour = arr[1].substring(0, 2) ;
				String min = arr[1].substring(2, 4) ;
				String sec = arr[1].substring(4, 6) ;
				timeStr = year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec ;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return timeStr ;
	}
	
	/**
	 * 获取path中的最后的部分
	 * 输入:/000/1111/0123
	 * 返回:0123
	 * @param path
	 * @return
	 * @author gzx
	 */
	public static String getLatestOrganId(String path){
		if(StringUtil.isBlank(path) || !path.contains("/")){
			return null ;
		}
		else{
			return path.substring(path.lastIndexOf("/")+1);
		}
	}
	
	
	/**
	 * 判断URL是否是http或https请求
	 * @param url
	 * @return
	 * @author gm
	 */
	public static boolean isNetworkUrl(String url) {
        if (url == null || url.length() == 0) {
            return false;
        }
        return isHttpUrl(url) || isHttpsUrl(url);
    }
	
	/**
	 * 判断URL是否是http请求
	 * @param url
	 * @return
	 * @author gm
	 */
	 public static boolean isHttpUrl(String url) {
	        return (null != url) &&
	               (url.length() > 6) &&
	               url.substring(0, 7).equalsIgnoreCase("http://");
	}
	 
	 /**
	 * 判断URL是否是https请求
	 * @param url
	 * @return
	 * @author gm
	 */
	 public static boolean isHttpsUrl(String url) {
	        return (null != url) &&
	               (url.length() > 7) &&
	              url.substring(0, 8).equalsIgnoreCase("https://");
	}
	 
	/**
	 * 将字符串数组转换成为字符串表示形式(用于组拼sql语句)
	 * @param array
	 * @return
	 * @author gzx
	 */
	public static String array2SqlString2(Object[] array) {
		if(array == null || array.length == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder() ;
		for (int i = 0; i < array.length; i++) {
			String item = "" + array[i] + "" + "," ;
//				if (array[i] instanceof Number) {
//					item = array[i] + "," ;
//				}
			sb.append(item);
		}
		sb.deleteCharAt(sb.length() - 1) ;
		return sb.toString() ;
	}
	
	/**
	 * 将字符串集合转换成为字符串表示形式(用于组拼sql语句)
	 * @param list
	 * @return
	 * @author gzx
	 */
	public static String list2SqlString2(List<String> list) {
		if(list == null || list.size() == 0){
			return "";
		}
		Object[] array = list.toArray() ;
		String[] strArr = new String[array.length] ;
		for (int i = 0; i < array.length; i++) {
			strArr[i] = array[i].toString() ;
		}
		return array2SqlString2(strArr) ;
	}
			 

	
	public static void main(String args[]) {
		//System.out.println(upperIndexString("Abcddd")) ;
		System.out.println("123".equals("123"));
	}
}
