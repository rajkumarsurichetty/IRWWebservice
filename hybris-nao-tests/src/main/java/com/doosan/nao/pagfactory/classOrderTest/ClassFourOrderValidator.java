package com.doosan.nao.pagfactory.classOrderTest;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.PageFactory.HomePage;
import com.doosan.nao.PageFactory.LoginPage;
import com.doosan.nao.PageFactory.OrderSummaryPage;
import com.doosan.nao.PageFactory.QuickOrderPage;
import com.doosan.nao.PageFactory.SelectOrgPage;
import com.doosan.nao.PageFactory.ShipmentAddressPage;
import com.doosan.nao.PageFactory.YourShoppingCartPage;
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.input.InputReader;
import com.doosan.nao.reports.ReportGenerator;

public class ClassFourOrderValidator extends TestInitializer {
	
	private String browserName;
	private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@BeforeMethod
	public void setUpForClassFourOrderValidatorTest(String browser, String browserVersion, String platform, String osVersion) throws IOException, URISyntaxException, InterruptedException
	{	
		browserName=browser;
		if (isBrowserAlive=="N")
		{
		wd=WebdriverSelector.getDriver(wd, browser);
		
		initialize(browser, browserVersion, platform, osVersion);
		
			wd.get(PROJECT.getProperty("DoosanPassportURL"));
		}
	}
	
	@Test(dataProvider="ClassFourOrderValidator")
	public void validateClassFourOrderTest(String testData,String userName,String password, String brand, String custNo, String itemNo, String qty, String binLocation, String comments, String testUrlName) throws InterruptedException
	{
		this.localTestData=testData;
		LoginPage loginPage=PageFactory.initElements(wd, LoginPage.class);
		SelectOrgPage selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
		HomePage homePage=PageFactory.initElements(wd, HomePage.class);
		QuickOrderPage quickOrderPage=PageFactory.initElements(wd, QuickOrderPage.class);
		YourShoppingCartPage yourShoppingCartPage=PageFactory.initElements(wd, YourShoppingCartPage.class);
		ShipmentAddressPage shipmentAddressPage=PageFactory.initElements(wd, ShipmentAddressPage.class);
		OrderSummaryPage orderSummaryPage=PageFactory.initElements(wd, OrderSummaryPage.class);
		
		if(isBrowserAlive=="N")
		{
			loginPage.enterUserName(userName.trim());
		loginPage.enterPassword(password.trim());
		loginPage.clickLoginButton();
		Thread.sleep(15000L);
		}
		wd.get(PROJECT.getProperty("DoosanParts5URL"));
		//wd.get("http://parts5.qa.corp.doosan.com/");
		if (!selectOrgPage.verifyWelcomeText(wd,userName.trim()))
		{
			System.out.println("i am in browser validation");
			isBrowserAlive="N";
			//wd.quit();
		}
		homePage.clickChange();		
		selectOrgPage.searchByFirstDropdown("Brand");
		selectOrgPage.searchByContainingOptionDropdown(brand.trim());
		selectOrgPage.enterCustomerNo(custNo.trim());
		selectOrgPage.clickSearchButton();
		selectOrgPage.clickFirstOrgLink(wd);
		
		homePage.clickQuickOrderLink(wd);
		
		quickOrderPage.enterItemNumer(itemNo.trim());
		quickOrderPage.enterQuantity(qty.trim());
		quickOrderPage.enterBinLocation(binLocation.trim());
		quickOrderPage.enterComments(comments.trim());
		quickOrderPage.clickaddToCart(wd);
		if(brand.trim().equals("Doosan")){
			yourShoppingCartPage.selecOrderClass(wd,"Stock");
		}else{
		yourShoppingCartPage.selecOrderClass(wd,"Class 4 - Stock");
		}
		
		//yourShoppingCartPage.clickselectAllCheckBox(wd);
		//yourShoppingCartPage.clickselectFirstCheckBoxInCartSummary(wd);
		yourShoppingCartPage.clickIgnoreBulletins(wd);
		yourShoppingCartPage.clickRemoveSelectedLines(wd);
		yourShoppingCartPage.clickcheckOutButton(wd);
		/*
		boolean verify = false;
		try 
		{
			if(wd.findElement(By.xpath(".//*[@id='header3']/div/ul/li[2]")).isDisplayed())
			{
				System.out.println("Text present");
				verify=true;	
			} else 
			{
				System.out.println("Text not present");
				verify=false;
			}
			
		} catch (Throwable t)
		{
			
		}
		
	
	
		if (verify)
			
		{
			System.err.println("I am inside the if of  yourShoppingCartPage");
			homePage.clickQuickOrderLink(wd);
			
			quickOrderPage.enterItemNumer(itemNo.trim());
			quickOrderPage.enterQuantity(qty.trim());
			quickOrderPage.enterBinLocation(binLocation.trim());
			quickOrderPage.enterComments(comments.trim());
			quickOrderPage.clickaddToCart();
			
			yourShoppingCartPage.selecOrderClass(wd,"Class 4 - Stock");
			yourShoppingCartPage.clickselectAllCheckBox(wd);
			yourShoppingCartPage.clickselectFirstCheckBoxInCartSummary(wd);
			yourShoppingCartPage.clickIgnoreBulletins(wd);
			yourShoppingCartPage.clickRemoveSelectedLines(wd);
			yourShoppingCartPage.clickcheckOutButton(wd);
		}
*/
		shipmentAddressPage.purchaseOrderNo(wd);
		shipmentAddressPage.selectPrimaryShipmentMethod("Truck");
		shipmentAddressPage.selectPrimaryShipmentCarrier("United Parcel Ground Freight");
		//shipmentAddressPage.selectPrimaryShipmentCarrierByIndex(2);
		shipmentAddressPage.selectPrimaryShipmentPriorty("Not specified");
		shipmentAddressPage.enterShippingInstructions("Testing");
		shipmentAddressPage.enterAdditionalContacts("Test@test.com");
		shipmentAddressPage.clickContinueButton();
		
		orderSummaryPage.clickAgreeConditionsCheckBox(wd);
		orderSummaryPage.verifyTotalOrderAmount();
		orderSummaryPage.clickSubmitOrder();
		//TestInitializer.isBrowserAlive="A";
		if(yourShoppingCartPage.verifyAccountHistory(wd))	{
			
		} else 	{
			Assert.assertTrue(false, "Order submitted but with error like 500 or bad server");
		}
	}

	@DataProvider(name="ClassFourOrderValidator")
	public static Object[][] getDataForShipments() throws InterruptedException
	{
		//TestInitializer.isBrowserAlive="N";
		return InputReader.getInputReader().getDataFromXLS("ClassFourOrderValidator");
		
	}
	
	
	@AfterMethod()
	public void onTestFailure(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot("ClassFourOrderValidator~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			isBrowserAlive="N";
			//wd.close();
			wd.quit();
			
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot("ClassFourOrderValidator~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			//wd.close();
			wd.quit();
		}
	}
	

}
