package com.ui.pages.testHeroku;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public DynamicControlsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	public String addRemoveCheckbox() {
		if(btnAddRemove.isEnabled()) {
			btnAddRemove.click();
		}else {
			throw new RuntimeException("Add/Remove button is disabled");
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(checkBoxMsg));
		return checkBoxMsg.getText();
	}
	
	public String enableDisableTextField() {
		if(btnEnableDisable.isEnabled()) {
			btnEnableDisable.click();
		}else {
			throw new RuntimeException("Enable/Disable button is disabled");
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(inputBoxMsg));
		return inputBoxMsg.getText();
	}
	
	public void enterTextInTextBox(String text) {
		textBox.sendKeys(text);
	}
	
	@FindBy(xpath="//form[@id='checkbox-example']/button")
	public WebElement btnAddRemove;
	
	@FindBy(xpath="//form[@id='checkbox-example']//input[@id='checkbox']")
	public WebElement checkBox;
	
	@FindBy(xpath="//form[@id='checkbox-example']//p[contains(@id, 'message')]")
	public WebElement checkBoxMsg;
	
	@FindBy(xpath="//form[@id='input-example']//input")
	public WebElement textBox;
	
	@FindBy(xpath="//form[@id='input-example']//button")
	public WebElement btnEnableDisable;
	
	@FindBy(xpath="//form[@id='input-example']//p[contains(@id, 'message')]")
	public WebElement inputBoxMsg;
	
	@FindBy(xpath="//div[@id='page-footer']//div[contains(text(), 'Powered by')]")
	public WebElement footerText;
}
