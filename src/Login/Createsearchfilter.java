package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Createsearchfilter {

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
        
        
        /*Thread.sleep(2000);
        Actions act=new Actions(driver);
        WebElement del=driver.findElement(By.xpath("//*[@class='ewDeleteFilter']"));
        act.moveToElement(del);
        del.click();*/

        driver.findElement(By.xpath(("//*[@class='btn btn-default ewSearchToggle']"))).click();
        driver.findElement(By.name(("psearch"))).sendKeys("samsungphones");
        driver.findElement(By.id("btnsubmit")).click();
                
       // driver.findElement(By.xpath("//*[@class='btn btn-primary ewButton']")).click();
        
        driver.findElement(By.xpath("//*[@data-caption='Filters']")).click();
        
        driver.findElement(By.xpath("//*[@class='ewSaveFilter']")).click();
        
        String msg=driver.findElement(By.xpath("//*[@class='ajs-content']")).getText();
        System.out.println("Message is "+msg);
        String s1=driver.getWindowHandle();
        System.out.println(s1);
        driver.switchTo().window(s1);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("samsungphones");
        
       // driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();


        
	}

}
