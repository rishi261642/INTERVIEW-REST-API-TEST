package com.kingshuk.webservices.rest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.kingshuk.webservices.rest.business.IParkingSpotService;
import com.kingshuk.webservices.rest.model.dto.ParkingLocation;
import com.kingshuk.webservices.rest.model.dto.ParkingSpot;

@SpringBootApplication
public class ParkingSpotRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingSpotRestServiceApplication.class, args);
	}

}

@Component
class DataUploader implements CommandLineRunner {

	private final IParkingSpotService service;

	public DataUploader(IParkingSpotService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {
		ParkingSpot spot1 = ParkingSpot.builder().isHandicapped(false).isOccupied(false).build();

		ParkingSpot spot2 = ParkingSpot.builder().isHandicapped(false).isOccupied(false).build();

		ParkingSpot spot3 = ParkingSpot.builder().isHandicapped(false).isOccupied(true).build();

		ParkingLocation parkingLocation = ParkingLocation.builder().city("Chicago").street("123 Main Street")
				.zipCode("60089").parkingSpots(Arrays.asList(spot1, spot2, spot3)).build();

		service.addParkingLocation(parkingLocation);
	}

}
