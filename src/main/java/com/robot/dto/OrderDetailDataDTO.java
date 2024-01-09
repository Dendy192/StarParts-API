package com.robot.dto;

import lombok.Data;

@Data
public class OrderDetailDataDTO {
	
    private int orderDetailId;
    private String orderDetailItem;
    private int orderDetailQty;
    private String orderDetailPrice;
    
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
