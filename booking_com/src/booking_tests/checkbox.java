package booking_tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testing_base.base;
import util.testutil;

public class checkbox extends base{
	static int i = 0;
	@DataProvider (name="check_box")
	  public Object[][] acc_search() {
		  Object[][] arrayObject = testutil.getData("check_box");
			return arrayObject;
	  }
	@Test(dataProvider = "check_box")
	public void checkbox(String cityname,String Status,String msg) throws InterruptedException, IOException {
		  driver.get(CONFIG.getProperty("autName"));
		  Thread.sleep(1000);
		  System.out.println(cityname);
		  testutil.check_box(cityname);
		  if(ischeckbox==true) {
			  testutil.setData("check_box","status", cityname, "pass", "cityname");
			  testutil.setData("check_box","message", cityname, "(pass)search has been done successful", "cityname");
			  testutil.takeScreenShot("check_box"+i);
			  i++;
			  
		  }
		  else {
			  testutil.setData("check_box","status", cityname, "failed", "cityname");
			  testutil.setData("check_box","message", cityname, "(failed)search has been done successful", "cityname");
			  testutil.takeScreenShot("check_box"+i);
			  i++;
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
