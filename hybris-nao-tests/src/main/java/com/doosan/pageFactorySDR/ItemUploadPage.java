package com.doosan.pageFactorySDR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ItemUploadPage {

	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/div/div/div/h1")
	public static WebElement itemUPloadText;
	public void verifyItemUPloadText()
	{
		String ItemUPloadText=itemUPloadText.getText();
		if(ItemUPloadText.trim().equals("Item Upload".trim()))
		{
		System.out.println("");	
		}
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/ul[1]/li[2]/a[1]")
	public static WebElement ExcelTemplateLink;
	public void clickExcelTemplateLink()
	{
		ExcelTemplateLink.click();
	}

	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/ul[1]/li[2]/a[2]")
	public static WebElement CSVTemplateLink;
	public void clickCSVTemplateLink()
	{
		CSVTemplateLink.click();
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/form/div[2]/div[1]/input")
	public static WebElement fileUploadInputBox;
	public void enterFileInFileUploadInputBox(String file)
	{
		fileUploadInputBox.sendKeys(file);
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/form/div[2]/div[5]/span/button")
	public static WebElement uploadButton;
	public void clickUploadButton()
	{
		uploadButton.click();
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/ul[2]/li[1]/a")
	public static WebElement backToCreateNewClaimButton;
	public void clickBackToCreateNewClaimButton()
	{
		backToCreateNewClaimButton.click();
	}
	
	@FindBy (how=How.XPATH,using="html/body/div[2]/div[2]/ul[2]/li[2]/a")
	public static WebElement enterPartsManually;
	public void clickEnterPartsManually()
	{
		enterPartsManually.click();
	}
	
	@FindBy (how=How.LINK_TEXT,using="Cancel Claim")
	public static WebElement cancelClaimLinkInItemUpload;
	public void clickCancelClaimLinkInItemUpload()
	{
		cancelClaimLinkInItemUpload.click();
	}
	
	
}
