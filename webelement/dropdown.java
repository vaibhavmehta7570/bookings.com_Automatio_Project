package webelement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://timesofindia.indiatimes.com/");
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		List <WebElement>alldropdown=driver.findElements(By.tagName("option"));
		System.out.println(alldropdown.size());
		for(int i=0;i<alldropdown.size();i++)
		{
			System.out.println(alldropdown.get(i).getText());
		}
		WebElement droplist=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[13]/div[14]/select"));
		Select s=new Select(droplist);
		//s.selectByValue("23");
		//s.selectByIndex(6);
		s.selectByVisibleText("Bangalore");
	}

}
