package com.robot.dao;

import java.util.List;

import com.robot.controller.DiscountsController;

import lombok.Data;

@Data
public class OrderDAO {
	private String date;
	private String time;
	private String customerId;
	private String total;
	private List<OrderDetailDAO> data;
	private List<DiscountsDetailDAO> discount;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<OrderDetailDAO> getData() {
		return data;
	}
	public void setData(List<OrderDetailDAO> data) {
		this.data = data;
	}
	
	public List<DiscountsDetailDAO> getDiscount() {
		return discount;
	}
	public void setDiscount(List<DiscountsDetailDAO> discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "OrderDAO [date=" + date + ", time=" + time + ", customerId=" + customerId + ", total=" + total
				+ ", data=" + data + ", discount=" + discount + "]";
	}
	
	
	
	
}
