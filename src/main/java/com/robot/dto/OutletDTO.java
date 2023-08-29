package com.robot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OutletDTO {
	
	private String OUTLET_ID;
	
	private String OUTLET_NAME;


	private String OUTLET_PHONE;
	
	private String STATUS_NAME;
	
	private String TYPE_NAME;
	
	private int TYPE_PERCENTAGE;

	
	
	public OutletDTO(String oUTLET_ID, String oUTLET_NAME, String oUTLET_PHONE, String sTATUS_NAME, String tYPE_NAME,
			int tYPE_PERCENTAGE) {
		OUTLET_ID = oUTLET_ID;
		OUTLET_NAME = oUTLET_NAME;
		OUTLET_PHONE = oUTLET_PHONE;
		STATUS_NAME = sTATUS_NAME;
		TYPE_NAME = tYPE_NAME;
		TYPE_PERCENTAGE = tYPE_PERCENTAGE;
	}

	public String getOUTLET_ID() {
		return OUTLET_ID;
	}

	public void setOUTLET_ID(String oUTLET_ID) {
		OUTLET_ID = oUTLET_ID;
	}

	public String getOUTLET_NAME() {
		return OUTLET_NAME;
	}

	public void setOUTLET_NAME(String oUTLET_NAME) {
		OUTLET_NAME = oUTLET_NAME;
	}

	public String getOUTLET_PHONE() {
		return OUTLET_PHONE;
	}

	public void setOUTLET_PHONE(String oUTLET_PHONE) {
		OUTLET_PHONE = oUTLET_PHONE;
	}

	public String getSTATUS_NAME() {
		return STATUS_NAME;
	}

	public void setSTATUS_NAME(String sTATUS_NAME) {
		STATUS_NAME = sTATUS_NAME;
	}

	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}

	public int getTYPE_PERCENTAGE() {
		return TYPE_PERCENTAGE;
	}

	public void setTYPE_PERCENTAGE(int tYPE_PERCENTAGE) {
		TYPE_PERCENTAGE = tYPE_PERCENTAGE;
	}

	
	
	
	
}
