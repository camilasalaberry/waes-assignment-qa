package com.waes.heros.profiles.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import com.waes.heros.profiles.pageobjects.DetailsPage;
import com.waes.heros.profiles.pageobjects.HomeHerosProfilesPage;
import com.waes.heros.profiles.pageobjects.NewUserPage;
import com.waes.heros.profiles.pageobjects.ProfilePage;
import com.waes.heros.profiles.pageobjects.SignUpPage;
import org.openqa.selenium.WebDriver;

public class SignUpSteps {
	HomeHerosProfilesPage herosProfilesPage;
	ProfilePage profilePage;
	DetailsPage detailsPage;
	SignUpPage signUpPage;
	NewUserPage newUserPage;

	public WebDriver driver = Hooks.driver;

	@Given("the user is at sign up page")
	public void the_user_is_at_sign_up_page() {
		herosProfilesPage = new HomeHerosProfilesPage(driver);
		herosProfilesPage.GoToSignUpPage();
		signUpPage = new SignUpPage(driver);
	}

	@When("user attempts to register")
	public void user_attempts_to_register() {
		signUpPage.submit();
		newUserPage = new NewUserPage(driver);
		
	}

	@Given("the entered email is {string}")
	public void the_entered_email_is(String email) {
		signUpPage.fillEmail(email);
	}

	@Given("user fill the form to become a hero with username {string}")
	public void user_fill_the_form_to_become_a_hero_with_username(String userName) {
		signUpPage.fillUsername(userName);
	}

	@Given("password {string}")
	public void password(String passWord) {
		signUpPage.fillPassWord(passWord);
	}

	@Given("name {string}")
	public void name(String name) {
		signUpPage.fillName(name);
	}

	@Given("email {string}")
	public void email(String email) {
		signUpPage.fillEmail(email);
	}

	@Given("day of birth {string}")
	public void day_of_birth(String dayDateOfBirthDay) {
		signUpPage.selectDayOfBirth(dayDateOfBirthDay);
	}

	@Given("month of birth {string}")
	public void month_of_birth(String monthDateOfBirthDay) {
		signUpPage.selectMonthOfBirth(monthDateOfBirthDay);
	}

	@Given("year of birth {string}")
	public void year_of_birth(String yearDateOfBirthDay) {
		signUpPage.selectYearOfBirth(yearDateOfBirthDay);
	}

	@Given("user fill the form to become a hero")
	public void user_fill_the_form_to_become_a_hero() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("he should see a message {string}")
	public void he_should_see_a_message(String message) {
		assertEquals(message, newUserPage.welcomeMessage.getText());
	}
	
	@Then("a validation should be presented {string}")
	public void a_validation_should_be_presented(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Then("he should see the status {string}")
	public void he_should_see_the_status(String status) {
		assertEquals(status, newUserPage.status.getText());
	}

}
