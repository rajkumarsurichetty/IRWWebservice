package com.doosan.nao.pagfactory.classOrderTest;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.PageFactory.HomePage;
import com.doosan.nao.PageFactory.LoginPage;
import com.doosan.nao.PageFactory.SelectOrgPage;
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class HomePageTest extends TestInitializer{

	private String browserName;
	private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;
	LoginPage loginpage;//=PageFactory.initElements(wd, LoginPage.class);
	SelectOrgPage selectOrgPage;//=PageFactory.initElements(wd, SelectOrgPage.class);
	HomePage homePage;//=PageFactory.initElements(wd, HomePage.class);
	
	//HomePage homePage;
	@Parameters(value = { "browser", "version", "platform", "osVersion","userName","password","brand","custNo" })
	@BeforeTest
	public void setUpForClassOneOrderValidatorTest(String browser,
			String browserVersion, String platform, String osVersion,String userName ,String password, String brand,String custNo) throws IOException, URISyntaxException, InterruptedException
	{	this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
	System.err.println(browser);
	browserName = browser;
	this.localTestData=userName;
	if (isBrowserAlive == "N") {
	wd = WebdriverSelector.getDriver(wd, browser);
	initialize(browser, browserVersion, platform, osVersion);
	wd.get(PROJECT.getProperty("DoosanParts5URL"));
	String userid=PROJECT.getProperty("userName");
	String Pass=PROJECT.getProperty("Password");
	
	userName=userid;
	password=Pass;
	loginpage=PageFactory.initElements(wd, LoginPage.class);
	loginpage.toLoginPassportPortal(userName, password,wd);
	selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
	homePage=PageFactory.initElements(wd, HomePage.class);
	
	selectOrgPage.searchByFirstDropdown("Brand");
	selectOrgPage.searchByContainingOptionDropdown(brand.trim());
	selectOrgPage.enterCustomerNo(custNo.trim());
	selectOrgPage.clickSearchButton();
	selectOrgPage.clickFirstOrgLink(wd);
	try {
		waitforpagetoload(wd);
	} catch (Exception e) {			}
	
}

		/*browserName=browser;
		if (isBrowserAlive=="N")
		{
		wd=WebdriverSelector.getDriver(wd, browser);
		
		initialize(browser, browserVersion, platform, osVersion);
		
		wd.get(PROJECT.getProperty("DoosanParts5URL"));
		}*/
	}
	
	
	
	@Test(priority=1)
	public void validateSaveQuickLinkTop(){
		homePage.clickSavedCartsLink();
		homePage.verifySaveCartLink(wd);
	}
	@Test(priority=2)
	public void validatePriceAndAvailabilityQucikLinkTop(){
		homePage.clickPriceAndAvaliablityLink();
		homePage.verifyPriceAndAvaliablityLink(wd);
	}
	@Test(priority=3)
	public void validateQuickOrderQucikLinkTop(){
		homePage.clickQuickOrderLink(wd);
		homePage.verifyQuickOrderLink(wd);
	}
	@Test(priority=4)
	public void validateBatchOrderUploadQucikLinkTop(){
		homePage.clickBatchOrderUploadLink();
		homePage.verifyBatchOrderUploadLink(wd);
	}
	
	@Test(priority=5)
	public void validateAccountHistoryQucikLinkTop(){
		homePage.clickOrderHistoryLink();
		homePage.verifyAccountHistoryLink(wd);
	}
	
	@Test(priority=6)
	public void validateClickCreateANewOrderLink(){
		homePage.clickCreateNewOrderLink(wd);
		homePage.verifyQuickOrderText(wd);
	}
	
	@Test(priority=7)
	public void validateUpLoadAnExcelPartsListLink(){
		homePage.clickuploadAnExcelPartsListLink(wd);
		homePage.verifyUploadAnExcelPartsListText();
	}
	
	@Test(priority=8)
	public void validateviewSavedShoppingCartsLink(){
		homePage.clickviewSavedShoppingCartsLink(wd);
		homePage.verifyViewSavedShoppingCartsText();
	}
	@Test(priority=9)
	public void validatecheckPriceAndAvailabilityLink(){
		homePage.clickcheckPriceAndAvailabilityLink(wd);
		homePage.verifyCheckPriceAndAvailabilityText();
	}
	
	
	@Test(priority=10)
	public void validateSearchInvoicesLink(){
		homePage.clickSearchInvoicesLink(wd);
		homePage.verifySearchInvoicesLink(wd);
	}

	@Test(priority=11)
	public void validateSearchOrdersLink(){
		homePage.clickSearchOrdersLink(wd);
		homePage.verifySearchOrdersLink(wd);
	}
	
	@Test(priority=12)
	public void validateDefaultShipmentsLink(){
		homePage.clickDefaultShipmentsLink(wd);
		homePage.verifyDefaultShipmentsLink(wd);
	}
	@Test(priority=13)
	public void validateProductDiagnosticsLink(){
		homePage.clickproductDiagnosticsLink(wd);
		homePage.verifyproductDiagnosticsLink(wd);
	}
	
	
	
	
	//@Test(priority=10)
	
	public void validateFleetManagementQuickLinkTop(String brand ,String custNo) throws InterruptedException
	{
		/*String userid=PROJECT.getProperty("userName");
		String Pass=PROJECT.getProperty("Password");
		
		this.localTestData=new Object(){}.getClass().getEnclosingMethod().getName();
		methodName=localTestData;
		LoginPage loginPage=PageFactory.initElements(wd, LoginPage.class);
		SelectOrgPage selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
		 homePage=PageFactory.initElements(wd, HomePage.class);
		QuickOrderPage quickOrderPage=PageFactory.initElements(wd, QuickOrderPage.class);
		
		
		
		if(isBrowserAlive=="N")
		{
			loginPage.enterUserName(userid.trim());
			loginPage.enterPassword(Pass.trim());
		loginPage.clickLoginButton();
		Thread.sleep(10000L);
		}
		
		
		if (!selectOrgPage.verifyWelcomeText(wd,userid.trim()))
		{
			isBrowserAlive="N";
			//wd.quit();
		}
		
		//homePage.clickChange();
		
		selectOrgPage.searchByFirstDropdown("Brand");
		selectOrgPage.searchByContainingOptionDropdown(brand.trim());
		selectOrgPage.enterCustomerNo(custNo.trim());
		selectOrgPage.clickSearchButton();
		selectOrgPage.clickFirstOrgLink(wd);*/
		homePage.clickFleetmanagementLink(wd);
		homePage.verifyFleetManagementLink(wd);
		
		
	}
	
	//Allmakes this for doosan
	
	
	//Online parts catalog new tab function 
	
	//Bobcat Merchandise  new tab function
	
	@AfterMethod()
public void onTestFailure(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot(methodName+"~"+browserName, "HomePage", localTestData, Constants.PASSED, wd);
			isBrowserAlive="N";
			//wd.close();	
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot(methodName+"~"+browserName, "HomePage", localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			//wd.quit();
		}
	}
	@AfterTest
	public void BrowserQuit(){
		
		wd.close();
		wd.quit();
	}
}

