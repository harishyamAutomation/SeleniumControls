package com.ui.pages.testHeroku;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxesPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public CheckboxesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	@FindBy(xpath="//form[@id='checkboxes']/input[1]")
	public WebElement firstCheckbox;
	
	@FindBy(xpath="//form[@id='checkboxes']/input[2]")
	public WebElement secondCheckbox;
	
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
}
