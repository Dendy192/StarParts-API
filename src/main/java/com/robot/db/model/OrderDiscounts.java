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
@Table(name = "\"SP_ORDER_DETAIL_DISCOUNTS\"")
public class OrderDiscounts implements Serializable {
	private static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_order_detai")
	@Column(name = "\"ORDER_DETAIL_DISCOUNTS_ID\"")
	private int id;
	
	@Column(name = "\"ORDER_ID\"")
	private String orderId;
	
	
	@Column(name = "\"DISCOUNTS_ID\"")
	private String discountId;
	
	@Column(name = "\"DISCOUNT_NAME\"")
	private String discountName;
	
	

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String dcName) {
		this.discountName = dcName;
	}

	
	
	
	
	
}
