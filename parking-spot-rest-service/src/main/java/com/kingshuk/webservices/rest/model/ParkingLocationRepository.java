package com.kingshuk.webservices.rest.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingshuk.webservices.rest.model.entities.ParkingLocationEntity;

public interface ParkingLocationRepository extends JpaRepository<ParkingLocationEntity, Integer> {
	
	List<ParkingLocationEntity> findByZipCode(String zipCode);
	
	List<ParkingLocationEntity> findByStreetAndCity(String street, String city);

}
