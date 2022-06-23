package Login;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Advancedsearchstockitem {

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
        driver.findElement(By.xpath("//*[@class='icon-advanced-search ewIcon']")).click();
        
        Select cat=new Select(driver.findElement(By.id("z_Category")));
        cat.selectByValue("=");
        Select catvalue=new Select(driver.findElement(By.id("x_Category")));
        catvalue.selectByVisibleText("mobiles");
        
        Select price=new Select(driver.findElement(By.id("z_Purchasing_Price")));
        price.selectByValue("<");
        driver.findElement(By.name("x_Purchasing_Price")).sendKeys("20000");
        
        driver.findElement(By.id("btnAction")).click();
        
        WebElement stocktable=driver.findElement(By.id("fa_stock_itemslist"));
        //driver.findElement(By.id("gmp_a_stock_items"));
        
        List<WebElement> rows,cols;
        rows=driver.findElements(By.tagName("tr"));
        int rowsize=rows.size();
        System.out.println("No.of Rows is" +rowsize);
        cols = rows.get(3).findElements(By.tagName("td"));
		int colsize=cols.size();
		System.out.println("size of coloumns is" +colsize);
        
       for(int i=1;i<rows.size();i++)
        {
        	cols = rows.get(i).findElements(By.tagName("td"));
        	
        	for(WebElement element : cols)
        	{
        		String data=element.getText();
        		System.out.print(data+"   ");
        	}
        	
            System.out.println();
        	
        }
        
       Thread.sleep(2000);
       driver.findElement(By.linkText("Logout")).click();
      
        
        
	}

}
