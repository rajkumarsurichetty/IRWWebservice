package com.doosan.nao.pagfactory.classOrderTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.PageFactory.HomePage;
import com.doosan.nao.PageFactory.LoginPage;
import com.doosan.nao.PageFactory.QuickOrderPage;
import com.doosan.nao.PageFactory.SelectOrgPage;
import com.doosan.nao.PageFactory.YourShoppingCartPage;
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.input.InputReader;
import com.doosan.nao.reports.ReportGenerator;

public class ShoppingCartDupLineBin extends TestInitializer{
	private String browserName;
	private String isBrowserAlive="N";
	public EventFiringWebDriver wd=null;
	private String localTestData;
	Map<String ,Integer> consolidateQuantity =new HashMap<>();
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@BeforeMethod
	public void setUpForShoppingCartPageInvalidTest(String browser, String browserVersion, String platform, String osVersion) throws IOException, URISyntaxException, InterruptedException
	{
		browserName=browser;
		if (isBrowserAlive=="N")
		{
		wd=WebdriverSelector.getDriver(wd, browser);
		
		initialize(browser, browserVersion, platform, osVersion);
		
			wd.get(PROJECT.getProperty("DoosanPassportURL"));
		}
		QuickOrderPage quickOrderPage =new QuickOrderPage();
		quickOrderPage.clearAllBrowserCache(wd);
	}

	
	
	@Test(dataProvider="ShoppingCartDupLineBin")
	public void validateShoppingCartPageInvalidTest(String testData,String userName,String password, String brand, String custNo, String itemNo, String qty, String binLocation, String comments,String shoppingQty, String shoppingBinLocation, String shoppingComments, String testUrlName) throws InterruptedException
	{
		this.localTestData=testData;
		
		LoginPage loginPage=PageFactory.initElements(wd, LoginPage.class);
		SelectOrgPage selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
		HomePage homePage=PageFactory.initElements(wd, HomePage.class);
		QuickOrderPage quickOrderPage=PageFactory.initElements(wd, QuickOrderPage.class);
		YourShoppingCartPage yourShoppingCartPage=PageFactory.initElements(wd, YourShoppingCartPage.class);
		
		if(isBrowserAlive=="N")
		{
			loginPage.enterUserName(userName.trim());
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
		
		
		quickOrderPage.enterMultipleParts(wd, itemNo, qty,binLocation);
		
		//quickOrderPage.enterItemNumer(itemNo.trim());
		//quickOrderPage.enterQuantity(qty.trim());
		//quickOrderPage.enterBinLocation(binLocation.trim());
		quickOrderPage.checkduplicateLineBinLocations(wd);
		quickOrderPage.enterComments(comments.trim());
		quickOrderPage.clickaddToCart(wd);
		//verifying the invalid item 
		try{
		if(quickOrderPage.VerifyitemNumberentries0.isDisplayed()){
		quickOrderPage.VerifyitemNumberentries0();
		System.out.println("Item invalid Error Message is ==>"+quickOrderPage.VerifyitemNumberentries0.getText());
		}
		}catch(Throwable e){}
		//Verifying the invalid Quantity 
		try{
		if( quickOrderPage.Verifyquantityrentries0.isDisplayed())
		quickOrderPage.Verifyquantityrentries0();
		System.out.println(" Qntity invalid Error Message is ==> "+quickOrderPage.Verifyquantityrentries0.getText());
		}catch(Throwable e){
			
		}
		
		//Verifying the invalid bin input value
		try{
			if( quickOrderPage.Verifybinentries0.isDisplayed())
			quickOrderPage.Verifybinentries0();
			System.out.println( " Bin location invalid Error Message is ==> "+quickOrderPage.Verifybinentries0.getText());
			}catch(Throwable e){
				
			}
		
		//Verifying the invalid bin input value
				try{
					if( quickOrderPage.Verifycommententries0.isDisplayed())
					quickOrderPage.VerifyCommentEntries0();
					System.out.println( "Comment invalid  Error Message is ==> "+quickOrderPage.Verifycommententries0.getText());
					}catch(Throwable e){
						
					}
				
				//Shopping cart
			/*yourShoppingCartPage.enterQuantity(shoppingQty);
			yourShoppingCartPage.enterBinLocation(shoppingBinLocation);
			yourShoppingCartPage.enterComments(shoppingComments);
			yourShoppingCartPage.selecOrderClass(wd,"Class 1 - Breakdown - Warranty");
			yourShoppingCartPage.clickcheckOutButton(wd);
			try{
				yourShoppingCartPage.verifyentries0quantityerrors(wd);
				System.out.println( "Quantity invalid  Error Message is ==> "+yourShoppingCartPage.entries0quantityerrors.getText());
			}catch( Throwable e){
				
			}
			try{
				yourShoppingCartPage.Verifyentries0binLocationerrors();
				System.out.println( "Binlocation invalid  Error Message is ==> "+yourShoppingCartPage.entries0binLocationerrors.getText());
			}catch( Throwable e){
				
			}
			try{
				yourShoppingCartPage.Verifyentries0commentserrors();
				System.out.println( "Comment invalid  Error Message is ==> "+yourShoppingCartPage.entries0commentserrors.getText());
			}catch( Throwable e){
				
			}*/
			
			consolidateQuantity	=	quickOrderPage.checkDuplicatedLineItemsNoBinLocation(wd, itemNo, qty, binLocation);
				
				yourShoppingCartPage.getLineItemAndQuantity(wd, consolidateQuantity, "");
				yourShoppingCartPage.clickRemoveCart();
				
	}

	
	@DataProvider(name="ShoppingCartDupLineBin")
	public static Object[][] getDataForShipments() throws InterruptedException
	{
		//TestInitializer.isBrowserAlive="N";
		return InputReader.getInputReader().getDataFromXLS("ShoppingCartDupLineBin");
		
	}
	
	
	@AfterMethod()
	public void onTestFailure(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot("ShoppingCartDupLineBin~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			isBrowserAlive="N";
			wd.quit();			
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot("ShoppingCartDupLineBin~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			wd.quit();
		}
	}

}
