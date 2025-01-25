package testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.DashboardPage;
import util.TestUtils;

public class CartPageTest extends TestBase implements DashboardPageTest
{
	DashboardPage dashboardPageObj;
	CartPage cartPageObj;
	String totCartAmtValue="";
	String adaptorPriceValue="";
	String phoneCasePriceValue="";
	Logger log;
	
	public CartPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		log= Logger.getLogger(CartPageTest.class);
		log.info("Launched Amazon");
		dashboardPageObj= new DashboardPage();
		cartPageObj= new CartPage();
	}
	
	@Test(priority=1)
	public void addFirstProductTest() throws InterruptedException
	{
		dashboardPageObj.addFirstProduct(prop.getProperty("searchPhoneData"));
		log.info("first item added");
		TestUtils.cartItemVerificationUsable();
		Assert.assertEquals(TestUtils.itemAddedVal, prop.getProperty("itemCountVal"));
	}
	
	@Test(priority=2, dependsOnMethods={"addFirstProductTest"})
	public void addSecondProductTest() throws InterruptedException
	{
		dashboardPageObj.addSecondProduct(prop.getProperty("searchCaseData"));
		TestUtils.cartItemVerificationUsable();
		Assert.assertEquals(TestUtils.itemAddedVal, prop.getProperty("itemCountSecVal"));
	}
	
	@Test(priority=3, dependsOnMethods= {"addSecondProductTest"})
	public void addThirdProductTest() throws InterruptedException
	{
		dashboardPageObj.addThirdProduct(prop.getProperty("searchAdaptorData"));
		TestUtils.cartItemVerificationUsable();
		Assert.assertEquals(TestUtils.itemAddedVal, prop.getProperty("itemCountThirdVal"));
	}
	
	@Test(priority=4, dependsOnMethods= {"addThirdProductTest"})
	public void goToCartPageTest()
	{
		cartPageObj= dashboardPageObj.goToCartPage();
		Assert.assertNotNull(cartPageObj);
	}
	
	@Test(priority=5)
	public void getadaptorPriceValueTest()
	{
		adaptorPriceValue= cartPageObj.getadaptorPriceValue().replace(" ", "");
		System.out.println(adaptorPriceValue);
	}
	
	@Test(priority=6)
	public void getPhoneCasePriceValueTest()
	{
		phoneCasePriceValue= cartPageObj.getPhoneCasePriceValue().replace(" ", "");
		System.out.println(phoneCasePriceValue);
	}
	
	
	@Test(priority=7)
	public void deleteItemPhoneTest() throws InterruptedException
	{
		TestUtils.pageScroll();
		cartPageObj.deleteItemPhone();
		TestUtils.threadWait();
	}
	
	@Test(priority=8)
	public void getTotalCartValueTest()
	{
		totCartAmtValue= cartPageObj.getTotalCartValue().replace(" ", "");
		System.out.println(totCartAmtValue);
		
	}
	
	@Test(priority=9)
	public void cartAmountTotalVerification()
	{
		try
		{
			float adaptorAmt= Float.parseFloat(adaptorPriceValue.replace(",", ""));
			float phoneCaseAmt= Float.parseFloat(phoneCasePriceValue.replace(",", ""));
			float totalItemsAmtVal= adaptorAmt+phoneCaseAmt;
			float totalCartAmtExpectedVal= Float.parseFloat(totCartAmtValue.replace(",", ""));
			Assert.assertEquals(totalItemsAmtVal, totalCartAmtExpectedVal);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	@Ignore
	public void tearDown()
	{
		driver.quit();
	}
}
