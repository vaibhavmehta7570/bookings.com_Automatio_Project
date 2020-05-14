package stepdefination3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUp {
	WebDriver driver;
	 @Given("^Open chrome browser and launch the application$")
	 public void Open_firefox_and_launch_the_application() {
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\training01\\Desktop\\MyJars\\gecko\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get("https://www.booking.com/");
		 			 
	 }
	 @When("^User enters the username onto the username field$")
	 public void User_enters_the_username_in_the_username_field() throws InterruptedException {
		 
		 driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[4]/a/div")).click();
		 driver.findElement(By.xpath("//*[@id=\"login_name_register\"]")).sendKeys("lakshmi230156@gmail.com");
		 driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/button/span")).click();
			Thread.sleep(1000);
			String displTxt=driver.findElement(By.xpath("//*[@id=\"login_name_register-error\"]")).getText();
			String txt="You already have a Booking.com account registered to this email: lhamo30156@gmail.com.";
			if(displTxt.contains(txt))
				System.out.println("The Email address already exists ");
			
		 }
		 
	 @And("^User enter the password and confirm password onto pw and cpw field$")
	 public void User_enter_the_password_and_confirm_password_onto_pw_and_cpw_field() throws InterruptedException {
		 driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("lakshmi1234");
		 driver.findElement(By.xpath("//*[@id=\"confirmed_password\"]")).sendKeys("lakshmi1234");
		 
			//Thread.sleep(1000);
		 
		 
	 }
	 @When("^User clicks on the create account button$")
	 public void User_clicks_on_the_create_account_button() throws InterruptedException {	 
		 driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/button/span")).click();
			Thread.sleep(3000);
			 driver.findElement(By.xpath("//*[@id=\"wl252-firstname\"]")).sendKeys("lakshmi");
			 driver.findElement(By.xpath("//*[@id=\\\"wl252-lastname\\\"]")).sendKeys("x");
			 // driver.findElement(By.xpath("//*[@id=\"wl252-lastname\"]")).sendKeys("x");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/form/div[2]/button")).click();
			 driver.findElement(By.xpath("/html/body/div[24]/div[1]/div/form/div[1]/div/div/input")).sendKeys("9901245475");
			 driver.findElement(By.xpath("/html/body/div[24]/div[1]/div/form/div[2]/button")).click();
			 driver.findElement(By.xpath("/html/body/div[24]/div[1]/div/div[3]/a[2]")).click();
			 Thread.sleep(5000);
			  
	 }
	/* @Then("Validate if the user login is successful")
	 public void Validate_login_is_successful_or_not()
	 {
		 System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[5]/a/span[2]/span[1]")).getText());

		 driver.close();
	
}*/
	
	
}
