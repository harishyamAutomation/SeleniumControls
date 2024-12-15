package com.ui.core;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.ui.util.ScreenshotUtility;

public class BaseTest {
	
	protected WebDriver driver;
	DriverManager driverManager = new DriverManager();
	
	@BeforeSuite
	public void config(@Optional("Optional name Automation") String reportName, @Optional("Optional Report") String flow) {
		
	}
	
	@BeforeTest
	public void beforeTest() {
		driver = driverManager.getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		//driver.manage().deleteAllCookies();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			
		}else if(result.getStatus()==ITestResult.FAILURE) {
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			
		}
		
		String testCaseID = "_";
		
		try {
			testCaseID += result.getParameters()[0].toString();
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			testCaseID += result.getMethod().getMethodName().toString();
		}		
		
		String methodName = (result.getMethod().getMethodName()).concat(testCaseID.concat("_"+String.valueOf(System.currentTimeMillis())));
		System.out.println("Method : "+methodName);
		ScreenshotUtility.captureScreenshot(driver, methodName);
	}
	
	@AfterTest
	public void afterTest() {
		driverManager.quitDriver();
	}
	
	public void endReport() {
		System.out.println("Close Report");
	}
}
