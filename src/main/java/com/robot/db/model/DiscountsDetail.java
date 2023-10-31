package com.robot.db.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"SP_DISCOUNTS_DETAIL\"")
public class DiscountsDetail implements Serializable{
private static long serialVersionUID = 1L;
	
	@Id
	@Column(name = "\"DISCOUNTS_DETAIL_ID\"")
	private int discounDetailtId;
	
	@Column(name = "\"DISCOUNTS_ID\"")
	private String discountDetailId;
	
//	@Column(name = "\"DISCOUNT_DETAIL_DESCRIPTION\"")
//	private String discountDetailDesc;
	
	@Column(name = "\"DISCOUNTS_DETAIL_STATUS\"")
	private String discountDetailStatus;
	
	@Column(name = "\"DISCOUNTS_DETAIL_RULES\"")
	private String discountDetailRules;
	
	@Column(name = "\"DISCOUNTS_DETAIL_AMMOUNT\"")
	private String discountDetailAmmount;

	public int getDiscounDetailtId() {
		return discounDetailtId;
	}

	public void setDiscounDetailtId(int discounDetailtId) {
		this.discounDetailtId = discounDetailtId;
	}

	public String getDiscountDetailId() {
		return discountDetailId;
	}

	public void setDiscountDetailId(String discountDetailId) {
		this.discountDetailId = discountDetailId;
	}

	public String getDiscountDetailStatus() {
		return discountDetailStatus;
	}

	public void setDiscountDetailStatus(String discountDetailStatus) {
		this.discountDetailStatus = discountDetailStatus;
	}

	public String getDiscountDetailRules() {
		return discountDetailRules;
	}

	public void setDiscountDetailRules(String discountDetailRules) {
		this.discountDetailRules = discountDetailRules;
	}

	public String getDiscountDetailAmmount() {
		return discountDetailAmmount;
	}

	public void setDiscountDetailAmmount(String discountDetailAmmount) {
		this.discountDetailAmmount = discountDetailAmmount;
	}

	@Override
	public String toString() {
		return "DiscountsDetail [discounDetailtId=" + discounDetailtId + ", discountDetailId=" + discountDetailId
				+ ", discountDetailStatus=" + discountDetailStatus + ", discountDetailRules=" + discountDetailRules
				+ ", discountDetailAmmount=" + discountDetailAmmount + "]";
	}

//	public String getDiscountDetailDesc() {
//		return discountDetailDesc;
//	}
//
//	public void setDiscountDetailDesc(String discountDetailDesc) {
//		this.discountDetailDesc = discountDetailDesc;
//	}
	
	
}
