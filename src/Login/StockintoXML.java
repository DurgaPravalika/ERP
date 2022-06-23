package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StockintoXML {

	public static void main(String[] args) 
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
        driver.findElement(By.xpath("//*[@data-caption='XML']")).click();
        String text=driver.findElement(By.xpath("//*[@class='header']")).getText();
        System.out.println(text);
        if(text.contains("XML file"))
        {
          System.out.println("XML file is displayed");	
        }
        
        else
        {
            System.out.println("XML file is not displayed");	

        }
	}

}
