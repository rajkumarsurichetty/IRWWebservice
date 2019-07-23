package com.doosan.nao.accountHistoryTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.input.InputReader;
import com.doosan.nao.reports.ReportGenerator;

public class ShipmentsTabValidator extends TestInitializer {
	public EventFiringWebDriver wd=null;
	public Object[] shipmentNo;
	public Object[] purchaseOrderNo;
	public Object[] shipToContainer;
	public Object[] shipmentMethod;
	public Object[] totalCartons;
	public Object[] trackingNo;
	
	String brand="Doosan";
	String customerNo="0001166428";
	String itemNo="91V1165";
	
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@BeforeTest
	public void setUpForShipmentsTest(String browser, String browserVersion, String platform, String osVersion) throws IOException, URISyntaxException
	{

		wd=WebdriverSelector.getDriver(wd, browser);
		
		initialize(browser, browserVersion, platform, osVersion);
	}
	@Test (dataProvider="ShipmentsTabValidator")
	public void validateShipmentsTest(String testData, String userName, String password, String brandName, String CustNo, String itemNo) throws IOException, URISyntaxException, InterruptedException
	{
		try {
		wd.get(PROJECT.getProperty("DoosanPassportURL"));
		getWebElement(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH,wd).sendKeys(userName.trim());
		getWebElement(Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH,wd).sendKeys(password.trim());
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
		
		wd.findElement(By.linkText("Order History")).click();

		WebDriverWait waitForOrderHistoryTab=new WebDriverWait(wd, 600);
		waitForOrderHistoryTab.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[4]/div/div[2]/div[1]/a")));
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/div[1]/a")).click();
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/div[2]/a")).click();

		} catch (Throwable t )
		{
			
		}
	}
	
	@Test (priority=1)
	public void testShipmentsfromthepastDropdownList()
	{
		try {
		Select shipmentsFromPast=new Select(wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[1]/td[2]/select")));
		List<WebElement> l=shipmentsFromPast.getOptions();
		for (int i=0;i<l.size();i++)
		{
			String options=l.get(i).getText();
			if(!options.equals("7 Days")||!options.equals("30 Days")||!options.equals("60 Days")||!options.equals("90 Days"))
			{
				ReportGenerator.setLog("This option is not available"+l.get(i).getText());
			} else 
			{
				ReportGenerator.setLog("Shipments From the Past Dropdown Options are validated successsfully For---> "+options);
			}
			
		}
		} catch (Throwable t )
		{
			
		}
	}
	
	@Test(priority=2)
	public void validateOrderHistoryResultPage() throws InterruptedException
	{
		try {
		Select shipmentsFromPast=new Select(wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[1]/td[2]/select")));
		shipmentsFromPast.selectByVisibleText("90 Days");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/button")).click();
		WebDriverWait waitForFirstLinkInTable=new WebDriverWait(wd, 30);
		waitForFirstLinkInTable.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[4]/div/div[3]/div[3]/div/table/tbody/tr[1]/td[1]/a")));
	
		WebElement table=wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/div[3]/div/table"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		
		shipmentNo=new Object[rows.size()];
		purchaseOrderNo=new Object[rows.size()];
		shipToContainer=new Object[rows.size()];
		shipmentMethod=new Object[rows.size()];
		totalCartons=new Object[rows.size()];
		trackingNo=new Object[rows.size()];
		for (int i=0;i<rows.size();i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			
			for (int j=0;j<cols.size();j++)
			{
				//ReportGenerator.setLog("shipmentNo["+j+"]>>>>>"+cols.get(0).getText());
				shipmentNo[i]=cols.get(0).getText().trim();
				purchaseOrderNo[i]=cols.get(1).getText().trim();
				shipmentMethod[i]=cols.get(4).getText().trim();
				totalCartons[i]=cols.get(5).getText().trim();
				trackingNo[i]=cols.get(6).getText().trim();
			}
		}
		
		for (int j=1;j<rows.size();j++)
		{
			//ReportGenerator.setLog("shipment No>>>>"+shipmentNo[j]);
			WebDriverWait waitForLinkPresnt=new WebDriverWait(wd, 60);
			waitForLinkPresnt.until(ExpectedConditions.elementToBeClickable(By.linkText(shipmentNo[j].toString())));
			 
			wd.findElement(By.linkText(shipmentNo[j].toString())).click();
			String shipmentNoInShipmentDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]")).getText().trim();
			String purchaseOrderNoInShipmentDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[3]/div[2]/div/table[2]/tbody/tr/td[1]")).getText().trim();
			String shipmentMethodInShipmentDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[3]/td[2]")).getText().trim();
			//String totalCartonsInShipmentDetails=wd.findElement(By.xpath("")).getText();
			String trackingNoInShipmentDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[4]/td[2]")).getText().trim();
			
			if (shipmentNo[j].equals(shipmentNoInShipmentDetails.trim()))
			{
				ReportGenerator.setLog("Shipment No verified successfully --->"+shipmentNoInShipmentDetails);
			}
			if (purchaseOrderNo[j].equals(purchaseOrderNoInShipmentDetails.trim()))
			{
				ReportGenerator.setLog("Purchase Order No verified successfully --->"+purchaseOrderNoInShipmentDetails);
			}
			if (shipmentMethod[j].equals(shipmentMethodInShipmentDetails.trim()))
			{
				ReportGenerator.setLog("Shipment Method verified successfully --->"+shipmentMethodInShipmentDetails);
			}
			if (trackingNo[j].equals(trackingNoInShipmentDetails.trim()))
			{
				ReportGenerator.setLog("Tracking No verified successfully --->"+trackingNoInShipmentDetails);
			}
			
			wd.navigate().back();
		
		}
		}
		catch (Throwable t )
		{
			
		}
	}
	
	@DataProvider(name="ShipmentsTabValidator")
	public static Object[][] getDataForShipments()
	{
		return InputReader.getInputReader().getDataFromXLS("ShipmentsTabValidator");
		
	}

}
