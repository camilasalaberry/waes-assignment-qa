package com.waes.heros.profiles.steps;

import org.openqa.selenium.WebDriver;

import com.waes.heros.profiles.pageobjects.DetailsPage;
import com.waes.heros.profiles.pageobjects.HomeHerosProfilesPage;
import com.waes.heros.profiles.pageobjects.LogInPage;
import com.waes.heros.profiles.pageobjects.ProfilePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class LoginSteps {

	LogInPage loginPage;
	HomeHerosProfilesPage herosProfilesPage;
	ProfilePage profilePage;
	DetailsPage detailsPage;
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

	@Given("the user is logged in as {string}, {string}")
	public void the_user_is_logged_in_as(String username, String password) {
		loadHerosProfilesHome();
		goToLoginPage();
		loginSubmit(username, password);
	}

	@When("the user attempts to profile page")
	public void the_user_attempts_to_profile_page() {
		
		profilePage = new ProfilePage(driver);

	}

@Then("profile information must be present {string} and , {string}")
public void profile_information_must_be_present_and(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

@When("the user attempts to details page")
public void the_user_attempts_to_details_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

@Then("details of personal profile must be present {string}, {string}")
public void details_of_personal_profile_must_be_present(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

	public void loadHerosProfilesHome() {
		herosProfilesPage = new HomeHerosProfilesPage(driver);
	}

	public void goToLoginPage(){
		herosProfilesPage.GoToLoginPage();
	    loginPage = new LogInPage(driver);
	}

	public void loginSubmit(String user, String pass){
		loginPage.fillUsernameAndPassword(user, pass);
		loginPage.doLogin();
	}
}
