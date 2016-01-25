/**   
* @Title: MacAddressUtil.java 
* @Package com.megaeyes.service.utils.licence 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-4 下午3:21:53 
* @version V1.0   
*/ 
package com.megaeyes.service.utils.licence;

/** 
 * @ClassName: MacAddressUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-4 下午3:21:53 
 *  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacAddressUtil {
	
	private static final String[] windowsCommand = { "ipconfig", "/all" };
	private static final String[] linuxCommand = { "/sbin/ifconfig", "-a" };
	private static final Pattern macPattern = Pattern
			.compile("(([0-9A-Fa-f]{1,2})(-[0-9A-Fa-f]{1,2}){5})|(([0-9A-Fa-f]{1,2})(:[0-9A-Fa-f]{1,2}){5})");

	public static List<String> getMacAddressList() throws IOException {
		ArrayList<String> macAddressList = new ArrayList<String>() ;
		String os = System.getProperty("os.name").toLowerCase() ;
		String[] command;
		if (os.startsWith("windows")) {
			command = windowsCommand;
		} 
		else if (os.startsWith("linux") || os.startsWith("sunos")) {
			command = linuxCommand;
		} 
		else {
			throw new IOException("Unknown operating system: " + os);
		}

		final Process process = Runtime.getRuntime().exec(command);
		// Discard the stderr
		new Thread() {
			public void run() {
				try {
					InputStream errorStream = process.getErrorStream();
					while (errorStream.read() != -1) {
					}
					errorStream.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();

		// Extract the MAC addresses from stdout
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		boolean result ;
		for (String line = null; (line = reader.readLine()) != null;) {
			Matcher matcher = macPattern.matcher(line);
			result = matcher.find();
			if (result) {
				macAddressList.add(formatMacAddress(matcher.group(0)));
			}
		}
		reader.close();
		return macAddressList;
	}

	public static String formatMacAddress(String macAddress) {
		macAddress = macAddress.replace(":", "-") ;
		String[] arr = macAddress.split("-") ;
		StringBuilder sb = new StringBuilder() ;
		if(arr != null && arr.length > 0){
			for (int i = 0; i < arr.length; i++) {
				if(arr[i].length() == 1) {
					sb.append("0" + arr[i]) ;
				}
				else {
					sb.append(arr[i]) ;
				}
				sb.append("-") ;
			}
			sb.deleteCharAt(sb.length() - 1) ;
		}
		else {
			sb.append(macAddress) ;
		}
		return sb.toString().toUpperCase() ;
	}
	
	public final static void main(String[] args) {
		try {
			List<String> addressList = getMacAddressList();
			StringBuffer sb = new StringBuffer();
			for (Iterator<String> iter = addressList.iterator(); iter.hasNext();) {
				sb.append(iter.next() + "\n");
			}
			System.out.println(sb.toString());
		} 
		catch (IOException e) {
		}
	}
}
