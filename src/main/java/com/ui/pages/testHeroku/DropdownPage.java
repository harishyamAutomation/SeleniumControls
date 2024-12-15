package com.ui.pages.testHeroku;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public DropdownPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	@FindBy(xpath="//select[@id='dropdown']")
	public WebElement selectDropdown;
	
	@FindBy(xpath="//select[@id='dropdown']/option")
	public List<WebElement> options;
	
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
}
