package DriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupDriver {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	
	public static EdgeOptions options1;

	public static WebDriver chromedriver()
	{
		WebDriverManager.chromedriver().setup();          
	      options = new ChromeOptions();
	      options.addArguments("start-maximized");
	      options.addArguments("incognito");
	      options.addArguments("disable-blink-features-AutomationControlled");  //"Chrome is controlled by ..."----this line gets disabled
	      driver = new ChromeDriver(options);
	      driver.get("https://www.linkedin.com/");   
		
		  return driver;
	}
	
	public static WebDriver edgedriver()
	{
		WebDriverManager.edgedriver().setup();          
	      options1 = new EdgeOptions();
	      options1.addArguments("start-maximized");
//	      options1.addArguments("incognito");
//	      options1.addArguments("disable-notifications");
//	      options1.addArguments("disable-popup-blocking");
//	      options1.addArguments("headless");  // to open headless browser( decreases time to load)
//	      options1.addArguments("disable-blink-features-AutomationControlled");  //"Chrome is controlled by ..."----this line gets disabled
	      driver = new EdgeDriver(options1);
	      driver.get("https://www.linkedin.com/");   
		
		  return driver;
	}
	
//	public static void teardown()
//	{
//		driver.close();
//		
//	}
	
}
