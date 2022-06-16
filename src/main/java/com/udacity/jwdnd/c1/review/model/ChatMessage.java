package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
	private Integer messageId;
	private String username;
	private String message;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessagetext() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
