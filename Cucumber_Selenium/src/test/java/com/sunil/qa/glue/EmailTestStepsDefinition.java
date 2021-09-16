package com.sunil.qa.glue;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sunil.qa.EmailTestRunner;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailTestStepsDefinition {

	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		WebDriver driver = EmailTestRunner.getDriver();
		// TODO: remove waits
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https:\\yahoo.com");
	}

	@When("^user navigates to login page$")
	public void user_navigates_to_login_page() throws Throwable {
		WebDriver driver = EmailTestRunner.getDriver();
		WebElement element = driver.findElement(By.cssSelector("div.text"));
		assertEquals(element.getAttribute("title"), "Sign In");
		element.click();
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_username_and_password(String username, String password) throws Throwable {
		WebDriver driver = EmailTestRunner.getDriver();
		driver.findElement(By.id("login-username")).sendKeys(username);
		driver.findElement(By.id("login-signin")).click();

		// TODO: remove waits
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#login-passwd")));

		driver.findElement(By.id("login-passwd")).sendKeys(password);
		driver.findElement(By.id("login-signin")).click();
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		WebDriver driver = EmailTestRunner.getDriver();
		WebElement element = driver.findElement(By.cssSelector("a#ymail"));
		assert (element != null);
	}

	@Given("I logged in to the yahooemail")
	public void i_logged_in_to_the_yahooemail() {
		WebDriver driver = EmailTestRunner.getDriver();
		driver.findElement(By.cssSelector("a#ymail")).click();
		driver.findElement(By.cssSelector("a#ybar-logo")).click();
	}

	@When("I search the title of an email")
	public void i_search_the_title_of_an_email() {
		WebDriver driver = EmailTestRunner.getDriver();
		driver.findElement(By.cssSelector("input[Class*='select-input react-typeahead-input']"))
				.sendKeys("Selenium_Cucumber Testing");
		driver.findElement(By.cssSelector("button[data-test-id='search-basic-btn']")).click();
	}

	@When("I select the email to reply")
	public void i_select_the_email_to_reply() {
		WebDriver driver = EmailTestRunner.getDriver();
		String emailTitle = "Selenium_Cucumber Testing";
		String selector = "span[title='" + emailTitle + "']";
		driver.findElement(By.cssSelector(selector)).click();
	}

	@Then("I send an reply to the email")
	public void i_send_an_reply_to_the_email() {
		WebDriver driver = EmailTestRunner.getDriver();
		driver.findElement(By.cssSelector("button[title='Reply']")).click();
		driver.findElement(By.cssSelector("button[data-test-id='btn-cc']")).click();
		driver.findElement(By.cssSelector("div[role='textbox']"))
				.sendKeys("Hi, I will get back to you(this is an automated reply)");
		driver.findElement(By.cssSelector("button[data-test-id='compose-send-button']")).click();
	}

	@Given("I am composing an email")
	public void i_am_composing_an_email() {
		WebDriver driver = EmailTestRunner.getDriver();
		driver.findElement(By.cssSelector("a[data-test-id='compose-button']")).click();
	}

	@Given("I entered the recepient email id")
	public void i_entered_the_recepient_email_id() {
		WebDriver driver = EmailTestRunner.getDriver();
		driver.findElement(By.cssSelector("input#message-to-field")).sendKeys("dahiya.himanshu@gmail.com");
	}

	@When("I put the subject of email as student information")
	public void i_put_the_subject_of_email_as_student_information() {
		WebDriver driver = EmailTestRunner.getDriver();
		driver.findElement(By.cssSelector("input[data-test-id='compose-subject']")).sendKeys("Student' Information");
	}

	@When("I have entered the student details in the body")
	public void i_have_entered_the_student_details_in_the_body(io.cucumber.datatable.DataTable dataTable) {
		WebDriver driver = EmailTestRunner.getDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		dataTable.asLists().forEach(row -> {
			String value = row.stream().collect(Collectors.joining("\t"));
			String divValue = "<div>" + value + "</div>";
			jsExecutor.executeScript("document.getElementById('editor-container').innerHTML +='" + divValue + "'");
		});
	}

	@Then("I have sent email to recepient")
	public void i_have_sent_email_to_recepient() {
//		WebDriver driver = EmailTestRunner.getDriver();
		throw new PendingException();
	}

}