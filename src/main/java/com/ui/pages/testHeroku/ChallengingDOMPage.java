package com.ui.pages.testHeroku;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChallengingDOMPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ChallengingDOMPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	@FindBy(xpath="//div[@class='row']//a[@class='button']")
	public WebElement blueBtn;
	
	@FindBy(xpath="//div[@class='row']//a[@class='button alert']")
	public WebElement redBtn;
	
	@FindBy(xpath="//div[@class='row']//a[@class='button success']")
	public WebElement greenBtn;
	
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
}
