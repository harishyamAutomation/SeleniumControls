package com.ui.pages.testHeroku;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenImagesPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public BrokenImagesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
	}
	
	public void countBrokenImages(List<WebElement> imgs){
		System.out.println();
	}
	
	public boolean isBrokenImage(WebElement element) {
		//String host = PropertyReader.getProperty("url");
		String url = element.getAttribute("src");
		String parentTab = driver.getWindowHandle();
		
		System.out.println(">>> URL : "+url);
		
		((JavascriptExecutor) driver).executeScript("window.open('"+url+"','_blank');");
		
		//Get all window handles
		Set<String> allWindowhandles = driver.getWindowHandles();
		allWindowhandles = driver.getWindowHandles();
		for(String handle:allWindowhandles) {
			if(!handle.equals(parentTab)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		driver.get(url);		
		
		try {
			if(driver.findElement(By.xpath("//img[@src='"+url+"']")).isDisplayed()) {	
				driver.switchTo().window(parentTab);
				return true;
			}
		} catch (NoSuchElementException e) {
			driver.switchTo().window(parentTab);
		}
		return false;
	}
	
	@FindBy(xpath="//img[@src='asdf.jpg']")
	public WebElement brokenImage1;
	
	@FindBy(xpath="//img[@src='hjkl.jpg']")
	public WebElement brokenImage2;
	
	@FindBy(xpath="//img[@src='img/avatar-blank.jpg']")
	public WebElement clearImage;
	
	@FindBy(xpath="//div[@id='content']//img")
	public List<WebElement> allImages;
	
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
	
}
