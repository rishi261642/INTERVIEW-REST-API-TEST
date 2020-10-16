package com.kingshuk.webservices.rest.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name = "PARKING_LOCATION")
public class ParkingLocationEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4535453735904833136L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_ID")
	private int locationId;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STREET")
	private String street;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, mappedBy = "locationEntity")
	private List<ParkingSpotEntity> parkingSpots;

}
