package com.doosan.nao.init;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class WebdriverSelector {

	  public static final String USERNAME = "vinothkumart1";
	  public static final String AUTOMATE_KEY = "UsURThcRq3pcjgD9qWw6";
	  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

	  
	public static EventFiringWebDriver getDriver(EventFiringWebDriver wd, String browser) throws MalformedURLException
	{
		//System.setProperty("atu.reporter.config", ClassLoader.getSystemClassLoader().getResourceAsStream("atu.properties").toString());
		if(browser.equals("firefox"))
		{
			
			//FirefoxProfile fp = new FirefoxProfile();
			// set something on the profile...
			//DesiredCapabilities dc = DesiredCapabilities.firefox();
			//dc.setCapability(FirefoxDriver.PROFILE, fp);
			//wd= new RemoteWebDriver(dc);
			
			
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			caps.setCapability("browser", "Firefox");
			caps.setCapability("browser_version", "34.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "7");
			caps.setCapability("resolution", "1024x768");
			caps.setCapability("browserstack.local", "true");
			caps.setCapability("browserstack.debug","true");
			caps.setCapability("browserstack.localIdentifier", "Test123");
			//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			//caps.setCapability(FirefoxDriver.PROFILE, TestInitializer.setPreferencesForFirefox());
			
			//WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			
			//System.setProperty("atu.reporter.config", System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"atu.properties");
				
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserSetUp\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			//ATUReports.setWebDriver(driver);
			wd=new EventFiringWebDriver(driver);
			//DriverListener driverListner=new DriverListener();
			//wd.register(driverListner);
			
			wd.manage().window().maximize();
			wd.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			

			return wd;
			
		} else if (browser.equals("chrome"))
		{
		
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "39.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "7");
			caps.setCapability("resolution", "1024x768");
			caps.setCapability("browserstack.debug","true");
			caps.setCapability("browserstack.local", "true");
			caps.setCapability("browserstack.localIdentifier", "Test123");
			//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			//WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			System.setProperty("java.net.preferIPv4Stack", "true");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserSetUp\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			wd=new EventFiringWebDriver(driver);
			DriverListener driverListner=new DriverListener();
			wd.register(driverListner);
			wd.manage().window().maximize();
			wd.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
		return wd;
		
		} else if (browser.equals("IE11"))
		{
			/*
			System.err.println("I am entered IE11");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			//caps.setCapability("browserstack.local", "true");
			caps.setCapability("browserstack.debug","true");
			
			//caps.setCapability("browserstack.localIdentifier", "Test123");
			caps.setCapability("browser", "IE");
			caps.setCapability("browser_version", "11.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "8.1");
			caps.setCapability("resolution", "1024x768");

			 
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browserstack.local", "true");
		    caps.setCapability("browserstack.localIdentifier", "Test123");
		    caps.setCapability("browserstack.debug", "true");
		    //caps.setCapability("acceptSslCerts", "true");
		   
		    //Script for IE
		    
		    caps.setCapability("browser", "IE");
		    caps.setCapability("browser_version", "11.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "8.1");
		    caps.setCapability("resolution", "1024x768");

			wd= new RemoteWebDriver(new java.net.URL(URL), caps);			
			wd.manage().window().maximize();
			wd.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					
			System.err.println("ready to retrun");
			return wd;
			*/
		} else if (browser.equals("IE10"))
		{
			/*
//			DesiredCapabilities caps = new DesiredCapabilities();
			

			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browserstack.local", "true");
		    caps.setCapability("browserstack.localIdentifier", "Test123");
		    caps.setCapability("browserstack.debug", "true");
		    //caps.setCapability("acceptSslCerts", "true");
		    // caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		    //Script for IE
		    
		    caps.setCapability("browser", "IE");
		    caps.setCapability("browser_version", "10.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "7");
		    caps.setCapability("resolution", "1024x768");

			//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			wd= new RemoteWebDriver(new java.net.URL(URL), caps);			
			wd.manage().window().maximize();
			wd.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					return wd;
					*/
		} else if (browser.equals("IE9"))
		{
			/*
	//		DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browserstack.local", "true");
		    caps.setCapability("browserstack.localIdentifier", "Test123");
		    caps.setCapability("browserstack.debug", "true");
		    //caps.setCapability("acceptSslCerts", "true");
		   
		    //Script for IE
		    
		    caps.setCapability("browser", "IE");
		    caps.setCapability("browser_version", "9.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "7");
		    caps.setCapability("resolution", "1024x768");
			//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			wd= new RemoteWebDriver(new java.net.URL(URL), caps);			
			wd.manage().window().maximize();
			wd.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					return wd;
					*/
		}
		 
		return null; 	
	}
}