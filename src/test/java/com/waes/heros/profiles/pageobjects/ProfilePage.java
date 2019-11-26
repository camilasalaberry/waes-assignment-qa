package com.waes.heros.profiles.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage extends DefaultPage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='___gatsby']/div/div/main/div[2]/section/p[1]")
	public WebElement question;

	@FindBy(how = How.XPATH, using = "//*[@id='___gatsby']/div/div/main/div[2]/section/p[2]")
	public WebElement superPower;

	@FindBy(how = How.ID, using = "details_link")
	public WebElement detailsLink;

	public void goToDetailsPage() {
		detailsLink.click();
	}
}
