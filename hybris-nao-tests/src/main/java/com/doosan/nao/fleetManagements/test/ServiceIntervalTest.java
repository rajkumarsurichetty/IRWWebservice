package com.doosan.nao.fleetManagements.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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
import com.doosan.nao.fleetManagements.page.IOTPortalHomePage;
import com.doosan.nao.fleetManagements.page.IOTPortalLoginPage;
import com.doosan.nao.fleetManagements.page.LoginPage;
import com.doosan.nao.fleetManagements.page.PlanMaintenancePage;
import com.doosan.nao.fleetManagements.page.SelectOrgPage;
import com.doosan.nao.fleetManagements.page.ServiceTabPage;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class ServiceIntervalTest extends TestInitializer{
	private static String browserName;
	private String isBrowserAlive = "N";
	public EventFiringWebDriver wd = null;
	public String methodName;
	public String localTestData;
	String IOTRetailThreshold;
	String PortalEditTheshold;
	String portalRetailThreshold;
	List <String > PortalEquipments;
	List<String>AssignMachines;
	Map<String, String>portalDetail;
	Map<String, String>iotEquipmentDetails;
	String passportEquipment;
	
	LoginPage loginpage;//=PageFactory.initElements(wd, LoginPage.class);
	SelectOrgPage selectOrgPage;//=PageFactory.initElements(wd, SelectOrgPage.class);
	HomePage homePage;//=PageFactory.initElements(wd, HomePage.class);
	FleetManagementEquipmentPage fleetManagementPage;//=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
	IOTPortalHomePage iotHomepage;
	IOTPortalLoginPage iotLoginPage;
	AdminTabCodeTabsPages adminCodeAddcomments;
	PlanMaintenancePage planmaintenance;
	ServiceTabPage serviceTab;
	String testRun;
	String []testCaseID;
	@Parameters(value = { "browser", "version", "platform", "osVersion","userName","password","brand","custNo","equipmentNo" ,"testCaseIDs"})
	@BeforeTest
	public void setUpForLoginTest(String browser,
			String browserVersion, String platform, String osVersion,String userName ,String password, String brand,String custNo,String equipmentNo ,String testCaseids)
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
			planmaintenance=PageFactory.initElements(wd, PlanMaintenancePage.class);
			iotLoginPage=PageFactory.initElements(wd, IOTPortalLoginPage.class);
			iotHomepage=PageFactory.initElements(wd,IOTPortalHomePage.class);
			serviceTab=PageFactory.initElements(wd, ServiceTabPage.class);
			
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
	@Parameters(value = { "equipmentNo","sliderChoice"})
	@Test(priority=1)
	public void testValidatefleetManagementLink(String equipmentNo,String sliderChoices){
		
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			System.err.println(" ****************** Validate service interval ******************");
			homePage.clickFleetManagementHeaderLink(wd);
			fleetManagementPage.verfyFleetManagementHeaderText(wd,testCaseID[0]);
			fleetManagementPage.frameID(wd);
			fleetManagementPage.enterEquipmentNumber(wd,equipmentNo);
			passportEquipment=fleetManagementPage.getEquipmentNumber(wd);
			fleetManagementPage.clickEquipmentLink(wd);
			fleetManagementPage.verifyDetailsText(wd);
			serviceTab.clickServiceTab(wd);
			serviceTab.sliderValue();
		//	serviceTab.setDefaultIntervalsOpint(wd);
			//serviceTab.setIntervalsOpint(wd, "100-200-1000-100");
			String intrvals=sliderChoices;
			//String []intr=intrvals.split("-");
		//	for (String string : intr) {
				serviceTab.setIntervalsRegular250(wd, intrvals);
				//serviceTab.setIntervalsRegular500(wd, intr[1]);
				//serviceTab.setIntervalsRegular1000(wd, intr[2]);
		//	}
			
			serviceTab.GetServiceSchedule(wd);
			
		//	serviceTab.getServiceHeaders();
		//  serviceTab.checkMoreinfoLink();
			
			
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
		
		wd.close();
		wd.quit();
	}

}
