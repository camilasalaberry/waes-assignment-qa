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

	@FindBy(id = "password_input")
	public WebElement passWord;

	@FindBy(id = "login_button")
	public WebElement loginButton;
	
	@FindBy(id="status")
	public WebElement statusLogin;

	public void fillUsernameAndPassword(String name, String pass) {		
		userName.sendKeys(name);
		passWord.sendKeys(pass);

	}

	public void submit() {
		loginButton.click();

	}

}
