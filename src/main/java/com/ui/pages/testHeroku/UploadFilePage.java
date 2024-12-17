package com.ui.pages.testHeroku;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFilePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public UploadFilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	@FindBy(xpath="//input[@id='file-upload']")
	public WebElement chhosewFile;
	
	@FindBy(xpath="//input[@id='file-submit']")
	public WebElement uploadBtn;
	
	@FindBy(xpath="//div[@id='content']//h3")
	public WebElement fileUploadRespHeader;
	
	@FindBy(xpath="//div[@id='uploaded-files']")
	public WebElement uploadedFiles;
	
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
	
	//uploadFilePath

}
