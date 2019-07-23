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

public class ClassFourOrderValidator extends TestInitializer  {
	public EventFiringWebDriver wd=null;
	private String localTestData;
	public String currentBrowser=null;
 	//String brand="Bobcat";
	//String customerNo="0001225771";
	//String itemNo="7168039";
	
	//String brand="Doosan";
	//String customerNo="0001166428";
//	String itemNo="91V1165";
	
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@BeforeMethod
	public void setUpForClassFourOrderValidatorTest(String browser, String browserVersion, String platform, String osVersion) throws IOException, URISyntaxException, InterruptedException
	{	
		if(wd==null)		
		{
		wd=WebdriverSelector.getDriver(wd, browser);
		currentBrowser=browser;
		initialize(browser, browserVersion, platform, osVersion);
		
			wd.get(PROJECT.getProperty("DoosanPassportURL"));
		
		}
		

	}
	
	@Test(dataProvider="ClassFourOrderValidator")
	public void ValidateClassFourOrderValidatorTest(String testData,String userName,String password, String brand, String custNo, String itemNo, String qty, String binLocation, String comments, String testUrlName) throws IOException, URISyntaxException, InterruptedException
	{
		localTestData=testData;
		ReportGenerator.setLog("ClassFourOrderValidator is initated with input likes :"+ "  brand :>> "+brand+"   Customer No :>> "+custNo+"  item No :>> "+itemNo+"  Order Class :>> "+" Browser :>>"+currentBrowser+" Current Url :>>"+testUrlName);

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
		System.out.println("cheking completed >>>>>>>>>>>>>>>>>>>>");
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

		WebDriverWait waitForOrgSection=new WebDriverWait(wd, 120);
		waitForOrgSection.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		
		
		Select selectBrandByInput=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		selectBrandByInput.selectByVisibleText(brand.trim());
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys(custNo.trim());
		handlingUntrustuedSiteErrorForIE();
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();

		if(wd.getTitle().contains("Certificate Error"))
		{
			wd.navigate().to("javascript:document.getElementById('overridelink').click()");
			wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys(custNo.trim());
			wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
			
		}

		
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 180);
		waitForFirstOrgLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));

		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")).click();
		handlingUntrustuedSiteErrorForIE();
		WebDriverWait waitForQuickOrderLink=new WebDriverWait(wd, 30);
		waitForQuickOrderLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[1]/div/ul/li[4]/a")));
		}
		
		wd.findElement(By.xpath("html/body/div[2]/div[1]/div/ul/li[4]/a")).click();
		handlingUntrustuedSiteErrorForIE();

		validateClassFourOrderValidate(itemNo, qty, binLocation, comments);
		
		try {
			if(wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]")).isDisplayed())
			{
				System.out.println("Cart is empty");
				validateClassFourOrderValidate(itemNo, qty, binLocation, comments);
			} else 
			{
				System.out.println("Cart is not emptyy");
			}
		} catch (Throwable t)
		{
			System.out.println("cart empty check catch");
		}

		
		handlingUntrustuedSiteErrorForIE();
		WebDriverWait waitForPurchaseOrderInput=new WebDriverWait(wd, 120);
		waitForPurchaseOrderInput.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[2]/span[2]/input")));
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[2]/span[2]/input")).clear();
		PurchaseOrderGenerator randomNumberGenerator=new PurchaseOrderGenerator();
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[2]/span[2]/input")).sendKeys(randomNumberGenerator.generatePurchareOrder());

		//Select selectShipCompleOption=new Select(wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[4]/span[2]/select")));
		//selectShipCompleOption.selectByVisibleText("No".trim());
		
		//Select selectModeOption=new Select(wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[5]/div[2]/span[2]/select")));
		//selectModeOption.selectByVisibleText("Truck".trim());
		//selectModeOption.selectByIndex(1);
		
		//Select selectCarrierOption=new Select(wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[5]/div[3]/span[2]/select")));
		//selectCarrierOption.selectByVisibleText("Roadrunner Dawes".trim());
		//selectCarrierOption.selectByIndex(1);
		
		//Select selectPriorityOption=new Select(wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[5]/div[4]/span[2]/select")));
		//selectPriorityOption.selectByVisibleText("Not specified".trim());
		//selectPriorityOption.selectByIndex(1);
		
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[5]/div[3]/div[2]/textarea")).sendKeys("Testing");
		
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[7]/div[2]/div[2]/div[2]/textarea")).sendKeys("Test@mail.com");
		wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[8]/div[1]/span/button")).click();
		handlingUntrustuedSiteErrorForIE();
		WebDriverWait waitForTermsAndConditionsCheckBox=new WebDriverWait(wd, 120);		waitForTermsAndConditionsCheckBox.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/form/nav[1]/ul/li[3]/label/input")));
		wd.findElement(By.xpath("html/body/div[2]/div[2]/form/nav[1]/ul/li[3]/label/input")).click();
		ReportGenerator.setLog("ClassFourOrderValidator is sucessfully completd with input likes :"+ "  brand :>> "+brand+"   Customer No :>> "+custNo+"  item No :>> "+itemNo+"  Order Class :>> "+" Browser :>>"+currentBrowser);		

		wd.findElement(By.xpath("html/body/div[2]/div[2]/form/nav[1]/ul/li[1]/button")).click();

	//	TestInitializer.isBrowserAlive="A";
		ReportGenerator.setLogAndCreateScreenshot("ClassFourOrderValidator", "ValidateClassFourOrder", testData, "pass", wd);
		}

	@AfterMethod()
	public void onTestFailure(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			System.out.println("ClassFourOrderValidator pass");
			ReportGenerator.setLogAndCreateScreenshot("ClassFourOrderValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
		} else 
		{

			System.out.println("ClassFourOrderValidator Fail");
			ReportGenerator.setLogAndCreateScreenshot("ClassFourOrderValidator", Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			wd.get(PROJECT.getProperty("DoosanParts5URL"));	
		}
	}

	@DataProvider(name="ClassFourOrderValidator")
	public static Object[][] getDataForShipments() throws InterruptedException
	{
//		TestInitializer.isBrowserAlive="N";
		return InputReader.getInputReader().getDataFromXLS("ClassFourOrderValidator");
		
	}
	
	
	public  void handlingUntrustuedSiteErrorForIE()
	{
		if(wd.getTitle().contains("Certificate Error"))
		{
			wd.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
	}

	public void validateClassFourOrderValidate(String itemNo, String qty, String binLocation, String comments)
	{
		wd.findElement(By.xpath("html/body/div[2]/div[1]/div/ul/li[4]/a")).click();
		handlingUntrustuedSiteErrorForIE();
		if (itemNo==null||itemNo==""||itemNo.isEmpty())
		{
			itemNo="021-00014HEF";
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
		//selectOrderClass.selectByVisibleText(orderClass.toString().trim());
		selectOrderClass.selectByIndex(5);
		
		WebDriverWait waitForSelectAllCheckBox=new WebDriverWait(wd, 120);
		waitForSelectAllCheckBox.until(ExpectedConditions.elementToBeClickable(By.id("checkAll")));
		
		wd.findElement(By.id("checkAll")).click();
		wd.findElement(By.id("entries[0].selected")).click();
	
		
		try {
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[2]/a[1]")).click();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	
		

		WebDriverWait waitForCheckoutButton=new WebDriverWait(wd, 120);
		waitForCheckoutButton.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div/span/input")));
		
		try {
			if (!wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[2]/span/input")).isSelected())
			{
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[2]/span/input")).click();
		handlingUntrustuedSiteErrorForIE();
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		 
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div/span/input")).click();
	}
}
