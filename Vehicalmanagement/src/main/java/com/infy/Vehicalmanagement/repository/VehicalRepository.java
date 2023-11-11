package com.infy.Vehicalmanagement.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.metamodel.mapping.internal.VirtualIdEmbeddable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infy.Vehicalmanagement.entity.Vehicle;

public interface VehicalRepository extends CrudRepository<Vehicle, Integer>{
List<Vehicle> findAll();
Optional<Vehicle> findById(Integer Id);
//@Query("SELECT v from vehicle v WHERE v.soldDate=:soldDate AND v.status=:status")
//Optional<Vehicle> findBySoldDateAndStatus(LocalDate soldDate,String status);
}
