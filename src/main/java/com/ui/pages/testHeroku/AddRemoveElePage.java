package com.ui.pages.testHeroku;

import java.awt.AWTException;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemoveElePage {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//h3[text()='Add/Remove Elements']")
	public WebElement addRemoveHeader;
	
	@FindBy(xpath="//button[text()='Add Element']")
	public WebElement addElement;
	
	@FindBy(xpath="//div[@id='elements']/button[text()='Delete']")
	public WebElement deleteElement;
	
	@FindBy(xpath="//div[@id='elements']/button[text()='Delete']")
	public List<WebElement> deleteAllElements;
	
	public AddRemoveElePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	}
	
	public boolean addElement() {
		if(addElement.isDisplayed() & addElement.isEnabled()) {
			addElement.click();
			return true;
		}else {
			throw new RuntimeException(addElement+" button is either disabled or not displayed.");
		}
	}
	
	public boolean isElementAdded() {
		if(deleteElement.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean removeElement() {
		if(deleteElement.isDisplayed() & deleteElement.isEnabled()) {
			deleteElement.click();
			return true;
		}else {
			throw new RuntimeException(deleteElement+" button is either disabled or not displayed.");
		}
	}
	
	public boolean isElementRemoved() {
		boolean status=true;
		try {
			if(deleteElement.isDisplayed()) {
				status = false;
			}
		} catch (NoSuchElementException e) {
		}
		return status;
	}
	
	public boolean deleteAllAddedElements() throws AWTException {
		try {
			List<WebElement> deleteAllElementss = driver.findElements(By.xpath("//div[@id='elements']/button[text()='Delete']"));
			int i=1;
			for(WebElement element : deleteAllElementss) {
				if(element.isDisplayed() & element.isEnabled()) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(element));
					element.click();
					deleteAllElementss = driver.findElements(By.xpath("//div[@id='elements']/button[text()='Delete']"));
					System.out.println("Deleted : "+element.getText()+"["+i+"]");
					i++;
				}else {
					throw new RuntimeException(element+" button is either disabled or not displayed.");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return true;
	}
}
