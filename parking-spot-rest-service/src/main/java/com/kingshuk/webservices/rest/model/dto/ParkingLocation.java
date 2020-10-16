package com.kingshuk.webservices.rest.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLocation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8539782955312327082L;

	private int locationId;

	private String zipCode;
	
	private String city;
	
	private String street;
	
	private List<ParkingSpot> parkingSpots;
}
