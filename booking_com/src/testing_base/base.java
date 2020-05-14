package testing_base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import testing_base.*;
import testing_base.*;
import testing_base.*;
import database_xlsx.xlsreader;

public class base {
	public static Properties CONFIG=null;
	public static Properties xpath=null;
	public static WebDriver dr=null;
	public static EventFiringWebDriver driver=null;
	public static boolean issearchin=false;
	public static boolean ischeckbox=false;
	public static boolean isLoggedIn=false;
	public static boolean isreg=false;
	public static boolean isdelcust=false;
	public static boolean isdelacc=false;
	public static boolean editcust=false;
	public static boolean iswithdraw=false;
	public static boolean isaddacc=false;
	public static boolean editacc=false;
	public static xlsreader datatable=null;;
	public static boolean isViewGoldPrice=false;
	public static boolean isBuyProduct=false;
	public static boolean isStoreLocator=false;
	public static boolean isStoreLocator1=false;
	public static boolean isStoreLocator2=false;
	public static boolean 	isViewProduct=false;
	public static boolean isSol=false;
	public static boolean isRadioButton=false;
	public static boolean isBuyProductgc=false;
	public static boolean isSolitaire=false;
	public static boolean isGoldMenu=false;
	public static boolean isgift=false;
	public static boolean isbrand=false;
	public static boolean isfacebook=false;
	public static boolean isOrder=false;
	
	public static WebElement getObject(String xpathKey) {
		try{
			return driver.findElement(By.xpath(xpath.getProperty(xpathKey)));
			
		}catch(Throwable t) {
			Assert.assertTrue(false,t.getMessage());
			return null;
		}
}
	public void intialize() throws IOException {
		if(driver==null) {
			//configuration property file
			CONFIG= new Properties();
			FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"//src//config_prt//conf.properties");
			CONFIG.load(fn);
			//OR properties file
		xpath=new Properties();
			fn=new FileInputStream(System.getProperty("user.dir")+"//src//config_prt//xpath.properties");
			xpath.load(fn);
			
			//initialize the web driver
			if(CONFIG.getProperty("browser").equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\training01\\Desktop\\MyJars\\geckodriver-v0.22.0-win64\\geckodriver.exe");
				dr=new FirefoxDriver();
				//dr = new FirefoxDriver();
			}else if(CONFIG.getProperty("browser").equals("IE")) {
				dr = new InternetExplorerDriver();
			}
			
			driver = new EventFiringWebDriver(dr);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
						
		}
}
