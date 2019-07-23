package com.doosan.nao.fleetManagements.page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	EventFiringWebDriver wd;
	@FindBy(how = How.LINK_TEXT, using = "Sign Out")
	public WebElement SignOut;
	public void clickSignOutLink() {
		SignOut.click();
	}
	
	@FindBy(how = How.LINK_TEXT, using = "Home")
	public WebElement HomeLink;

	public void clickHomeLink() {
		/*WebDriverWait waitForHomeLink = new WebDriverWait(wd, 5);
		waitForHomeLink
				.until(ExpectedConditions.elementToBeClickable(HomeLink));*/
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomeLink.click();
	}

	
	@FindBy(how = How.LINK_TEXT, using = "Change")
	public WebElement change;

	public void clickChange() {
		System.err.println("A");
		try {
			System.err.println("B");
			change.click();
			System.err.println("C");
		} catch (Throwable t) {
			System.err.println("D");
		}
	}
	FleetManagementEquipmentPage fp=new FleetManagementEquipmentPage();
	/**
	 * This method for clicking the Fleet management on header link 
	 */
	@FindBy(how = How.LINK_TEXT, using = "Fleet Management")
	public WebElement fleateMangementlink;

	public void clickFleetManagementHeaderLink(EventFiringWebDriver wd) {
		try {
			WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 120);
			waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(fleateMangementlink));
			if(!(fleateMangementlink.isDisplayed())){
				String url=wd.getCurrentUrl();
				wd.get(url);
				
				wd.navigate().refresh();
				waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(fleateMangementlink));
			}
			fp.highlightMyElement(fleateMangementlink, 3, wd);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(fleateMangementlink.getText().equals("Fleet Management")){
			
			
		fleateMangementlink.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			System.err.println(" FleetManagement link not found Get the Access role From Admin ");
		}
	}
	
	

}
