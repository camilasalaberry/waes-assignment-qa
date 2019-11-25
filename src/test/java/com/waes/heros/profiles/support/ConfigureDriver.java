package com.waes.heros.profiles.support;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ConfigureDriver {
	
	public ConfigureDriver () {
		
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

	public WebDriver setUpDriver(boolean headless){
		
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\firefox\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("start-maximized");

		if (headless) {
			options.setHeadless(true);
		}
		return new FirefoxDriver(options);
	}

}
