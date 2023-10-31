package com.robot.dao;

import java.util.List;

import lombok.Data;

@Data
public class DiscountsDAO {
	
	List<DiscountsDetailDAO> data;
	

	

	public List<DiscountsDetailDAO> getData() {
		return data;
	}
	
	public void setData(List<DiscountsDetailDAO> data) {
		this.data = data;
	}

}
