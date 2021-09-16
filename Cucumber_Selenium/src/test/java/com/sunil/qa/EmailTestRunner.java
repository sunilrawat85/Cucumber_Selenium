package com.sunil.qa;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/d", glue = { "com.sunil.qa.glue" }, plugin = {
		"pretty" }, stepNotifications = true)
public class EmailTestRunner {

	private static WebDriver driver = null;

	@BeforeClass
	public static void before() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
		if (driver == null)
			driver = new ChromeDriver();
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
