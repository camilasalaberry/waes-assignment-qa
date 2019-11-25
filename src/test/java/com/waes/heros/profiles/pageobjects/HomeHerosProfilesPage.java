package com.waes.heros.profiles.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeHerosProfilesPage extends DefaultPage {

	public HomeHerosProfilesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.ID, using="login_link")
	private WebElement loginLink;

	@FindBy(how = How.ID , using = "signup_link")
	private WebElement signupLink;

	public void GoToLoginPage() {
		loginLink.click();
		
	}
	
	public void GoToSignUpPage() {
		signupLink.click();
		
	}
}
