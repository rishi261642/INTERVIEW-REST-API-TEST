package com.kingshuk.webservices.rest.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingshuk.webservices.rest.model.entities.ParkingSpotEntity;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpotEntity, Integer> {

}
