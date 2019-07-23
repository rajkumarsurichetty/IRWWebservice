package com.doosan.nao.init;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.doosan.nao.reports.ReportGenerator;



public class DriverListener extends AbstractWebDriverEventListener {
	

	public void afterNavigateBack(WebDriver wd) {
		//System.out.println("am navigating back"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void onException(java.lang.Throwable throwable,
            EventFiringWebDriver efwd) throws IOException
        {
		System.err.println("TEST Exception");
		TestInitializer.isBrowserAlive="N";
		//ReportGenerator.setLogAndCreateScreenshot(TestInitializer.failureClassName, "Validate"+TestInitializer.failureClassName+"Test", TestInitializer.failureTestData, "Fail", throwable.getMessage(), efwd);
		}	
	
	
	public void afterClickOn(WebElement we, WebDriver wd) {
		//System.out.println("i just clicked the button"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void afterChangeValueOf(WebElement element,  WebDriver wd) {
		//System.out.println("afterChangeValueOf"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
     }
	
	public void beforeScript(java.lang.String script, WebDriver wd) {
		//System.out.println("beforeScript"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
      }
	
	public void afterScript(java.lang.String script, WebDriver driver)	{
		//System.out.println("afterScript"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void beforeNavigateTo(java.lang.String url, WebDriver driver) {
		//System.out.println("beforeNavigateTo"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void afterNavigateTo(java.lang.String url, WebDriver driver) {
		//System.out.println("afterNavigateTo"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void beforeNavigateBack(WebDriver driver) {
		//System.out.println("beforeNavigateBack"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void beforeNavigateForward(WebDriver driver) {
		//System.out.println("beforeNavigateForward"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void afterNavigateForward(WebDriver driver) {
		//System.out.println("afterNavigateForward"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void beforeFindBy(By by,  WebElement element,  WebDriver driver) {
		//System.out.println("beforeFindBy"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);	
	}
	
	public void afterFindBy(By by, WebElement element,  WebDriver driver) {
		//System.out.println("afterFindBy"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void beforeClickOn(WebElement element,  WebDriver driver) {
		//System.out.println("beforeClickOn"+TestInitializer.testCaseId+TestInitializer.className+TestInitializer.methodName);
	}
	
	public void beforeChangeValueOf(WebElement element,  WebDriver driver) {
		//System.out.println("beforeChangeValueOf");
	}
	
	
}
