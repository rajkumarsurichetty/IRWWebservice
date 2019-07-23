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

public class OrderHistryTabValidator extends TestInitializer {

	public Object [] salseOrderNo;
	public Object [] webConfirmationNo;
	public Object [] orderClass;
	public Object [] purchaseOrderNo;
	public Object [] lines;
	public Object [] totalOrderAmount;
	public Object [] orderStatus;
	
	public EventFiringWebDriver wd=null;

	
	//Testing Data Set
	//String brand="Bobcat";
	//String customerNo="0001225771";
	//String itemNo="7168039";
	
	//String brand="Doosan";
//	String customerNo="0001166428";
	//String itemNo="91V1165";

	
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	@BeforeTest
	public void setUpForOrderHistryTabTest(String browser, String browserVersion, String platform, String osVersion) throws IOException, URISyntaxException
	{
		wd=WebdriverSelector.getDriver(wd, browser);
		
		initialize(browser, browserVersion, platform, osVersion);
		
	}
	
	@Test(dataProvider="OrderHistryTabValidator")
	public void validateOrderHistryTabTest(String testData, String userName, String password, String brandName, String CustNo, String itemNo) throws IOException, URISyntaxException, InterruptedException
	{
	try{	
		wd.get(PROJECT.getProperty("DoosanPassportURL"));
		getWebElement(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH,wd).sendKeys("rajkumars");
		getWebElement(Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH,wd).sendKeys("welcome3");
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
		selectBrandByInput.selectByVisibleText(brandName);
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys(CustNo);
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
		
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 600);
		waitForFirstOrgLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));
		
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")).click();
		
		wd.findElement(By.linkText("Order History")).click();

		WebDriverWait waitForOrderHistoryTab=new WebDriverWait(wd, 600);
		waitForOrderHistoryTab.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[4]/div/div[2]/div[1]/a")));
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/div[1]/a")).click();

	}catch (Throwable t )
		{
			
		}
		
	}
	
	@Test (priority=1)
	public void testOrdersfromthepastDropdownList()
	{
	try	{
		Select orderFromPast=new Select(wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[1]/td[2]/select")));
		List<WebElement> l=orderFromPast.getOptions();
		for (int i=0;i<l.size();i++)
		{
			String options=l.get(i).getText();
			if(!options.equals("7 Days")||!options.equals("30 Days")||!options.equals("60 Days")||!options.equals("90 Days"))
			{
				ReportGenerator.setLog("This option is not available"+l.get(i).getText());
			}
		}
	}
		catch (Throwable t )
		{
			
		}
	}
	
	@Test (priority=1, enabled=false)
	public void testDuringThePeriodOf()
	{
		//Date date=new Date();
		try {
		//DateSetter DS=new DateSetter();
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[2]/td[2]/input")).clear();
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[2]/td[2]/input")).sendKeys("3/3/2015");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[2]/td[3]/input")).clear();
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[2]/td[3]/input")).sendKeys("3/3/2015");
		} catch (Throwable t )
		{
			
		}
	}
	
	@Test (priority=2,enabled=false)
	public void testContaingCheckBoxSelection()
	{
		try {
		Select containingDropdwon=new Select(wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[4]/td[2]/select")));
		containingDropdwon.selectByIndex(2);
		String isCheckBoxSelected=wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[4]/td[1]/input[1]")).getAttribute("value");
		if(isCheckBoxSelected.equals("true"))
		{
			ReportGenerator.setLog("Check Box Selected");
		} else 
		{
			ReportGenerator.setLog("Check Box not Selected");
		}
		} catch (Throwable t )
		{
			
		}
		
	}
	
	@Test (priority=3)
	public void validateResultPageHeader() throws InterruptedException
	{
		try {
		Thread.sleep(10000L);
		WebElement table=wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/div[3]/div/table"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		ReportGenerator.setLog("validateResultPageHeader"+rows.size());
		List<WebElement> cols=rows.get(1).findElements(By.tagName("td"));
		
		String startingXpath="html/body/div[2]/div[4]/div/div[3]/div[3]/div/table/thead/tr/th[";
		String endingXpath="]";
		for (int i=1;i<cols.size();i++)		{
			String tableHeader=wd.findElement(By.xpath(startingXpath+i+endingXpath)).getText();
			ReportGenerator.setLog(tableHeader);
			switch (tableHeader) {
			case "Sales Order #":
				ReportGenerator.setLog("Sales Order # column is present");
				break;
			case "Web Confirmation":
				ReportGenerator.setLog("Web Confirmation column is present");
				break;
			case "Ship To Customer":
				ReportGenerator.setLog("Ship To Customer column is present");
				break;
			case "Order Date":
				ReportGenerator.setLog("Order Date column is present");
				break;
			case "Order Class":
				ReportGenerator.setLog("Order Class column is present");
				break;
			case "Purchase Order #":
				ReportGenerator.setLog("Sales Order # column is present");
				break;
			case "Lines":
				ReportGenerator.setLog("Lines column is present");
				break;
			case "Total Order Amount":
				ReportGenerator.setLog("Total Order Amount column is present");
				break;
			case "Order Status":
				ReportGenerator.setLog("Order Status column is present");
				break;
			
			}
		}
	
		} catch (Throwable t )
		{
			
		}
	}
	
	@Test (priority=4)
	public void validateResultPage() throws InterruptedException
	{
		try {
				wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/input")).click();
		} catch (Throwable t )
		{
			
		}
	}
	
	

	@Test (priority=5)
	public void validateOrderHistoryResultPage() throws InterruptedException
	{
		try{
		Select OrdersFromPast=new Select(wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/div/table/tbody/tr[1]/td[2]/select")));
																  
		OrdersFromPast.selectByVisibleText("90 Days");
		wd.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/form/button")).click();
		
		WebDriverWait waitForFirstLinkInTable=new WebDriverWait(wd, 30);
		waitForFirstLinkInTable.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[4]/div/div[3]/div[3]/div/table/tbody/tr[1]/td[1]/a")));
		
		//WebDriverWait waitForTablePresent=new WebDriverWait(wd, 600);
		//waitForTablePresent.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("search_list")));
		
		
		
		WebElement table=wd.findElement(By.id("search_list"));
		WebDriverWait waitForRows=new WebDriverWait(wd, 60);
		waitForRows.until(ExpectedConditions.elementToBeClickable(By.tagName("tr")));
		
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		int currentRow=rows.size();
		
		salseOrderNo=new Object[currentRow];
		webConfirmationNo=new Object[currentRow];
		orderClass=new Object[currentRow];
		purchaseOrderNo=new Object[currentRow];
		lines=new Object[currentRow];
		totalOrderAmount=new Object[currentRow];
		orderStatus=new Object[currentRow];
		
		
		for (int i=0;i<currentRow;i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			for  (int j=0;j<cols.size();j++)
			{
			//ReportGenerator.setLog("In side loop"+cols.get(0).getText());
			salseOrderNo[i]=cols.get(0).getText().trim();
			webConfirmationNo[i]=cols.get(1).getText().trim();
			orderClass[i]=cols.get(4).getText().trim();
			purchaseOrderNo[i]=cols.get(5).getText().trim();
			lines[i]=cols.get(6).getText().trim();
			totalOrderAmount[i]=cols.get(7).getText().trim();
			orderStatus[i]=cols.get(8).getText().trim();
			//ReportGenerator.setLog("tableData["+i+"]"+cols.get(0).getText());
			}
		}
		
		for (int i=1;i<currentRow;i++)
		{
			
			wd.findElement(By.linkText(salseOrderNo[i].toString())).click();
			String saleOrderInOrderDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]")).getText();
			String webConfirmationInOrderDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]")).getText();
			String orderClassInOrderDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[3]/td[2]")).getText();
			String purchaseOrderInOrderDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]")).getText();
			String orderStatusInOrderDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[1]/td[2]")).getText();
			if (salseOrderNo[i].equals(saleOrderInOrderDetails.trim()))
			{
				ReportGenerator.setLog("Salse Order Verified sucessfully --->"+saleOrderInOrderDetails);
			}
			if (webConfirmationNo[i].equals(webConfirmationInOrderDetails.trim()))
			{
				ReportGenerator.setLog("Web confirmation no Verified sucessfully --->"+webConfirmationInOrderDetails);
			}
			if (orderClass[i].equals(orderClassInOrderDetails.trim()))
			{
				ReportGenerator.setLog("Order Class details Verified sucessfully --->"+orderClassInOrderDetails);
			}
			if (purchaseOrderNo[i].equals(purchaseOrderInOrderDetails.trim()))
			{
				ReportGenerator.setLog("Purchase Order details Verified sucessfully --->"+purchaseOrderInOrderDetails);
			}
			//String linesInOrderDetails=wd.findElement(By.xpath("")).getText();
		//	if(!totalOrderAmount[i].equals(null))
			{
			//String totalOrderAmountInOrderDetails=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[3]/div[2]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]")).getText();
			//if(totalOrderAmount[i].equals(totalOrderAmountInOrderDetails))
			{
				//System.out.println("Purchase Order Amount details Verified sucessfully");
			}
			}
			if (orderStatus[i].equals(orderStatusInOrderDetails.trim()))
			{
				ReportGenerator.setLog("Order Status details Verified sucessfully --->"+orderStatusInOrderDetails);
			}
			wd.navigate().back();
			
			
		}
		} catch (Throwable t )
		{
			
		}
		
	}
	
	@DataProvider(name="OrderHistryTabValidator")
	public static Object[][] getDataForShipments()
	{
		return InputReader.getInputReader().getDataFromXLS("OrderHistryTabValidator");
		
	}

	
}
