package com.ui.test.testHeroku;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.ChallengingDOMPage;
import com.ui.pages.testHeroku.IndexPage;
import com.ui.util.HighlightUtil;

//Need to test canvas present on the page in future

public class ChallengingDOM extends BaseTest{

	IndexPage getIndexPage() {
		//return new IndexPage(driver);
		return IndexPage.getIndexPage(driver);
	}
	
	ChallengingDOMPage getPage() {
		return new ChallengingDOMPage(driver);
	}
	
	@Test(description="Open App", priority=1, enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open challenging dom page", priority=2)
	public void openChallengingDOmPage() {
		getIndexPage().clickChanllengingdom();
	}
	
	@Test(description="Vallidate to click blue button", priority=3)
	public void validateBlueButton() {
		boolean status = false;
		if(getPage().blueBtn.isDisplayed() & getPage().blueBtn.isEnabled()) {
			HighlightUtil.highlighElement(driver, getPage().blueBtn);
			getPage().blueBtn.click();
			status=true;
		}
		assertTrue(status);
	}
	
	@Test(description="Vallidate to click red button", priority=4)
	public void validateRedButton() {
		boolean status = false;
		if(getPage().redBtn.isDisplayed() & getPage().redBtn.isEnabled()) {
			HighlightUtil.highlighElement(driver, getPage().redBtn);
			getPage().redBtn.click();
			status=true;
		}
		assertTrue(status);
	}
	
	@Test(description="Vallidate to click green button", priority=5)
	public void validateGreenButton() {
		boolean status = false;
		if(getPage().greenBtn.isDisplayed() & getPage().greenBtn.isEnabled()) {
			HighlightUtil.highlighElement(driver, getPage().greenBtn);
			getPage().greenBtn.click();
			status=true;
		}
		assertTrue(status);
	}
}
