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
	public void the_username_was_registered_with_password(String userName, String passWord)
			throws InterruptedException {
		this.loadHerosProfilesHome();
		this.goToLoginPage();
		loginPage.fillUsernameAndPassword(userName, passWord);
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
	public void the_username_was_not_registered_with_password(String userName, String passWord) {
		this.loadHerosProfilesHome();
		this.goToLoginPage();
		loginPage.fillUsernameAndPassword(userName, passWord);
	}

	@Then("he should see a not allowed message {string}")
	public void he_should_see_a_not_allowed_message(String message) {
		assertEquals(message, loginPage.statusLogin.getText());
	}

	@Given("the username {string}")
	public void the_username(String userName) {
		this.loadHerosProfilesHome();
		this.goToLoginPage();
		loginPage.fillUsername(userName);
	}

	@Given("the password {string}")
	public void the_password(String passWord) {
		loginPage.fillPassword(passWord);
	}

	@Then("the message {string} must be visible")
	public void the_message_must_be_visible(String message) {
		assertEquals(message, loginPage.statusLogin.getText());
	}
	@Then("a validation into the field must be present")
	public void a_validation_into_the_field_must_be_presente(){
		assetTrue(StringUtils.isNotEmpty(loginPage.userName.getAttribute("validationMessage"));
	}
	@Given("the user is logged in as {string}, {string}")
	public void the_user_is_logged_in_as(String userName, String passWord) {
		loadHerosProfilesHome();
		goToLoginPage();
		loginAndSubmit(userName, passWord);
	}

	@When("the user click to profile page")
	public void the_user_click_to_profile_page() {
		profilePage = new ProfilePage(driver);
	}

	@Then("profile information must be present {string} and , {string}")
	public void profile_information_must_be_present_and(String question, String superPower) {
		assertTrue(profilePage.question.getText().contains(question));
		assertTrue(profilePage.superPower.getText().contains(superPower));
	}

	@When("the user click to details page")
	public void the_user_click_to_details_page() {
		profilePage = new ProfilePage(driver);
		profilePage.detailsLink.click();
		detailsPage = new DetailsPage(driver);
	}

	@Then("details of personal profile must be present {string}, {string}")
	public void details_of_personal_profile_must_be_present(String name, String email) {
		assertTrue(detailsPage.name.getText().contains(name));
		assertTrue(detailsPage.emailAddress.getText().contains(email));
	}

	public void loadHerosProfilesHome() {
		herosProfilesPage = new HomeHerosProfilesPage(driver);
	}

	public void goToLoginPage() {
		herosProfilesPage.GoToLoginPage();
		loginPage = new LogInPage(driver);
	}

	public void loginAndSubmit(String userName, String passWord) {
		loginPage.fillUsernameAndPassword(userName, passWord);
		loginPage.doLogin();
	}
}
