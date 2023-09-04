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
@Table(name = "\"SP_ORDER\"")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "\"ORDER_ID\"")
	private String id;
	
	@Column(name = "\"ORDER_CUSTOMER_ID\"")
	private String customerId;
	
	@Column(name = "\"ORDER_TOTAL_PRICE\"")
	private String totalPrice;
	
	@Column(name = "\"ORDER_DATE\"")
	private Date date;
	
	@Column(name = "\"ORDER_TIME\"")
	private Time time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", totalPrice=" + totalPrice + ", date=" + date
				+ ", time=" + time + "]";
	}
	
	
	
}
