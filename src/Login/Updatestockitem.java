package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Updatestockitem {

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
       driver.findElement(By.xpath("(//span[@data-caption='Edit'])[4]")).click();
       /*//These two also works for edit option
       driver.findElement(By.xpath("//*[@id='r1_a_stock_items']/td[3]/div/div/a[2]/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[3]/form/div/div[2]/table/tbody/tr[1]/td[3]/div/div/a[2]/span")).click();*/
       
        driver.findElement(By.name("x_Purchasing_Price")).clear();
        driver.findElement(By.name("x_Purchasing_Price")).sendKeys("25000");
        
        driver.findElement(By.name("x_Quantity")).clear();
        driver.findElement(By.name("x_Quantity")).sendKeys("50");
        
        driver.findElement(By.id("btnAction")).click();
        
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
        
       

        
       
	}
}
