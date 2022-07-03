package com.udacity.jwdnd.c1.review.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

	@FindBy(id = "backtologin-link")
	private WebElement backtologinLink;

	@FindBy(id = "success-msg")
	private WebElement alertSuccess;

	@FindBy(id = "error-msg")
	private WebElement alertError;

	@FindBy(id = "inputFirstName")
	private WebElement inputFirstName;

	@FindBy(id = "inputLastName")
	private WebElement inputLastName;

	@FindBy(id = "inputUsername")
	private WebElement inputUsername;

	@FindBy(id = "inputPassword")
	private WebElement inputPassword;

	@FindBy(id = "submit-button")
	private WebElement submitButton;

	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setFirstName(String firstName) {
		inputFirstName.clear();
		inputFirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		inputLastName.clear();
		inputLastName.sendKeys(lastName);
	}

	public void setUsername(String username) {
		inputUsername.clear();
		inputUsername.sendKeys(username);
	}

	public void setPassword(String password) {
		inputPassword.clear();
		inputPassword.sendKeys(password);
	}

	public boolean isSuccess() {
		return alertSuccess.isDisplayed();
	}

	public boolean isError() {
		return alertError.isDisplayed();
	}

	public void clickBackToLogin() {
		backtologinLink.click();
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

}
