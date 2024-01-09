package com.robot.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private String orderId;
    private String customerId;
    private String totalPrice;
    private Date date;
    private Time time;
    private String status;
    private List<OrderDetailDataDTO> details;
    
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderDetailDataDTO> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetailDataDTO> details) {
		this.details = details;
	}
	

    
}
