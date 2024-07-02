package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextStepup;

public class Hooks 
{
	TestContextStepup testContextStepup;
	
	public Hooks(TestContextStepup testContextStepup)
	{
		this.testContextStepup = testContextStepup;
	}
	@After
	public void AfterScenario() throws Exception
	{
		testContextStepup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws Exception
	{
		WebDriver driver = testContextStepup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
			File sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
}
