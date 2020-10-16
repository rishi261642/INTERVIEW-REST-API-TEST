package com.kingshuk.webservices.rest.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class ParkingLocationSearch implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8539782955312327082L;

	@JsonProperty(required = false)
	private String zipCode;
	
	@JsonProperty(required = false)
	private String city;
	
	@JsonProperty(required = false)
	private String street;
}
