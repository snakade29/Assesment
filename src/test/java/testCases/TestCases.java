package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Reusable.Reusable;
import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.HomePage;
 

public class TestCases extends BaseClass {

	@Test(dataProvider = "loginDetails",dataProviderClass = CustomDataProvider.class,priority = 1)
	public void  Testcase1 (String  Username ,String password)
	{
		HomePage home=new  HomePage(driver);
		home.VerifyElementPresent();
		home.EnterDetails(Username, password);	
     }
	@Test(priority = 2)
	public void  Testcase2 ( )
	{
		HomePage home=new  HomePage(driver);
		Assert.assertEquals(home.Count_the_Items(),3);
		Assert.assertTrue(home.Contains_Item("List Item 2"));
		Assert.assertTrue(home.Contains_Value("6"));
    }
   
	@Test(priority = 3)
	public void Testcase3()
 	{
 		HomePage home=new  HomePage(driver);
 		Assert.assertTrue(home.Contains_option1ByDefault("Option 1"));
 		home.select_option("Option 3");
 	}

	@Test(priority = 4)
	public void Testcase4()
 	{
 		HomePage home=new  HomePage(driver);
 		 Assert.assertTrue(home.First_Button.isEnabled()); 
		 Assert.assertFalse(home.Second_Button.isEnabled());	 
 	}
	
	
	@Test(priority = 5)
	public void Testcase5()
 	{
 		HomePage home=new  HomePage(driver);
 		Reusable.WaitForVisibilityOfElement(driver,home.Pop_Button);
 		home.Pop_Button.click();
 		Assert.assertTrue(home.Pop_Message.isDisplayed()); 
 		 Assert.assertFalse(home.Pop_Button.isEnabled());
 	}
	
	
	
    @Test (priority = 6)
 	public void Testcase6() throws InterruptedException
 	{
  		HomePage home=new  HomePage(driver);
     Assert.assertEquals(home.Find_Value_On_table(2, 2),"Ventosanzap"); 
  		 
 	}
 
	
	
	
	
	
	
	
}
 