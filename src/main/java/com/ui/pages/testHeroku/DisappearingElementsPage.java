package com.ui.pages.testHeroku;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisappearingElementsPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public DisappearingElementsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	@FindBy(xpath="//div[@id='content']//li/a")
	public List<WebElement> allLinks;
	
	@FindBy(xpath="//h1[normalize-space()='Not Found']")
	public WebElement galleryResponse;
	
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
}
