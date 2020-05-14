package webelement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		//driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input")).click();
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(100);
		Alert al=driver.switchTo().alert();
		String name=al.getText();
		System.out.println(name);
		al.accept();
	}
		
}

