package com.ui.test.testHeroku;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.DynamicContentPage;
import com.ui.pages.testHeroku.IndexPage;
import com.ui.util.HighlightUtil;

public class DynamicContent extends BaseTest {

	private DynamicContentPage dynContentInstance;
//	private IndexPage indexInstance;

//	IndexPage getIndexPage() {
//		if(indexInstance==null) {
//			return new IndexPage(driver);
//		}
//		return indexInstance;
//	}
	
	public IndexPage getIndexPage() {
		return IndexPage.getIndexPage(driver);
	}
	
	DynamicContentPage getPage() {
		if(dynContentInstance==null) {
			return new DynamicContentPage(driver);
		}
		return dynContentInstance;
	}
	
	@Test(description="Open App", priority=1, enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Dynamic Content page", priority=2)
	public void openDynamicContentPage() {
		getIndexPage().clickDynamiccontent();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Validate Image from first row", priority=3)
	public void validateImagefromFirstRow() {
		WebElement img = getPage().imgFromFirstRow;
		assertTrue(img.isDisplayed());
		HighlightUtil.highlighElement(driver, img);
		System.out.println("First Image src : "+img.getAttribute("src"));
	}
	
	@Test(description="Validate Text from first row", priority=4)
	public void validateTextfromFirstRow() {
		WebElement text = getPage().textFromFirstRow;
		assertTrue(text.isDisplayed());
		HighlightUtil.highlighElement(driver, text);
		System.out.println("Text for first row : "+text.getText());
	}
	
	@Test(description="Validate Image from Second row", priority=5)
	public void validateImagefromSecondRow() {
		WebElement img = getPage().imgFromSecondRow;
		assertTrue(img.isDisplayed());
		HighlightUtil.highlighElement(driver, img);
		System.out.println("Second Image src : "+img.getAttribute("src"));
	}
	
	@Test(description="Validate Text from second row", priority=6)
	public void validateTextfromSecondRow() {
		WebElement text = getPage().textFromSecondRow;
		assertTrue(text.isDisplayed());
		HighlightUtil.highlighElement(driver, text);
		System.out.println("Text for second row : "+text.getText());
	}
	
	@Test(description="Validate Image from third row", priority=7)
	public void validateImagefromThirdRow() {
		WebElement img = getPage().imgFromThirdRow;
		assertTrue(img.isDisplayed());
		HighlightUtil.highlighElement(driver, img);
		System.out.println("Third Image src : "+img.getAttribute("src"));
	}
	
	@Test(description="Validate Text from third row", priority=8)
	public void validateTextfromThirdRow() {
		WebElement text = getPage().textFromThirdRow;
		assertTrue(text.isDisplayed());
		HighlightUtil.highlighElement(driver, text);
		System.out.println("Text for third row : "+text.getText());
	}
}
