package com.doosan.nao.pagfactory.classOrderTest;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class Testing {

	EventFiringWebDriver wd;
	@BeforeMethod
	public void beforeTest() throws MalformedURLException
	{
		wd=WebdriverSelector.getDriver(wd, "firefox");
		
	}
	@Test(dataProvider="Testing")
	public void testing(String name, String pass)
	{
		
		wd.get("https://www.google.co.in");
		wd.findElement(By.xpath("q"));
	}
	
	@AfterMethod
	public void afterMethodTesting(ITestResult result) throws IOException
	{
		if (!result.isSuccess())
		{
			ReportGenerator.setLogAndCreateScreenshot("Testing", "TEstCaseName", "TestData1","Pass", "", wd);
		} 		
	}
	
	@DataProvider(name="Testing")
	public static Object[][] getdata()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="Testing1";
		data[0][1]="Testing2";
		data[1][0]="Testing3";
		data[1][1]="Testing4";
		
		return data;
		
	}
}
