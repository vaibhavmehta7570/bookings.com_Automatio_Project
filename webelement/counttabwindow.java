package webelement;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class counttabwindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
		Set<String> winids=driver.getWindowHandles();
		System.out.println("total browsers->"+winids.size());
		Iterator<String>  it=winids.iterator();
		System.out.println(it.next());
		driver.findElement(By.linkText("Flights")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Rental cars")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/a[3]/span")).click();
		
		System.out.println("-------------------------------------");
		winids=driver.getWindowHandles();
		System.out.println("total windows->"+winids.size());
		it=winids.iterator();
		String mainwinid=it.next();
		String tabwinid=it.next();
		System.out.println(mainwinid);
		System.out.println(tabwinid);
		driver.switchTo().window(tabwinid);
		Thread.sleep(5000);
		driver.findElement(By.id("ss_origin")).sendKeys("bengaluru");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[1]/div/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(4000);
		String newtabtext=driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/h1/span")).getText();
		System.out.println("actual value is "+newtabtext);
		String expected="Car rentals for any kind of trip" ;
		System.out.println("expected value is "+expected);
		
		if(expected.equals(newtabtext))
		{
			System.out.println("test case pass");
			
		}
		else
			System.out.println("test case fail");
		
	}

}
