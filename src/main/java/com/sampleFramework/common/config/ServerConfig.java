package com.sampleFramework.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerConfig {
	
	private static ServerConfig instance = null;
	private static final String SERVER_CONFIG_FILE = "properties/globals.properties";
	private static Properties properties = null;
	private static String SERVER_MODE = null;
	
	private static final String SAMPLE_SERVER_MODE = "server.mode";
	private static final String DEFAULT_SERVER_MODE = "P";
	public static final String SERVER_MODE_DEV = "D";
	public static final String SERVER_MODE_STAGING = "S";
	public static final String SERVER_MODE_PRODUCTION = "P";
	
	public static ServerConfig getInstance() {
		if ( instance == null ) {
			synchronized ( ServerConfig.class ) {
				if ( instance == null ) {
					instance = new ServerConfig();
				}
			}
		}
		
		return instance;
	}
	
	private ServerConfig() {
		init();
	}
	
	private void init() {
		try {
			loadProperties();
			SERVER_MODE = getProperty(SAMPLE_SERVER_MODE, DEFAULT_SERVER_MODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadProperties() {
		InputStream inputStream = null;
		
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(SERVER_CONFIG_FILE);
			
			if ( inputStream != null ) {
				properties = new Properties();
				properties.load(inputStream);
				
				inputStream.close();
			} else {
				System.out.println("not found config file. [serverconfig.properties]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if ( inputStream != null ) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private String getProperty(String property, String defaultValue) {
		return properties.getProperty(property, defaultValue);
	}

	public String getServerMode() {
		return SERVER_MODE;
	}
	
}
