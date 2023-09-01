package testCS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		driver.findElement(By.className("shopping_cart_badge")).click();
		
		List<WebElement> priceOfProducts = driver.findElements(By.className("inventory_item_price"));
		String first = priceOfProducts.get(0).getText().substring(1);
		String sec = priceOfProducts.get(1).getText().substring(1);
		float first1 = Float.parseFloat(first);
		float sec1 = Float.parseFloat(sec);
		
		
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("hehe");
		driver.findElement(By.id("last-name")).sendKeys("hehehe");
		driver.findElement(By.id("postal-code")).sendKeys("443122");
		driver.findElement(By.id("continue")).click();
		
		//Adding Tax Value
		WebElement tax = driver.findElement(By.className("summary_tax_label"));
		String Tax = tax.getText().substring(6);
		float taxN = Float.parseFloat(Tax);
		float res = first1 + sec1 + taxN;
		System.out.println("Total Of Two Products: "+ res);
		//Getting Total Value
		WebElement total = driver.findElement(By.className("summary_total_label"));
		String total1 = total.getText().substring(8);
		float result = Float.parseFloat(total1);
		System.out.println("FInal Total : "+result);
		
		if(res==result) {
			System.out.println("Matched Found Status Passed!!!");
		}
		
		
		

		
	}

}
