package com.doosan.nao.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.doosan.nao.init.TestInitializer;

public class HomePage {

	@FindBy(linkText="Fleet Management")
	WebElement fleetmgmtLinkTop;
	public void clickFleetmanagementLink(EventFiringWebDriver wd){
		TestInitializer.highlightMyElement(fleetmgmtLinkTop, 3, wd);
		fleetmgmtLinkTop.click();
	}
	@FindBy(xpath="//div/h1")
	WebElement fleetHeader;
	boolean flag=false;
	public void  verifyFleetManagementLink(EventFiringWebDriver wd){
		TestInitializer.waitForElement(wd, fleetHeader);
		flag=fleetHeader.isDisplayed();
		try {
			Assert.assertEquals(flag, true);
		} catch (Exception e) {
			
			e.printStackTrace();
			Assert.fail("Fleet management page not loaded");
		}
		
	}

	

	@FindBy(how=How.LINK_TEXT,using="Batch Order Upload")
	public WebElement BatchOrderUpload;

	@FindBy(how=How.LINK_TEXT,using="Order History")
	public WebElement OrderHistory;
	
	@FindBy(how=How.LINK_TEXT,using="Sign Out")
	public WebElement SignOut;    
    

	@FindBy(how=How.LINK_TEXT,using="All Makes")
	public WebElement AllMakes;
    public void clickAllMakes(EventFiringWebDriver wd)
    {


    	WebDriverWait waitForHomeLink=new WebDriverWait(wd, 5);
    	waitForHomeLink.until(ExpectedConditions.elementToBeClickable(AllMakes));
    	//AllMakes.click();
		//if(allMakes.size()==1)
    	//{
    		//Assert.assertSame(1, 2, "All makes duplicate links are present in home page");
    	//}
    	//else 
    	//{
    	//	Assert.assertSame(1, allMakes.size(), "All makes duplicate links are present in home page");
    	//}
    }

    
    
    
	@FindBy(how=How.LINK_TEXT,using="Home")
	public WebElement HomeLink;
    public void clickHomeLink(EventFiringWebDriver wd)
    {
    	WebDriverWait waitForHomeLink=new WebDriverWait(wd, 5);
    	waitForHomeLink.until(ExpectedConditions.elementToBeClickable(HomeLink));
    	HomeLink.click();
    }

	@FindBy(how=How.LINK_TEXT,using="Saved Carts")
	public WebElement SavedCarts;
    public void clickSavedCartsLink()
    {
    	SavedCarts.click();
    }
    @FindBy(xpath="//h1")
	WebElement saveCartHeader;
	boolean flagsavecart=false;
	public void  verifySaveCartLink(EventFiringWebDriver wd){
		TestInitializer.waitForElement(wd, saveCartHeader);
		flagsavecart=saveCartHeader.isDisplayed();
		try {
			Assert.assertEquals(flagsavecart, true);
		} catch (Exception e) {
			
			e.printStackTrace();
			Assert.fail("Save Cart page not loaded");
		}
		
	}
    
    
    

	@FindBy(how=How.LINK_TEXT,using="Price & Availability")
	public WebElement PriceAndAvaliablity;
    public void clickPriceAndAvaliablityLink()
    {
    	PriceAndAvaliablity.click();
    }

    @FindBy(xpath="//h1")
	WebElement PriceAndAvaliablityHeader;
	boolean flagPrice=false;
	public void  verifyPriceAndAvaliablityLink(EventFiringWebDriver wd){
		TestInitializer.waitForElement(wd, PriceAndAvaliablityHeader);
		flagPrice=PriceAndAvaliablityHeader.isDisplayed();
		try {
			Assert.assertEquals(flagPrice, true);
		} catch (Exception e) {
			
			e.printStackTrace();
			Assert.fail("Price And Avaliablity page not loaded");
		}
		
	}
    @FindBy(how=How.LINK_TEXT,using="Quick Order")
	public WebElement QuickOrder;
    public void clickQuickOrderLink(EventFiringWebDriver wd)
    {
    	WebDriverWait wait=new WebDriverWait(wd, 180);
    	wait.until(ExpectedConditions.elementToBeClickable(QuickOrder));
    	QuickOrder.click();
    }
    
    @FindBy(xpath="//h1")
   	WebElement QuickOrderHeader;
   	boolean flagQuickOrder=false;
   	public void  verifyQuickOrderLink(EventFiringWebDriver wd){
   		TestInitializer.waitForElement(wd, QuickOrderHeader);
   		flagQuickOrder=QuickOrderHeader.isDisplayed();
   		try {
   			Assert.assertEquals(flagQuickOrder, true);
   		} catch (Exception e) {
   			
   			e.printStackTrace();
   			Assert.fail("Quick order page not loaded");
   		}
   		
   	}
   	
    
    
    public void clickBatchOrderUploadLink()
    {
    	BatchOrderUpload.click();
    }
   	@FindBy(xpath="//h1")
   	WebElement BatchOrderUploadHeader;
   	boolean flagBatchOrderUploadHeader=false;
   	public void  verifyBatchOrderUploadLink(EventFiringWebDriver wd){
   		TestInitializer.waitForElement(wd, BatchOrderUploadHeader);
   		flagBatchOrderUploadHeader=BatchOrderUploadHeader.isDisplayed();
   		try {
   			Assert.assertEquals(flagBatchOrderUploadHeader, true);
   		} catch (Exception e) {
   			
   			e.printStackTrace();
   			Assert.fail("Batch Order Upload page not loaded");
   		}
   		
   	}
    public void clickOrderHistoryLink()
    {
    	OrderHistory.click();
    }
    
    
    
    @FindBy(xpath="//h1")
   	WebElement AccountHistoryHeader;
   	boolean flagAccountHistoryHeader=false;
   	public void  verifyAccountHistoryLink(EventFiringWebDriver wd){
   		TestInitializer.waitForElement(wd, AccountHistoryHeader);
   		flagAccountHistoryHeader=AccountHistoryHeader.isDisplayed();
   		try {
   			Assert.assertEquals(flagAccountHistoryHeader, true);
   		} catch (Exception e) {
   			
   			e.printStackTrace();
   			Assert.fail("Account History page not loaded");
   		}
   		
   	}
    public void clickSignOutLink()
    {
    	SignOut.click();
    }
    
    
    @FindBy(how=How.LINK_TEXT,using="Change")
	public WebElement change;
    public void clickChange()
    {
    	System.err.println("A");
    	try {
    		System.err.println("B");
    	change.click();
    	System.err.println("C");
    	} catch (Throwable t)
    	{
    		System.err.println("D");
    	}
    }

    
    
    //Hyper links
    
    @FindBy(how=How.LINK_TEXT,using="All Makes")
	public WebElement allMakes;
    public void clickAllMakesLink()
    {
    	allMakes.click();
    }
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[1]/div/div/h1")
	public WebElement allMakesText;
    public void verifyAllMakesText()
    {
    	String actualText=allMakesText.getText();
    	String expectedText="All Makes";
    	Assert.assertEquals(actualText, expectedText);
    }
     
    
    
    
    
    
    
    @FindBy(how=How.LINK_TEXT,using="Check Price & Availability")
	public WebElement checkPriceAndAvailability;
    public void clickcheckPriceAndAvailabilityLink(EventFiringWebDriver wd)
    {
    	clickHomeLink(wd);
    TestInitializer.waitForElement(wd, checkPriceAndAvailability);
    
    	System.err.println("check price");
    	checkPriceAndAvailability.click();
    }
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[1]/div/div/h1")
	public WebElement checkPriceAndAvailabilityText;
    public void verifyCheckPriceAndAvailabilityText()
    {
    	String actualText=checkPriceAndAvailabilityText.getText();
    	String expectedText="Check Price & Availability";
    	
    	try {
			Assert.assertEquals(actualText, expectedText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Price & Availability page not loaded");
		}
    }
        
    
    
    @FindBy(how=How.LINK_TEXT,using="Upload an Excel parts list")
	public WebElement uploadAnExcelPartsList;
    public void clickuploadAnExcelPartsListLink(EventFiringWebDriver wd)
    {clickHomeLink(wd);
    TestInitializer.waitForElement(wd, uploadAnExcelPartsList);
    	uploadAnExcelPartsList.click();
    }
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div/div/h1")
	public WebElement uploadAnExcelPartsListText;
    public void verifyUploadAnExcelPartsListText()
    {
    	String actualText=uploadAnExcelPartsListText.getText();
    	String expectedText="Batch Order Upload";
    	
    	try {
			Assert.assertEquals(actualText, expectedText);
		} catch (Exception e) {
			
			e.printStackTrace();
			Assert.fail("Batch Order Upload page not loaded ");
		}
    }
    
    
    
    @FindBy(how=How.LINK_TEXT,using="Create a New Order")
	public WebElement createNewOrder;
    public void clickCreateNewOrderLink(EventFiringWebDriver wd)
    {clickHomeLink(wd);
    TestInitializer.waitForElement(wd, createNewOrder);
    	createNewOrder.click();
    }
    
    @FindBy(how=How.XPATH,using=".//*[@id='main']/div[1]/div/div/h1")
	public WebElement quickOrderText;
    public void verifyQuickOrderText(EventFiringWebDriver wd)
    {TestInitializer.waitForElement(wd, quickOrderText);
    	String actualText=quickOrderText.getText().trim();
    	String expectedText="	Quick Order".trim();
    	
    	try {
			Assert.assertEquals(actualText, expectedText);
		} catch (Exception e) {
			
			e.printStackTrace();
			Assert.fail("Quick Order page not loaded  ");
		}
    }
    
    
    
    //GPES
    //Import GPES Order
    
    
    
    @FindBy(how=How.LINK_TEXT,using="Create a New Order")
	public WebElement CreateANewOrder;
    public void clickCreateANewOrderLink(EventFiringWebDriver wd)
    {clickHomeLink(wd);
    TestInitializer.waitForElement(wd, CreateANewOrder);
    	CreateANewOrder.click();
    }
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[1]/div/div/h1")
	public WebElement CreateANewOrderText;
    public void verifycreateANewOrderText()
    {
    	String actualText=CreateANewOrderText.getText();
    	String expectedText="Quick Order";
    	
    	Assert.assertEquals(actualText, expectedText);
    }

    @FindBy(how=How.LINK_TEXT,using="View saved shopping carts")
	public WebElement viewSavedShoppingCarts;
    public void clickviewSavedShoppingCartsLink(EventFiringWebDriver wd)
    {clickHomeLink(wd);
    TestInitializer.waitForElement(wd, viewSavedShoppingCarts);
    	viewSavedShoppingCarts.click();
    }
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[1]/div/div/h1")
	public WebElement viewSavedShoppingCartsText;
    public void verifyViewSavedShoppingCartsText()
    {
    	String actualText=viewSavedShoppingCartsText.getText();
    	String expectedText="Saved Carts";
    	
    	try {
			Assert.assertEquals(actualText, expectedText);
		} catch (Exception e) {
			
			e.printStackTrace();
			Assert.fail("Saved Carts page not loaded");
		}
    }
    
    
  //
    //Import GPES Order
    
    
    
    @FindBy(how=How.LINK_TEXT,using="Import GPES Order")
	public WebElement ImportGPESOrder;
    public void clickImportGPESOrderLink(EventFiringWebDriver wd)
    {clickHomeLink(wd);
    TestInitializer.waitForElement(wd, viewSavedShoppingCarts);
    	ImportGPESOrder.click();
    }
    
    @FindBy(how=How.XPATH,using="html/body/div[5]/div[1]/span")
	public WebElement ImportGPESOrderText;
    public void verifyImportGPESOrderText(EventFiringWebDriver wd)
    {
    	String actualText=ImportGPESOrderText.getText();
    	String expectedText="GPES Order Lookup";
    	
    	Actions ac=new Actions(wd);
    	ac.sendKeys(Keys.ESCAPE).build().perform();
    	Assert.assertEquals(actualText, expectedText);
    	
    }

    /***************Search Account History Links ********************/
    
    @FindBy(how=How.LINK_TEXT,using="Search Invoices")
	public WebElement SearchInvoices;
    public void clickSearchInvoicesLink(EventFiringWebDriver wd)
    {clickHomeLink(wd);
    TestInitializer.waitForElement(wd, viewSavedShoppingCarts);
    	SearchInvoices.click();
    }
    @FindBy(xpath="//h1")
	WebElement InvoicesHeader;
    boolean flagInvoicesHeader;
    public void verifySearchInvoicesLink(EventFiringWebDriver wd){
    	TestInitializer.waitForElement(wd, InvoicesHeader);
   		flagInvoicesHeader=InvoicesHeader.isDisplayed();
   		try {
   			Assert.assertEquals(flagInvoicesHeader, true);
   		} catch (Exception e) {
   			
   			e.printStackTrace();
   			Assert.fail("Invoice  page not loaded");
   		}
    }
    
    @FindBy(how=How.LINK_TEXT,using="Search Orders")
	public WebElement SearchOrders;
    public void clickSearchOrdersLink(EventFiringWebDriver wd)
    {clickHomeLink(wd);
    TestInitializer.waitForElement(wd, viewSavedShoppingCarts);
    	SearchOrders.click();
    }
    
    @FindBy(xpath="//h1")
	WebElement SearchOrdersHeader;
    boolean flagSearchOrders;
    public void verifySearchOrdersLink(EventFiringWebDriver wd){
    	TestInitializer.waitForElement(wd, SearchOrdersHeader);
    	flagSearchOrders=SearchOrdersHeader.isDisplayed();
   		try {
   			Assert.assertEquals(flagSearchOrders, true);
   		} catch (Exception e) {
   			
   			e.printStackTrace();
   			Assert.fail("Search Order page not loaded");
   		}
    }
    @FindBy(how=How.LINK_TEXT,using="Search Shipments")
	public WebElement SearchShipments;
    public void clickSearchShipmentsLink(EventFiringWebDriver wd)
    {clickHomeLink(wd);
    TestInitializer.waitForElement(wd, viewSavedShoppingCarts);
    	SearchShipments.click();
    }
    @FindBy(xpath="//h1")
   	WebElement SearchShipmentsHeader;
       boolean flagSearchShipments;
       public void verifySearchShipmentsLink(EventFiringWebDriver wd){
       	TestInitializer.waitForElement(wd, SearchShipmentsHeader);
       	flagSearchShipments=SearchShipmentsHeader.isDisplayed();
      		try {
      			Assert.assertEquals(flagSearchShipments, true);
      		} catch (Exception e) {
      			
      			e.printStackTrace();
      			Assert.fail("Search Order page not loaded");
      		}
       }
       @FindBy(how=How.LINK_TEXT,using="Product Diagnostics")
       public WebElement productDiagnostics;
       public void clickproductDiagnosticsLink(EventFiringWebDriver wd)
       {clickHomeLink(wd);
       TestInitializer.waitForElement(wd, productDiagnostics);
       productDiagnostics.click();
       }
       @FindBy(xpath="//h1")
      	WebElement productDiagnosticsHeader;
          boolean flagProductDiagnostics;
          public void verifyproductDiagnosticsLink(EventFiringWebDriver wd){
          	TestInitializer.waitForElement(wd, productDiagnosticsHeader);
          	flagProductDiagnostics=productDiagnosticsHeader.isDisplayed();
         		try {
         			Assert.assertEquals(flagProductDiagnostics, true);
         		} catch (Exception e) {
         			
         			e.printStackTrace();
         			Assert.fail("Product Diagnostics page not loaded");
         		}
          }
          @FindBy(how=How.LINK_TEXT,using="Default Shipments")
          public WebElement defaultShipments;
          public void clickDefaultShipmentsLink(EventFiringWebDriver wd)
          {clickHomeLink(wd);
          TestInitializer.waitForElement(wd, defaultShipments);
          defaultShipments.click();
          }
          @FindBy(xpath="//h1")
         	WebElement defaultShipmentsHeader;
             boolean flagDefaultShipments;
             public void verifyDefaultShipmentsLink(EventFiringWebDriver wd){
             	TestInitializer.waitForElement(wd, defaultShipmentsHeader);
             	flagDefaultShipments=defaultShipmentsHeader.isDisplayed();
            		try {
            			Assert.assertEquals(flagDefaultShipments, true);
            		} catch (Exception e) {
            			
            			e.printStackTrace();
            			Assert.fail("DefaultS hipments page not loaded");
            		}
             }
    /***************Shipment Discrepancy Reports links ********************/
    
    @FindBy(how=How.LINK_TEXT,using="Create a New Parts Claim")
	public WebElement CreateANewPartsClaim;
    public void clickCreateANewPartsClaimLink(EventFiringWebDriver wd)
    {
    	clickHomeLink(wd);
    	try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	WebDriverWait wait=new WebDriverWait(wd, 180);
    	wait.until(ExpectedConditions.elementToBeClickable(CreateANewPartsClaim));
    	CreateANewPartsClaim.click();
    	
    }

    @FindBy(how=How.LINK_TEXT,using="My Open Parts Claims")
	public WebElement MyOpenPartsClaims;
    public void clickMyOpenPartsClaimsLink()
    {
    	MyOpenPartsClaims.click();
    }
    
    @FindBy(how=How.LINK_TEXT,using="Search Claim History")
	public WebElement SearchClaimHistory;
    public void clickSearchClaimHistoryLink()
    {
    	SearchClaimHistory.click();
    }
    
    
    @FindBy(how=How.LINK_TEXT,using="Access Parts Reporting")
	public WebElement AccessPartsReporting;
    public void clickAccessPartsReportingLink()
    {
    	AccessPartsReporting.click();
    }
    
    
    @FindBy(how=How.LINK_TEXT,using="How To Contact Us")
	public WebElement HowToContactUs;
    public void clickHowToContactUsLink()
    {
    	HowToContactUs.click();
    }
    
    
    
    @FindBy(how=How.LINK_TEXT,using="Training Materials")
	public WebElement TrainingMaterials;
    public void clickTrainingMaterialsLink()
    {
    	TrainingMaterials.click();
    }
    
    
    @FindBy(how=How.LINK_TEXT,using="DealerNET")
	public WebElement DealerNET;
    public void clickDealerNETLink()
    {
    	DealerNET.click();
    }
    
    @FindBy(how=How.LINK_TEXT,using="DoosanStockCalendar")
	public WebElement DoosanStockCalendar;
    public void clickDoosanStockCalendarLink()
    {
    	DoosanStockCalendar.click();
    }
    

    /*****************************Text verification ****************/
    
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div/div[1]/div/h1")
	public WebElement SearchInvoiceText;
    public void verifySearchInvoiceText()
    {
    	String actualText=SearchInvoiceText.getText();
    	String expectedText="Account History";
    	
    	Assert.assertEquals(actualText, expectedText);
    }

    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div/div[1]/div/h1")
	public WebElement SearchOrderText;
    public void verifySearchOrderText()
    {
    	String actualText=SearchOrderText.getText();
    	String expectedText="Account History";
    	
    	Assert.assertEquals(actualText, expectedText);
    }
    
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div/div[1]/div/h1")
	public WebElement SearchShipmentsText;
    public void verifySearchShipmentsText()
    {
    	String actualText=SearchShipmentsText.getText();
    	String expectedText="Account History";
    	
    	Assert.assertEquals(actualText, expectedText);
    }
    
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[1]/div/div/h1")
	public WebElement CreateNewPartClaimText;
    public void verifyCreateNewPartClaimText()
    {
    	String actualText=CreateNewPartClaimText.getText();
    	String expectedText="Parts Claims";
    	Assert.assertEquals(actualText, expectedText);
    }
    
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[1]/div/div/h1")
	public WebElement MyOpenPartsClaimText;
    public void verifyMyOpenPartsClaimText()
    {
    	String actualText=MyOpenPartsClaimText.getText();
    	String expectedText="Parts Claims";
    	
    	Assert.assertEquals(actualText, expectedText);
    }
    
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[1]/div/div/h1")
	public WebElement SearchClaimHistoryText;
    public void verifySearchClaimHistoryText()
    {
    	String actualText=SearchClaimHistoryText.getText();
    	String expectedText="Parts Claims";
    	
    	Assert.assertEquals(actualText, expectedText);
    }
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[1]/div/h1")
	public WebElement AccessPartsReportingText;
    public void verifyAccessPartsReportingText()
    {
    	String actualText=AccessPartsReportingText.getText();
    	String expectedText="	Reporting";
    	
    	Assert.assertEquals(actualText, expectedText);
    }
    
    
    @FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[1]/div/span/h1")
	public WebElement DefaultShipmentMethodsText;
    public void verifyDefaultShipmentMethodsText()
    {
    	String actualText=DefaultShipmentMethodsText.getText();
    	String expectedText="Assign Default Shipment Method";
    	
    	Assert.assertEquals(actualText, expectedText);
    }
    
    
   
}
