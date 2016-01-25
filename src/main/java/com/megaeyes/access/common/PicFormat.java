package com.megaeyes.access.common;

import java.util.HashMap;

/**
 * 
 * @Title: PicFormat.java
 * @Package com.megaeyes.access.common
 * @Description: 图像格式映射
 * @author zhuanqi@megaeyes.com
 * @date 2012-12-3 上午03:31:01
 * @version V1.0
 */
public class PicFormat {

	// 图像格式映射表
	private static HashMap<String, String> picFormatTranslator = new HashMap<String, String>();

	static {
		// 配置图像格式映射表
		picFormatTranslator.put("0", "CIF");
		picFormatTranslator.put("1", "QCIF");
		picFormatTranslator.put("2", "2CIF");
		picFormatTranslator.put("3", "4CIF/D1");
	}

	public static String getPicFormat(String code) {
		return (String) picFormatTranslator.get(code);
	}

}
