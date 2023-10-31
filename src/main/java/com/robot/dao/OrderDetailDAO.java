package com.robot.dao;

public class OrderDetailDAO {
	
	private String itemId;
	private int qty;
	private String itemHarga;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getItemHarga() {
		return itemHarga;
	}
	public void setItemHarga(String itemHarga) {
		this.itemHarga = itemHarga;
	}
	
	
}
