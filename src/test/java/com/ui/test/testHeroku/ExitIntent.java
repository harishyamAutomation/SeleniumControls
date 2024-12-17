package com.ui.test.testHeroku;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;

import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.ExitIntentPage;
import com.ui.pages.testHeroku.IndexPage;

public class ExitIntent extends BaseTest {

//	private IndexPage indexInstance;
	private ExitIntentPage pageInstance;
	
//	public IndexPage getIndexPage() {
//		if(indexInstance==null) {
//			return new IndexPage(driver);
//		}
//		return indexInstance;
//	}
	
	public IndexPage getIndexPage() {
		return IndexPage.getIndexPage(driver);
	}
	
	public ExitIntentPage getPage() {
		if(pageInstance==null) {
			return new ExitIntentPage(driver);
		}
		return pageInstance;
	}
	
	@Test(description="Open App", priority=1, enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Exit Intent page", priority=2)
	public void openExitIntentPage() {
		getIndexPage().clickExitintent();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Validate to open intent on taking mouse out of view port of browser", priority=3)
	public void validateIntentOnMouseOutOfViewPort() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(0, 0);
		assertEquals(getPage().intentHeader.getText(), "THIS IS A MODAL WINDOW");
	}
	
	@Test(description="Validate to close the intent which opened on taking mouse out of view port of browser", dependsOnMethods = "validateIntentOnMouseOutOfViewPort", priority=4)
	public void validateCloseIntent() throws AWTException {
		getPage().closeIntent.click();
		assertEquals(getPage().exitIntentPageHeader.getText(), "Exit Intent");
	}
}
