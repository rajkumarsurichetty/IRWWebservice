package com.doosan.nao.fleetManagements.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.ini4j.CommentedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.doosan.nao.init.TestInitializer;

/**
 * @author rajkumars
 *
 */
public class FleetManagementEquipmentPage extends TestInitializer{
	SoftAssert assertion=new SoftAssert();
	/*@FindBy(how = How.XPATH, using = ".//*[@id='main']/div/div/h1")
	public WebElement verifyFleetManagementTitle;
	public FleetManagementEquipmentPage(){
		try {
			String actualText = verifyFleetManagementTitle.getText();
			String expectedText = "Fleet Management";
			Assert.assertEquals(actualText, expectedText);
			
		} catch (Exception e) {

		}
	}*/
	
	@FindBy(how = How.XPATH, using = "//h1")
	public WebElement verifyFleetManagementTitle;

	/**
	 * Note filter the values and push data into list or set and verify the
	 * contains This method Verifying the Fleet Management page header
	 * 
	 * @return
	 */
	public boolean verfyFleetManagementHeaderText(EventFiringWebDriver wd ,String testcaseid) {
		boolean flag = false;
		try {
			if (true==verifyFleetManagementTitle.isDisplayed()) {
				highlightMyElement(verifyFleetManagementTitle, 3, wd);
				String actualText = verifyFleetManagementTitle.getText();
				String expectedText = "Fleet Management";
				Assert.assertEquals(true, actualText.contains(expectedText));
				flag = true;
			}else{
				System.out.println("FleetManagement not cliked");
			}
			Assert.assertEquals(flag, true);
			addResultForTestCase(PROJECT.getProperty("testRunID"), testcaseid, 1, "Fleet management opened");
		} catch (AssertionError e) {
			addResultForTestCase(PROJECT.getProperty("testRunID"), testcaseid, 5, "Fleet management not opened"+e.getMessage());
		}catch (Exception e){
			
		}
		return flag;
	}

	@FindBy(how = How.XPATH, using ="//a/span[contains(text(),'Equipment list')]")
	public WebElement searchEquipmentListTab;

	public void clickEquipmentListTab(EventFiringWebDriver wd) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			
		}
		if(searchEquipmentListTab.isDisplayed()){
			try {
				highlightMyElement(searchEquipmentListTab, 3, wd);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		searchEquipmentListTab.click();
		System.out.println("Pass:Manage Equipments tab Verified");
		}else{
			System.out.println("Equipment tab not available");
		}
	}

	@FindBy(xpath="//table[@st-persist='equipmentsTable']/thead/tr[2]/th/span")
	List<WebElement>gridcolumns;
	public void verifyEquipmentTableHeaderColumns(EventFiringWebDriver wd,String testcaseid){
		List<String>colsName=new ArrayList<String>();
		JavascriptExecutor je=(JavascriptExecutor)wd;
		je.executeScript("arguments[0].scrollIntoView();",wd.findElement(By.xpath("//table[@st-persist='equipmentsTable']/thead/tr[2]/th/span"))); 
		for(int i =0;i<gridcolumns.size();i++){
			colsName.add(gridcolumns.get(i).getText());
		}
		List<String> tableList = new ArrayList<>();
		tableList.add("Serial Number");
		tableList.add("Servicing Dealer");
		tableList.add("Owner");
		tableList.add("Category");
		tableList.add("Model");
		tableList.add("Inventory Status");
		tableList.add("Operating Hours");
		tableList.add("Fuel Level");
		tableList.add("Service Status");
		tableList.add("Last Update");
		tableList.add("Last Location");
		try {
			Assert.assertEquals(colsName, tableList);
			addResultForTestCase(PROJECT.getProperty("testRunID"), testcaseid, 1, "Fleet management Heders appeared");
		} catch (Exception e) {
			addResultForTestCase(PROJECT.getProperty("testRunID"), testcaseid, 1, "Fleet management Heders not appeared");
		}
	}
	@FindBy(how = How.XPATH, using = "//a/span[contains(text(),'Manage geofences')]")
	public WebElement searchManageGeofence;

	public void clickManageGeofenceTab(EventFiringWebDriver wd) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			
		}
		if (searchManageGeofence.isDisplayed()) {
			try {
				highlightMyElement(searchManageGeofence, 3, wd);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			searchManageGeofence.click();
			System.out.println("Pass:Manage Geofence tab Verified");
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}else{
			System.out.println("Manage geofence tab not available");
		}
	}

	@FindBy(how = How.XPATH, using = "//a/span[text()='Notifications']")
	public WebElement searchManageNotifications;

	public void clickManageNotificationTab(EventFiringWebDriver wd) {
		//System.out.println("=> "+searchManageNotifications.getText());
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if (searchManageNotifications.isDisplayed()) {
			try {
				highlightMyElement(searchManageNotifications, 3, wd);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			searchManageNotifications.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("Pass:Manage Notification tab Verified");
		}else{
			//System.out.println("Manage Notifications tab not available");
		}
	}
	@FindBy(how = How.XPATH, using = "//a/span[contains(text(),'Settings')]")
	public WebElement searchSettings;

	public void clickSettingTab(EventFiringWebDriver wd) {
		if (searchSettings.isDisplayed()) {
			try {
				highlightMyElement(searchSettings, 3, wd);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			searchSettings.click();
			System.out.println("Pass: Settings Tab Verified");
		}else{
			System.out.println(" Settings Tab not available");
		}
	}
	@FindBy(how = How.XPATH, using = "(//input[@st-search='serialNumber'])[1]")
	public WebElement serialnumber;

	/**
	 * This method for filter the equipment by entering the SERIAL NUMBER
	 */
	public void filerEquipmentByEnterSerialNumber() {
		serialnumber.sendKeys("AUYJ2116");
	}

	@FindBy(how = How.XPATH, using = "(//input[@st-search='category'])[2]")
	public WebElement category;

	/**
	 * This method for filter the equipment by entering the Category
	 */
	public void filterQuipmentByEnteringCategory() {
		category.sendKeys("MX");
	}

	@FindBy
	public WebElement model;

	/**
	 * This method for filter the equipment by entering the Model
	 */
	public void filterquipmentByEnterModel() {
		model.sendKeys("T650 T4");
	}

	@FindBy(how = How.XPATH, using = "//select[@st-search='status']")
	public WebElement orderStaus;

	/**
	 * This method for selecting the Order Satatus
	 */
	public void filterEquipmentBySelectOrderStatus() {
		selectByVisibleText(orderStaus, "RETAILED");
	}

	@FindBy(how = How.XPATH, using = "(//select[@st-search='serviceStatus'])[2]")
	public WebElement serviceStatus;

	/**
	 * This method for selecting the Service status
	 */
	public void filterEquipmentBySelectingServiceStatus() {
		selectByVisibleText(serviceStatus, "Service due soon");
	}

	@FindBy(how = How.XPATH, using = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	public WebElement fromElement;

	/**
	 * This method for Click from date
	 */
	public void clickFromDate() {
		fromElement.click();
	}

	@FindBy(how = How.XPATH, using = "")
	// PEnding this element for selecting data ************************/
	public WebElement selectCalFromDate;

	/**
	 * This method for select the Select calendar from data
	 */
	public void selectFromCalDate() {
		selectCalFromDate.click();

	}

	@FindBy(how = How.XPATH, using = "(//i[@class='glyphicon glyphicon-calendar'])[2]")
	public WebElement clickToDate;

	/**
	 * This method for click todate
	 */
	public void clickToDate() {
		clickToDate.click();

	}

	@FindBy(how = How.XPATH, using = "")
	// PEnding this element for selecting data*******************************/
	public WebElement selectCalToDate;

	/**
	 * This method for selecting the Todate
	 */
	public void selectToDate() {
		selectCalToDate.click();

	}

	/**
	 * This method for Filtering by Location of equipment
	 */
	@FindBy
	public WebElement filterLocation;

	public void filterEquipmetByLocation() {
		filterLocation.sendKeys("ex");
	}

	public void selectByIndex(WebElement element, int index) {
		Select option = new Select(element);
		option.selectByIndex(index);

	}
	List<String>opt;
	public List<String> getSelectOptionFromDropDown(WebElement element) {
		Select option = new Select(element);
		List<WebElement>listOps=option.getOptions();
		opt=new ArrayList<>();
		for (WebElement webElement : listOps) {
			opt.add(webElement.getText());
		}
		return opt;

	}

	public void selectByVisibleText(WebElement element, String vText) {
		Select option = new Select(element);
		option.selectByVisibleText(vText);

	}

	public void selectByValue(WebElement element, String Value) {
		Select option = new Select(element);
		option.selectByVisibleText(Value);

	}

	@FindBy(how = How.XPATH, using = "(//table[@st-table='$ctrl.equipments']/tbody)[1]")
	public WebElement equipmentTable;

	/**
	 * This method to get the data from WebTable
	 */
	public List<String> getTableEquipment(EventFiringWebDriver wd,String testcaseid) {
		try {waitforpagetoload(wd);
		//Thread.sleep(10000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return tableDataRead(equipmentTable,wd);

	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Export')]")
	WebElement export;

	/**
	 * This method for export excel
	 */
	public void exportButton() {
		export.click();
	}

	@FindBy(how = How.XPATH, using = "//div/span[contains(text(),'Showing')]")
	public WebElement showTotalEquipmets;

	/**
	 * This method used to show the total number of equipments.
	 */
	public String showTotalEquipments(EventFiringWebDriver wd) {
		/*JavascriptExecutor jse = (JavascriptExecutor) wd;
		jse.executeScript("arguments[0].scrollIntoView();", showTotalEquipmets);*/
		String showText = showTotalEquipmets.getText();
		String totalRows=showText.replaceAll("[a-zA-Z,()]", "").trim();
		System.out.println("Total Number of Rows => "+totalRows);
		return totalRows;
	}

	/********************************** Manage GeoFence ************************************/
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Manage geofences')]")
	public WebElement ManageGeofenceTab;

	/**
	 * This method for managing the ge0fences
	 */
	public void clcikManageGeofenceTab(EventFiringWebDriver wd) {
		try {
			highlightMyElement(ManageGeofenceTab, 3, wd);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		ManageGeofenceTab.click();
	}

	@FindBy(how = How.CLASS_NAME, using = "//input[@class='input-sm form-control']")
	public WebElement filterEquipmentName;

	public void filterEquipmentByEnterName() {
		filterEquipmentName.sendKeys("Elka Grove location");
	}

	// Create Geofence

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Create Geofence')]")
	public WebElement createGefence;

	/**
	 * This method is used for clicking the create geofence
	 */
	public void clickCreateGeofenceButton(EventFiringWebDriver wd) {
		try {
			Thread.sleep(2000);
			highlightMyElement(createGefence, 3, wd);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		createGefence.click();
	}

	/******************************************* Manage Notification ************************************************/

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Manage notifications')]")
	public WebElement manageNotifications;

	/**
	 * This method is used for clicking the manage Notification
	 */
	public void clickManageNotificationsTab(EventFiringWebDriver wd) {
		try {
			highlightMyElement(manageNotifications, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		manageNotifications.click();
	}

	@FindBy(how = How.ID, using = "notificationMethod")
	WebElement notificationmethod;

	/**
	 * This method for selecting the Add Notification method
	 */
	public void selecNotificationMethod() {
		selectByIndex(notificationmethod, 1);
	}

	@FindBy(how = How.ID, using = "notificationType")
	WebElement notificationType;
	@FindBy(id="geofence")
	WebElement eofenceDrop;
	/**
	 * This method for selecting the Add Notification method
	 */
	public void selecNotificationType() {
		Select sele=new Select(notificationType);
		List<WebElement> listOpt=sele.getOptions();
		for (WebElement webElement : listOpt) {
			sele.selectByValue(webElement.getText().trim());
			if(webElement.getText().trim().equals("Geofence")){
				Select seleGeo=new Select(eofenceDrop);
				List<WebElement> listOptGeo=seleGeo.getOptions();
				for (WebElement geo : listOptGeo) {
					seleGeo.selectByValue(geo.getText().trim());break;
				}
			}
			break;
		}
		//selectByIndex(notificationType, 1);
	}

	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Add')]")
	WebElement add;

	public void clickAddbutton(EventFiringWebDriver wd) {
		try {
			highlightMyElement(add, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		add.click();
	}

	/****************************** Settings *********************************************/
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Settings')]")
	WebElement settings;

	/**
	 * This method for clicking the Settings tab
	 */
	public void clickSettingsTab(EventFiringWebDriver wd) {
		try {
			highlightMyElement(settings, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		settings.click();
	}

	@FindBy(how = How.ID, using = "systemOfMeasurement")
	WebElement systemOfMeasurement;

	/**
	 * This method for selecting the system measurement
	 */
	public void selectSystemOfMeasurement() {
		selectByIndex(systemOfMeasurement, 1);
	}

	
	@FindBy(how = How.XPATH, using = "(//serial-number[@class='ng-isolate-scope']/span/a)[1]")
	public WebElement equimentLink;
	
	@FindBy(how = How.XPATH, using = "//translate/span[text()='Results per page']/following::select")
	WebElement resultsPerPage;

	/**
	 * This method for selecting the no of row per page drop down
	 *///table[@st-table='$ctrl.equipments']/tbody/tr[3]
	public void selectResultsPerAge(EventFiringWebDriver wd,String testcaseId) {
		try {
			//Thread.sleep(10000L);
			waitforpagetoload(wd);
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			jse.executeScript("arguments[0].scrollIntoView();", resultsPerPage);
			WebDriverWait waitForFirstOrgLink = new WebDriverWait(wd, 200);
			waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(resultsPerPage));
			if (!(equimentLink.isDisplayed())) {
				wd.navigate().refresh();
				waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(equimentLink));
			}
			/*Thread.sleep(9000);
			//((JavascriptExecutor)wd).executeScript("scroll(0, -450);","");
			Thread.sleep(3000);
		//	((JavascriptExecutor)wd).executeScript("scroll(0, 750);","");
			Thread.sleep(5000);*/
			selectByIndex(resultsPerPage,3);
			//Thread.sleep(12000);
			waitforpagetoload(wd);
			waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(equimentLink));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	List<String>listOpt;
	List<String>listOptExpected;
	public void verifySelectPageDropDownOptions(String testcaseId) {
		listOpt=new ArrayList<>();
		listOptExpected=new ArrayList<>();
		listOpt=getSelectOptionFromDropDown(resultsPerPage);
		listOptExpected=new ArrayList<>();
		listOptExpected=Arrays.asList("5","10","50","100");
		Assert.assertEquals(listOpt, listOptExpected);
		addResultForTestCase(PROJECT.getProperty("testRunID"), testcaseId, 1, "Test Select results per page is passed ");
	}
	/*****************************Diagnostics ***************************************/
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Diagnostics')]")
	WebElement deviceDiagnostics;

	/**
	 * This method for clicking the deviceDiagnostics tab
	 */
	public void clickDeviceDiagnosticsTab(EventFiringWebDriver wd) {
		try {
			highlightMyElement(deviceDiagnostics, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		deviceDiagnostics.click();
		
	}
	@FindBy(how = How.XPATH, using = "//input[@ng-model='serialNumber']")
	WebElement serialNuminput;

	/**
	 * This method for entering serial number
	 */String srnumber;
	public void enterSerialNumDignastic(EventFiringWebDriver wd,String serlNuminput) {
		srnumber=serlNuminput;
		try {
			highlightMyElement(serialNuminput, 3, wd);
			serialNuminput.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
		serialNuminput.sendKeys(serlNuminput);
	}
	@FindBy(xpath="//span[text()='Test']")
	WebElement testButton;

	/**
	 * This method for clicking test but
	 */
	public void clickTestButton(EventFiringWebDriver wd) {
		try {
			highlightMyElement(testButton, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		testButton.click();
	}
	
	String serlNumStatusResults;
	@FindBy(xpath="//div[@ng-if='testResult']/div/p/span/following-sibling::span/span")
	WebElement serlNumStatus;
	@FindBy(xpath="/html/body/div[1]/div/div/device-diagnostics/div/div/div[2]/div/div/div/p[2]/span[2]")
	WebElement serlNumStatusCode;
	
	//String serlNumStatusCodeText;
	public String  getStatusResults() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		serlNumStatusResults=serlNumStatus.getText();
		System.out.println("Serial number->"+srnumber+ " <-> Result is "+serlNumStatusResults);
		if(serlNumStatusResults.equals("FAIL")) {
			String	serlNumStatusCodeText=serlNumStatusCode.getText();
			System.out.println("Serial number->"+srnumber+ " <-> Result is "+serlNumStatusResults +" due to ->"+serlNumStatusCodeText);
		}
		
		return serlNumStatusResults;
	}
	// ******************************** Equipment details**************************************88/
	@FindBy(xpath="//input[@st-search='serialNumber']")
	WebElement enterEquipmentno;
	public void enterEquipmentNumber(EventFiringWebDriver wd,String equipmentNo){
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 200);
		waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(equimentLink));
		enterEquipmentno.sendKeys(equipmentNo,Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	public void clickEquipmentLink(EventFiringWebDriver wd) {
		try {
			try {
				System.out.println("Before click Equipemnt ");
				JavascriptExecutor jse = (JavascriptExecutor) wd;
				jse.executeScript("arguments[0].scrollIntoView();", equimentLink);
				Thread.sleep(6000);
				//waitforpagetoload(wd);
				//highlightMyElement(equimentLink, 3, wd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			equimentLink.click();
			//Thread.sleep(9000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" After Click Equipment");
	}
	
	/**
	 * Get the Equipment number
	 * @return
	 */
	public String getEquipmentNumber(EventFiringWebDriver wd){
		try {
			//Thread.sleep(10000);
			
			WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 200);
			waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(equimentLink));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		String equipmentNum=equimentLink.getText();
		System.out.println( "EquipmentNo is"+equipmentNum);
		return equipmentNum;
	}
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Details')]")
	WebElement textDetais;

	/**
	 * Verify the Equipment details tab open
	 */
	public void verifyDetailsText(EventFiringWebDriver wd) {
		try {
			//Thread.sleep(12000);
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			jse.executeScript("arguments[0].scrollIntoView();", textDetais);
			WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 200);
			waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(textDetais));
			if(!textDetais.isDisplayed()){
				equimentLink.click();
			}
			waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(textDetais));
			System.out.println(" Clicked Equipment and Navigated in to Details page ");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String text = textDetais.getText();
		if (text.equals("Details")) {
			System.out.println("Equipment Details available  ");
		} else {
			System.out.println("Equipment Details  not available ");
		}

	}
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Admin')]")
	WebElement adminTab;
	public void verifyAdminTab(EventFiringWebDriver wd){
		try {
			highlightMyElement(adminTab, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		 
	    //WebElement element = wd.findElement(By.linkText("Google.com.ph"));
	    jse.executeScript("arguments[0].scrollIntoView();", adminTab);
		adminTab.click();
	}
	

	@FindBy(how=How.XPATH,using="//th[contains(text(),'Wholesale Date')]")
	WebElement wholesaleDate;
	public void verifyWholeSaleDateOnAdmin(){
		String text=wholesaleDate.getText();
		if(text.equals("Wholesale Date")){
			System.out.println("Admin tab data table available");
		}else{
			System.out.println("Admin tab data tabel not available ");
		}
			
	}
	@FindBy(how =How.XPATH,using="//table/tbody[1]/tr/td/span")
	public WebElement equipemtsResults;
	public String VerifyEquipmetGridResutls(){
		String gridResults="";
		boolean flag=equipemtsResults.isDisplayed();
		if(flag==true){
		gridResults=equipemtsResults.getText();
		System.out.println(gridResults);
		}
		return gridResults;
		
		//Equipment list is empty

		//table/tbody[1]/tr[2]/td/span
	}
	
	@FindBy(how=How.ID,using="fleetmanagementApp")
	public WebElement frameId;
	public void frameID(WebDriver wd){
		try {
			Thread.sleep(8000);
			wd.switchTo().frame(frameId);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void switchToDefaultFrame(EventFiringWebDriver wd){
		wd.switchTo().defaultContent();
		//Thread.sleep(2000);
	}
	/** Equpment Details 
	 * Atlas Bobcat, Elk Grove Village, IL
	Atlas Bobcat, Elk Grove Village, IL
	 * */
	/**
	 * This method to get the data from WebTable
	 */
	String orga;
	@FindBy(xpath="//div[@id='orginfo']")
	WebElement orgName;
	public String getOrganizationName(){
		orga=orgName.getText();
		System.out.println(orga);
		String OName=orga.substring(0, 35);
		System.out.println(OName);
		return OName;
	}
	@FindBy(id="fleetmanagementApp")
	WebElement detailsFrame;
	public void switchToEquipmentDetailsFrame(EventFiringWebDriver wd){
		try {
			wd.switchTo().frame(detailsFrame);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	String textServiceOrg;
	@FindBy(xpath="(//tr/td[@class='col-xs-4 machine-property-value ng-binding'])[13]")
	WebElement serviceOrg;
	public String serviceDealer(EventFiringWebDriver wd){
		try {
			highlightMyElement(serviceOrg, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		textServiceOrg=serviceOrg.getText();
		System.out.println(textServiceOrg);
		return textServiceOrg;
		}
	public boolean verifyOrgwithServiceDealer(){
		boolean flag=false;
		if(orga.equals(textServiceOrg)){
			flag=true;
		}
		return flag;
		
	}
	@FindBy(xpath="//table[@class='table table-bordered ng-scope']/tbody")
	WebElement detailstable;
	public Map<String, String> getDetailofEquipment(){
		return tableDetailsequipments(detailstable);
	}
	
	
	String Keyth;
	String valuetd;
	public Map<String, String> tableDetailsequipments(WebElement tableElement) {
		Map<String, String> map=new HashMap<String, String>();
				
		List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
		System.out.println("Total Table rows is =>"+( rows.size()));
		rows.get(2).click();
		for (int row = 0; row < rows.size(); row++) {
			List<WebElement> colstd = rows.get(row).findElements(By.tagName("td"));
			List<WebElement> colsth = rows.get(row).findElements(By.tagName("th"));
			valuetd=colstd.get(0).getText().trim();
			Keyth=colsth.get(0).getText();
			//System.out.println(valuetd);
			//System.out.println(Keyth);
			if(valuetd.length()>0){
			map.put(Keyth, valuetd);
			}
			//System.out.println(map);
			for (int col = 0; col < colstd.size(); col++) {
				
				//System.out.println( " => "+colstd.get(col).getText());

			}
		}
			
		return map;
	}
	//****************************************************************************************************************
	@FindBy(xpath="//table[@st-table='$ctrl.equipments']/tbody/tr[@ng-repeat='row in $ctrl.equipments']")
	WebElement rowGrid;
	@FindBy(xpath="//table[@st-table='$ctrl.equipments']/tbody")
	WebElement equipTable;
	List<String>portalEquip1489;
	public void getEquipmentsFromGrid1489(EventFiringWebDriver wd){
		waitforpagetoload(wd);
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		jse.executeScript("arguments[0].scrollIntoView();", rowGrid);
		waitMethod(wd, rowGrid);
		
		/*try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			
		}*/
		portalEquip1489=new ArrayList<String>();
		List<WebElement>Erows=wd.findElements(By.xpath("//table[@st-table='$ctrl.equipments']/tbody/tr[@ng-repeat='row in $ctrl.equipments']"));
		for(int r=0;r<Erows.size();r++){
			List<WebElement> Ecol=wd.findElements(By.xpath("//table[@st-table='$ctrl.equipments']/tbody/tr[@ng-repeat='row in $ctrl.equipments']/td/equipment-details-row/div/div//serial-number/span/a"));
			for(int c=0;c<Ecol.size();c++){
				String eqipmentNo=Ecol.get(c).getText();
				portalEquip1489.add(eqipmentNo);
			}
			break;
			/*System.out.println(portalEquip1489);*/
		}
		
		wd.switchTo().defaultContent();
	}
	
	
	
	
	List<String>portalEquip1725;
	public void getEquipmentsFromGrid1725(EventFiringWebDriver wd){
		portalEquip1725=new ArrayList<String>();
		waitforpagetoload(wd);
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		jse.executeScript("arguments[0].scrollIntoView();", rowGrid);
		waitMethod(wd, rowGrid);
		
		
		/*try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			
		}*/
		List<WebElement>Erows=wd.findElements(By.xpath("//table[@st-table='$ctrl.equipments']/tbody/tr[@ng-repeat='row in $ctrl.equipments']"));
		for(int r=0;r<Erows.size();r++){
			List<WebElement> Ecol=wd.findElements(By.xpath("//table[@st-table='$ctrl.equipments']/tbody/tr[@ng-repeat='row in $ctrl.equipments']/td/equipment-details-row/div/div/serial-number/span/a"));
			for(int c=0;c<Ecol.size();c++){
				String eqipmentNo=Ecol.get(c).getText();
				portalEquip1725.add(eqipmentNo);
			}
			break;
			/*System.out.println(portalEquip1489);*/
		}
		
	}
	List<String>commonEqupemntsList;
	String EqupmentNo;
	String euipmentwebelement;
	public void commonEquipments(){
		commonEqupemntsList=new ArrayList<String>(portalEquip1489);
		System.out.println(portalEquip1489);
		System.out.println();
		System.out.println(portalEquip1725);
		commonEqupemntsList.retainAll(portalEquip1725);
		System.out.println(commonEqupemntsList);
		
		
	}
	
	public String getEquipmentCommonList(){
		EqupmentNo=commonEqupemntsList.get(0).trim();
		String str=EqupmentNo.toLowerCase();
		return EqupmentNo=str;
		
	}
	WebElement clickingEquipmentNo;
	public void getEquimentWebelement(EventFiringWebDriver wd,String equipemntNofromCommon){
		WebDriverWait wait =new WebDriverWait(wd, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@st-table='$ctrl.equipments']/tbody/tr[@ng-repeat='row in $ctrl.equipments']/td/equipment-details-row/div/div/serial-number/span/a")));
		euipmentwebelement="//table[@st-table='$ctrl.equipments']/tbody/tr[@ng-repeat='row in $ctrl.equipments']/td/equipment-details-row/div/div/serial-number/span/a[text()='"+equipemntNofromCommon+"']";
	 final String strele=euipmentwebelement;
		clickingEquipmentNo=wd.findElement(By.xpath(strele));
	}
	public void clickEquipmentNo(EventFiringWebDriver wd){
		WebDriverWait wait =new WebDriverWait(wd, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@st-table='$ctrl.equipments']/tbody/tr[@ng-repeat='row in $ctrl.equipments']/td/equipment-details-row/div/div/serial-number/span/a")));
		clickingEquipmentNo.click();
	}
	@FindBy(xpath="//span[text()='Change']")
	WebElement changeOrgLik;
	@FindBy(xpath="//table[@id='organization_list']/tbody/tr/td[2]/a")
	WebElement firstOrgLink;
	public void clickChangeLink(EventFiringWebDriver wd){
		changeOrgLik.click();
		waitMethod(wd, firstOrgLink);
	}
	public static void waitMethod(EventFiringWebDriver wd,WebElement ele){
        WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 200);
        waitForFirstOrgLink.until(ExpectedConditions.visibilityOf(ele));
 } 

	
	//***************************************************************************************
	
	public List<String> tableDataRead(WebElement tableElement,EventFiringWebDriver wd) {
		//List<String>portalEquip=new ArrayList<String>();
		List<String>newPortalRowSerial = new ArrayList<String>();
		/*List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
		System.out.println("Total Table rows is =>"+( rows.size()-2));
		rows.get(2).click();
		for (int row = 2; row < rows.size(); row++) {
			List<WebElement> cols = rows.get(row)
					.findElements(By.tagName("td"));
			
			
			portalEquip.add(cols.get(0).getText().toLowerCase());*/
			List<WebElement>newrowsSer=wd.findElements(By.xpath("//serial-number/span/a"));
			for(int s=0;s<newrowsSer.size();s++){
				
			//newPortalRowSerial;
			newPortalRowSerial.add(newrowsSer.get(s).getText());
			
			}
			System.out.println(newPortalRowSerial);
			//System.out.println(" Portal Equipments >"+cols.get(0).getText());//serial-number/a
			//for (int col = 0; col < cols.size(); col++) {
				
				//System.out.println( " => "+cols.get(col).getText());

			//}
		//}
		return newPortalRowSerial;
	}
	
	
	/********************************Admin Tab data validations********************************/
	//@FindBy(xpath="html/body/div[1]/div/div[4]/div/div/div/div[1]/div/div/div[1]/table")
	@FindBy(xpath="//table[@class='table table-bordered']/tbody")
	 public WebElement adminTable;
	 public  Map<String, String> validateAdminTableDetails(EventFiringWebDriver wd){
		 JavascriptExecutor jse = (JavascriptExecutor) wd;
		 
		   // WebElement element = wd.findElement(By.linkText("Google.com.ph"));
		    jse.executeScript("arguments[0].scrollIntoView();", adminTable);
		 return getAdminTablvaluese(adminTable);
	 }
	 
	 String keyAdmin,valueAdmin;
	 public  Map<String, String> getAdminTablvaluese(WebElement elementAdminTb){
		 Map<String, String> map=new HashMap<String, String>();
			
			List<WebElement> rows = elementAdminTb.findElements(By.tagName("tr"));
			System.out.println("Total Table rows is =>"+( rows.size()));
			//rows.get(2).click();
			for (int row = 0; row < rows.size()-5; row++) {
				List<WebElement> colstd = rows.get(row).findElements(By.tagName("td"));
				List<WebElement> colsth = rows.get(row).findElements(By.tagName("th"));
				valueAdmin=colstd.get(0).getText().trim();
				keyAdmin=colsth.get(0).getText();
				//System.out.println(valuetd);
				//System.out.println(Keyth);
				if(valueAdmin.length()>0){
				map.put(keyAdmin, valueAdmin);
				}
				//System.out.println(map);
				for (int col = 0; col < colstd.size(); col++) {
					
					//System.out.println( " => "+colstd.get(col).getText());

				}
			}
			return map;
				
			
	 }
	 
	 
	 @FindBy(xpath="//property-value[@property='$ctrl.machine.retailThreshold']")
	 WebElement retailThreshold;
	 String threshold; float rThreshold;
	 public String  getRetailThrehold(EventFiringWebDriver wd){
		 String th = null;
		 try {
			highlightMyElement(retailThreshold, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 threshold=retailThreshold.getText();
		 if(!threshold.equals("")){
		 String a[]=threshold.split(" ");
		  th =a[0].trim();
		 System.out.println(" Before Retaild Threshold  :"+th);
		/* rThreshold=Float.parseFloat(th);
		 System.out.println(" Before update Retail Threshold is :"+rThreshold);*/
		 }else{
			 System.out.println(" Threshold vaues is empty");
		 }
		return th;
		
		 
	 }
	 @FindBy(xpath="//input[@ng-click='$ctrl.editRetailThreshold($ctrl.machine)']")
	 WebElement editThreshold;
	 @FindBy (xpath="html/body/div[1]/div/div/retail-threshold-dialog/div[2]/div/div/select") 
	 WebElement selectEditThreshold;
	 
	 @FindBy (xpath="html/body/div[1]/div/div/retail-threshold-dialog/div[3]/button[2]")
	 WebElement clickSaveEdit;//button[text()='Save']
	 String thresholdEdit; int rThresholdEdit;float addt;String srt;
	 public String clickEditThreshold(EventFiringWebDriver wd){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!threshold.equals("")) {
			wd.switchTo().defaultContent();
			JavascriptExecutor jse = (JavascriptExecutor)wd;
			jse.executeScript("scroll(0,-250);", "");
			jse.executeScript("scroll(0,650);","" );
			wd.switchTo().frame(frameId);
			editThreshold.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// if(rThreshold>=40&&rThreshold<=200){

			Select getthreshold = new Select(selectEditThreshold);
			List<WebElement> getthresholdList = getthreshold.getOptions();
			Random randThreshold = new Random();
			srt = getthresholdList.get(
					randThreshold.nextInt(getthresholdList.size())).getText().trim();
			selectByVisibleText(selectEditThreshold, srt);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Actions act=new Actions(wd);
			act.click(clickSaveEdit).build().perform();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			thresholdEdit = retailThreshold.getText().trim();
			String a[] = thresholdEdit.split(" ");
			String th = a[0].trim();
			System.out.println(" After thresholdEdit " + th);
		 
			try {
			 Assert.assertEquals(thresholdEdit.contains(srt), true);
			} catch (AssertionError e) {
				Assert.fail();
			}
			
			//System.out.println("Retailed Tresold not updated");
			//Assert.fail("Retailed Tresold not updated");
		//}
		// Assert.assertEquals(thresholdEdit, srt);
		 }else{System.out.println("threashold is empty");}
		return thresholdEdit;
	 }
	/*WebDriver d=new FirefoxDriver();
	WebDriverWait w=new WebDriverWait(d, 20);*/
	/***********************************Validate the Codes TAb***********************************************/
	@FindBy(xpath="//span[text()='Codes']")
	WebElement clickCodes;
	public void clickOnCodesTab(EventFiringWebDriver wd){
		try {
			highlightMyElement(clickCodes, 3, wd);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		 
	   
	    jse.executeScript("arguments[0].scrollIntoView();", clickCodes);
		clickCodes.click();
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*************************WarrantyFieldMods**********************************/
	@FindBy(xpath="//a/uib-tab-heading/span[text()='Warranty/Field Mods']")
	WebElement WarrantyFieldMods;
	public void clickWarrantyFieldModsTab(EventFiringWebDriver wd){
		try {
			highlightMyElement(WarrantyFieldMods, 3, wd);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		WarrantyFieldMods.click();
		
	}
	@FindBy(xpath="//span[text()='Pending Field Modifications (AA & A)']")
	WebElement WarrantyFieldModsHederText;
	public void checkWarrantyFieldModsTextisOpne(EventFiringWebDriver wd){
		try {
			highlightMyElement(WarrantyFieldModsHederText, 3, wd);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		WarrantyFieldModsHederText.getText();
		boolean fg = false;
		if (WarrantyFieldModsHederText.getText().equals("Pending Field Modifications (AA & A)")) {
			fg=true;
		}
		Assert.assertEquals(fg, true);
	}
	@FindBy (xpath="//field-mods-table/table/tbody")
	WebElement pendingFildmod ;
	public void getTablePendingFieldModifications (EventFiringWebDriver wd){
		List<WebElement>row=pendingFildmod.findElements(By.tagName("tr"));
		for (int i = 0; i < row.size(); i++) {
			List<WebElement>col=row.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < col.size(); j++) {
				System.out.println(col.get(j).getText());
			}
			
		}
	}
	
	@FindBy(xpath="//field-mods-table/table/tbody/tr/td/span")
	WebElement tabledataPendingFild;
	boolean flag;
	public void checkPendingFieldModificationsTableDataIsAvailable(){
		 flag=false;
		try{if(tabledataPendingFild.isDisplayed()){
			flag=true;
		}
	}catch( Exception e){
		System.out.println(" Data is Available for Warranty Status ");
	}
		//Assert.assertEquals(flag, true, "PendingField ModificationsTableData Not Available");
	}
	public void getfieldModsDataAndDisplay(EventFiringWebDriver wd){
		checkPendingFieldModificationsTableDataIsAvailable();
		if(!(flag==true)){
			getTablePendingFieldModifications(wd);
		}else{
		System.out.println("No Data for Pending Field Modifications ");
		}
	}
	
	
	
	@FindBy (xpath="//warranty-plans-table/table/tbody")
	WebElement warrantyplanstable ;
	public void getTablewarrantyplanstable (EventFiringWebDriver wd){
		List<WebElement>row=warrantyplanstable.findElements(By.tagName("tr"));
		for (int i = 0; i < row.size(); i++) {
			List<WebElement>col=row.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < col.size(); j++) {
				System.out.println(col.get(j).getText());
			}
			
		}
	}
	
	@FindBy(xpath="//warranty-plans-table/table/tbody/tr/td/span")
	WebElement tabledatawarrantyplanstable;
	boolean flag_tabledatawarrantyplanstable;
	public void checktabledatawarrantyplanstableTableDataIsAvailable(){
		flag_tabledatawarrantyplanstable=false;
		try{
		if(tabledatawarrantyplanstable.isDisplayed()){
			flag_tabledatawarrantyplanstable=true;
		}
		}catch( Exception e){
			System.out.println(" Data is Available for Warranty Status ");
		}
		//Assert.assertEquals(flag, true, "flag_tabledatawarrantyplanstable Not Available");
	}
	public void getWarrantyPlansTableDataAndDisplay(EventFiringWebDriver wd){
		checktabledatawarrantyplanstableTableDataIsAvailable();
		if(!(flag_tabledatawarrantyplanstable==true)){
			getTablewarrantyplanstable(wd);
		}else{
			System.out.println("No Data for Warranty Status");
		}
	}
	/*@FindBy(xpath="//fault-codes/div/div/table/tbody[1]")
	WebElement codes;
	public Map<String, String> codesdetails(){
		return codesTableValues(codes);
		
	}
	String severity;String code;
	public Map<String, String> codesTableValues(WebElement fCodes){
		Map<String, String>mapcode=new HashMap<String, String>();
		List<WebElement>rowcode=fCodes.findElements(By.tagName("tr"));
		int size=rowcode.size()-2;
		System.out.println(" Total codes > "+size );
		for (int rowc = 1;rowc < rowcode.size(); rowc ++) {
			List<WebElement>codeCols=rowcode.get(rowc).findElements(By.tagName("td"));
			 severity=codeCols.get(0).getText();
			 code=codeCols.get(1).getText();
			 mapcode.put( code, severity);
			 for (Map.Entry<String, String> fCodes : mapcode.entrySet()) {
				System.out.println(fCodes.getKey()+" > "+fCodes.getValue());
			}
		}
		return mapcode;
	}*/
	@FindBy(xpath="//fault-codes/div/div/table/tbody[1]")
	WebElement codes;
	public void  codesdetails(){
		 codesTableValues(codes);
		
	}
	//String severity;String code;
	public void codesTableValues(WebElement fCodes){
		List<String>severity=new ArrayList<String>();
		List<String>code=new ArrayList<String>();
		List<WebElement>rowcode=fCodes.findElements(By.xpath("//tr[@ng-repeat-start='code in $ctrl.faultCodes']"));
		int size=rowcode.size()-2;
		System.out.println(" Total codes > "+size );
		for (int rowc = 1;rowc < rowcode.size(); rowc ++) {
			List<WebElement>codeCols=rowcode.get(rowc).findElements(By.tagName("td"));
			severity.add(codeCols.get(0).getText());
			code.add( codeCols.get(1).getText());
		}
		for(int i=0;i<severity.size();i++){
		System.out.println("Fault Codes: "+"["+severity.get(i)+"    > "+code.get(i)+"]");
		}
		//return new Pair(severity,code);
		
	}
	
	
	/*******************************Equipment Location history Tab************************************************/
	@FindBy(xpath="//span[text()='Location History']")
	WebElement lochtab;
	public void clickLocationTab(EventFiringWebDriver wd){
		try {
			highlightMyElement(lochtab, 3, wd);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lochtab.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//location-history/div/div[1]/table/tbody[1]/tr/td[1]")
	public WebElement locationEmpty;
	public boolean verifylocationHistoryIsEmpty(){
		boolean flag=locationEmpty.isDisplayed();
		return flag;
	}
	@FindBy(xpath="//location-history/div/div[1]/table/tbody[1]")
	WebElement lochistory;
	public Map<String, String> locationHistorydetails(){
		return locationHistoryTableValues(lochistory);
		
	}
	String date;String location;
	public Map<String, String> locationHistoryTableValues(WebElement locHistory){
		Map<String, String>maplochistory=new HashMap<String, String>();
		
		List<WebElement>rowloc=locHistory.findElements(By.tagName("tr"));
		int size=rowloc.size()-2;
		System.out.println(" Total codes > "+size );
		for (int rowl = 1;rowl < rowloc.size(); rowl ++) {
			List<WebElement>lochistoryCols=rowloc.get(rowl).findElements(By.tagName("td"));
			date=lochistoryCols.get(0).getText();
			location=lochistoryCols.get(1).getText();
			maplochistory.put( date, location);
			 for (Map.Entry<String, String> loch : maplochistory.entrySet()) {
				System.out.println(loch.getKey()+" > "+loch.getValue());
			}
		}
		return maplochistory;
	}
	/*********************** Fleet Management Geofences tab************************/
	String geofencesTol;
	@FindBy(xpath="//div/h4")
	WebElement geofenceTotal;
	public String geofenceTotalCreated(){
		geofencesTol=geofenceTotal.getText();
		System.out.println(geofencesTol);
		String geofencesT=geofencesTol.substring(11, 13);
		System.out.println("Total Geofences Created >"+geofencesT);
		return geofencesT;
	}
	String geoTitle;
	@FindBy(xpath="//div/h4/translate/span[contains(text(),'Geofences')]")
	WebElement geofenceTitle;
	public String verifygeofenceTilte(EventFiringWebDriver wd){
		try {
			highlightMyElement(geofenceTitle, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		geoTitle=geofenceTitle.getText();
		//System.out.println(geoTitle);
		String geofencesT=geoTitle.substring(0, 9);
		System.out.println("Geofences Title > "+geofencesT);
		return geofencesT;
	}
	
	@FindBy(xpath="//table/tbody[1]/tr/td/span")
	public WebElement verifyGeofencesIsEmpty;
	public boolean verifyGeofenceTableIsempty(EventFiringWebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,750);", "");
		wd.switchTo().frame(frameId);
		boolean flag=verifyGeofencesIsEmpty.isDisplayed();
		return flag;
		
	}
	@FindBy(xpath="//select[@ng-model='geofencesResultsPerPage']")
	WebElement georesultPerPage;
	@FindBy(xpath="html/body/div[1]/div/div[3]/div/table/tfoot/tr/td[1]/div[contains(text(),'Results per page')]")
	WebElement georesultPerPageClick;
	public void selectGeoResultPerPage(EventFiringWebDriver wd){
		selectByVisibleText(georesultPerPage, "100");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//georesultPerPageClick.click();
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("scroll(0, -250);");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//table[@st-table='geofences']/tbody[1]")
	WebElement geofencesTable;
	int totalGeofenceRows;
	public int getAllTableGeofences(){
		List<WebElement>rows=geofencesTable.findElements(By.tagName("tr"));
		totalGeofenceRows=rows.size()-1;
		System.out.println("Total Geofences is : "+totalGeofenceRows);
		for(int r=1;r<rows.size();r++){
			List<WebElement>cols=rows.get(r).findElements(By.tagName("td"));
		}
		return totalGeofenceRows;
	}
	
	public void clickGefenceRadioButton(EventFiringWebDriver wd){
		System.out.println();
		WebElement ele =wd.findElement(By.xpath("//table/tbody[1]/tr[last()]/td[1]/input"));
		wd.switchTo().defaultContent();
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		jse.executeScript("scroll(0,-250);", "");
		//jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		try {									 
			highlightMyElement(ele, 3, wd);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		wd.findElement(By.xpath("//table/tbody[1]/tr[last()]/td[1]/input")).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
//	@FindBy(xpath="//tr[2]/td[8]/input[@class='delete-button'][1]")
	@FindBy(xpath="(//input[@title='Delete'])[1]")
	
	WebElement deleteGeo;
	public void clickDeleteGeofence(EventFiringWebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		//jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		deleteGeo.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//button[contains(text(),'remove geofence')]")
	WebElement removeGeofence;
	public void clickRemoveGeofence(EventFiringWebDriver wd){
		wd.switchTo().defaultContent();
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		//jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		removeGeofence.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@FindBy(xpath="(//table[@st-table='geofenceEquipment']/tbody[1]/tr/td/span)")
	WebElement verifyAssignEuipment;
	public boolean verifyAssignEquipmentTableisEmpty(){
		boolean flag=false;
		try {
			 flag=verifyAssignEuipment.isDisplayed();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	@FindBy(xpath="//table[@st-table='geofenceEquipment']/tbody[1]")
	WebElement assignedEquipmenttabel;
	int totalAssignEqipments;
	public int getAssignEquipmentList(EventFiringWebDriver wd){
		WebDriverWait wait=new WebDriverWait(wd, 100);
		wait.until(ExpectedConditions.elementToBeClickable(assignedEquipmenttabel));
		List<WebElement>rows=assignedEquipmenttabel.findElements(By.tagName("tr"));
		return totalAssignEqipments=rows.size()-1;
	}
	@FindBy(xpath="//table[@st-table='geofenceEquipment']/tbody[1]/tr[2]/td[6]/input")
	WebElement deletAssignedequpment;
	public void clickDeleteAssignedEquipment(){
		deletAssignedequpment.click();
	}
	@FindBy(xpath="//div[@class='modal-content']/div[3]/button[2]")
	WebElement removeAssingEquipment;
	public void clickRemoveAssignedEquipment(EventFiringWebDriver wd){
		
		try {
			Thread.sleep(3000);
			removeAssingEquipment.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@FindBy(className="btn btn-primary table-button")
	WebElement createGeofenceButton;
	public void createGeofenceButton(EventFiringWebDriver wd){
		try {
			highlightMyElement(createGeofenceButton, 3, wd);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		createGeofenceButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath="//div/h4/span")
	WebElement getNameofPage;
	String nameOfthePage;
	public String getNameOfthePage(){
		nameOfthePage=getNameofPage.getText().trim();
		System.out.println( "POPup page is > "+nameOfthePage);
		return nameOfthePage;
	}

	
	@FindBy(xpath="//button/span[text()='Cancel']")
	WebElement cancelGeofence;
	public void clickCancelGeofence(EventFiringWebDriver wd){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		cancelGeofence.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	RandomNumber randomNo =new RandomNumber();
	
	@FindBy(id="name")
	WebElement enterGeoName;
	public void enterGefenceName(EventFiringWebDriver wd){
		try {
			highlightMyElement(enterGeoName, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		enterGeoName.sendKeys("Auto_GeoName_"+randomNo.generateRnumber());
	}
	
	@FindBy(xpath=".//*[@id='geofenceCreator']/div/div/div[9]/div[3]/div/span/div/img")
	WebElement geoShape;
	public void geoShapeCircle( EventFiringWebDriver wd){
		try {
			highlightMyElement(geoShape, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		geoShape.click();
		Actions builder =new Actions(wd);
		builder.clickAndHold();
		
		
		
	}
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement clickSave;
	public void clickSaveGeo(EventFiringWebDriver wd){
		try {
			highlightMyElement(clickSave, 3, wd);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		clickSave.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath="//input[@name='active_geofence'][1]")
	WebElement activeGeofence;
	public void clickActiveGefenceRadiobutton(EventFiringWebDriver wd){
		try {
			highlightMyElement(activeGeofence, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*wd.switchTo().defaultContent();
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		jse.executeScript("scroll(0,-250);", "");
		//jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);*/
		activeGeofence.click();
	}
	@FindBy(xpath="//button/span[contains(text(),'Assign Machines')]")
	WebElement assignMachines;
	public void clickAssignMachineButton(EventFiringWebDriver wd){
		try {
			highlightMyElement(assignMachines, 3, wd);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wd.switchTo().defaultContent();
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		//jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,650);", "");
		wd.switchTo().frame(frameId);
		assignMachines.click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	@FindBy(xpath="//geofence-machinelist/div[2]/div/div/table/tbody[1]")
	public WebElement assignMachineTableEle;
	public void validateAssignMachineTable(EventFiringWebDriver wd){
		try {
			highlightMyElement(assignMachineTableEle, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getAssignMachineSerialNumbers(assignMachineTableEle);
	}
	
	public List<String> getAssignMachineSerialNumbers(WebElement elementAssignmachinetable){
		List<String> listAssignMachines=new ArrayList<String>();
		List<WebElement> rows=elementAssignmachinetable.findElements(By.tagName("tr"));
		for (int rowsA = 1; rowsA < rows.size(); rowsA++) {
			List<WebElement> colA=rows.get(rowsA).findElements(By.tagName("td"));
			listAssignMachines.add(colA.get(1).getText());
			
		}
		System.out.println("List of Assign Machines  : "+listAssignMachines);
		return listAssignMachines;
	}
	int noofitr,tot;
	@FindBy(xpath="//tfoot/tr/td/div/span[@class='ng-binding ng-scope']")
	public WebElement totalrows;
	String totalAssign;
	public void totalrowinAssignmachines(){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		totalAssign=totalrows.getText();
		//String str=totalAssign.substring(25, 28).trim();
		String regex = "[^\\d]+";

        String[] strr = totalAssign.split(regex);

        System.out.println(strr[3]);
		//System.out.println(str);
		 tot=Integer.parseInt(strr[3]);
		System.out.println("Total rows : "+tot);
		 noofitr=tot/10;
		 System.out.println("Total iterations"+noofitr);
	}
	
	@FindBy(linkText=">")
	public WebElement next;
	
	public List<String> getAssignMachineSerialNo(EventFiringWebDriver wd) throws InterruptedException{
		List<String> listAssignMachines=new ArrayList<String>();
		if(tot>10){
		for (int i = 0; i <= noofitr; i++) {
			List<WebElement> rows=assignMachineTableEle.findElements(By.tagName("tr"));
			for (int rowsA = 1; rowsA < rows.size(); rowsA++) {
				List<WebElement> colA=rows.get(rowsA).findElements(By.tagName("td"));
				listAssignMachines.add(colA.get(1).getText().toString().trim().toLowerCase());
				
			}
			try {
				highlightMyElement(next, 3, wd);
			} catch (IOException e) {
				e.printStackTrace();
			}
			next.click();
			Thread.sleep(2000);
		}
		
		System.out.println("List of Assign Machines  : "+listAssignMachines);
	}
		else{
			return getAssignMachineSerialNumbers(assignMachineTableEle);
		}
		return listAssignMachines;
	}
	
	@FindBy(xpath="//button/span[contains(text(),'Cancel')]")
	WebElement assignCancel;
	public void clickCancelAssignbutton(EventFiringWebDriver wd){
		wd.switchTo().defaultContent();
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,650);", "");
		wd.switchTo().frame(frameId);
		assignCancel.click();
	}
	/**************************** Manage Notification Tab ***********************************/
	
	@FindBy(id="notificationMethod")
	public WebElement notificationselect;
	public void selectNotificationMethod(EventFiringWebDriver wd){
		try {
			Thread.sleep(5000);
			highlightMyElement(notificationselect, 3, wd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Select selectNotificationmenthod= new Select(notificationselect);
		selectNotificationmenthod.selectByVisibleText("Email");
		
		
	}
	String selectedNotificationTyep;
	@FindBy(id="notificationType")
	public WebElement selectnotificationtype;
	public String selectNotificationType(EventFiringWebDriver wd){
		try {
			highlightMyElement(selectnotificationtype, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*Select selectNotificationType= new Select(selectnotificationtype);
		selectNotificationType.selectByVisibleText("Critical Codes");
		WebElement option=selectNotificationType.getFirstSelectedOption();*/
		Select sele=new Select(selectnotificationtype);
		List<WebElement> listOpt=sele.getOptions();
		for (int i=1;i< listOpt.size()-1;i++) {
			sele.selectByVisibleText(listOpt.get(i).getText().trim());
			if(listOpt.get(i).getText().trim().equals("Geofence")){
				Select seleGeo=new Select(eofenceDrop);
				List<WebElement> listOptGeo=seleGeo.getOptions();
				for (WebElement geo : listOptGeo) {
					seleGeo.selectByValue(geo.getText().trim());break;
				}
			}
			break;
		}
		WebElement option=sele.getFirstSelectedOption();
		return selectedNotificationTyep=option.getText();
	}
	@FindBy(xpath="//button/span[contains(text(),'Add')]")
	public WebElement addNotification;
	public void clickAddNotificationButton(EventFiringWebDriver wd){
		try {
			highlightMyElement(addNotification, 3, wd);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		addNotification.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//input[@class='delete-button']")
	public WebElement deleteNotification;
	public void deleNotifcationEmail(EventFiringWebDriver wd){
		try {
			highlightMyElement(deleteNotification, 3, wd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		deleteNotification.click();
	}
	
	
	@FindBy(xpath="//table[@st-table='$ctrl.notifications' and @st-pipe='$ctrl.getNotifications']/tbody[1]")
	public WebElement notificationTable;
	public void validateNotificationList(){
		getNoficationEmailList(notificationTable);
	}
	
	public int rowSize;
	public void getNoficationEmailList(WebElement eleNotificationTable){
		List<String> MethodCol=new ArrayList<String>();
		List<String> notificationTypeCol=new ArrayList<String>();
		List<WebElement> rows=eleNotificationTable.findElements(By.tagName("tr"));
		rowSize=rows.size();
		System.out.println(rowSize);
		for (int rowN = 1; rowN < rows.size(); rowN++) {
			 List<WebElement> colN=rows.get(rowN).findElements(By.tagName("td"));
			MethodCol.add(colN.get(0).getText());
			notificationTypeCol.add(colN.get(1).getText());
			
		}
		for (int i = 0; i < MethodCol.size(); i++) {
			System.out.println("Notification Email List: "+ "["+ MethodCol.get(i) +" > "+ notificationTypeCol.get(i)+"]");
		
		}
	}
	
	@FindBy(xpath="//table/tbody[1]/tr[2]/td[4]/input")
	public WebElement deleteNotificationEle;
	public void clickDeleteNotification(EventFiringWebDriver wd){
		try {
			highlightMyElement(deleteNotificationEle, 3, wd);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		deleteNotificationEle.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@FindBy(xpath="html/body/div[1]/div/div/div[3]/button[2]")
	WebElement yesDeleteNotification;
	public void clickYesRemoveNotification(EventFiringWebDriver wd){
		try {
			highlightMyElement(yesDeleteNotification, 3, wd);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		yesDeleteNotification.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public int totalNotifications;
	public int getTotalNoficationEmailRows(){
		List<WebElement> rows=notificationTable.findElements(By.tagName("tr"));
		return totalNotifications=rows.size();
	}
	String notfication;
	public String getNoficationTypeValue(){
		List<WebElement>cols=null;
		List<WebElement> rows=notificationTable.findElements(By.tagName("tr"));
		rowSize=rows.size();
		System.out.println(rowSize);
		  for(int i=1;i<rows.size();i++){
		cols=rows.get(rowSize-1).findElements(By.tagName("td"));
	
		  }
		  return notfication =cols.get(1).getText();
	}
	
	/**********************************************************Settings tab **************/
	
	@FindBy(id="systemOfMeasurement")
	WebElement Systemofmeasurement;
	String selectedOPt;
	public String selectSystemofMeasurement(){
		Select select=new Select(Systemofmeasurement);
		//selectByVisibleText(Systemofmeasurement, vText);
		List<WebElement>opt=select.getOptions();
		List<String>op=new ArrayList<String>();;
		for (WebElement webElement : opt) {
			
			if(!webElement.getText().trim().equals("")){
			op.add(webElement.getText().trim());}
			
		}
		System.out.println(op);
		String[] array = new String[op.size()];
		op.toArray(array);
				Random r = new Random();
		 selectedOPt=array[r.nextInt(array.length)];
		selectByVisibleText(Systemofmeasurement, selectedOPt);
		return selectedOPt;
	}
	
	public String getSelectedSystemOfOpt(){
		Select select=new Select(Systemofmeasurement);
		String selectedval=select.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedval.trim(), selectedOPt.trim());
		return selectedval;
	}
	
	
	@FindBy(xpath="//button/span[text()='Save']")
	WebElement settingsSAve;
	
	public void clickSettingSave(){
		settingsSAve.click();
	}
	
	public  void highlightMyElement(WebElement element, int waitSeconds, EventFiringWebDriver webdriver)
			throws IOException {
		for (int i = 0; i < waitSeconds; i++) {
			JavascriptExecutor js = (JavascriptExecutor) webdriver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: red; border: 5px solid red;");
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");

		}

	}

	public static void waitforpagetoload(EventFiringWebDriver wd)
	{
		for (int i = 0; i <= 60; i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	       boolean pagestatus = ((JavascriptExecutor)wd).executeScript("return document.readyState").equals("complete");
	       if (pagestatus == true) {
	              break;
	          }
	        }
	} 	
}
