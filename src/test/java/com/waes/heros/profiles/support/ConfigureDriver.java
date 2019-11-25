package com.waes.heros.profiles.support;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigureDriver {
	
	public ConfigureDriver () {
		
	}
	
	public WebDriver GetDriver() {
		WebDriver driver;
		String browser = Optional.ofNullable(System.getProperty("browser")).orElse("");
		switch (browser.toLowerCase()) {
		case "edge":
			System.setProperty("webdriver.msedge.driver", "src\\test\\resources\\drivers\\edge\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "headless":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		}
		return driver;
	}

}
