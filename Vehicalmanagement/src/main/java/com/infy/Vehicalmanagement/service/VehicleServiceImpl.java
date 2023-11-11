package com.infy.Vehicalmanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Vehicalmanagement.dto.VehicalDTO;
import com.infy.Vehicalmanagement.dto.VehicleUpdateDTO;
import com.infy.Vehicalmanagement.entity.Vehicle;
import com.infy.Vehicalmanagement.exception.VehicleException;
import com.infy.Vehicalmanagement.repository.*;
import com.infy.Vehicalmanagement.validator.VehicalValidator;

import jakarta.transaction.Transactional;
@Service("vehicleService")
@Transactional
public class VehicleServiceImpl implements VehicleService{
	@Autowired
	private VehicalRepository vehicleRepository;

	@Override
	public List<VehicalDTO> getAllVehicle() throws VehicleException {
		List<Vehicle> v =vehicleRepository.findAll();
		List<VehicalDTO> vdtolist=new ArrayList<>();
		if(v.isEmpty())throw new VehicleException("Vehicle.NOT_PRESENT");
		for(Vehicle vehicle:v) {
			VehicalDTO vdto=new VehicalDTO();
			vdto.setId(vehicle.getId());
			vdto.setMake(vehicle.getMake());
			vdto.setModelName(vehicle.getModelName());
			vdto.setSoldDate(vehicle.getSoldDate());
			vdto.setStatus(vehicle.getStatus());
			vdto.setYear(vehicle.getYear());
			vdtolist.add(vdto);
			
		}
		return vdtolist;
	}

	@Override
	public VehicalDTO addvehicle(VehicalDTO vehicaldto) throws VehicleException {
		VehicalValidator.validateVehical(vehicaldto);
		Vehicle v= new Vehicle();
		
		v.setMake(vehicaldto.getMake());
		v.setModelName(vehicaldto.getModelName());
		v.setStatus(vehicaldto.getStatus().toUpperCase());
		v.setYear(vehicaldto.getYear());
		if(vehicaldto.getStatus().matches("UNSOLD")) {
			v.setSoldDate(null);
		}
		else {
		      v.setSoldDate(vehicaldto.getSoldDate());
		      }
		
		vehicleRepository.save(v);
		vehicaldto.setId(v.getId());
		vehicaldto.setStatus(v.getStatus());
		return vehicaldto;
	}

	@Override
	public VehicalDTO updateStatus(Integer id, VehicleUpdateDTO vehicleUpdateDTO ) throws VehicleException {
		
		Optional<Vehicle> voptional=vehicleRepository.findById(id);
		Vehicle v=voptional.orElseThrow(()-> new VehicleException("VehicleValidator.INVALID_ID"));
		if(v!=null) {
			v.setStatus(vehicleUpdateDTO.getStatus());
			v.setSoldDate(vehicleUpdateDTO.getSoldDate());
			vehicleRepository.save(v);
		}
		VehicalDTO vdto=new VehicalDTO();
		vdto.setId(v.getId());
		vdto.setMake(v.getMake());
		vdto.setModelName(v.getModelName());
		vdto.setSoldDate(v.getSoldDate());
		vdto.setStatus(v.getStatus());
		vdto.setYear(v.getYear());
		
		return vdto;
			
		
		
	}

//	@Override
//	public List<VehicalDTO> soldVehiclesInSpecificDays(Integer noOfDays,String status) throws VehicleException {
//		return null;
//		Optional<Vehicle> v =vehicleRepository.findBySoldDateAndStatus(LocalDate.now().minusDays(noOfDays),status);
//		if(v.isEmpty())throw new VehicleException("vehicle.NOT_PRESENT");
//		
//		return v.stream().map(vehicle->{
//			VehicalDTO vdto=new VehicalDTO();		
//			vdto.setId(vehicle.getId());
//			vdto.setMake(vehicle.getMake());
//			vdto.setModelName(vehicle.getModelName());			
//			vdto.setSoldDate(vehicle.getSoldDate());
//			vdto.setStatus(vehicle.getStatus());
//		
//			vdto.setYear(vehicle.getYear());
//			return vdto;
//		}).collect(Collectors.toList());
//	}

}
