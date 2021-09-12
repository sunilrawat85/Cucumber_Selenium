package SeleniumCode;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import org.junit.Assert;

public class emailTest {
	public static WebDriver driver;
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {     
    	System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
    	driver =new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https:\\yahoo.com");
    }
    
    @When("^user navigates to login page$")
    public void user_navigates_to_login_page() throws Throwable {
        driver.findElement(By.cssSelector("div.text")).click();
    }
    
    @When("^user enters username and password$")
    public void user_enters_username_and_password() throws Throwable {
    	driver.findElement(By.id("login-username")).sendKeys("sunilrawattest@yahoo.com");
    	driver.findElement(By.id("login-signin")).click();
		driver.wait(5000);
		driver.findElement(By.id("login-passwd")).sendKeys("Ultr@Mild");
		driver.findElement(By.id("login-signin")).click();
    }
    
    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    	driver.findElement(By.cssSelector("a#ymail")).click();
    	
    	//String exp_message = "Welcome to your account. Here you can manage all   of your personal information and orders.";
    	//Stringactual = driver.findElement(By.cssSelector(".info-account")).getText();
        //Assert.assertEquals(exp_message, actual);
        //driver.quit();  
    }      
}