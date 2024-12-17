package com.ui.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ui.enums.DriverType;
import com.ui.util.PropertyReader;

public class DriverManager {
	
	private static WebDriver driver;
	private static DriverType driverType;
	private static DriverManager instance;
	//ConfigurationManager configurationManager = new ConfigurationManager();
	
//	public DriverManager() {
//		driverType = configurationManager.getBrowser();
//	}
	
	private DriverManager() {
		driverType = ConfigurationManager.getConfigManager().getBrowser();
	}
	
	public static DriverManager getDriverManager() {
		//driverType = ConfigurationManager.getConfigManager().getBrowser();
		if(instance==null) {
			instance = new DriverManager();
		}
		return instance;
	}
	
	public WebDriver getDriver() {
		//System.out.println("************************ Driver *************************"+ConfigurationManager.properties.getProperty("firefox.driver.path"));
		if(driver==null) {
			driver = createDriver();
		}
		return driver;
	}
	
	private static WebDriver createDriver() {
		switch(driverType) {
		case FIREFOX:
			System.setProperty("webdriver.firefox.driver", ConfigurationManager.getConfigManager().properties.getProperty("firefox.driver.path"));
			FirefoxOptions fireFoxOptions = new FirefoxOptions();
			fireFoxOptions.setAcceptInsecureCerts(true);
			fireFoxOptions.addArguments("use-fake-ui-for-media-stream");
			fireFoxOptions.addPreference("media.navigator.permission.disabled", true);
			driver  = new FirefoxDriver(fireFoxOptions);
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", ConfigurationManager.getConfigManager().properties.getProperty("chrome.driver.path"));
			
			if(new File(PropertyReader.getProperty("downloadDirPath")).exists()) {
				System.out.println("** DOWNLOAD DIR ** "+PropertyReader.getProperty("downloadDirPath"));
			}else {
				throw new RuntimeException("Download dir not found");
			}
			
			//Download Files prefs
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("download.default_directory", PropertyReader.getProperty("downloadDirPath"));
			prefs.put("download.prompt_for_download", false); //Disable download prompt
			prefs.put("download.directory_upgrade", true);
			prefs.put("savefile.default_directory", PropertyReader.getProperty("downloadDirPath"));
			prefs.put("plugins.always_open_pdf_externallhy", true); //Bypass PDF viewer
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setAcceptInsecureCerts(true);
			chromeOptions.addArguments("use-fake-ui-for-media-stream");
			chromeOptions.setExperimentalOption("prefs", prefs);
			
			driver = new ChromeDriver(chromeOptions);
			break;
		case EDGE:
			System.setProperty("webdriver.edge.driver", ConfigurationManager.getConfigManager().properties.getProperty("edge.driver.path"));
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setAcceptInsecureCerts(true);
			edgeOptions.addArguments("use-fake-ui-for-media-stream");
			driver = new EdgeDriver(edgeOptions);
			break;
		default:
			System.setProperty("webdriver.chrome.driver", ConfigurationManager.getConfigManager().properties.getProperty("chrome.driver.path"));
			driver = new ChromeDriver();				
		}
		return driver;
	}
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}
}
