package com.doosan.nao.fleetManagements.page;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



import org.openqa.selenium.By;
//import org.apache.bcel.generic.GETSTATIC;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlanMaintenancePage {
	
	@FindBy(xpath="//input[@ng-click='$ctrl.editPlannedMaintenance($ctrl.machine.key, $ctrl.plannedMaintenance)']")
	WebElement planmagementEditICON;
	public void checkplanMainTenanceEditIcon(){
		boolean flag;
		try {
		flag=planmagementEditICON.isDisplayed();
		Assert.assertEquals(flag, true);
		} catch (Exception e) {
			System.out.println(" Planmaintenace not dipaying");
		}
		
	}

	public void clickPlanMainTenanceEditIcon(EventFiringWebDriver wd){
		try {
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			wd.switchTo().defaultContent();
			jse.executeScript("scroll(0,-250);", "");
			jse.executeScript("scroll(0,950);", "");
			   // WebElement element = wd.findElement(By.linkText("Google.com.ph"));
			Thread.sleep(2000);
			wd.switchTo().frame(frameId);
			highlightMyElement(planmagementEditICON, 3, wd);
			planmagementEditICON.click();
			Thread.sleep(12000);
		} catch (Exception e) {
			
		}
	}
	@FindBy(xpath="//button[@ng-click='$ctrl.openPmEndDate($event)']")
	WebElement clickCalendarIcon;
	
	@FindBy(xpath="//button[text()='Clear']")
	WebElement clickCalendarClear;
	@FindBy(xpath="//button[text()='Today']")
	WebElement clickCalendarToday;
	@FindBy(xpath="//button[contains(@id,'datepicker')]")
	WebElement clickCalendarMonth;
	@FindBy(xpath="//button[contains(@id,'datepicker')]")
	WebElement clickCalendarYear;
	String selectyearStart="//button/span[text()='2018']";
	WebElement clickCalendarYearSelect;
	WebElement clickCalendarMonthSelect;
	WebElement clickCalendarDateNoSelect;
	String[]dtVal;
	public void selectYearFromCalender(EventFiringWebDriver wd){
		String dt=getFullTomorrowDate();
		dtVal=dt.split("-");
		clickCalendarYearSelect=wd.findElement(By.xpath("//button/span[text()='"+dtVal[2].trim()+"']"));
		
		
	}
	public void selectMonthfromCalnder(EventFiringWebDriver wd){
		clickCalendarMonthSelect=wd.findElement(By.xpath("//button/span[text()='"+dtVal[1].trim()+"']"));
	}
	public void selectDatefromCalnder(EventFiringWebDriver wd){
		clickCalendarDateNoSelect=wd.findElement(By.xpath("//button/span[text()='"+dtVal[0].trim()+"']"));
	}
	
	
	@FindBy(how=How.ID,using="fleetmanagementApp")
	public WebElement frameId;
	@FindBy(id="pmEndDate")
	WebElement PMENDdate;
	public void clickPlanMaintenanceENDDateTomorrow(EventFiringWebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
	
		wd.switchTo().frame(frameId);
		WebDriverWait wait=new WebDriverWait(wd, 120);
		wait.until(ExpectedConditions.elementToBeClickable(PMENDdate));
		clickCalendarIcon.click();
		clickCalendarClear.click();
		//PMENDdate.clear();
		//String dt=getTomorrowDate();
		String dt=getFullTomorrowDate();
		dtVal=dt.split("-");
		clickCalendarIcon.click();//clicking calendar icon from popup
		clickCalendarMonth.click();//month on top of the calendar tab
		clickCalendarYear.click();//year on top of the calendar tab
		clickCalendarYearSelect=wd.findElement(By.xpath("//button/span[text()='"+dtVal[2].trim()+"']"));
		clickCalendarYearSelect.click();
		clickCalendarMonthSelect=wd.findElement(By.xpath("//button/span[text()='"+dtVal[1].trim()+"']"));
		clickCalendarMonthSelect.click();
		clickCalendarDateNoSelect=wd.findElement(By.xpath("//button/span[@class='ng-binding' and text()='"+dtVal[0].trim()+"']"));
		clickCalendarDateNoSelect.click();
		/*jse.executeScript("arguments[1].value = arguments[0]; ", dt,PMENDdate );
		//jse.executeScript("document.getElementById('pmEndDate').value='"+dt+"'");
		wd.switchTo().defaultContent();
		wd.switchTo().frame(frameId);*/
		//PMENDdate.sendKeys(dt,Keys.ENTER);
		
	}
	public void clickPlanMaintenanceExpiredPastDate(EventFiringWebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		//jse.executeScript("scroll(0,450);", "");
		   // WebElement element = wd.findElement(By.linkText("Google.com.ph"));
		wd.switchTo().frame(frameId);
		wd.findElement(By.xpath("//button[@ng-click='$ctrl.openPmEndDate($event)']")).click();
		wd.findElement(By.xpath("//button[@ng-click='select(null, $event)']")).click();
		//jse.executeScript("document.getElementById('pmEndDate').value=''");
		//PMENDdate.clear();
		clickCalendarIcon.click();
		clickCalendarClear.click();
		String dt=getFullYesterdayDate();
		dtVal=dt.split("-");
		clickCalendarIcon.click();//clicking calendar icon from popup
		clickCalendarMonth.click();//month on top of the calendar tab
		clickCalendarYear.click();//year on top of the calendar tab
		clickCalendarYearSelect=wd.findElement(By.xpath("//button/span[contains(@class,'ng-binding') and text()='"+dtVal[2].trim()+"']"));
		clickCalendarYearSelect.click();
		clickCalendarMonthSelect=wd.findElement(By.xpath("//button/span[contains(@class,'ng-binding') and text()='"+dtVal[1].trim()+"']"));
		clickCalendarMonthSelect.click();
		/*int dts=Integer.parseInt(dtVal[0])-2;
		dtVal[0]=String.valueOf(dts);*/
		//String dts=
		clickCalendarDateNoSelect=wd.findElement(By.xpath("//button/span[@class='ng-binding' and text()='"+dtVal[0].trim()+"']"));
		clickCalendarDateNoSelect.click();
		/*//jse.executeScript("document.getElementById('pmEndDate').value='"+dt+"'");
		jse.executeScript("arguments[1].value = arguments[0]; ", dt,PMENDdate );
		wd.switchTo().defaultContent();
		wd.switchTo().frame(frameId);
		//PMENDdate.sendKeys(dt,Keys.ENTER);
*/		
	}
	
	String operatingHrs;
	int operatHrs;
	@FindBy(xpath="//th[text()='Operating Hours']/following::td/property-value/span")
	WebElement operatinhrs;
	public void getOperationHours(){
		operatingHrs=operatinhrs.getText();
		operatHrs=Integer.parseInt(operatingHrs);
	}
	public void clearOperatinghrs(){
		PMEndHours.clear();
	}
	public void clearPmDate(EventFiringWebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		jse.executeScript("scroll(0,550);", "");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		//jse.executeScript("scroll(0,450);", "");
		   // WebElement element = wd.findElement(By.linkText("Google.com.ph"));
		wd.switchTo().frame(frameId);
		try {
			WebDriverWait wait=new WebDriverWait(wd, 120);
			wait.until(ExpectedConditions.elementToBeClickable(PMENDdate));
			Thread.sleep(3000);
			highlightMyElement(PMENDdate, 3, wd);
		} catch (Exception e) {
			
		}
		PMENDdate.click();
		wd.findElement(By.xpath("//button[@ng-click='$ctrl.openPmEndDate($event)']")).click();
		wd.findElement(By.xpath("//button[@ng-click='select(null, $event)']")).click();
		//PMENDdate.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		//PMENDdate.clear();
	}
	
	
	
	@FindBy(xpath="//th/span[text()='PM Status']/following::td")
	public WebElement pmStatus;
	String PmStatus;
	public String getPMStatus(EventFiringWebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,950);", "");
		wd.switchTo().frame(frameId);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		//new WebDriverWait(wd, 200).until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@class='edit-button']")));
		return PmStatus=pmStatus.getText();
	}
	boolean flag;
	public void verifytheStatusNone(EventFiringWebDriver wd){
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			//new WebDriverWait(wd, 200).until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@class='edit-button']")));
		}//new WebDriverWait(wd, 200).until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@class='edit-button']")));
		String status=getPMStatus(wd);
		if(status.trim().equalsIgnoreCase("NONE")){
			flag=true;
		}
		Assert.assertEquals(flag, true);
	}
	
	public void verifytheStatusActiveBytomorrowdate(EventFiringWebDriver wd){
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			
		}//new WebDriverWait(wd, 200).until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@class='edit-button']")));
		String status=getPMStatus(wd);
		if(status.trim().equals("ACTIVE")){
			flag=true;
		}
		Assert.assertEquals(flag, true);
	}
	public void verifytheStatusExpitrdByYesterdayDate(EventFiringWebDriver wd){
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			
		}//new WebDriverWait(wd, 200).until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@class='edit-button']")));
		String status=getPMStatus(wd);
		if(status.trim().equalsIgnoreCase("EXPIRED")){
			flag=true;
		}
		Assert.assertEquals(flag, true);
	}
	String afterUpDateOperatinghrs;
	@FindBy(id="pmEndHours")
	WebElement PMEndHours;
	public void enterPMEndHours(){
		//pmEndHours
		operatHrs=operatHrs+1;
		afterUpDateOperatinghrs=String.valueOf(operatHrs);
		PMEndHours.sendKeys(afterUpDateOperatinghrs);
	}
	@FindBy(id="pmComments")
	WebElement PMComments;
	String newEnterComment;
	public void enterPMComments(EventFiringWebDriver wd){
		//PMComments
		 DateFormat sdf;
			sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			// System.out.println(sdf.format(date));
			String da = sdf.format(date);
			newEnterComment="AutoTestPMComments Added on :"+da.replaceAll("[/,:]", "").replace(" ", "");
			try {
				highlightMyElement(PMComments, 3, wd);
			} catch (IOException e) {}		
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			wd.switchTo().defaultContent();
			jse.executeScript("scroll(0,-250);", "");
			jse.executeScript("scroll(0,450);", "");
			wd.switchTo().frame(frameId);
		PMComments.sendKeys(newEnterComment);
		
	}
	@FindBy(xpath="//button[@ng-click='$ctrl.onSave()']")
	WebElement savePmpopup;
	public void clickSaveOnPMPopup(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		savePmpopup.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//span[text()='Cancel']")
	WebElement cancelPmpopup;
	public void clickCancelOnPMPopup(EventFiringWebDriver wd){
		//cancelPmpopup
		try {
			Thread.sleep(3000);
			highlightMyElement(PMComments, 3, wd);
		} catch (Exception e) {}	
		cancelPmpopup.click();
	}
	@FindBy(xpath="//span[text()='PM End Date']/following::td[1]")
	WebElement getdateText;
	public void getDateafterUpdate(){
		//cancelPmpopup
		
		String afterUpdateDate=getdateText.getText();
		System.out.println("After updated date "+afterUpdateDate);
	}
	@FindBy(xpath="//span[text()='PM Status']/following::td[1]")
	WebElement getPMstatusText;
	public void getPMStatusfterUpdate(){
		//cancelPmpopup
		
		String afterUpdateStatus=getPMstatusText.getText();
		System.out.println("After updated PMStatus "+afterUpdateStatus);
	}
	@FindBy(id="pmEndDate")
	WebElement dateEnetrFiledTxt;
	public void getDateFromPopup(){
		dateEnetrFiledTxt.getAttribute("value");
		System.out.println(dateEnetrFiledTxt.getAttribute("value"));
		System.out.println(dateEnetrFiledTxt.getText());
	}
	
	@FindBy(xpath="//button[text()='Clear']")
	WebElement clearPopupDate;
	public void clickClearPoupDate(){
		clearPopupDate.click();
	}
	
	
	
	
	
	
	
	public String getTomorrowDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MMM-yyyy" );
		Calendar cal=Calendar.getInstance();
		Date dat=cal.getTime();
		System.out.println(dat);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date tm=cal.getTime();
		System.out.println(tm);
		System.out.println(dateFormat.format(tm));
		return dateFormat.format(tm);
		
		
	}
	
public String getYesterdayDate(){
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MMM-yyyy" );
	Calendar cal=Calendar.getInstance();
		Date dat=cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Date tm1=cal.getTime();
		System.out.println(tm1);
		System.out.println(dateFormat.format(tm1));
		return dateFormat.format(tm1);
	}
	
public String getFullTomorrowDate(){
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MMMM-yyyy" );
	Calendar cal=Calendar.getInstance();
	Date dat=cal.getTime();
	System.out.println(dat);
	cal.add(Calendar.DAY_OF_YEAR, 1);
	Date tm=cal.getTime();
	System.out.println(tm);
	System.out.println(dateFormat.format(tm));
	return dateFormat.format(tm);
	
	
}

public String getFullYesterdayDate(){
SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MMMM-yyyy" );
Calendar cal=Calendar.getInstance();
	Date dat=cal.getTime();
	cal.add(Calendar.DAY_OF_YEAR, -1);
	Date tm1=cal.getTime();
	System.out.println(tm1);
	System.out.println(dateFormat.format(tm1));
	return dateFormat.format(tm1);
}
	
	

/*****************************Operating hours EndHours******************************/
float opehrs; 
	@FindBy(xpath="//th/span[text()='Operating Hours']/parent::th/following-sibling::td/property-value")
	WebElement operatingHours;
	public float getOperatingHours(EventFiringWebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		String Ophr=operatingHours.getText();
		
		String[] oph=Ophr.split(" ");
		System.out.println("Operating Hours is = " +oph[0]);
		
		float opehs=Float.parseFloat(oph[0]);
		System.out.println(" Integer value of OpHrs = " +opehs);
		//opehrs=opehs;
		return opehs;
	}
	
	public void enterOperatinHoursMoreThanOPeratingHrs(EventFiringWebDriver wd){
		float opehrs=getOperatingHours(wd);
		int opehrsint=(int)opehrs+2;
		String oph=String.valueOf(opehrsint);
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		PMEndHours.clear();
		try {
			highlightMyElement(PMEndHours, 3, wd);
		} catch (IOException e) {
			
		}
		PMEndHours.sendKeys(oph,Keys.ENTER);
	
		
			}
	
	public void enterOperatinHoursCurrentVal(EventFiringWebDriver wd){
		float opehrs=getOperatingHours(wd);
		int opehrsint=(int)opehrs;
		String oph=String.valueOf(opehrsint);
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		PMEndHours.clear();
		try {
			highlightMyElement(PMEndHours, 3, wd);
		} catch (IOException e) {
			
		}
		PMEndHours.sendKeys(oph,Keys.ENTER);
	
		
			}
	
	public void checkStatusActiveByMoreOperatinghrs(EventFiringWebDriver wd){
		String status=getPMStatus(wd);
		boolean flag = false;
		if(status.trim().equalsIgnoreCase("ACTIVE")){ flag=true;}
		Assert.assertEquals(flag, true);
		
	}
	
	public void enterOperatinHoursLessThanOPeratingHrs(EventFiringWebDriver wd){
		float opehrs=getOperatingHours(wd);
		if(opehrs<1){
			double opehrsint=opehrs-0.1;
			String oph=String.valueOf(opehrsint);
			try{highlightMyElement(PMEndHours, 3, wd);
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			wd.switchTo().defaultContent();
			jse.executeScript("scroll(0,-250);", "");
			jse.executeScript("scroll(0,450);", "");
			wd.switchTo().frame(frameId);
			PMEndHours.clear();
			try {
				highlightMyElement(PMEndHours, 3, wd);
			} catch (IOException e) {
				
			}
			PMEndHours.sendKeys(oph,Keys.ENTER);
			}catch(Exception e){
				
			}
		}else{
		int opehrsint=(int)opehrs-2;
		String oph=String.valueOf(opehrsint);
		try{highlightMyElement(PMEndHours, 3, wd);
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		PMEndHours.clear();
		try {
			highlightMyElement(PMEndHours, 3, wd);
		} catch (IOException e) {
			
		}
		PMEndHours.sendKeys(oph,Keys.ENTER);
		}catch(Exception e){
			
		}
		
		}
	}
	public void enterOperatinHoursASZeroHrs(EventFiringWebDriver wd){
		
		try{highlightMyElement(PMEndHours, 3, wd);
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		PMEndHours.clear();
		try {
			highlightMyElement(PMEndHours, 3, wd);
		} catch (IOException e) {
			
		}
		PMEndHours.sendKeys("0",Keys.ENTER);
		Thread.sleep(4000);
		}catch(Exception e){
			
		}
		
		
	}
	@FindBy(xpath="//div[@class='modal-header']/following::div[@class='modal-body']/div/div/p")
	WebElement errormessage;
	public void checkErrorMessage(EventFiringWebDriver wd){
		boolean flag = false;
		try {
			highlightMyElement(errormessage, 3, wd);
		} catch (IOException e) {
			
		}
		WebDriverWait wait=new WebDriverWait(wd, 100);
		wait.until(ExpectedConditions.elementToBeClickable(errormessage));
		String mess=errormessage.getText();
		if(mess.trim().equals("Engine Hours cannot be zero. Enter a non-zero engine hour.")){
			flag=true;
		}
		Assert.assertEquals(flag, true);
	}
	@FindBy(xpath="//div[@class='modal-footer']/button[text()='OK']")
	WebElement okError;
	public void clickOKErrorMessage(EventFiringWebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		wd.switchTo().frame(frameId);
		try {
			highlightMyElement(okError, 3, wd);
		} catch (IOException e) {
			
		}
		okError.click();
	}
	public void checkStatusExpiryByMoreOperatinghrs(EventFiringWebDriver wd){
		String status=getPMStatus(wd);
		boolean flag = false;
		if(status.trim().equalsIgnoreCase("EXPIRED")){ flag=true;}
		Assert.assertEquals(flag, true);
		
	}
	
	
	@FindBy(xpath="//input[@ng-click='$ctrl.deletePlannedMaintenance($ctrl.machine.key)']")
	WebElement deletePMstatusIcon;
	public void clickDeletPMStatusICON(EventFiringWebDriver wd){
		
		try {
			highlightMyElement(deletePMstatusIcon, 3, wd);
			deletePMstatusIcon.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}
	}
	
	public void checkPMStatusAfterDeletePmStatus(EventFiringWebDriver wd){
		String status=getPMStatus(wd);
		boolean flag = false;
		if(status.trim().equalsIgnoreCase("NONE"))
		{ flag=true;}
		Assert.assertEquals(flag, true);
	}
	
	public String currentDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MMM-yyyy" );
		Calendar cal=Calendar.getInstance();
		Date dat=cal.getTime();
		System.out.println(dateFormat.format(dat));
		//String curDate=dateFormat.format(dat);
		return dateFormat.format(dat);
		
	}
	
	public void enterCurrentdate(EventFiringWebDriver wd){
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		   // WebElement element = wd.findElement(By.linkText("Google.com.ph"));
		wd.switchTo().frame(frameId);
		clickCalendarIcon.click();
		clickCalendarClear.click();
		//PMENDdate.clear();
		String dt=currentDate();
		clickCalendarIcon.click();
		clickCalendarToday.click();
		//PMENDdate.sendKeys(dt,Keys.ENTER);
	}
	
	/****************************************Powered by the hour**************************************************/
	@FindBy(xpath="//th/span[text()='Power by The Hour']")
	WebElement powerbytheHourlable;
	public boolean checkPowerBytheHourLabel(EventFiringWebDriver wd){
	return	powerbytheHourlable.isDisplayed();
		
	}
	
	@FindBy(xpath="//th/span[text()='Power by The Hour']/following::td/span")
	WebElement powerbytheHourStatus;
	public void checkPowerBytheHourStatus(EventFiringWebDriver wd){
		boolean f=checkPowerBytheHourLabel(wd);
		String status = null;
		if(f==true){
			status=powerbytheHourStatus.getText();
		}
		Assert.assertEquals(status, "YES");
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
