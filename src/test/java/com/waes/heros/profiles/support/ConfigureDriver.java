package com.waes.heros.profiles.support;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class ConfigureDriver {
	PropertiesFileReader propertiesFileReader;

	public ConfigureDriver() {
		propertiesFileReader = new PropertiesFileReader();
	}

	public WebDriver getDriver() {
		WebDriver driver;
		String browser = Optional.ofNullable(System.getProperty("browser")).orElse("");
		switch (browser.toLowerCase()) {
		case "headless":
			driver = setUpDriver(true);
			break;
		default:
			driver = setUpDriver(false);
		}
		return driver;
	}

	public WebDriver setUpDriver(boolean headless) {

		System.setProperty("webdriver.gecko.driver", propertiesFileReader.getDriverPath());
		FirefoxOptions options = new FirefoxOptions();
		
		if (headless) {
			options.addArguments("--headless");
		} else {
			options.addArguments(propertiesFileReader.getWindowSize());
		}

		return new FirefoxDriver(options);
	}

}
