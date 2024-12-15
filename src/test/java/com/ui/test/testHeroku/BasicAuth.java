package com.ui.test.testHeroku;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.BasicAuthPage;
import com.ui.pages.testHeroku.IndexPage;
import com.ui.util.PropertyReader;

public class BasicAuth extends BaseTest{

	BasicAuthPage getBasicAuthPage() {
		return new BasicAuthPage(driver);
	}
	
	IndexPage getIndexPage() {
		return new IndexPage(driver);
	}
	
	@Test(description="Open Index Page", priority=1)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Click on Basic Auth and authenticate the user", priority=2)
	public void validateBasicAuth() throws InterruptedException, AWTException {
		
		getIndexPage().clickBasicauth();
		Thread.sleep(1000);
		Robot keyBoard = new Robot();
		
			//Enter username
			keyBoard.keyPress(KeyEvent.VK_A);	//a
			keyBoard.keyRelease(KeyEvent.VK_A);
			keyBoard.keyPress(KeyEvent.VK_D);	//d
			keyBoard.keyRelease(KeyEvent.VK_D);
			keyBoard.keyPress(KeyEvent.VK_M);	//m
			keyBoard.keyRelease(KeyEvent.VK_M);
			keyBoard.keyPress(KeyEvent.VK_I);	//i
			keyBoard.keyRelease(KeyEvent.VK_I);
			keyBoard.keyPress(KeyEvent.VK_N);	//n
			keyBoard.keyRelease(KeyEvent.VK_N);
			
			//Press Tab
			keyBoard.keyPress(KeyEvent.VK_TAB);
			keyBoard.keyRelease(KeyEvent.VK_TAB);
			
			//Enter password
			keyBoard.keyPress(KeyEvent.VK_A);	//a
			keyBoard.keyRelease(KeyEvent.VK_A);
			keyBoard.keyPress(KeyEvent.VK_D);	//d
			keyBoard.keyRelease(KeyEvent.VK_D);
			keyBoard.keyPress(KeyEvent.VK_M);	//m
			keyBoard.keyRelease(KeyEvent.VK_M);
			keyBoard.keyPress(KeyEvent.VK_I);	//i
			keyBoard.keyRelease(KeyEvent.VK_I);
			keyBoard.keyPress(KeyEvent.VK_N);	//n
			keyBoard.keyRelease(KeyEvent.VK_N);
			
			//Press Enter
			keyBoard.keyPress(KeyEvent.VK_ENTER);
			keyBoard.keyRelease(KeyEvent.VK_ENTER);
			
			assertEquals(getBasicAuthPage().successMessage.getText(), "Congratulations! You must have the proper credentials.");
			driver.navigate().to(PropertyReader.getProperty("url"));
	}
}
