package browserFactory;

 
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowserInstance()
	{
		return driver;	
	}
	
	
	public static WebDriver startBrowser(String browserName,String applicationURL) throws MalformedURLException
	{

		
		if(browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome"))
		{
//			System.setProperty( "webdriver.chrome.driver","D:\\Software\\Chrome\\chromedriver-win64\\chromedriver.exe" );
//			 ChromeOptions option = new ChromeOptions();
//			 option.setBinary("D:\\Software\\Chrome\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
//			 	driver=new ChromeDriver(option);
			 
//			options.addArguments("--remote-allow-origins=*");
//			ChromeOptions chromeOptions = new ChromeOptions();
////			chromeOptions.addArguments("--remote-allow-origins=*");
//			chromeOptions.setCapability("browserVersion", "119.0");
//			chromeOptions.setCapability("platformName", "linux");
//			 
//			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
//			 
		 
			driver = new ChromeDriver(); 
			 
		}
		
		 
		
		
		
		else if(browserName.contains("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.contains("Safari"))
		{
			driver=new SafariDriver();
		}
		else if(browserName.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		else {
//			 System.setProperty( "webdriver.chrome.driver","D:\\Software\\Chrome\\chromedriver-win64\\chromedriver.exe" );
//			 ChromeOptions option = new ChromeOptions();
//			 option.setBinary("D:\\Software\\Chrome\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
//			driver=new ChromeDriver(option);
////			driver = new ChromeDriver();
//			 
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
//			  driver = new ChromeDriver(options);
//			ChromeOptions chromeOptions = new ChromeOptions();
////			chromeOptions.addArguments("--remote-allow-origins=*");
//			chromeOptions.setCapability("browserVersion", "119.0");
//			chromeOptions.setCapability("platformName", "linux");
//			 
//			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
			 driver = new ChromeDriver(); 
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		
		driver.get(applicationURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		return driver;
	}

}
