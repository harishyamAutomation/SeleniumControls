package com.ui.util;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	private static ExtentReport instance;
	private static ExtentReports extentReport;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	private ExtentReport() {
		
	}
	
	public static ExtentReport getInstance() {
		if(instance==null) {
			instance = new ExtentReport();
		}
		return instance;
	}
	
	public synchronized void initialize(String extentReportFilePath) {
		extentReport = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFilePath);
		
		try {
			sparkReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/resources/extent-config.xml"));
			extentReport.attachReporter(sparkReporter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		//Get the resolution
		
		DisplayMode dp = gd.getDisplayMode();
		int screenWidth = dp.getWidth();
		int screenHeight = dp.getHeight();
		
		extentReport.setSystemInfo("Product", "Selenium Controls");
		extentReport.setSystemInfo("Host", "Harishyam Sharma");
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Resolution", screenWidth+"x"+screenHeight);
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		System.out.println(">>> Initialized");
	}
	
	public static void startTest(String testName, String testDescription) {
		if(extentReport!=null) {
			ExtentTest test = extentReport.createTest(testName, testDescription);
			extentTest.set(test);
		}else {
			throw new IllegalStateException("ExtentReports is not initialized. Call initialize() first.");
		}
	}
	
	public static ExtentTest getTest() {
		ExtentTest test = extentTest.get();
		if(test==null) {
			throw new IllegalStateException("No test started. Call startTest() before logging.");
		}
		return test;
				
	}
	
	public void flush() {
		if(extentReport!=null) {
			extentReport.flush();
		}
	}
}
