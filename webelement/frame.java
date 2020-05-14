package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class frame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/a[6]/div/span")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("._26Vr")).click();
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		String actual= driver.findElement(By.cssSelector(".qrcode-footer-text > span:nth-child(1)")).getText();
		System.out.println("Frame link text is->"+driver.findElement(By.cssSelector(".qrcode-footer-text > span:nth-child(1)")).getText());
		Thread.sleep(5000);
		String expected="Login/Signup with mobile number and password";
		if(actual.compareTo(expected)==0)
		{
			System.out.println("passed");
			
		}
		else
			System.out.println("failed");
		
		

	}

}
