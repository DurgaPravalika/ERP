package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Stockitemcreating {

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
        
        driver.findElement(By.xpath("//*[@class='btn btn-default ewAddEdit ewAdd btn-sm']")).click();
        
       /* Select cat=new Select(driver.findElement(By.id("x_Category")));
          cat.selectByVisibleText("mobiles");*/
        
        driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-plus ewIcon']")).click();
        driver.findElement(By.name("x_Category_Name")).sendKeys("mobiles");
        driver.findElement(By.xpath("//html/body/div[9]/div/div/div[3]/button[1]")).click();
        
        Select suppnum=new Select(driver.findElement(By.id("x_Supplier_Number")));
        suppnum.selectByVisibleText("First Supplier");
        
        driver.findElement(By.id("x_Stock_Name")).sendKeys("Samsungphones");
        
        /*Select unit=new Select(driver.findElement(By.id("x_Unit_Of_Measurement")));
        unit.selectByVisibleText("11");*/
        
        driver.findElement(By.xpath("//*[@id='aol_x_Unit_Of_Measurement']")).click();
        driver.findElement(By.id("x_UOM_ID")).sendKeys("6755850");
        driver.findElement(By.name("x_UOM_Description")).sendKeys("kilograms");
        driver.findElement(By.xpath("//html/body/div[9]/div/div/div[3]/button[1]")).click();
        
        driver.findElement(By.name("x_Purchasing_Price")).sendKeys("20000");
        
        driver.findElement(By.name("x_Selling_Price")).sendKeys("25000");
        
        driver.findElement(By.name("x_Notes")).sendKeys("First class products");
        
        driver.findElement(By.id("btnAction")).click();
        
        String s=driver.getWindowHandle();
        System.out.println("current window is "+s);
        
        String msg=driver.findElement(By.xpath("//div[contains(text(),'new record')]")).getText();
        System.out.println("Alert msg is "+msg);
        String s1=driver.getWindowHandle();
        System.out.println(s1);
        driver.switchTo().window(s1);
        driver.findElement(By.xpath("/html/body/div[18]/div[2]/div/div[4]/div[2]/button[1]")).click();
        
        String Msg=driver.findElement(By.xpath(("//*[@class='alert alert-success ewSuccess']"))).getText();
        System.out.println("Alert message is "+Msg);
        
        driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
       
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
       // driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
        
        driver.close();
       

	}

}
