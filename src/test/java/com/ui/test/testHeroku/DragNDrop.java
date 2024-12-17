package com.ui.test.testHeroku;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.DragNDropPage;
import com.ui.pages.testHeroku.IndexPage;

public class DragNDrop extends BaseTest {
	
	private DragNDropPage dragNDropInstance;
	//private IndexPage indexInstance;

//	IndexPage getIndexPage() {
//		if(indexInstance==null) {
//			return new IndexPage(driver);
//		}
//		return indexInstance;
//	}
	
	public IndexPage getIndexPage() {
		return IndexPage.getIndexPage(driver);
	}
	
	DragNDropPage getPage() {
		if(dragNDropInstance==null) {
			return new DragNDropPage(driver);
		}
		return dragNDropInstance;
	}
	
	@Test(description="Open App", priority=1, enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Drag and Drop page", priority=2)
	public void openDragNDropPages() {
		getIndexPage().clickDragndrop();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Drag box A to box B", priority=3)
	public void dragBoxAtoBoxB() {
		WebElement boxA = getPage().boxA;
		WebElement boxB = getPage().boxB;
		
		String boxAText = boxA.findElement(By.xpath("./header")).getText();
		String boxBText = boxB.findElement(By.xpath("./header")).getText();
		
		System.out.println(">>> Box A Text : "+boxAText);
		System.out.println(">>> Box B Text : "+boxBText);

		Actions action = new Actions(driver);
		action.dragAndDrop(boxA, boxB).perform();
		
		boxAText = boxA.findElement(By.xpath("./header")).getText();
		
		System.out.println("*********** After Drag and Drop*******************");
		System.out.println(">>> Box A Text : "+boxAText);
		System.out.println(">>> Box B Text : "+boxBText);
		
		assertTrue(boxAText.equals(boxBText));
		driver.navigate().refresh();
		
	}
	
	@Test(description="Drag box B to box A", priority=4)
	public void dragBoxBtoBoxA() {
		WebElement boxA = getPage().boxA;
		WebElement boxB = getPage().boxB;
		
		String boxAText = boxA.findElement(By.xpath("./header")).getText();
		String boxBText = boxB.findElement(By.xpath("./header")).getText();
		
		System.out.println(">>> Box A Text : "+boxAText);
		System.out.println(">>> Box B Text : "+boxBText);

		Actions action = new Actions(driver);
		action.dragAndDrop(boxA, boxB).perform();
		
		boxAText = boxA.findElement(By.xpath("./header")).getText();
		
		System.out.println("*********** After Drag and Drop*******************");
		System.out.println(">>> Box A Text : "+boxAText);
		System.out.println(">>> Box B Text : "+boxBText);
		
		assertTrue(boxAText.equals(boxBText));
		
	}
	
}
