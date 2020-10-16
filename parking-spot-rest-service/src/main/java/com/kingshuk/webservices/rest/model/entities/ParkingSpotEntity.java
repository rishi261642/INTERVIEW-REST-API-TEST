package com.kingshuk.webservices.rest.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PARKING_SPOT")
public class ParkingSpotEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4468044358148477898L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARKING_SPOT_NO")
	private int parkingSpotNumber;

	@Column(name = "IS_HANDICAPPED")
	private boolean isHandicapped;

	@Column(name = "ISOCCUPIED")
	private boolean isOccupied;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID", nullable = false)
	private ParkingLocationEntity locationEntity;
}
