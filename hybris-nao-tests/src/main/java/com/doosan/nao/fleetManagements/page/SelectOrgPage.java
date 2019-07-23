package com.doosan.nao.fleetManagements.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectOrgPage {
	
	String  organizationHeadertxt;
	@FindBy(xpath="//*[@id='orgs_page']/div[1]/div/h1")
	public WebElement selectOrgHeaderText;
	public void getSelectOrganizationHeaderText()
	{
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		organizationHeadertxt=selectOrgHeaderText.getText().trim();
	}
	public void verifySelectOrganizationHeader(String orgText) {
		System.out.println(orgText);
		try {
			Assert.assertEquals(organizationHeadertxt, orgText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Organization header text not in language "+orgText);
		}
	}
	public void verifySelectOrganizationURL(String apllicationURL) {
		System.out.println(apllicationURL);
		try {
			Assert.assertEquals(apllicationURL, "https://portal-hybris.qa.dice-tools.com/naoorgselector/fr/login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Organization header text not in language "+apllicationURL);
		}
	}
	
	@FindBy(how=How.XPATH, using=".//*[@id='search_option1']")
	public WebElement searchByFirstDropdown;
	public void searchByFirstDropdown(String brand)
	{	try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		Select firstSelect=new Select(searchByFirstDropdown);
		firstSelect.selectByVisibleText(brand);
	}

	@FindBy(how=How.XPATH, using="html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")
	public WebElement enterCustomerNumber;
	public void searchByContainingOptionDropdown(String brand)
	{
		Select firstSelect=new Select(searchByBrand);
		firstSelect.selectByVisibleText(brand);
	}

	@FindBy(how=How.XPATH, using="html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")
	public WebElement searchByBrand;
	public void enterCustomerNo(EventFiringWebDriver  wd,String customerNo)
	{WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 160);
	waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(firstOrgLinkInSearchResultpage));
		this.enterCustomerNumber.clear();
		this.enterCustomerNumber.sendKeys(customerNo);
	}

	@FindBy(how=How.XPATH, using="//table[@id='organization_list']/tbody/tr/td[2]/a")
	public WebElement firstOrgLinkInSearchResultpage;
	public void clickFirstOrgLink(WebDriver wd)
	{
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 200);
		waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(firstOrgLinkInSearchResultpage));
		this.firstOrgLinkInSearchResultpage.click();
		
	}
	
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div[3]/div/div[3]/form/button")
	public WebElement searchButtonOrgPage;
	public void clickSearchButton(EventFiringWebDriver wd)
	{
		this.searchButtonOrgPage.click();
		//FleetManagementEquipmentPage.waitMethod(wd, ele);
	}
	
	
	@FindBy(how=How.ID,using="userinfo")
	public WebElement welcomeText;
	public boolean verifyWelcomeText(String welcomeText)
	{
		System.out.println(welcomeText);
		System.out.println(welcomeText.substring(welcomeText.length()-5));
		
		return this.welcomeText.getText().contains(welcomeText.substring(welcomeText.length()-5));
	}
}
