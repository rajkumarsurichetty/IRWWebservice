package com.doosan.nao.fleetManagements.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ServiceTabPage {
	

	@FindBy(xpath="//a/uib-tab-heading/span[text()='Service']")
	WebElement serviceTab;
	@FindBy(xpath="//th/span[text()='Invoice Date']")
	WebElement admintabinfo;
	public void checkServiceTabAvailability(EventFiringWebDriver wd){
		waitMethod(wd, admintabinfo);
		boolean flag=false;
		flag=serviceTab.isDisplayed();
		Assert.assertEquals(flag, true);
	}
	public void clickServiceTab(EventFiringWebDriver wd){
		try {
			highlightMyElement(serviceTab, 3, wd);
			serviceTab.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		} catch (IOException e) {
			
		}
		
	}
	

	@FindBy(xpath="//table[@st-table='servicePlan']/thead")
	WebElement serviceTableHeader;
	
	public void checkServiceTableHeader(EventFiringWebDriver wd){
		try {
			waitMethod(wd, serviceTableHeader);
		highlightMyElement(serviceTableHeader, 3, wd);
		boolean flag=false;
		flag=serviceTableHeader.isDisplayed();
		Assert.assertEquals(flag, true);
		} catch (IOException e) {
			
		}
	}
	
	public void getServiceHeaders(){
		List<WebElement>serviceHeaderCol;
		List<String>serviceHeaderColText;
		serviceHeaderColText=new ArrayList<String>();
		String col;
		List<WebElement>serviceHeader=serviceTableHeader.findElements(By.tagName("tr"));
		for(int i=0;i<serviceHeader.size();i++){
			serviceHeaderCol=serviceHeader.get(i).findElements(By.tagName("th"));
			for(int scol=0;scol<serviceHeaderCol.size();scol++){
				 col=serviceHeaderCol.get(scol).getText();
				 serviceHeaderColText.add(col);
			}
		}
		
		System.out.println(" Header"+serviceHeaderColText);
		
	}
	@FindBy(xpath="//table[@st-table='servicePlan']/tbody")
	WebElement serviceTablebody;
	public void getServiceplanDataInfo(){
		List<WebElement>serviceHeaderCol;
		List<String>serviceHeaderColText1;
		serviceHeaderColText1=new ArrayList<String>();
		List<String>serviceHeaderColText2;
		serviceHeaderColText2=new ArrayList<String>();
		Map<String ,String>tableData = null;
		 tableData=new HashMap<String, String>();
		String col1;String col2;
		List<WebElement>serviceHeader=serviceTablebody.findElements(By.tagName("tr"));
		for(int i=0;i<serviceHeader.size();i++){
			serviceHeaderCol=serviceHeader.get(i).findElements(By.tagName("td"));
			//for(int scol=0;scol<serviceHeaderCol.size();scol++){
				 col1=serviceHeaderCol.get(0).getText();
				 col2=serviceHeaderCol.get(1).getText();
				 serviceHeaderColText1.add(col1);
				 serviceHeaderColText2.add(col2);
				
				 tableData.put(col1, col2);
			//}
		}
		
		System.out.println(" Service Plan info"+tableData);
		
	}
	@FindBy(xpath="//a/span[text()='View kit contents']")
	List<WebElement> moreLink;
	int moreLinkcount;
	public void checkMoreinfoLink(){
		boolean flag;
		flag=moreLink.isEmpty();
		if(!flag==true){
		System.out.println(" More links count"+ moreLink.size());
		moreLinkcount=moreLink.size();
		}
		
	}
	
	public void checkmoreLinkclickable(EventFiringWebDriver wd){
		moreLink.get(0).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath="//h3")
	WebElement headerMoreLink;
	String headerText;
	public void checkheaderOfMorelinkPopup(EventFiringWebDriver wd){
		waitMethod(wd, headerMoreLink);
		boolean flag;
		try {
			highlightMyElement(headerMoreLink, 3, wd);
		} catch (IOException e) {
			
		}
		flag=headerMoreLink.isDisplayed();
		headerText=headerMoreLink.getText();
		System.out.println(" Header of more popup => "+headerText);
		Assert.assertEquals(flag, true);
	}
	String lastVal;
	public void getHeaderTextOfDescriptionCol(){
		String[] splitText=headerText.split("-");
		lastVal=splitText[splitText.length-1].trim();
		System.out.println(lastVal);
	}
	@FindBy(xpath="//button/span[text()='Close']")
	WebElement closeButton;
	public void clickCloseButtonInMorePopup(EventFiringWebDriver wd){
		try {
			highlightMyElement(closeButton, 3, wd);
		} catch (IOException e) {
			
		}
		closeButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
	}
	@FindBy(xpath="//table[@st-table='servicePlan']/tbody/tr[1]/td[2]")
	WebElement description1;
	String description1Text;
	
	public void getDescriptionColinTable(EventFiringWebDriver wd){
		
		try {
			Thread.sleep(2000);
			highlightMyElement(description1, 3, wd);
		} catch (Exception e) {
			
		}
		description1Text=description1.getText();
		System.out.println(description1Text);
	}
	
	public void checkDescriptions(){
		Assert.assertEquals(description1Text.trim().contains(lastVal),true);
	}
	//@FindBy(xpath="//service-interval-details/div[@class='modal-body']/div[7]/div/h5/span")
	//Emea
	@FindBy(xpath="//service-interval-details/div[@class='modal-body']/div[8]/div/h5/span")
	WebElement tableHeaderText1;
	String tableHeaderText11;
	public void gettableText1ofAllInMorePopup(){
		tableHeaderText11=tableHeaderText1.getText();
		System.out.println(tableHeaderText11);
	}
	//@FindBy(xpath="//service-interval-details/div[@class='modal-body']/div[9]/div/h5/span") //Emea changes
	@FindBy(xpath="//service-interval-details/div[@class='modal-body']/div[10]/div/h5/span")
	
	WebElement tableHeaderText2;
	String tableHeaderText22;
	public void gettableText2ofAllInMorePopup(){
		tableHeaderText22=tableHeaderText2.getText();
		System.out.println(tableHeaderText22);
	}
	
	//@FindBy(xpath="//service-interval-details/div[@class='modal-body']/div[11]/div/h5/span")//EMEA changes
	@FindBy(xpath="//service-interval-details/div[@class='modal-body']/div[12]/div/h5/span")
	WebElement tableHeaderText3;
	String tableHeaderText33;
	public void gettableText3ofAllInMorePopup(){
		tableHeaderText33=tableHeaderText3.getText();
		System.out.println(tableHeaderText33);
	}
	
	
	public void checktableText1ofAllInMorePopup(){
		Assert.assertEquals(tableHeaderText11, "Service Kits:");
	}
	public void checktableText2ofAllInMorePopup(){
		Assert.assertEquals(tableHeaderText22, "Service Parts:");
	}
	
	public void checktableText3ofAllInMorePopup(){
		Assert.assertEquals(tableHeaderText33, "Service Fluids:");
	}
	
	@FindBy(xpath="//service-kits-table[@maintenance-kits='$ctrl.serviceInterval.intervalDefinition.maintenanceKits']/table[@st-table='servicePlan']/thead")
	WebElement servicelogTableServiceKitsHeader;
	@FindBy(xpath="//service-kits-table[@maintenance-kits='$ctrl.serviceInterval.intervalDefinition.maintenanceKits']/table[@st-table='servicePlan']/tbody")
	WebElement servicelogTableServiceKits;
	List<String>servicekitValH;
	List<String>servicekitVal;
	public void getTableDataValuesOfServiceKitHeader(){
		servicekitValH=new ArrayList<String>();
		List<WebElement>serviceRow=servicelogTableServiceKitsHeader.findElements(By.tagName("tr"));
		for (int i = 0; i < serviceRow.size(); i++) {
			List<WebElement>ServiceCol=serviceRow.get(i).findElements(By.tagName("th"));
			for (int j = 0; j < ServiceCol.size(); j++) {
				servicekitValH.add(ServiceCol.get(j).getText());
			}
			
		}
		System.out.println("ServicekitVal >"+servicekitValH);
	}
	public void getTableDataValuesOfServiceKit(){
		servicekitVal=new ArrayList<String>();
		List<WebElement>serviceRow=servicelogTableServiceKits.findElements(By.tagName("tr"));
		for (int i = 0; i < serviceRow.size(); i++) {
			List<WebElement>ServiceCol=serviceRow.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < ServiceCol.size(); j++) {
				servicekitVal.add(ServiceCol.get(j).getText());
			}
			
		}
		System.out.println("ServicekitVal >"+servicekitVal);
	}
	@FindBy(xpath="//table[@st-table='serviceParts']/thead")
	WebElement servicelogTableServicePartsHeader;
	@FindBy(xpath="//table[@st-table='serviceParts']/tbody")
	WebElement servicelogTableServiceParts;
	List<String>ServicePartsValH;
	List<String>ServicePartsVal;
	public void getTableDataValuesOfServicePartsHeader(){
		ServicePartsValH=new ArrayList<String>();
		List<WebElement>serviceRow=servicelogTableServicePartsHeader.findElements(By.tagName("tr"));
		for (int i = 0; i < serviceRow.size(); i++) {
			List<WebElement>ServiceCol=serviceRow.get(i).findElements(By.tagName("th"));
			for (int j = 0; j < ServiceCol.size(); j++) {
				ServicePartsValH.add(ServiceCol.get(j).getText());
			}
			
		}
		System.out.println("ServicekitVal >"+ServicePartsValH);
	}
	public void getTableDataValuesOfServiceParts(){
		ServicePartsVal=new ArrayList<String>();
		List<WebElement>serviceRow=servicelogTableServiceParts.findElements(By.tagName("tr"));
		for (int i = 0; i < serviceRow.size(); i++) {
			List<WebElement>ServiceCol=serviceRow.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < ServiceCol.size(); j++) {
				ServicePartsVal.add(ServiceCol.get(j).getText());
			}
			
		}
		System.out.println("ServicekitVal >"+ServicePartsVal);
	}
	@FindBy(xpath="//table[@st-table='serviceFluids']/thead")
	WebElement servicelogTableServiceFluidsHeader;
	@FindBy(xpath="//table[@st-table='serviceFluids']/tbody")
	WebElement servicelogTableServiceFluids;
	List<String>ServiceFluidH;
	List<String>ServiceFluidVal;
	public void getTableDataValuesOfServiceFluidsHeader(){
		ServiceFluidH=new ArrayList<String>();
		List<WebElement>serviceRow=servicelogTableServiceFluidsHeader.findElements(By.tagName("tr"));
		for (int i = 0; i < serviceRow.size(); i++) {
			List<WebElement>ServiceCol=serviceRow.get(i).findElements(By.tagName("th"));
			for (int j = 0; j < ServiceCol.size(); j++) {
				ServiceFluidH.add(ServiceCol.get(j).getText());
			}
			
		}
		System.out.println("ServicekitVal >"+ServiceFluidH);
	}
	public void getTableDataValuesOfServiceFluids(){
		ServiceFluidVal=new ArrayList<String>();
		List<WebElement>serviceRow=servicelogTableServiceFluids.findElements(By.tagName("tr"));
		for (int i = 0; i < serviceRow.size(); i++) {
			List<WebElement>ServiceCol=serviceRow.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < ServiceCol.size(); j++) {
				ServiceFluidVal.add(ServiceCol.get(j).getText());
			}
			
		}
		System.out.println("ServicekitVal >"+ServiceFluidVal);
	}
	
	
	
	/*******************************************Service log***************************************************************/
	
	
	@FindBy(xpath="//uib-tab-heading/span[text()='Service Log']")
	WebElement servicelogTab;
	public void checkServiceLogTabIsavailable(EventFiringWebDriver wd){
		
		try {
			Thread.sleep(7000);
			highlightMyElement(servicelogTab, 3, wd);
		} catch (Exception e) {
			
		}
		boolean flag=servicelogTab.isDisplayed();
		Assert.assertEquals(flag, true);
	}
	public void clickServiceLogTab(EventFiringWebDriver wd){
		try {
			highlightMyElement(servicelogTab, 3, wd);
		} catch (IOException e) {
			
		}
		servicelogTab.click();
		}
	@FindBy(xpath="//span[text()='Current Software Versions']")
	WebElement servicelogtabHeader;
	public void checkServiceLogtabClikble(EventFiringWebDriver wd){
		try {
			highlightMyElement(servicelogtabHeader, 3, wd);
		} catch (IOException e) {
			
		}
		String servicelogtabHeaderText=servicelogtabHeader.getText();
		Assert.assertEquals(servicelogtabHeaderText, "Current Software Versions");
	}
	
	@FindBy(xpath="//software-versions/table/thead")
	WebElement servicelogtableHeader;
	public void checkDisplayServicelogTableHeaders(){
		List<WebElement>tblRow=servicelogtableHeader.findElements(By.tagName("tr"));
		for (int i = 0; i < tblRow.size(); i++) {
			List<WebElement>tblCol=tblRow.get(i).findElements(By.tagName("th"));
			for (int j = 0; j < tblCol.size(); j++) {
				String servicelogTableHeaderText=tblCol.get(j).getText();
				System.out.println("Service Log header is "+servicelogTableHeaderText);
			}
			
		}
	}
	
	
	
	@FindBy(xpath="//software-versions/table/tbody")
	WebElement servicelogTable;
	Map<String,String> serLogData;
	List <String>serviceLogControllerColomn;
	List<String>ServicenonNoneList;
	List<String>ServiceNoneList;
	List<String>serviceLogVersionList;
	public Map<String,String>  getserviceLogTableData(){
		serLogData=new HashMap<String, String>();
		ServiceNoneList=new ArrayList<String>();
		serviceLogControllerColomn=new ArrayList<String>();
		ServicenonNoneList=new ArrayList<String>();
		serviceLogVersionList=new ArrayList<String>();
		List<WebElement>tblRow=servicelogTable.findElements(By.tagName("tr"));
		for (int i = 0; i < tblRow.size(); i++) {
			List<WebElement>tblCol=tblRow.get(i).findElements(By.tagName("td"));
			//for (int j = 0; j < tblCol.size(); j++) {
				String servicelogControllerText=tblCol.get(0).getText();
				System.out.println("Service Log Table is "+servicelogControllerText);
				serviceLogControllerColomn.add(servicelogControllerText);
				String servicelogVersionText=tblCol.get(1).getText().trim();
				System.out.println("Service Log Table version is "+servicelogVersionText);
				serLogData.put(servicelogControllerText, servicelogVersionText);
				serviceLogVersionList.add(servicelogVersionText.trim());
		//	}
			if(tblCol.get(1).getText().equals("(none)")){
				ServiceNoneList.add(servicelogControllerText);
			}
			else{
				ServicenonNoneList.add(servicelogControllerText);
			}
		}
		//System.out.println(serLogData);
		//System.out.println(ServiceNoneList);
		//System.out.println(ServicenonNoneList);
		return serLogData;
	}
	List<String>Nonelist;
	public List<String> returnListNoneList(){
		Nonelist=new ArrayList<String>();
		Nonelist=ServiceNoneList;
		return Nonelist;
		
	}
	List<String>NonNonelist;
	public List<String> returnListNoNNoneList(){
		NonNonelist=new ArrayList<String>();
		NonNonelist=ServicenonNoneList;
		return NonNonelist;
		
	}
	
	List<String>versionlist;
	public List<String> returnListServiceLogVersionList(){
		versionlist=new ArrayList<String>();
		versionlist=serviceLogVersionList;
		return versionlist;
		
	}
	List<String>ListOfController;
	public List<String> returnListOFControllerCol(){
		ListOfController=new ArrayList<String>();
		ListOfController=serviceLogControllerColomn;
		return ListOfController;
		
	}
	@FindBy(xpath="//select[@ng-model='$ctrl.selectedVersion']")//select[@ng-model='$ctrl.selectedVersion']
	WebElement selectSoftwareHistory;
	 List<WebElement> softwareHistorylistele;
	public void getAllDropdownvaluesofSoftwareHistory(){
		Select select=new Select(selectSoftwareHistory);
		softwareHistorylistele=select.getOptions();
		for (WebElement string : softwareHistorylistele) {
			System.out.println(string.getText());
		}
	}
	
	@FindBy(xpath="//select[@ng-model='$ctrl.selectedVersion']/option[ @disabled]")
	List<WebElement> optionsisDisplay;
	List<String>ServiceVeriosdiabled;
	public void getallIsdisabled(){
		ServiceVeriosdiabled=new ArrayList<String>();
		for (int i = 0; i < optionsisDisplay.size(); i++) {
			ServiceVeriosdiabled.add(optionsisDisplay.get(i).getText());
			
		}
		System.out.println(ServiceVeriosdiabled);
	}
	
	
	public void checkServiceNoneListAndIsDisabledList(){
		boolean flag=ServiceVeriosdiabled.containsAll(ServiceNoneList);
		Assert.assertEquals(flag, true);
	}
	
	
	
	public void checkselectValueFromDropDownToResultsInTable(){
		for (int i = 0; i < ServiceVeriosdiabled.size(); i++) {
			System.out.println(ServiceVeriosdiabled.get(i));
			//if(ServiceVeriosdiabled.get(i).equals(arg0)){
				
			//}
		}
		
	}
	
	
/************************************************Service tab Service interval **************************************************/	
	String [] defaultVal={"250", "500", "1000"};
	
//			[100, 250, 250, 500, 500, 1000]
	
	@FindBy(xpath="//span[@ng-if='t.legend != null' and text()='250']")
	WebElement pointerclick;
	String pointerSTR;
			public void setDefaultIntervalsOpint(EventFiringWebDriver wd){
				//pointerSTR="//span[@ng-if='t.legend != null' and text()='"+250+"']";
				//pointerclick.click();
		wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='250']")).click();
		wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='500']")).click();
		wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='1000']")).click();
		System.out.println();
	}
			
			
			//String pointerSTR;
					public void setIntervalsOpint(EventFiringWebDriver wd,String intrvals){
						//pointerSTR="//span[@ng-if='t.legend != null' and text()='"+250+"']";
						//pointerclick.click();
						String []intr=intrvals.split("-");
						for (String string : intr) {
							wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='"+string+"']")).click();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								
								e.printStackTrace();
							}
							clickSaveIntervals();
						}
				
				//wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='500']")).click();
				//wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='1000']")).click();
				System.out.println();
			}
			
			
			
					public void setIntervalsRegular250(EventFiringWebDriver wd,String intrvals){
						//pointerSTR="//span[@ng-if='t.legend != null' and text()='"+250+"']";
						//pointerclick.click();
						String []intrval=intrvals.split("-");
						for (String string : intrval) {
							String []intr=string.split(",");
							//for (String string : intr) {
								wd.findElement(By.xpath("(//operating-hours-range/div/div/div/ul[@ng-show='showTicks'])["+intr[1]+"]/li/span[text()='"+intr[0]+"'][2]")).click();
								try {
									Thread.sleep(5000);
								} catch (InterruptedException e) {
									
									e.printStackTrace();
								}
								clickSaveIntervals();
						}
						
					//	}
				
				//wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='500']")).click();
				//wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='1000']")).click();
				
			}
			
					public void setIntervalsRegular500(EventFiringWebDriver wd,String intrvals){
						wd.findElement(By.xpath("(//operating-hours-range/div/div/div/ul[@ng-show='showTicks'])[2]/li/span[text()='"+intrvals+"'][2]")).click();
						/*//pointerSTR="//span[@ng-if='t.legend != null' and text()='"+250+"']";
						//pointerclick.click();
						String []intr=intrvals.split("-");
						for (String string : intr) {
							wd.findElement(By.xpath("(//operating-hours-range/div/div/div/ul[@ng-show='showTicks'])[2]/li/span[text()='"+string+"'][2]")).click();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								
								e.printStackTrace();
							}*/
							clickSaveIntervals();
						//}
				
				//wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='500']")).click();
				//wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='1000']")).click();
				
			}
			
					
					
					
					public void setIntervalsRegular1000(EventFiringWebDriver wd,String intrvals){
						wd.findElement(By.xpath("(//operating-hours-range/div/div/div/ul[@ng-show='showTicks'])[3]/li/span[text()='"+intrvals+"'][2]")).click();
						//pointerSTR="//span[@ng-if='t.legend != null' and text()='"+250+"']";
						//pointerclick.click();
						/*String []intr=intrvals.split("-");
						for (String string : intr) {
							wd.findElement(By.xpath("(//operating-hours-range/div/div/div/ul[@ng-show='showTicks'])[3]/li/span[text()='"+string+"'][2]")).click();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								
								e.printStackTrace();
							}*/
							clickSaveIntervals();
						//}
				
				//wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='500']")).click();
				//wd.findElement(By.xpath("//span[@ng-if='t.legend != null' and text()='1000']")).click();
				System.out.println();
			}			
	@FindBy(xpath="//button[text()='Save']")
	WebElement savaInterval;
public void clickSaveIntervals(){
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				savaInterval.click();
	}

@FindBy(xpath="//span[@ng-if='t.legend != null']")
	
	List<WebElement> regularPointerval;

List<String>regIntValues;
	public void sliderValue(){
		regIntValues=new ArrayList<String>();
		for (WebElement regintVal : regularPointerval) {
			//System.out.println(regintVal.getText());
			regIntValues.add(regintVal.getText());
			
		}
		System.out.println("regIntValues >> "+regIntValues);
		System.out.println();
	}
	
	@FindBy(xpath="")
	
	WebElement regular250Pointer;
	public void clickSliderInRegular250(){
		regular250Pointer.click();
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
						e.printStackTrace();
		}
	}
	
	
	
	
	public void GetServiceSchedule(EventFiringWebDriver wd){
		String maxInaterval="//table[@st-table='servicePlan']/tbody/tr/td[text()='3000']";
		wd.findElement(By.xpath("//table[@st-table='servicePlan']/tbody/tr/td[text()='"+regIntValues.get(regIntValues.size()-1)+"']")).getAttribute("index");
		List<WebElement> tableRow=wd.findElements(By.xpath("//table[@st-table='servicePlan']/tbody/tr"));
		List<String> serviceScheduleVal=new ArrayList<String>();
		for (int i = 1; i < tableRow.size(); i++) {
			
			//if(!serviceintval.equals(regIntValues.get(regIntValues.size()-1).trim())){
			if(wd.findElement(By.xpath("//table[@st-table='servicePlan']/tbody/tr["+i+"]/td[1]")).getText().equals(regIntValues.get(regIntValues.size()-1))){
				break;
			}
			String serviceintval=tableRow.get(i).findElement(By.tagName("td")).getText().trim();
				System.out.println(serviceintval);
				String  description=wd.findElement(By.xpath("//table[@st-table='servicePlan']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			//	System.out.println(wd.findElement(By.xpath("//table[@st-table='servicePlan']/tbody/tr["+i+1+"]/td[2]")).getText());
				wd.findElement(By.xpath("//table[@st-table='servicePlan']/tbody/tr["+(i+1)+"]/td[3]")).click();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				//wd.findElement(By.xpath("//service-kits-table/table/tbody/tr/td[1]")).getText();
				//System.out.println(wd.findElement(By.xpath("//service-kits-table/table/tbody/tr[1]/td[1]")).getText());
				String partNumber=wd.findElement(By.xpath("//service-kits-table/table/tbody/tr[1]/td[1]")).getText();
				//serviceScheduleVal.add(serviceintval);
				serviceScheduleVal.add(serviceintval+"-"+partNumber);
				wd.findElement(By.xpath("//button/span[text()='Close']")).click();
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		System.out.println("serviceScheduleVal >> "+serviceScheduleVal);
		}
		
	//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void waitMethod(EventFiringWebDriver wd,WebElement ele){
        WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 250);
        waitForFirstOrgLink.until(ExpectedConditions.visibilityOf(ele));
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
	
}