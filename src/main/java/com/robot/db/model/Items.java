package com.robot.db.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
//SELECT "ITEM_ID", "ITEM_NAME", "ITEM_BRAND", "ITEM_SUB_BRAND", "ITEM_SUB_ITEM", "ITEM_JENIS", "ITEM_SUB_JENIS", "ITEM_UKURAN", "ITEM_PRICE", "ITEM_STOCK", "ITEM_IS_ACTIVE" FROM "SP_ITEMS";

@Data
@Entity
@Table(name = "\"SP_ITEMS\"")
public class Items implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "\"ITEM_ID\"")
	private String itemID;
	
	@Column(name = "\"ITEM_NAME\"")
	private String itemName;
	
	@Column(name = "\"ITEM_BRAND\"")
	private String itemBrand;
	
	@Column(name = " \"ITEM_SUB_BRAND\"")
	private String itemSubBrand;
	
	@Column(name = "\"ITEM_SUB_ITEM\"")
	private String itemSubItem;
	
	@Column(name = "\"ITEM_JENIS\"")
	private String itemJenis;
	
	@Column(name = "\"ITEM_SUB_JENIS\"")
	private String itemSubJenis;
	
	@Column(name = "\"ITEM_UKURAN\"")
	private String itemUkuran;
	
	@Column(name = "\"ITEM_PRICE\"")
	private Double itemPrice;
	
	@Column(name = "\"ITEM_STOCK\"")
	private int itemStock;
	
	@Column(name = "\"ITEM_IS_ACTIVE\"")
	private String itemIsActive;
	
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemBrand() {
		return itemBrand;
	}
	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
	public String getItemSubBrand() {
		return itemSubBrand;
	}
	public void setItemSubBrand(String itemSubBrand) {
		this.itemSubBrand = itemSubBrand;
	}
	public String getItemSubItem() {
		return itemSubItem;
	}
	public void setItemSubItem(String itemSubItem) {
		this.itemSubItem = itemSubItem;
	}
	public String getItemJenis() {
		return itemJenis;
	}
	public void setItemJenis(String itemJenis) {
		this.itemJenis = itemJenis;
	}
	public String getItemSubJenis() {
		return itemSubJenis;
	}
	public void setItemSubJenis(String itemSubJenis) {
		this.itemSubJenis = itemSubJenis;
	}
	public String getItemUkuran() {
		return itemUkuran;
	}
	public void setItemUkuran(String itemUkuran) {
		this.itemUkuran = itemUkuran;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String getItemIsActive() {
		return itemIsActive;
	}
	public void setItemIsActive(String itemIsActive) {
		this.itemIsActive = itemIsActive;
	}
	
	
}
