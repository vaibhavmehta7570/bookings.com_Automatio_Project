package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class navigate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://booking.com");
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
			
		}
		
		
	}	

}
