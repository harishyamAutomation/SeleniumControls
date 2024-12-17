package com.ui.test.testHeroku;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.DropdownPage;
import com.ui.pages.testHeroku.IndexPage;

public class Dropdown extends BaseTest {

	private DropdownPage dropdownInstance;
	//private IndexPage indexInstance;

//	IndexPage getIndexPage() {
//		if(indexInstance==null) {
//			return new IndexPage(driver);
//		}
//		return indexInstance;
//	}
	
	public IndexPage getIndexPage() {
		return IndexPage.getIndexPage(driver);
	}
	
	DropdownPage getPage() {
		if(dropdownInstance==null) {
			return new DropdownPage(driver);
		}
		return dropdownInstance;
	}
	
	@Test(description="Open App", priority=1, enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Dropdown page", priority=2)
	public void openDropdownPage() {
		getIndexPage().clickDropdown();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Select first value from dropdown", priority=3)
	public void selectOpion1() {
		Select select = new Select(getPage().selectDropdown);
		String opt1 = getPage().options.get(1).getText();
		select.selectByVisibleText(opt1);
		assertTrue(select.getFirstSelectedOption().getText().equals(opt1));
		
	}
	
	@Test(description="Select second value from dropdown", priority=4)
	public void selectOpion2() {
		Select select = new Select(getPage().selectDropdown);
		String opt1 = getPage().options.get(2).getText();
		select.selectByVisibleText(opt1);
		assertTrue(select.getFirstSelectedOption().getText().equals(opt1));
		
	}
}
