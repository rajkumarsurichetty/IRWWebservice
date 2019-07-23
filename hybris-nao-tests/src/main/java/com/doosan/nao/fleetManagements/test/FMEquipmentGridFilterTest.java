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
	import com.doosan.nao.init.TestInitializer;
	import com.doosan.nao.init.WebdriverSelector;
	import com.doosan.nao.reports.ReportGenerator;

 public class FMEquipmentGridFilterTest extends TestInitializer { 


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
		String IOTEnvironment;
		LoginPage loginpage;//=PageFactory.initElements(wd, LoginPage.class);
		SelectOrgPage selectOrgPage;//=PageFactory.initElements(wd, SelectOrgPage.class);
		HomePage homePage;//=PageFactory.initElements(wd, HomePage.class);
		FleetManagementEquipmentPage fleetManagementPage;//=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
		IOTPortalHomePage iotHomepage;
		IOTPortalLoginPage iotLoginPage;
		AdminTabCodeTabsPages adminCodeAddcomments;
		PlanMaintenancePage planmaintenance;
		String userid;
		String Pass;
		String testRun;
		String []testCaseID;
		String testCase_Id;
		String path;
		@Parameters(value = { "browser", "version", "platform", "osVersion","userName","password","brand","custNo" ,"testCaseIDs"})
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
				 userid=PROJECT.getProperty("userName");
				 Pass=PROJECT.getProperty("Password");
				IOTEnvironment=PROJECT.getProperty("IOTEvn");
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
				System.err.println(" ****************** Validate Fleet Managemnet Link 67827******************");
				testCase_Id=testCaseID[0];
				homePage.clickFleetManagementHeaderLink(wd);
				fleetManagementPage.verfyFleetManagementHeaderText(wd, testCase_Id);//1387118
				
				
		}
		/**
		 * @throws InterruptedException
		 */
		@Test(priority=2)
		public void testValidateFleetmanagementTabs() throws InterruptedException
		{this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			System.err.println(" ****************** Validate FM Tabs ******************");
			testCase_Id=testCaseID[1];
			fleetManagementPage.frameID(wd);//1377143
			fleetManagementPage.clickManageNotificationTab(wd);
			fleetManagementPage.clickManageGeofenceTab(wd);
			fleetManagementPage.clickSettingTab(wd);
			fleetManagementPage.clickEquipmentListTab(wd);
			fleetManagementPage.verifyEquipmentTableHeaderColumns(wd, testCaseID[1]);
			
			try{
			Thread.sleep(2000);
			
			}catch (Exception e)	{		}
		}
		
		@Test(priority=3)
		public void testValidateEquipmentsInGrid() 
		{
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			System.err.println(" ****************** Validates Equipment Grid filer service-status ******************");
			testCase_Id=testCaseID[0];
				fleetManagementPage.selectResultsPerAge(wd,testCaseID[3]);
				
		
			
		}
		
		@Test(priority=4)
		public void testValidateEquipmentDetails() 
		{this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
				System.err.println(" ****************** Validates the Equipments Filer by Inventory status ******************");
				 //homePage=PageFactory.initElements(wd, HomePage.class);
				testCase_Id=testCaseID[0];
				
				
				
				
		}
		
		@AfterMethod()
		public void onTestFailure(ITestResult result) throws IOException
		{
			if (result.isSuccess())
			{
				isBrowserAlive="A";
			 path =ReportGenerator.setLogAndCreateScreenshot(methodName+"~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
				addResultForTestCase(PROJECT.getProperty("testRunID"),testCase_Id,1, methodName+" Test~ "+browserName+"__"+localTestData+"_"+Constants.PASSED+"\n"+"![](http://che-dt-idc1/Hybris/reports/Screenshots/"+path+")");
				isBrowserAlive="N";
				//wd.close();	
			} else 
			{
				path =ReportGenerator.setLogAndCreateScreenshot(methodName+"~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
				addResultForTestCase(PROJECT.getProperty("testRunID"),testCase_Id,1, methodName+" Test Failed~ "+browserName+"__"+localTestData+"_"+Constants.FAILED+result.getThrowable()+"\n"+"![](http://che-dt-idc1/Hybris/reports/Screenshots/"+path+")");
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
