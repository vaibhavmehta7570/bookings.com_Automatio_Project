package webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class radiobutton_count {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		List <WebElement> allradio=driver.findElements(By.xpath("//span[@class='tabsCircle appendRight5']"));
		System.out.println("total radio buttons are->"+allradio.size());
		//List <WebElement> radio=driver.findElements(By.xpath(".selected"));
		for(int i=0;i<allradio.size();i++)
		{
			System.out.println(""+allradio.get(i).getText());
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ul/li[3]/span")).click();
	}	

}
