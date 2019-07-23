package com.doosan.pageFactoryHomePages;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.doosan.nao.PageFactory.CheckPriceAndAvailabityPage;
import com.doosan.nao.PageFactory.HomePage;
import com.doosan.nao.PageFactory.LoginPage;
import com.doosan.nao.PageFactory.SelectOrgPage;
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class CheckPriceAndAvailabityPageValidator extends TestInitializer {


	/*private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;

	public HomePage homePage=null;
	public LoginPage loginPage=null;
	public SelectOrgPage selectOrgPage=null;
	public CheckPriceAndAvailabityPage checkPriceAndAvailabityPage=null;
	
	@BeforeMethod
	public void setUpForCheckPriceAndAvailabityPageValidatorTest() throws IOException, URISyntaxException, InterruptedException
	{	
		if (isBrowserAlive=="N")
		{
		wd=WebdriverSelector.getDriver(wd, "firefox");
		
		initialize("firefox", "", "","");
		
			wd.get(PROJECT.getProperty("DoosanPassportURL"));
		}
				
		  homePage=PageFactory.initElements(wd, HomePage.class);
		  loginPage=PageFactory.initElements(wd, LoginPage.class);
		  selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
		  checkPriceAndAvailabityPage=PageFactory.initElements(wd, CheckPriceAndAvailabityPage.class);
		  
			if(isBrowserAlive=="N")
			{		
				
			loginPage.enterUserName("b.shephard");
			loginPage.enterPassword("Welcome1");
			loginPage.clickLoginButton();
			Thread.sleep(10000L);
			}
			
			wd.get(PROJECT.getProperty("DoosanParts5URL"));
			System.out.println(1);
			
			System.out.println(2);
			if (!selectOrgPage.verifyWelcomeText(wd,"b.shephard".trim()))
			{
				
				isBrowserAlive="N";
				wd.quit();
			}
			if(isBrowserAlive=="N")
			{

			selectOrgPage.searchByFirstDropdown("Brand");
			selectOrgPage.searchByContainingOptionDropdown("Doosan");
			selectOrgPage.clickSearchButton();
			selectOrgPage.clickFirstOrgLink(wd);
			

			}
		
			System.out.println("i am before compelted");
	}
	
	@Test (priority=1)
	public void verifyValidPartNumberAndQuantity()
	{
		homePage.clickHomeLink(wd);
		homePage.clickcheckPriceAndAvailabilityLink();
		homePage.verifyCheckPriceAndAvailabilityText();
		checkPriceAndAvailabityPage.enterValidPartNumber("65.09100-7080A");
		checkPriceAndAvailabityPage.enterValidQty("1");
		checkPriceAndAvailabityPage.clickCheckpriceAndAvailabityButton();
		wd.navigate().back();
	}
	
	@Test (priority=2)
	public void verifyInValidPartNumber()
	{
		homePage.clickHomeLink(wd);
		homePage.clickcheckPriceAndAvailabilityLink();
		homePage.verifyCheckPriceAndAvailabilityText();
		checkPriceAndAvailabityPage.clickClearForumButton();
		checkPriceAndAvailabityPage.enterInValidPartNumber("65.09100-7080A1");
		checkPriceAndAvailabityPage.enterValidQty("1");
		checkPriceAndAvailabityPage.clickCheckpriceAndAvailabityButton();
		checkPriceAndAvailabityPage.verifyPartNumberErrorMessage(wd);
		wd.navigate().back();
	}
	
	
	@Test (priority=4)
	public void verifyInValidQuantity()
	{
		homePage.clickHomeLink(wd);
		homePage.clickcheckPriceAndAvailabilityLink();
		homePage.verifyCheckPriceAndAvailabilityText();
		checkPriceAndAvailabityPage.clickClearForumButton();
		checkPriceAndAvailabityPage.enterValidPartNumber("65.09100-7080A");
		checkPriceAndAvailabityPage.enterInValidQty("-1");		
		checkPriceAndAvailabityPage.clickCheckpriceAndAvailabityButton();
		checkPriceAndAvailabityPage.verifyQuantityErrorMessage(wd);
		wd.navigate().back();
	}

	@Test (priority=5)
	public void verifyEmpty()
	{
		homePage.clickHomeLink(wd);
		homePage.clickcheckPriceAndAvailabilityLink();
		homePage.verifyCheckPriceAndAvailabilityText();
		checkPriceAndAvailabityPage.clickClearForumButton();
		checkPriceAndAvailabityPage.clickCheckpriceAndAvailabityButton();
		//checkPriceAndAvailabityPage.verifyPartNumberErrorMessage(wd);
		//checkPriceAndAvailabityPage.verifyQuantityErrorMessage(wd);
		wd.navigate().back();
	}


	@AfterMethod()
	public void onCheckPriceAndAvailabityPageValidatorTestFailure(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot("CheckPriceAndAvailabityPageValidatorTest", Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot("CheckPriceAndAvailabityPageValidatorTest", Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			wd.quit();
		}
	}*/
}
