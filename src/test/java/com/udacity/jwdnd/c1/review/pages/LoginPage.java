package com.udacity.jwdnd.c1.review.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "error-msg")
	private WebElement alertError;

	@FindBy(id = "logout-msg")
	private WebElement alertLogout;

	@FindBy(id = "inputUsername")
	private WebElement inputUsername;

	@FindBy(id = "inputPassword")
	private WebElement inputPassword;

	@FindBy(id = "submit-button")
	private WebElement submitButton;

	@FindBy(id = "signup-link")
	private WebElement signupLink;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String username) {
		inputUsername.clear();
		inputUsername.sendKeys(username);
	}

	public String getDisplayedUsername() {
		// return inputPassword.getText();
		return inputUsername.getAttribute("value");
	}

	public void setPassword(String password) {
		inputPassword.clear();
		inputPassword.sendKeys(password);
	}

	public String getDisplayedPassword() {
		// return inputPassword.getText();
		return inputPassword.getAttribute("value");
	}

	public boolean isLoginError() {
		try {
			return alertError.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public boolean isLoggedout() {
		try {
			return alertLogout.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void clickSignupLink() {
		signupLink.click();
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

}
