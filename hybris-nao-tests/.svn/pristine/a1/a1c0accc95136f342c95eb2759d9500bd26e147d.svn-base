package com.doosan.nao.fleetManagements.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IOTPortalLoginPage {

	@FindBy(id="UserUsername")
	WebElement username;
	public void EnterUserName(EventFiringWebDriver wd,String userName){
		//WebDriverWait wait=new WebDriverWait(wd, 180);
		//wait.until(ExpectedConditions.visibilityOf(username));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}
		username.sendKeys(userName);
	}
	
	@FindBy(id="UserPassword")
	WebElement userPassword;
	public void enterPassword(String passWord){
		userPassword.sendKeys(passWord);
	}
	
	@FindBy(how =How.XPATH,using="//input[@value='Login']")
	WebElement login;
	public void clickLoginButton(){
		login.click();
	}
	
	
}
