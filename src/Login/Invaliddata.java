package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Invaliddata {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
        driver.get("http://webapp.qedgetech.com/login.php");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys("abc");
        driver.findElement(By.id("password")).sendKeys("mas");
        driver.findElement(By.id("btnsubmit")).click(); 
        
        //TC4 verify reset button is working or not
        driver.findElement(By.id("btnreset")).click();
        System.out.println("Invalid data");
        String name=driver.findElement(By.id("username")).getAttribute("value");
        System.out.println(name);
        String pwd=driver.findElement(By.id("password")).getAttribute("value");
        System.out.println(pwd);
        if(name.isEmpty()&&pwd.isEmpty())
        {
     	   System.out.println("Reset done successfully");
        }
        else
        {
     	   System.out.println("Reset done unsuccessfully ");
        }
        
        
      String errmsg=driver.findElement(By.xpath("//div[contains(text(),'Incorrect')]")).getText();
      System.out.println("Alert msg is"+errmsg);
      if(errmsg.contains("Incorrect"))
      {
    	  System.out.println("Invalid crendials, testcase is passed");
      }
      else
      {
    	 System.out.println("Testcase is failed");
      }
      
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
      
	}

}
