package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class booking_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
			
		//driver.findElement(By.cssSelector("a.xpb__link:nth-child(4) > span:nth-child(2)")).click();
		//driver.findElement(By.id("ss_origin")).sendKeys("bengaluru");
		String default_val=driver.findElement(By.id("ss_origin")).getAttribute("placeholder");
		System.out.println("default value is -> "+default_val);
		driver.findElement(By.id("ss_origin")).sendKeys("bengaluru");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[1]/div/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[4]/div[2]/button/span[1]")).click();
		Thread.sleep(5000);
		String error=driver.findElement(By.cssSelector(".result__subheadline")).getText();
		System.out.println("actual value is->"+error);
		String city="Recife - Cordeiro";
		if(city.equals(error))
			System.out.println("test case pass");
		else
			System.out.println("test case fail");
	}

}
