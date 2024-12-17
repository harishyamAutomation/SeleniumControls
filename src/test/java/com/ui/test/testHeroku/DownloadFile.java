package com.ui.test.testHeroku;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.DownloadFilePage;
import com.ui.pages.testHeroku.IndexPage;

public class DownloadFile extends BaseTest {

//	private IndexPage indexInstance;
	private DownloadFilePage pageInstance;
	
	public IndexPage getIndexPage() {
		return IndexPage.getIndexPage(driver);
	}
	
	public DownloadFilePage getPage() {
		if(pageInstance==null) {
			return new DownloadFilePage(driver);
		}
		return pageInstance;
	}
	
	@Test(description="Open App", priority=1, enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Download File page", priority=2)
	public void openExitIntentPage() {
		getIndexPage().clickFiledownload();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Download a file from the page", priority=3)
	public void downloadFile() {
		getPage().downloadLinks.get(2).click();
	}
	
	@Test(description="Download all file from the page", priority=4, enabled = false)
	public void downloadAllFile() {
		for(WebElement link:getPage().downloadLinks) {
			link.click();
			System.out.println(">>> File"+link.getText()+"Downloaded...!!");
		}
	}
}
