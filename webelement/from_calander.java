package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class from_calander {
	public static void main(String[]args) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
		driver.findElement(By.linkText("Car Rentals")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ss_origin")).sendKeys("bengaluru");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[1]/div/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[3]/label[1]/span[1]")).click();
		driver.findElement(By.id("driverAgeInput")).sendKeys("20");
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[4]/div[2]/button")).click();
		Thread.sleep(9000);
		String actual=driver.findElement(By.cssSelector(".no_results > h1:nth-child(2)")).getText();
		Thread.sleep(9000);
		System.out.println("actual text is->"+actual);
		String expected="Error:\n"+"Driver needs to be between 20 and 99 years old" ;
		if(expected.compareTo(actual)==0)
		{
			System.out.println("fail");
		}
		else
		{
			System.out.println("pass");
		}	
	}

	
}
