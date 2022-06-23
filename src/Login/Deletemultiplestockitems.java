package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deletemultiplestockitems {

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
        driver.findElement(By.xpath("//*[@value='165']")).click();
        driver.findElement(By.xpath("//*[@value='166']")).click();
        
        driver.findElement(By.xpath("//*[@class='icon-options ewIcon']")).click();
        driver.findElement(By.xpath("//*[@data-caption='Delete Selected Records']")).click();
        
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
        
        
        
        /*@Test 
         public void TC15_DeleteStockItems() {
	  //click on the stock Items menu 
	  BaseMethods.driver.findElement(By.xpath("//li[@id='mi_a_stock_items']")).click();
			
	  String pcaption = BaseMethods.driver.findElement(By.id("ewPageCaption")).getText();
	  Assert.assertEquals(pcaption, "Stock Items");
	  
	  BaseMethods.driver.findElement(By.xpath(("//*[@class='btn btn-default ewSearchToggle']"))).click();
	  BaseMethods.driver.findElement(By.name(("psearch"))).sendKeys("Samsung");
	  BaseMethods.driver.findElement(By.id("btnsubmit")).click();
		
	  BaseMethods.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);String stockName = "Samsung";
	  WebElement Table = BaseMethods.driver.findElement(By.xpath("//table[@id='tbl_a_stock_itemslist']"));
	  List <WebElement> rows = Table.findElements(By.tagName("tr"));
	  
	  System.out.println(rows.size());
	  String name = rows.get(0).findElement(By.xpath("//span[@id='el1_a_stock_items_Supplier_Number']")).getText();
	  System.out.println("Name is " + name);

	  for(int i=1; i<rows.size(); i++) {
	  
		  BaseMethods.driver.findElement(By.xpath("//tr[@data-rowindex='" + i +"']/td")).click();
		  
	  }
	  
	  // Now Delete Selected Records step can be written below:
	  // Click on Actions Menu
	  // Click on Delete Selected Records
	  // Confirm on OK button on pop up*/


        

	}

}
