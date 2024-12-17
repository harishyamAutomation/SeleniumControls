package com.ui.test.testHeroku;

import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.IndexPage;
import com.ui.util.SoftAssertionUtil;

public class Index extends BaseTest{
	
//	IndexPage getIndexPage() {
//		return new IndexPage(driver);
//	}
	
	IndexPage getIndexPage() {
		//return new IndexPage(driver); //removed driver parameter
		return IndexPage.getIndexPage(driver);
	}

	@Test(description = "Open the Test Heroku App", priority=1, groups="somkeTest", enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description = "Verify All Elements", priority=2, groups="somkeTest")
	public void verifyAllElements() {
		//IndexPage ip = new IndexPage(driver);
		getIndexPage().verifyAllElement();
	}
	
	@Test(description = "Validate A/B Test Link", priority=3)
	public void validateABTest() {
		getIndexPage().clickABTesting();
		SoftAssertionUtil.customAssertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/abtest");
	}
}
