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
	public WebDriver driver;

	@Given("the username {string} was registered with password {string}")
	public void the_username_was_registered_with_password(String username, String password) throws InterruptedException {
		driver = Hooks.driver;
		herosProfilesPage = new HomeHerosProfilesPage(driver);
		herosProfilesPage.GoToLoginPage();

	    loginPage = new LogInPage(driver);
	    loginPage.fillUsernameAndPassword(username, password);
	}

	@When("the user attempts to login")
	public void the_user_attempts_to_login() {
		loginPage.submit();
	}

	@Then("he should see a welcome message {string}")
	public void he_should_see_a_welcome_message(String message) {
		assertEquals(message, loginPage.statusLogin.getText());
	}
}
