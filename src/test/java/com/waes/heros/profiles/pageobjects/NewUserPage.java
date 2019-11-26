package com.waes.heros.profiles.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewUserPage extends DefaultPage{

	public NewUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using ="//*[@id=\"___gatsby\"]/div/div/main/div[2]/section/p")
	public WebElement welcomeMessage;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"status\"]/p")
	public WebElement status;
	
	
}
