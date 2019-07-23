package com.doosan.nao.cartTest;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class SavedCartValidator extends TestInitializer {

	public EventFiringWebDriver wd=null;
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@BeforeTest
	public void setUpForClass48HoursOrderValidatorTest(String browser, String browserVersion, String platform, String osVersion) throws IOException, URISyntaxException
	{
		wd=WebdriverSelector.getDriver(wd, browser);
		initialize(browser, browserVersion, platform, osVersion);	
	}

	@Test(priority=1)
	public void ValidateClass48HoursOrderValidatorTest() throws IOException, URISyntaxException, InterruptedException
	{
		//ReportGenerator.setLog("Class48HoursOrderValidator is initated with input likes :"+ "brand :>> "+brand+"Customer No :>> "+custNo+"item No :>> "+itemNo+"Order Class :>> "+orderClass);
		wd.get(PROJECT.getProperty("DoosanPassportURL"));
		getWebElement(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH,wd).sendKeys("vinoth.kumar");
		getWebElement(Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH,wd).sendKeys("welcome2");
		getWebElement(Constants.LOGIN_PAGE_SUBMIT_BUTTON_X_PATH,wd).submit();
		Thread.sleep(10000L);
		wd.navigate().to(PROJECT.getProperty("DoosanParts5URL"));
		
		WebDriverWait waitForSearchByDropdown=new WebDriverWait(wd, 30);
		waitForSearchByDropdown.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
		
		Select selectBrand=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
		selectBrand.selectByVisibleText("Brand");

		WebDriverWait waitForOrgSection=new WebDriverWait(wd, 30);
		waitForOrgSection.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		
		
		Select selectBrandByInput=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		selectBrandByInput.selectByVisibleText("Doosan");
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys("0001166428");
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
		
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 30);
		waitForFirstOrgLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")).click();

		WebDriverWait waitForSavedCartLink=new WebDriverWait(wd, 30);
		waitForSavedCartLink.until(ExpectedConditions.elementToBeClickable(By.linkText("Saved Carts")));
		wd.findElement(By.linkText("Saved Carts")).click();
		WebElement cartNameElement=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div/div/table/tbody/tr/td[1]/a"));
		String cartName=cartNameElement.getText();
		cartNameElement.click();
		String cartNameInCartDetailsPage=wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/form/div/input[2]")).getText();
		if (cartName.equals(cartNameInCartDetailsPage))
		{
			ReportGenerator.setLog("cart Name is valided successfully");
		} else 
		{
			ReportGenerator.setLog("cart Name is validation failed");
		}

	}
	
	
	@Test(priority=2)
	public void validateUpdateButton()
	{
		String cartNameBeforeUpdate=wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/form/div/input[2]")).getText();
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/form/div/input[2]")).sendKeys("1");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/form/div/input[3]")).click();
		String cartNameAfterUpdate=wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/form/div/input[2]")).getText();
		if(cartNameAfterUpdate.equals(cartNameBeforeUpdate+1))
		{
			System.out.println("Update button Validated Successfully");
		} else 
		{
			System.out.println("Update button Validatation failed");
		}
	}
	
	
	@Test(priority=3)
	public void validateBackToSavedCartsList()
	{
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[5]/a[2]")).click();
		String savedCartPageText=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[1]/div/div/h1")).getText();
		if (savedCartPageText.equals("Saved Carts"))
		{ 
			ReportGenerator.setLog("Back To Saved Carts List is validated successfully");
		} else 
		{
			ReportGenerator.setLog("Back To Saved Carts List validation having error");
		}
	}
	
	@Test(priority=4)
	public void validateLoadSavedCart()
	{
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div/div/table/tbody/tr/td[5]/a")).click();
		String cartPageText=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[1]/div[1]/h1")).getText();
		if (cartPageText.trim().equals("Your Shopping Cart".trim()))
		{
			System.out.println("Load Saved Cart Validated successully");
		} else
		{
			System.out.println("Load Saved Cart validation failed");
		}
	}
	
}
