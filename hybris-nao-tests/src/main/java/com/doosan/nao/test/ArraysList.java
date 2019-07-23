package com.doosan.nao.test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ArraysList {
public static void main(String[] args) {
	List<String>listOptExpected=Arrays.asList("5","10","50","100");
	System.out.println(listOptExpected);
	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

	capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");

	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	
	capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
	System.setProperty("webdriver.ie.driver", ".//BrowserSetUp//IEDriverServer.exe");
    //Initialize InternetExplorerDriver Instance.
    WebDriver driver = new InternetExplorerDriver(capabilities);
    driver.get("https://www.facebook.com/");
    try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//driver.findElement(By.xpath("//span[text()='Jobs']")).click();
    driver.findElement(By.id("email")).sendKeys("raha");
    driver.findElement(By.id("pass")).sendKeys("xcv");
    driver.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
