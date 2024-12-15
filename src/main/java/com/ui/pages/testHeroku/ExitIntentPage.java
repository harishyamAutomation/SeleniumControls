package com.ui.pages.testHeroku;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExitIntentPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ExitIntentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	@FindBy(xpath="//div[@id='ouibounce-modal']//div[contains(@class, 'modal-title')]/h3")
	public WebElement intentHeader;
	
	@FindBy(xpath="//div[@id='ouibounce-modal']//div[contains(@class, 'modal-footer')]/p")
	public WebElement closeIntent;
	
	@FindBy(xpath="//div[@id='content']/div/h3")
	public WebElement exitIntentPageHeader;
		
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
}
