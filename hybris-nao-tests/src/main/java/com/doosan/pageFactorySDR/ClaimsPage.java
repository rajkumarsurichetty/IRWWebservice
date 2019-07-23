package com.doosan.pageFactorySDR;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class ClaimsPage {

	public static String sdrCodeSheet="SDR-reason-code.xlsx";
	@FindBy (how=How.XPATH,using=".//*[@id='formEntries0.selected1']")
	public static WebElement individualLineCheckBox;
	public void clickIndividualLineCheckBox()
	{
		individualLineCheckBox.click();
	}
	
	@FindBy (how=How.XPATH,using=".//*[@id='id0']/td[2]/div[2]")
	public static WebElement lineNoText;
	public void getLineNoText()
	{
		String LineNoText=lineNoText.getText();
	}
	
	@FindBy (how=How.XPATH,using=".//*[@id='id0']/td[3]")
	public static WebElement partNoText;
	public void getPartNoText()
	{
		String LineNoText=partNoText.getText();
	}

	@FindBy (how=How.XPATH,using=".//*[@id='id0']/td[7]/input")
	public static WebElement claimQuantity;
	public void enterClaimQuantity(String claimQty)
	{
		claimQuantity.sendKeys(claimQty);
	}
	
	@FindBy (how=How.XPATH,using=".//*[@id='id0']/td[8]/select")
	public static WebElement requesReasonDropdown;
	
	@FindBy (how=How.XPATH,using=".//*[@id='claimDetailsTable']/tbody/tr[3]/td[2]/div[1]/div[1]")
	public static WebElement carrierDamagedPart;
	
	@FindBy (how=How.XPATH,using=".//*[@id='claimDetailsTable']/tbody/tr[3]/td[2]/div[2]/div[1]")
	public static WebElement pictureBeenAttachedToClaim;
	
	public void verifyDamagedRequest(EventFiringWebDriver wd, String option)
	{
		selectReasonCodeDropdown(requesReasonDropdown, option);
		String carrierDamagedPart=this.carrierDamagedPart.getText();
		String pictureBeenAttachedToClaim=this.pictureBeenAttachedToClaim.getText();
	}

	public void selectReasonCodeDropdown(WebElement dropdown, String option)
	{
		Select sel=new Select(dropdown);
		sel.selectByVisibleText(option);
	}

	public void verifyReasonCodeInExcel(String firstQuestion, String SecondQuestion) throws IOException
	{
		boolean isFirstQuestionAvailable=false;
		boolean isSecondQuestionAvailable=false;
		XSSFWorkbook workbook=new XSSFWorkbook(ClassLoader.getSystemClassLoader().getResourceAsStream(sdrCodeSheet));
		XSSFSheet sheet=workbook.getSheet("Questions");
		int row=sheet.getLastRowNum();
		int col=sheet.getRow(1).getLastCellNum();
		for (int rownum=0;rownum<row;rownum++)
		{
				String data=sheet.getRow(rownum).getCell(1).getStringCellValue();
				if(firstQuestion.equals(data))
				{
					isFirstQuestionAvailable=true;
				}
				if(SecondQuestion.equals(data))
				{
					isSecondQuestionAvailable=true;
				}
				
				if(isFirstQuestionAvailable)
				{
					System.out.println(firstQuestion+" :  "+ "is present");
				}				
		}
	}

	public void verifyReasonCodeInExcel(String firstQuestion, String SecondQuestion, String ThirdQuestion)
	{
	
	}
}
