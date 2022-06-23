package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigatetoanotherpage {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
        driver.navigate().to("http://webapp.qedgetech.com/login.php");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("master");
        driver.findElement(By.id("btnsubmit")).click(); 
        
        driver.findElement(By.linkText("Stock Items")).click();
        
        driver.navigate().back();
                
        String msg=driver.findElement(By.id("ewPageCaption")).getText();
        System.out.println("Message is " +msg);
        
        driver.navigate().forward();
        
        String msg1=driver.findElement(By.id("ewPageCaption")).getText();
        System.out.println("Message is " +msg1);
        
        
	}

}
