package com.robot.dto.Outlet;

public class OutletDTOStatus {
	private boolean success;
	private OutletDTO data;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public OutletDTO getData() {
		return data;
	}
	public void setData(OutletDTO data) {
		this.data = data;
	}
	
	
}
