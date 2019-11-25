package com.waes.heros.profiles.steps;

import org.openqa.selenium.WebDriver;

import com.waes.heros.profiles.pageobjects.HomeHerosProfilesPage;
import com.waes.heros.profiles.pageobjects.LogInPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class LoginSteps {

	LogInPage loginPage;
	HomeHerosProfilesPage herosProfilesPage;
	public WebDriver driver = Hooks.driver;

	@Given("the username {string} was registered with password {string}")
	public void the_username_was_registered_with_password(String username, String password) throws InterruptedException {
		this.loadHerosProfilesHome();
		this.goToLoginPage();
	    loginPage.fillUsernameAndPassword(username, password);
	}

	@When("the user attempts to login")
	public void the_user_attempts_to_login() {
		loginPage.doLogin();
	}

	@Then("he should see a welcome message {string}")
	public void he_should_see_a_welcome_message(String message) {
		assertEquals(message, loginPage.statusLogin.getText());
	}

	@Given("the username {string} was not registered with password {string}")
	public void the_username_was_not_registered_with_password(String username, String password) {
		this.loadHerosProfilesHome();
		this.goToLoginPage();
	    loginPage.fillUsernameAndPassword(username, password);
	}

	@Then("he should see a not allowed message {string}")
	public void he_should_see_a_not_allowed_message(String message) {
		assertEquals(message, loginPage.statusLogin.getText());
	}

	@Given("the username {string}")
	public void the_username(String username) {
		this.loadHerosProfilesHome();
		this.goToLoginPage();
    	loginPage.fillUsername(username);
	}

	@Given("the password {string}")
	public void the_password(String password) {
    	loginPage.fillPassword(password);
	}

	@Then("the message {string} must be visible")
	public void the_message_must_be_visible(String message) {
		assertEquals(message, loginPage.statusLogin.getText());
	}

	public void loadHerosProfilesHome() {
		herosProfilesPage = new HomeHerosProfilesPage(driver);
	}

	public void goToLoginPage(){
		herosProfilesPage.GoToLoginPage();
	    loginPage = new LogInPage(driver);
	}
}
