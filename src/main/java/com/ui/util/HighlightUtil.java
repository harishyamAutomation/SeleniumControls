package com.ui.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightUtil {
	public static void highlighElement(WebDriver driver, WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].style.border='2px dashed red'", element);
	     
	     // Wait for a moment to show the highlight (optional, for visual purposes)
	        try {
	            Thread.sleep(500); // 500 ms delay
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}
	
	public static void deHighlighElement(WebDriver driver, WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].style.border='none'", element);
	}
}
