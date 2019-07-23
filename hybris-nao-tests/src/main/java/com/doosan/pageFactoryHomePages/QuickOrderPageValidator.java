package com.doosan.pageFactoryHomePages;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class QuickOrderPageValidator extends TestInitializer {

	/*private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;

	public HomePage homePage=null;
	public LoginPage loginPage=null;
	public SelectOrgPage selectOrgPage=null;
	public CheckPriceAndAvailabityPage checkPriceAndAvailabityPage=null;
	public BatchOrderUploadPage batchOrderUploadPage=null;
	public QuickOrderPage quickOrderPage=null;
	
	

	
	@BeforeMethod
	public void setUpForBatchOrderUploadValidator() throws IOException, URISyntaxException, InterruptedException
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
	
	@Test (priority=1)
	public void verifyQuickOrderResultTableHeader() throws InterruptedException
	{	
		quickOrderPage.verifyQuickOrderPageHeaders(wd);
		Thread.sleep(3000L);
	}
	
	@Test (priority=2)
	public void verifyInvalidItemNumberErrorMessage()
	{
		
		quickOrderPage.enterItemNumer("00000000");
		quickOrderPage.clickaddToCart(wd);
		quickOrderPage.verifyQuickOrderItemErrorMessageInTable();
		quickOrderPage.verifyRemoveAllInvalidLinesButton();
	}
	
	@Test (priority=3)
	public void verifyInvalidQtyErrorMessage()
	{	
		quickOrderPage.enterQuantity("-1212");
		quickOrderPage.clickaddToCart(wd);
		quickOrderPage.verifyQuickOrderQtyErrorMessageInTable();
		quickOrderPage.verifyRemoveAllInvalidLinesButton();

	}
	
	@Test (priority=4)
	public void verifyInvalidBinLocationErrorMessage()
	{	
		quickOrderPage.enterBinLocation("!@#$@");
		quickOrderPage.clickaddToCart(wd);
		quickOrderPage.verifyQuickOrderBinErrorMessageInTable();
		quickOrderPage.verifyRemoveAllInvalidLinesButton();
	}
	
	@Test (priority=5)
	public void verifyInvalidCommentsErrorMessage()
	{
		quickOrderPage.enterComments("!@#$@");
		quickOrderPage.clickaddToCart(wd);
		quickOrderPage.verifyQuickOrderCommentsErrorMessageInTable();
		quickOrderPage.verifyRemoveAllInvalidLinesButton();
	}
	
	
	@AfterMethod()
	public void tearDownBatchOrderUploadFile(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot("QuickOrderPageValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot("QuickOrderPageValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			wd.quit();
		}
	}*/

}
