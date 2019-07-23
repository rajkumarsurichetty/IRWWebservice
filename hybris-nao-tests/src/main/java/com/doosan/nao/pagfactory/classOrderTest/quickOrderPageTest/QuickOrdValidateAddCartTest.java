package com.doosan.nao.pagfactory.classOrderTest.quickOrderPageTest;

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

import com.doosan.nao.PageFactory.HomePage;
import com.doosan.nao.PageFactory.LoginPage;
import com.doosan.nao.PageFactory.QuickOrderPage;
import com.doosan.nao.PageFactory.SelectOrgPage;
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.input.InputReader;
import com.doosan.nao.reports.ReportGenerator;

public class QuickOrdValidateAddCartTest extends TestInitializer{
	
	private String browserName;
	private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;
	public  String testRunId;
	public String testCaseNumberID;
	String path;
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

	
	
	@Test(priority=1,dataProvider="QuickOrdValidateAddCartTest")
	public void validateSelectOrgPageTwoDropDownTest(String testData,String userName,String password, String brand, String custNo, String itemNum, String qty, String binLocation, String comments, String testUrlName,String testCaseNumber) throws InterruptedException
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
		HomePage homePage=PageFactory.initElements(wd, HomePage.class);
		QuickOrderPage quickOrderPage=PageFactory.initElements(wd, QuickOrderPage.class);
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
		
				
		selectOrgPage.verifyFirstDropDownisDisplayed(wd);
		selectOrgPage.getSelectedOptionFrmFirstDropDown(wd);
		selectOrgPage.verifyBySecondDropDown(wd);		
		selectOrgPage.searchByFirstDropdown("Brand");
		selectOrgPage.selectFirstDropDownValue(wd, brand);
		selectOrgPage.enterTextSecondContainsBox(custNo);
		selectOrgPage.clickSearchButton();
		selectOrgPage.clickFirstOrgLink(wd);
		homePage.clickQuickOrderLink(wd);
		quickOrderPage.isQuickOrderpageItemTableDisplay(wd);
		quickOrderPage.enterItemNumer(itemNum);
		quickOrderPage.enterQuantity(qty);
		quickOrderPage.enterBinLocation(binLocation);
		quickOrderPage.enterComments(comments);
		quickOrderPage.verifyItemNumisEntered(itemNum);
		quickOrderPage.verifyQuantityisEntered(qty);
		quickOrderPage.verifyBiLocationIsEntered(binLocation);
		quickOrderPage.verifyCommentsIsEntered(comments);
		quickOrderPage.clickaddToCart(wd);
		//quickOrderPage.verifyErrorisDispaly();
		//verifying the invalid item 
		try{
		if(quickOrderPage.VerifyitemNumberentries0.isDisplayed()){
			//quickOrderPage.getTwoErrorItemNum();
		quickOrderPage.VerifyitemNumberentries0();
		System.out.println("Item invalid Error Message is ==>"+quickOrderPage.VerifyitemNumberentries0.getText());
		}
		}catch(Throwable e){}
		//Verifying the invalid Quantity 
		try{
		if( quickOrderPage.Verifyquantityrentries0.isDisplayed())
		quickOrderPage.Verifyquantityrentries0();
		System.out.println(" Qntity invalid Error Message is ==> "+quickOrderPage.Verifyquantityrentries0.getText());
		}catch(Throwable e){
			
		}
		
		//Verifying the invalid bin input value
		try{
			if( quickOrderPage.Verifybinentries0.isDisplayed())
			quickOrderPage.Verifybinentries0();
			System.out.println( " Bin location invalid Error Message is ==> "+quickOrderPage.Verifybinentries0.getText());
			}catch(Throwable e){
				
			}
		
		//Verifying the invalid bin input value
				try{
					if( quickOrderPage.Verifycommententries0.isDisplayed())
					quickOrderPage.VerifyCommentEntries0();
					System.out.println( "Comment invalid  Error Message is ==> "+quickOrderPage.Verifycommententries0.getText());
					}catch(Throwable e){
						
					}
		/*quickOrderPage.isItemNumTextBoxDisplay(wd);
		quickOrderPage.isQuantityTextBoxDisplay(wd);
		quickOrderPage.isBindLocationTextBoxDisplay(wd);
		quickOrderPage.isCommentTextBoxDisplay(wd);
		quickOrderPage.isAddToCartDisplay(wd);
		quickOrderPage.isSelectAllCheckDisplay(wd);
		quickOrderPage.isAddLinesTextBoxDisplay(wd);
		quickOrderPage.isAddLinesButtonDisplay(wd);
		quickOrderPage.isExportExcelDisplay(wd);*/
		//selectOrgPage.getAllSearchBradValus(wd, brand);
		
				
	}
		

	
	@DataProvider(name="QuickOrdValidateAddCartTest")
	public static Object[][] getDataForShipments() throws InterruptedException
	{
		//TestInitializer.isBrowserAlive="N";
		return InputReader.getInputReader().getDataFromXLS("QuickOrdValidateAddCartTest");
		
	}
	
	
	@AfterMethod()
	public void onTestFailure(ITestResult result) throws IOException
	{int i=0;
		if (result.isSuccess())
		{
			isBrowserAlive="A";
		path=ReportGenerator.setLogAndCreateScreenshot("QuickOrdValidateAddCartTest~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			//addResultForTestCase("4603", "1350059", 1,"Test Passed  "+i++ );+ className + "_" + testCaseName + "_" + testData + "_"+ status +
			addResultForTestCase(testRunId,testCaseNumberID,1, "Qucik order page UI elements Test~ "+browserName+"__"+localTestData+"_"+Constants.PASSED+"\n"+"![](http://che-dt-idc1/Hybris/reports/Screenshots/"+path+")");
			isBrowserAlive="N";																																			//che-dt-idc1/Hybris/reports/Screenshots\QuickOrderPageUIElementsTest~chrome__TestData2_passed.jpg
			wd.quit();		
		} else 
		{//http://localhost/Hybris/Screenshots/
			path=ReportGenerator.setLogAndCreateScreenshot("QuickOrdValidateAddCartTest~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			addResultForTestCase(testRunId,testCaseNumberID,5, "Quick Order Page UI Elements Test failed ~ "+browserName+"__"+localTestData+"_"+Constants.FAILED+"\n"+result.getThrowable()+"![](http://che-dt-idc1/Hybris/reports/Screenshots/"+path+")");
			//addResultForTestCase("4603", "1350059", 5, "Test Failed");
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			wd.quit();
		}
	}

}
