package com.ui.test.testHeroku;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.DynamicLoadingPage;
import com.ui.pages.testHeroku.IndexPage;

public class DynamicLoading extends BaseTest {

	private IndexPage indexInstance;
	private DynamicLoadingPage pageInstance;
	
	public IndexPage getIndexPage() {
		if(indexInstance==null) {
			return new IndexPage(driver);
		}
		return indexInstance;
	}
	
	public DynamicLoadingPage getPage() {
		if(pageInstance==null) {
			return new DynamicLoadingPage(driver);
		}
		return pageInstance;
	}
	
	@Test(description="Open App", priority=1)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Dynamic Loading page", priority=2)
	public void openDynamicContentPage() {
		getIndexPage().clickDynamicloading();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Validate the first link of dynamic loading page", priority=3)
	public void validateFirstLinkOnPage() {
		getPage().linkElementOnPage.click();
		assertTrue(getPage().startBtnOnFirstLink.isDisplayed() & getPage().startBtnOnFirstLink.isEnabled());
	}
	
	@Test(description="Validate Start button on the first link of dynamic loading", priority=4)
	public void validateStartBtnfromFirstLink() {
		assertTrue(getPage().startBtnOnFirstLink.isDisplayed() & getPage().startBtnOnFirstLink.isEnabled());
	}
	
	@Test(description="Validate hidden text on click of Start btn on the first link", dependsOnMethods = "validateStartBtnfromFirstLink", priority=5)
	public void fetchHiddenTextOnPage() {
		getPage().startBtnOnFirstLink.click();
		assertEquals(getPage().getMsgFromFirstLink(), "Hello World!");
		driver.navigate().back();
	}
	
	@Test(description="Validate the second link of dynamic loading page", priority=6)
	public void validateSecondLinkOnPage() {
		getPage().linkElementRendered.click();
		assertTrue(getPage().startBtnOnSecondLink.isDisplayed() & getPage().startBtnOnSecondLink.isEnabled());
	}
	
	@Test(description="Validate Start button on the second link of dynamic loading", priority=7)
	public void validateStartBtnfromSecondLink() {
		assertTrue(getPage().startBtnOnSecondLink.isDisplayed() & getPage().startBtnOnSecondLink.isEnabled());
	}
	
	@Test(description="Validate rendered text on click of Start btn on the second link", dependsOnMethods = "validateStartBtnfromSecondLink", priority=8)
	public void fetchHiddenTextOnPageAfterItRendered() {
		getPage().startBtnOnSecondLink.click();
		assertEquals(getPage().getMsgFromSecondLink(), "Hello World!");
	}
	
}
