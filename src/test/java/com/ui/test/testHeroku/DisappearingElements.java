package com.ui.test.testHeroku;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.DisappearingElementsPage;
import com.ui.pages.testHeroku.IndexPage;

public class DisappearingElements extends BaseTest{

//	IndexPage getIndexPage() {
//		return new IndexPage(driver);
//	}
	
	public IndexPage getIndexPage() {
		return IndexPage.getIndexPage(driver);
	}
	
	DisappearingElementsPage getPage() {
		return new DisappearingElementsPage(driver);
	}
	
	@Test(description="Open App", priority=1, enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Disappearing element page", priority=2)
	public void openDisAppElementPage() {
		getIndexPage().clickDisappearingelements();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Get all the navigation links", priority=3)
	public void getAllLinksOnthePage() {
		for (WebElement element : getPage().allLinks) {
			System.out.print("\tElement: "+element.getText());
		}
	}
	
	@Test(description="Click on Gallery if it appears", invocationCount = 3, priority=4)
	public void clickGallery() {
			try {
				for(int i=0; i<3; i++) {
					List<WebElement> allLinks = getPage().allLinks;
					int size = allLinks.size();
					if(allLinks.get(size-1).getText().equals("Gallery")) {
						System.out.println("Tag : "+allLinks.get(size-1).getText());
						System.out.println("Size : "+allLinks.size());
						allLinks.get(size-1).click();
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait.until(ExpectedConditions.visibilityOf(getPage().galleryResponse));
						System.out.println(driver.getCurrentUrl()+", response : "+getPage().galleryResponse.getText());
						assertTrue(getPage().galleryResponse.getText().equals("Not Found"));
						driver.navigate().back();
						break;
					}else {
						System.out.println("Gallery link not found, refreshing the page....");
						driver.navigate().refresh();
						allLinks = getPage().allLinks;
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Gallery link not found, after multiple attempts");
			}
		}
	}
