package com.doosan.nao.fleetManagements.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CodesTabPage {
	
	
	
	@FindBy(xpath="//input[@id='from']")
	WebElement fromdate;
	@FindBy(xpath="//input[@id='to']")
	WebElement todate;
	@FindBy(xpath="//span[text()='Export']")
	WebElement export;
	
	public void fileds(EventFiringWebDriver wd){
		try {
			highlightMyElement(severityDropdown, 3, wd);
			Thread.sleep(2000);
			highlightMyElement(controllerDropdown, 3, wd);
			Thread.sleep(2000);
			highlightMyElement(fromdate, 3, wd);
			Thread.sleep(2000);
			highlightMyElement(todate, 3, wd);
			Thread.sleep(2000);
			highlightMyElement(export, 3, wd);
			
			} catch (Exception e) {
			
				e.printStackTrace();
			}
	}
	@FindBy(xpath="//a/uib-tab-heading/span[text()='Codes']")
	WebElement codesTab;
	@FindBy(xpath="//th/span[text()='Invoice Date']")
	WebElement admintabinfo;
	public void checkCodesTabAvailability(EventFiringWebDriver wd){
		waitMethod(wd, admintabinfo);
		boolean flag=false;
		flag=codesTab.isDisplayed();
		Assert.assertEquals(flag, true);
	}
	public void clickCodesTab(EventFiringWebDriver wd){
		try {
			highlightMyElement(codesTab, 3, wd);
			codesTab.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		} catch (IOException e) {
			
		}
		
	}
	@FindBy(xpath="//select[@st-search='severity']")
	WebElement severityDropdown;
	List<String> severityOptVal =new ArrayList<String>();
	public void checkSeverityDropDown(EventFiringWebDriver wd){
		try {
			highlightMyElement(severityDropdown, 3, wd);
			
		} catch (Exception e) {
			System.out.println("In Codes tab Severit drop down not availabe");
		}
		severityDropdown.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Select sele=new Select(severityDropdown);
		List<WebElement>severityoptions =sele.getOptions();
		for (int i=1;i<=severityoptions.size()-1;i++) {
			//webElement.getText();
			severityOptVal.add(severityoptions.get(i).getText());
			
		}
		System.out.println(severityOptVal);
	}
	
	
	@FindBy(xpath="//select[@st-search='controller']")
	WebElement controllerDropdown;
	List<String> controllerOptVal =new ArrayList<String>();
	public void checkcontrollerDropDown(EventFiringWebDriver wd){
		try {
			highlightMyElement(controllerDropdown, 3, wd);
			controllerDropdown.click();
			Thread.sleep(3000);
			
		} catch (Exception e) {
			System.out.println("in Codes Controller dropdown not availabe");
		}
		Select sele=new Select(controllerDropdown);
		List<WebElement>controlleroptions =sele.getOptions();
		for (int i=1;i<=controlleroptions.size()-1;i++) {
			//webElement.getText();
			controllerOptVal.add(controlleroptions.get(i).getText());
			
		}
		System.out.println(controllerOptVal);
	}
	
	@FindBy(xpath="//table[@st-table='$ctrl.faultCodes']/tbody")
	WebElement tableFaultCode;

	List<WebElement> FaultCode;
	List<WebElement>row;
	List<WebElement>cols;
	List<String>codeSeverity=new ArrayList<String>();
	List<String>cSeverity=new ArrayList<String>();
	List<String> staus=new ArrayList<String>();
	boolean f=false;
	public void checkCriticalCodesSeverityEachOption(EventFiringWebDriver wd){
		Select sele=new Select(severityDropdown);
		for(int i=0;i<severityOptVal.size();i++){
		sele.selectByVisibleText(severityOptVal.get(i));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		String fcode ="//table[@st-table='$ctrl.faultCodes']/tbody/tr/td[text()='"+severityOptVal.get(i)+"']";
		String fscode ="//table[@st-table='$ctrl.faultCodes']/tbody/tr[@class='ng-scope']/td[2]";
		List<WebElement> stat=wd.findElements(By.xpath("//table[@st-table='$ctrl.faultCodes']/tbody/tr[@class='ng-scope']/td[8]"));
		if(!wd.findElements(By.xpath(fcode)).isEmpty()){
		FaultCode=wd.findElements(By.xpath(fcode));
		row=wd.findElements(By.xpath(fcode));
		codeSeverity=new ArrayList<String>();
		cSeverity=new ArrayList<String>();
		staus=new ArrayList<String>();
		for (int j = 0; j < FaultCode.size(); j++) {
			codeSeverity.add(FaultCode.get(j).getText());
			cSeverity.add(row.get(j).getText());
			System.out.println();
			staus.add(stat.get(j).getText());
			}
		f=new HashSet<String>(codeSeverity).size()<=1;
		
		System.out.println("Completed "+severityOptVal.get(i) + " Codes> > >"+cSeverity  +" Status >> "+staus);
		System.out.println("Severity "+f);
		Assert.assertEquals(f, true);
		}else{
		System.out.println(wd.findElement(By.xpath("//table[@st-table='$ctrl.faultCodes']/tbody/tr/td/span")).getText());
		Assert.assertEquals(wd.findElement(By.xpath("//table[@st-table='$ctrl.faultCodes']/tbody/tr/td/span")).getText(), "Fault codes list is empty");
		}
		
	}
		
		
	
	
	}
	List<WebElement> cFaultCode;
	List<String>controller=new ArrayList<String>();
	//boolean f=false;
	public void checkCriticalCodesControllerEachOption(EventFiringWebDriver wd){
		Select sele=new Select(controllerDropdown);
		for(int i=0;i<controllerOptVal.size();i++){
		sele.selectByVisibleText(controllerOptVal.get(i));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		String fcode ="//table[@st-table='$ctrl.faultCodes']/tbody/tr[@class='ng-scope']/td[2]";
		if(!wd.findElements(By.xpath(fcode)).isEmpty()){
			cFaultCode=wd.findElements(By.xpath(fcode));
		controller=new ArrayList<String>();
		for (int j = 0; j < cFaultCode.size(); j++) {
			controller.add(cFaultCode.get(j).getText());
			}
		//f=new HashSet<String>(controller).size()<=1;
		
		System.out.println("Severity Controller Codes "+controller);
		//System.out.println("Severity "+f);
		//Assert.assertEquals(f, true);
		}else{
		System.out.println(wd.findElement(By.xpath("//table[@st-table='$ctrl.faultCodes']/tbody/tr/td/span")).getText());
		Assert.assertEquals(wd.findElement(By.xpath("//table[@st-table='$ctrl.faultCodes']/tbody/tr/td/span")).getText(), "Fault codes list is empty");
		}
		
	}
		
		
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void waitMethod(EventFiringWebDriver wd,WebElement ele){
        WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 200);
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
