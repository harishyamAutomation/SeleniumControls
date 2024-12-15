package com.ui.test.testHeroku;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.CheckboxesPage;
import com.ui.pages.testHeroku.IndexPage;

public class Checkboxes extends BaseTest{

	IndexPage getIndexPage() {
		return new IndexPage(driver);
	}
	
	CheckboxesPage getPage() {
		return new CheckboxesPage(driver);
	}
	
	@Test(description="Open App", priority=1)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Checkboxes page", priority=2)
	public void openCheckbnoxesPage() {
		getIndexPage().clickCheckboxes();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Validate first Checkboxes is checked or not", priority=3)
	public void validateFirstCheckbox() {
		assertFalse(getPage().firstCheckbox.isSelected());
	}
	
	@Test(description="Validate second Checkboxes is checked or not", priority=4)
	public void validateSecondCheckbox() {
		assertTrue(getPage().secondCheckbox.isSelected());
	}
	
	@Test(description="check the first checbox if it's not", priority=5)
	public void validateSelectFirstCheckbox() {
		if(!getPage().firstCheckbox.isSelected()) {
			getPage().firstCheckbox.click();
			assertTrue(getPage().firstCheckbox.isSelected());
		}
	}
	
	@Test(description="Uncheck the second checbox if it's not", priority=6)
	public void validateDeSelectSecondCheckbox() {
		if(!getPage().secondCheckbox.isSelected()) {
			getPage().secondCheckbox.click();
			assertFalse(getPage().secondCheckbox.isSelected());
		}
	}
}
