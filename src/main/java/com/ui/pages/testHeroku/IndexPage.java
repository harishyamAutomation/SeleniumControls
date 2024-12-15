package com.ui.pages.testHeroku;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.util.PropertyReader;

public class IndexPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public IndexPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	public void launchPage() {
		driver.get(PropertyReader.getProperty("url"));
		wait.until(ExpectedConditions.visibilityOf(WYSIWYGEditor));
		driver.manage().window().maximize();
	}
	
	@FindBy(xpath = "//a[text()='A/B Testing']")
	public WebElement abTesting;
	
	@FindBy(xpath = "//a[text()='Add/Remove Elements']")
	public WebElement addRemoveElements;
	
	@FindBy(xpath = "//a[contains(text(), 'Basic Auth')]")
	public WebElement basicAuth;
	
	@FindBy(xpath = "//a[text()='Broken Images']")
	public WebElement brokenImages;
	
	@FindBy(xpath = "//a[text()='Challenging DOM']")
	public WebElement chanllengingDom;
	
	@FindBy(xpath = "//a[text()='Checkboxes']")
	public WebElement checkBoxes;
	
	@FindBy(xpath = "//a[text()='Context Menu']")
	public WebElement contextMenu;
	
	@FindBy(xpath = "//a[text()='Digest Authentication']")
	public WebElement digestAuth;
	
	@FindBy(xpath = "//a[text()='Disappearing Elements']")
	public WebElement disappearingElements;
	
	@FindBy(xpath = "//a[text()='Drag and Drop']")
	public WebElement dragNDrop;
	
	@FindBy(xpath = "//a[text()='Dropdown']")
	public WebElement dropdown;
	
	@FindBy(xpath = "//a[text()='Dynamic Content']")
	public WebElement dynamicContent;
	
	@FindBy(xpath = "//a[text()='Dynamic Controls']")
	public WebElement dynamicCtrl;
	
	@FindBy(xpath = "//a[text()='Dynamic Loading']")
	public WebElement dynamicLoading;
	
	@FindBy(xpath = "//a[text()='Entry Ad']")
	public WebElement entryAd;
	
	@FindBy(xpath = "//a[text()='Exit Intent']")
	public WebElement exitIntent;
	
	@FindBy(xpath = "//a[text()='File Download']")
	public WebElement fileDownload;
	
	@FindBy(xpath = "//a[text()='File Upload']")
	public WebElement fileUpload;
	
	@FindBy(xpath = "//a[text()='Floating Menu']")
	public WebElement floatingMenu;
	
	@FindBy(xpath = "//a[text()='Forgot Password']")
	public WebElement forgotPassword;
	
	@FindBy(xpath = "//a[text()='Form Authentication']")
	public WebElement formAuth;
	
	@FindBy(xpath = "//a[text()='Frames']")
	public WebElement frames;
	
	@FindBy(xpath = "//a[text()='Geolocation']")
	public WebElement geoLocation;
	
	@FindBy(xpath = "//a[text()='Horizontal Slider']")
	public WebElement horizontalSlider;
	
	@FindBy(xpath = "//a[text()='Hovers']")
	public WebElement hovers;
	
	@FindBy(xpath = "//a[text()='Infinite Scroll']")
	public WebElement infiniteScroll;
	
	@FindBy(xpath = "//a[text()='Inputs']")
	public WebElement inputs;
	
	@FindBy(xpath = "//a[text()='JQuery UI Menus']")
	public WebElement jQeryUIMenus;
	
	@FindBy(xpath = "//a[text()='JavaScript Alerts']")
	public WebElement jsAlerts;
	
	@FindBy(xpath = "//a[text()='JavaScript onload event error']")
	public WebElement jsOnLoadEventErr;
	
	@FindBy(xpath = "//a[text()='Key Presses']")
	public WebElement keyPresses;
	
	@FindBy(xpath = "//a[text()='Large & Deep DOM']")
	public WebElement largeNDeepDom;
	
	@FindBy(xpath = "//a[text()='Multiple Windows']")
	public WebElement multiWindows;
	
	@FindBy(xpath = "//a[text()='Nested Frames']")
	public WebElement nestedFrames;
	
	@FindBy(xpath = "//a[text()='Notification Messages']")
	public WebElement notifMsgs;
	
	@FindBy(xpath = "//a[text()='Redirect Link']")
	public WebElement redirectLink;
	
	@FindBy(xpath = "//a[text()='Secure File Download']")
	public WebElement secureFileDownload;
	
	@FindBy(xpath = "//a[text()='Shadow DOM']")
	public WebElement shadowDom;
	
	@FindBy(xpath = "//a[text()='Shifting Content']")
	public WebElement shiftingContent;
	
	@FindBy(xpath = "//a[text()='Slow Resources']")
	public WebElement slowResources;
	
	@FindBy(xpath = "//a[text()='Sortable Data Tables']")
	public WebElement sortableDataTables;
	
	@FindBy(xpath = "//a[text()='Status Codes']")
	public WebElement statusCodes;
	
	@FindBy(xpath = "//a[text()='Typos']")
	public WebElement typos;
	
	@FindBy(xpath = "//a[text()='WYSIWYG Editor']")
	public WebElement WYSIWYGEditor;
	
	public void verifyAllElement() {
		assertTrue(abTesting.isDisplayed());
		assertTrue(addRemoveElements.isDisplayed());
		assertTrue(basicAuth.isDisplayed());
		assertTrue(brokenImages.isDisplayed());
		assertTrue(chanllengingDom.isDisplayed());
		assertTrue(checkBoxes.isDisplayed());
		assertTrue(contextMenu.isDisplayed());
		assertTrue(digestAuth.isDisplayed());
		assertTrue(disappearingElements.isDisplayed());
		assertTrue(dragNDrop.isDisplayed());
		assertTrue(dropdown.isDisplayed());
		assertTrue(dynamicContent.isDisplayed());
		assertTrue(dynamicCtrl.isDisplayed());
		assertTrue(dynamicLoading.isDisplayed());
		assertTrue(entryAd.isDisplayed());
		assertTrue(exitIntent.isDisplayed());
		assertTrue(fileDownload.isDisplayed());
		assertTrue(fileUpload.isDisplayed());
		assertTrue(floatingMenu.isDisplayed());
		assertTrue(forgotPassword.isDisplayed());
		assertTrue(formAuth.isDisplayed());
		assertTrue(frames.isDisplayed());
		assertTrue(geoLocation.isDisplayed());
		assertTrue(horizontalSlider.isDisplayed());
		assertTrue(hovers.isDisplayed());
		assertTrue(infiniteScroll.isDisplayed());
		assertTrue(inputs.isDisplayed());
		assertTrue(jQeryUIMenus.isDisplayed());
		assertTrue(jsAlerts.isDisplayed());
		assertTrue(jsOnLoadEventErr.isDisplayed());
		assertTrue(keyPresses.isDisplayed());
		assertTrue(largeNDeepDom.isDisplayed());
		assertTrue(multiWindows.isDisplayed());
		assertTrue(nestedFrames.isDisplayed());
		assertTrue(notifMsgs.isDisplayed());
		assertTrue(redirectLink.isDisplayed());
		assertTrue(secureFileDownload.isDisplayed());
		assertTrue(shadowDom.isDisplayed());
		assertTrue(shiftingContent.isDisplayed());
		assertTrue(slowResources.isDisplayed());
		assertTrue(sortableDataTables.isDisplayed());
		assertTrue(statusCodes.isDisplayed());
		assertTrue(typos.isDisplayed());
		assertTrue(WYSIWYGEditor.isDisplayed());
	}
	
	public void clickABTesting() {
		if(abTesting.isEnabled()) {
			abTesting.click();
		}else {
			throw new RuntimeException(abTesting+" link is disabled");
		}
	}
	
	public void clickAddremoveelements() {
	    if (addRemoveElements.isEnabled()) {
	        addRemoveElements.click();
	    } else {
	        throw new RuntimeException(addRemoveElements + " link is disabled");
	    }
	}
	public void clickBasicauth() {
	    if (basicAuth.isEnabled()) {
	        basicAuth.click();
	    } else {
	        throw new RuntimeException(basicAuth + " link is disabled");
	    }
	}
	public void clickBrokenimages() {
	    if (brokenImages.isEnabled()) {
	        brokenImages.click();
	    } else {
	        throw new RuntimeException(brokenImages + " link is disabled");
	    }
	}
	public void clickChanllengingdom() {
	    if (chanllengingDom.isEnabled()) {
	        chanllengingDom.click();
	    } else {
	        throw new RuntimeException(chanllengingDom + " link is disabled");
	    }
	}
	public void clickCheckboxes() {
	    if (checkBoxes.isEnabled()) {
	        checkBoxes.click();
	    } else {
	        throw new RuntimeException(checkBoxes + " link is disabled");
	    }
	}
	public void clickContextmenu() {
	    if (contextMenu.isEnabled()) {
	        contextMenu.click();
	    } else {
	        throw new RuntimeException(contextMenu + " link is disabled");
	    }
	}
	public void clickDigestauth() {
	    if (digestAuth.isEnabled()) {
	        digestAuth.click();
	    } else {
	        throw new RuntimeException(digestAuth + " link is disabled");
	    }
	}
	public void clickDisappearingelements() {
	    if (disappearingElements.isEnabled()) {
	        disappearingElements.click();
	    } else {
	        throw new RuntimeException(disappearingElements + " link is disabled");
	    }
	}
	public void clickDragndrop() {
	    if (dragNDrop.isEnabled()) {
	        dragNDrop.click();
	    } else {
	        throw new RuntimeException(dragNDrop + " link is disabled");
	    }
	}
	public void clickDropdown() {
	    if (dropdown.isEnabled()) {
	        dropdown.click();
	    } else {
	        throw new RuntimeException(dropdown + " link is disabled");
	    }
	}
	public void clickDynamiccontent() {
	    if (dynamicContent.isEnabled()) {
	        dynamicContent.click();
	    } else {
	        throw new RuntimeException(dynamicContent + " link is disabled");
	    }
	}
	public void clickDynamicctrl() {
	    if (dynamicCtrl.isEnabled()) {
	        dynamicCtrl.click();
	    } else {
	        throw new RuntimeException(dynamicCtrl + " link is disabled");
	    }
	}
	public void clickDynamicloading() {
	    if (dynamicLoading.isEnabled()) {
	        dynamicLoading.click();
	    } else {
	        throw new RuntimeException(dynamicLoading + " link is disabled");
	    }
	}
	public void clickEntryad() {
	    if (entryAd.isEnabled()) {
	        entryAd.click();
	    } else {
	        throw new RuntimeException(entryAd + " link is disabled");
	    }
	}
	public void clickExitintent() {
	    if (exitIntent.isEnabled()) {
	        exitIntent.click();
	    } else {
	        throw new RuntimeException(exitIntent + " link is disabled");
	    }
	}
	public void clickFiledownload() {
	    if (fileDownload.isEnabled()) {
	        fileDownload.click();
	    } else {
	        throw new RuntimeException(fileDownload + " link is disabled");
	    }
	}
	public void clickFileupload() {
	    if (fileUpload.isEnabled()) {
	        fileUpload.click();
	    } else {
	        throw new RuntimeException(fileUpload + " link is disabled");
	    }
	}
	public void clickFloatingmenu() {
	    if (floatingMenu.isEnabled()) {
	        floatingMenu.click();
	    } else {
	        throw new RuntimeException(floatingMenu + " link is disabled");
	    }
	}
	public void clickForgotpassword() {
	    if (forgotPassword.isEnabled()) {
	        forgotPassword.click();
	    } else {
	        throw new RuntimeException(forgotPassword + " link is disabled");
	    }
	}
	public void clickFormauth() {
	    if (formAuth.isEnabled()) {
	        formAuth.click();
	    } else {
	        throw new RuntimeException(formAuth + " link is disabled");
	    }
	}
	public void clickFrames() {
	    if (frames.isEnabled()) {
	        frames.click();
	    } else {
	        throw new RuntimeException(frames + " link is disabled");
	    }
	}
	public void clickGeolocation() {
	    if (geoLocation.isEnabled()) {
	        geoLocation.click();
	    } else {
	        throw new RuntimeException(geoLocation + " link is disabled");
	    }
	}
	public void clickHorizontalslider() {
	    if (horizontalSlider.isEnabled()) {
	        horizontalSlider.click();
	    } else {
	        throw new RuntimeException(horizontalSlider + " link is disabled");
	    }
	}
	public void clickHovers() {
	    if (hovers.isEnabled()) {
	        hovers.click();
	    } else {
	        throw new RuntimeException(hovers + " link is disabled");
	    }
	}
	public void clickInfinitescroll() {
	    if (infiniteScroll.isEnabled()) {
	        infiniteScroll.click();
	    } else {
	        throw new RuntimeException(infiniteScroll + " link is disabled");
	    }
	}
	public void clickInputs() {
	    if (inputs.isEnabled()) {
	        inputs.click();
	    } else {
	        throw new RuntimeException(inputs + " link is disabled");
	    }
	}
	public void clickJqeryuimenus() {
	    if (jQeryUIMenus.isEnabled()) {
	        jQeryUIMenus.click();
	    } else {
	        throw new RuntimeException(jQeryUIMenus + " link is disabled");
	    }
	}
	public void clickJsalerts() {
	    if (jsAlerts.isEnabled()) {
	        jsAlerts.click();
	    } else {
	        throw new RuntimeException(jsAlerts + " link is disabled");
	    }
	}
	public void clickJsonloadeventerr() {
	    if (jsOnLoadEventErr.isEnabled()) {
	        jsOnLoadEventErr.click();
	    } else {
	        throw new RuntimeException(jsOnLoadEventErr + " link is disabled");
	    }
	}
	public void clickKeypresses() {
	    if (keyPresses.isEnabled()) {
	        keyPresses.click();
	    } else {
	        throw new RuntimeException(keyPresses + " link is disabled");
	    }
	}
	public void clickLargendeepdom() {
	    if (largeNDeepDom.isEnabled()) {
	        largeNDeepDom.click();
	    } else {
	        throw new RuntimeException(largeNDeepDom + " link is disabled");
	    }
	}
	public void clickMultiwindows() {
	    if (multiWindows.isEnabled()) {
	        multiWindows.click();
	    } else {
	        throw new RuntimeException(multiWindows + " link is disabled");
	    }
	}
	public void clickNestedframes() {
	    if (nestedFrames.isEnabled()) {
	        nestedFrames.click();
	    } else {
	        throw new RuntimeException(nestedFrames + " link is disabled");
	    }
	}
	public void clickNotifmsgs() {
	    if (notifMsgs.isEnabled()) {
	        notifMsgs.click();
	    } else {
	        throw new RuntimeException(notifMsgs + " link is disabled");
	    }
	}
	public void clickRedirectlink() {
	    if (redirectLink.isEnabled()) {
	        redirectLink.click();
	    } else {
	        throw new RuntimeException(redirectLink + " link is disabled");
	    }
	}
	public void clickSecurefiledownload() {
	    if (secureFileDownload.isEnabled()) {
	        secureFileDownload.click();
	    } else {
	        throw new RuntimeException(secureFileDownload + " link is disabled");
	    }
	}
	public void clickShadowdom() {
	    if (shadowDom.isEnabled()) {
	        shadowDom.click();
	    } else {
	        throw new RuntimeException(shadowDom + " link is disabled");
	    }
	}
	public void clickShiftingcontent() {
	    if (shiftingContent.isEnabled()) {
	        shiftingContent.click();
	    } else {
	        throw new RuntimeException(shiftingContent + " link is disabled");
	    }
	}
	public void clickSlowresources() {
	    if (slowResources.isEnabled()) {
	        slowResources.click();
	    } else {
	        throw new RuntimeException(slowResources + " link is disabled");
	    }
	}
	public void clickSortabledatatables() {
	    if (abTesting.isEnabled()) {
	        sortableDataTables.click();
	    } else {
	        throw new RuntimeException(abTesting + " link is disabled");
	    }
	}
	public void clickStatuscodes() {
	    if (statusCodes.isEnabled()) {
	        statusCodes.click();
	    } else {
	        throw new RuntimeException(statusCodes + " link is disabled");
	    }
	}
	public void clickTypos() {
	    if (typos.isEnabled()) {
	        typos.click();
	    } else {
	        throw new RuntimeException(typos + " link is disabled");
	    }
	}
	public void clickWysiwygeditor() {
	    if (WYSIWYGEditor.isEnabled()) {
	        WYSIWYGEditor.click();
	    } else {
	        throw new RuntimeException(WYSIWYGEditor + " link is disabled");
	    }
	}
	
}
