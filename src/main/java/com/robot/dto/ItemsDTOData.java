package com.robot.dto;

import lombok.Data;

@Data
public class ItemsDTOData {
	private String itemNo;
	private String itemDesc;
	private String itemGroup;
	private String subJenis;
	private String itemUkuran;
	
	private String itemType;
	private Double itemHarga;
	
	
	
	
	
	
	
	
	public ItemsDTOData(String itemNo, String itemDesc, String itemGroup, String subJenis, String itemUkuran,
			String itemType, Double itemHarga) {
		super();
		this.itemNo = itemNo;
		this.itemDesc = itemDesc;
		this.itemGroup = itemGroup;
		this.subJenis = subJenis;
		this.itemUkuran = itemUkuran;
		this.itemType = itemType;
		this.itemHarga = itemHarga;
	}
	public String getItemUkuran() {
		return itemUkuran;
	}
	public void setItemUkuran(String itemUkuran) {
		this.itemUkuran = itemUkuran;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}
	public String getSubJenis() {
		return subJenis;
	}
	public void setSubJenis(String subJenis) {
		this.subJenis = subJenis;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Double getItemHarga() {
		return itemHarga;
	}
	public void setItemHarga(Double itemHarga) {
		this.itemHarga = itemHarga;
	}
	
	
	
	
	
	
}
