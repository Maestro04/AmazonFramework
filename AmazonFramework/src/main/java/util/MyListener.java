package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import base.TestBase;

public class MyListener extends TestBase implements WebDriverListener {
	
   public void beforeGet(WebDriver driver, String url) {
      System.out.println("Before navigating to: '" + url + "'");
   }

   public void afterGet(WebDriver driver, String url) {
      System.out.println("Navigated to:'" + url + "'");
   }
   
   public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
	   System.out.println("Typing in the Element: "+element);
	   for(int i=0; i<keysToSend.length; i++)
	   {
		   System.out.println("Entering value: "+keysToSend[i]);
	   }
   }
   
   public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
	   System.out.println("Typed in the Element: "+element);
	   for(int i=0; i<keysToSend.length; i++)
	   {
		   System.out.println("Value entered: "+keysToSend[i]);
	   }
   }

   /*public void beforeChangeValueOf(WebElement element, WebDriver driver) {
      System.out.println("Value of the:" + element.toString() + " before any changes made");
   }

   public void afterChangeValueOf(WebElement element, WebDriver driver) {
      System.out.println("Element value changed to: " + element.toString());
   }*/

   public void beforeClick(WebElement element) {
      System.out.println("Trying to click on: " + element.toString());
   }

   public void afterClick(WebElement element) {
      System.out.println("Clicked on: " + element.toString());
   }

   /*public void beforeNavigateBack(WebDriver driver) {
      System.out.println("Navigating back to previous page");
   }

   public void afterNavigateBack(WebDriver driver) {
      System.out.println("Navigated back to previous page");
   }

   public void beforeNavigateForward(WebDriver driver) {
      System.out.println("Navigating forward to next page");
   }

   public void afterNavigateForward(WebDriver driver) {
      System.out.println("Navigated forward to next page");
   }*/

   /*public void onException(Throwable error, WebDriver driver) {
      System.out.println("Exception occurred: " + error);

      try {
         TestUtils.takeScreenShot();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }*/
   
   public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
	   System.out.println("Exception occurred: " + target);
	   System.out.println("Exception occurred by: " + method.getName());
	   System.out.println("Exception: "+ e.getMessage());
	   
		try {
			TestUtils.takeScreenShot();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
   }

   /*public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println("Trying to find Element By : " + by.toString());
   }

   public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println("Found Element By : " + by.toString());
   }

   public void beforeScript(String script, WebDriver driver) {
   }

   public void afterScript(String script, WebDriver driver) {
   }

   public void beforeAlertAccept(WebDriver driver) {
   }

   public void afterAlertAccept(WebDriver driver) {
   }

   public void afterAlertDismiss(WebDriver driver) {
   }

   public void beforeAlertDismiss(WebDriver driver) {
   }

   public void beforeNavigateRefresh(WebDriver driver) {
   }

   public void afterNavigateRefresh(WebDriver driver) {
   }

   public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
   }

   public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
   }

   public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
   }

   public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
   }

   public void afterSwitchToWindow(String arg0, WebDriver arg1) {
   }

   public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
   }

   public void beforeGetText(WebElement arg0, WebDriver arg1) {
   }

   public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
   }*/
}
