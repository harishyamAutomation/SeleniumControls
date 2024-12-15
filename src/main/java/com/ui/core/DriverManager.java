package com.ui.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ui.enums.DriverType;

public class DriverManager {
	
	WebDriver driver;
	private static DriverType driverType;
	ConfigurationManager configurationManager = new ConfigurationManager();
	
	public DriverManager() {
		driverType = configurationManager.getBrowser();
	}
	
	public WebDriver getDriver() {
		System.out.println("************************ Driver *************************"+configurationManager.properties.getProperty("firefox.driver.path"));
		if(driver==null) {
			driver = createDriver();
		}
		return driver;
	}
	
	private WebDriver createDriver() {
		switch(driverType) {
		case FIREFOX:
			System.setProperty("webdriver.firefox.driver", configurationManager.properties.getProperty("firefox.driver.path"));
			FirefoxOptions fireFoxOptions = new FirefoxOptions();
			fireFoxOptions.setAcceptInsecureCerts(true);
			fireFoxOptions.addArguments("use-fake-ui-for-media-stream");
			fireFoxOptions.addPreference("media.navigator.permission.disabled", true);
			driver  = new FirefoxDriver(fireFoxOptions);
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", configurationManager.properties.getProperty("chrome.driver.path"));
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setAcceptInsecureCerts(true);
			chromeOptions.addArguments("use-fake-ui-for-media-stream");
			driver = new ChromeDriver(chromeOptions);
			break;
		case EDGE:
			System.setProperty("webdriver.edge.driver", configurationManager.properties.getProperty("edge.driver.path"));
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setAcceptInsecureCerts(true);
			edgeOptions.addArguments("use-fake-ui-for-media-stream");
			driver = new EdgeDriver(edgeOptions);
			break;
		default:
			System.setProperty("webdriver.chrome.driver", configurationManager.properties.getProperty("chrome.driver.path"));
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
