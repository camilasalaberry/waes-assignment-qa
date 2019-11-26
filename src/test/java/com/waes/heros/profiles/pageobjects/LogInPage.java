package com.waes.heros.profiles.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends DefaultPage {

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	// fields of login page mapped by id

	@FindBy(how = How.ID, using = "username_input")
	public WebElement userNameInput;

	@FindBy(how = How.ID, using = "password_input")
	public WebElement passWordInput;

	@FindBy(how = How.ID, using = "login_button")
	public WebElement loginButton;

	@FindBy(how = How.ID, using = "status")
	public WebElement statusLogin;

	public void fillUsernameAndPassword(String userName, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 60); // 1 minute
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username_input")));
		userNameInput.sendKeys(userName);
		passWordInput.sendKeys(password);
	}

	public void doLogin() {
		loginButton.click();
	}

	public void fillUsername(String name) {
		WebDriverWait wait = new WebDriverWait(driver, 30);// 30 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username_input")));
		userNameInput.sendKeys(name);
	}

	public void fillPassword(String password) {
		passWordInput.sendKeys(password);
	}

	public void fillLoginAndSubmit(String userName, String password) {
		fillUsernameAndPassword(userName, password);
		doLogin();
	}
}
