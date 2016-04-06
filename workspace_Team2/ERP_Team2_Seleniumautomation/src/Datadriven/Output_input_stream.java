package Datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Output_input_stream {
	public WebDriver driver;
	public String str;
  @Test
  public void f() throws Exception, IOException {
	  DateFormat df=new SimpleDateFormat("yyyy-mm-dd hh-mm-ss a");
	  Date d= new Date();
	  String time=df.format(d);
	  FileInputStream fi= new FileInputStream("D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\TestData\\input1.xls");
	  Workbook wb=Workbook.getWorkbook(fi);
	  Sheet s=wb.getSheet(0);
	  
	 // FileOutputStream
	  
	  FileOutputStream fo=new FileOutputStream("D:\\workspace_Team2\\ERP_Team2_Seleniumautomation\\Result\\"+time+"results.xls");
	  WritableWorkbook wb1= Workbook.createWorkbook(fo);
	  WritableSheet ws= wb1.createSheet("result", 0);
	  for(int c=3;c<s.getColumns();c++)
	  {
	  for(int i=1; i<s.getRows();i++)
	  {
		  try 
		  {
			  if(s.getCell(2,i).getContents().equalsIgnoreCase("text Box"))
			  {   
				  
				  driver.findElement(By.id(s.getCell(0,i).getContents())).sendKeys(s.getCell(c,i).getContents());
				  Thread.sleep(1000);
				 // driver.findElement(By.id(s.getCell(0,i).getContents())).clear();
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("Drop Down"))
			  {
				new Select(driver.findElement(By.id(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(c,i).getContents());
				  Thread.sleep(1000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("Button"))
			  {
				  System.out.println("Button");
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
				  
				  Thread.sleep(2000);
			  }
			  else if (s.getCell(2,i).getContents().equalsIgnoreCase("popup"))
			  {
				 Set<String> windows=driver.getWindowHandles();
				  System.out.println(windows);
				  Object s1[]=windows.toArray();
				  System.out.println(s1[0].toString());
				 // driver.switchTo().window(s1[0].toString());
				  
				  driver.switchTo().window(s1[1].toString());
                 
			  
				  Thread.sleep(1000);
			  }
			  else if (s.getCell(2,i).getContents().equalsIgnoreCase("popup1"))
			  {
				 Set<String> windows=driver.getWindowHandles();
				  System.out.println(windows);
				  Object s1[]=windows.toArray();
				  System.out.println(s1[0].toString());
				 // driver.switchTo().window(s1[0].toString());
				  
				  driver.switchTo().window(s1[0].toString());
                 
			  
				  Thread.sleep(1000);
			  }
			  str="pass";
		  } 
		  catch (Exception e) 
		  {
			 str="fail"; 
		  }
		  
		  Label result=new Label(5,i,str);
		  ws.addCell(result);
		  Label result1=new Label(6,i,str);
		  ws.addCell(result1);
		  for(int j=0;j<s.getColumns();j++)
		  {
			  System.out.println(s.getCell(j,i).getContents());
			  Label l=new Label(j,i,s.getCell(j,i).getContents());
			  ws.addCell(l);
		  }
		  
		 
	  }    // i for loop
	  Label OR=new Label(0,0,"ObjectRepo");
	  Label DisName=new Label(1,0,"DisplayName");
	  Label OBType=new Label(2,0,"Object Type");
	  Label TData1=new Label(3,0,"TestData1");
	  Label TData2=new Label(4,0,"TestData2");
	  Label Rs= new Label(5,0,"Result1");
	  Label Rs1= new Label(6,0,"Result2");
	  ws.addCell(OR);
	  ws.addCell(DisName);
	  ws.addCell(OBType);
	  ws.addCell(TData1);
	  ws.addCell(TData2);
	  ws.addCell(Rs); 
	  ws.addCell(Rs1); 
	  wb1.write();
	  wb1.close();
	  
	  }
  }
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);

  }

  @AfterTest
  public void afterTest() {
  }

}
