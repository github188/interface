package com.megaeyes.access.common;

/**
 * 
 * @Title: AutoGeneratePassword.java
 * @Package com.megaeyes.access
 * @Description: 自动生成指定长度的密码
 * @author zhuanqi@megaeyes.com
 * @date 2012-8-30 下午01:31:55
 * @version V1.0
 */
public class AutoGeneratePassword {
	private static AutoGeneratePassword password;

	private AutoGeneratePassword() {

	}

	public static AutoGeneratePassword getInstance() {
		if (password == null) {
			password = new AutoGeneratePassword();
		}
		return password;
	}

	public String generatePassword(int length) {
		char[] cs = new char[length];
		int i = 0;
		do {
			cs[i] = generateCharRandom();
			if (cs[i] == 'l' || cs[i] == 'o' || cs[i] == '0' || cs[i] == '1')
				continue;
			i++;
		} while (i < length);
		return new String(cs);
	}

	private char generateCharRandom() {
		char p = 'a';
		int type = (int) (Math.random() * 2);
		if (type == 0) {
			p = (char) (48 + (int) (Math.random() * 10));
		} else {
			p = (char) (97 + (int) (Math.random() * 26));
		}
		return p;
	}

	public static void main(String[] args) {
		System.out.println(AutoGeneratePassword.getInstance().generatePassword(8));
	}
}
