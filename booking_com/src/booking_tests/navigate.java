package booking_tests;
import testing_base.base;
import util.*;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class navigate extends base{
  @Test
  public void f() throws InterruptedException {
	  driver.get(CONFIG.getProperty("autName"));
	  driver.findElement(By.linkText("Car Rentals")).click();
		
		
		driver.navigate().back();
		
		Thread.sleep(5000);
	
		
		String newtabtext1=driver.findElement(By.xpath("/html/body/div[3]/div/div/h2/span")).getText();
		System.out.println("actual value is "+newtabtext1);
		String expected1="Find deals for any season";
		System.out.println("expected value is "+expected1);
		
		driver.navigate().forward();
		
		String newtabtext=driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/h1/span")).getText();
		System.out.println("actual value is "+newtabtext);
		String expected="Car rentals for any kind of trip" ;
		System.out.println("expected value is "+expected);
		
		if((newtabtext1.compareTo(expected1)==0)&&(newtabtext.compareTo(expected)==0))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
			testutil.takeScreenShot("Nav");
			
		}
	  
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  intialize();
  }
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
