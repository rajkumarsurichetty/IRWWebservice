package com.doosan.nao.fleetManagements.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	@FindBy(how=How.XPATH, using="html/body/div[1]/div/div/div[2]/div[1]/div[3]/div[1]/form/div[2]/dl/dd[1]/input")
	public WebElement userName;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div/div/div[2]/div[1]/div[3]/div[1]/form/div[2]/dl/dd[3]/input")
	public WebElement password;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div/div/div[2]/div[1]/div[3]/div[1]/form/div[2]/div/input[1]")
	public WebElement loginButton;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div[2]/div[3]/div[1]/div/span")
	public WebElement loginText;
	
		
	
	public void enterUserName(String username ,EventFiringWebDriver wd) 
	{WebDriverWait w=new WebDriverWait(wd, 100);
	w.until(ExpectedConditions.elementToBeClickable(userName));
		this.userName.click();
		this.userName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		this.password.click();
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		this.loginButton.click();
	}
	public void toLoginPassport( String userName,String password,EventFiringWebDriver wd){
		
		enterUserName(userName,wd);
		enterPassword(password);
		clickLoginButton();
	}
	public void validateLoginText(String expectedTex)
	{
		String actualText=this.loginText.getText();
		Assert.assertEquals(actualText, expectedTex);
		
	}
	
	
}
