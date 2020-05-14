package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class google_auto_suggest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com/");
		driver.findElement(By.name("q")).sendKeys("hello there");
		Thread.sleep(5000);
	
		String part1="//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul/li[";
		String part2="]/div/div[2]/div/span";
	
		for(int i=1;i<=8;i++)
		{
			String text=driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(text);
		}

	}

}
