package com.robot.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private String orderId;
    private String customerId;
    private String totalPrice;
    private Date date;
    private Time time;
    private String status;
    
    private int orderDetailId;
    private String orderDetailItem;
    private int orderDetailQty;
    private String orderDetailPrice;
    
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
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getOrderDetailItem() {
		return orderDetailItem;
	}
	public void setOrderDetailItem(String orderDetailItem) {
		this.orderDetailItem = orderDetailItem;
	}
	public int getOrderDetailQty() {
		return orderDetailQty;
	}
	public void setOrderDetailQty(int orderDetailQty) {
		this.orderDetailQty = orderDetailQty;
	}
	public String getOrderDetailPrice() {
		return orderDetailPrice;
	}
	public void setOrderDetailPrice(String orderDetailPrice) {
		this.orderDetailPrice = orderDetailPrice;
	}

    
}
