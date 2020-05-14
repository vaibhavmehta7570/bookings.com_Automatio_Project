package webelement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Total_Link {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://timesofindia.indiatimes.com/");
		//driver.manage().window().pageLoadTimeout(40,TimeUnit.SECONDS);
		List <WebElement>alllinks=driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
		for(int i=0;i<alllinks.size();i++)
		{
			System.out.println(alllinks.get(i).getText());
		}
	}

}
