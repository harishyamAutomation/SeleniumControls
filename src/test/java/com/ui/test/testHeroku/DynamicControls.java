package com.ui.test.testHeroku;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.DynamicControlsPage;
import com.ui.pages.testHeroku.IndexPage;

public class DynamicControls extends BaseTest {

	private DynamicControlsPage dynControlsInstance;
	private IndexPage indexInstance;

	IndexPage getIndexPage() {
		if(indexInstance==null) {
			return new IndexPage(driver);
		}
		return indexInstance;
	}
	
	DynamicControlsPage getPage() {
		if(dynControlsInstance==null) {
			return new DynamicControlsPage(driver);
		}
		return dynControlsInstance;
	}
	
	@Test(description="Open App", priority=1)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Dynamic Controls page", priority=2)
	public void openDynamicControlPage() {
		getIndexPage().clickDynamicctrl();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Add/Remove checkbox and validate message", invocationCount = 2, priority=3)
	public void addRemoveCheckbox() {
		try {
			if(getPage().checkBox.isDisplayed()) {	//It's not picking up the checkbox
				getPage().checkBox.click();
				System.out.println(">>> Removed!!");
				assertEquals(getPage().addRemoveCheckbox(), "It's gone!");
			}
		} catch (NoSuchElementException e) {
			System.out.println(">>> Added!!");
			assertEquals(getPage().addRemoveCheckbox(), "It's back!");
		}
	}
	
	@Test(description="Enable/Disable input field and validate message", invocationCount = 2, priority=4)
	public void enableDisableTextBox() {		
		if(getPage().textBox.isEnabled()) {
			assertEquals(getPage().enableDisableTextField(), "It's disabled!");
		}else {
			assertEquals(getPage().enableDisableTextField(), "It's enabled!");
		}
	}
	
	@Test(description="Input something in textbox", priority=5)
	public void inputTextinTextbox() {
		if(getPage().textBox.isEnabled()) {
			getPage().enterTextInTextBox("Enter Something...");
		}
	}
}
