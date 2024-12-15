package com.ui.pages.testHeroku;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicAuthPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public BasicAuthPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	}
	
	@FindBy(xpath="//p[contains(text(),'Congratulations! You must have the proper credentials')]")
	public WebElement successMessage;
}
