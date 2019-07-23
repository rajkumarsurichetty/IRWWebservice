package com.doosan.nao.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.input.InputReader;
import com.doosan.nao.reports.ReportGenerator;


public class MultipleItemTest implements Constants {
	
	public static boolean isBrowserEnabled=true;
	public static String browser;
	public WebDriver wd;
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	/**
	 * This method initializes the browser setting before running the test
	 * 
	 * @param browser
	 * @param browserVersion
	 * @param platform
	 * @param osVersion
	 * @throws IOException
	 */

	@BeforeTest
	public void initializeLoginTest(String browser, String browserVersion,
			String platform, String osVersion) throws IOException, URISyntaxException {
		System.out.println(browser+">>>>>>>>>>>>>>>");
		if (browser.equals("firefox"))
		{	
		TestInitializer
				.initialize(browser, browserVersion, platform, osVersion);
		wd=new FirefoxDriver();
		} else if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserSetUp\\chromedriver.exe");
			TestInitializer
			.initialize(browser, browserVersion, platform, osVersion);
	
			wd=new ChromeDriver();
		}
		
		wd.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test (dataProvider="MultipleItemTest")
	public void testMultipleItemForDiffrentCustomer(String testData,String UserName, String password, String dealerByCustomerNo, String itemNumber, String qty, String orderClass ) throws IOException, InterruptedException
	{
	
		try {
			System.out.println("i am enterd test of multiorder");
		Reporter.log("multiple item test is initated for the below inputs");
		Reporter.log("Customer No -"+ dealerByCustomerNo+" item Number "+ itemNumber+ "Order class"+ orderClass);
		
		
		if (isBrowserEnabled)
		{
		wd.get(TestInitializer.PROJECT.getProperty(Constants.DOOSAN_URL));
		getWebElement(LOGIN_PAGE_USERNAME_TEXT_X_PATH).sendKeys(UserName);
		getWebElement(LOGIN_PAGE_PASSWORD_TEXT_X_PATH).sendKeys(password);
		getWebElement(LOGIN_PAGE_SUBMIT_BUTTON_X_PATH).click();
		Thread.sleep(10000L);
		}
		wd.navigate().to(TestInitializer.PROJECT.getProperty("DoosanParts5URL"));
		
		
		
		if (!isBrowserEnabled)
		{
			System.out.println("i am browser !isBrowserEnabled");
		wd.findElement(By.linkText("Change")).click();	
		}
		WebDriverWait waitingForContainingBox=new WebDriverWait(wd, 30);
		
		waitingForContainingBox.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='search_val2']")));
		
		wd.findElement(By.xpath(".//*[@id='search_val2']")).sendKeys(dealerByCustomerNo.trim());
		
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
		
		WebDriverWait waitingForElementPresent1=new WebDriverWait(wd, 60);
		waitingForElementPresent1.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));
		getWebElement(HOME_PAGE_ORG_SELECT_ORG_LINK_X_PATH).click();
	
		getWebElement(QUICK_ORDER_LINK_CLICK_X_PATH).click();
		getWebElement(QUICK_ORDER_PART_NUMBER_TEXT_X_PATH).sendKeys(itemNumber.trim());
		getWebElement(QUICK_ORDER_QUANTITY_TEXT_X_PATH).sendKeys(qty);

		getWebElement(QUICK_ORDER_ADD_TO_CART_X_PATH).click();
		Thread.sleep(5000L);
	
		Thread.sleep(5000L);
		Select select=new Select(wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[1]/select")));
		select.selectByVisibleText(orderClass.trim());
		System.out.println(orderClass.trim());
		WebDriverWait waitingForElementPresent=new WebDriverWait(wd, 30);
		waitingForElementPresent.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[1]/span/input")));
				
				wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[3]/table/thead/tr/th[1]/input")).click();
				wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[3]/table/tbody/tr[1]/td[1]/input[1]")).click();

				if (wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[2]/a[1]")).isDisplayed())
				{
					wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[2]/a[1]")).click();
				}
				
				try {
				wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[2]/span/input")).click();
				} catch (Throwable t)
				{
					
				}
			
				
			    wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[1]/span/input")).click();
		
		
		
		if (orderClass.equals("Class 1 - Breakdown - Warranty") || orderClass.equals("Class 3 - Non-Emergency Breakdown") || orderClass.equals("Class 2 - Breakdown - Non-Warranty"))
		{
		wd.findElement(By.xpath(".//*[@id='purchaseOrderInput']")).clear();
		wd.findElement(By.xpath(".//*[@id='purchaseOrderInput']")).sendKeys(poNogeneration());
		
		wd.findElement(By.xpath(".//*[@id='shipComplete']")).sendKeys("No");

		Select mode=new Select(wd.findElement(By.xpath(".//*[@id='primaryShipmentMode']")));
		mode.selectByIndex(0);
		mode.selectByIndex(1);

		Select carrier=new Select(wd.findElement(By.xpath(".//*[@id='primaryShipmentCarrier']")));
		carrier.selectByIndex(0);
		carrier.selectByIndex(1);

		Select priority=new Select(wd.findElement(By.xpath(".//*[@id='primaryShipmentPriority']")));
		priority.selectByIndex(0);
		priority.selectByIndex(1);
		wd.findElement(By.xpath(".//*[@id='textarea_instructions']")).sendKeys(poNogeneration());
		wd.findElement(By.xpath(".//*[@id='buttonContinue']")).click();
		wd.findElement(By.xpath(".//*[@id='agreeCheckbox1']")).click();
		wd.findElement(By.xpath(".//*[@id='orderSubmitBtn']")).click();
		System.out.println("multiple item test is sucessfully completed for the below inputs");
		System.out.println("Passed data -"+"Browser-"+browser+"Customer No -"+ dealerByCustomerNo+" item Number "+ itemNumber+ "Order class"+ orderClass);
				
				Reporter.log("multiple item test is sucessfully completed for the below inputs");
		Reporter.log("Passed data -"+"Browser-"+browser+"Customer No -"+ dealerByCustomerNo+" item Number "+ itemNumber+ "Order class"+ orderClass);
		
		//ReportGenerator.setLogAndCreateScreenshot(
//				"MultipleItemTest",
	//			"MultipleItemTest", Constants.DEFAULT_TESTNAME, testData, Constants.PASSED);
		
		//wd.close();
		isBrowserEnabled=false;
		}
		if (orderClass.equals("Class 4 - Stock"))
		{
			wd.findElement(By.xpath(".//*[@id='purchaseOrderInput']")).clear();
			wd.findElement(By.xpath(".//*[@id='purchaseOrderInput']")).sendKeys(poNogeneration());

				wd.findElement(By.xpath(".//*[@id='textarea_instructions']")).sendKeys(poNogeneration());
			
			
			wd.findElement(By.xpath(".//*[@id='buttonContinue']")).click();
			wd.findElement(By.xpath(".//*[@id='agreeCheckbox1']")).click();
			wd.findElement(By.xpath(".//*[@id='orderSubmitBtn']")).click();
			Reporter.log("multiple item test is sucessfully completed for the below inputs");
			Reporter.log("Data Passed -"+"Browser-"+browser+"Customer No -"+ dealerByCustomerNo+" item Number "+ itemNumber+ "Order class"+ orderClass);
			
			System.out.print("multiple item test is sucessfully completed for the below inputs");
			System.out.print("Data Passed -"+"Browser-"+browser+"Customer No -"+ dealerByCustomerNo+" item Number "+ itemNumber+ "Order class"+ orderClass);
			
			
			//wd.close();
			isBrowserEnabled=false;
		}
		
		if (orderClass.equals("Class 0 - Field Modification"))
		{
			wd.findElement(By.xpath(".//*[@id='purchaseOrderInput']")).clear();
			wd.findElement(By.xpath(".//*[@id='purchaseOrderInput']")).sendKeys(poNogeneration());
			
			wd.findElement(By.xpath(".//*[@id='shipComplete']")).sendKeys("No");


			Select Mode=new Select(wd.findElement(By.xpath(".//*[@id='primaryShipmentMode']")));
			Mode.selectByIndex(0);

			Mode.selectByIndex(1);

			Select carrier=new Select(wd.findElement(By.xpath(".//*[@id='primaryShipmentCarrier']")));
			carrier.selectByIndex(0);
			carrier.selectByIndex(1);

			Select Priority=new Select(wd.findElement(By.xpath(".//*[@id='primaryShipmentPriority']")));
			Priority.selectByIndex(0);
			Priority.selectByIndex(1);
			
			wd.findElement(By.xpath(".//*[@id='textarea_instructions']")).sendKeys(poNogeneration());
			
			
			
			wd.findElement(By.xpath(".//*[@id='buttonContinue']")).click();
			wd.findElement(By.xpath(".//*[@id='agreeCheckbox1']")).click();
			wd.findElement(By.xpath(".//*[@id='orderSubmitBtn']")).click();
			Reporter.log("multiple item test is sucessfully completed for the below inputs");
			Reporter.log("Data Passed -"+"Browser-"+browser+"Customer No -"+ dealerByCustomerNo+" item Number "+ itemNumber+ "Order class"+ orderClass);
			
			System.out.print("multiple item test is sucessfully completed for the below inputs");
			System.out.print("Data Passed -"+"Browser-"+browser+"Customer No -"+ dealerByCustomerNo+" item Number "+ itemNumber+ "Order class"+ orderClass);
			
			
			//wd.close();
			isBrowserEnabled=false;
		}
		
		
		} catch (Throwable t) 
		{
			System.out.print("multiple item test is failed for the below inputs");
			System.out.print("Failed Data -"+"Browser-"+browser+"Customer No -"+ dealerByCustomerNo+" item Number "+ itemNumber+ "Order class"+ orderClass);
			
			Reporter.log("multiple item test is failed for the below inputs");
			Reporter.log("Failed Data -"+"Browser-"+browser+"Customer No -"+ dealerByCustomerNo+" item Number "+ itemNumber+ "Order class"+ orderClass);
			
			
			//ReportGenerator.setLogAndCreateScreenshot(
				//	"MultipleItemTest",
					//"MultipleItemTest", Constants.DEFAULT_TESTNAME, testData, Constants.FAILED);
			
			System.out.print("syso"+t.getStackTrace());
			
			isBrowserEnabled=true;
			Assert.assertNull(t.getMessage());
			
		}
		
	
	}
	
	@DataProvider (name="MultipleItemTest")
	public static Object[][] getData()
	{
		return InputReader.getInputReader().getDataFromXLS("MultipleItemTest");
		
		
	}
	
	public String poNogeneration()
	{
		Date date=new Date();
		Random rand = new Random();
		int x = rand.nextInt(1000);
		int y = rand.nextInt(1000);
		int z = rand.nextInt(1000);
		String poNumber=date.getDate()+"Auto"+x+y+z;
		return poNumber;
		
	}
	
	public WebElement getWebElement(String pathKey)
	
	{
		return wd.findElement(By.xpath(TestInitializer.PROJECT.getProperty(pathKey)));
		
	}
}
