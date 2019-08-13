package com.doosan.nao.PageFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.doosan.nao.init.TestInitializer;

public class YourShoppingCartPage {

	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div[1]/select")
	public WebElement selectOrderClass;
	public void selecOrderClass(WebDriver wd,String orderClass)
	{	
		WebDriverWait waitForOrderClass=new WebDriverWait(wd, 120);
		waitForOrderClass.until(ExpectedConditions.elementToBeClickable(selectOrderClass));
		Select selectOrder=new Select(selectOrderClass);
		selectOrder.selectByVisibleText(orderClass);
	}
	
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div[2]/span/input")
	public WebElement ignoreBulletins;
	public void clickIgnoreBulletins(WebDriver wd)
	{
		try {
		WebDriverWait waitForOrderClass=new WebDriverWait(wd, 10);
		waitForOrderClass.until(ExpectedConditions.elementToBeClickable(ignoreBulletins));
		ignoreBulletins.click();
		} catch (Throwable t)
		{
			
		}
	}
	
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[3]/table/thead/tr/th[1]/input")
	public WebElement selectAllCheckBox;
	public void clickselectAllCheckBox(WebDriver wd)
	{
		WebDriverWait waitForOrderClass=new WebDriverWait(wd, 120);
		waitForOrderClass.until(ExpectedConditions.elementToBeClickable(selectAllCheckBox));
		selectAllCheckBox.click();
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[3]/table/tbody/tr[1]/td[1]/input[1]")
	public WebElement FirstCheckBoxInCartSummary;
	public void clickselectFirstCheckBoxInCartSummary(WebDriver wd)
	{
		WebDriverWait waitForOrderClass=new WebDriverWait(wd, 120);
		waitForOrderClass.until(ExpectedConditions.elementToBeClickable(FirstCheckBoxInCartSummary));
		FirstCheckBoxInCartSummary.click();
		if(FirstCheckBoxInCartSummary.isSelected())
		{
			FirstCheckBoxInCartSummary.click();
		}
		if(FirstCheckBoxInCartSummary.isSelected())
		{
			FirstCheckBoxInCartSummary.click();
		}
		
	}
	
	

	@FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[2]/a[1]")
	public WebElement RemoveSelectedLines;
	public void clickRemoveSelectedLines(WebDriver wd)
	{
		//WebDriverWait waitForOrderClass=new WebDriverWait(wd, 120);
		//waitForOrderClass.until(ExpectedConditions.elementToBeClickable(RemoveSelectedLines));
		try {
		RemoveSelectedLines.click();
		} catch (Throwable t)
		{
			
		}
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[2]/div[2]/form/div[1]/span/input")
	public WebElement checkOutButton;
	public void clickcheckOutButton(WebDriver wd)
	{
		WebDriverWait waitForOrderClass=new WebDriverWait(wd, 120);
		waitForOrderClass.until(ExpectedConditions.elementToBeClickable(checkOutButton));
		checkOutButton.click();
	}
	
	@FindBy(how=How.LINK_TEXT,using="Account History")
	public WebElement AccountHistory;
	public boolean verifyAccountHistory(WebDriver wd)
	{
		WebDriverWait waitForOrderClass=new WebDriverWait(wd, 10);
		waitForOrderClass.until(ExpectedConditions.elementToBeClickable(AccountHistory));
		return AccountHistory.isDisplayed();
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='buttons']/div[1]/button")
	public WebElement addItemsButton;
	public void clickAddItemsButton(WebDriver wd)
	{
		addItemsButton.click();
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='buttons']/div[2]/button[1]")
	public WebElement exportToExcelButton;
	public void clickexportToExcelButton(WebDriver wd)
	{
		exportToExcelButton.click();
	}
	
	public boolean verifyexportToExcelButton(WebDriver wd)
	{
		return  exportToExcelButton.isDisplayed();
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='buttons']/div[2]/button[2]")
	public WebElement refreshAvailablityButton;
	public void clickrefreshAvailablityButton(WebDriver wd)
	{
		refreshAvailablityButton.click();
	}
	
	public boolean verifyRefreshAvailablityButton(WebDriver wd)
	{
		return refreshAvailablityButton.isDisplayed();
	}
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='buttons']/div[2]/button[3]")
	public WebElement saveToSavedCartsButton;
	public void clicksaveToSavedCartsButton(WebDriver wd)
	{
		saveToSavedCartsButton.click();
	}
	
	public boolean verifySaveToSavedCartsButton(WebDriver wd)
	{
		return saveToSavedCartsButton.isDisplayed();
	}
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='buttons']/div[2]/button[4]")
	public WebElement updatesCartsButton;
	public void clickupdatesCartsButton(WebDriver wd)
	{
		updatesCartsButton.click();
	}
	
	public boolean verifyUpdatesCartsButton(WebDriver wd)
	{
		return updatesCartsButton.isDisplayed();
	}
	
	
	public  boolean verifyCartIsEmpty(WebDriver wd) 
	{
		try 
		{
			if(wd.findElement(By.xpath(".//*[@id='header3']/div/ul/li[2]")).isDisplayed())
			{
				System.out.println("Text present");
				return true;	
			} else 
			{
				System.out.println("Text not present");
				return false;
			}
			
		} catch (Throwable t)
		{
			
		}
		
		return false;	
	}
	
	
	

	public void verfiyCartSummaryHeader(WebDriver wd)
	{

		WebElement quickOrderResultTable=wd.findElement(By.xpath(".//*[@id='shoppingcarttableExt']"));
		List<WebElement> rows=quickOrderResultTable.findElements(By.tagName("tr"));
		
		for (int i=0;i<1;i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("th"));
			for(int j=0;j<cols.size();j++)
			{
			String header=cols.get(j).getText().trim();
			if(header.equals("Select All".trim())||header.equals("Line No.".trim())||header.equals("Part Number".trim())||header.equals("Quantity".trim())||header.equals("Bin Location".trim())||header.equals("Comments".trim())||header.equals("Item Description".trim())||header.equals("Net Price".trim())||header.equals("Line Total / Est. Line Weight".trim()))
			{
				System.out.println(header+" is validated in result table");
			} else 
			{
				System.out.println(header+" is not present in result table");
			}
			}
		}
	}
	
	

	
	@FindBy(how=How.LINK_TEXT,using="Voucher Code Lookup")
	public WebElement VoucherCodeLookupLink;
	public boolean verifyVoucherCodeLookupLink(WebDriver wd)
	{
		return VoucherCodeLookupLink.isDisplayed();
	}
	
	public void clickVoucherCodeLookupLink(WebDriver wd)
	{
		VoucherCodeLookupLink.click();
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[5]/div[1]/span")
	public WebElement VoucherCodeLookupHeader;
	public boolean verifyVoucherCodeLookupHeader(WebDriver wd)
	{
		String header=VoucherCodeLookupHeader.getText();
		if(header.equals("Voucher Code Lookup"))
		{
			return true;
		} else 
		{
			return true;
		}
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[5]/div[2]/table/tbody/tr[1]/td[1]/a")
	public WebElement VoucherCode;
	public void clickVoucherCode(WebDriver wd)
	{
		VoucherCode.click();
		
	}
	
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[4]/div[3]/div[2]/div/div[3]/div[1]/a[1]")
	public WebElement VoucherCodeRemoveLink;
	public void clickVoucherCodeRemoveLink(WebDriver wd)
	{
		VoucherCodeRemoveLink.click();
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='shoppingcarttableExt']/tbody/tr/td[4]/input")
	public WebElement quantity;
	public void enterQuantity(String shoppingQty)
	{
		this.quantity.clear();
		this.quantity.sendKeys(shoppingQty);
	}

	@FindBy(how=How.XPATH,using=".//*[@id='shoppingcarttableExt']/tbody/tr/td[5]/input")
	public WebElement binLocation;
	public void enterBinLocation(String shoppingBinLocation)
	{
		this.binLocation.clear();
		this.binLocation.sendKeys(shoppingBinLocation);
	}

	@FindBy(how=How.XPATH,using=".//*[@id='shoppingcarttableExt']/tbody/tr[1]/td[6]/textarea")
	public WebElement comments;
	public void enterComments(String shoppingComments)
	{
		this.comments.clear();
		this.comments.sendKeys(shoppingComments);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.quantity.errors']")
	public WebElement entries0quantityerrors;
	public void verifyentries0quantityerrors(WebDriver wd)
	{
		String message=this.entries0quantityerrors.getText();
		if (message.equals("Invalid Quantity. Please enter a whole number.")){
			Assert.assertEquals(message, "Invalid Quantity. Please enter a whole number.", "quantity not valid");
		}else if(message.equals("Quantity cannot be longer than 9 numbers.")){
			Assert.assertEquals(message, "Quantity cannot be longer than 9 numbers.", "item not valid");
		//}
		}
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.binLocation.errors']")
	public WebElement entries0binLocationerrors;
	public void Verifyentries0binLocationerrors()
	{
		//System.err.println(itemNumber);.//*[@id='entries2.quantity.errors'] 
		//if(Verifyquantityrentries0.isDisplayed()){
		String message=this.entries0binLocationerrors.getText();
		if (message.equals("Bin location cannot not contain special characters.")){
			Assert.assertEquals(message, "Bin location cannot not contain special characters.", "Invalid");
		}else if(message.equals("Bin location cannot be longer than 6 characters.")){
			Assert.assertEquals(message, "Bin location cannot be longer than 6 characters.", "Invalid");
		//}
		}
	}
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.comments.errors']")
	public WebElement entries0commentserrors;
	public void Verifyentries0commentserrors()
	{
		//System.err.println(itemNumber);.//*[@id='entries2.quantity.errors'] 
		//if(Verifyquantityrentries0.isDisplayed()){
		String message=this.entries0commentserrors.getText();
		if (message.equals("Comments cannot contain special characters.")){
			Assert.assertEquals(message, "Comments cannot contain special characters.", "invalid");
		}else if(message.equals("Comments cannot be longer than 75 characters.")){
			Assert.assertEquals(message, "Comments cannot be longer than 75 characters.", "Invalid");	
		//}
		}
		}
	
	String beforeStockStatu;
	@FindBy(xpath="//div[@id='l_entries0stockStatus']/span")
	public WebElement StockStatusBefore;
	public String  getStockStatusBefore(){
		 beforeStockStatu=StockStatusBefore.getText().trim();
		return beforeStockStatu;
	}
	
	
	@FindBy(id="entries[0].quantity")
	public WebElement quatityEnter;
	public void  enterQantiry(){
		quatityEnter.click();
		
	}
	@FindBy(xpath="//a[contains(text(),'Update Cart')]")
	public WebElement updateCartLink;
	public void  clickUpdateCartLink(){
		 updateCartLink.click();
		
	}
	
	
	
	
	//Duplicate item line verification 
	@FindBy(xpath="//table[@id='shoppingcarttableExt']/tbody")
	WebElement shoppingcartTable;
	String itemNum;
	String qty;
	Map<String ,Integer> dupicatelineitemQty=new HashMap<>();
	public void getLineItemAndQuantity(EventFiringWebDriver wd,Map<String ,Integer> dupicate,String text ) {
		List<WebElement>rowV=shoppingcartTable.findElements(By.tagName("tr"));
		for (int i=1;i<=rowV.size();i++) {
			//List<WebElement>colV=rowV.get(i).findElements(By.tagName("td"));
			WebElement colV=wd.findElement(By.xpath("//table[@id='shoppingcarttableExt']/tbody/tr["+i+"]/td[3]/div/div/span"));
			WebElement colV1=wd.findElement(By.xpath("//table[@id='shoppingcarttableExt']/tbody/tr["+i+"]/td[4]/input"));
			WebElement textMessageEr=wd.findElement(By.xpath("//table[@id='shoppingcarttableExt']/tbody/tr["+i+"]/td[4]/input"));
			System.out.println(colV.getText());
			System.out.println(colV1.getAttribute("value"));
			dupicatelineitemQty.put(colV.getText(), Integer.valueOf(colV1.getAttribute("value")));
			//System.out.println(colV1.getAttribute("value"));
			
		}
		
		
	}
	
	@FindBy(id="checkAll")
	WebElement checkAll;
	@FindBy(xpath="//div[@id='remove_all_section_top']/a")
	WebElement remove_all_section_top;
	
	public void clickRemoveCart(EventFiringWebDriver wd) {
		TestInitializer.scrollIntoViewElement(wd, checkAll);
		checkAll.click();
		remove_all_section_top.click();
	}
	
	
	@FindBy(xpath="//input[contains(@name,'.partNumber')]/preceding-sibling::div/span")
	WebElement itemElem;
	String shopItem;
	public void getItemfromShoppingGrid(EventFiringWebDriver wd) {
		TestInitializer.waitForElement(wd, itemElem);
		shopItem=itemElem.getText();
	}
	@FindBy(xpath="//input[contains(@name,'].quantity')]")
	WebElement itemQtyElem;
	String shopQtyItem;
	public void getItemQtyfromShoppingGrid() {
		shopQtyItem=itemQtyElem.getAttribute("value");
	}
	@FindBy(xpath="//input[contains(@name,'].binLocation')]")
	WebElement itemBinElem;
	String shopBinItem;
	public void getItemBinfromShoppingGrid() {
		shopBinItem=itemBinElem.getAttribute("value");
	}
	@FindBy(xpath="//textarea[contains(@name,'].comments')]")
	WebElement itemCommElem;
	String shopCommItem;
	public void getItemCommfromShoppingGrid() {
		shopCommItem=itemCommElem.getText();
	}
	public void verifyShoppingCartItem(String item){
		try {
			Assert.assertEquals(shopItem, item);
		} catch (Exception e) {
			Assert.fail(" Item Number Not Match");
			e.printStackTrace();
		}
		
	}

	public void verifyShoppingCartItemQty(String itemQty) {
		try {
			Assert.assertEquals(shopQtyItem, itemQty);
		} catch (Exception e) {
			Assert.fail("Quantity Not Match");
			e.printStackTrace();
		}
	}

	public void verifyShoppingCartItemBin(String itemBin) {
		try {
			Assert.assertEquals(shopBinItem, itemBin);
		} catch (Exception e) {
			Assert.fail("Bin Location Not match");
			e.printStackTrace();
		}
	}

	public void verifyShoppingCartItemComments(String itemComm) {
		try {
			Assert.assertEquals(shopCommItem, itemComm);
		} catch (Exception e) {
			Assert.fail("Comments Not Match");
			e.printStackTrace();
		}
	}

	
	//***********************Click Cleared all Shopping cart lines************************/
	@FindBy(xpath="//div[@id='basketitems']/a/span")
	WebElement shoppingCartItemTotal;
	public String getTotalItemLineInShoppingCart() {
		String tot=shoppingCartItemTotal.getText();
		return tot;
	}
	
	public void verifyShoppingCartItemClearing(EventFiringWebDriver wd) {
		TestInitializer.waitForElement(wd, shoppingCartItemTotal);
		String tot=getTotalItemLineInShoppingCart();
		if(!tot.equals("0")) {
			shoppingCartItemTotal.click();
			TestInitializer.waitForElement(wd, itemQtyElem);
			clickRemoveCart(wd);
		}
			
		}
	
}

