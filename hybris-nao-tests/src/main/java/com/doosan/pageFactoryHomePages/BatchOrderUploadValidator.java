package com.doosan.pageFactoryHomePages;

import java.io.File;
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
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class BatchOrderUploadValidator extends TestInitializer {

	private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;

	public HomePage homePage=null;
	public LoginPage loginPage=null;
	public SelectOrgPage selectOrgPage=null;
	public CheckPriceAndAvailabityPage checkPriceAndAvailabityPage=null;
	public BatchOrderUploadPage batchOrderUploadPage=null;
	public QuickOrderPage quickOrderPage=null; 
	
	public String validFile=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"ValidFile.xls";
	public String inValidFile=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"InvalidFile.xls";
	public String MoreLineInvalidFile=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"InvalidLineItems.xls";
	
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
	public void verifyValidFileInBatchOrderUploadPage()
	{
		homePage.clickHomeLink(wd);
		homePage.clickBatchOrderUploadLink();
		homePage.verifyUploadAnExcelPartsListText();
		batchOrderUploadPage.uploadInValidfile(validFile);
		batchOrderUploadPage.clickUploadButton();
		quickOrderPage.verifyQuickOrderTextForValidFile();	
		wd.navigate().back();
	}
	
	@Test (priority=2)
	public void verifyInValidFileInBatchOrderUploadPage()
	{
		homePage.clickHomeLink(wd);
		homePage.clickBatchOrderUploadLink();
		homePage.verifyUploadAnExcelPartsListText();
		batchOrderUploadPage.uploadInValidfile(inValidFile);
		batchOrderUploadPage.clickUploadButton();
		quickOrderPage.verifyQuickOrderTextForInValidFile();
		wd.navigate().back();
	}
	
	
	@Test (priority=3)
	public void verifyMoreThanExpectedLineFileInBatchOrderUploadPage()
	{
		homePage.clickHomeLink(wd);
		homePage.clickBatchOrderUploadLink();
		homePage.verifyUploadAnExcelPartsListText();
		batchOrderUploadPage.uploadMoreThanExpectedLinefile(MoreLineInvalidFile);
		batchOrderUploadPage.clickUploadButton();
		quickOrderPage.verifyQuickOrderTextForMultipleItemFile();
		
	}
	
	

	@AfterMethod()
	public void tearDownBatchOrderUploadFile(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot("Class48HoursOrderValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot("Class48HoursOrderValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			wd.quit();
		}
	}

	
}
