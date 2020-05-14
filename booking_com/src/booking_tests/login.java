package booking_tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testing_base.base;
import util.*;

public class login extends base{
	static int i = 0;
	@DataProvider(name="login")
	 public Object[][] loginData() {
	 			Object[][] arrayObject = testutil.getData("login");
	 			return arrayObject;
	 		}
	  @Test(dataProvider = "login")
	  public void loginTest1(String username,String password,String Status,String message) throws InterruptedException, IOException 
	  {
		  
		  driver.get(CONFIG.getProperty("autName"));
			//login
			testutil.doLogin(username,password);
			if(isLoggedIn==true){ 
				testutil.setData("login","Status",username,"pass","userid");
				testutil.setData("login", "message", username, "login(success) testcase is successful", "userid");
			
			}
			else{
				
				testutil.setData("login","Status",username,"fail","userid");
				testutil.setData("login", "message", username, "login(failure) testcase is successful", "userid");
				Thread.sleep(3000);
				testutil.takeScreenShot("login"+i);
				i++;
				}
			
			
			Thread.sleep(3000L);
			
		
			
			
		}
	  @BeforeMethod
	  public void beforeMethod() {
	  }

	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		  Thread.sleep(3000L);
		testutil.logout();
		
	  }


	 
	 
	  @BeforeClass
	  public void beforeClass() throws IOException {
		  intialize();
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

	  @BeforeTest
	  public void beforeTest() {
	  }

	  @AfterTest
	  public void afterTest() {
	  }

	  @BeforeSuite
	  public void beforeSuite() {
	  }

	  @AfterSuite
	  public void afterSuite() {
	  }
}
