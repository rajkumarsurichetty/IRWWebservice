package com.doosan.pageFactorySDR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SearchClaimHistoryTab {

	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[1]/div[2]")
	public static WebElement searchClaimHistoryTab;
	public void clickSearchClaimHistoryTab()
	{
		searchClaimHistoryTab.click();
	}

	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div/table/tbody/tr[1]/td[1]/input")
	public static WebElement claimsPlacedInTheLastCheckBox;
	public void isClaimsPlacedInTheLastCheckBoxSelected ()
	{	
		if(claimsPlacedInTheLastCheckBox.isSelected())
		{
		System.out.println("");	
		}
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div/table/tbody/tr[2]/td[1]/input")
	public static WebElement claimsPlacedBetweenCheckBox;
	public void isClaimsPlacedBetweenCheckBoxSelected ()
	{	
		if(claimsPlacedBetweenCheckBox.isSelected())
		{
		System.out.println("");	
		}
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div/table/tbody/tr[3]/td[1]/input[1]")
	public static WebElement searchByCheckBox;
	public void isSearchByCheckBoxSelected ()
	{	
		if(searchByCheckBox.isSelected())
		{
		System.out.println("");	
		}
	}

	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div/div/button")
	public static WebElement searchButton;
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div/table/tbody/tr[1]/td[2]/select")
	public static WebElement InvoiceFromPastDropdown;
	public void selectInvoiceFromPastDropdown (String days)
	{
		Select select=new Select(InvoiceFromPastDropdown);
		select.selectByVisibleText(days);
		
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div/table/tbody/tr[2]/td[2]/input")
	public static WebElement startingDate;
	public void enterStartingDate(String startDate)
	{
		startingDate.sendKeys(startDate);
	}

	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div/table/tbody/tr[2]/td[3]/input")
	public static WebElement endingDate;
	public void enterEndingDate(String endDate)
	{
		endingDate.sendKeys(endDate);
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div/div/input")
	public static WebElement exportToExcelButton;
	public void clickExportToExcelButton()
	{
		exportToExcelButton.click();
	}


}
