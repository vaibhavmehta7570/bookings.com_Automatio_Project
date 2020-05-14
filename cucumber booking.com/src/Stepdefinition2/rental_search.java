package Stepdefinition2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class rental_search {
	
	WebDriver driver;
	 @Given("^Open chrome browser and launch the application$")
	 public void Open_firefox_and_launch_the_application() 
	 {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get("https://www.booking.com");
		 
	}
	 
	 @When("^user logged in to the application$")
	 public void user_logged_in_to_the_application() throws InterruptedException 
	 {
		 driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[5]/a/div/span")).click();
		 driver.findElement(By.id("username")).sendKeys("urvijain1010@gmail.com");
		 driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/div[3]/button/span")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.id("password")).sendKeys("urvi1010");
		 driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/button/span")).click();
		 Thread.sleep(5000);
	 }
	 
	 @And("^User clicks on the car rental option$")
	 public void  User_clicks_on_the_car_rental_option() throws InterruptedException 
	 {
		 Thread.sleep(5000);
		 driver.findElement(By.linkText("Car Rentals")).click();
		 Thread.sleep(5000);
		 
			
	 }
	 
	 
	 @And("^enter a pickup location$")
	 public void enter_a_pickup_location() throws InterruptedException 
	 {
		 driver.findElement(By.id("ss_origin")).sendKeys("madrid airport");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//*[@id=\"frm\"]/div[2]/div[1]/div/div[1]/ul[1]/li[1]")).click();
			Thread.sleep(5000);
	 }
	 
	 @When("^user clicks on the search button$")
	 public void user_clicks_on_the_search_button() throws InterruptedException
	 {
		 driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[4]/div[2]/button")).click();
		 Thread.sleep(9000);
	 }
	 
	 @Then("^Validate if the user is able to search car$")
	 public void Validate_if_the_user_is_able_to_search_car() throws InterruptedException
	 {
		String actual=driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div[1]/form/div/div/h2")).getText();
		System.out.println("actual value is-> "+actual);
		String expected="Let’s find your ideal car";
		if(expected.compareTo(actual)==0)
				{
			      System.out.println("Test is passed");
				}
		else
			System.out.println("Test is failed");
	 }

}
