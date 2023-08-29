package com.robot.dto;

import java.util.List;

import lombok.Data;

@Data
public class ItemsDTO {
	
	private boolean success;
	private List<ItemsDTOData> data;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<ItemsDTOData> getData() {
		return data;
	}
	public void setData(List<ItemsDTOData> data) {
		this.data = data;
	}
	
	
}
