package com.ui.test.testHeroku;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.AddRemoveElePage;
import com.ui.pages.testHeroku.IndexPage;

public class AddRemoveEle extends BaseTest {

	AddRemoveElePage getAddRemoveElePage() {
		return new AddRemoveElePage(driver); //removed driver parameter
	}
	
	IndexPage getIndexPage() {
		//return new IndexPage(driver); //removed driver parameter
		return IndexPage.getIndexPage(driver);
	}
	
	@Test(description="Open the App", priority=1, enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Add Remove Element link", priority=2)
	public void openAddRemoveLink() {
		getIndexPage().clickAddremoveelements();
		assertTrue(getAddRemoveElePage().addRemoveHeader.isDisplayed());
	}
	
	@Test(description="Verify Add Elemennt", priority=3)
	public void verifyAddElement() {
		getAddRemoveElePage().addElement();
		assertTrue(getAddRemoveElePage().isElementAdded());
		
	}
	
	@Test(description="Verify Remove Element", priority=4)
	public void verifyRemoveElement() {
		getAddRemoveElePage().removeElement();
		assertTrue(getAddRemoveElePage().isElementRemoved());
		
	}
	
	@Test(description="Verify Multiple Add Elements", priority=5)
	public void verifyMultipleAddElement() {
		int count=1;
		for(int i=count; i<=5; i++, count++) {
			getAddRemoveElePage().addElement();
		}
		assertEquals(getAddRemoveElePage().deleteAllElements.size(), count-1);	
	}
	
	@Test(description="Verify Remove All Elements", priority=6, enabled=false)
	public void verifyRemoveAllElements() throws AWTException {
		assertTrue(getAddRemoveElePage().deleteAllAddedElements());
		//driver.navigate().to(PropertyReader.getProperty("url"));
	}
	
}
