package com.robot.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
	private boolean success;
	private String message;
	
	private UserDTOData data;

	

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDTOData getData() {
		return data;
	}

	public void setData(UserDTOData data) {
		this.data = data;
	}

	
	
}
