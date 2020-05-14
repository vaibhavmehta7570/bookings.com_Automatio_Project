package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class booking {
	public static void main(String [] args) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[5]/a/div/span")).click();
		driver.findElement(By.id("username")).sendKeys("urvijain1010@gmail.com");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/div[3]/button/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("urvi1010");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/button")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("/html/body/div[2]/div/span/span[2]")).click();
		driver.findElement(By.linkText("Car Rentals")).click();
		//driver.findElement(By.id("ss_origin")).sendKeys("bengaluru");
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[4]/div[2]/button")).click();
		String default_val=driver.findElement(By.id("ss_origin")).getAttribute("placeholder");
		System.out.println("default value is -> "+default_val);
		String error=driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[1]/div/div[2]/div")).getText();
		System.out.println(error);
		String actual_error="Error:\n"+"Enter a pickup location";
		if(actual_error.compareTo(error)==0)
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
		
	
		
		
		
			
		
		
		
		
		
	}

}
