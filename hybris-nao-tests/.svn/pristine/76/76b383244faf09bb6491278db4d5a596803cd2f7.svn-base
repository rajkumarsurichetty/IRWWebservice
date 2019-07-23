package com.doosan.nao.classOrderTest;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.input.InputReader;
import com.doosan.nao.reports.ReportGenerator;

public class ClassZeroOrderValidator extends TestInitializer  {
	public String currentBrowser;

	public EventFiringWebDriver wd=null;
	private String localTestData;

 	//String brand="Bobcat";
	//String customerNo="0001225771";
	//String itemNo="7168039";
	
	//String brand="Doosan";
	//String customerNo="0001166428";
//	String itemNo="91V1165";
	
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@BeforeMethod
	public void setUpForClassZeroOrderValidatorTest(String browser, String browserVersion, String platform, String osVersion ) throws IOException, URISyntaxException, InterruptedException
	{	
		if(wd==null){

		wd=WebdriverSelector.getDriver(wd, browser);
		currentBrowser=browser;
		initialize(browser, browserVersion, platform, osVersion);
		
			wd.get(PROJECT.getProperty("DoosanPassportURL"));
		
		
		}

	}
	
	@Test(dataProvider="ClassZeroOrderValidator")
	public void ValidateClassZeroOrderValidatorTest(String testData,String userName,String password, String brand, String custNo, String itemNo, String qty, String binLocation, String comments, String testUrlName) throws IOException, URISyntaxException, InterruptedException
	{

		localTestData=testData;
ReportGenerator.setLog("ClassZeroOrderValidator is intitated with input likes :"+ "  brand :>> "+brand+"   Customer No :>> "+custNo+"  item No :>> "+itemNo+"  Order Class :>> "+" Browser :>>"+currentBrowser+" Current Url :>>"+testUrlName);

if(wd.getTitle().equals("Passport Login"))
{

	getWebElement(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH,wd).sendKeys(userName.toString());
	getWebElement(Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH,wd).sendKeys(password.toString());
	getWebElement(Constants.LOGIN_PAGE_SUBMIT_BUTTON_X_PATH,wd).submit();
Thread.sleep(10000L);

}
		wd.navigate().to(PROJECT.getProperty("DoosanParts5URL"));
		if(wd.findElements(By.linkText("Change")).isEmpty())
		{
			System.err.println("No change");
		}
		if(!wd.findElements(By.linkText("Change")).isEmpty())
		{
		wd.findElement(By.linkText("Change")).click();
		}		
		if(!custNo.equals("NA"))
		{
		WebDriverWait waitForSearchByDropdown=new WebDriverWait(wd, 30);
		waitForSearchByDropdown.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
		
		Select selectBrand=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
		selectBrand.selectByVisibleText("Brand");

		WebDriverWait waitForOrgSection=new WebDriverWait(wd, 30);
		waitForOrgSection.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		
		
		Select selectBrandByInput=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		selectBrandByInput.selectByVisibleText(brand.trim());
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys(custNo.trim());
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
		

		if(wd.getTitle().contains("Certificate Error"))
		{
			wd.navigate().to("javascript:document.getElementById('overridelink').click()");
			wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys(custNo.trim());
			wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
			
		}

		
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 180);
		waitForFirstOrgLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));
		handlingUntrustuedSiteErrorForIE();
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")).click();
		handlingUntrustuedSiteErrorForIE();
		WebDriverWait waitForQuickOrderLink=new WebDriverWait(wd, 30);
		waitForQuickOrderLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[1]/div/ul/li[4]/a")));
		}
		wd.findElement(By.xpath("html/body/div[2]/div[1]/div/ul/li[4]/a")).click();
		handlingUntrustuedSiteErrorForIE();
		
		if (itemNo==null||itemNo==""||itemNo.isEmpty())
		{
			itemNo="65.09100-7080A";
			System.out.println("Current item is :"+itemNo);
		}
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[1]/table/tbody/tr[1]/td[3]/input")).sendKeys(itemNo);
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[1]/table/tbody/tr[1]/td[4]/input")).sendKeys(qty);
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[1]/table/tbody/tr[1]/td[5]/input")).sendKeys(binLocation);
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[1]/table/tbody/tr[1]/td[6]/input")).sendKeys(comments);
		
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[3]/div[2]/a[2]")).click();
		handlingUntrustuedSiteErrorForIE();
		WebDriverWait waitForOrderClassDropdown=new WebDriverWait(wd, 120);
		waitForOrderClassDropdown.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div/select")));
		
		Select selectOrderClass=new Select(wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div/select")));
		//selectOrderClass.selectByVisibleText(orderClass.toString());
		selectOrderClass.selectByIndex(1);
		
		WebDriverWait waitForSelectAllCheckBox=new WebDriverWait(wd, 120);
		
		waitForSelectAllCheckBox.until(ExpectedConditions.presenceOfElementLocated(By.id("checkAll")));
	
		wd.findElement(By.id("checkAll")).click();
		handlingUntrustuedSiteErrorForIE();
		wd.findElement(By.id("entries[0].selected")).click();
	
		
		try {
		wd.findElement(By.id("remove-all")).click();
		System.err.println("i have cliked remove all");
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		//wd.findElement(By.xpath("html/body/div[2]/div[4]/div[4]/div[2]/form/div/span/input")).click();
		WebDriverWait waitForCheckoutButton=new WebDriverWait(wd, 30);
		waitForCheckoutButton.until(ExpectedConditions.elementToBeClickable(By.id("top_checkout_btn")));
		
		try {
			if (!wd.findElement(By.id("top_bulletins_btn")).isSelected())
			{
		wd.findElement(By.id("top_bulletins_btn")).click();
		handlingUntrustuedSiteErrorForIE();
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}				 
				wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div/span/input")).click();
				handlingUntrustuedSiteErrorForIE();
		WebDriverWait waitForPurchaseOrderInput=new WebDriverWait(wd, 120);
		waitForPurchaseOrderInput.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[2]/span[2]/input")));
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[2]/span[2]/input")).clear();
		PurchaseOrderGenerator randomNumberGenerator=new PurchaseOrderGenerator();
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[2]/span[2]/input")).sendKeys(randomNumberGenerator.generatePurchareOrder());

		Select selectShipCompleOption=new Select(wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[4]/span[2]/select")));
		selectShipCompleOption.selectByVisibleText("No");
		
		Select selectModeOption=new Select(wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[5]/div[2]/span[2]/select")));
		selectModeOption.selectByVisibleText("Truck");
		
		Select selectCarrierOption=new Select(wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[5]/div[3]/span[2]/select")));
		selectCarrierOption.selectByVisibleText("UPS - United Parcel Service");
		
		Select selectPriorityOption=new Select(wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[5]/div[4]/span[2]/select")));
		selectPriorityOption.selectByVisibleText("Not specified");
		
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[5]/div[3]/div[2]/textarea")).sendKeys("Testing");
		
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[7]/div[2]/div[2]/div[2]/textarea")).sendKeys("Test@mail.com");
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[8]/div[1]/span/button")).click();
		handlingUntrustuedSiteErrorForIE();
		WebDriverWait waitForTermsAndConditionsCheckBox=new WebDriverWait(wd, 120);
		waitForTermsAndConditionsCheckBox.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/form/nav[1]/ul/li[3]/label/input")));
		wd.findElement(By.xpath("html/body/div[2]/div[2]/form/nav[1]/ul/li[3]/label/input")).click();
		ReportGenerator.setLog("ClassZeroOrderValidator is sucessfully completed with input likes :"+ "  brand :>> "+brand+"   Customer No :>> "+custNo+"  item No :>> "+itemNo+"  Order Class :>> "+" Browser :>>"+currentBrowser);		
		wd.findElement(By.xpath("html/body/div[2]/div[2]/form/nav[1]/ul/li[1]/button")).click();
		//TestInitializer.isBrowserAlive="A";		
	}


	@AfterMethod()
	public void onTestFailure(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			System.out.println("ClassZeroOrderValidator pass");
			ReportGenerator.setLogAndCreateScreenshot("ClassZeroOrderValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			
		} else 
		{
			

			System.out.println("ClassZeroOrderValidator Fail");
			ReportGenerator.setLogAndCreateScreenshot("ClassZeroOrderValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			wd.get(PROJECT.getProperty("DoosanParts5URL"));			
		}
	}
	
	@DataProvider(name="ClassZeroOrderValidator")
	public static Object[][] getDataForShipments() throws InterruptedException
	{
		//TestInitializer.isBrowserAlive="N";
		return InputReader.getInputReader().getDataFromXLS("ClassZeroOrderValidator");
		
	}
	
	
	public  void handlingUntrustuedSiteErrorForIE()
	{
		if(wd.getTitle().contains("Certificate Error"))
		{
			wd.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
	}

	
}
