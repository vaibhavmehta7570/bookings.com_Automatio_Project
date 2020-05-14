package booking_tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testing_base.base;
import util.testutil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;

public class car_rental_pickup extends base {
	static int i = 0;
	@DataProvider (name="car_rental")
	  public Object[][] acc_search() {
		  Object[][] arrayObject = testutil.getData("car_rental");
			return arrayObject;
	  }
	@Test(dataProvider = "car_rental")
  public void carrental_search(String cityname,String Status,String msg) throws InterruptedException, IOException {
	  driver.get(CONFIG.getProperty("autName"));
	  Thread.sleep(1000);
	  System.out.println(cityname);
	  testutil.carrental_search(cityname);
	  if(issearchin==true) {
		  testutil.setData("car_rental","status", cityname, "pass", "cityname");
		  testutil.setData("car_rental","message", cityname, "(pass)search has been done successful", "cityname");
		  testutil.takeScreenShot("cityname_pass"+i);
		  i++;
		  
	  }
	  else {
		  testutil.setData("car_rental","status", cityname, "failed", "cityname");
		  testutil.setData("car_rental","message", cityname, "(failed)search has been done successful", "cityname");
		  testutil.takeScreenShot("cityname_fail"+i);
		  i++;
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"carRentalsLink\"]")).click();
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
