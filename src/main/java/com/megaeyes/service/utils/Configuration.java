package com.megaeyes.service.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 中心配置文件读取类
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-5-2 下午01:38:05
 */
public class Configuration {

	private static final Configuration configuration = new Configuration();
	private Map<String, String> map = new HashMap<String, String>();

	private String j2eeServerIp = null;
	private String j2eeServerPort = null;

	private Configuration() {
		// Singleton
	}

	public static Configuration getInstance() {
		return configuration;
	}

	/**
	 * 从config.properties配置文件中，查找指定属性的值
	 * 
	 * @param key
	 *            属性
	 * @return 值
	 */
	public String getProperties(String key) {
		if (null == map.get(key)) {
			try {
				String filePath = this.getClass().getClassLoader()
						.getResource("config.properties").getPath();

				Properties prop = new Properties();
				InputStream in = new BufferedInputStream(new FileInputStream(
						filePath));
				prop.load(in);
				in.close();
				String value = prop.getProperty(key);
				map.put(key, value);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return map.get(key);
	}

	/**
	 * 从platform_code_definition.properties配置文件中，获取指定前缀的资源类型
	 * 
	 * @param key
	 *            前缀
	 * @return 资源类型
	 */
	public String getPrefix(String key) {
		if (null == map.get(key)) {
			try {
				String filePath = this.getClass().getClassLoader()
						.getResource("platform_code_definition.properties")
						.getPath();

				Properties prop = new Properties();
				InputStream in = new BufferedInputStream(new FileInputStream(
						filePath));
				prop.load(in);
				in.close();
				String value = prop.getProperty(key);
				map.put(key, value);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map.get(key);
	}

	/**
	 * 获取本平台IP地址
	 * 
	 * @return
	 */
	public String getJ2eeServerIp() {
		if (this.j2eeServerIp != null) {
			return this.j2eeServerIp;
		}
		try {
			String filePath = this.getClass().getClassLoader()
					.getResource("config.properties").getPath();

			Properties prop = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			prop.load(in);
			in.close();
			this.j2eeServerIp = prop.getProperty("j2ee_server_ip");
			this.j2eeServerPort = prop.getProperty("j2ee_server_port");
			return this.j2eeServerIp;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取本平台HTTP端口
	 * 
	 * @return
	 */
	public String getJ2eeServerPort() {
		if (this.j2eeServerPort != null) {
			return this.j2eeServerPort;
		}
		try {
			String filePath = this.getClass().getClassLoader()
					.getResource("config.properties").getPath();

			Properties prop = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			prop.load(in);
			in.close();
			this.j2eeServerIp = prop.getProperty("j2ee_server_ip");
			this.j2eeServerPort = prop.getProperty("j2ee_server_port");
			return this.j2eeServerPort;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<String> getUpperPlatform() {
		List<String> results = new ArrayList();
		try {
			String filePath = this.getClass().getClassLoader()
					.getResource("upper_platform.properties").getPath();

			Properties prop = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			prop.load(in);
			in.close();
			Iterator iterator = prop.keySet().iterator();

			while (iterator.hasNext()) {
				results.add(prop.getProperty((String) iterator.next()));
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return results;
	}
}
