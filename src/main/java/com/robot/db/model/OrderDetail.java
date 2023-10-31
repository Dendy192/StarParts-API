package com.robot.db.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"SP_ORDER_DETAIL\"")
@SequenceGenerator(name = "order_detail_seq", sequenceName = "order_detail_seq", allocationSize = 1)
public class OrderDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_detail_seq")
	@Column(name = "\"ORDER_DETAIL_ID\"")
	private int orderDetailId;
	
	@Column(name = "\"ORDER_ID\"")
	private String orderId;
	
	@Column(name = "\"ORDER_DETAIL_ITEM\"")
	private String orderDetailItem;
	
	@Column(name = "\"ORDER_DETAIL_QTY\"")
	private int orderDetailQty;
	
	@Column(name = "\"ORDER_DETAIL_PRICE\"")
	private String orderDetailPrice;

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", orderDetailItem="
				+ orderDetailItem + ", orderDetailQty=" + orderDetailQty + ", orderDetailPrice=" + orderDetailPrice
				+ "]";
	}
	
	
	
	
}
