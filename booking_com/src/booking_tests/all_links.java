package booking_tests;
import testing_base.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import  org.apache.poi.hssf.usermodel.HSSFSheet;  
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import  org.apache.poi.hssf.usermodel.HSSFRow;


public class all_links extends base{
  @SuppressWarnings("deprecation")
@Test
  public void f() {
	  try
	  {
		  driver.get(CONFIG.getProperty("autName"));
		  
		  String filename="C:\\Users\\training01\\Desktop\\training\\final\\booking_com\\src\\config_prt\\Suite1.xlsx" ;
		 
		  HSSFWorkbook hwb=new HSSFWorkbook();
		  FileOutputStream file1=new FileOutputStream(new File(filename));
		
		  HSSFSheet sheet =  hwb.createSheet("Sheet1");
		  
		  List <WebElement>alllinks=driver.findElements(By.tagName("a"));
		 // System.out.println(alllinks.size());
		  HSSFRow row=   sheet.createRow((short)0);
		  HSSFCell cell;
		  for(int i=1;i<alllinks.size();i++)
			{
			  cell = row.createCell(0);
			  
			  cell.setCellValue(new HSSFRichTextString(alllinks.get(i).getText()));
			  
			  String l=alllinks.get(i).getText();
			  //row = sheet.createRow(i);
			  //row.createCell(i).setCellValue(l);
			  System.out.println(l);
		  
			} 
		  file1.close();
		  FileOutputStream  fileout = new FileOutputStream (new File(filename));
		  hwb.write(fileout);
		  fileout.close();
		  System.out.println("-----------------------------------------------------------------TEST CASE runned sucessfully---------------------------------------------------");
		  System.out.println("total test cases are"+alllinks.size());
		  int expected= alllinks.size();
		  int actual=292;
		  if(actual==expected)
		  {
			  System.out.println("Test case pass");
		  }
		  else
		  {
			  System.out.println("Test case fail");
			    
		  }
		  
		  
	  }
	  catch(Exception e)
	  {
		System.out.println(e.getMessage());  
	  }
	
	  
  }

@BeforeClass
public void beforeClass() throws IOException {
	  intialize(); 
}
@AfterClass
public void afterClass() {
	  driver.close();
}
}