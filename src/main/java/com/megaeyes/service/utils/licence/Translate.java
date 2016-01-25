/**   
 * @Title: Translate.java 
 * @Package com.megaeyes.service.utils.licence 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-5-4 下午3:23:06 
 * @version V1.0   
 */
package com.megaeyes.service.utils.licence;

/**
 * @ClassName: Translate
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-5-4 下午3:23:06
 * 
 */

final public class Translate {
	private static final char chars[] = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private Translate() {
	}

	public static String translateBytesToString(byte abyte0[]) {
		StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
		for (int i = 0; i < abyte0.length; i++) {
			stringbuffer.append(chars[abyte0[i] >> 4 & 0xf]);// 取出次低4位(0-16)
			stringbuffer.append(chars[abyte0[i] & 0xf]);// 取出最低4位(0-16)
		}

		return stringbuffer.toString();
	}

	public static byte[] translateStringToBytes(String s) {
		byte abyte0[] = new byte[s.length() / 2];
		for (int i = 0; i < s.length(); i += 2) {
			if (i + 1 >= s.length())
				throw new IllegalArgumentException();
			byte byte0 = calculate(s.charAt(i));
			byte0 <<= 4;
			byte0 += calculate(s.charAt(i + 1));
			abyte0[i / 2] = byte0;
		}
		return abyte0;
	}

	private static byte calculate(char c1) throws IllegalArgumentException {
		byte byte0 = 0;
		if (c1 >= '0' && c1 <= '9')
			byte0 += c1 - 48;
		else if (c1 >= 'a' && c1 <= 'f')
			byte0 += (c1 - 97) + 10;
		else if (c1 >= 'A' && c1 <= 'F')
			byte0 += (c1 - 65) + 10;
		else
			throw new IllegalArgumentException();
		return byte0;
	}
	// public static void main(String[] args) {
	// System.out.println(calculate('a'));
	// }

}
