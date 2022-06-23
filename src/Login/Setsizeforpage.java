package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setsizeforpage 
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
        
        driver.findElement(By.id("mci_Settings")).click();
        driver.findElement(By.id("mci_Font_Size")).click();
        driver.findElement(By.id("mci_13px")).click();
        
        Thread.sleep(2000);
        //driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.id("mi_logout")).click();

	}

}
