package com.ui.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.ui.enums.DriverType;

public class ConfigurationManager {

	public Properties properties;
	String propertyFile = "resources/configuration.properties";
	
	public ConfigurationManager() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFile));
			properties = new Properties();
			
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Properties file not found at the location : "+propertyFile);
		}
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
