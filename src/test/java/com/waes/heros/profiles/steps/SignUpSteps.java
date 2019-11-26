package com.waes.heros.profiles.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import com.waes.heros.profiles.pageobjects.DetailsPage;
import com.waes.heros.profiles.pageobjects.HomeHerosProfilesPage;
import com.waes.heros.profiles.pageobjects.ProfilePage;
import com.waes.heros.profiles.pageobjects.SignUpPage;
import org.openqa.selenium.WebDriver;

public class SignUpSteps {
    HomeHerosProfilesPage herosProfilesPage;
	ProfilePage profilePage;
    DetailsPage detailsPage;
    SignUpPage signUpPage;
    
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
}

@Given("the entered email is {string}")
public void the_entered_email_is(String email) {
    signUpPage.fillEmail(email);
}
}
