package com.doosan.nao.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;



public class BobcatHomePageHyperLinkTest extends TestInitializer  {

	private static final String UPLOAD_EXCEL_PARTS_LIST_LINK = "Upload an Excel parts list";
	private static final String ALL_MAKES_LINK = "All Makes";
	private static final String IMPORT_GPES_ORDER_LINK = "Import GPES Order";
	private static final String CHECK_PRICE_AND_AVAILABITY_LINK = "Check Price & Availability";
	private static final String CREATE_NEW_ORDER_LINK = "Create a New Order";
	private static final String VIEW_SAVED_SHOOPING_CARTS = "View saved shopping carts";
	private static final String GPES_LINK = "GPES";
	private static final String DOOSAN_MERCHANDISE_LINK = "Doosan Merchandise";
	
	private static final String SEARCH_INVOICES_LINK="Search Invoices";
	private static final String DEFAULT_SHIPMENTS_LINK="Default Shipments";
	private static final String PRODUCT_DIAGONSTICS_LINK="Product Diagnostics";
	private static final String SEARCH_ORDRS_LINK="Search Orders";
	private static final String SEARCH_SHIPMENTS_LINK="Search Shipments";
	
	
	private static final String CREATE_NEW_PARTS_CLAIM_LINK="Create a New Parts Claim";
	private static final String MY_OPEN_PARTS_CLAIMS_LINK="My Open Parts Claims";
	private static final String SEARCH_CLAIM_HISTORY_LINK="Search Claim History";
	
	
	private static final String ACCESS_PARTS_REPORTING_LINK="Access Parts Reporting";
	private static final String DEFAULT_SHIPMENTS_REPORTS_LINK="html/body/div[2]/div[4]/div[4]/div/div/div[1]/div[3]/div/div/ul/li[2]/a";
	
	
	private static final String HOW_TO_CONTACT_US_LINK="How To Contact Us";
	private static final String TRAINING_MATERIALS_LINK="Training Materials";
	
	


    
    


    
    





	public EventFiringWebDriver wd=null;
	@BeforeClass
	public void  setUp() throws IOException, URISyntaxException, InterruptedException
	{
		wd=WebdriverSelector.getDriver(wd, "firefox");
		
		initialize("firefox", "30", "windows", "7");
		wd.get(PROJECT.getProperty("DoosanPassportURL"));
		getWebElement(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH,wd).sendKeys("vinoth.kumar");
		getWebElement(Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH,wd).sendKeys("welcome2");
		getWebElement(Constants.LOGIN_PAGE_SUBMIT_BUTTON_X_PATH,wd).submit();
		Thread.sleep(10000L);
		wd.navigate().to(PROJECT.getProperty("DoosanParts5URL"));
		WebDriverWait waitForSearchByDropdown=new WebDriverWait(wd,600);
		waitForSearchByDropdown.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
		
		Select selectBrand=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
		selectBrand.selectByVisibleText("Brand");

		WebDriverWait waitForOrgSection=new WebDriverWait(wd,600);
		waitForOrgSection.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		
		
		Select selectBrandByInput=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		selectBrandByInput.selectByVisibleText("Doosan");
		//wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys("0001225596");
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();

		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd,600);
		waitForFirstOrgLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));
		
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")).click();;

	}
	
	@Test(priority=1)
	public void testUploadAnExcelPartsListLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(UPLOAD_EXCEL_PARTS_LIST_LINK)));
		wd.findElement(By.linkText(UPLOAD_EXCEL_PARTS_LIST_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("UPLOAD_EXCEL_PARTS_LIST_LINK");
	}
	
	@Test(priority=2)
	public void testAllMakesLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(ALL_MAKES_LINK)));
		wd.findElement(By.linkText(ALL_MAKES_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("ALL_MAKES_LINK");
	}
	
	@Test(priority=20)
	public void testImportGPESOrderLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(IMPORT_GPES_ORDER_LINK)));
		wd.findElement(By.linkText(IMPORT_GPES_ORDER_LINK)).click();
		Actions ac=new Actions(wd);
		ac.sendKeys(Keys.ESCAPE).build().perform();
		
		System.out.println("IMPORT_GPES_ORDER_LINK");
	}
	
	
	@Test(priority=4)
	public void testCheckPriceAvailabilityLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(CHECK_PRICE_AND_AVAILABITY_LINK)));
		wd.findElement(By.linkText(CHECK_PRICE_AND_AVAILABITY_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("CHECK_PRICE_AND_AVAILABITY_LINK");
		
	}
	
	@Test(priority=5)
	public void testCreateNewOrderLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(CREATE_NEW_ORDER_LINK)));
		wd.findElement(By.linkText(CREATE_NEW_ORDER_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("CREATE_NEW_ORDER_LINK");
	}
	
	@Test(priority=6)
	public void testViewSavedShoppingCartsLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(VIEW_SAVED_SHOOPING_CARTS)));
		wd.findElement(By.linkText(VIEW_SAVED_SHOOPING_CARTS)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("VIEW_SAVED_SHOOPING_CARTS");
	}
	
	
	@Test(priority=7)
	public void testGPESLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(GPES_LINK)));
		wd.findElement(By.linkText(GPES_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("GPES_LINK");
	}
	
	
	@Test(priority=8)
	public void testDoosanMerchandiseLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(DOOSAN_MERCHANDISE_LINK)));
		wd.findElement(By.linkText(DOOSAN_MERCHANDISE_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("DOOSAN_MERCHANDISE_LINK");
	}
	
	@Test(priority=9)
	public void testSearchInvoicesLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(SEARCH_INVOICES_LINK)));
		wd.findElement(By.linkText(SEARCH_INVOICES_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("SEARCH_INVOICES_LINK");
	}
	
	
	@Test(priority=10)
	public void testDefaultShipmentsLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(DEFAULT_SHIPMENTS_LINK)));
		wd.findElement(By.linkText(DEFAULT_SHIPMENTS_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("DEFAULT_SHIPMENTS_LINK");
	}
	
	@Test(priority=11)
	public void	testProductDiagnosticsLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(PRODUCT_DIAGONSTICS_LINK)));
		wd.findElement(By.linkText(PRODUCT_DIAGONSTICS_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("PRODUCT_DIAGONSTICS_LINK");
	}
	
	@Test(priority=12)
	public void	testSearchOrdersLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(SEARCH_ORDRS_LINK)));
		wd.findElement(By.linkText(SEARCH_ORDRS_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("SEARCH_ORDRS_LINK");
	}
	
	@Test(priority=13)
	public void	testSearchShipmentsLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(SEARCH_SHIPMENTS_LINK)));
		wd.findElement(By.linkText(SEARCH_SHIPMENTS_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("SEARCH_SHIPMENTS_LINK");
	}
	
	
	
	@Test(priority=14)
	public void	testCreateNewPartsClaimLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(CREATE_NEW_PARTS_CLAIM_LINK)));
		wd.findElement(By.linkText(CREATE_NEW_PARTS_CLAIM_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("CREATE_NEW_PARTS_CLAIM_LINK");
	}
	
	@Test(priority=15)
	public void	testMyOpenPartsClaimsLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(MY_OPEN_PARTS_CLAIMS_LINK)));
		wd.findElement(By.linkText(MY_OPEN_PARTS_CLAIMS_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("MY_OPEN_PARTS_CLAIMS_LINK");
	}
	
	@Test(priority=16)
	public void	testSearchClaimHistoryLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(SEARCH_CLAIM_HISTORY_LINK)));
		wd.findElement(By.linkText(SEARCH_CLAIM_HISTORY_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("SEARCH_CLAIM_HISTORY_LINK");
	}
	
	@Test(priority=17)
	public void	testAccessPartsReportingLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(ACCESS_PARTS_REPORTING_LINK)));
		wd.findElement(By.linkText(ACCESS_PARTS_REPORTING_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("ACCESS_PARTS_REPORTING_LINK");
	}
	@Test(priority=18)
	public void	testDefaultShipmentsReportsLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEFAULT_SHIPMENTS_REPORTS_LINK)));
		wd.findElement(By.xpath(DEFAULT_SHIPMENTS_REPORTS_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("DEFAULT_SHIPMENTS_REPORTS_LINK");
	}
	
	
	@Test(priority=19)
	public void	testHowToContactUsLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(HOW_TO_CONTACT_US_LINK)));
		wd.findElement(By.linkText(HOW_TO_CONTACT_US_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("HOW_TO_CONTACT_US_LINK");
	}
	@Test(priority=3, enabled=false)
	public void	testTrainingMaterialsLink()
	{
		WebDriverWait waitForHomeLink=new WebDriverWait(wd,600);
		waitForHomeLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText(TRAINING_MATERIALS_LINK)));
		wd.findElement(By.linkText(TRAINING_MATERIALS_LINK)).click();
		wd.findElement(By.linkText("Home")).click();
		System.out.println("TRAINING_MATERIALS_LINK");
		

	}
	
		
}
