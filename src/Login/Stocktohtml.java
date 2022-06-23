package Login;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stocktohtml {

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
        driver.findElement(By.xpath("//*[@class='ewExportLink ewHtml']")).click();
        
        WebElement htmltable=driver.findElement(By.xpath("//*[@class='ewExportTableHeader']"));
        List<WebElement> rows,cols;
        rows=driver.findElements(By.tagName("tr"));
        int rowsize=rows.size();
        System.out.println("size of row is" +rowsize);
        cols = rows.get(5).findElements(By.tagName("td"));
		int colsize=cols.size();
		System.out.println("size of coloumns is" +colsize);
        for(int i=1;i<rows.size();i++)
		{
			cols = rows.get(i).findElements(By.tagName("td"));
			
			for(WebElement element : cols)
			{
				String data = element.getText();
				System.out.print(data+"   ");
			}
			System.out.println();
		}
	}

}
