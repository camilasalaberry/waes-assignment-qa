package com.waes.heros.profiles.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import java.util.concurrent.TimeUnit;
import com.waes.heros.profiles.support.ConfigureDriver;
import com.waes.heros.profiles.support.PropertiesFileReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	static WebDriver driver;
	ConfigureDriver configureDriver;
	PropertiesFileReader propertiesFileReader;
	

	@Before
	public void BeforeScenario() {

		propertiesFileReader = new PropertiesFileReader();
		configureDriver = new ConfigureDriver();
		driver = configureDriver.getDriver();
		driver.manage().timeouts().implicitlyWait(propertiesFileReader.getImplicitWait(), TimeUnit.SECONDS);
		driver.get(propertiesFileReader.getApplicationUrl());

	}

	@After
	public void embedScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}
		driver.quit();
	}
}
