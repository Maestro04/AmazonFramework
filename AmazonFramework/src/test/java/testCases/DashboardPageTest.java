package testCases;


interface DashboardPageTest
{
	
	String removeAttribute="document.getElementById('nav-cart-count').removeAttribute('aria-hidden');";	
	
	public void addFirstProductTest() throws InterruptedException;
	
	public void addSecondProductTest() throws InterruptedException;
	
	public void addThirdProductTest() throws InterruptedException;
	
	public void goToCartPageTest() throws InterruptedException;

}
