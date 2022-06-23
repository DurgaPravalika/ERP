package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deletestockitem {

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
        
        driver.findElement(By.xpath(("//*[@class='btn btn-default ewSearchToggle']"))).click();
        driver.findElement(By.name(("psearch"))).sendKeys("samsungphones");
        driver.findElement(By.id("btnsubmit")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@value='163']")).click();
        
        driver.findElement(By.xpath("//*[@class='icon-options ewIcon']")).click();
        driver.findElement(By.xpath("//*[@data-caption='Delete Selected Records']")).click();
        
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();


	}

}
