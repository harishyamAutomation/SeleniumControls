package com.ui.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.ui.enums.DriverType;

public class ConfigurationManager {

	public Properties properties;
	private static String propertyFile = "resources/configuration.properties";
	private static ConfigurationManager instance;
	
	 private ConfigurationManager() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFile))) {
	            properties = new Properties();
	            properties.load(reader);
	        } catch (IOException e) {
	            throw new RuntimeException("Properties file not found at: " + propertyFile, e);
	        }
	    }
	
	public static ConfigurationManager getConfigManager() {
		if(instance==null) {
			instance = new ConfigurationManager();
		}
		return instance;
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			return DriverType.CHROME;
		}else if(browserName.equalsIgnoreCase("firefox")) {
			return DriverType.FIREFOX;
		}else if (browserName.equalsIgnoreCase("edge")) {
			return DriverType.EDGE;
		}else {
			throw new RuntimeException("Please provide valid browser, Valid brwsers are : "+DriverType.CHROME+", "+DriverType.FIREFOX+", "+DriverType.EDGE);
		}
	}
	
}
