package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextStepup;

public class OfferPageStepDefinition 
{
	public String offerProductName;
	TestContextStepup testContextSetup;
	PageObjectManager pageObjectManager;
	//Single responsibility Prinicple
	//loosly coupled
	public OfferPageStepDefinition(TestContextStepup testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
	}

	@Then("^User searched for (.+) short name in offers page$")
	public void user_searched_for_same_short_name_in_offers_page(String shortName) throws Exception 
	{	
		switchToOffersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();//----------------------
		offersPage.searchItem(shortName);
		Thread.sleep(3000);
		offerProductName = offersPage.getProductName();
		System.out.println(offerProductName+" is extracted from offers page");	
	}
	public void switchToOffersPage()
	{
		//if already switched then don't switch
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();
		
	}
	
	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_matches()
	{
		Assert.assertEquals(offerProductName, testContextSetup.homeProductName);
	}
}
