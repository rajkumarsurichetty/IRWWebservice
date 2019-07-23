package com.doosan.nao.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.doosan.nao.classOrderTest.PurchaseOrderGenerator;

public class ShipmentAddressPage {

	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div[1]/div/span/h1")
	public WebElement shipingTitle;
	public void verifyShipingTitle(WebDriver wd)
	{

		WebDriverWait waitForShipingTitle=new WebDriverWait(wd, 120);
		waitForShipingTitle.until(ExpectedConditions.textToBePresentInElement(shipingTitle, "Shipping Address"));
	}

	                              
	@FindBy (how=How.ID,using="purchaseOrderInput")
	public WebElement purchaseOrderNo;
	public void purchaseOrderNo(WebDriver wd)
	{
		PurchaseOrderGenerator randomNumberGenerator=new PurchaseOrderGenerator();
		this.purchaseOrderNo.clear();
		this.purchaseOrderNo.sendKeys(randomNumberGenerator.generatePurchareOrder());
	}
	public void inputPurchaseOrderNo(String poNumber)
	{
		//PurchaseOrderGenerator randomNumberGenerator=new PurchaseOrderGenerator();
		this.purchaseOrderNo.clear();
		this.purchaseOrderNo.sendKeys(poNumber);
	}
	@FindBy (how=How.ID,using="purchaseOrder_error")
	public WebElement verifPurchaseOrderError;
	public void VerifyPurchaseOrderError()
	{
		String message=verifPurchaseOrderError.getText();
		if(message.equals("Please enter a Purchase Order # for this order")){
			Assert.assertEquals(message, "Please enter a Purchase Order # for this order", "valid PO");
		}else if (message.equals("Purchase Order # cannot be longer than 35 characters")){
			Assert.assertEquals(message, "Purchase Order # cannot be longer than 35 characters", "valid PO");
		}else if(message.equals("Purchase Order # cannot contain special characters")){
			Assert.assertEquals(message, "Purchase Order # cannot contain special characters", "valid PO");
		}
	}
	
	@FindBy (how=How.ID,using="modelNumberInput")
	public WebElement modelNumberNo;
	public void enterModelNumberNo(String modelNo)
	{
		this.modelNumberNo.clear();
		this.modelNumberNo.sendKeys(modelNo);
	}
	@FindBy (how=How.ID,using="modelNumber_error")
	public WebElement modelNumberError;
	public void verifyModelNumberError( )
	{
		String message=modelNumberError.getText();
		if(message.equals("Please enter a Model Number on Machine Details section")){
			Assert.assertEquals(message, "Please enter a Model Number on Machine Details section", "valid");
		}//else if (message.equals(){}
	}
	
	
	@FindBy (how=How.ID,using="serialNumberInput")
	public WebElement serialNumber;
	public void enterSerialNumber(String serialNumber)
	{
		this.serialNumber.clear();
		this.serialNumber.sendKeys(serialNumber);
	}
	@FindBy (how=How.ID,using="hours_error")
	public WebElement verifySerialNumberError;
	public void verifySerialNumberError( )
	{
		String message=verifySerialNumberError.getText();
		if(verifySerialNumberError.isDisplayed()){
		if(message.equals("Please enter a Serial Number on Machine Details section")){
			Assert.assertEquals(message, "Please enter a Serial Number on Machine Details section", "valid");
		}else if (message.equals("The Serial Number field, on Machine Details section, only accepts alphanumeric")){
			Assert.assertEquals(message, "The Serial Number field, on Machine Details section, only accepts alphanumeric", "valid");
		}
		}
	}
	@FindBy (how=How.ID,using="hours")
	public WebElement hours;
	public void enterHours(String hours)
	{
		this.hours.clear();
		this.hours.sendKeys(hours);
	}
	
	@FindBy (how=How.ID,using="hours_error")
	public WebElement hoursError;
	public void verifyHoursError( )
	{
		String message=hoursError.getText();
		if(message.equals("The Hours field, on Machine Details section, only accepts positive, integers numbers")){
			Assert.assertEquals(message, "The Hours field, on Machine Details section, only accepts positive, integers numbers", "valid");
		}else if (message.equals("Please enter a value for Hours on Machine Details section")){
			
			Assert.assertEquals(message, "Please enter a value for Hours on Machine Details section", "valid");
		}
	}
	
	
	//Primary Shipments methods
	
	@FindBy (how=How.ID,using="primaryShipmentMode")
	public WebElement primaryShipmentMethod;
	
	public void selectPrimaryShipmentMethodByIndex(int mode)
	{
		Select selectMethod=new Select(primaryShipmentMethod);
		selectMethod.selectByIndex(1);
	}
	
	
	public void selectPrimaryShipmentMethod(String mode)
	{
		List<String>opt=new ArrayList<String>();
		Select selectMethod=new Select(primaryShipmentMethod);
		//selectMethod.selectByIndex(1);
		List<WebElement> l=selectMethod.getOptions();
				if(l.size()==1)
				{
					selectMethod.selectByIndex(0);			
				} else
				{
					for(int i=0;i<l.size();i++){
						if(!l.get(i).getText().trim().equals("Please Select")){
							opt.add(l.get(i).getText());}
					}
					System.out.println(opt+ " > "+opt.get(new Random().nextInt(opt.size())));
					selectMethod.selectByVisibleText(opt.get(new Random().nextInt(opt.size())));
					//selectMethod.selectByIndex(1);
				}
		
	}
	
	public void printPrimaryShipmentMethodOptions()
	{List<String>opt=new ArrayList<String>();
		Select selectMethod=new Select(primaryShipmentMethod);
		//selectMethod.selectByIndex(1);
		List<WebElement> l=selectMethod.getOptions();
		List<WebElement> options=selectMethod.getOptions();
		for (int i=0;i<options.size();i++)
		
		{
			System.out.println(options.get(i).getText());	
		}
		
	}
	
	@FindBy (how=How.ID,using="primaryShipmentCarrier")
	public WebElement primaryShipmentCarrier;
	public void selectPrimaryShipmentCarrier(String carrier)
	{
		Select selectMethod=new Select(primaryShipmentCarrier);
		List<String>opt=new ArrayList<String>();
		List<WebElement> l=selectMethod.getOptions();
		//selectMethod.selectByIndex(1);
		//selectMethod.selectByVisibleText(carrier);
		if(l.size()==1)
		{
			selectMethod.selectByIndex(0);			
		} else
		{
			for(int i=0;i<l.size();i++){
				if(!l.get(i).getText().trim().equals("Please Select")){
					opt.add(l.get(i).getText());
					}
					
			}
			System.out.println(opt+ " > "+opt.get(new Random().nextInt(opt.size())));
			selectMethod.selectByVisibleText(opt.get(new Random().nextInt(opt.size())));
			//selectMethod.selectByIndex(1);
		}
	}
	
	public void selectPrimaryShipmentCarrierByIndex(int carrier)
	{
		Select selectMethod=new Select(primaryShipmentCarrier);
		//selectMethod.selectByIndex(1);
		selectMethod.selectByIndex(1);
	}
	
	public void printprimaryShipmentCarrierOptions()
	{
		Select selectMethod=new Select(primaryShipmentCarrier);
		//selectMethod.selectByIndex(1);
		List<WebElement> options=selectMethod.getOptions();
		for (int i=0;i<options.size();i++)
		
		{
			System.out.println(options.get(i).getText());	
		}
		
	}
	
	@FindBy (how=How.ID,using="primaryShipmentPriority")
	public WebElement primaryShipmentPriorty;
	public void selectPrimaryShipmentPriorty(String priority)
	{
		/*Select selectMethod1=new Select(primaryShipmentMethod);
		//selectMethod.selectByIndex(1);
		List<WebElement> l=selectMethod1.getOptions();
		System.err.println(l.size());
				if(l.size()==1)
				{
					System.err.println("primaryShipmentPriorty if");
					Select selectMethod=new Select(primaryShipmentPriorty);
		selectMethod.selectByIndex(1);
		//selectMethod.selectByVisibleText(priority);
		
				} 
				else {
					System.err.println("primaryShipmentPriorty else");
					Select selectMethod=new Select(primaryShipmentPriorty);
		//selectMethod.selectByIndex(1);
		selectMethod.selectByIndex(1);
				}*/
		
		Select selectMethod=new Select(primaryShipmentPriorty);
		List<String>opt=new ArrayList<String>();
		List<WebElement> l=selectMethod.getOptions();
		//selectMethod.selectByIndex(1);
		//selectMethod.selectByVisibleText(carrier);
		if(l.size()==1)
		{
			selectMethod.selectByIndex(0);			
		} else
		{
			for(int i=0;i<l.size();i++){
				if(!l.get(i).getText().trim().equals("Please Select")){
			opt.add(l.get(i).getText());
			}
			}
			System.out.println(opt+ " > "+opt.get(new Random().nextInt(opt.size())));
			selectMethod.selectByVisibleText(opt.get(new Random().nextInt(opt.size())));
			//selectMethod.selectByIndex(1);
		}
	}
	
	public void selectPrimaryShipmentPriortyByIndex(int priority)
	{
		Select selectMethod1=new Select(primaryShipmentMethod);
		selectMethod1.selectByIndex(1);
	}
	public void printPrimaryShipmentPriortyOptions()
	{
		Select selectMethod=new Select(primaryShipmentPriorty);
		//selectMethod.selectByIndex(1);
		List<WebElement> options=selectMethod.getOptions();
		for (int i=0;i<options.size();i++)
		
		{
			System.out.println(options.get(i).getText());	
		}
		
	}
	@FindBy(how=How.ID,using="primaryShipmentMode_error")
	public WebElement verifyPrimaryShipmentModeerror;
	public void verifyprimaryShipmentModeerror(){
		String message=verifyPrimaryShipmentModeerror.getText();
		if(message.equals("Please select Primary Ship Method for this order")){
			Assert.assertEquals(message, "Please select Primary Ship Method for this order", "valid ");
		}
	}
	@FindBy(how=How.ID,using="primaryShipmentMode")
	public WebElement intputPrimaryShipmentMode;
	public void inputPrimaryShipmentMode(String pMode){
		this.intputPrimaryShipmentMode.clear();
		this.intputPrimaryShipmentMode.sendKeys(pMode);
	}
	@FindBy (how=How.ID,using="primaryShipmentCarrier_error")
	public WebElement verifyPrimaryShipmentCarrierError ;
	public void verifyprimaryShipmentCarriererror (){
		String message=verifyPrimaryShipmentCarrierError.getText();
		if(message.equals("Please select carrier of Primary Ship Method for this order")){
			Assert.assertEquals(message, "Please select carrier of Primary Ship Method for this order", "valid ");
		}
	}
	@FindBy(how=How.ID,using="primaryShipmentCarrier")
	public WebElement intputPrimaryShipmentCarrier;
	public void inputPrimaryShipmentCarrier(String pCarrier){
		this.intputPrimaryShipmentCarrier.clear();
		this.intputPrimaryShipmentCarrier.sendKeys(pCarrier);
	}
	@FindBy (how=How.ID,using="primaryShipmentPriority_error")
	public WebElement verifyPrimaryShipmentPriorityError ;
	public void verifyprimaryShipmentPriorityerror (){
		String message=verifyPrimaryShipmentPriorityError.getText();
		if(message.equals("Please select priority of Primary Ship Method for this order")){
			Assert.assertEquals(message, "Please select priority of Primary Ship Method for this order", "valid ");
		}
	}
	
	@FindBy(how=How.ID,using="primaryShipmentPriority")
	public WebElement intputPrimaryShipmentPriority;
	public void inputPrimaryShipmentPriority(String pPriority){
		this.intputPrimaryShipmentPriority.clear();
		this.intputPrimaryShipmentPriority.sendKeys(pPriority);
	}
	@FindBy (how=How.ID,using="additionalContacts_error")
	public WebElement VerifyDdditionalContactsError;
	public void VerifyAdditionalContactsError(){
		String message=VerifyDdditionalContactsError.getText();
		if(message.equals("Additional contacts have not a valid email address")){
			Assert.assertEquals(message, "Additional contacts have not a valid email address", "valid ");
		}
	}
	@FindBy(how=How.ID,using="textarea_instructions")
	public WebElement inputShippingInstructions;
	public void inputShippingInstructions(){
		this.inputShippingInstructions.clear();
		this.inputShippingInstructions.sendKeys("Test%$%");
	}
	@FindBy (how=How.ID,using="instructions_error")
	public WebElement verifyShippingInstructionsError;
	public void verifyShippingInstructionsError(){
		String message=verifyShippingInstructionsError.getText();
		if(message.equals("Shipping instructions cannot contain special characters.")){
			Assert.assertEquals(message, "Shipping instructions cannot contain special characters.", "valid ");
		}
	}
	@FindBy(how=How.ID,using="textarea_additional_contacts")
	public WebElement inputadditionalcontacts;
	public void inputadditionalcontacts(){
		this.inputadditionalcontacts.clear();
		this.inputadditionalcontacts.sendKeys("Test");
	}
		
	//BackOrder shipmentsMethods
	
	@FindBy (how=How.ID,using="backorderShipmentMode")
	public WebElement backOrderShipmentMethod;
	public void selectbackOrderShipmentMethod(String mode)
	{
		Select selectMethod=new Select(backOrderShipmentMethod);
		//selectMethod.selectByIndex(1);
		selectMethod.selectByVisibleText(mode);
	}
	
	public void printbackOrderShipmentMethodOptions()
	{
		Select selectMethod=new Select(backOrderShipmentMethod);
		//selectMethod.selectByIndex(1);
		List<WebElement> options=selectMethod.getOptions();
		for (int i=0;i<options.size();i++)
		
		{
			System.out.println(options.get(i).getText());	
		}
		
	}
	
	@FindBy (how=How.ID,using="backorderShipmentCarrier")
	public WebElement backOrderShipmentCarrier;
	public void selectbackOrderShipmentCarrier(String carrier)
	{
		Select selectMethod=new Select(backOrderShipmentCarrier);
		//selectMethod.selectByIndex(1);
		selectMethod.selectByVisibleText(carrier);
	}
	
	public void printBackOrderShipmentCarrierOptions()
	{
		Select selectMethod=new Select(backOrderShipmentCarrier);
		//selectMethod.selectByIndex(1);
		List<WebElement> options=selectMethod.getOptions();
		for (int i=0;i<options.size();i++)
		
		{
			System.out.println(options.get(i).getText());	
		}
		
	}
	
	@FindBy (how=How.ID,using="backorderShipmentPriority")
	public WebElement backOrderShipmentPriorty;
	public void selectbackOrderShipmentPriorty(String priority)
	{
		Select selectMethod=new Select(backOrderShipmentPriorty);
		//selectMethod.selectByIndex(1);
		selectMethod.selectByVisibleText(priority);
	}
	
	public void printBackOrderShipmentPriortyOptions()
	{
		Select selectMethod=new Select(backOrderShipmentPriorty);
		//selectMethod.selectByIndex(1);
		List<WebElement> options=selectMethod.getOptions();
		for (int i=0;i<options.size();i++)
		
		{
			System.out.println(options.get(i).getText());	
		}
		
	}
	

	
	
	
	
	
	
	
	@FindBy (how=How.ID,using="textarea_instructions")
	public WebElement shippingInstructions;
	public void enterShippingInstructions(String shippingInstructions)
	{
		this.shippingInstructions.clear();
		this.shippingInstructions.sendKeys(shippingInstructions);
	}
	
	

	@FindBy(how=How.ID,using="textarea_additional_contacts")
	public WebElement additionalContacts;
	public void enterAdditionalContacts(String additionalContacts)
	{
		this.additionalContacts.clear();
		this.additionalContacts.sendKeys(additionalContacts);
	}
	
	
	@FindBy(how=How.ID,using="buttonContinue")
	public WebElement continueButton;
	public void clickContinueButton()
	{
		this.continueButton.click();
	}
	

	@FindBy(how=How.XPATH,using="html/body/div[2]/div[2]/div[1]/form/div[4]/div[1]/h2")
	public WebElement shipmentsOptionsText;
	public boolean verifyShipmentsOptionsText()
	{
		return shipmentsOptionsText.isDisplayed();
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[2]/div[1]/form/div[5]/div[1]/h3")
	public WebElement ShipToAddressText;
	public boolean verifyShipToAddressText()
	{
		return ShipToAddressText.isDisplayed();
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[2]/div[1]/form/div[6]/div[1]/h3")
	public WebElement InvoiceAddressText;
	public boolean verifyInvoiceAddressText()
	{
		return InvoiceAddressText.isDisplayed();
	}
	
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[2]/div[1]/form/div[7]/div[1]/h3")
	public WebElement CustomerContactsText;
	public boolean verifyCustomerContactsText()
	{
		return CustomerContactsText.isDisplayed();
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[2]/div[1]/form/div[8]/div[2]/a")
	public WebElement BackToCartButton;
	public void clickBackToCartButton()
	{
		 BackToCartButton.click();
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr/td[2]/a/font")
	public WebElement CancelCheckOutLink;
	public void clickCancelCheckOutLink()
	{
		CancelCheckOutLink.click();
	}
	
	
	
}
