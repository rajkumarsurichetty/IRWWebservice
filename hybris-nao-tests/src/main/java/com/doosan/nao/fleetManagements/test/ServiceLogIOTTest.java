package com.doosan.nao.fleetManagements.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class ServiceLogIOTTest extends TestInitializer {
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
	String testRun;
	String []testCaseID;
	@Parameters(value = { "browser", "version", "platform", "osVersion","userName","password","brand","custNo","testCaseIDs" })
	@BeforeTest
	public void setUpForLoginTest(String browser,
			String browserVersion, String platform, String osVersion,String userName ,String password, String brand,String custNo ,String testCaseids)
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
			selectOrgPage.searchByFirstDropdown("Brand");
			selectOrgPage.searchByContainingOptionDropdown(brand.trim());
			selectOrgPage.enterCustomerNo(wd,custNo.trim());
			selectOrgPage.clickSearchButton(wd);
			selectOrgPage.clickFirstOrgLink(wd);
			try {
				waitforpagetoload(wd);
			} catch (Exception e) {			}
			
		}
	
	}
	@Test(priority=1)
	public void testValidatefleetManagementLink(){
		
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			System.err.println(" ****************** Validate Fleet Managemnet Link ******************");
			homePage.clickFleetManagementHeaderLink(wd);
			fleetManagementPage.verfyFleetManagementHeaderText(wd,testCaseID[0]);
			
			
	}
	/**
	 * @throws InterruptedException
	 */
	@Test(priority=2)
	public void testValidateFleetmanagementTabs() throws InterruptedException
	{this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ****************** Validate FM Tabs ******************");
		fleetManagementPage.frameID(wd);
		fleetManagementPage.clickManageNotificationTab(wd);
		fleetManagementPage.clickManageGeofenceTab(wd);
		fleetManagementPage.clickSettingTab(wd);
		fleetManagementPage.clickEquipmentListTab(wd);
		try{
		Thread.sleep(2000);
		
		}catch (Exception e)	{		}
	}
	
	@Test(priority=3)
	public void testValidateEquipmentsInGrid() 
	{
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ****************** Validates Equipment Grid ******************");
			fleetManagementPage.selectResultsPerAge(wd,testCaseID[0]);
			fleetManagementPage.showTotalEquipments(wd);
			PortalEquipments=fleetManagementPage.getTableEquipment(wd,testCaseID[0]);
			System.out.println();
			System.out.println(" ****************** All Equipments in Grid ******************");
			System.out.println(PortalEquipments);
			passportEquipment=fleetManagementPage.getEquipmentNumber(wd);
			fleetManagementPage.clickEquipmentLink(wd);
			
			fleetManagementPage.verifyDetailsText(wd);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				 
				e.printStackTrace();
			}
			
	
		{
			
		}
	
		
	}
	
	
	@Parameters(value = { "browser", "version", "platform", "osVersion","iotUSer","iotPassword"})
	@Test(priority=41)
	public void testValidateEquipmetsIOTtoFMPortal(String browser,
			String browserVersion, String platform, String osVersion,String IOTUser,String IOTPassword){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ****************** Validate IOT Equipmets to Portal Total Equipments ****************** ");
		
		wd.get(PROJECT.getProperty("IOTPortalURL"));
		iotLoginPage.EnterUserName(wd,IOTUser);
		iotLoginPage.enterPassword(IOTPassword);
		iotLoginPage.clickLoginButton();
		//iotHomepage.clickOrganizationSwitch(wd);
		//iotHomepage.selectEnvironment(wd);
		iotHomepage.clickThings(wd);
		iotHomepage.clickHereForMoreOrg(wd);
		iotHomepage.clickOrganizationLik(wd);
		iotHomepage.clickActiveEquipments(wd);
		iotHomepage.selectDealer(wd);
		iotHomepage.clickThingsTableTab(wd);
		List<String>IOTequipment =iotHomepage.getIOTEquipmentsTable(wd);
		System.out.println("Equipmets are");
		System.out.println(IOTequipment);
		System.out.println(IOTequipment.containsAll(PortalEquipments));
		//Assert.assertEquals(IOTequipment.containsAll(PortalEquipments), true);
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
	
	//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
