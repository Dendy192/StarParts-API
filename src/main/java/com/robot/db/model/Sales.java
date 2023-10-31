package com.robot.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"SP_SALES\"")
public class Sales {
	
	@Id
	@Column(name = "\"SALES_ID\"")
	private String id;
	
	@Column(name = "\"SALES_NAME\"")
	private String name;
	
	@Column(name = "\"SALES_PHONE\"")
	private String phone;

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
	
	
}
