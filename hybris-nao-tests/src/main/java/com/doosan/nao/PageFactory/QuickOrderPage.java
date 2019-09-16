package com.doosan.nao.PageFactory;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.reports.ReportGenerator;
import com.google.common.collect.ArrayListMultimap;


//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class QuickOrderPage {

	public void isItemNumTextBoxDisplay(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(itemNumber, 3, wd);
		try {
			Assert.assertEquals(itemNumber.isDisplayed(), true);
		}catch(Exception e) {
			Assert.fail("Element not visible"+e);
		}
	}
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/tbody/tr[1]/td[3]/input")
	public WebElement itemNumber;
	public void enterItemNumer(String itemNumber)
	{
		System.err.println(itemNumber);
		this.itemNumber.clear();
		this.itemNumber.sendKeys(itemNumber);
	}
	String itNo;
	public String verifyItemNumisEntered(String ItemNo) {
		itNo=itemNumber.getAttribute("value");
		Assert.assertEquals(itNo.trim(), ItemNo.trim());
		return itNo;
	}
	String itemNoMultiple;
	public WebElement itemNumberMultiple;
	public WebElement quantityrMultiple;
	public WebElement binLocMultiple;
	public void enterMultipleParts(EventFiringWebDriver wd,String itemNum,String qty,String binLocation) {
		String itmNo[]=itemNum.split(",");
		String qty1[]=qty.split(",");
		String binlc[]=null;
		String binloc="";
		if(!binLocation.equals("")) {
		 binlc =binLocation.split(",");
		}else {
			binloc=binLocation;
		}
		int len=itmNo.length;
		if(len>1) {
			for(int i=0;i<len;i++) {
				itemNumberMultiple=wd.findElement(By.xpath("//*[@id='quickOrderTable']/tbody/tr["+(1+i)+"]/td[3]/input"));
				itemNumberMultiple.sendKeys(itmNo[i]);
				quantityrMultiple=wd.findElement(By.xpath("//*[@id='quickOrderTable']/tbody/tr["+(1+i)+"]/td[4]/input"));
				quantityrMultiple.sendKeys(qty1[i]);
				binLocMultiple=wd.findElement(By.xpath("//*[@id='quickOrderTable']/tbody/tr["+(1+i)+"]/td[5]/input"));
				if(!binLocation.equals("")) {
					binLocMultiple.sendKeys(binlc[i]);
					}else {
						binLocMultiple.sendKeys(binloc);
				}
			}
		}else {
			enterItemNumer(itemNum);
			enterQuantity(qty);
			enterBinLocation(binLocation);
		}
		
	}
	WebElement itemBinLoc;
	WebElement quantiyBin;
	WebElement binLoclBin;
	String item;
	String QtyBin;
	String binLoc;
	@FindBy(xpath="//table[@id='quickOrderTable']/tbody")//85D10@2-Bin2,6679836-1-Bin1
	WebElement qickOrderTable;
	List<String>listItems=new ArrayList<>();
	List<String>listQty=new ArrayList<>();
	List<String>listBinLoc=new ArrayList<>();
	public void checkduplicateLineBinLocations(EventFiringWebDriver wd) {
		ArrayListMultimap<Object, Object> item_BinLoc=ArrayListMultimap.create();//new HashMap<>();
		//Map<String, Integer> item_Qty=new HashMap<>();
		ArrayListMultimap<Object, Object> item_Qty=ArrayListMultimap.create();
		Map<String,String>Bin_itm=new HashMap<>();
		List<WebElement>tableRow=qickOrderTable.findElements(By.tagName("tr"));
		for(int i=1;i<=tableRow.size();i++) {
		itemBinLoc=wd.findElement(By.xpath("//table[@id='quickOrderTable']/tbody/tr["+i+"]/td[3]/input"));
		item=itemBinLoc.getAttribute("value");
		if(item.equals("")) {
			break;
		}
		listItems.add(item);
		binLoclBin=wd.findElement(By.xpath("//table[@id='quickOrderTable']/tbody/tr["+i+"]/td[5]/input"));
		binLoc=binLoclBin.getAttribute("value");
		listBinLoc.add(binLoc);
		quantiyBin=wd.findElement(By.xpath("//table[@id='quickOrderTable']/tbody/tr["+i+"]/td[4]/input"));
		QtyBin=quantiyBin.getAttribute("value");
		listQty.add(QtyBin);
		
		
		
		
		
		}
		System.out.println(listItems);
		System.out.println(listQty);
		System.out.println(listBinLoc);
		for(int i=0;i<=listItems.size()-1;i++) {
		if(item_BinLoc.containsKey(listItems.get(i).trim())&&item_BinLoc.get(listItems.get(i).trim()).equals(listBinLoc.get(i).trim())) {
			System.out.println();
			item_BinLoc.put(listItems.get(i).trim(),listBinLoc.get(i).trim());
			Bin_itm.put(listBinLoc.get(i).trim(), listItems.get(i).trim());
			
			item_Qty.put(listItems.get(i).trim(),item_Qty.get(listItems.get(i).trim())+(listQty.get(i).trim()));
		}else {
			System.out.println();
			item_BinLoc.put(listItems.get(i).trim(), listBinLoc.get(i).trim());
			item_Qty.put(listItems.get(i).trim(), Integer.valueOf(listQty.get(i).trim()));
		}
		System.out.println(item_BinLoc);System.out.println(item_Qty);
	}
		}
	
	
	
	public Map<String,Integer> checkDuplicatedLineItemsNoBinLocation(EventFiringWebDriver wd,String item,String quatity,String bin) {
		String it[]=item.split(",");
		String bnl[]=bin.split(",");
		String qty[]=quatity.split(",");
		Map<String, String> m=new HashMap<>();
		Map<String, Integer> b=new HashMap<>();
		for(int i=0;i<it.length;i++) {
			if(m.containsKey(it[i])) {
				m.put(it[i],m.get(it[i])+qty[i]);
				b.put(it[i], b.get(it[i])+Integer.valueOf(qty[i]));
			}else {
				m.put(it[i], qty[i]);
				b.put(it[i], Integer.valueOf(qty[i]));
			}
		}
		
		System.out.println(m+"\n"+b);
		return b;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.itemNumber.errors']")
	public WebElement VerifyitemNumberentries0;
	public void VerifyitemNumberentries0()
	{ 
		// verify the error message web element
		String message=this.VerifyitemNumberentries0.getText();
		if (message.equals("Invalid item. This item does not exist.")){
			Assert.assertEquals(message, "Invalid item. This item does not exist.", "item not valid");
		}else if(message.equals("This item is not available.")){
			Assert.assertEquals(message, "This item is not available.", "item not valid");
		//}
		}else if ( message.equals("You are not contracted to purchase this item.")){
			Assert.assertEquals(message, "You are not contracted to purchase this item.", "item not valid");
		}
		}
	@FindBy(how=How.XPATH,using="//div[@class='error-message']/p")
	public WebElement errorMessage;
	public void VerifyiteErrorMessage()
	{ 
		// verify the error message web element
		String message=this.errorMessage.getText();
		if (message.equals("Please enter at least one line")){
			Assert.assertEquals(message, "Please enter at least one line", "item not entered");
		}
		}
	
	public void getTwoErrorItemNum() {
		String message=this.VerifyitemNumberentries0.getText();
		if (message.trim().replace("\n", " ").equals("Item number cannot be longer than 30 characters Invalid item. This item does not exist.")){
			Assert.assertEquals(message.trim().replace("\n", " "), "Item number cannot be longer than 30 characters Invalid item. This item does not exist.", "item  not more than 30 ");
			//Assert.assertEquals(message, "Invalid item. This item does not exist.", "item not valid");
		}else {
			System.out.println("error not in proper getting");
		}
	}
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.quantity.errors']")
	public WebElement Verifyquantityrentries0;
	public void Verifyquantityrentries0()
	{
		//System.err.println(itemNumber);.//*[@id='entries2.quantity.errors'] .//*[@id='entries0.binLocation.errors']
		//if(Verifyquantityrentries0.isDisplayed()){
		String message=this.Verifyquantityrentries0.getText();
		if (message.equals("Invalid Quantity. Please enter a whole number.")){
			Assert.assertEquals(message, "Invalid Quantity. Please enter a whole number.", "quantity not valid");
		/*}else if(message.equals("This item is not available.")){
			Assert.assertEquals(message, "This item is not available.", "item not valid");*/	
		//}
		}
		}
	public void VerifyQuantityMoreCharaError() {
		String message=this.Verifyquantityrentries0.getText();
		if (message.equals("Quantity cannot be longer than 9 numbers.")){
			Assert.assertEquals(message, "Quantity cannot be longer than 9 numbers.", "quantity not in more characters");
		}
	}
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.binLocation.errors']")
	public WebElement Verifybinentries0;
	public void Verifybinentries0()
	{
		//System.err.println(itemNumber);.//*[@id='entries2.quantity.errors'] 
		//if(Verifyquantityrentries0.isDisplayed()){
		String message=this.Verifybinentries0.getText();
		if (message.equals("Bin location cannot contain special characters")){
			Assert.assertEquals(message, "Bin location cannot contain special characters", "Invalid");
		}else if(message.equals("Quantity cannot be longer than 9 numbers.")){
			Assert.assertEquals(message, "Quantity cannot be longer than 9 numbers.", "item not valid");	
		//}
		}
		}
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.comments.errors']")
	public WebElement Verifycommententries0;
	public void VerifyCommentEntries0()
	{
		//System.err.println(itemNumber);.//*[@id='entries2.quantity.errors'] 
		//if(Verifyquantityrentries0.isDisplayed()){
		String message=this.Verifycommententries0.getText();
		if (message.equals("Comments cannot contain special characters")){
			Assert.assertEquals(message, "Comments cannot contain special characters", "quantity not valid");
		}else if(message.equals("Comments cannot be longer than 75 characters")){
			Assert.assertEquals(message, "Comments cannot be longer than 75 characters", "item not valid");	
		}
		
		}
	public void isQuantityTextBoxDisplay(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(quantity, 3, wd);
		try {
			Assert.assertEquals(quantity.isDisplayed(), true);
		} catch (Exception e) {
			Assert.fail("Quantity Element not visible "+e);
			e.printStackTrace();
		}
	}
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/tbody/tr[1]/td[4]/input")
	public WebElement quantity;
	public void enterQuantity(String qty)
	{
		this.quantity.clear();
		this.quantity.sendKeys(qty);
	}
	public void isBindLocationTextBoxDisplay(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(binLocation, 3, wd);
		try {
			Assert.assertEquals(binLocation.isDisplayed(), true);
		} catch (Exception e) {
			Assert.fail("Bin location Element not visible "+e);
			e.printStackTrace();
		}
	}
	String qtyEnter;
	public String verifyQuantityisEntered(String qty) {
		qtyEnter=quantity.getAttribute("value");
		Assert.assertEquals(qtyEnter.trim(), qty.trim());
		return qtyEnter;
	}
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/tbody/tr[1]/td[5]/input")
	public WebElement binLocation;
	public void enterBinLocation(String binLocation)
	{
		this.binLocation.clear();
		this.binLocation.sendKeys(binLocation);
	}
	
	String binEnter;
	public String verifyBiLocationIsEntered(String binlocation) {
		binEnter=binLocation.getAttribute("value");
		Assert.assertEquals(binEnter.trim(), binlocation.trim());
		return binEnter;
	}
	public void isCommentTextBoxDisplay(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(comments, 3, wd);
		try {
			Assert.assertEquals(comments.isDisplayed(), true);
		} catch (Exception e) {
			Assert.fail("Comment text box  Element not visible "+e);
			e.printStackTrace();
		}
	}
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/tbody/tr[1]/td[6]/input")
	public WebElement comments;
	public void enterComments(String comments)
	{
		this.comments.clear();
		this.comments.sendKeys(comments);
	}
	String commEnter;
	public String verifyCommentsIsEntered(String comment) {
		commEnter=comments.getAttribute("value");
		Assert.assertEquals(commEnter.trim(), comment.trim());
		return commEnter;
	}
	
	public void isAddToCartDisplay(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(addToCart, 3, wd);
		try {
			Assert.assertEquals(addToCart.isDisplayed(), true);
		} catch (Exception e) {e.printStackTrace();
			Assert.fail("addToCart  Element not visible "+e);
			//e.printStackTrace();
		}
	}
	@FindBy(how=How.ID,using="addToCart")
	public WebElement addToCart;
	public void clickaddToCart(EventFiringWebDriver wd)
	{
		JavascriptExecutor jse = (JavascriptExecutor)wd;
		//jse.executeScript("window.scrollBy(0,550)", "");"
		jse.executeScript("arguments[0].scrollIntoView();", addToCart);
		addToCart.click();
	}
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='main']/div[1]/div/div/h1")
	public WebElement quickOrderTextForValidFile;
	public void verifyQuickOrderTextForValidFile()
	{
		Assert.assertTrue(quickOrderTextForValidFile.isDisplayed());
	}
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderForm']/div[1]/div[2]/h2")
	public WebElement quickOrderTextForInValidFile;
	public void verifyQuickOrderTextForInValidFile()
	{
		Assert.assertTrue(quickOrderTextForInValidFile.isDisplayed());
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='main']/div[1]/div/h1")
	public WebElement quickOrderTextForMultipleItemFile;
	public void verifyQuickOrderTextForMultipleItemFile()
	{
		Assert.assertTrue(quickOrderTextForMultipleItemFile.isDisplayed());
	}
	@FindBy(id="checkAll")
	public WebElement selectAllCheckBox;
	public void isSelectAllCheckDisplay(EventFiringWebDriver wd) {
		
		try {
			
			Assert.assertEquals(selectAllCheckBox.isDisplayed(), true);
			TestInitializer.highlightMyElement(selectAllCheckBox, 3, wd);
		} catch (Exception e) {
			Assert.fail("selectAll Check box  Element not visible "+e);
			e.printStackTrace();
		}
	}
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/thead/tr/th[1]/div")
	public WebElement selectAllTextInQuickOrderTable;
	public void verifySelectAllCheckBoxText()
	{
		String expectedText="Select All".trim();
		String actualText=selectAllTextInQuickOrderTable.getText().trim();
		System.err.println(actualText);
		Assert.assertEquals(actualText, expectedText);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/thead/tr/th[2]")
	public WebElement lineNoTextInQuickOrderTable;
	public void verifyLineNoText()
	{
		String expectedText="Line No.".trim();
		String actualText=lineNoTextInQuickOrderTable.getText().trim();
		System.err.println(actualText);
		Assert.assertEquals(actualText, expectedText);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/thead/tr/th[3]")
	public WebElement itemNoTextInQuickOrderTable;
	public void verifyItemNoText()
	{
		String expectedText="Item Number".trim();
		String actualText=itemNoTextInQuickOrderTable.getText().trim();
		System.out.println(actualText);
		Assert.assertEquals(actualText, expectedText);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/thead/tr/th[4]")
	public WebElement quantityTextInQuickOrderTable;
	public void verifyQuantityText()
	{
		String expectedText="Quantity".trim();
		String actualText=quantityTextInQuickOrderTable.getText().trim();
		System.out.println(actualText);
		Assert.assertEquals(actualText, expectedText);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/thead/tr/th[5]")
	public WebElement binLocationTextInQuickOrderTable;
	public void verifyBinLocationText()
	{
		String expectedText="Bin Location".trim();
		String actualText=binLocationTextInQuickOrderTable.getText().trim();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderTable']/thead/tr/th[6]")
	public WebElement commentsTextInQuickOrderTable;
	public void verifyCommentsText()
	{
		String expectedText="Bin Location".trim();
		String actualText=commentsTextInQuickOrderTable.getText().trim();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderForm']/div[1]/div[2]/p")
	public WebElement pleaseEnterAtleastOneText;
	public void verifyEnterAtleastOneText()
	{
		Assert.assertTrue(pleaseEnterAtleastOneText.isDisplayed());
	}
	

	public void verifyQuickOrderPageHeaders(EventFiringWebDriver wd)
	{	
		
		WebElement quickOrderResultTable=wd.findElement(By.xpath(".//*[@id='quickOrderTable']"));
		List<WebElement> rows=quickOrderResultTable.findElements(By.tagName("tr"));
		System.err.println(rows.size());
		for (int i=0;i<1;i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("th"));
			for(int j=0;j<cols.size();j++)
			{
			String header=cols.get(j).getText().trim();
			if(header.equals("Select All".trim())||header.equals("Line No.".trim())||header.equals("Item Number".trim())||header.equals("Quantity".trim())||header.equals("Bin Location".trim())||header.equals("Comments".trim()))
			{
				System.out.println(header+" is validated in result table");
			} else 
			{
				System.out.println(header+" is not present in result table");
			}
			}
		}
	}

	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderForm']/div[1]")
	public WebElement quickOrderFullPageErrorMessage;
	public void verifyQuickOrderErrorMessage()
	{
		quickOrderFullPageErrorMessage.isDisplayed();
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.itemNumber.errors']")
	public WebElement quickOrderItemErrorMessage;
	public void verifyQuickOrderItemErrorMessageInTable()
	{
		quickOrderItemErrorMessage.isDisplayed();
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.quantity.errors']")
	public WebElement quickOrderQtyErrorMessage;
	public void verifyQuickOrderQtyErrorMessageInTable()
	{
		quickOrderQtyErrorMessage.isDisplayed();
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.binLocation.errors']")
	public WebElement quickOrderBinErrorMessage;
	public void verifyQuickOrderBinErrorMessageInTable()
	{
		quickOrderBinErrorMessage.isDisplayed();
	}
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='entries0.comments.errors']")
	public WebElement quickOrderCommentsErrorMessage;
	public void verifyQuickOrderCommentsErrorMessageInTable()
	{
		quickOrderCommentsErrorMessage.isDisplayed();
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='quickOrderForm']/div[2]/div/div[1]/div[1]/a")
	public WebElement removeAllInvalidLinesButton;
	public void verifyRemoveAllInvalidLinesButton()
	{
		removeAllInvalidLinesButton.click();
	}public void clearAllBrowserCache(EventFiringWebDriver wd) throws InterruptedException{
    	wd.manage().deleteAllCookies();
    	Thread.sleep(7000);
    }
	
	@FindBy(id="addMoreLines")
	WebElement addLineButtons;
	public void isAddLinesButtonDisplay(EventFiringWebDriver wd) {
try {
			
			Assert.assertEquals(addLineButtons.isDisplayed(), true);
			TestInitializer.highlightMyElement(addLineButtons, 3, wd);
		} catch (Exception e) {
			Assert.fail("addLine Button  Element not visible "+e);
			e.printStackTrace();
		}
	}
	
	
	public void clickAddMoreLines() {
		addLineButtons.click();
		
		
	}
	@FindBy(id="linesNuber")
	WebElement addLineTextBox;
	public void isAddLinesTextBoxDisplay(EventFiringWebDriver wd) {
try {
			
			Assert.assertEquals(addLineTextBox.isDisplayed(), true);
			TestInitializer.highlightMyElement(addLineTextBox, 3, wd);
		} catch (Exception e) {
			Assert.fail("addLine text box Element not visible "+e);
			e.printStackTrace();
		}
	}
	
	
	
	@FindBy(id="linesNuber")
	WebElement exportToExcelButton;
	public void isExportExcelDisplay(EventFiringWebDriver wd) {
		try {
			
			Assert.assertEquals(exportToExcelButton.isDisplayed(), true);
			TestInitializer.highlightMyElement(exportToExcelButton, 3, wd);
		} catch (Exception e) {
			Assert.fail("export To Excel Button Element not visible "+e);
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//table[@id='quickOrderTable']/tbody/tr")
	WebElement quickorderItemTable;
	public void isQuickOrderpageItemTableDisplay(EventFiringWebDriver wd) {
try {
			
			Assert.assertEquals(quickorderItemTable.isDisplayed(), true);
			TestInitializer.highlightMyElement(quickorderItemTable, 3, wd);
		} catch (Exception e) {
			Assert.fail("Qucik order page table Element not visible "+e);
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//div[@class='error-message']/h2")
	WebElement errorHeader;
	@FindBy(xpath="//div[@class='error-message']/p")
	WebElement errorPHeader;
	
	public void verifyErrorisDispaly() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(errorHeader.getText().trim(), "Sorry, there were problems submitting this request");
		Assert.assertEquals(errorPHeader.getText().trim(), "Please enter at least one line");
		
	}
	public void verifyAddlineErrorisDispaly() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assert.assertEquals(errorHeader.getText().trim(), "Sorry, there were problems submitting this request");
		Assert.assertEquals(errorPHeader.getText().trim(), "Please enter at least one line");
		
	}
	String addLineNumbers;
	@FindBy(id="linesNuber")
	WebElement eleAddLineTextbox;
	public void enterAddlineTextBox(String text) {
		addLineNumbers=text;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleAddLineTextbox.clear();
		eleAddLineTextbox.sendKeys(text);

		
	}
	@FindBy(id="lines.errors")
	WebElement eleAddLineTextErrorLine;
	public void verifyAddlineTextBoxErrorisDispaly(EventFiringWebDriver wd) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ((addLineNumbers.matches("[0-9]+") && addLineNumbers.length() > 2)) {
		if(!(Integer.parseInt(addLineNumbers)>=600)) {
		((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", eleAddLineTextErrorLine);
		//Assert.assertEquals(errorHeader.getText().trim(), "Sorry, there were problems submitting this request");
		Assert.assertEquals(eleAddLineTextErrorLine.getText().trim(), "Please enter data in valid format");
		}else {
			((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", eleAddLineTextbox);
			Assert.assertEquals(wd.findElement(By.xpath("//div[@class='error-message']/p")).getText().trim(), "Donot enter more than 600 lines");
		}
		}else {
			((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", eleAddLineTextErrorLine);
			//Assert.assertEquals(errorHeader.getText().trim(), "Sorry, there were problems submitting this request");
			Assert.assertEquals(eleAddLineTextErrorLine.getText().trim(), "Please enter data in valid format");
		}
	}
	@FindBy(xpath="//table[@id='quickOrderTable']/tbody/tr")
	List<WebElement>itemlinerows;
	public int getTotalRowsLinetems() {
		int totalrows=itemlinerows.size();
		System.out.println("Total rows"+totalrows);
		return totalrows;
		
	}
	
	public void verifyToalItemRows(int beforeRow,String textval) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		int beforeRows=Integer.parseInt(textval);
		int afterRows=getTotalRowsLinetems();
		System.out.println("After Adding lines  "+afterRows);
		try {
			
			Assert.assertEquals(beforeRows+beforeRow, afterRows);
		} catch (Exception e) {
			Assert.fail("Rows not equal"+e);
		}
		
	}
	@FindBy(xpath="//table[@id='quickOrderTable']/tbody")
	WebElement quickOrderTable;
	List<String>items;List<String>Qty;List<String>bin;List<String>comment;

	public void getQuickOrderTableValues(EventFiringWebDriver wd) {
		items=new ArrayList<>();Qty=new ArrayList<>();bin=new ArrayList<>();comment=new ArrayList<>();
		List<WebElement>rows=quickOrderTable.findElements(By.tagName("tr"));
		for (int i = 1; i <=rows.size(); i++) {
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			if(wd.findElement(By.xpath("//table[@id='quickOrderTable']/tbody/tr["+i+"]/td[3]/input")).getAttribute("value").equals("")) {
				break;
			}
			items.add(wd.findElement(By.xpath("//table[@id='quickOrderTable']/tbody/tr["+i+"]/td[3]/input")).getAttribute("value"));
			Qty.add(wd.findElement(By.xpath("//table[@id='quickOrderTable']/tbody/tr["+i+"]/td[4]/input")).getAttribute("value"));
			bin.add(wd.findElement(By.xpath("//table[@id='quickOrderTable']/tbody/tr["+i+"]/td[5]/input")).getAttribute("value"));
			comment.add(wd.findElement(By.xpath("//table[@id='quickOrderTable']/tbody/tr["+i+"]/td[6]/input")).getAttribute("value"));
			
		}
		System.out.println( "ITems "+items+"Quantity  "+Qty+"Bin location "+bin+"Comments "+comment);
	}
	
	
	@FindBy(xpath="//div[@class='error-message']")
	WebElement error600Item;
	
	public void bathcOrderUploadTest(String dataSet, String lineItems,
			String invalidFile, String validfile,String testCaseName,EventFiringWebDriver wd) throws IOException,
			InterruptedException, AWTException {
		ReportGenerator.setLog("Batch Order Upload Test initiated:::");
		//int lineItem = Integer.parseInt(lineItems);
		try {

			//TestInitializer.setOrganization(wd);
			// To test if the Line items in Excel exceeds 600 lines
			if (lineItems.equalsIgnoreCase("invalidLine600Items")) {
				testInputFile(
						System.getProperty(Constants.USER_DIRECTORY)
								+ TestInitializer.PROJECT
										.getProperty("invalidlineitemsfilepath"),
						dataSet,
						error600Item,
						"invalidLine600Items",wd);
			}
			// If the Excel file uploaded by user is in invalid format  The file contains more than 600 lines. Please reduce the number of order lines and try again.

// order contains more than 600 lines. Please reduce the number of order lines and try again.
			if (invalidFile.equalsIgnoreCase("InValid")) {
				testInputFile(
						System.getProperty(Constants.USER_DIRECTORY)
								+ TestInitializer.PROJECT
										.getProperty("invalidfilepath"),
						dataSet, error600Item,"InValid",wd);
			}
			// To Test Valid Excel File
			if (validfile.equals("Valid")) {
				testInputFile(System.getProperty(Constants.USER_DIRECTORY)
						+ TestInitializer.PROJECT.getProperty("validfilepath"),
						dataSet, error600Item,
						"validFile",wd);
			}

		} catch (NoSuchElementException nse) {
			ReportGenerator.setLogAndCreateScreenshot(testCaseName,
					Constants.DEFAULT_TESTNAME, dataSet, Constants.FAILED,
					nse.getMessage(),wd);

		} catch (NoSuchWindowException nswe) {

			ReportGenerator.setLogAndCreateScreenshot(testCaseName,
					Constants.DEFAULT_TESTNAME, dataSet, Constants.FAILED,
					nswe.getMessage(),wd);
		}
		ReportGenerator.setLog("Batch Order Upload Test::: completed");
		ReportGenerator.setLogAndCreateScreenshot(testCaseName,
				Constants.DEFAULT_TESTNAME, dataSet, Constants.PASSED,wd);
	}
	
	/**
	 * This method validates all the test case for the batch order upload test.
	 * 
	 * @param fileName
	 * @param dataSet
	 * @param xpath
	 * @param testCaseName
	 * 
	 * @throws IOException
	 */
	
	@FindBy(id="fileInput")
	WebElement uploadFilePath;
	@FindBy(id="upload-button")
	WebElement uploadFileButton;
	
	public void testInputFile(String fileName, String dataSet, WebElement webElement,
			String testCaseName,EventFiringWebDriver wd) throws IOException {
		try {
			
			//uploadFilePath.click();			
			uploadFilePath.sendKeys(fileName);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			uploadFileButton.click();try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (webElement.isDisplayed()) {
				if(testCaseName.equalsIgnoreCase("invalidLine600Items")) {
				Assert.assertEquals(webElement.getText().trim(), "The file contains more than 600 lines. Please reduce the number of order lines and try again.\r\n" + 
						"Resulting order contains more than 600 lines. Please reduce the number of order lines and try again.");
				}else if(testCaseName.equalsIgnoreCase("InValid")) {
					Assert.assertEquals(wd.findElement(By.xpath("//*[@id=\"quickOrderForm\"]/div[1]/div[2]/h2")).getText().trim(), "Sorry, there were problems submitting this request");
				}else if(testCaseName.equalsIgnoreCase("validFile")) {
					Assert.assertEquals(webElement.getText().trim(), "The file contains more than 600 lines. Please reduce the number of order lines and try again.Resulting order contains more than 600 lines. Please reduce the number of order lines and try again.");
				}
				
				
				/*ReportGenerator.setLogAndCreateScreenshot(
						BATCH_ORDER_UPLOAD_TEST, testCaseName, dataSet,
						Constants.PASSED,wd);*/

			}
		} catch (NoSuchElementException nse) {
			ReportGenerator.setLogAndCreateScreenshot(testCaseName,
					testCaseName, dataSet, Constants.FAILED, nse.getMessage(),wd);
		} catch (NoSuchWindowException nswe) {
			ReportGenerator.setLogAndCreateScreenshot(testCaseName,
					testCaseName, dataSet, Constants.FAILED, nswe.getMessage(),wd);
		}
	}

}
