package testCS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test4Table {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@Test
	public void getTableInfo() {
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//a/span)[2]")).click();
		
		List<WebElement> low = driver.findElements(By.xpath("//div/div/div/div[@role='columnheader']"));
		for(int i=0;i<low.size();i++) {
				System.out.print(low.get(i).getText()+"\t");
		}
		System.out.println();
		List<WebElement> rows = driver.findElements(By.xpath("//div[@role='row']"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//div[@role='cell']"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println();
        }
        
        driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
        driver.findElement(By.xpath("(//div[@role='document']//button[@type='button'])[2]")).click();
        FluentWait<WebDriver>  wait = new FluentWait<WebDriver>(driver);
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[Text()='Successfully Deleted']")));
        String msg = ele.getText();
        Assert.assertEquals(msg, "Successfully Deleted");
        
		
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
}
