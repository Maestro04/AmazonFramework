package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import util.MyListener;

public class TestBase
{
	public static WebDriver driver;
	public static WebDriver e_driver;
	public static Properties prop;
	public static ExtentSparkReporter htmlReport;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	//public static EventFiringDecorator<WebDriver> e_driver;
	public static WebDriverListener eventListener;
	
	public TestBase()
	{
		try
		{
			prop= new Properties();
			FileInputStream in= new FileInputStream("C:/Users/baner/eclipse-workspace/AmazonFramework"
					+ "/src/main/java/config/config.properties");
			prop.load(in);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions option= new ChromeOptions();
			option.setExperimentalOption("useAutomationExtension", false);
			option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			option.addArguments("--remote-allow-origins=*");
			
			Map<String, Object> prefs= new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			option.setExperimentalOption("prefs", prefs);
			
			driver= new ChromeDriver(option);
			eventListener= new MyListener();
			e_driver= new EventFiringDecorator<WebDriver>(eventListener).decorate(driver);
			driver=e_driver;
			
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		}
	}
}
