package com.doosan.pageFactorySDR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateNewClaimPage {

	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[1]/div[1]/a")
	public static WebElement myOpenClaimsTab;
	public void clickMyOpenClaimsTab()
	{
		myOpenClaimsTab.click();
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[1]/div[2]")
	public static WebElement searchClaimHistoryTab;
	public void clickSearchClaimHistoryTab()
	{
		searchClaimHistoryTab.click();
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[1]/div[3]/a")
	public static WebElement createNewClaimTab;
	public void clickCreateNewClaimTab ()
	{
		createNewClaimTab.click();
	}
	
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[3]/input")
	public static WebElement createClaimButtonForSDR;
	public void clickCreateClaimButtonSDR ()
	{
		createClaimButtonForSDR.click();
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[3]/input")
	public static WebElement createClaimButtonForSurplusretrun;
	public void clickCreateClaimButtonSurplusretrun ()
	{
		createClaimButtonForSurplusretrun.click();
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[3]/input")
	public static WebElement createClaimButtonForPolicyReturn;
	public void clickCreateClaimButtonPolicyReturn ()
	{
		createClaimButtonForPolicyReturn.click();
	}
	
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[3]/input")
	public static WebElement selectClaimTypeText;
	public void verifySelectClaimTypeText ()
	{
		String SelectClaimTypeText=selectClaimTypeText.getText();
		if(SelectClaimTypeText.trim().equals("Select Claim Type".trim()))
		{
		System.out.println("");	
		}
		
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/div[2]/p[1]")
	public static WebElement 	surplusReturnEligibilityText;
	public void verifySurplusReturnEligibilityText ()
	{
		String SelectClaimTypeText=surplusReturnEligibilityText.getText();
		if(SelectClaimTypeText.trim().equals("Surplus Return Eligibility".trim()))
		{
		System.out.println("");	
		}
		
	}
	
	
}
