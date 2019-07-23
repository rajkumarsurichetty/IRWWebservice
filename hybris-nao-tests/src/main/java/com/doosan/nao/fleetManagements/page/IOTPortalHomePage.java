package com.doosan.nao.fleetManagements.page;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.doosan.nao.init.TestInitializer;

public class IOTPortalHomePage {
	
	@FindBy(how =How.ID,using="a-header-dashboards")
	WebElement dashboard;
	public void clickDashBoard(){
		dashboard.click();
	}
	@FindBy(how =How.ID,using="a-header-things")
	WebElement things;
	public void clickThings(WebDriver wd){
		
		/*try {
			highlightMyElement(clickActive, 3, wd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 120);
		waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(things));
		things.click();
		try {
			//WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 120);
			waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(clickHere));
			//Thread.sleep(8000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(how =How.ID,using="a-header-connections")
	WebElement connections;
	public void clickConnections(){
		connections.click();
	}
	
	@FindBy(how =How.XPATH,using="//a[@title='Cog Menu']")
	WebElement settingsIcon;
	public void clickSettingICON(EventFiringWebDriver wd){
		try {
			//Thread.sleep(9000);
			WebDriverWait wait =new WebDriverWait(wd, 180);
			wait.until(ExpectedConditions.elementToBeClickable(settingsIcon));
			highlightMyElement(settingsIcon, 3, wd);
		} catch (Exception e) {
			
		}
		settingsIcon.click();
	}
	@FindBy(how =How.XPATH,using="//li/a[@data-target='#orgSwitch']")
	WebElement settingsIconOrgSwitch;
	public void clickSettingICONSwitch(){
		settingsIconOrgSwitch.click();
	}
	@FindBy(how =How.XPATH,using="//div[contains(@class,'org-name-switch')]/a")
	WebElement orgSwitch;
	public void clickOrganizationSwitch(EventFiringWebDriver wd){
		wd.manage().window().maximize();
		try {
			//Thread.sleep(9000);
			WebDriverWait wait =new WebDriverWait(wd, 180);
			wait.until(ExpectedConditions.elementToBeClickable(orgSwitch));
			highlightMyElement(orgSwitch, 3, wd);
		} catch (Exception e) {
			
		}
		orgSwitch.click();
	}
	
	//@FindBy(xpath="//a[text()='DBI_QA']")
	WebElement selectEnvironment;
	public void selectEnvironment(WebDriver wd,String IOTEvn){
		String evn="//a[text()='"+IOTEvn+"']";
		selectEnvironment=wd.findElement(By.xpath(evn));
		try {
			highlightMyElement(selectEnvironment, 3, wd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectEnvironment.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FindBy(linkText="active")
	WebElement clickActive;
	public void clickActiveEquipments(WebDriver wd){
		try {
			highlightMyElement(clickActive, 3, wd);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			highlightMyElement(clickActive, 3, wd);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clickActive.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(linkText="dealer")
	WebElement dealer;
	public void selectDealer(WebDriver wd){
		try {
			highlightMyElement(dealer, 3, wd);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		dealer.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(id="ThingQuery")
	WebElement things_search;
	public void enterequipmentThings(EventFiringWebDriver wd,String Equipmentname){
		TestInitializer.waitforpagetoload(wd);
		things_search.sendKeys(Equipmentname,Keys.ENTER);
		TestInitializer.waitforpagetoload(wd);		
	}
	
	
	
	
	@FindBy(xpath="//a[@onclick='showAllTags();']")
	WebElement clickHere;
	public void clickHereForMoreOrg(WebDriver wd){
		try {
			highlightMyElement(clickHere, 3, wd);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		wd.get("https://portal-dev.telit.com/things/browse");;
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickHere.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FindBy(how=How.LINK_TEXT,using="org1489")
	public WebElement orgLink;
	public void clickOrganizationLik(WebDriver wd){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			highlightMyElement(orgLink, 3, wd);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		orgLink.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(id="button-page-limit-dropup")
	public WebElement pageLimit;
	@FindBy(xpath="(//a[text()='500'])[2]")
	public WebElement pageLimitVal;
	@FindBy(id="button-page-limit-dropup")
	public WebElement pageLimite;//*[@id="ThingActionForm"]/div[3]/div/ul/li[5]/a
	
	public void clickPAgeLimitDropButton(WebDriver wd){
		try {
		highlightMyElement(pageLimit, 3, wd);
		pageLimit.click();
		
			Thread.sleep(3000);
			
		}			
		 catch (Exception e) {}
		
		try {
			//Actions action=new Actions(wd);
			//action.moveToElement(pageLimitVal).click().build().perform();
			highlightMyElement(pageLimitVal, 3, wd);
			pageLimitVal.click();
			Thread.sleep(9000);
			
		}			
		 catch (Exception e) {}
	}
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Table')]")
	public WebElement thingsTable;
	public void clickThingsTableTab(WebDriver wd){
		clickPAgeLimitDropButton(wd);
		
		try {
			highlightMyElement(thingsTable, 3, wd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thingsTable.click();
		try {
			Thread.sleep(4000);
			
		}			
		 catch (Exception e) {}
			
	}
	@FindBy(xpath=".//*[@id='ThingActionForm']")
	public WebElement equpmentsTl;
	public void totalEquipments(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tequimoments=equpmentsTl.getText();
		String tot=tequimoments.substring(2,5);
		System.out.println(tequimoments.substring(2,5).trim());
	}
	
	@FindBy(xpath="//form/table/tbody")
	WebElement equipmentsIotGrid;
	public List<String> getIOTEquipmentsTable(WebDriver wd){
		try {
			highlightMyElement(equipmentsIotGrid, 3, wd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableDataRead(equipmentsIotGrid);
	}
	@FindBy(id="ThingActionForm")
	WebElement iotFrameid;
	public void switchToframeid(){
		
	}
	
	
	
	/**  
	 * Equipments details
	 * 
	 */
	//@FindBy(xpath="(//span[@class='glyphicons eye-open hidden-print'])[25]")
	@FindBy(xpath="//*[@id='thing-576414f9b2157c263dd7d5e4']/td[1]/a[1]/span[2]")
	WebElement eyeView;String xpathEyeView;String eyeElement;String precedeElement;
	//FleetManagementEquipmentPage ftpage=new FleetManagementEquipmentPage();
	@FindBy(xpath="//button[contains(@class,'button-page-limit-dropdown')]")
	WebElement selectNoPerPagebutton;
	
	@FindBy(xpath="//button[contains(@class,'button-page-limit-dropdown')]/following-sibling::ul[contains(@class,'dropdown-menu dropdown-menu-inverse')]/li/a[text()='500']")
	WebElement selectNoPerPage;
	public void clickEyeView(EventFiringWebDriver wd,String equipment){
		selectNoPerPagebutton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Actions act=new Actions(wd);
		act.moveToElement(selectNoPerPage).click().build().perform();
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<String>IOTequipment =getIOTEquipmentsTable(wd);
		int i=1;precedeElement="/preceding::td[2]/a[1]";
		for (String eNo : IOTequipment) {
			xpathEyeView=".//table[@class='table table-striped rwd table-configuration']/tbody/tr["+i+"]/td[3]";
			
			if(eNo.equalsIgnoreCase(equipment)){
				eyeElement=xpathEyeView+precedeElement;
				eyeView =wd.findElement(By.xpath(eyeElement));
				
			}
			i++;
		}
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		eyeView.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block .//*[@id='wrap']/div[4]/ul/li[1]/a
			e.printStackTrace();
		}
	}
	
	
	@FindBy(xpath=".//*[@id='wrap']/div[4]/ul/li[1]/a")
	WebElement clickThings;
	public void reClickThings(){
		clickThings.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//table[@class='table table-striped table-responsive']/tbody")
	WebElement viewEyeDetails;
	public Map<String, String> getTableViewEyeDetails(){
		return viewEquipmentDetailsTable(viewEyeDetails);
	}
	@FindBy(xpath="//td/span[@class='text-muted']")
	WebElement tdata;
	public Map<String, String> viewEquipmentDetailsTable(WebElement tableElement) {
		Map<String, String>eyeDetail=new HashMap<String, String>();
		List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
		System.out.println("Total Table rows is =>"+( rows.size()));
		
		for (int row = 0; row < rows.size(); row++) {
			
			List<WebElement> cols = rows.get(row)
					.findElements(By.tagName("td"));
			/*String key=cols.get(1).getText();
			if(key.equals("acr_status")||key.equals("device_event_type")||key.equals("dr_status")||key.equals("service_status")||key.equals("status"))
			{System.out.println(" IOTEquipments > "+cols.get(1).getText() +" <=> "+cols.get(2).getText());
			eyeDetail.put(cols.get(1).getText(), cols.get(2).getText());
			}*/
			String value=cols.get(2).getText().trim();
			//System.out.println("Flag value  ="+value.length());
			if(value.length()>0){
				//System.out.println(" IOTEquipments > "+cols.get(1).getText() +" <=> "+cols.get(2).getText());
				eyeDetail.put(cols.get(1).getText(), cols.get(2).getText());
			}else{
				//System.out.println(" No data");
			}
			
			for (int col = 1; col < cols.size()-1; col++) {
				
				//System.out.println( " => "+cols.get(col).getText());

			}
		}
		
		return eyeDetail;
	}
	
	
	/**
	 * This method to get the data from WebTable
	 */
	public List<String> tableDataRead(WebElement tableElement) {
		List <String>equipmets =new ArrayList<String>();
		List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
		System.out.println("Total Table rows is =>"+( rows.size()));
		
		for (int row = 0; row < rows.size(); row++) {
			List<WebElement> cols = rows.get(row)
					.findElements(By.tagName("td"));
			
			//System.out.println(" IOTEquipments > "+cols.get(1).getText());
			equipmets.add(cols.get(2).getText());
			for (int col = 1; col < cols.size()-1; col++) {
				
				//System.out.println( " => "+cols.get(col).getText());

			}
		}
		return equipmets;
	}
	public  void highlightMyElement(WebElement element, int waitSeconds, WebDriver webdriver)
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
	int ind=0;WebElement xp;
	@FindBy(xpath="//form/table/tbody")
	WebElement tableEyeToEquipvalue;
	public void gettableEyeValue(WebDriver wd){
		List<String> rowIndex=new ArrayList<String>();
		List<WebElement>rows=tableEyeToEquipvalue.findElements(By.tagName("tr"));
		for(int r=0;r<rows.size();r++){
			
			List<WebElement>cols=rows.get(r).findElements(By.tagName("td"));
			System.out.println( cols.get(2).getText());
			rowIndex.add(cols.get(2).getText());
			if(cols.get(2).getText().equalsIgnoreCase("aljg18918")){
			 ind=rowIndex.indexOf("aljg18918");
			System.out.println(ind);
			int row=(ind)+1;
			wd.findElement(By.xpath( "//form/table/tbody/tr["+row+"]/td[1]/a[1]/span[2]")).click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			}
			
		}
		
	}
	
	/*int row=(ind)+1;
	
	
	
	public void clickEyeOfEqupment(){
		System.out.println(ind);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			highlightMyElement(clickEyeEquipment, 3, wd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xp.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@FindBy(xpath="//div[@id='value-unit-retail_threshold']/span")
	WebElement retaildThreshold;
	
	@FindBy (xpath="//strong/a[text()='Retail Threshhold']/following::div[@id='value-unit-retail_threshold']/span[@class='current-value']")
	WebElement retailedThreasholdGraph;
	@FindBy (xpath="//a[text()='Message Type']")
	WebElement beforeRetThresholdEle;
	int retailts;
	public String getRetailThresholdValue(WebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		 
		   // WebElement element = wd.findElement(By.linkText("Google.com.ph"));
		    //jse.executeScript("arguments[0].scrollIntoView();", retaildThreshold);
		    jse.executeScript("arguments[0].scrollIntoView();", beforeRetThresholdEle);
		    try {
				Thread.sleep(60000L);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			try {
				Thread.sleep(30000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 400);
			waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(retailedThreasholdGraph));
			highlightMyElement(retaildThreshold, 3, wd);
		} catch (Exception e) {
			
		}
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 200);
		waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(retailedThreasholdGraph));
		String retailT=retaildThreshold.getText().trim();
		//System.out.println(retailT+ " Inger val"+Integer.parseInt(retailT));
		return retailT;
		
		
		
	}
	
	
	/***************************Attributes*********************************************/
	
	
	@FindBy(xpath="//a[text()='Attributes']")
	WebElement attribute;
	public void clickAttributeTab(EventFiringWebDriver wd){
		
		try {
			highlightMyElement(attribute, 3, wd);
			attribute.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			
		}
	}
	
	//div[@id='attributes']/dl/dt/span[text()='ACD Version']

	//div[@id='attributes']/dl/dt/span[text()='ACD Version']/following::dd/span

	//div[@id='attributes']/dl/dt/span[text()='ACD Version']/following::dd/span

	//click eye

	//div[@id='attributes']/dl/dt/span[text()='ACD Version']/following::dd/a[2]
	String AttProperties;
	WebElement serviesLogPropEle;
	String AttPropertyVal;
	WebElement serviesLogPropVAlEle;
	String property;
	String propertyVal;
	List<String>AddNoneValList;
	List<String>AddNonNoneValList;
	public void getServiecLogData(EventFiringWebDriver wd,List<String> seriviesProperList){
		AddNoneValList=new ArrayList<String>();
		AddNonNoneValList=new ArrayList<String>();
		for (String string : seriviesProperList) {
			if(string.equals("Auxiliary/MX Secondary Version")){
				string="Auxiliary/MX Secondary Version";
				//AttProperties="//div[@id='attributes']/dl/dt/span[text()='"+string+"']";
				AttProperties="//div[@id='attributes']/div/div/span[text()='"+string+"']";
				serviesLogPropEle=wd.findElement(By.xpath(AttProperties));
				 property=serviesLogPropEle.getText();
				System.out.println(" property "+property);
				//AttPropertyVal="//div[@id='attributes']/dl/dt/span[text()='"+string+"']"+"/following::dd/span";
				AttPropertyVal="//div[@id='attributes']/div/div/span[text()='"+string+"']/../following-sibling::div/div/div/span";
				serviesLogPropVAlEle=wd.findElement(By.xpath(AttPropertyVal));
				TestInitializer.highlightMyElement(serviesLogPropVAlEle, 4, wd);
				 propertyVal=serviesLogPropVAlEle.getText();
				System.out.println(" property Values are "+propertyVal);
				if(propertyVal.equals("")){
					AddNoneValList.add(property);
				}else {
					AddNonNoneValList.add(property);
				}
			}else if(string.equals("Workgroup Throttle Version"))
					{
			string="Workgroup/Throttle Version";
			//AttProperties="//div[@id='attributes']/dl/dt/span[text()='"+string+"']";
			AttProperties="//div[@id='attributes']/div/div/span[text()='"+string+"']";
			serviesLogPropEle=wd.findElement(By.xpath(AttProperties));
			 property=serviesLogPropEle.getText();
			System.out.println(" property "+property);
			//AttPropertyVal="//div[@id='attributes']/dl/dt/span[text()='"+string+"']"+"/following::dd/span";
			AttPropertyVal="//div[@id='attributes']/div/div/span[text()='"+string+"']/../following-sibling::div/div/div/span";
			serviesLogPropVAlEle=wd.findElement(By.xpath(AttPropertyVal));
			TestInitializer.highlightMyElement(serviesLogPropVAlEle, 4, wd);
			 propertyVal=serviesLogPropVAlEle.getText();
			System.out.println(" property Values are "+propertyVal);
			property="Workgroup Throttle Version";
			if(propertyVal.equals("")){
				AddNoneValList.add(property);
			}else {
				AddNonNoneValList.add(property);
			}
			}else{
				//AttProperties="//div[@id='attributes']/dl/dt/span[text()='"+string+"']"; this change for UI 
				AttProperties="//div[@id='attributes']/div/div/span[text()='"+string+"']";
				serviesLogPropEle=wd.findElement(By.xpath(AttProperties));
				 property=serviesLogPropEle.getText();
				System.out.println(" property "+property);
				//AttPropertyVal="//div[@id='attributes']/dl/dt/span[text()='"+string+"']"+"/following::dd/span";
				AttPropertyVal="//div[@id='attributes']/div/div/span[text()='"+string+"']/../following-sibling::div/div/div/span";
				
				serviesLogPropVAlEle=wd.findElement(By.xpath(AttPropertyVal));
				TestInitializer.highlightMyElement(serviesLogPropVAlEle, 4, wd);
				 propertyVal=serviesLogPropVAlEle.getText();
				System.out.println(" property Values are "+propertyVal);
				if(propertyVal.equals("")){// changed for space here. previously  there is space coming but now no space.
					AddNoneValList.add(property);
				}else {
					AddNonNoneValList.add(property);
				}
			}
		}
		System.out.println("System None value"+AddNoneValList);
		System.out.println("System Non None value"+AddNonNoneValList);
		}
	List<String>StringNonneList;
	public List<String> checkNonevaluesList(){
		StringNonneList=new ArrayList<String>();
		return StringNonneList=AddNoneValList;
	}
	String selectedNonNonneProperty;
	String selectedNonNonnePropertyElement;
	WebElement selectDeleteNonNoneValWebEle;
	public void checkDeletePropertiesValueFromIOT(EventFiringWebDriver wd){
		Random rand = new Random();
		selectedNonNonneProperty=AddNonNoneValList.get(rand.nextInt(AddNonNoneValList.size()));
		if(selectedNonNonneProperty.equals("Workgroup Throttle Version")){
			String selec="Workgroup/Throttle Version";
		
		//selectedNonNonnePropertyElement="//div[@id='attributes']/dl/dt/span[text()='"+selec+"']/following::dd/a[3]";
		selectedNonNonnePropertyElement="//div[@id='attributes']/div/div/span[text()='"+selec+"']/../following-sibling::div/div/div[3]/a[3]";
		selectDeleteNonNoneValWebEle=wd.findElement(By.xpath(selectedNonNonnePropertyElement));
		TestInitializer.highlightMyElement(selectDeleteNonNoneValWebEle, 4, wd);
		selectDeleteNonNoneValWebEle.click();
		Alert alert=wd.switchTo().alert();
		System.out.println(alert.getText());
		if(selectedNonNonneProperty.equals("Workgroup Throttle Version")){
			Assert.assertEquals(alert.getText().contains("Workgroup/Throttle Version"), true);
			alert.accept();
		}else if(selectedNonNonneProperty.equals("Auxilliary/MX Secondary Version")){
			Assert.assertEquals(alert.getText().contains("Auxiliary/MX Secondary Version"), true);
			alert.accept();
			wd.switchTo().defaultContent();
		}else{
		Assert.assertEquals(alert.getText().contains(selectedNonNonneProperty), true);
		alert.accept();}
		}else if(selectedNonNonneProperty.equals("Auxiliary/MX Secondary Version")){
			String selec="Auxiliary/MX Secondary Version";
		//selectedNonNonnePropertyElement="//div[@id='attributes']/dl/dt/span[text()='"+selec+"']/following::dd/a[3]";
			
			selectedNonNonnePropertyElement="//div[@id='attributes']/div/div/span[text()='"+selec+"']/../following-sibling::div/div/div[3]/a[3]";
			
		selectDeleteNonNoneValWebEle=wd.findElement(By.xpath(selectedNonNonnePropertyElement));
		TestInitializer.highlightMyElement(selectDeleteNonNoneValWebEle, 4, wd);
		selectDeleteNonNoneValWebEle.click();
		Alert alert=wd.switchTo().alert();
		System.out.println(alert.getText());
		if(selectedNonNonneProperty.equals("Workgroup Throttle Version")){
			Assert.assertEquals(alert.getText().contains("Workgroup/Throttle Version"), true);
			alert.accept();
			wd.switchTo().defaultContent();
		}else if(selectedNonNonneProperty.equals("Auxilliary/MX Secondary Version")){
			Assert.assertEquals(alert.getText().contains("Auxiliary/MX Secondary Version"), true);
			alert.accept();
			wd.switchTo().defaultContent();
		}else{
		Assert.assertEquals(alert.getText().contains(selectedNonNonneProperty), true);
		alert.accept();
		wd.switchTo().defaultContent();
		}
		}else{System.out.println();
		//selectedNonNonnePropertyElement="//div[@id='attributes']/dl/dt/span[text()='"+selectedNonNonneProperty+"']/following::dd/a[3]";
		
		selectedNonNonnePropertyElement="//div[@id='attributes']/div/div/span[text()='"+selectedNonNonneProperty+"']/../following-sibling::div/div/div[3]/a[3]";
		TestInitializer.waitForElement(wd, wd.findElement(By.xpath(selectedNonNonnePropertyElement)));//added  wait elemnet on 14 mar 19
		selectDeleteNonNoneValWebEle=wd.findElement(By.xpath(selectedNonNonnePropertyElement));
		TestInitializer.highlightMyElement(selectDeleteNonNoneValWebEle, 4, wd);
		selectDeleteNonNoneValWebEle.click();
		Alert alert=wd.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText().contains(selectedNonNonneProperty), true);
		alert.accept();
		wd.switchTo().defaultContent();
		}
		
	}
	public String getSelectedPropertyRandomly(){
		String sele=selectedNonNonneProperty;
		return sele;
	}
	public void checkPropertyValueDeleted(EventFiringWebDriver wd){
		if(selectedNonNonneProperty.equals("Auxiliary/MX Secondary Version")){
			String tt="Auxiliary/MX Secondary Version";
			//String proVal="//div[@id='attributes']/dl/dt/span[text()='"+tt+"']"+"/following::dd/span";
			
			String proVal="//div[@id='attributes']/div/div/span[text()='"+tt+"']"+"/../following-sibling::div/div/div/span";
			
			WebElement propDeleEle=wd.findElement(By.xpath(proVal));
			TestInitializer.highlightMyElement(propDeleEle, 4, wd);
			System.out.println(propDeleEle.getText());
			
			//Assert.assertEquals(propDeleEle.getText().equals(" "), true);
			Assert.assertEquals(propDeleEle.getText().equals(""), true);
			
		}else if(selectedNonNonneProperty.equals("Workgroup Throttle Version")){	String tt="Workgroup/Throttle Version";
			
		//String proVal="//div[@id='attributes']/dl/dt/span[text()='"+tt+"']"+"/following::dd/span";
		
		String proVal="//div[@id='attributes']/div/div/span[text()='"+tt+"']"+"/../following-sibling::div/div/div/span";
		
			WebElement propDeleEle=wd.findElement(By.xpath(proVal));
			TestInitializer.highlightMyElement(propDeleEle, 4, wd);
			System.out.println(propDeleEle.getText());
			
			//Assert.assertEquals(propDeleEle.getText().equals(" "), true);
			Assert.assertEquals(propDeleEle.getText().equals(""), true);
		}else{
			
		//String proVal="//div[@id='attributes']/dl/dt/span[text()='"+selectedNonNonneProperty+"']"+"/following::dd/span";
		
		String proVal="//div[@id='attributes']/div/div/span[text()='"+selectedNonNonneProperty+"']"+"/../following-sibling::div/div/div/span";
		
		WebElement propDeleEle=wd.findElement(By.xpath(proVal));
		TestInitializer.highlightMyElement(propDeleEle, 4, wd);
		System.out.println(propDeleEle.getText());
		
		Assert.assertEquals(propDeleEle.getText().equals(""), true);
		}
	}
	@FindBy (id="AttrValue")
	WebElement Attributevalue;
	String EnterNewAttributeVal;
	public void enetrattributeValue(){
		DateFormat sdf;
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		// System.out.println(sdf.format(date));
		String da = sdf.format(date);
		EnterNewAttributeVal="AutoAtbVal"+da.replaceAll("[/,:]", "").replace(" ", "");
		Attributevalue.sendKeys(EnterNewAttributeVal);
	}
	String attributeAftersetupValue;
	String getPropertyVale;
	@FindBy(xpath="")
	WebElement getpropetyvalEle;
	public String getPropertyValueAfterSetup(EventFiringWebDriver wd){
		if(NoneSelectedProperty.equals("Workgroup Throttle Version")){
			String selec="Workgroup/Throttle Version";
			String Text="{\"value\":\""+EnterNewAttributeVal+"\"}";
			//getPropertyVale="//div[@id='attributes']/dl/dt/span[text()='"+selec+"']/following::dd/span[@data-json='"+Text+"']";
			
			getPropertyVale="//div[@id='attributes']/div/div/span[text()='"+selec+"']/../following-sibling::div/div/div/span[@data-json='"+Text+"']";
			getpropetyvalEle=wd.findElement(By.xpath(getPropertyVale));
			attributeAftersetupValue=getpropetyvalEle.getText();
			System.out.println(attributeAftersetupValue);
		
		}
		else if(NoneSelectedProperty.equals("Auxilliary/MX Secondary Version")){
			String Text="{\"value\":\""+EnterNewAttributeVal+"\"}";
			String selec="Auxiliary/MX Secondary Version";
			//getPropertyVale="//div[@id='attributes']/dl/dt/span[text()='"+selec+"']/following::dd/span[@data-json='"+Text+"']";
			
			getPropertyVale="//div[@id='attributes']/div/div/span[text()='"+selec+"']/../following-sibling::div/div/div/span[@data-json='"+Text+"']";
			
			getpropetyvalEle=wd.findElement(By.xpath(getPropertyVale));
			attributeAftersetupValue=getpropetyvalEle.getText();
			System.out.println(attributeAftersetupValue);
		}else{
			//String updated=EnterNewAttributeVal.trim();
			String Text="{\"value\":\""+EnterNewAttributeVal+"\"}";
			
			//getPropertyVale="//div[@id='attributes']/dl/dt/span[text()='"+NoneSelectedProperty+"']/following::dd/span[@data-json='"+Text+"']";
			getPropertyVale="//div[@id='attributes']/div/div/span[text()='"+NoneSelectedProperty+"']/../following-sibling::div/div/div/span[@data-json='"+Text+"']";
			
			getpropetyvalEle=wd.findElement(By.xpath(getPropertyVale));
			attributeAftersetupValue=getpropetyvalEle.getText();
			System.out.println(attributeAftersetupValue);
			
		}
		return attributeAftersetupValue;
	}
	@FindBy (xpath="//input[@value='Set attribute']")
	WebElement SetAttributevalue;
	public void clickSetAtrributeButton(){
		SetAttributevalue.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}
	}
	String NoneSelectedProperty;
	
	WebElement SelectedNonePropertyEle;
	public void checkSetPropertyValue(List<String>getNoneList ,EventFiringWebDriver wd){
		
		Random rand = new Random();
		NoneSelectedProperty=getNoneList.get(rand.nextInt(getNoneList.size()));
		if(NoneSelectedProperty.equals("Workgroup Throttle Version")){
			String selec="Workgroup/Throttle Version";
			
			
		//selectedNonNonnePropertyElement="//div[@id='attributes']/dl/dt/span[text()='"+selec+"']/following::dd/a[2]";
		
		selectedNonNonnePropertyElement="//div[@id='attributes']/div/div/span[text()='"+selec+"']/../following-sibling::div/div/div[3]/a[2]";
		
		SelectedNonePropertyEle=	wd.findElement(By.xpath(selectedNonNonnePropertyElement));
		SelectedNonePropertyEle.click();
		
		}else if(NoneSelectedProperty.equals("Auxilliary/MX Secondary Version")){
			String selec="Auxiliary/MX Secondary Version";
			
		///selectedNonNonnePropertyElement="//div[@id='attributes']/dl/dt/span[text()='"+selec+"']/following::dd/a[2]";
			
		selectedNonNonnePropertyElement="//div[@id='attributes']/div/div/span[text()='"+selec+"']/../following-sibling::div/div/div[3]/a[2]";
		
		SelectedNonePropertyEle=wd.findElement(By.xpath(selectedNonNonnePropertyElement));
		SelectedNonePropertyEle.click();
		
		}else{
			//selectedNonNonnePropertyElement="//div[@id='attributes']/dl/dt/span[text()='"+NoneSelectedProperty+"']/following::dd/a[2]";
			
			selectedNonNonnePropertyElement="//div[@id='attributes']/div/div/span[text()='"+NoneSelectedProperty+"']/../following-sibling::div/div/div[3]/a[2]";
			
			SelectedNonePropertyEle=wd.findElement(By.xpath(selectedNonNonnePropertyElement));
			SelectedNonePropertyEle.click();
		}
		
	}
	public void navigatesToHyBbPortal(EventFiringWebDriver wd,String URL)
	{
		wd.navigate().to(URL);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			
		}
	}
}