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
	public void the_user_is_at_sign_up_page() throws Exception {
		herosProfilesPage = new HomeHerosProfilesPage(driver);
		herosProfilesPage.goToSignUpPage();
		signUpPage = new SignUpPage(driver);
	}

	@When("user attempts to register")
	public void user_attempts_to_register() throws Exception {
		signUpPage.submit();
		newUserPage = new NewUserPage(driver);

	}

	@Given("the entered email is {string}")
	public void the_entered_email_is(String email) throws Exception {
		signUpPage.fillEmail(email);
	}

	@Given("user fill the form to become a hero with username {string}")
	public void user_fill_the_form_to_become_a_hero_with_username(String userName) throws Exception  {
		signUpPage.fillUsername(userName);
	}

	@Given("password {string}")
	public void password(String passWord) throws Exception  {
		signUpPage.fillPassWord(passWord);
	}

	@Given("name {string}")
	public void name(String name) throws Exception  {
		signUpPage.fillName(name);
	}

	@Given("email {string}")
	public void email(String email) throws Exception  {
		signUpPage.fillEmail(email);
	}

	@Given("day of birth {string}")
	public void day_of_birth(String dayDateOfBirthDay) throws Exception  {
		signUpPage.selectDayOfBirth(dayDateOfBirthDay);
	}

	@Given("month of birth {string}")
	public void month_of_birth(String monthDateOfBirthDay) throws Exception  {
		signUpPage.selectMonthOfBirth(monthDateOfBirthDay);
	}

	@Given("year of birth {string}")
	public void year_of_birth(String yearDateOfBirthDay) throws Exception {
		signUpPage.selectYearOfBirth(yearDateOfBirthDay);
	}

	@Given("user fill the form to become a hero")
	public void user_fill_the_form_to_become_a_hero() throws Exception {
		signUpPage.fillUsername("analyst");
		signUpPage.fillPassWord("docs");
		signUpPage.fillName("Camila");
		signUpPage.selectDayOfBirth("19");
		signUpPage.selectMonthOfBirth("May");
		signUpPage.selectYearOfBirth("1990");
	}

	@Then("he should see a message {string}")
	public void he_should_see_a_message(String message) throws Exception {
		assertEquals(message, signUpPage.status.getText());
	}

	@Then("he should see a welcome message in his profile {string}")
	public void he_should_see_a_welcome_message_in_his_profile(String message) throws Exception  {
		assertEquals(message, newUserPage.welcomeMessage.getText());
	}

	@Then("a validation should be presented {string}")
	public void a_validation_should_be_presented(String message) throws Exception {
		assertEquals(message, signUpPage.emailInput.getAttribute("validationMessage"));
		String validationMessage = signUpPage.emailInput.getAttribute("validationMessage");
		System.out.println(validationMessage);
	}

	@Then("a validation should be presented to mandatory fields {string}, {string}")
	public void a_validation_should_be_presented_to_mandatory_fields(String field, String message) throws Exception  {
		if (field.equals("userName")) {
			assertEquals(message, signUpPage.userNameInput.getAttribute("validationMessage"));
		} else if (field.equals("passWord")) {
			assertEquals(message, signUpPage.passWordInput.getAttribute("validationMessage"));
		} else if (field.equals("name")) {
			assertEquals(message, signUpPage.nameInput.getAttribute("validationMessage"));
		} else if (field.equals("email")) {
			assertEquals(message, signUpPage.emailInput.getAttribute("validationMessage"));
		} else if (field.equals("dayDateOfBirth")) {
			assertEquals(message, signUpPage.dateOfBirthDaySelect.getAttribute("validationMessage"));
		} else if (field.equals("monthDateOfBirth")) {
			assertEquals(message, signUpPage.dateOfBirthMonthSelect.getAttribute("validationMessage"));
		} else if (field.equals("yearDateOfBirth")) {
			assertEquals(message, signUpPage.dateOfBirthYearSelect.getAttribute("validationMessage"));
		}

	}

	@Then("he should see the status {string}")
	public void he_should_see_the_status(String status) throws Exception {
		assertEquals(status, newUserPage.status.getText());
	}

	@Then("should be possible access profile data like superpower {string}")
	public void should_be_possible_access_profile_data_like_superpower(String superpower) throws Exception {
		newUserPage.goToProfilePage();
		profilePage = new ProfilePage(driver);
		assertTrue(profilePage.superPower.getText().contains(superpower));
	}

	@Then("details like name {string}, email {string}")
	public void details_like_name_email(String name, String email) throws Exception {
		newUserPage.goToDetailsPage();
		detailsPage = new DetailsPage(driver);
		assertTrue(detailsPage.name.getText().contains(name));
		assertTrue(detailsPage.emailAddress.getText().contains(email));
	}

}
