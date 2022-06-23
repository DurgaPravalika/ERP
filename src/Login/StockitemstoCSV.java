package Login;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StockitemstoCSV 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
        driver.get("http://webapp.qedgetech.com/login.php");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("master");
        driver.findElement(By.id("btnsubmit")).click(); 
       
        driver.findElement(By.linkText("Stock Items")).click();
        
        driver.findElement(By.xpath("//*[@data-original-title='Export']")).click();
        driver.findElement(By.xpath("//a[@data-caption='CSV']")).click();
        
        Thread.sleep(2000);
        boolean result=StockitemstoCSV.isfiledownload("Downloads","a_stock_items.csv");
        System.out.println("Result is " +result);
        
        
      }
	public static boolean isfiledownload(String path,String fname)
	{
		File dir = new File(path);
		  File[] dirContents = dir.listFiles();
		  //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  for (int i = 0; i <= dirContents.length; i++) 
		  {
		      if (dirContents[i].getName().equals(fname)) 
		      {
		          // File has been found, it can now be deleted:
		          dirContents[i].delete();
		          return true;
		      }
		  }
		  return false;
		
	}

}
