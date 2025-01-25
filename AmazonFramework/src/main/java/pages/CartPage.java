package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	
	@FindBy(xpath="//input[starts-with(@aria-label,'Delete Samsung Galaxy')]")
	WebElement phoneDeleteLink;
	
	@FindBy(xpath="//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	WebElement totalCartAmt;
	
	@FindBy(xpath="//form[@id='activeCartViewForm']//child::div[@data-name='Active Items']"
			+ "/div[3]//span[contains(@class,'a-size-medium a-color-base sc-price')]")
	WebElement adaptorPriceAmt;
	
	@FindBy(xpath="//form[@id='activeCartViewForm']//child::div[@data-name='Active Items']"
			+ "/div[4]//span[contains(@class,'a-size-medium a-color-base sc-price')]")
	WebElement phoneCasePriceAmt;
	
	
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void deleteItemPhone()
	{
		phoneDeleteLink.click();
	}
	
	public String getadaptorPriceValue()
	{
		return adaptorPriceAmt.getText();
	}
	
	public String getPhoneCasePriceValue()
	{
		return phoneCasePriceAmt.getText();
	}
	
	public String getTotalCartValue()
	{
		return totalCartAmt.getText();
	}
	
	
}
