package com.udacity.jwdnd.c1.review;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.udacity.jwdnd.c1.review.pages.ChatPage;
import com.udacity.jwdnd.c1.review.pages.LoginPage;
import com.udacity.jwdnd.c1.review.pages.SignupPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserTestingApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private SignupPage signupPage;
	private LoginPage loginPage;
	private ChatPage chatPage;

	private final String username = "johnDoe";
	private final String password = "password";

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}

	@Test
	public void userRegistration() throws InterruptedException {
		driver.get("http://localhost:" + port + "/signup");
		signupPage = new SignupPage(driver);

		signupPage.setFirstName("John");
		signupPage.setLastName("Doe");
		signupPage.setUsername(username);
		signupPage.setPassword(password);

		assertEquals("John", signupPage.getDisplayedFirstName());
		assertEquals("Doe", signupPage.getDisplayedLastName());
		assertEquals(username, signupPage.getDisplayedUsername());
		assertEquals(password, signupPage.getDisplayedPassword());

		signupPage.clickSubmitButton();

		assertEquals(true, signupPage.isSignupSuccess());
		assertEquals(false, signupPage.isSignupError());
	}

	@Test
	public void userLogin() throws InterruptedException {
		driver.get("http://localhost:" + port + "/login");
		loginPage = new LoginPage(driver);

		loginPage.setUsername(username);
		loginPage.setPassword(password);

		assertEquals(username, loginPage.getDisplayedUsername());
		assertEquals(password, loginPage.getDisplayedPassword());

		loginPage.clickSubmitButton();

		assertEquals(false, loginPage.isLoginError());
	}

	@Test
	public void userChatMessage() throws InterruptedException {
		driver.get("http://localhost:" + port + "/chat");
		chatPage = new ChatPage(driver);

		String firstMessage = "First Message";
		String secondMessage = "Second Message";
		String thirdMessage = "Third Message";

		String[] types = new String[] { "Say", "Shout", "Whisper" };

		// Write First Message
		chatPage.setMessageText(firstMessage);
		chatPage.setMessageType(types[0]);

		assertEquals(firstMessage, chatPage.getDisplayedMessageText());
		assertEquals(types[0], chatPage.getDisplayedMessageType());

		chatPage.clickSubmitButton();

		assertEquals("", chatPage.getDisplayedMessageText());
		assertEquals("Say", chatPage.getDisplayedMessageType());

		// Write Second Message
		chatPage.setMessageText(secondMessage);
		chatPage.setMessageType(types[1]);

		assertEquals(secondMessage, chatPage.getDisplayedMessageText());
		assertEquals(types[1], chatPage.getDisplayedMessageType());

		chatPage.clickSubmitButton();

		assertEquals("", chatPage.getDisplayedMessageText());
		assertEquals("Say", chatPage.getDisplayedMessageType());

		// Write Third Message
		chatPage.setMessageText(thirdMessage);
		chatPage.setMessageType(types[2]);

		assertEquals(thirdMessage, chatPage.getDisplayedMessageText());
		assertEquals(types[2], chatPage.getDisplayedMessageType());

		chatPage.clickSubmitButton();

		assertEquals("", chatPage.getDisplayedMessageText());
		assertEquals("Say", chatPage.getDisplayedMessageType());

		// Check Sent Messages
		assertEquals(3, chatPage.getChatEntries());

	}
}
