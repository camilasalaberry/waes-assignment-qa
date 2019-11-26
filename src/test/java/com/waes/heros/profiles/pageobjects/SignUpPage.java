package com.waes.heros.profiles.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends DefaultPage{

	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	// fields of login page mapped by id
	
	 @FindBy(how= How.ID, using ="username_input")
	    public WebElement userNameInput;

	 @FindBy(how= How.ID, using ="password_input")
	    public WebElement passWordInput;

	 @FindBy(how= How.ID, using ="name_input")
	    public WebElement nameInput;
	 
	 @FindBy(how= How.ID, using ="email_input")
	    public WebElement emailInput;
	 
	//  @FindBy(how= How.ID, using ="day_select")
	//    public SelectElement dateOfBirthDaySelect;

	//  @FindBy(how= How.ID, using ="month_select")
	//    public SelectElement dateOfBirthMonthSelect;
	 
	//  @FindBy(how= How.ID, using ="year_select")
	//    public SelectElement dateOfBirthYearSelect;
	 
	 @FindBy(how= How.ID, using ="submit_button")
	   public WebElement submitButton;


	   public void fillAllForm(String userName, String passWord,String email,String  name, String dayDateOfBirthDay, String monthDateOfBirthDay,String yearDateOfBirthDay){
		userNameInput.sendKeys(userName);
		passWordInput.sendKeys(passWord);
		emailInput.sendKeys(email);
		nameInput.sendKeys(name);
		// dateOfBirthDaySelect.selectByValue(dayDateOfBirthDay);
		// dateOfBirthMonthSelect.selectByValue(monthDateOfBirthDay);
		// dateOfBirthYearSelect.selectByValue(yearDateOfBirthDay);

	
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

	   public void submit(){
		submitButton.click();
	   }
}

