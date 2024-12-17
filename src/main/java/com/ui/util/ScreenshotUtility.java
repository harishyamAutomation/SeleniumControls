package com.ui.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	static TakesScreenshot takeScreenshot;
	public static void captureScreenshot(WebDriver driver, String screenShotName) {
		try {
			Thread.sleep(10000);
			if(takeScreenshot==null) {
				takeScreenshot = (TakesScreenshot) driver;
			}
			File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
			System.setProperty("org.uncommons.reportng.escape-output", "true");
			File destination = new File("target/OrangeHRM/"+screenShotName+".png");
			FileUtils.copyFile(source, destination);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Destination file path is incorrect");
		}
	}
}
