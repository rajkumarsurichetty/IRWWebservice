package com.doosan.pageFactoryHomePages;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.doosan.nao.PageFactory.BatchOrderUploadPage;
import com.doosan.nao.PageFactory.CheckPriceAndAvailabityPage;
import com.doosan.nao.PageFactory.HomePage;
import com.doosan.nao.PageFactory.LoginPage;
import com.doosan.nao.PageFactory.QuickOrderPage;
import com.doosan.nao.PageFactory.SelectOrgPage;
import com.doosan.nao.PageFactory.YourShoppingCartPage;
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class YourShoppingCartPageValidator extends TestInitializer {


	/*private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;

	public HomePage homePage=null;
	public LoginPage loginPage=null;
	public SelectOrgPage selectOrgPage=null;
	public CheckPriceAndAvailabityPage checkPriceAndAvailabityPage=null;
	public BatchOrderUploadPage batchOrderUploadPage=null;
	public QuickOrderPage quickOrderPage=null;
	public YourShoppingCartPage yourShoppingCartPage=null;
	

	
	@BeforeMethod
	public void setUpForYourShoppingCartPageValidator() throws IOException, URISyntaxException, InterruptedException
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
		  batchOrderUploadPage=PageFactory.initElements(wd, BatchOrderUploadPage.class);
		  quickOrderPage=PageFactory.initElements(wd, QuickOrderPage.class);
		  yourShoppingCartPage=PageFactory.initElements(wd, YourShoppingCartPage.class);
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
			
			homePage.clickHomeLink(wd);
			homePage.clickQuickOrderLink(wd);
			homePage.verifyQuickOrderText(wd);		

			}
		
	}
	
	@Test(priority=1)
	public void verifyCartSummaryReslultTable()
	{
		quickOrderPage.enterItemNumer("65.09100-7080A");
		quickOrderPage.enterQuantity("1");
		quickOrderPage.enterComments("test");
		quickOrderPage.enterBinLocation("10 test");
		quickOrderPage.clickaddToCart(wd);
	}
	
	@Test(priority=2)
	public void verifyCartSummaryReslultTableHeader()
	{
		yourShoppingCartPage.verfiyCartSummaryHeader(wd);
	}
	
	@Test(priority=3)
	public void verifyVoucherCodeLookUp()
	{
		if(yourShoppingCartPage.verifyVoucherCodeLookupLink(wd))
		{
			yourShoppingCartPage.clickVoucherCodeLookupLink(wd);
			if(yourShoppingCartPage.verifyVoucherCodeLookupHeader(wd))
			{
				yourShoppingCartPage.clickVoucherCode(wd);
				yourShoppingCartPage.clickVoucherCodeRemoveLink(wd);
			}
		}
	}
	
	
	
	@AfterMethod()
	public void tearDownYourShoppingCartPageValidator(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot("YourShoppingCartPageValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot("YourShoppingCartPageValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			wd.quit();
		}
	}*/


}
