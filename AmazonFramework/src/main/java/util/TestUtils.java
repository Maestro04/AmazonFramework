package util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;
import pages.DashboardPage;

public class TestUtils extends TestBase
{
	
	public static final long waitTime= 10;
	public static final long impWait= 7;
	public static final long expWait= 7;
	public static String itemAddedVal="";
	
	public static String screenShot()
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	public static void takeScreenShot() throws IOException
	{
		File screenShotImage= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir= System.getProperty("user.dir");
		FileUtils.copyFile(screenShotImage, new File(currentDir+ "/screenshots/"+ System.currentTimeMillis()+ ".png"));
		/*FileHandler.copy(screenShotImage, new File("C:/Users/baner/eclipse-workspace/AmazonFramework"
				+ "/screenshots/"+ System.currentTimeMillis()+ ".png"));*/
	}
	
	public static void pageLoadTimeout()
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(waitTime));
	}
	
	public static void implicitlyWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impWait));
	}
	
	public static void threadWait() throws InterruptedException
	{
		Thread.sleep(4000);
	}
	
	public static void pageScroll() throws InterruptedException
	{
		threadWait();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,350)","");
	}
	
	public static void cartItemVerificationUsable() throws InterruptedException
	{
		threadWait();
		DashboardPage dashboardPageObj= new DashboardPage();
		String cartAttribute= dashboardPageObj.cartItemNumber();
		String cartAttributeSplit[]= cartAttribute.split(" ");
		for(int i=0; i<cartAttributeSplit.length; i++)
		{
			if(i==0)
			{
				itemAddedVal= cartAttributeSplit[i];
				break;
			}	
		}
		//Assert.assertEquals(itemAddedVal, prop.getProperty("itemCountVal"));
	}
	
}
