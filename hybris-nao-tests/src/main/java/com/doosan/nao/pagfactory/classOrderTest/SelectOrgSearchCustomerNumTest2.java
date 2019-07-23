package com.doosan.nao.pagfactory.classOrderTest;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.PageFactory.LoginPage;
import com.doosan.nao.PageFactory.QuickOrderPage;
import com.doosan.nao.PageFactory.SelectOrgPage;
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.input.InputReader;
import com.doosan.nao.reports.ReportGenerator;

public class SelectOrgSearchCustomerNumTest2 extends TestInitializer {
	private String browserName;
	private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;
	public  String testRunId;
	public String testCaseNumberID;
	public String [] TCNum=null;
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@BeforeMethod
	public void setUpForSelectOrgPageTwoDropDownTest(String browser, String browserVersion, String platform, String osVersion) throws IOException, URISyntaxException, InterruptedException
	{ 	System.out.println(" Verify the SelectOrgPage UI Objects ");
		browserName=browser;
		if (isBrowserAlive=="N")
		{
		wd=WebdriverSelector.getDriver(wd, browser);
		
		initialize(browser, browserVersion, platform, osVersion);
		
			wd.get(PROJECT.getProperty("DoosanPassportURL"));
		}
		QuickOrderPage quickOrderPage =new QuickOrderPage();
		quickOrderPage.clearAllBrowserCache(wd);
	}

	
	
	@Test(priority=1,dataProvider="SelectOrgSearchCustomerNumTest2")
	public void validateSelectOrgPageTwoDropDownTest(String testData,String userName,String password, String brand, String custNo, String OrgName, String qty, String binLocation, String comments, String testUrlName,String testCaseNumber) throws InterruptedException
	{	testRunId=PROJECT.getProperty("testRunID");
		testCaseNumberID=testCaseNumber;
		System.out.println("1350059");
		TCNum=testCaseNumber.split(",");
		for (String tcNum : TCNum) {
			System.out.println("TestCase No ->"+tcNum);
		}
		
		this.localTestData=testData;
		
		LoginPage loginPage=PageFactory.initElements(wd, LoginPage.class);
		SelectOrgPage selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
		
				
		if(isBrowserAlive=="N")
		{
			loginPage.enterUserName(userName.trim());
		loginPage.enterPassword(password.trim());
		loginPage.clickLoginButton();
		Thread.sleep(10000L);
		}
		
		wd.get(PROJECT.getProperty("DoosanParts5URL"));
		//wd.get("http://parts3.qa.corp.doosan.com/");
		if (!selectOrgPage.verifyWelcomeText(wd,userName.trim()))
		{
			System.out.println("i am in browser validation");
			isBrowserAlive="N";
			//wd.quit();
		}
		
				
		/*selectOrgPage.searchByFirstDropdown("Brand");
		selectOrgPage.searchByContainingOptionDropdown(brand.trim());
		selectOrgPage.enterCustomerNo(custNo.trim());
		selectOrgPage.clickSearchButton();
		selectOrgPage.clickFirstOrgLink(wd);*/
		selectOrgPage.verifyFirstDropDownisDisplayed(wd);
		selectOrgPage.getSelectedOptionFrmFirstDropDown(wd);
		selectOrgPage.verifyBySecondDropDown(wd);
		selectOrgPage.getSelectedOptionFrmSecondDropDown(wd);
		selectOrgPage.enterTextSecondContainsBox(custNo);
		selectOrgPage.clickSearchButton();
		selectOrgPage.verifyOrganizationCustomerSearchReasults(wd, custNo);
		
				
	}
		//@Test(priority=2,dataProvider="SelectOrgPageUITest")
		public void checkDropdownOptions(String testData,String userName,String password, String brand, String custNo, String itemNo, String qty, String binLocation, String comments, String testUrlName,String testCaseNumber) {
			System.out.println("checkDropdownOptions....1350060......>>>>>>>> ");
			
			
			
			
		}

	
	@DataProvider(name="SelectOrgSearchCustomerNumTest2")
	public static Object[][] getDataForShipments() throws InterruptedException
	{
		//TestInitializer.isBrowserAlive="N";
		return InputReader.getInputReader().getDataFromXLS("SelectOrgSearchCustomerNumTest2");
		
	}
	
	
	@AfterMethod()
	public void onTestFailure(ITestResult result) throws IOException
	{int i=0;
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot("SelectOrgSearchCustomerNumTest2~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			//addResultForTestCase("4603", "1350059", 1,"Test Passed  "+i++ );+ className + "_" + testCaseName + "_" + testData + "_"+ status +
			addResultForTestCase(testRunId,testCaseNumberID, 1, "Select Organization elements Select Org and Search by Customer Test~ "+browserName+"__"+localTestData+"_"+Constants.PASSED+"\n"+"![](http://localhost/HybrisAWSCons/SelectOrgPageUITest~"+browserName+"__"+localTestData+"_"+Constants.PASSED+".jpg)");
			isBrowserAlive="N";
			wd.quit();		
		} else 
		{//http://localhost/Hybris/Screenshots/
			ReportGenerator.setLogAndCreateScreenshot("SelectOrgSearchCustomerNumTest2~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			addResultForTestCase(testRunId,testCaseNumberID, 5, "Select Organization elements Select Org and Search by Customer Test~ "+browserName+"__"+localTestData+"_"+Constants.PASSED+"\n"+"![](http://localhost/HybrisAWSCons/SelectOrgPageUITest~"+browserName+"__"+localTestData+"_"+Constants.PASSED+".jpg)");
			//addResultForTestCase("4603", "1350059", 5, "Test Failed");
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			wd.quit();
		}
	}

}
