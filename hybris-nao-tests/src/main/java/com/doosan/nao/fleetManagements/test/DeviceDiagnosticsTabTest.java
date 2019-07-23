package com.doosan.nao.fleetManagements.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.fleetManagements.page.AdminTabCodeTabsPages;
import com.doosan.nao.fleetManagements.page.FleetManagementEquipmentPage;
import com.doosan.nao.fleetManagements.page.HMCPage;
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

public class DeviceDiagnosticsTabTest extends TestInitializer {
	
	//https://ec5.qa.corp.doosan.com/hmc/hybris
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
String stemOfMes;
LoginPage loginpage;//=PageFactory.initElements(wd, LoginPage.class);
SelectOrgPage selectOrgPage;//=PageFactory.initElements(wd, SelectOrgPage.class);
HomePage homePage;//=PageFactory.initElements(wd, HomePage.class);
FleetManagementEquipmentPage fleetManagementPage;//=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
HMCPage hmcpage;
IOTPortalLoginPage iotLoginPage;
AdminTabCodeTabsPages adminCodeAddcomments;
PlanMaintenancePage planmaintenance;
ServiceTabPage serviceTab;
String HmcURL;
String hmcuserid;
String hmcPass;
String testRun;
String []testCaseID;
@Parameters(value = { "browser", "version", "platform", "osVersion","userName","password","brand","custNo" ,"testCaseIDs"})
@BeforeTest
public void setUpForLoginTest(String browser,
		String browserVersion, String platform, String osVersion,String userName ,String password, String brand,String custNo,String testCaseids )
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
		 HmcURL=PROJECT.getProperty("HMCEC5UR");
		 hmcuserid=PROJECT.getProperty("hmcUSer");
		 hmcPass=PROJECT.getProperty("hmcPassword");
		userName=userid;
		password=Pass;
		loginpage=PageFactory.initElements(wd, LoginPage.class);
		loginpage.toLoginPassport(userName, password,wd);
		selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
		homePage=PageFactory.initElements(wd, HomePage.class);
		fleetManagementPage=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
		hmcpage=PageFactory.initElements(wd, HMCPage.class);
		
		
		
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
@Parameters(value = { "browser","PassPortUSerName"})
@Test(priority=1)
public void ValidateFTMgmtDeviceDiagnostics(String browser,String passPortUSer){
	
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ****************** Validate device Diagnostics ******************");
		homePage.clickFleetManagementHeaderLink(wd);
		fleetManagementPage.verfyFleetManagementHeaderText(wd, testCaseID[0]);
		fleetManagementPage.frameID(wd);
		fleetManagementPage.selectResultsPerAge(wd,testCaseID[0]);
		fleetManagementPage.showTotalEquipments(wd);
		PortalEquipments=fleetManagementPage.getTableEquipment(wd,testCaseID[0]);
		System.out.println();
		System.out.println(" ****************** All Equipments in Grid ******************");
		System.out.println(PortalEquipments);
		
		passportEquipment=fleetManagementPage.getEquipmentNumber(wd);
		fleetManagementPage.clickDeviceDiagnosticsTab(wd);
		for (String string : PortalEquipments) {
			
			fleetManagementPage.enterSerialNumDignastic(wd, string.trim());
			fleetManagementPage.clickTestButton(wd);
			fleetManagementPage.getStatusResults();
		}
		//fleetManagementPage.enterSerialNumDignastic(wd, passportEquipment);
		//fleetManagementPage.clickTestButton(wd);
		
		/*try {
			wd = WebdriverSelector.getDriver(wd, browser);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			initialize(browser, "30", "", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*wd.get(HmcURL);
		
		hmcpage.enterUserNameAndPassword(hmcuserid, hmcPass);
		hmcpage.clickLoginButton();
		try{
			if(true==hmcpage.testLoginPage()){
				hmcpage.enterUserNameAndPassword(hmcuserid, hmcPass);
				hmcpage.clickLoginButton();
			}
			
		}catch(Exception e){
			System.out.println("Loogedin");
		}
		
		hmcpage.clickPassportLink(wd);
		hmcpage.clickPassportIdentitLink(wd);
		hmcpage.enterPassPortUSerNAme(passPortUSer);
		hmcpage.clickSearchButton();
		hmcpage.clickUserLineGrid(wd);
		String hmcSystemOfoptin=hmcpage.getselectedOptionsystemOfMeasurementSettings(wd);
		Assert.assertEquals(stemOfMes.toLowerCase().contains(hmcSystemOfoptin.trim().toLowerCase()), true);*/
		
		
		
}
@AfterTest
public void BrowserQuit(){
	
	wd.close();
	wd.quit();
}
@Test(priority=2)
public void validateInvalidEquipmentResults() {
	fleetManagementPage.enterSerialNumDignastic(wd, "A3NV239325");
	fleetManagementPage.clickTestButton(wd);
	fleetManagementPage.getStatusResults();
	
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
}
