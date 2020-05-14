package webelement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class working_with_textboxes {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.findElement(By.id("inputValEnter")).sendKeys("mobile");
		driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div[2]/button/span")).click();
		String default_val=driver.findElement(By.id("inputValEnter")).getAttribute("placeholder");
		System.out.println("default value is -> "+default_val);
		String val=driver.findElement(By.id("inputValEnter")).getAttribute("value");
		System.out.println("actual value is -> "+val);
	}

}
