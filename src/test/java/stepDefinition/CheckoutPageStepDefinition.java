package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextStepup;

public class CheckoutPageStepDefinition 
{
	public WebDriver driver;
	public String homeProductName;
	public String offerProductName;
	public CheckoutPage checkoutPage;
	TestContextStepup testContextSetup;
	
	public CheckoutPageStepDefinition(TestContextStepup testContextSetup) 
	{
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckPage();
		this.testContextSetup = testContextSetup;
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void Verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
		System.out.println("Hi papu");
	}
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws Exception
	{
		checkoutPage.checkoutItems();
	}
	
}
