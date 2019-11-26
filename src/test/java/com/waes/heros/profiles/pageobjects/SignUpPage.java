package com.waes.heros.profiles.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage extends DefaultPage {

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	// fields of login page mapped by id

	@FindBy(how = How.ID, using = "username_input")
	public WebElement userNameInput;

	@FindBy(how = How.ID, using = "password_input")
	public WebElement passWordInput;

	@FindBy(how = How.ID, using = "name_input")
	public WebElement nameInput;

	@FindBy(how = How.ID, using = "email_input")
	public WebElement emailInput;

	@FindBy(how = How.ID, using = "day_select")
	public WebElement dateOfBirthDaySelect;

	@FindBy(how = How.ID, using = "month_select")
	public WebElement dateOfBirthMonthSelect;

	@FindBy(how = How.ID, using = "year_select")
	public WebElement dateOfBirthYearSelect;

	@FindBy(how = How.ID, using = "submit_button")
	public WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//*[@id='___gatsby']/div/div/main")
	public WebElement bodyDocument;

	@FindBy(how = How.XPATH, using = "//*[@id='status']/p")
	public WebElement status;

	public void fillAllForm(String userName, String passWord, String email, String name, String dayDateOfBirthDay,
			String monthDateOfBirthDay, String yearDateOfBirthDay) {
		userNameInput.sendKeys(userName);
		passWordInput.sendKeys(passWord);
		emailInput.sendKeys(email);
		nameInput.sendKeys(name);
		dateOfBirthDaySelect.sendKeys(dayDateOfBirthDay);
		dateOfBirthMonthSelect.sendKeys(monthDateOfBirthDay);
		dateOfBirthYearSelect.sendKeys(yearDateOfBirthDay);

	}

	public void fillUsername(String userName) {
		userNameInput.sendKeys(userName);
	}

	public void fillPassWord(String passWord) {
		passWordInput.sendKeys(passWord);
	}

	public void fillEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void fillName(String name) {
		nameInput.sendKeys(name);
	}

	public void selectDayOfBirth(String dayDateOfBirthDay) {
		dateOfBirthDaySelect.sendKeys(dayDateOfBirthDay);
	}

	public void selectMonthOfBirth(String monthDateOfBirthDay) {
		dateOfBirthMonthSelect.sendKeys(monthDateOfBirthDay);
	}

	public void selectYearOfBirth(String yearDateOfBirthDay) {
		dateOfBirthYearSelect.sendKeys(yearDateOfBirthDay);
		bodyDocument.click();
	}

	public void submit() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		submitButton.click();
	}
}
