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
	private Select inputMessageType;

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

	public void setMessageType(String type) {
		inputMessageType.selectByValue(type);
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public int getChatEntries() {
		return chatUsernameOutput.size();
	}

}
