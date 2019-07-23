package com.doosan.nao.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPriceAndAvailabityPage {

	@FindBy(how=How.NAME,using="entries[0].itemNumber")
	public WebElement partNumber;
	public void enterValidPartNumber(String validPartNumber)
	{
		System.out.println("i am inside parnumber");
		this.partNumber.sendKeys(validPartNumber);
	}
	
	@FindBy(how=How.NAME,using="entries[0].quantity")
	public WebElement qty;
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/form/div/div/div[3]/div/a")
	public WebElement clearForumButton;
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/form/div/div/div[3]/div/button")
	public WebElement checkpriceAndAvailablityButton;

	@FindBy(how=How.ID,using="entries0.itemNumber.errors")
	public WebElement partNumberErrorMessage;

	@FindBy(how=How.ID,using="entries0.quantity.errors")
	public WebElement quantityErrorMessage;
	

	@FindBy(how=How.LINK_TEXT,using="Start New Search")
	public WebElement startNewSearchButton;

	@FindBy(how=How.ID,using="shoppingcarttable	")
	public WebElement resultTable;
	
	
	
	public void enterValidQty(String validQty)
	{
		this.qty.clear();
		this.qty.sendKeys(validQty);
	}
	
	public void enterInValidPartNumber(String validPartNumber)
	{
		this.partNumber.clear();
		this.partNumber.sendKeys(validPartNumber);
	}
	
	
	public void enterInValidQty(String validQty)
	{
		this.qty.clear();
		this.qty.sendKeys(validQty);
	}
	
	public void clickClearForumButton()
	{
		clearForumButton.click();
	}
	
	public void clickCheckpriceAndAvailabityButton()
	{
		this.checkpriceAndAvailablityButton.click();
	}
	
	public boolean verifyPartNumberErrorMessage(EventFiringWebDriver wd)
	{
		WebDriverWait waitForPartNumberErrorMessage=new WebDriverWait(wd, 5);
		waitForPartNumberErrorMessage.until(ExpectedConditions.visibilityOf(partNumberErrorMessage));

		return this.partNumberErrorMessage.isDisplayed();
	}
	
	public boolean verifyQuantityErrorMessage(EventFiringWebDriver wd)
	{
		WebDriverWait waitForQtyErrorMessage=new WebDriverWait(wd, 5);
		waitForQtyErrorMessage.until(ExpectedConditions.visibilityOf(quantityErrorMessage));
		return this.quantityErrorMessage.isDisplayed();
	}

	public void clickStartNewSearchButton()
	{
		this.startNewSearchButton.click();
	}
	
	public boolean verifyResultTable()
	{
		return resultTable.isDisplayed();
	}

}
