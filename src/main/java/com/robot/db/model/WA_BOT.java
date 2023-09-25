package com.robot.db.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"SP_BOT_WA\"")
public class WA_BOT implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "\"BOT_WA_ID\"")
	private String BOT_WA_ID;
	
	@Column(name = "\"BOT_WA_NAME\"")
	private String BOT_WA_NAME;
	
	@Column(name = "\"BOT_WA_TYPE\"")
	private String BOT_WA_TYPE;
	
	@Column(name = "\"BOT_WA_STATUS\"")
	private int BOT_WA_STATUS;
	
	@Column(name = "\"BOT_WA_PHONE\"")
	private String phone;
	
	@Column(name = "\"BOT_WA_DISCOUNT\"")
	private String BOT_WA_DISCOUNT;
	
	public String getBOT_WA_ID() {
		return BOT_WA_ID;
	}
	public void setBOT_WA_ID(String bOT_WA_ID) {
		BOT_WA_ID = bOT_WA_ID;
	}
	public String getBOT_WA_NAME() {
		return BOT_WA_NAME;
	}
	public void setBOT_WA_NAME(String bOT_WA_NAME) {
		BOT_WA_NAME = bOT_WA_NAME;
	}
	public String getBOT_WA_TYPE() {
		return BOT_WA_TYPE;
	}
	public void setBOT_WA_TYPE(String bOT_WA_TYPE) {
		BOT_WA_TYPE = bOT_WA_TYPE;
	}
	public int getBOT_WA_STATUS() {
		return BOT_WA_STATUS;
	}
	public void setBOT_WA_STATUS(int bOT_WA_STATUS) {
		BOT_WA_STATUS = bOT_WA_STATUS;
	}
	public String getBOT_WA_PHONE() {
		return phone;
	}
	public void setBOT_WA_PHONE(String bOT_WA_PHONE) {
		phone = bOT_WA_PHONE;
	}
	public String getBOT_WA_DISCOUNT() {
		return BOT_WA_DISCOUNT;
	}
	public void setBOT_WA_DISCOUNT(String bOT_WA_DISCOUNT) {
		BOT_WA_DISCOUNT = bOT_WA_DISCOUNT;
	}
	@Override
	public String toString() {
		return "WA_BOT [BOT_WA_ID=" + BOT_WA_ID + ", BOT_WA_NAME=" + BOT_WA_NAME + ", BOT_WA_TYPE=" + BOT_WA_TYPE
				+ ", BOT_WA_STATUS=" + BOT_WA_STATUS + ", BOT_WA_PHONE=" + phone + ", BOT_WA_DISCOUNT="
				+ BOT_WA_DISCOUNT + "]";
	}
	
	
	
	
	
	
	
}	
