package com.robot.dto;

import java.util.List;

public class DiscountsDTO {

	private boolean status;
	private List<DiscountsDTOData> data;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<DiscountsDTOData> getData() {
		return data;
	}
	public void setData(List<DiscountsDTOData> data) {
		this.data = data;
	}
	
	
}
