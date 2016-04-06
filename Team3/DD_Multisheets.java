package com.erp;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DD_Multisheets extends Helper{
  @Test
  public void Read_Sheets() throws Exception{
	  DateFormat df = new SimpleDateFormat("yyyy_mmm_dd_hh_mm_ss a");
	  Date d = new Date();
	  String time = df.format(d);
	  System.out.println(time);
	  
	  FileInputStream fis =new FileInputStream("D:\\WorkingDir-Team2\\ERP_Team2\\InputData.\\Input_Multi.xls");
	  Workbook w = Workbook.getWorkbook(fis);
	  Sheet s;
	  for(int j=0;j<w.getSheets().length;j++)
	  {
		 s = w.getSheet(j);
	  
	  
	  for(int i=1;i<s.getRows();i++)
	  {
		 if(s.getCell(2, i).getContents().equalsIgnoreCase("Link"))
		 {
			 windows_Handler();
			 driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
		 }
		 else if(s.getCell(2, i).getContents().equalsIgnoreCase("Textbox"))
		 {
			 driver.findElement(By.name(s.getCell(0, i).getContents())).sendKeys(s.getCell(3, i).getContents());
		 }
		 else if(s.getCell(2, i).getContents().equalsIgnoreCase("Dropdown"))
		 {
			 windows_Handler();
			 new Select(driver.findElement(By.id(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(3, i).getContents());
		 }
		 else if(s.getCell(2, i).getContents().equalsIgnoreCase("Button"))
		 {
			 driver.findElement(By.name(s.getCell(0, i).getContents())).click();
		 }
		 else if(s.getCell(2, i).getContents().equalsIgnoreCase("Save Record"))
		  {
			  driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
			  System.out.println("Printing Result Text: "+ driver.findElement(By.xpath(".//*[@id='json_save_header']/div")).getText());
	 	  }
		 else if(s.getCell(2, i).getContents().equalsIgnoreCase("wait"))
		  {
			  Thread.sleep(3000);
		  }
	  }
	  }
	  	  
  }
}
