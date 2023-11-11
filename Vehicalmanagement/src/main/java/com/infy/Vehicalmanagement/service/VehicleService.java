package com.infy.Vehicalmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.infy.Vehicalmanagement.dto.VehicalDTO;
import com.infy.Vehicalmanagement.dto.VehicleUpdateDTO;
import com.infy.Vehicalmanagement.exception.VehicleException;

public interface VehicleService {
	public List<VehicalDTO> getAllVehicle() throws VehicleException;
	public VehicalDTO addvehicle(VehicalDTO vehicaldto) throws VehicleException;
	public VehicalDTO updateStatus(Integer id,VehicleUpdateDTO vehicleUpdateDTO) throws VehicleException;
	//public List<VehicalDTO> soldVehiclesInSpecificDays(Integer noOfDays,String status) throws VehicleException;  
}
