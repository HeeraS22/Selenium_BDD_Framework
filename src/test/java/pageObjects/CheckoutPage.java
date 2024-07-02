package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	public WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	//To avoid hard coding
	By cartBag = By.cssSelector("img[alt='Cart']");
	By checkoutBtn = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoBtn = By.cssSelector(".promoCode");
	By placeOrderBtn = By.xpath("//button[text()='Place Order']");
	
	public void checkoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkoutBtn).click();
	}
	
	public Boolean verifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
		
	}
	
	public Boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrderBtn).isDisplayed();
		
	}
	
}
