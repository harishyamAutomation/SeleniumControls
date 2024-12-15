package com.ui.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private static Properties properties;
	private static String propertyFile = "resources/configuration.properties";
	
	public static String getProperty(String key) {
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
		return (String) properties.get(key);
	}
	
	public static String getProperty(String filePath, String key) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
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
			throw new RuntimeException("Properties file not found at the location : "+filePath);
		}
		return (String) properties.get(key);
	}
}
