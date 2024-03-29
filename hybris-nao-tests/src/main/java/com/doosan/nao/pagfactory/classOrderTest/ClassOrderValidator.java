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

public class ClassOrderValidator extends TestInitializer {
	private static String browserName;
	private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;	
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@BeforeMethod
	public void setUpForClassOrderValidatorTest(String browser, String browserVersion, String platform, String osVersion) throws IOException, URISyntaxException, InterruptedException
	{	
		System.err.println(browser);
		browserName=browser;
		if (isBrowserAlive=="N")
		{
		wd=WebdriverSelector.getDriver(wd, browser);
		
		initialize(browser, browserVersion, platform, osVersion);
		
			wd.get(PROJECT.getProperty("DoosanPassportURL"));
		}
	}
	
	
	@Test(dataProvider="ClassOrderValidator")
	public void validateClassOrderValidatorTest(String testData,String userName,String password, String brand, String custNo, String itemNo, String qty, String binLocation, String comments,String orderClass, String testUrlName) throws InterruptedException
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
			loginPage.enterUserName(userName);
			loginPage.enterPassword(password.trim());
		loginPage.clickLoginButton();
		Thread.sleep(10000L);
		}
		
		wd.get(PROJECT.getProperty("DoosanParts5URL"));
		//wd.get("http://parts3.qa.corp.doosan.com/");
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
		String [] orderclasses=orderClass.split(",");
		//for (String iterable_element : orderclasses) {
			for (int i = 0; i < orderclasses.length; i++) {
				
			
		
		quickOrderPage.enterItemNumer(itemNo.trim());
		quickOrderPage.enterQuantity(qty.trim());
		quickOrderPage.enterBinLocation(binLocation.trim());
		quickOrderPage.enterComments(comments.trim());
		quickOrderPage.clickaddToCart(wd);
		
		yourShoppingCartPage.selecOrderClass(wd,orderclasses[i]);
		//yourShoppingCartPage.clickselectAllCheckBox(wd);
		//yourShoppingCartPage.clickselectFirstCheckBoxInCartSummary(wd);
		yourShoppingCartPage.clickIgnoreBulletins(wd);
		yourShoppingCartPage.clickRemoveSelectedLines(wd);
		yourShoppingCartPage.clickcheckOutButton(wd);
		/*
		boolean verify = false;
		try 
		{
			Thread.sleep(2000L);
			if(wd.findElement(By.xpath(".//*[@id='header3']/div/ul/li[2]")).isDisplayed())
			{
				System.out.println("Cart is empty");
				verify=true;	
			} else 
			{
				System.out.println("Cart is not empty");
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
			
			yourShoppingCartPage.selecOrderClass(wd,"48 Hour Guarantee");
			yourShoppingCartPage.clickselectAllCheckBox(wd);
			yourShoppingCartPage.clickselectFirstCheckBoxInCartSummary(wd);
			yourShoppingCartPage.clickIgnoreBulletins(wd);
			yourShoppingCartPage.clickRemoveSelectedLines(wd);
			yourShoppingCartPage.clickcheckOutButton(wd);
		}
		
*/
		shipmentAddressPage.purchaseOrderNo(wd);
		/*shipmentAddressPage.enterHours("12");
		shipmentAddressPage.enterModelNumberNo("ModelNumberTest");
		shipmentAddressPage.enterSerialNumber("SerialNumberTest");*/
		//if(!iterable_element.equals("")){
			
		shipmentAddressPage.selectPrimaryShipmentMethod("Air");
		//shipmentAddressPage.selectPrimaryShipmentCarrier("DHL");
		shipmentAddressPage.selectPrimaryShipmentCarrier("Federal Express Parcel".trim());
		//shipmentAddressPage.selectPrimaryShipmentCarrierByIndex(1);
		//Thread.sleep(1000L);
		//shipmentAddressPage.selectPrimaryShipmentPriorty("NXA - Morning");
		shipmentAddressPage.selectPrimaryShipmentPriorty("2ND - 2nd day".trim());
		//}
		//shipmentAddressPage.selectPrimaryShipmentPriortyByIndex(1);
		shipmentAddressPage.enterShippingInstructions("Testing");
		shipmentAddressPage.enterAdditionalContacts("Test@test.com");
		shipmentAddressPage.clickContinueButton();
		
		orderSummaryPage.clickAgreeConditionsCheckBox(wd);
		orderSummaryPage.verifyTotalOrderAmount();
		orderSummaryPage.clickSubmitOrder();
		
		if(yourShoppingCartPage.verifyAccountHistory(wd))	{
			
		} else 	{
			Assert.assertTrue(false, "Order submitted but with error like 500 or bad server");
		}
		if((orderclasses.length-1)!=i){orderSummaryPage.clickContinueShopping();}
		}
	}
	
	@DataProvider(name="ClassOrderValidator")
	public static Object[][] getDataForShipments() throws InterruptedException
	{
	
		return InputReader.getInputReader().getDataFromXLS("ClassOrderValidator");
		
	}
	
	
	@AfterMethod()
	public void onTestFailure(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot("ClassOrderValidator~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			isBrowserAlive="N";
			wd.quit();
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot("ClassOrderValidator~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			wd.quit();
		}
	}
	
	
}
