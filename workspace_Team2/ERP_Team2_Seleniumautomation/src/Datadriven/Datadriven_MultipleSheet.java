package Datadriven;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Datadriven_MultipleSheet {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	 /* DateFormat df=new SimpleDateFormat("yyyy-mm-dd hh-mm-ss a");
	  Date d= new Date();
	  String time=df.format(d);*/
	  FileInputStream fi= new FileInputStream("D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\TestData\\MultipleSheet.xls");
	  Workbook wb=Workbook.getWorkbook(fi);
	//  Sheet s[]=wb.getSheets();
	 Sheet s;
	  for(int i=0; i<wb.getSheets().length;i++)
	  {
		  //s[]=wb.getSheets();
		  s=wb.getSheet(i);
		  for(int j=1;j<s.getRows();j++)
		  {
		  try
		  {
			  if(s.getCell(2,i).getContents().equalsIgnoreCase("Text"))
			  {
				  driver.findElement(By.name(s.getCell(0,i).getContents())).sendKeys(s.getCell(3,i).getContents());
				  Thread.sleep(2000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("Dropdown"))
			  {
				 new Select(driver.findElement(By.id(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(3,i).getContents()); 
				  Thread.sleep(1000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("Button"))
			  {
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
				  Thread.sleep(1000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("popup"))
			  {
				  Set<String> windows=driver.getWindowHandles();
				  System.out.println(windows);
				  Object s1[]=windows.toArray();
				  System.out.println(s1[0].toString());
				  driver.switchTo().window(s1[0].toString());
				  driver.switchTo().window(s1[1].toString());
			  }
			
		}
		  
		  catch (Exception e) {}
			// TODO: handle exception
	  }
	  }  
  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	  driver.manage().window().maximize();
	 // driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);

  }

  @AfterTest
  public void afterTest() {
  }

}
