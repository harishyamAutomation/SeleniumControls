package com.ui.test.testHeroku;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ui.core.BaseTest;
import com.ui.pages.testHeroku.IndexPage;
import com.ui.pages.testHeroku.UploadFilePage;
import com.ui.util.PropertyReader;

public class UploadFile extends BaseTest {

	//private IndexPage indexInstance;
	private UploadFilePage pageInstance;
	
//	public IndexPage getIndexPage() {
//		if(indexInstance==null) {
//			return new IndexPage(driver);
//		}
//		return indexInstance;
//	}
	
	public IndexPage getIndexPage() {
		return IndexPage.getIndexPage(driver);
	}
	
	public UploadFilePage getPage() {
		if(pageInstance==null) {
			return new UploadFilePage(driver);
		}
		return pageInstance;
	}
	
	@Test(description="Open App", priority=1, enabled=false)
	public void openApp() {
		getIndexPage().launchPage();
	}
	
	@Test(description="Open Upload File page", priority=2)
	public void openUploadFilePage() {
		getIndexPage().clickFileupload();
		assertTrue(getPage().footerText.isDisplayed());
	}
	
	@Test(description="Test to upload a file", priority=3)
	public void testFileUpload() {
		
		String fileName = "fondo_pantalla.png";
		String filePath = PropertyReader.getProperty("uploadFilePath")+fileName;
		
		if(new File(filePath).exists()) {
			getPage().chhosewFile.sendKeys(PropertyReader.getProperty(filePath));
			getPage().uploadBtn.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(getPage().fileUploadRespHeader));
			assertEquals(getPage().fileUploadRespHeader.getText(), "File Uploaded!");
			assertEquals(getPage().uploadedFiles.getText(), fileName);
		}else {
			throw new RuntimeException("Provided file path is invalid..!!");
		}
	}
}
