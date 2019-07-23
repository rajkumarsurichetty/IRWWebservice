package com.doosan.nao.pagfactory.classOrderTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.reports.ReportGenerator;

public class AllMakesTest {
	private String isBrowserAlive = "N";
	public String methodName;
	private static String browserName;
	public String localTestData;
	WebDriver wd;
	public  Properties PROJECT;
	@Test
	public void testAllMakes() throws InterruptedException
	{this.methodName= new Object(){}.getClass().getEnclosingMethod().getName();
		// wd=new FirefoxDriver();
	PROJECT = new Properties();
	InputStream projectInputFile=ClassLoader.getSystemClassLoader().getResourceAsStream("project.properties");

	try {
		PROJECT.load(projectInputFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String userid=PROJECT.getProperty("userName");
	String Pass=PROJECT.getProperty("Password");
	System.out.println( userid +" >> "+Pass);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserSetUp\\chromedriver.exe");
		wd=new ChromeDriver();
		 localTestData="rajkumars";
		 browserName="Chrome";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//wd.get("https://qa.doosanpassport.com/Login/Login.aspx");
		//wd.get("https://portal-hybris.qa.dice-tools.com/naoorgselector/en/login");
		wd.get(PROJECT.getProperty("DoosanParts5URL"));
		wd.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[3]/div[1]/form/div[2]/dl/dd[1]/input")).sendKeys(userid);
		wd.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[3]/div[1]/form/div[2]/dl/dd[3]/input")).sendKeys(Pass);
		wd.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[3]/div[1]/form/div[2]/div/input[1]")).click();
		
		Thread.sleep(10000);
		//wd.navigate().to("http://parts5.qa.corp.doosan.com/");
		
		//Thread.sleep(6000);
		
		WebDriverWait wait=new WebDriverWait(wd, 60);
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys("1123154");
		wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//*[@id='organization_list']/tbody/tr/td[2]/a"))));
		Thread.sleep(10000);
		WebElement firstLink=wd.findElement(By.xpath("//*[@id='organization_list']/tbody/tr/td[2]/a"));
		firstLink.click();
		
		waitTest(wd, wd.findElement(By.linkText("All Makes")));
		WebElement AllMakes=wd.findElement(By.linkText("All Makes"));
		AllMakes.click();
		
		WebElement allMakeFirstLink=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div/div[1]/div/div[2]/div[2]/ul/li[1]/form/a"));
		
				allMakeFirstLink.click();
		WebElement addToCart=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div/div[2]/div[2]/div[5]/table/tbody/tr[1]/td[3]/form/a"));
		addToCart.click();
		Thread.sleep(8000);
		WebElement proccedToCheckOut=wd.findElement(By.xpath("html/body/div[4]/div[3]/div/button[2]"));
		proccedToCheckOut.click();
		Thread.sleep(8000);
		WebElement dropDown=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[1]/select"));
		Select select=new Select(dropDown);
		select.selectByIndex(2);
		Thread.sleep(6000);
		WebElement checkOut=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[1]/span/input"));
		checkOut.click();
		/*try {
		WebElement checkOut=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[1]/span/input"));
		checkOut.click();
		} catch (Throwable t)
		{
			WebElement checkOut=wd.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/div[2]/form/div[1]/span/input"));
			checkOut.click();			
		}*/
		Thread.sleep(5000);
		WebElement poNumber=wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[2]/span[2]/input"));
		poNumber.clear();
		poNumber.sendKeys("POAUTO"+randomGenMillSecs()+System.currentTimeMillis());
		
		WebElement mode=wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[7]/div[2]/span[2]/select"));
		Select modeselect=new Select(mode);
		modeselect.selectByIndex(1);
		
		WebElement carrier=wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[7]/div[3]/span[2]/select"));
		Select modecarrierselect=new Select(carrier);
		modecarrierselect.selectByIndex(1);
		
		WebElement priority=wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[4]/div[7]/div[4]/span[2]/select"));
		Select priorityselect=new Select(priority);
		priorityselect.selectByIndex(1);
		
		WebElement checkOutele=wd.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/form/div[8]/div[1]/span/button"));
		checkOutele.click();
		
		WebElement agree=wd.findElement(By.xpath("html/body/div[2]/div[2]/form/nav[1]/ul/li[3]/label/input"));
		agree.click();
		
		WebElement submitOrder=wd.findElement(By.xpath("html/body/div[2]/div[2]/form/nav[1]/ul/li[1]/button"));
		submitOrder.click();
	}
	
	public void waitTest(WebDriver wd, WebElement link)
	{
		WebDriverWait wait=new WebDriverWait(wd, 60);
		wait.until(ExpectedConditions.elementToBeClickable(link));
		
	}
	
	public static int randomGenMillSecs()
	{
		Random ran=new Random();
		int i=ran.nextInt(9)+3;
		return i;
	}
	@AfterMethod
	/*public void quitBrowser(){
		//wd.close();
	}
	@AfterClass*/
	public void onTestFailure(ITestResult result) throws IOException
	{
		if (result.isSuccess())
		{
			isBrowserAlive="A";
			ReportGenerator.setLogAndCreateScreenshot(methodName+"~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.PASSED, wd);
			isBrowserAlive="N";
			wd.close();	
		} else 
		{
			ReportGenerator.setLogAndCreateScreenshot(methodName+"~"+browserName, Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,result.getThrowable().toString(),wd);
			System.out.println(result.getThrowable());
			isBrowserAlive="N";
			wd.quit();
		}
	}
}
