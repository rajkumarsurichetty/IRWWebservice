package com.doosan.nao.priceAndAvailablity;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;

public class PriceAndAvailabityValidator extends TestInitializer {

	public EventFiringWebDriver wd;
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@Test(priority=1)
	public void validatePriceAndAvailabityTest(String browser, String browserVersion, String platform, String osVersion) throws IOException, URISyntaxException, InterruptedException
	{
		
		//String brand="Bobcat";
		//String customerNo="0001225771";
		//String itemNo="7168039";
		
		String brand="Doosan";
		String customerNo="0001166428";
		String itemNo="91V1165";
		wd=WebdriverSelector.getDriver(wd, browser);
		
		initialize(browser, browserVersion, platform, osVersion);
		wd.get(PROJECT.getProperty("DoosanPassportURL"));
		getWebElement(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH,wd).sendKeys("vinoth.kumar");
		getWebElement(Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH,wd).sendKeys("welcome2");
		getWebElement(Constants.LOGIN_PAGE_SUBMIT_BUTTON_X_PATH,wd).submit();
		Thread.sleep(10000L);
		wd.navigate().to(PROJECT.getProperty("DoosanParts5URL"));		
		WebDriverWait waitForSearchByDropdown=new WebDriverWait(wd, 600);
		waitForSearchByDropdown.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
		
		Select selectBrand=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
		selectBrand.selectByVisibleText("Brand");

		WebDriverWait waitForOrgSection=new WebDriverWait(wd, 600);
		waitForOrgSection.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		
		
		Select selectBrandByInput=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		selectBrandByInput.selectByVisibleText(brand);
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys(customerNo);
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
		
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 600);
		waitForFirstOrgLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));
		
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")).click();
		
		wd.findElement(By.linkText("Price & Availability")).click();

		WebDriverWait waitForPriceAndAvailabilityPage=new WebDriverWait(wd, 600);
		waitForPriceAndAvailabilityPage.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[4]/div/div/div/h1")));
		
	}
	
	@Test(priority=2)
	public void validateClearFormButton()
	{
		
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div/div/div[1]/table/tbody/tr[1]/td[1]/input")).sendKeys("91V1165");
		
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div/div/div[3]/div/a")).click();
		
		String isItemNoAvalialble=wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div/div/div[1]/table/tbody/tr[1]/td[1]/input")).getText();
		if (isItemNoAvalialble.equals(null) || isItemNoAvalialble.equals(""))
		{
			System.out.println("Clear Button is validated properly");
		} else 
		{
			System.out.println("Issue exists in Clear button");
		}
		
	}
	
	@Test(priority=3)
	public void validateInvalidItemErrorMessage()
	{
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div/div/div[1]/table/tbody/tr[1]/td[1]/input")).sendKeys("TestingInvalidItem");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div/div/div[3]/div/button")).click();
		WebDriverWait waitForErrorMessage=new WebDriverWait(wd, 30);
		waitForErrorMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[4]/form/div/div/div[1]/table/tbody/tr[1]/td[1]/span[2]/p/span")));
		String errorMessage=wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div/div/div[1]/table/tbody/tr[1]/td[1]/span[2]/p/span")).getText();
		if(!errorMessage.equals(" ") || !errorMessage.equals(null))
		{
			System.out.println("Error message validated successfully");
		} else 
		{
			System.out.println("Issue Exists in Error message validation");
		}
		
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div/div/div[3]/div/a")).click();
	}
	
	@Test(priority=4)
	public void validateCheckPriceAndAvaialblity()
	{
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div/div/div[1]/table/tbody/tr[1]/td[1]/input")).sendKeys("91V1165");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div/div/div[3]/div/button")).click();
		String itemNo=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
		if(!itemNo.equals("") || !itemNo.equals(null))
		{
			System.out.println("Check Price and Avaliablity Validated successfully");
		} else 
		{
			System.out.println("Issue exists in Check Price and Avaliablity test");
		}
	
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div/div[2]/div/a")).click();
		String priceAndAvaliablityText=wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div/div/h1")).getText();
		
		if (!priceAndAvaliablityText.equals(" ") || !priceAndAvaliablityText.equals(null))
		{
			System.out.println("Start new search is working fine");
		} else 
		{
			System.out.println("Issue exits in Start new search Test");
		}
	}
	
	
}
