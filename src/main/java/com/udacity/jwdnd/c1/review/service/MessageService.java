package com.udacity.jwdnd.c1.review.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;

@Service
public class MessageService {

	private List<ChatMessage> chatMessages;
	/*
	 * private String message;
	 * 
	 * public MessageService(String message) { this.message = message; }
	 * 
	 * public String toUppercase() { return this.message.toUpperCase(); }
	 * 
	 * public String toLowercase() { return this.message.toLowerCase(); }
	 */

	@PostConstruct
	public void postConstruct() {
		System.out.println("Creating MessageService Bean");
		this.chatMessages = new ArrayList<>();
	}

	public void addMessage(ChatForm chatForm) {
		ChatMessage newMessage = new ChatMessage();
		newMessage.setUsername(chatForm.getUsername());
		System.out.println(chatForm.getMessageType());
		switch (chatForm.getMessageType()) {
		case "Say":
			newMessage.setMessage(chatForm.getMessageText());
			break;
		case "Shout":
			newMessage.setMessage(chatForm.getMessageText().toUpperCase());
			break;
		case "Whisper":
			newMessage.setMessage(chatForm.getMessageText().toLowerCase());
			break;
		}

		this.chatMessages.add(newMessage);
	}

	public List<ChatMessage> getChatMessages() {
		return this.chatMessages;
	}
}
