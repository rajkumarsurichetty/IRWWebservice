package com.doosan.nao.fleetManagements.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
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
import com.doosan.nao.fleetManagements.page.IOTPortalLoginPage;
import com.doosan.nao.fleetManagements.page.LoginPage;
import com.doosan.nao.fleetManagements.page.PlanMaintenancePage;
import com.doosan.nao.fleetManagements.page.SelectOrgPage;
import com.doosan.nao.fleetManagements.page.ServiceTabPage;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class LanguageSupportToUserTest extends TestInitializer {
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
	String hybrisUserid;
	String hybrisPass;
	String curentOrgURL;
	@Parameters(value = { "browser", "version", "platform", "osVersion","userName","password","brand","custNo" })
	@BeforeTest
	public void setUpForLoginTest(String browser,
			String browserVersion, String platform, String osVersion,String userName ,String password, String brand,String custNo )
			throws IOException, URISyntaxException, InterruptedException {
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			System.err.println(browser);
			browserName = browser;
			this.localTestData=userName;
			if (isBrowserAlive == "N") {
			wd = WebdriverSelector.getDriver(wd, browser);
			initialize(browser, browserVersion, platform, osVersion);
			wd.get(PROJECT.getProperty("HMCEC5UR"));
			hybrisUserid=PROJECT.getProperty("userName");
			hybrisPass=PROJECT.getProperty("Password");
			 HmcURL=PROJECT.getProperty("HMCEC5UR");
			 hmcuserid=PROJECT.getProperty("hmcUSer");
			 hmcPass=PROJECT.getProperty("hmcPassword");
			
			loginpage=PageFactory.initElements(wd, LoginPage.class);
			selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
			homePage=PageFactory.initElements(wd, HomePage.class);
			fleetManagementPage=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
			hmcpage=PageFactory.initElements(wd, HMCPage.class);
			
			
			
			/*selectOrgPage.searchByContainingOptionDropdown(brand.trim());
			selectOrgPage.enterCustomerNo(wd,custNo.trim());
			selectOrgPage.clickSearchButton(wd);
			selectOrgPage.clickFirstOrgLink(wd);*/
			try {
				TestFleetManagement.waitforpagetoload(wd);
			} catch (Exception e) {			}
			
		}

	}
	@Parameters(value = { "browser","PassPortUSerName"})
	@Test(priority=1)
	public void testLanguageSupportToUserTest(String browser,String passPortUSer){
		
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			System.err.println(" ****************** Validate language support to user ******************");
			
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
			//wd.get(HmcURL);
			
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
			hmcpage.enterLocale(wd,"fr");
			hmcpage.clickSave(wd);
			
			wd.get(PROJECT.getProperty("DoosanParts5URL"));
			loginpage.toLoginPassport(hybrisUserid, hybrisPass,wd);
			
			selectOrgPage.searchByFirstDropdown("Brand");
			selectOrgPage.getSelectOrganizationHeaderText();
			selectOrgPage.verifySelectOrganizationHeader("S�lectionnez une organisation");
			wd.get("https://portal-hybris.qa.dice-tools.com/naoorgselector/");
			selectOrgPage.searchByFirstDropdown("Brand");
			selectOrgPage.getSelectOrganizationHeaderText();
			selectOrgPage.verifySelectOrganizationHeader("S�lectionnez une organisation");
			wd.get("https://portal-hybris.qa.dice-tools.com/naoorgselector/en/login");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			selectOrgPage.searchByFirstDropdown("Brand");
			selectOrgPage.getSelectOrganizationHeaderText();
			selectOrgPage.verifySelectOrganizationHeader("S�lectionnez une organisation");
			curentOrgURL=wd.getCurrentUrl();
			selectOrgPage.verifySelectOrganizationURL(curentOrgURL);
			wd.get(PROJECT.getProperty("HMCEC5UR"));
			/*hmcpage.enterUserNameAndPassword(hmcuserid, hmcPass);
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
			hmcpage.clickUserLineGrid(wd);*/
			hmcpage.enterLocale(wd,"en");
			hmcpage.clickSave(wd);
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
