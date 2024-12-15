package com.ui.pages.testHeroku;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicContentPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public DynamicContentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	@FindBy(xpath="//div[contains(@class, 'example')]//div[@id='content']/div[1]/div/img")
	public WebElement imgFromFirstRow;
	
	@FindBy(xpath="//div[contains(@class, 'example')]//div[@id='content']/div[1]/div[contains(@class, 'large-10 columns')]")
	public WebElement textFromFirstRow;
	
	@FindBy(xpath="//div[contains(@class, 'example')]//div[@id='content']/div[2]/div/img")
	public WebElement imgFromSecondRow;
	
	@FindBy(xpath="//div[contains(@class, 'example')]//div[@id='content']/div[2]/div[contains(@class, 'large-10 columns')]")
	public WebElement textFromSecondRow;
	
	@FindBy(xpath="//div[contains(@class, 'example')]//div[@id='content']/div[3]/div/img")
	public WebElement imgFromThirdRow;
	
	@FindBy(xpath="//div[contains(@class, 'example')]//div[@id='content']/div[3]/div[contains(@class, 'large-10 columns')]")
	public WebElement textFromThirdRow;
	
	@FindBy(xpath="//select[@id='dropdown']/option")
	public List<WebElement> options;
	
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
	
}
