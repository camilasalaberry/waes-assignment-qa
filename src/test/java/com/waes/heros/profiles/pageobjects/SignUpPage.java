package com.waes.heros.profiles.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends DefaultPage{

	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	// fields of login page mapped by id
	
	 @FindBy(id="username_input")
	    private WebElement userName;

	 @FindBy(id="password_input")
	    private WebElement passWord;

	 @FindBy(id="name_input")
	    private WebElement name;
	 
	 @FindBy(id="email_input")
	    private WebElement email;
	 
	 @FindBy(id="day_select")
	   private WebElement dateOfBirthDay;

	 @FindBy(id="month_select")
	   private WebElement dateOfBirthMonth;
	 
	 @FindBy(id="year_select")
	   private WebElement dateOfBirthYear;
	 
	 @FindBy(id="submit_button")
	   private WebElement submitButton;
}

