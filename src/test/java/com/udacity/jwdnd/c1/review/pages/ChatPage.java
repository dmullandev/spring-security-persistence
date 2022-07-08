package com.udacity.jwdnd.c1.review.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChatPage {

	@FindBy(id = "messageText")
	private WebElement inputMessage;

	@FindBy(id = "messageType")
	private WebElement selectMessageType;

	@FindBy(id = "submitMessage")
	private WebElement submitButton;

	@FindBy(tagName = "span")
	private List<WebElement> chatUsernameOutput;

	public ChatPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setMessageText(String message) {
		inputMessage.clear();
		inputMessage.sendKeys(message);
	}

	public String getDisplayedMessageText() {
		// return inputPassword.getText();
		return inputMessage.getAttribute("value");
	}

	public void setMessageType(String type) {
		Select selectObj = new Select(selectMessageType);
		selectObj.selectByValue(type);
	}

	public String getDisplayedMessageType() {
		Select selectObj = new Select(selectMessageType);
		return selectObj.getFirstSelectedOption().getText();
	}

	public void clickSubmitButton() {
		submitButton.click();

		// reset back to Say
		Select selectObj = new Select(selectMessageType);
		selectObj.selectByValue("Say");
	}

	public int getChatEntries() {
		// half due to double span in div, correct use is xpath over tagname here
		return chatUsernameOutput.size() / 2;
	}

}
