package com.ui.core;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ui.helper.BaseTestHelper;
import com.ui.pages.testHeroku.IndexPage;
import com.ui.util.ExtentReport;
import com.ui.util.PropertyReader;
import com.ui.util.ScreenshotUtility;

public class BaseTest {
	
	private static ThreadLocal<ExtentTest> extentTest;
	
	public static ThreadLocal<ExtentTest> getTest(){
		if(extentTest==null) {
			extentTest = new ThreadLocal<ExtentTest>();
		}
		return extentTest;
	}
	
	protected WebDriver driver = DriverManager.getDriverManager().getDriver();
	//DriverManager driverManager = new DriverManager();
	
	@BeforeSuite(alwaysRun = true)
	public void config(@Optional("Optional name Automation") String reportName, @Optional("Optional Report") String flow) {
		//driver = DriverManager.getDriverManager().getDriver();
		//IndexPage ip = new IndexPage(driver);
		
		String folderPath = System.getProperty("user.dir")+"/reports/"+BaseTestHelper.currentDate();
		BaseTestHelper.createFolder(folderPath);
		
		ExtentReport.getInstance().initialize(folderPath+"/"+BaseTestHelper.timeStamp()+"SeleniumControls.html");
		
		IndexPage.getIndexPage(driver).launchPage();
	}
	
	@BeforeClass
	public void beforeClass() {
		//IndexPage.getIndexPage(driver).launchPage();
	}
	
	@BeforeTest
	public void beforeTest() {
		//driver = driverManager.getDriver();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		//driver.manage().deleteAllCookies();
		Test annotation = method.getAnnotation(Test.class);
		String desc = annotation.description()==null?"":annotation.description();
		ExtentReport.startTest(method.getName(), "<b>Description</b> : "+desc+"<hr style='margin:0.1%;'/> ");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			ExtentReport.getTest().generateLog(Status.PASS, result.getName()+" : "+result.getMethod().getDescription()+" has been <b style='color:green'>PASSED</b>");
		}else if(result.getStatus()==ITestResult.FAILURE) {
			ExtentReport.getTest().generateLog(Status.FAIL, result.getName()+" : "+result.getMethod().getDescription()+" has been <b style='color:red'>FAILED</b></br>due to<br/>"+result.getThrowable());
		}else if(result.getStatus()==ITestResult.SKIP) {
			ExtentReport.getTest().generateLog(Status.SKIP, result.getName()+" : "+result.getMethod().getDescription()+" has been <b style='color:blue'>SKIPPED</b>");
		}
		
		String testCaseID = "_";
		
		try {
			testCaseID += result.getParameters()[0].toString();
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			//testCaseID += result.getMethod().getMethodName().toString();
			testCaseID = "";
		}		
		
		String methodName = (result.getMethod().getMethodName()).concat(testCaseID.concat("_"+BaseTestHelper.timeStamp()));
		System.out.println("Method : "+methodName);
		ScreenshotUtility.captureScreenshot(driver, methodName);
	}
	
	@AfterClass
	public void afterClass() {
		//driverManager.quitDriver();
		driver.get(PropertyReader.getProperty("url"));
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentReport.getInstance().flush();
		DriverManager.getDriverManager().quitDriver();
	}
	
	public void endReport() {
		System.out.println("Close Report");
	}
}
