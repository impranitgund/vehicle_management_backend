package com.infy.Vehicalmanagement.api;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Vehicalmanagement.dto.VehicalDTO;
import com.infy.Vehicalmanagement.dto.VehicleUpdateDTO;
import com.infy.Vehicalmanagement.exception.VehicleException;
import com.infy.Vehicalmanagement.service.VehicleService;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin
public class VehicleAPI {
	@Autowired
	private VehicleService vehicleService;
	
	
	@GetMapping("/vehicle")
	public ResponseEntity<List<VehicalDTO>> getAllVehicle() throws VehicleException {
		List<VehicalDTO> vdto=vehicleService.getAllVehicle();
		return new ResponseEntity<List<VehicalDTO>>(vdto,HttpStatus.OK);
	}
	@PostMapping("/vehicle")
	public ResponseEntity<VehicalDTO> addvehicle(@RequestBody VehicalDTO vehicaldto) throws VehicleException {
		VehicalDTO vdto=vehicleService.addvehicle(vehicaldto);
		return new ResponseEntity<>(vdto,HttpStatus.CREATED);
	}
	@PutMapping("vehicle/{id}")
	public ResponseEntity<VehicalDTO> updateStatus(@PathVariable Integer id,@RequestBody VehicleUpdateDTO vehicleUpdateDTO) throws VehicleException {
		VehicalDTO vdto=vehicleService.updateStatus(id, vehicleUpdateDTO);
		return new ResponseEntity<>(vdto,HttpStatus.OK);
	}
//	@GetMapping("/vehicles/{noOfDays}/{status}")
//	public ResponseEntity<List<VehicalDTO>> soldVehiclesInSpecificDays(@PathVariable Integer noOfDays,@PathVariable String status) throws VehicleException{
//		List<VehicalDTO> vdto=vehicleService.soldVehiclesInSpecificDays(noOfDays, status);
//		return new ResponseEntity<List<VehicalDTO>>(vdto,HttpStatus.OK);
		
//	}

}
