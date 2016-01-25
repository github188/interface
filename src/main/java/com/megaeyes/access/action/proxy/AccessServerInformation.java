package com.megaeyes.access.action.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.megaeyes.access.exception.ExceptionHandler;

public class AccessServerInformation {
	// 配置文件
	static public final String PROPERTY_FILE = "megaeyes_access_server_info.properties";

	static private transient Log Logger = LogFactory.getLog(AccessServerInformation.class);

	// private
	static private Properties _config = null;

	static private long _lastModified = 0;

	// method
	public static  void reloadConfiguration() {
		// 查找配置文件
		Class thisClass = AccessServerInformation.class;

		URL fileURL = thisClass.getClassLoader().getResource(PROPERTY_FILE);

		File file = new File(fileURL.getFile());

		long fileLastModified = file.lastModified();

		synchronized (thisClass) {
			if (fileLastModified != _lastModified) // 第一次读配置，或配置文件被修改了
			{

				Logger.info("Config file [" + file + "] be modified, reload it ...");

				// 读取配置信息
				Properties prop = new Properties();
				InputStream is = null;
				try {
					is = new FileInputStream(file);
					prop.load(is);
				} catch (FileNotFoundException fnfe) {
					ExceptionHandler.throwRuntimeException(fnfe);
				} catch (IOException ioe) {
					ExceptionHandler.throwRuntimeException(ioe);
				} finally {
					if (is != null) {
						try {
							is.close();
						} catch (Exception e) {
						}
					}
				}

				// 保持配置信息
				_config = prop;
				_lastModified = fileLastModified;
				Logger.info("Config file [" + file + "] reload over.");
			}
		}
	}

	public static String getProperty(String key) {
		return _config.getProperty(key);
	}

}