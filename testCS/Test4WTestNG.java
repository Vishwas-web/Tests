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
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class Test4WTestNG {
	    static WebDriver driver;
	    static WebDriverWait wait;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void fillRegistrationForm() {
	        driver.get("https://demo.automationtesting.in/Register.html");

	        // Fill personal information
	        fillPersonalInfo();

	        // Click on radio button
	        radioBtnClick("(//input[@type='radio'])[1]");

	        // Click on checkboxes
	        checkBox("checkbox1");

	        // Select skills from dropdown
	        selectFromDropdown("//select[@id='Skills']", "Adobe Photoshop");

	        // Select country from dropdown
	        clickAndSelectFromCountryDropdown("India");

		// Find and click on the dropdown options (assuming they are 'li' elements)
        	List<WebElement> ddOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li")));
        	clickOnWebEle("Hindi", ddOptions);

	        // Select date of birth
	        selectFromDropdown("//select[@type='text'][@placeholder='Year']", "2001");
	        selectFromDropdown("//select[@type='text'][@placeholder='Month']", "April");
	        selectFromDropdown("//select[@type='text'][@placeholder='Day']", "19");

	        // Enter passwords
	        enterPasswords("12345678");

	        // Upload file
	        uploadFile("imagesrc", "D:/CS/actitime test inputs.xlsx");
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

	    // Helper methods
	    private void fillPersonalInfo() {
	        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Vishwas");
	        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Patil");
	        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("This is an Address");
	        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
	        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("1234567890");
	    }

	    private void radioBtnClick(String BtnRadio) {
	        driver.findElement(By.xpath(BtnRadio)).click();
	    }

	    private void checkBox(String BtnChecked) {
	        driver.findElement(By.id(BtnChecked)).click();
	    }

	    private void selectFromDropdown(String dropdownXpath, String option) {
	        WebElement dropdown = driver.findElement(By.xpath(dropdownXpath));
	        Select select = new Select(dropdown);
	        select.selectByVisibleText(option);
	    }

	    private void clickAndSelectFromCountryDropdown(String option) {
	        WebElement countryDropdown = driver.findElement(By.xpath("//span[@role='combobox']"));
	        countryDropdown.click();
	        List<WebElement> ddOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span//ul/li")));
	        clickOnWebEle(option, ddOptions);
	    }

	    private void enterPasswords(String password) {
	        driver.findElement(By.id("firstpassword")).sendKeys(password);
	        driver.findElement(By.id("secondpassword")).sendKeys(password);
	    }

	    private void uploadFile(String fileInputId, String filePath) {
	        driver.findElement(By.id(fileInputId)).sendKeys(filePath);
	    }

	    private void clickOnWebEle(String choice, List<WebElement> ddList) {
	        for (WebElement we : ddList) {
	            if (we.getText().equals(choice)) {
	                we.click();
	                break;
	            }
	        }
	    }
	}



