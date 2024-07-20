package Reusable;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable {
	

	

 
	


 
 
	
	
	
 
		

	 
	
	public static void waitForSeconds(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) 
		{
		
		}
	}
	
	// Sample Code
	public static void multipleScreenshot(int timeInterval,int totalDuration)
	{
		for(int i=0;i<totalDuration;i++)
		{
			
			try 
			{
				Thread.sleep(timeInterval);
			} catch (InterruptedException e) {
				
			}
			
		}
		
	}
	
	
	public static String captureScreenshotInBase64(WebDriver driver)
	{
	
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		String base64=ts.getScreenshotAs(OutputType.BASE64);
		
		return base64;
		
	}
	
	public static void captureScreenshot(WebDriver driver)
	{
		try 
		{
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("./screenshots/Screenshot_"+getCurrentTime()+".png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Something went wrong "+e.getMessage());
		}
	}
	
	public static String getCurrentTime()
	{
		String date=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		
		return date;
	}
	
	 public static void WaitForVisibilityOfElement(WebDriver driver , WebElement element)

	    {
	    	try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Use Duration.ofSeconds
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			}
	    	
	    }
	
	
}
