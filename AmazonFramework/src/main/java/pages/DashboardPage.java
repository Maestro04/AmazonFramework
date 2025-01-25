package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.TestBase;

public class DashboardPage extends TestBase
{
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@id='nav-cart-count-container']/span[@id='nav-cart-count']")
	public WebElement countVisibility;
	
	public static By addToCrtBtnLoc= By.xpath("//*[@id='a-autoid-1-announce']");
	public static By addToCartDivSpan= By.xpath("//div[@data-atcb-uid='atcb-B0CT5BJC16-1']//span[@id='a-autoid-1']");
	public static By cartIconDivSpan= By.xpath("//div[@data-atcb-uid='atcb-B0CM4SNJRZ-1']//span[@id='a-autoid-1']");
	public WebElement addToCrtBtn;
	public static By moveToCartIcon= By.xpath("//*[@id='nav-cart']");
	WebElement cartIconLink;
	
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void findElementAddBtn()
	{
		addToCrtBtn= driver.findElement(addToCrtBtnLoc);
	}
	
	public void findElementMoveToCart()
	{
		cartIconLink= driver.findElement(moveToCartIcon);
	}
	
	
	public void addFirstProduct(String phoneData)
	{
		searchBox.sendKeys(phoneData);
		searchBox.sendKeys(Keys.ENTER);
		findElementAddBtn();
		addToCrtBtn.click();
	}
	
	public String cartItemNumber()
	{
		findElementMoveToCart();
		return cartIconLink.getAttribute("aria-label");
	}
	
	public void addSecondProduct(String caseData)
	{
		searchBox.clear();
		searchBox.sendKeys(caseData);
		searchBox.sendKeys(Keys.ENTER);
		findElementAddBtn();
		addToCrtBtn.click();	
	}
	
	public void addThirdProduct(String adaptorData)
	{
		searchBox.clear();
		searchBox.sendKeys(adaptorData);
		searchBox.sendKeys(Keys.ENTER);
		findElementAddBtn();
		addToCrtBtn.click();
	}
	
	public CartPage goToCartPage()
	{
		findElementMoveToCart();
		cartIconLink.click();
		return new CartPage();
	}
}
