package com.infy.Vehicalmanagement.validator;

import java.time.LocalDate;

import com.infy.Vehicalmanagement.dto.VehicalDTO;
import com.infy.Vehicalmanagement.exception.VehicleException;

public class VehicalValidator {
	
	public static void validateVehical(VehicalDTO vehicaldto) throws VehicleException{
		if(!isValidStatus(vehicaldto.getStatus())) throw new VehicleException("VehicleValidator.INVALID_STATUS");
		


}

		
	
		
		public static Boolean isValidStatus(String status) {
		if(status.matches("SOLD|UNSOLD")) {
			return true;
			
		}
			
		
		return false;
		
	}
		
	}
	
