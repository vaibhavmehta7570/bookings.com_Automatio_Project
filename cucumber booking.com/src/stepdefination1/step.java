package stepdefination1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class step {
	WebDriver driver;
	public String path=System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
	@Given("^Launch the browser and open application$")
	public void Launch_the_browser_and_open_application() throws Throwable
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	@When ("^click on sign in button$")
	public void click_on_sign_in_button() throws Throwable
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[5]/a/div/span")).click();
		
	}
	@And ("^enter the valid email address and click on next button$")
	public void enter_the_valid_email_address_and_click_on_next_button() throws Throwable
	{
		driver.findElement(By.id("username")).sendKeys("urvijain1010@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div/div/div/form/div[3]/button/span")).click();
	}
	@And("^enter the password and click on sign in button$")
	public void enter_the_password_and_click_on_sign_in_button() throws Throwable
	{
		driver.findElement(By.id("password")).sendKeys("urvi1010");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div/div/div/form/button/span")).click();
	}
	@Then("^Validate if User is sucessfully loged in$")
	public void Validate_if_User_is_sucessfully_loged_in() throws Throwable
	{
		String actual=driver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/div[3]/div/div/h2/span")).getText();
		System.out.println("actual value is->"+actual);
		String expected="Where to next, urvi?";
		if(expected.compareTo(actual)==0)
		{
			System.out.println("pass");
			driver.close();
		}
		else
			System.out.println("fail");
		driver.close();
	
	}
	
	
}
