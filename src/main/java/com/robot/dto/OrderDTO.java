package com.robot.dto;

import lombok.Data;

@Data
public class OrderDTO {
	private boolean status;
	private String messages;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	
}
