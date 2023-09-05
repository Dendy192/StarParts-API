package com.robot.dto;

public class WA_BOTDTOData {
	private String id;
	private String name;
	private String phone;
	private String status;
	private String type;
	private String discount;
	
	
	
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "WA_BOTDTO [id=" + id + ", name=" + name + ", phone=" + phone + ", status=" + status + ", type=" + type
				+ "]";
	}
	
	
	
	
}
