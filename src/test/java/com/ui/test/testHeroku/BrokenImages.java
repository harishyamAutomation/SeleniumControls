package com.ui.test.testHeroku;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.BrokenImagesPage;
import com.ui.pages.testHeroku.IndexPage;

public class BrokenImages extends BaseTest{

	IndexPage getIndexPage() {
		return new IndexPage(driver);
	}
	
	BrokenImagesPage getPage() {
		return new BrokenImagesPage(driver);
	}
	
	@Test(description="Open the App", priority=1)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open the Broken Images Page", priority=2)
	
	public void openPage() {
		getIndexPage().clickBrokenimages();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Validate broken and clear images", priority=3)
	public void validateImageStatus() {
		assertFalse(getPage().isBrokenImage(getPage().brokenImage1));
		assertFalse(getPage().isBrokenImage(getPage().brokenImage2));
		assertTrue(getPage().isBrokenImage(getPage().clearImage));
	}
	
}
