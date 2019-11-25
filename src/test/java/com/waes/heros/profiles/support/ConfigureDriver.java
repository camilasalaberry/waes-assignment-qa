package com.waes.heros.profiles.support;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ConfigureDriver {
	
	public ConfigureDriver () {
		
	}
	
	public WebDriver GetDriver() {
		WebDriver driver;
		String browser = Optional.ofNullable(System.getProperty("browser")).orElse("");
		switch (browser.toLowerCase()) {
		case "headless":
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\firefox\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			break;
		default:
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		}
		return driver;
	}

}
