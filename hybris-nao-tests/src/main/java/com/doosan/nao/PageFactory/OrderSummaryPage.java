package com.doosan.nao.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderSummaryPage {

	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[2]/form/nav[1]/ul/li[3]/label/input")
	public WebElement agreeConditionsCheckbox;
	public void clickAgreeConditionsCheckBox(EventFiringWebDriver wd)
	{
		WebDriverWait waitForAgreeCheckBox=new WebDriverWait(wd, 160);
		waitForAgreeCheckBox.until(ExpectedConditions.elementToBeClickable(agreeConditionsCheckbox));
		this.agreeConditionsCheckbox.click();
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[2]/form/nav[1]/ul/li[1]/button")
	public WebElement submitOrder;
	public void clickSubmitOrder()
	{
		this.submitOrder.click();
	}

	
	@FindBy(how=How.XPATH,using=".//*[@id='order_summary_order_info']/li[2]/ul[2]/li[1]/span[2]")
	public WebElement totalOrderAmount;
	public void verifyTotalOrderAmount()
	{
		if(totalOrderAmount.getText().trim().equals("$0.00".trim()))
		{
			System.out.println(totalOrderAmount.getText().trim());
		Assert.assertTrue(false);
		}
	}
	@FindBy(how=How.XPATH,using="//*[@id='buttons']/a[contains(text(),'Continue Shopping')]")
	public WebElement continueShopping;
	public void clickContinueShopping()
	{
		this.continueShopping.click();
	}
	
}
