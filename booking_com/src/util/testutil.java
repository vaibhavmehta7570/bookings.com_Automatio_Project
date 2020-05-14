package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import database_xlsx.xlsreader;
import testing_base.base;

public class testutil extends base{
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static void carrental_search(String cityname)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		try
		{
			driver.findElement(By.linkText("Car Rentals")).click();
		}
		catch(Exception e)
		{
			System.out.println("website is dynamic");
			driver.findElement(By.linkText("Car rentals")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.id("ss_origin")).sendKeys(cityname);
		driver.findElement(By.xpath("//*[@id=\"frm\"]/div[2]/div[1]/div/div[1]/ul[1]/li[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"frm\"]/div[2]/div[4]/div[2]/button")).click();
		Thread.sleep(6000);
		
		String default_val=driver.findElement(By.xpath("//*[@id=\"searchAgainTop\"]/div/h2")).getText();
		System.out.println("default value is -> "+default_val);
		String actual_error="Let’s find your ideal car";
		if(actual_error.compareTo(default_val)==0)
		{
			System.out.println("pass");
			issearchin=true;
		}
		else
		{	
			System.out.println("fail");
			issearchin=false;
		}
	}
	public static void check_box(String cityname)throws InterruptedException, IOException
	{
		driver.findElement(By.linkText("Car Rentals")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ss_origin")).sendKeys(cityname);
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[1]/div/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[3]/label[1]/span[1]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/form/div[2]/div[4]/div[2]/button")).click();
		
		
		String actual=driver.findElement(By.xpath("//*[@id=\"frm\"]/div[3]/div/div")).getText();
		System.out.println(actual);
		String expected="Error:\n"+ 
				"Driver needs to be between 20 and 99 years old";
		if(expected.compareTo(actual)==0)
		{
			System.out.println("pass");
			ischeckbox=true;
		}
		else
		{	
			System.out.println("fail");
			ischeckbox=false;
	
		}
	}
	
	
public static void doLogin(String username,String password) throws InterruptedException, IOException{
	
	
		
//		getObject("signin_link").click();
		Thread.sleep(3000L);
	//	System.out.println(username+" "+password);
	getObject("loginlink").click();
	Thread.sleep(5000);
	log.debug("Click on sign in button");
	
	getObject("email").sendKeys(username);
	log.debug("enter email address");
	getObject("nextButton").click();
	log.debug("click on next button");
	Thread.sleep(5000);
	getObject("password").sendKeys(password);
	log.debug("enter password");
	getObject("signin").click();
	log.debug("click on log in button");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"current_account\"]/a/span[1]/img")).click();
			//driver.findElement(By.xpath("//*[@id=\"current_account\"]/a/span[1]/img")).click();
			Thread.sleep(3000);
			String displayedUserName=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/a")).getText();
			log.debug("Validating if user signed in or not");
			System.out.println(displayedUserName);
			String logout = "Edit your profile";
			if(displayedUserName.compareTo(logout)==0) 
			{
				isLoggedIn=true;	
				log.debug("username and password is correct");
				//setData("LoginTest","Status",username,"PASS","userid");
				
			}
			else
			{
				log.debug("invalid credentials");
				isLoggedIn=false;	
				
				//TestUtil.setData("LoginTest","Status",username,"FAIL","userid");
			}
		} catch (Throwable t) {
			isLoggedIn=false;
			log.debug("invalid credentials");
			
		}
		
	}
	public static Object[][] getData(String testName) {
		//return test data
		// read test data from xls
		if(datatable == null) {
			//load the suite 1 sheet
			datatable = new xlsreader(System.getProperty("user.dir")+"//src//config_prt//Suite.xlsx");
		}
		
		int rows = datatable.getRowCount(testName)-1;
		if(rows<=0) {
			Object[][] testData = new Object[1][0];
			return testData;
		}
		rows = datatable.getRowCount(testName);
		int cols = datatable.getColumnCount(testName);
		System.out.println("Test NAme--"+testName);
		log.debug("Test NAme--"+testName);
		System.out.println("total rows --"+rows);
		log.debug("total rows --"+rows);
		System.out.println("total cols -- "+cols);
		log.debug("total cols --"+cols);
		Object data[][] = new Object[rows-1][cols];
		
		for(int rowNum = 2;rowNum<=rows;rowNum++) {
			for(int colNum = 0;colNum<cols;colNum++) {
				data[rowNum-2][colNum]=datatable.getCellData(testName,colNum,rowNum);
			}
		}
		log.debug("returning data");
		return data;
	}
	
	public static void setData(String testName,String colName,String existrowVal,String status,String existcolName) {

		xlsreader setdata = new xlsreader(System.getProperty("user.dir")+"//src//config_prt//Suite.xlsx");
		int num=setdata.getCellRowNum(testName, existcolName, existrowVal);
		System.out.println(num);
		log.debug("printing--"+num);
		System.out.println(status);
		log.debug("printing--"+status);
		setdata.setCellData(testName, colName, num, status);

		}
	
	public static void takeScreenShot(String fileName) throws InterruptedException {
		
		
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Thread.sleep(3000);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".jpg"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	} 
	public static void logout() throws InterruptedException {
		if(isLoggedIn) {
			//Thread.sleep(3000L);
			//getObject("signout_dropdown").click();;
				//Thread.sleep(2000);
			
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[5]/a/span[1]/img")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[5]/a/span[1]/img")).click();
	
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("input.profile-menu__link")).click();
			log.debug("user is signing out");
			
		}
		
	}
}
