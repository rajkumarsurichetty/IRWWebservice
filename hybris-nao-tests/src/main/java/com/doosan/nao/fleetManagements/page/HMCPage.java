package com.doosan.nao.fleetManagements.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HMCPage {
	
	@FindBy(id="Main_user")
	WebElement hmcUser;
	@FindBy(id="Main_password")
	WebElement hmcPassword;
	public void enterUserNameAndPassword(String userName,String passWord){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hmcUser.sendKeys(userName);
		hmcPassword.sendKeys(passWord);
	}
	
	public boolean testLoginPage(){
		boolean testFlg=hmcUser.isDisplayed();
		return testFlg;
	}
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement hmcLogin;
	public void clickLoginButton(){
		hmcLogin.click();
		
	}
	@FindBy(xpath="//a[contains(text(),'Passport')]")
	WebElement passport;
	
	public void clickPassportLink(EventFiringWebDriver wd){
		waitMethod(wd, passport);
		passport.click();
		
	}
	@FindBy(xpath="//a[contains(text(),'Passport Identity')]")
	WebElement passportIdentit;
	
	public void clickPassportIdentitLink(EventFiringWebDriver wd){
		waitMethod(wd, passportIdentit);
		passportIdentit.click();
		
	}
	@FindBy(id="Content/StringEditor[in Content/GenericCondition[PassportIdentity.firstName]]_input")
	WebElement EnterName;
	public void enterPassPortUSerNAme(String PassportuserName){
		EnterName.sendKeys(PassportuserName);
	}
	
	
	
	@FindBy(xpath="//span[contains(text(),'Search')]")
	WebElement search;
	public void clickSearchButton(){
		search.click();
		
	}
	
	@FindBy(xpath="//tr[contains(@id,'Content/OrganizerListEntry')]")
	WebElement userSearchResult;
	public void clickUserLineGrid(EventFiringWebDriver wd){
		Actions action=new Actions(wd);
		action.doubleClick(userSearchResult).build().perform();
		waitMethod(wd, roleTable);
	}
	
	@FindBy(id="table_Content/GenericItemList_table")
	WebElement roleTable;
	@FindBy(id="Content/EnumerationValueSelectEditor[in Content/Attribute[PassportIdentity.systemOfMeasurementSettings]]_select")
	WebElement systemOfMeasurementSettings;
	public String getselectedOptionsystemOfMeasurementSettings(EventFiringWebDriver wd){
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("arguments[0].scrollIntoView();", systemOfMeasurementSettings);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select sele=new Select(systemOfMeasurementSettings);
		String selectedVal=sele.getFirstSelectedOption().getText();
		return selectedVal;
	}
	
	@FindBy(xpath="//input[@id='Content/StringEditor[in Content/Attribute[PassportIdentity.defaultLocale]]_input']")
	WebElement defaultLocale;
	public void enterLocale(EventFiringWebDriver wd,String locale){
		Actions action=new Actions(wd);
		action.moveToElement(defaultLocale).build().perform();
		defaultLocale.clear();
		defaultLocale.sendKeys(locale);
		//waitMethod(wd, roleTable);
	}
	
	@FindBy(id="Content/ImageToolbarAction[organizer.editor.save.title]_label")
	WebElement save;
	public void clickSave(EventFiringWebDriver wd){
		Actions action=new Actions(wd);
		action.moveToElement(save).build().perform();
		save.click();
		waitMethod(wd, roleTable);
	}
	public void waitMethod(EventFiringWebDriver wd,WebElement element){
		WebDriverWait wait=new WebDriverWait(wd, 200);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
}
