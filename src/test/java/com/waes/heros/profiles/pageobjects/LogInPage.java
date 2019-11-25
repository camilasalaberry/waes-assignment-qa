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

	@FindBy(how = How.NAME, using= "username") 
	public WebElement userName;

	@FindBy(how = How.ID , using = "password_input")
	public WebElement passWord;

	@FindBy(how = How.ID , using ="login_button")
	public WebElement loginButton;
	
	@FindBy(how = How.ID , using ="status")
	public WebElement statusLogin;

	public void fillUsernameAndPassword(String name, String pass) {		
		userName.sendKeys(name);
		passWord.sendKeys(pass);
	}

	public void doLogin() {
		loginButton.click();
	}

	public void fillUsername(String name) {
		userName.sendKeys(name);
	}
	public void fillPassword(String pass) {
		passWord.sendKeys(pass);
	}
}
