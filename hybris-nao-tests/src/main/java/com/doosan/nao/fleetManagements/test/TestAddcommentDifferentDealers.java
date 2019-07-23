package com.doosan.nao.fleetManagements.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.fleetManagements.page.AdminTabCodeTabsPages;
import com.doosan.nao.fleetManagements.page.FleetManagementEquipmentPage;
import com.doosan.nao.fleetManagements.page.HomePage;
import com.doosan.nao.fleetManagements.page.LoginPage;
import com.doosan.nao.fleetManagements.page.SelectOrgPage;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class TestAddcommentDifferentDealers extends TestInitializer {
	
	private static String browserName;
	private String isBrowserAlive = "N";
	public EventFiringWebDriver wd = null;
	public String methodName;
	public String localTestData;
	
	public String equipemntNofromCommon;
	LoginPage loginpage;
	SelectOrgPage selectOrgPage;
	HomePage homePage;
	FleetManagementEquipmentPage fleetManagementPage;
	AdminTabCodeTabsPages adminCodeAddcomments;
	List <String > PortalEquipments;
	String testRun;
	String []testCaseID;
	
	@Parameters(value = { "browser", "version", "platform", "osVersion","userName","password","brand","custNo","testCaseIDs" })
	@BeforeTest
	public void setUpForLoginTest(String browser,
			String browserVersion, String platform, String osVersion,String userName ,String password, String brand,String custNo ,String testcaseIds ,String testCaseids)
			throws IOException, URISyntaxException, InterruptedException {
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			System.err.println(browser);
			browserName = browser;
			testCaseID=testCaseids.split(",");
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
			loginpage.toLoginPassport(userName, password,wd);
			selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
			homePage=PageFactory.initElements(wd, HomePage.class);
			fleetManagementPage=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
			adminCodeAddcomments=PageFactory.initElements(wd, AdminTabCodeTabsPages.class);
			selectOrgPage.searchByFirstDropdown("Brand");
			selectOrgPage.searchByContainingOptionDropdown(brand.trim());
			selectOrgPage.enterCustomerNo(wd,custNo.trim());
			selectOrgPage.clickSearchButton(wd);
			selectOrgPage.clickFirstOrgLink(wd);
			try {
				TestFleetManagement.waitforpagetoload(wd);
			} catch (Exception e) {			}
			
		}
	}
	@Test(priority=1)
	public void testclickFleetManagementLink1489(){
		homePage.clickFleetManagementHeaderLink(wd);
		fleetManagementPage.verfyFleetManagementHeaderText(wd,testCaseID[0]);
		fleetManagementPage.frameID(wd);
		fleetManagementPage.clickEquipmentListTab(wd);
		fleetManagementPage.selectResultsPerAge(wd,testCaseID[0]);
		fleetManagementPage.showTotalEquipments(wd);
		fleetManagementPage.getEquipmentsFromGrid1489(wd);
	}
	
	@Test(priority=2)@Parameters(value={"custNo2"})
	public void testclickFleetManagementLink1725(String custNo){
		fleetManagementPage.clickChangeLink(wd);
		selectOrgPage.enterCustomerNo(wd,custNo.trim());
		selectOrgPage.clickSearchButton(wd);
		selectOrgPage.clickFirstOrgLink(wd);
		//homePage.clickFleetManagementHeaderLink(wd);
		fleetManagementPage.verfyFleetManagementHeaderText(wd,testCaseID[0]);
		fleetManagementPage.frameID(wd);
		fleetManagementPage.clickEquipmentListTab(wd);
		fleetManagementPage.selectResultsPerAge(wd,testCaseID[0]);
		fleetManagementPage.showTotalEquipments(wd);
		fleetManagementPage.getEquipmentsFromGrid1725(wd);
		fleetManagementPage.commonEquipments();
	}
	
	@Test(priority=3)
	public void testVrifyAddcommentLinkfor1725(){
		equipemntNofromCommon= fleetManagementPage.getEquipmentCommonList();
		fleetManagementPage.getEquimentWebelement(wd,equipemntNofromCommon);
		fleetManagementPage.clickEquipmentNo(wd);
		adminCodeAddcomments.verifyAddComnetLink(wd);
		adminCodeAddcomments.clickAddCommentLink(wd);
		adminCodeAddcomments.headerNewComments(wd);
		adminCodeAddcomments.clickCancelNewcommentPopup(wd);
	}
	
	@Test(priority=4)
	public void testValidateAddNewComments() {
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("****** Test Adding new comment ********");
		adminCodeAddcomments.clickAddCommentLink(wd);
		adminCodeAddcomments.enterNewcomments();
		adminCodeAddcomments.clickSaveNewComment(wd);

	}
	@Test(priority=5)
	public void testValidateTotalComments() {
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" *******  Test verifying total comments in grid ***********");
		adminCodeAddcomments.getTableRows(wd);
		adminCodeAddcomments.verifyNewCommentAddedOrNot(wd);
		adminCodeAddcomments.verifycommentAvailableInList();
		wd.switchTo().defaultContent();
		
	}
	
	
	/**
	 * This test method verifying the added new comment in another dealer 1489
	 */
	@Test(priority=6)
	@Parameters(value={"custNo"})
	public void testNewCommentaddedinAnotherDealer(String custNo){
		fleetManagementPage.clickChangeLink(wd);
		selectOrgPage.enterCustomerNo(wd,custNo.trim());
		selectOrgPage.clickSearchButton(wd);
		selectOrgPage.clickFirstOrgLink(wd);
		//homePage.clickFleetManagementHeaderLink(wd);
		fleetManagementPage.verfyFleetManagementHeaderText(wd,testCaseID[0]);
		fleetManagementPage.frameID(wd);
		fleetManagementPage.clickEquipmentListTab(wd);
		fleetManagementPage.selectResultsPerAge(wd,testCaseID[0]);
		fleetManagementPage.showTotalEquipments(wd);
		fleetManagementPage.getEquimentWebelement(wd,equipemntNofromCommon);
		fleetManagementPage.clickEquipmentNo(wd);
		adminCodeAddcomments.verifyNewCommentAddedOrNot(wd);
		adminCodeAddcomments.verifycommentAvailableInListforAnoterDealer();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod()
	public void onTestFailure(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot(methodName+"~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			isBrowserAlive="N";
			//wd.close();	
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot(methodName+"~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			//wd.quit();
		}
	}
	@AfterTest
	public void BrowserQuit(){
		//test
		wd.close();
		wd.quit();
	}
}