package com.robot.dto;

public class WA_BOTDTO {
	private String status;
	private boolean success;
	private WA_BOTDTOData data;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public WA_BOTDTOData getData() {
		return data;
	}
	public void setData(WA_BOTDTOData data) {
		this.data = data;
	}
	
	
}
