package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Stockcategory {

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
        
        Actions act=new Actions(driver);
        WebElement stockitems=driver.findElement(By.id("mi_a_stock_items"));
        act.moveToElement(stockitems).build().perform();
        
        
        Actions act1=new Actions(driver);
        WebElement cat=driver.findElement(By.id("mi_a_stock_categories"));
        act1.moveToElement(cat);
        cat.click();
        
        driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-plus ewIcon']")).click();
        
        driver.findElement(By.name("x_Category_Name")).sendKeys("phones");
        driver.findElement(By.id("btnAction")).click();
        
        String msg=driver.findElement(By.xpath("//div[text()='Add new record?']")).getText();
        System.out.println("message is "+msg );
        
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
        
        String Alertmsg=driver.findElement(By.xpath("//*[@class='alert alert-success ewSuccess']")).getText();
        System.out.println("Alertmsg is "+Alertmsg);
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
        
        
        Thread.sleep(2000);
        
        driver.findElement(By.linkText("Logout")).click();
        
        
        driver.close();
        
        
        
        
        
        
		
		
	}

}
