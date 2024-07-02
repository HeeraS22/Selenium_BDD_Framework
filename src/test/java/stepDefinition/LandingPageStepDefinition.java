package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextStepup;

public class LandingPageStepDefinition 
{
	public WebDriver driver;
	public String homeProductName;
	public String offerProductName;
	TestContextStepup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextStepup testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() 
	{
     //Run--Constructors--StepDefinition
		Assert.assertTrue(landingPage.getLandingPageTitile().contains("GreenKart"));
	}
	
	@When("^User searched with short name (.+) and extracted actual name of product$")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) 
			throws Exception 
	{
		
		landingPage.searchItem(shortName);
		Thread.sleep(3000);
		testContextSetup.homeProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(homeProductName+" is extracted from home page");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_of_the_selected_product_to_cart(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
	
}
