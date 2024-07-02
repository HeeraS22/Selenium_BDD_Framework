package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src/test/resources/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QA_URL");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		//ternary operation// result=testcondition? value1: value2
		String browser = browser_maven!=null?  browser_maven : browser_properties;
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				//System.setProperty("webdriver.chrome.driver", "D:\\SeleniumFolder\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
				//firefox code9
				System.out.println("firefox");
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);   
		}
		return driver;
	}
}
