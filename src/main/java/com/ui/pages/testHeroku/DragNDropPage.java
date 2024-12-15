package com.ui.pages.testHeroku;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragNDropPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public DragNDropPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	@FindBy(xpath="//div[@id='column-a']")
	public WebElement boxA;
	
	@FindBy(xpath="//div[@id='column-b']")
	public WebElement boxB;
	
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
}
