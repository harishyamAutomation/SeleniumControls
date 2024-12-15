package com.ui.test.testHeroku;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.ContextMenuPage;
import com.ui.pages.testHeroku.IndexPage;

public class ContextMenu extends BaseTest{

	IndexPage getIndexPage() {
		return new IndexPage(driver);
	}
	
	ContextMenuPage getPage() {
		return new ContextMenuPage(driver);
	}
	
	@Test(description="Open App", priority=1)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Context Menu page", priority=2)
	public void openCheckbnoxesPage() {
		getIndexPage().clickContextmenu();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description = "Right click on the div", priority = 3)
	public void clickContextMenu() throws InterruptedException {
	    Actions action = new Actions(driver);
	    
	    // Perform right-click on the context menu
	    action.contextClick(getPage().contextMenu).perform();

	    // Wait for the alert to be present
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    // Interact with the alert
	    String actualText = alert.getText();
	    alert.accept();
	    getPage().contextMenu.click();
	    assertEquals(actualText, "You selected a context menu");
	}
	
	@Test(description="Navigate back by click on back on the context menu", priority=4)
	public void clickBackOnContextMenu() throws AWTException {
		Actions action = new Actions(driver);
		action.contextClick(getPage().contextMenu).perform();
		
		// Wait for the alert to be present
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    alert.accept();
		
	    Robot key = new Robot();
	    key.keyPress(KeyEvent.VK_ESCAPE);
	    key.keyRelease(KeyEvent.VK_ESCAPE);
	    
		driver.navigate().back();
		
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	//You selected a context menu
	
}
