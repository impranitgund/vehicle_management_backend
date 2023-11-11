package com.infy.Vehicalmanagement.dto;

import java.time.LocalDate;

public class VehicleUpdateDTO {
	private String Status;
	private LocalDate soldDate;
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public LocalDate getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(LocalDate soldDate) {
		this.soldDate = soldDate;
	}
	
	

}
