package com.doosan.nao.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BatchOrderUploadPage {

	@FindBy(how=How.XPATH,using=".//*[@id='fileInput']")
	public WebElement uploadInputField;
	
	@FindBy(how=How.XPATH,using=".//*[@id='upload-button']")
	public WebElement uploadButton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='upload-button']")
	public WebElement validMessage;
	
	@FindBy(how=How.XPATH,using=".//*[@id='upload-button']")
	public WebElement inValidErrorMessage;
	
	@FindBy(how=How.XPATH,using=".//*[@id='upload-button']")
	public WebElement moreThanExpectedLineMessage;
	
	public void uploadValidfile(String validFile)
	{
		
		uploadInputField.sendKeys(validFile);
	}
	
	public void uploadInValidfile(String InvalidFile)
	{
		
		uploadInputField.sendKeys(InvalidFile);
	}
	
	public void uploadMoreThanExpectedLinefile(String MoreThanExpectedLinefile)
	{
		
		uploadInputField.sendKeys(MoreThanExpectedLinefile);
	}
	
	public void clickUploadButton()
	{
		
		uploadButton.click();	
	}
	
	
}
