package com.doosan.pageFactorySDR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SelectInvoicePage {

	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[1]/div/div[1]/h1")
	public static WebElement selectInvoiceText;
	public void verifySelectInvoiceText ()
	{
		String SelectInvoiceText=selectInvoiceText.getText();
		if(SelectInvoiceText.trim().equals("Select Invoice".trim()))
		{
		System.out.println("");	
		}
	}
	

	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[2]/div[2]/form/table/tbody/tr[1]/td[1]/input")
	public static WebElement InvoicesFromThePastCheckBox;
	public void isInvoicesFromThePastCheckBoxSelected ()
	{	
		if(InvoicesFromThePastCheckBox.isSelected())
		{
		System.out.println("");	
		}
	}
	
	public void clickInvoicesFromThePastCheckBox()
	{	
		InvoicesFromThePastCheckBox.click();
		
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[2]/div[2]/form/table/tbody/tr[2]/td[1]/input")
	public static WebElement DuringThePeriodOfCheckBox;
	public void isDuringThePeriodOfCheckBoxSelected ()
	{	
		if(DuringThePeriodOfCheckBox.isSelected())
		{
		System.out.println("");	
		}
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[2]/div[2]/form/table/tbody/tr[3]/td[1]/input[1]")
	public static WebElement ContainingCheckBox;
	public void isContainingCheckBoxSelected ()
	{	
		if(ContainingCheckBox.isSelected())
		{
		System.out.println("");	
		}
	}
	
	public void clickContainingCheckBox()
	{	
		ContainingCheckBox.click();
	}


	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[2]/div[2]/form/button")
	public static WebElement searchButton;
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[2]/div[1]")
	public static WebElement invoiceSearchText;
	public void verifyInvoiceSearchText ()
	{
		String InvoiceSearchText=invoiceSearchText.getText();
		if(InvoiceSearchText.trim().equals("Invoice Search".trim()))
		{
		System.out.println("");	
		}
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[2]/div[2]/form/table/tbody/tr[1]/td[2]/select")
	public static WebElement InvoiceFromPastDropdown;
	public void selectInvoiceFromPastDropdown (String days)
	{
		Select select=new Select(InvoiceFromPastDropdown);
		select.selectByVisibleText(days);
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[2]/div[2]/form/table/tbody/tr[2]/td[2]/input[2]")
	public static WebElement startingDate;
	public void enterStartingDate(String startDate)
	{
		startingDate.sendKeys(startDate);
	}

	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[2]/div[2]/form/table/tbody/tr[2]/td[3]/input")
	public static WebElement endingDate;
	public void enterEndingDate(String endDate)
	{
		endingDate.sendKeys(endDate);
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/input")
	public static WebElement backToCreateClaimButton;
	public void clickBackToCreateClaimButton()
	{
		backToCreateClaimButton.click();
	}
	
	
}
