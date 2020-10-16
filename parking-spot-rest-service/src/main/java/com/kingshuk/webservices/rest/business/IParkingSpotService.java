package com.kingshuk.webservices.rest.business;

import java.util.List;

import com.kingshuk.webservices.rest.model.dto.ParkingLocation;
import com.kingshuk.webservices.rest.model.dto.ParkingSpot;

public interface IParkingSpotService {
	
	Integer addParkingLocation(ParkingLocation location);
	
	Integer addParkingSpot(ParkingSpot location);
	
	List<ParkingSpot> getAvailableSpots(String city, String zipCode, String street);

}
