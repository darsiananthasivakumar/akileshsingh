package Com.erp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Helper {
	public WebDriver driver;
	

  public void login() throws Exception 
  {
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
	  Thread.sleep(2000);
	 driver.findElement(By.id("username")).sendKeys("admin");
	 driver.findElement(By.id("password")).sendKeys("admin");
	 new Select(driver.findElement(By.name("user_language[]"))).selectByVisibleText("English");
	  driver.findElement(By.name("submitLogin")).click();
	  Thread.sleep(3000);
	  
  }
  public void NewAccount() throws Exception {
	  
	  try {
		  //driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		 //Thread.sleep(3000);
		  driver.findElement(By.id("ui-id-2")).click();
		  driver.findElement(By.name("first_name[]")).sendKeys("akhilesh");
		  driver.findElement(By.name("last_name[]")).sendKeys("singh");
		  driver.findElement(By.name("username[]")).sendKeys("akh123");
		  driver.findElement(By.name("email[]")).sendKeys("akhill@gmail.com");
		  driver.findElement(By.id("enteredPassword")).sendKeys("akh123");
		  driver.findElement(By.id("enteredRePassword")).sendKeys("akh123");
		  driver.findElement(By.name("phone[]")).sendKeys("9300317404");
		  driver.findElement(By.name("newUser")).click();
		  Thread.sleep(2000);
		
	} catch (Exception e) {}
  }
  public void userlogin() throws Exception 
  {
	  try {
		  driver.findElement(By.xpath(".//*[@id='ui-id-1']")).click();
		  Thread.sleep(5000);
		 driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[3]/div/div/div[1]/form/ul/li[1]/input")).sendKeys("admin");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[3]/div/div/div[1]/form/ul/li[2]/input")).sendKeys("admin");
		 new Select(driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[3]/div/div/div[1]/form/ul/li[3]/select"))).selectByVisibleText("English");
		  driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[3]/div/div/div[1]/form/ul/li[4]/input")).click();
		  Thread.sleep(3000);
		  
		
	} catch (Exception e) {}
	  	  
  }
  
  public void Inventory() throws Exception
  {
	  try {
		  driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
		  Thread.sleep(1000);
		  
		  //for Data Driven
		  
		  String str= driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form")).getText();
		  System.out.println(str);
		  String s[]=str.split("\n");
			for(int i=0;i<s.length;i++)
			{
				if(s[i].equalsIgnoreCase(""))
				{
					System.out.println(s[i]);
				}
			}     //End Data Driven
			
		  /*driver.findElement(By.xpath(".//*[@id='item_id']")).click();
		  driver.findElement(By.xpath(".//*[@id='tabsHeader-1']/ul/li[2]/i")).click();
		  Thread.sleep(3000);
		  Set<String> windows=driver.getWindowHandles();
		  System.out.println(windows);
		  Object s[]=windows.toArray();
		  System.out.println(s[0].toString());
		  driver.switchTo().window(s[1].toString());
		  driver.switchTo().window(s[0].toString());*/
		
	} catch (Exception e) {}
	  
  }
  public void itemNum_ajax() throws Exception
  {
	  try {
		  driver.findElement(By.id("item_number")).sendKeys("ma");
		  Thread.sleep(1000);
		  String str;
		  str=driver.findElement(By.xpath(".//*[@id='ui-id-40']")).getText();
		  System.out.println(str);
		  String s[]=str.split("\n");
		  System.out.println("String Length"+s.length);
		  for(int i=0;i<s.length;i++)
		  {
			if(s[i].equalsIgnoreCase("MAKE_001"))
			{
				System.out.println(s[i]);
				Thread.sleep(4000);
				driver.findElement(By.xpath(".//*[@id='item_number']")).clear();
				//driver.findElement(arg0)
				 // Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='item_number']")).sendKeys(s[i]);
				driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/ul/li[1]/a")).click();
			}
		  }
	} catch (Exception e) {}
	  
	  
  }
  public void Dashboard_allLink() throws Exception
  {
	  try {
		  String str=driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/form/div/div")).getText();
			System.out.println(str);
			String s[]=str.split("\n");
			for(int i=0;i<s.length;i++)
			{
				if(!s[i].equalsIgnoreCase(""))
				{
					System.out.println(s[i]);
					driver.findElement(By.linkText(s[i])).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
					Thread.sleep(2000);
				}
			}
		
	} catch (Exception e) {}
	 
	  
  }
  public void Inventory_allLink() throws Exception
  {
	  try {
		  driver.findElement(By.xpath(".//*[@id='sys_menu_left_vertical']/div[2]/ul/li[5]")).click();
		  Thread.sleep(2000);
		 // driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/div/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
		 //String str1=driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]")).getText();
		 //System.out.println(str1);
		  //List<WebElement> str1=driver.findElements(By.xpath(".//*[@id='sys_menu_left_vertical']/div[2]/ul/li[5]/ul"));
		  
		  String str1 = driver.findElement(By.xpath(".//*[@id='sys_menu_left_vertical']/div[2]/ul/li[5]/ul")).getText();
				  System.out.println(str1.length());
		  System.out.println(str1);
			  String s[]=str1.split("\n");
				 for(int i=0;i<s.length; i++)
				 {
					 System.out.println(s[i]);
					 driver.findElement(By.linkText(s[i])).click();
					 Thread.sleep(2000);
				 }
		
	} catch (Exception e) {}
	  
	 
  }
  
  public void item_masterall_links() throws Exception {
	  try {
		  driver.findElement(By.xpath(".//*[@id='sys_menu_left_vertical']/div[2]/ul/li[5]/ul")).click();
		  driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div/div[2]/div/div[2]/ul/li[5]/ul/li[1]/a")).click();
		  Thread.sleep(2000);
		  
		  for (int i = 1; i <=2; i++) 
		  {
			  for (int j = 1; j < 10; j++) 
			  {
				  driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form/div["+i+"]/div/ul/li["+j+"]/a")).click();
				
			}
		  }
		 /* driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/a/i")).click();
		  Thread.sleep(2000);
		 
		 
		 
		 
		  driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
		  Thread.sleep(3000);
		  //WebElement str1 = driver.findElement(By.xpath(".//*[@id='erp_form_area']"));
		  for(int i=22; i<=39; i++)
		  {
			  driver.findElement(By.id("ui-id-"+i)).click();
		  }*/
		 
	} catch (Exception e) {
		
	}
	  
	 
  }
  public void Org_ID() throws Exception
  {
	  new Select(driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div/form/div[1]/div/div/div[1]/ul/li[1]/select"))).selectByVisibleText("MAS");
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://localhost/erp/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	 // driver.quit();
  }

}
