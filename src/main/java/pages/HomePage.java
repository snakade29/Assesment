package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

 

public class HomePage {

	WebDriver driver;
	
	public  HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='test-1-div']//form[@class='form-signin']//input[@type='email']")
	public WebElement email_Address ;
	
	@FindBy(xpath="//div[@id='test-1-div']//form[@class='form-signin']//input[@type='password']")
	public WebElement  password_Ele ;
	
	@FindBy(xpath=" //button[contains(text(),'Sign in')]")
	public WebElement   SignInBtn ;
	
	@FindBy(xpath="//*[@id='test-2-div']/ul/li")
	public List<WebElement> List_of_Item;
	
	@FindBy(xpath="//button[@id='dropdownMenuButton']")
	 public WebElement dropdown ;
	
	@FindBy(xpath=" //*[@id='test-4-div']/button[1]")
	 public WebElement  First_Button ;
	
	@FindBy(xpath=" //*[@id='test-4-div']/button[2]")
	 public WebElement  Second_Button ;
	
	@FindBy(xpath=" //button[@id='test5-button']")
	 public WebElement Pop_Button ;
	
 
	@FindBy(xpath="//div[@role='alert']")
	 public WebElement Pop_Message ;
	
	@FindBy(xpath="//*[@id='test-6-div']/div/table/tbody/tr")
	 public List<WebElement>  List_row ;
	
	
	
	
	 
 
	 
	
	public void VerifyElementPresent( ) {
		
	Assert.assertTrue(email_Address.isDisplayed());
	Assert.assertTrue( password_Ele.isDisplayed());
	Assert.assertTrue(SignInBtn.isDisplayed());
		
	}
	
	public void clear_details(WebElement ele)
	{
	      	ele.clear();	
	}
	
	 public void  EnterDetails(String email, String password) {
		 clear_details( email_Address );
		 email_Address.sendKeys(email);
		 clear_details( password_Ele );
		 password_Ele.sendKeys( password);
		 SignInBtn .click();	 
	 }
	 
	 public int Count_the_Items() {
		 return List_of_Item.size();
		  }
        
	 public boolean Contains_Item(String value)
	 {
		 System.out.println(List_of_Item.get(1).getText());
		 return List_of_Item.get(1).getText().contains(value);
	 }
	 
	 public boolean Contains_Value(String value)
	 {
		 WebElement ele = List_of_Item.get(1).findElement(By.xpath("//span[contains(text(),'6')]"));
		 System.out.println(ele.getText());
		  return List_of_Item.get(1).findElement(By.xpath("//span[contains(text(),'6')]")).getText().contains(value);
	 }
	 
	 public boolean Contains_option1ByDefault(String value)
	 {
		 
		 return dropdown.getText().contains(value);
	 }
	 
	 public void select_option(String option)
	 {
		 dropdown.click();
		 driver.findElement(By.xpath("//a[text()='"+option+"']")).click();
	 }
	 
 
	 
	 public String Find_Value_On_table(int row, int col) {
		    int rownum = row;
		    int colnum = col;
		     
		    String xpath = ".//td[" + (colnum + 1) + "]";  

		 
		    WebElement rowElement = List_row.get(rownum);

		   
		    WebElement cellElement = rowElement.findElement(By.xpath(xpath));

		     		    String cellText = cellElement.getText();
		    
		 
		    
		    return cellText;
		}

 

	 
	 
	 
	 
	 
	 
}
