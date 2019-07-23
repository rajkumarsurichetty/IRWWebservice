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

import com.doosan.nao.classOrderTest.PurchaseOrderGenerator;
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;

public class DeleterCartValidator extends TestInitializer {

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
		selectBrandByInput.selectByVisibleText("Bobcat");
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys("0001225672");
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
		
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 30);
		waitForFirstOrgLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")).click();

		WebDriverWait waitForSavedCartLink=new WebDriverWait(wd, 30);
		waitForSavedCartLink.until(ExpectedConditions.elementToBeClickable(By.linkText("Quick Order")));
		wd.findElement(By.linkText("Quick Order")).click();
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[1]/table/tbody/tr[1]/td[3]/input")).sendKeys("6729900");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[1]/table/tbody/tr[1]/td[4]/input")).sendKeys("10");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[1]/table/tbody/tr[1]/td[5]/input")).sendKeys("10 bin");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[1]/table/tbody/tr[1]/td[6]/input")).sendKeys("10 comments");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/form/div[1]/div/div[3]/div[2]/a[2]")).click();
		WebDriverWait waitForCheckAll=new WebDriverWait(wd, 30);
		waitForCheckAll.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[3]/table/thead/tr/th[1]/input")));
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[3]/table/thead/tr/th[1]/input")).click();
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[4]/div/form/div[1]/div[2]/button[3]")).click();
		WebElement saveShoppingCartElement=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[1]/div/h1"));
		
		if(saveShoppingCartElement.getText().trim().equals("Save Shopping Cart"))
		{
			System.out.println("Save Shopping Cart Navigated to page");
		} else 
		{
			System.out.println("Save Shopping Cart Not Navigated to page");
		}
		
		WebDriverWait waitForSavedItemNo=new WebDriverWait(wd, 30);
		System.err.println(1);
		waitForSavedItemNo.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[4]/div[2]/div/form/div[1]/table/tbody/tr[2]/td[2]/input")));
		PurchaseOrderGenerator POG=new PurchaseOrderGenerator();
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div/form/div[1]/table/tbody/tr[2]/td[2]/input")).sendKeys(POG.generatePurchareOrder());
		System.err.println(2);
				

	}

}
