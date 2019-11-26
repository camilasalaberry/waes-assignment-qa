package com.waes.heros.profiles.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage extends DefaultPage {

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	// fields of login page mapped by id

	@FindBy(how = How.ID, using= "username_input") 
	public WebElement userNameInput;

	@FindBy(how = How.ID , using = "password_input")
	public WebElement passWordInput;

	@FindBy(how = How.ID , using ="login_button")
	public WebElement loginButton;
	
	@FindBy(how = How.ID , using ="status")
	public WebElement statusLogin;

	public void fillUsernameAndPassword(String userName, String password) {		
		userNameInput.sendKeys(userName);
		passWordInput.sendKeys(password);
	}

	public void doLogin() {
		loginButton.click();
	}

	public void fillUsername(String name) {
		userNameInput.sendKeys(name);
	}
	public void fillPassword(String password) {
		passWordInput.sendKeys(password);
	}

	public void fillLoginAndSubmit(String userName, String password){
		fillUsernameAndPassword(userName, password);
		doLogin();
	}
}
