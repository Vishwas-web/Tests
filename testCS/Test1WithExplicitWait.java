package testCS;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1WithExplicitWait {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://dista.ai/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//li[@id='menu-item-25']/a)[1]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ekit_page_list_title_title'])[13]")));
		element.click();
		
		WebElement box = driver.findElement(By.xpath("//section[@data-id='473efe5e']"));
		List<WebElement> low=box.findElements(By.tagName("a"));
		for(int i=0;i<low.size();i++) {
			if(!low.get(i).getText().isBlank()) {
				System.out.println(low.get(i).getText());
			}
		}
		String ExcepetedTxt="Boost Customer Satisfaction with Seamless Doorstep Services";
		String AcutalTxt=driver.findElement(By.xpath("//h1")).getText();
		if(AcutalTxt.equals(ExcepetedTxt)) {
			System.out.println("Status Passed!!!");
		}
		
		
	}
}
