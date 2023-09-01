package testCS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test4 {
	static WebDriver driver;
    static WebDriverWait wait;
    
	static void clickOnWebEle(String choice,List<WebElement>ddList) {
		for(WebElement we : ddList) {
			if(we.getText().equals(choice)) {
				we.click();
				break;
			}
		}
	}
	static void selectWebELe(WebElement selectList,String choice1) {
		Select select = new Select(selectList);
        select.selectByVisibleText(choice1);
	}
	static void uploadFile(String fileInputId, String filePath) {
        driver.findElement(By.id(fileInputId)).sendKeys(filePath);
    }
	static void checkBox(String BtnChecked) {
		// Click on checkboxes
        driver.findElement(By.id(BtnChecked)).click();
	}
	static void radioBtnClick(String BtnRadio) {
		// Click on radio buttons
        driver.findElement(By.xpath(BtnRadio)).click();
	}

    public static void main(String[] args) {	
    	driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Vishwas");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Patil");
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("This is an Address");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("1234567890");
        
        radioBtnClick("(//input[@type='radio'])[1]");
        
        checkBox("checkbox1");
        
        // Click on the multi-select dropdown
        driver.findElement(By.id("msdd")).click();
        
        // Find and click on the dropdown options (assuming they are 'li' elements)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> ddOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li")));
        clickOnWebEle("Hindi", ddOptions);
        clickOnWebEle("English", ddOptions);
        
        // Find and CLick on DropDown options(normal select)
        WebElement selectList = driver.findElement(By.id("Skills"));
        selectWebELe(selectList,"Adobe Photoshop");
        
        WebElement countryDropdown = driver.findElement(By.xpath("//span[@role='combobox']"));
        countryDropdown.click();
        ddOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span//ul/li")));
        clickOnWebEle("India", ddOptions);
        
        
        //Find and click on date of birth
        driver.findElement(By.xpath("//select[@type='text'][@placeholder='Year']")).click();
        ddOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='yearbox']/option")));
        clickOnWebEle("2001",ddOptions);
       
        //Month
        driver.findElement(By.xpath("//select[@type='text'][@placeholder='Month']")).click();
        ddOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@placeholder='Month']/option")));
        clickOnWebEle("April",ddOptions);
        
        //Day
        driver.findElement(By.xpath("//select[@type='text'][@placeholder='Day']")).click();
        ddOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@placeholder='Day']/option")));
        clickOnWebEle("19",ddOptions);
        
        //password
        driver.findElement(By.id("firstpassword")).sendKeys("12345678");
        driver.findElement(By.id("secondpassword")).sendKeys("12345678");
        
        //file upload
        uploadFile("imagesrc", "D:/CS/actitime test inputs.xlsx");
    }
	

	
}
		