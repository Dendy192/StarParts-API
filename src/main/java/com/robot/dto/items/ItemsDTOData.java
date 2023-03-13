package com.robot.dto.items;

import lombok.Data;

@Data
public class ItemsDTOData {
	private String item_no;
	private String item_desc;
	private String item_group;
	private String sub_fix;
	private String type;
	private Double harga;
	
	public ItemsDTOData(String item_no, String item_desc, String item_group, String sub_fix, String type, Double harga) {
		super();
		this.item_no = item_no;
		this.item_desc = item_desc;
		this.item_group = item_group;
		this.sub_fix = sub_fix;
		this.type = type;
		this.harga = harga;
	}
	
	public String getItem_no() {
		return item_no;
	}
	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	public String getItem_group() {
		return item_group;
	}
	public void setItem_group(String item_group) {
		this.item_group = item_group;
	}
	public String getSub_fix() {
		return sub_fix;
	}
	public void setSub_fix(String sub_fix) {
		this.sub_fix = sub_fix;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getHarga() {
		return harga;
	}
	public void setHarga(Double harga) {
		this.harga = harga;
	}
	
	
}
