package testCS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {
	static WebDriver driver;
	static int cnt;
	//public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//access web elements method
	private static WebElement accessWebElements() {
		WebElement dropdown=driver.findElement(By.xpath("(//li[@id='menu-item-25']/a)[1]"));
		dropdown.click();
		WebElement dropdown1=driver.findElement(By.xpath("(//span[@class='ekit_page_list_title_title'])[13]"));
		dropdown1.click();
		WebElement box= driver.findElement(By.xpath("	"));
		return box;
	}
	//checking  header status method
	private static void checkHeaderStatus(WebDriver driver ,JavascriptExecutor js) {
		js.executeScript("window.scrollBy(0,-10000);", "");
		String exceptedTxt="Boost Customer Satisfaction with Seamless Doorstep Services";
		String acutalTxt=driver.findElement(By.xpath("//h1")).getText();
		if(acutalTxt.equals(exceptedTxt)) {
			System.out.println("Status Passed!!!");
		}
	}
	//getting attributes values method
	private static void getAttMethod(List<WebElement> low) {
		cnt=1;
		for(int i=0;i<low.size();i++) {
			if(!low.get(i).getText().isBlank())
				System.out.println(cnt++ +" "+low.get(i).getAttribute("href"));
		}
	}
	//getting text method
	private static List<WebElement> gettextmethod(WebElement box,JavascriptExecutor js) {
		js.executeScript("window.scrollBy(0,10000);", " ");
		List<WebElement> low=box.findElements(By.tagName("a"));
		cnt=1;
		for(int i=0;i<low.size();i++) {
			if(!low.get(i).getText().isBlank())
				System.out.println(cnt++ +" "+low.get(i).getText());
		}
		return low;
	}
	//main method start
	public static void main(String[] args) {
	driver=new ChromeDriver();
	driver.get("https://dista.ai/");
	driver.manage().window().maximize();
	
	//access web elements
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement box = accessWebElements();
	
	//method called of get text 
	List<WebElement> low = gettextmethod(box,js);
	
	//check header status
	checkHeaderStatus(driver,js);
	
	//method of attributes
	getAttMethod(low);
	
	
	}
	

	

	
}
