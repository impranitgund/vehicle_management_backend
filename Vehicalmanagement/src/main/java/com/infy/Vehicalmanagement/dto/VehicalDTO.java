package com.infy.Vehicalmanagement.dto;

import java.time.LocalDate;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

public class VehicalDTO {
	
	private Integer id;
	@NotNull(message = "{vehical.make.notpresent}")
	@Pattern(regexp = "([A-Za-z]+)",message="{vehical.make.invalid}")
	private String make;
	@NotNull(message ="{vehical.year.notpresent}" )
	private int year;
	@NotNull(message="{vehical.model.notpresent}")
	private String modelName;
	@NotNull(message = "{vehical.status.notpresent}")
	@Pattern(regexp="SOLD|UNSOLD",message="{vehicle.Status.invalid}")
	private String Status;
	@PastOrPresent(message = "{vehical.solddate.invalid}")
	private LocalDate soldDate;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public LocalDate getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(LocalDate soldDate) {
		this.soldDate = soldDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

}
