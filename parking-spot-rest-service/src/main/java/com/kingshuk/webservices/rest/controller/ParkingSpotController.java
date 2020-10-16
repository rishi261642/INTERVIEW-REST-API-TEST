package com.kingshuk.webservices.rest.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.kingshuk.webservices.rest.business.IParkingSpotService;
import com.kingshuk.webservices.rest.model.dto.ParkingLocationSearch;
import com.kingshuk.webservices.rest.model.dto.ParkingSpot;

@RestController
public class ParkingSpotController {

	private final IParkingSpotService parkingService;

	public ParkingSpotController(IParkingSpotService parkingService) {
		super();
		this.parkingService = parkingService;
	}

//	@GetMapping(path = "parking-spots", params = {
//			"zipCode, street, city" }, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/parking-spots", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ParkingSpot>> getFreeParkingLocations(
			@RequestParam(name = "zipCode", required = false) final String zipCode,
			@RequestParam(name = "street", required = false) final String street,
			@RequestParam(name = "city", required = false) final String city) {
		Preconditions.checkArgument(
				StringUtils.isNotBlank(zipCode) || (StringUtils.isNotBlank(street) && StringUtils.isNotBlank(city)));
		return prepareData(zipCode, street, city);

	}

	@PutMapping(path = "/parking-spots", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ParkingSpot>> getFreeParkingLocations2(@RequestBody ParkingLocationSearch searchParams) {
		Preconditions.checkArgument(
				StringUtils.isNotBlank(searchParams.getZipCode()) || (StringUtils.isNotBlank(searchParams.getStreet())
						&& StringUtils.isNotBlank(searchParams.getCity())));
		return prepareData(searchParams.getZipCode(), searchParams.getStreet(), searchParams.getCity());
	}

	private ResponseEntity<List<ParkingSpot>> prepareData(final String zipCode, final String street,
			final String city) {
		List<ParkingSpot> availableSpots = parkingService.getAvailableSpots(zipCode, street, city);
		return ResponseEntity.ok(availableSpots);
	}

}
