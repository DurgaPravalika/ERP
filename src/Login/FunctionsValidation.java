package Login;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class FunctionsValidation {

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
		        
		       String name=driver.findElement(By.id("ewPageCaption")).getText();
		        if(name.equals("Dashboard"))
		        {
		        	System.out.println("Admin login is displayed");
		        
		        }
		        else
		        {
		        	System.out.println("Admin login is not displayed");
		        }
		       
		        //TC5 verify admin able to access stock items
		        driver.findElement(By.linkText("Stock Items")).click();
		        String caption = driver.findElement(By.id("ewPageCaption")).getText();
                if(caption.equals("Stock Items"))
                {
                	System.out.println("Stock items module displayed");
                }
                else
                {
                	System.out.println("Stock items module not displayed");

                }
		        
		     
		        //TC6 verify admin able to access customers page
		        driver.findElement(By.linkText("Customers")).click();
		        String caption1 = driver.findElement(By.id("ewPageCaption")).getText();
                if(caption1.equals("Customers"))
                {
                	System.out.println("Customers module displayed");
                }
                else
                {
                	System.out.println("Customers module not displayed");

                }
		        
		        
		        
		       //TC7 verify admin able to access stock categories page
		       
		        Actions act= new Actions(driver);
		        WebElement stockitems=driver.findElement(By.id("mi_a_stock_items"));
		        act.moveToElement(stockitems).build().perform();
		        
		        Actions act1=new Actions(driver);
		        WebElement cat=driver.findElement(By.id("mi_a_stock_categories"));
		        act1.moveToElement(cat);
		        cat.click();
		        Thread.sleep(2000);
		        
		        //TC8 verify admin able to access unitofmeasurement page
		        Actions act2= new Actions(driver);
		        WebElement stockitems1=driver.findElement(By.id("mi_a_stock_items"));
		        act.moveToElement(stockitems1).build().perform();
		        
		        Actions act3=new Actions(driver);
		        WebElement unit=driver.findElement(By.id("mi_a_unit_of_measurement"));
		        act3.moveToElement(unit);
		        unit.click();
		        
		        
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/ul[1]/li[11]/a")).click();
		        
		        
		        driver.close();
		        
		               

	}

	
}
