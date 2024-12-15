package com.ui.pages.testHeroku;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public DynamicLoadingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	public void waitForAttrToDisappear(WebDriver driver, final WebElement element, final String attributeName, int timeOutInSec) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOutInSec));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				String attrValue = element.getAttribute(attributeName);
				return attrValue=="";
			}
		});
	}
	
	public String getMsgFromFirstLink() {
		System.out.println(">>> "+msgAfterAdd.findElement(By.xpath("./.."))+", Tag Name : "+msgAfterAdd.findElement(By.xpath("./..")).getTagName());
		waitForAttrToDisappear(driver, msgAfterAdd.findElement(By.xpath("./..")), "style", 10);
		return msgAfterAdd.getText();
	}
	
	public String getMsgFromSecondLink() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(msgAfterAdd));
		return msgAfterAdd.getText();
	}
	
	@FindBy(xpath="//a[contains(@href, '/dynamic_loading/1')]")
	public WebElement linkElementOnPage;
	
	@FindBy(xpath="//a[contains(@href, '/dynamic_loading/2')]")
	public WebElement linkElementRendered;
	
	@FindBy(xpath="//div[@id='start']/button")
	public WebElement startBtnOnFirstLink, startBtnOnSecondLink;
	
	@FindBy(xpath="//div[@id='finish']/h4")
	public WebElement msgAfterAdd;
		
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
}
