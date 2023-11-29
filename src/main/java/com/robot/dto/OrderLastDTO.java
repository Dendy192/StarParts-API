package com.robot.dto;

import java.util.List;

public class OrderLastDTO {
	private boolean status;
	private List<OrderLastDTOData> data;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<OrderLastDTOData> getData() {
		return data;
	}
	public void setData(List<OrderLastDTOData> data) {
		this.data = data;
	}
	
}
