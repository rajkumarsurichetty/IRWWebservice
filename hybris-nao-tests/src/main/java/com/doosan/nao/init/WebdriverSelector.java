package com.doosan.nao.init;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserSetUp\\chromedriver.exe");
			DesiredCapabilities caps = new DesiredCapabilities().chrome();
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
			
			String downloadFilepath = System.getProperty("user.dir")+"\\downloads";	
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-pdf-material-ui");		 
			options.addArguments("test-type", "start-maximized","no-default-browser-check");
			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
	                  UnexpectedAlertBehaviour.IGNORE);
			//DesiredCapabilities cap = DesiredCapabilities.chrome();
			caps.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability(ChromeOptions.CAPABILITY, options);	
			//ChromeOptions cap = new ChromeOptions(); 
			//cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
			                 // UnexpectedAlertBehaviour.IGNORE);
			WebDriver driver=new ChromeDriver(caps);
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
