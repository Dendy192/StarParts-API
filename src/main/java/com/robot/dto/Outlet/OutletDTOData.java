package com.robot.dto.Outlet;

import lombok.Data;

@Data
public class OutletDTOData {
	private OutletDTOStatus data;

	public OutletDTOStatus getData() {
		return data;
	}

	public void setData(OutletDTOStatus data) {
		this.data = data;
	}

	public OutletDTOData(OutletDTOStatus data) {
		super();
		this.data = data;
	}
	
	
}
