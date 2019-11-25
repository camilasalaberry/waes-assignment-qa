package com.waes.heros.profiles.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

public class DetailsPage extends DefaultPage{

	public DetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH , using= "//*[@id='___gatsby']/div/div/main/div[2]/section/ul/li[1]")
	WebElement name; 

	@FindBy(how = How.XPATH , using= "//*[@id='___gatsby']/div/div/main/div[2]/section/ul/li[2]")
	WebElement emailAddress; 

	@FindBy(how = How.ID , using= "profile_link")
	WebElement profileLink;	

	@FindBy(how = How.XPATH , using= "//*[@id='status']/p/a")
	WebElement logOutLink;	


	public void goToDetailsPage(){
		profileLink.click();
	}
	
	public void logOut(){
		logOutLink.click();
	}
}
