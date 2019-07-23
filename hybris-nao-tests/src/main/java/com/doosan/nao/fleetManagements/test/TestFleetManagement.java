package com.doosan.nao.fleetManagements.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
import com.doosan.nao.fleetManagements.page.HomePage;
import com.doosan.nao.fleetManagements.page.IOTPortalHomePage;
import com.doosan.nao.fleetManagements.page.IOTPortalLoginPage;
import com.doosan.nao.fleetManagements.page.LoginPage;
import com.doosan.nao.fleetManagements.page.PlanMaintenancePage;
import com.doosan.nao.fleetManagements.page.SelectOrgPage;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class TestFleetManagement extends TestInitializer {


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
		System.err.println(" ****************** Validates Equipment Grid ******************");
		testCase_Id=testCaseID[0];
			fleetManagementPage.selectResultsPerAge(wd,testCaseID[3]);
			fleetManagementPage.verifySelectPageDropDownOptions(testCaseID[3]);
			fleetManagementPage.showTotalEquipments(wd);
			PortalEquipments=fleetManagementPage.getTableEquipment(wd,testCaseID[2]);//1377144
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
	
	@Test(priority=4)
	public void testValidateEquipmentDetails() 
	{this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			System.err.println(" ****************** Validates the Equipments details ******************");
			 //homePage=PageFactory.initElements(wd, HomePage.class);
			testCase_Id=testCaseID[0];
			 fleetManagementPage=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
			
			 try{
				portalDetail=fleetManagementPage.getDetailofEquipment();
				System.out.println("");
				System.out.println(" *************** EquipmentDetails **************");
				System.out.println(portalDetail);
				for (Map.Entry<String, String> entry : portalDetail.entrySet()) {
				    System.out.println("Property => " + entry.getKey() + " = " + entry.getValue());
				}
				System.out.println();
				
			} catch (Exception e) {
				
				
			}
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
				fleetManagementPage.switchToDefaultFrame(wd);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
		}
	@Test(priority=5)
	public void testValidateAdminTabAndRetailThrehold(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ****************** Validate Admin Tab and Retailed threshold ******************");
		// homePage=PageFactory.initElements(wd, HomePage.class);
		testCase_Id=testCaseID[0];
		 fleetManagementPage=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
		 String orgName=fleetManagementPage.getOrganizationName();
		 
			fleetManagementPage.frameID(wd);
			
			fleetManagementPage.verifyDetailsText(wd);
			portalRetailThreshold=fleetManagementPage.getRetailThrehold(wd);
			PortalEditTheshold=fleetManagementPage.clickEditThreshold(wd);
		 Map<String ,String> adminDetails=fleetManagementPage.validateAdminTableDetails(wd);
			for (Map.Entry<String, String> adminTableDetail : adminDetails.entrySet()) {
				System.out.println(" AdminDetails :"+"{"+ adminTableDetail.getKey()+"  > "+adminTableDetail.getValue() +"}");
			}
			
			String serviceDealer=fleetManagementPage.serviceDealer(wd);
			System.out.println( "Servicing Dealer :"+serviceDealer +" Selected Organization :"+orgName);
			
	}
	@Test(priority=6)
	public void testValidateAddComments(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("********** Test Verifying add comment link clickable or not **************");
		testCase_Id=testCaseID[0];
		adminCodeAddcomments.verifyAddComnetLink(wd);
		adminCodeAddcomments.clickAddCommentLink(wd);
		adminCodeAddcomments.headerNewComments(wd);
		adminCodeAddcomments.clickCancelNewcommentPopup(wd);
		//adminCodeAddcomments.verifyTotalComments();
		//adminCodeAddcomments.clickFullCommentHistoryLink();
		//adminCodeAddcomments.verifyHeaderCommentPopup();
		//adminCodeAddcomments.totalRowsinFullCommentsHistory(wd);
		//adminCodeAddcomments.clickCloseButtonCommentPopup(wd);
		
		}
	@Test(priority=7)
	public void testValidateNoComments() {
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("******Test verifying existing comment ******");
		adminCodeAddcomments.verifyNoCommnets();
	}
	@Test(priority=8)
	public void testValidateAddNewComments() {
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		testCase_Id=testCaseID[0];
		System.err.println("****** Test Adding new comment ********");
		adminCodeAddcomments.clickAddCommentLink(wd);
		adminCodeAddcomments.enterNewcomments();
		adminCodeAddcomments.clickSaveNewComment(wd);

	}
	@Test(priority=9)
	public void testValidateTotalComments() {
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" *******  Test verifying total comments in grid ***********");
		testCase_Id=testCaseID[0];
		adminCodeAddcomments.getTableRows(wd);
		adminCodeAddcomments.verifyNewCommentAddedOrNot(wd);
		adminCodeAddcomments.verifycommentAvailableInList();
	}
	@Test(priority=10)
	public void testValidateDeleteCommnets() {
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying Delete Comment ********");
		testCase_Id=testCaseID[0];
		adminCodeAddcomments.beforeDeletCommentTotal(wd);
		adminCodeAddcomments.clickdeleteCommentButtonIcon(wd);
		adminCodeAddcomments.verifyBeforeAndAfterDeleteComments(wd);
	}
	@Test(priority=11)
	public void testValidatePMStatus(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status ICON and edit PMstatus popup window  ********");
		testCase_Id=testCaseID[0];
		planmaintenance.checkplanMainTenanceEditIcon();
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clickPlanMaintenanceENDDateTomorrow(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.getDateafterUpdate();
		planmaintenance.getPMStatusfterUpdate();
	}
	@Test(priority=12)
	public void testValidateNoneByClearAllPopupfileds(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status None by clear all fileds  ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clearOperatinghrs();
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.verifytheStatusNone(wd);
		
	}
	
	@Test(priority=13)
	public void testValidateActiveByDateTomorrow(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Active by tomorrow date ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clickPlanMaintenanceENDDateTomorrow(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.verifytheStatusActiveBytomorrowdate(wd);
		
	}
	@Test(priority=14)
	public void testValidateExpiredbyYesterdayDate(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Expired by  Yesterday date ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clickPlanMaintenanceExpiredPastDate(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.verifytheStatusExpitrdByYesterdayDate(wd);
		
	}
	@Test(priority=15)
	public void testValidateActivedbyEndHouseMorethanOperationHours(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Active by entering More than Operating hours ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.enterOperatinHoursMoreThanOPeratingHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusActiveByMoreOperatinghrs(wd);
	}
	@Test(priority=16)
	public void testValidateExpiredbyEndHouseLessthanOperationHours(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Expired by entering Less than Operating hours ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.enterOperatinHoursLessThanOPeratingHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusExpiryByMoreOperatinghrs(wd);
	}
	@Test(priority=17)
	public void testValidateNonebyDeletePm(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status None by clicking on delete icon ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickDeletPMStatusICON(wd);
		planmaintenance.checkPMStatusAfterDeletePmStatus(wd);
		
	}
	@Test(priority=18)
	public void testValidateExpiredbyEndHrsLessOperHrsYesterday(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Expired by entering Less than Operating hours and yesterday date ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clickPlanMaintenanceExpiredPastDate(wd);
		planmaintenance.enterOperatinHoursLessThanOPeratingHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusExpiryByMoreOperatinghrs(wd);
	}
	@Test(priority=19)
	public void testValidateActivebyEndHrsMoreOperHrsTomorrows(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Active by entering More than Operating hours and Tomorrows date ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clickPlanMaintenanceENDDateTomorrow(wd);
		planmaintenance.enterOperatinHoursMoreThanOPeratingHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusActiveByMoreOperatinghrs(wd);
	}
	@Test(priority=20)
	public void testValidateNonebyClickinOnDeleteonAlreadyActive(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		testCase_Id=testCaseID[0];
		System.err.println("*******  Test verifying PM status None by clicking on delete icon which is already in Active status  ********");
		planmaintenance.clickDeletPMStatusICON(wd);
		planmaintenance.checkPMStatusAfterDeletePmStatus(wd);
	}
	@Test(priority=21)
	public void testValidateExpiredbyEndHrsmoreOperHrsYesterdayDate(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Expired by entering More than Operating hours and yesterday date ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clickPlanMaintenanceExpiredPastDate(wd);
		planmaintenance.enterOperatinHoursMoreThanOPeratingHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusExpiryByMoreOperatinghrs(wd);
	}
	@Test(priority=22)
	public void testValidateNonebyClickinOnDeleteonAlreadyExpired(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status None by clicking on delete icon which is already in Expired status  ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickDeletPMStatusICON(wd);
		planmaintenance.checkPMStatusAfterDeletePmStatus(wd);
	}
	@Test(priority=23)
	public void testValidateExpiredbyEndHrsmoreOperHrsYesterdayDate2(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Expired by entering More than Operating hours and yesterday date ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clickPlanMaintenanceExpiredPastDate(wd);
		planmaintenance.enterOperatinHoursMoreThanOPeratingHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusExpiryByMoreOperatinghrs(wd);
	}
	@Test(priority=24)
	public void testValidateExpiredbyAddingComments(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Expired by entering comment and which is already Expired ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.enterPMComments(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusExpiryByMoreOperatinghrs(wd);
	}

	@Test(priority=25)
	public void testValidateExpiredbyEndHrsLEssOperHrsTomorrowsDate(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Expired by entering Less than Operating hours and Tomorrow  date ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clickPlanMaintenanceENDDateTomorrow(wd);
		planmaintenance.enterOperatinHoursLessThanOPeratingHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusExpiryByMoreOperatinghrs(wd);
	}
	@Test(priority=26)
	public void testValidateErrormessageByEnterZeroEndHrs(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying error message by enter zero endhours ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.enterOperatinHoursASZeroHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		//planmaintenance.checkErrorMessage(wd);
		//planmaintenance.clickOKErrorMessage(wd);
		//planmaintenance.clickCancelOnPMPopup(wd);
	}
	@Test(priority=27)
	public void testValidateExpiredbyEndHrsLessOperHrsPastDate(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Expired by entering Less than Operating hours and Past date   ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clickPlanMaintenanceExpiredPastDate(wd);
		planmaintenance.enterOperatinHoursLessThanOPeratingHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusExpiryByMoreOperatinghrs(wd);
	}
	@Test(priority=28)
	public void testValidateActivebyEndHrsMoreOperHrsAndFutureDate(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status Active by entering Less than Operating hours and futured  date   ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clickPlanMaintenanceENDDateTomorrow(wd);
		planmaintenance.enterOperatinHoursMoreThanOPeratingHrs(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusActiveByMoreOperatinghrs(wd);
	}
	@Test(priority=29)
	public void testValidateActiveByEnteringCurrentDateNoOperatingHrs(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status active by entering current date and No entering operating hrs********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.enterCurrentdate(wd);
		planmaintenance.clearOperatinghrs();
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusActiveByMoreOperatinghrs(wd);
	}
	@Test(priority=30)
	public void testValidateActiveByEnteringOperatinghrsNoDate(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status active by entering operating hrs  and No date ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.enterOperatinHoursCurrentVal(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusActiveByMoreOperatinghrs(wd);
	}
	@Test(priority=31)
	public void testValidateActiveByEnteringOperatinghrsAndEndDateCurrentDate(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status active by entering operating hrs  and current date ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.enterCurrentdate(wd);
		planmaintenance.clearOperatinghrs();
		planmaintenance.enterOperatinHoursCurrentVal(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusActiveByMoreOperatinghrs(wd);
	}
	@Test(priority=32)
	public void testValidateNonebyAddingComments(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status None by entering comment and which is none ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clearOperatinghrs();
		planmaintenance.enterPMComments(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.verifytheStatusNone(wd);
	}
	@Test(priority=33)
	public void testValidateActivebyAddingComments(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("*******  Test verifying PM status active by entering comment and which is already active ********");
		testCase_Id=testCaseID[0];
		planmaintenance.clickPlanMainTenanceEditIcon(wd);
		planmaintenance.clearPmDate(wd);
		planmaintenance.clearOperatinghrs();
		planmaintenance.enterCurrentdate(wd);
		planmaintenance.enterPMComments(wd);
		planmaintenance.clickSaveOnPMPopup();
		planmaintenance.checkStatusActiveByMoreOperatinghrs(wd);
	}
	@Test(priority=33)
	public void testValidateCodeTab(){
		try {
			waitforpagetoload(wd);
		} catch (Exception e) {		}
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		testCase_Id=testCaseID[0];
		System.err.println("****************** Validate Fault Codes Tab ****************** ");
		//homePage=PageFactory.initElements(wd, HomePage.class);
		 fleetManagementPage=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
		fleetManagementPage.clickOnCodesTab(wd);
		fleetManagementPage.codesdetails();
	}
	@Test(priority=34)
	public void testValidateWarrantyFieldMods(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("****************** Validate Warranty Field Mods tab ****************** ");
		
		testCase_Id=testCaseID[0];
		fleetManagementPage.clickWarrantyFieldModsTab(wd);
		fleetManagementPage.checkWarrantyFieldModsTextisOpne(wd);
		fleetManagementPage.getfieldModsDataAndDisplay(wd);
		fleetManagementPage.getWarrantyPlansTableDataAndDisplay(wd);
	}
	@Test(priority=35)
	public void testValidateLocationHistory(){
		try {
			waitforpagetoload(wd);
		} catch (Exception e) {		}
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println("****************** Validate Location History Tab ******************");
		//homePage=PageFactory.initElements(wd, HomePage.class);
		testCase_Id=testCaseID[0];
		fleetManagementPage=PageFactory.initElements(wd, FleetManagementEquipmentPage.class);
		fleetManagementPage.clickLocationTab(wd);
		boolean tableval=fleetManagementPage.verifylocationHistoryIsEmpty();
		if(tableval!=true){
			
			Map<String, String>mapLocationHistoryDetails=fleetManagementPage.locationHistorydetails();;
			for (Map.Entry<String, String> locationHistory : mapLocationHistoryDetails.entrySet()) {
				System.out.println(" Location History "+ "{"+locationHistory.getKey()+" > "+locationHistory.getValue()+"}");
			}
		}else{
		System.out.println(fleetManagementPage.locationEmpty.getText());	
		}
	}
	
	@Test(priority=36)
	public void testValidateManageGeofences(){
		try {
			waitforpagetoload(wd);
		} catch (Exception e) {		}
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ****************** Validate Manage Gefence tab ****************** ");
		//homePage=PageFactory.initElements(wd, HomePage.class);
		testCase_Id=testCaseID[0];
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		fleetManagementPage.frameID(wd);
		fleetManagementPage.clickManageGeofenceTab(wd);
		fleetManagementPage.geofenceTotalCreated();
		String verifyTile=fleetManagementPage.verifygeofenceTilte(wd);
		Assert.assertEquals(verifyTile,"Geofences");
		fleetManagementPage.clickCreateGeofenceButton(wd);
		String nameOFthepage=fleetManagementPage.getNameOfthePage();
		fleetManagementPage.clickCancelGeofence(wd);
		Assert.assertEquals(nameOFthepage, "Add new geofence");
		
	}
	@Test(priority=37)
	public void testValidateDeleteGeofence(){
		try {
			waitforpagetoload(wd);
		} catch (Exception e) {		}
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ****************** Validate Delete Geofences ******************");
		testCase_Id=testCaseID[0];
		boolean flag=fleetManagementPage.verifyGeofenceTableIsempty(wd);
		if(flag!=true){
			try {
				waitforpagetoload(wd);
			} catch (Exception e) {			}
			fleetManagementPage.selectGeoResultPerPage(wd);
			int Beforedelete=fleetManagementPage.getAllTableGeofences();
			fleetManagementPage.clickDeleteGeofence(wd);
			fleetManagementPage.clickRemoveGeofence(wd);
			int Afterdelete=fleetManagementPage.getAllTableGeofences();
			if(Beforedelete>Afterdelete){
				System.out.println(" Gefence Deleted ");
			}
		}
	}
	@Test(priority=38)
	public void testValidateDeleteAssignedEquipment(){
		try {
			waitforpagetoload(wd);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ****************** Validate Delete Assigned Machines Geofences ******************");
		testCase_Id=testCaseID[0];
		boolean flag=fleetManagementPage.verifyGeofenceTableIsempty(wd);
		if(flag!=true){ 
			fleetManagementPage.clickGefenceRadioButton(wd);
		}else{System.out.println(" Gefence is Empty");}
		boolean flag1=fleetManagementPage.verifyAssignEquipmentTableisEmpty();
		if(flag||flag1!=true){
			
			int Beforedelete=fleetManagementPage.getAssignEquipmentList(wd);
			fleetManagementPage.clickDeleteAssignedEquipment();
			fleetManagementPage.clickRemoveAssignedEquipment(wd);
			int Afterdelete=fleetManagementPage.getAssignEquipmentList(wd);
			if(Beforedelete>Afterdelete){
				System.out.println(" Assigned equipment Deleted ");
			}
			else{
				System.out.println("  Empty ");
			}
		}
	}
	@Test(priority=39)
	public void testValidateAssignMachines() throws InterruptedException{
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ******************** Validate Assigned Machines  ******************");
		testCase_Id=testCaseID[0];
		 try {
			 waitforpagetoload(wd);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		 wd.switchTo().defaultContent();
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			jse.executeScript("scroll(0,-250);", "");
			fleetManagementPage.frameID(wd);
		fleetManagementPage.clickManageGeofenceTab(wd);
		fleetManagementPage.clickActiveGefenceRadiobutton(wd);
		fleetManagementPage.clickAssignMachineButton(wd);
		//fleetManagementPage.validateAssignMachineTable();
		fleetManagementPage.totalrowinAssignmachines();
		AssignMachines=fleetManagementPage.getAssignMachineSerialNo(wd);
		Thread.sleep(2000);
		System.out.println("Portal Machines"+ PortalEquipments);
		fleetManagementPage.clickCancelAssignbutton(wd);
		//Assert.assertEquals(PortalEquipments.containsAll(AssignMachines), true);
		
	}
	@Test(priority=40)
	public void testValidateManageNotifiationTab(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ****************** Validate the Manage Notification Tab ******************");
		testCase_Id=testCaseID[0];
		wd.switchTo().defaultContent();
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		jse.executeScript("scroll(0,-250);", "");
		fleetManagementPage.frameID(wd);
		fleetManagementPage.clickManageNotificationTab(wd);
		fleetManagementPage.selectNotificationMethod(wd);
		String selected=fleetManagementPage.selectNotificationType(wd);
		fleetManagementPage.clickAddNotificationButton(wd);
		fleetManagementPage.validateNotificationList();
		String notficationtype=fleetManagementPage.getNoficationTypeValue();
		Assert.assertEquals(selected, notficationtype);
		
	}
	@Test(priority=41)
	public void testValidateDeleteNotification(){
		this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		System.err.println(" ******************* Validate Delete Notification ******************");
		testCase_Id=testCaseID[0];
		int beforeTotal=fleetManagementPage.getTotalNoficationEmailRows();
		fleetManagementPage.clickDeleteNotification(wd);
		fleetManagementPage.clickYesRemoveNotification(wd);
		int afterTotal=fleetManagementPage.getTotalNoficationEmailRows();
		boolean flag=true;
		if(beforeTotal==afterTotal){
			flag=false;
		}
		
		System.err.println( "Before Delete Total Notifications :"+ beforeTotal  +" After Delete Total Notifications :"+afterTotal);
		Assert.assertEquals(flag, true);
		//wd.close();
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
		@Parameters(value = { "browser", "version", "platform", "osVersion","iotUSer","iotPassword"})
		@Test(priority=42)
		public void testValidateEquipmetsIOTtoFMPortal(String browser,
				String browserVersion, String platform, String osVersion,String IOTUser,String IOTPassword) throws IOException, URISyntaxException, InterruptedException{
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			testCase_Id=testCaseID[0];
			System.err.println(" ****************** Validate IOT Equipmets to Portal Total Equipments ****************** ");
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			/*System.err.println(browser+" Browser is Launching");
			browserName = browser;
			this.localTestData=IOTUser;
			if (isBrowserAlive == "N") {
			wd = WebdriverSelector.getDriver(wd, browser);
			initialize(browser, browserVersion, platform, osVersion);*/
			wd.get(PROJECT.getProperty("IOTPortalURL"));
			iotLoginPage.EnterUserName(wd,IOTUser);
			iotLoginPage.enterPassword(IOTPassword);
			iotLoginPage.clickLoginButton();
			iotHomepage.clickSettingICON(wd);
			iotHomepage.clickSettingICONSwitch();
			//iotHomepage.clickOrganizationSwitch(wd);
			iotHomepage.selectEnvironment(wd,IOTEnvironment);
			iotHomepage.clickThings(wd);
			/*waitforpagetoload(wd);
			iotHomepage.enterequipmentThings(wd, passportEquipment);
			waitforpagetoload(wd);*/
			//EMEA
			iotHomepage.clickHereForMoreOrg(wd);
			iotHomepage.clickOrganizationLik(wd);
			iotHomepage.clickActiveEquipments(wd);
			iotHomepage.selectDealer(wd);//EMEA
			iotHomepage.clickThingsTableTab(wd);
			List<String>IOTequipment =iotHomepage.getIOTEquipmentsTable(wd);
			System.out.println("Equipmets are");
			System.out.println(IOTequipment);
			System.out.println(IOTequipment.containsAll(PortalEquipments));
			//Assert.assertEquals(IOTequipment.containsAll(PortalEquipments), true);
			//}
		}
		@Test(priority=43)
		public void testValidateIOTToFMEquipmentDetails(){
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			testCase_Id=testCaseID[0];
			System.err.println(" ****************** Validate IOT Equipment Details ****************** ");
			iotHomepage.clickEyeView(wd,passportEquipment);
			iotEquipmentDetails =iotHomepage.getTableViewEyeDetails();
			System.out.println("IOT Equipmets details are");
			for (Map.Entry<String, String> entry : iotEquipmentDetails.entrySet()) {
			    System.out.println("Property => " + entry.getKey() + " = " + entry.getValue());
			}
			
		}
		
		@Test(priority=44)
		public void testValidateRetailTresholdValue(){
			this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			testCase_Id=testCaseID[0];
			System.err.println(" ****************** Validate PassPort Portal to IOT Porta Retail Thesold  ******************");
			IOTRetailThreshold=iotHomepage.getRetailThresholdValue(wd);
			System.out.println("IOT Portal Treshold val => "+IOTRetailThreshold);
			Assert.assertEquals(PortalEditTheshold.contains(IOTRetailThreshold), true);
			
			
			
		}
		

}