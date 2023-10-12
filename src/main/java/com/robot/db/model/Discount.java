package com.robot.db.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"SP_DISCOUNTS\"")
public class Discount implements Serializable {
	private static long serialVersionUID = 1L;
	
	@Id
	@Column(name = "\"DISCOUNTS_ID\"")
	private String discountId;
	
	@Column(name = "\"DISCOUNTS_NAME\"")
	private String discountName;
	
	
	@Column(name = "\"DISCOUNTS_TYPE\"")
	private String discountType;
	
	@Column(name = "\"DISCOUNTS_START_DATE\"")
	private Date discountStartDate;
	
	@Column(name = "\"DISCOUNTS_EXPIRED_DATE\"")
	private Date discountEndDate;
	
	@Column(name = "\"DISCOUNTS_START_TIME\"")
	private Time discountStartTime;
	
	@Column(name = "\"DISCOUNTS_EXPIRED_TIME\"")
	private Time discountEndTime;

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Date getDiscountStartDate() {
		return discountStartDate;
	}

	public void setDiscountStartDate(Date discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

	public Date getDiscountEndDate() {
		return discountEndDate;
	}

	public void setDiscountEndDate(Date discountEndDate) {
		this.discountEndDate = discountEndDate;
	}

	public Time getDiscountStartTime() {
		return discountStartTime;
	}

	public void setDiscountStartTime(Time discountStartTime) {
		this.discountStartTime = discountStartTime;
	}

	public Time getDiscountEndTime() {
		return discountEndTime;
	}

	public void setDiscountEndTime(Time discountEndTime) {
		this.discountEndTime = discountEndTime;
	}
	
	
	
	
}
