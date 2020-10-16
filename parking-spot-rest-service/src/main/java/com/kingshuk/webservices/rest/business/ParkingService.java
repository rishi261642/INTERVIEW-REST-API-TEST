package com.kingshuk.webservices.rest.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.kingshuk.webservices.rest.model.ParkingLocationRepository;
import com.kingshuk.webservices.rest.model.ParkingSpotRepository;
import com.kingshuk.webservices.rest.model.dto.ParkingLocation;
import com.kingshuk.webservices.rest.model.dto.ParkingSpot;
import com.kingshuk.webservices.rest.model.entities.ParkingLocationEntity;
import com.kingshuk.webservices.rest.model.entities.ParkingSpotEntity;

@Service
public class ParkingService implements IParkingSpotService {

	private final ParkingLocationRepository locationRepository;

	private final ParkingSpotRepository spotRepository;

	private final DozerBeanMapper beanMapper;

	public ParkingService(ParkingLocationRepository locationRepository, ParkingSpotRepository spotRepository,
			DozerBeanMapper beanMapper) {
		this.locationRepository = locationRepository;
		this.spotRepository = spotRepository;
		this.beanMapper = beanMapper;
	}

	@Override
	public Integer addParkingLocation(ParkingLocation location) {

		ParkingLocationEntity mappedEntity = beanMapper.map(location, ParkingLocationEntity.class);
		mappedEntity.getParkingSpots().forEach(spotEntity -> spotEntity.setLocationEntity(mappedEntity));
		ParkingLocationEntity addedLocation = locationRepository.save(mappedEntity);
		return addedLocation.getLocationId();
	}

	@Override
	public Integer addParkingSpot(ParkingSpot parkingSpot) {
		ParkingSpotEntity addedParkingSpot = spotRepository.save(beanMapper.map(parkingSpot, ParkingSpotEntity.class));
		return addedParkingSpot.getParkingSpotNumber();
	}

	@Override
	public List<ParkingSpot> getAvailableSpots(String zipCode, String street, String city) {
		Preconditions.checkArgument(
				StringUtils.isNotBlank(zipCode) || (StringUtils.isNotBlank(street) && StringUtils.isNotBlank(city)));

		List<ParkingLocationEntity> locations = null;

		if (StringUtils.isNotBlank(zipCode)) {
			locations = locationRepository.findByZipCode(zipCode);
		} else {
			locations = locationRepository.findByStreetAndCity(street, city);
		}

		List<ParkingSpotEntity> parkingSpots = new ArrayList<>();

		List<ParkingSpot> emptyParkingSpots = new ArrayList<>();

		if (!CollectionUtils.isEmpty(locations)) {
			for (ParkingLocationEntity location : locations) {
				List<ParkingSpotEntity> parkingSpots2 = location.getParkingSpots();

				parkingSpots.addAll(parkingSpots2.stream().filter(parkingSpot -> !parkingSpot.isOccupied())
						.collect(Collectors.toList()));
			}
		}

		parkingSpots.forEach(parkingSpot -> emptyParkingSpots.add(beanMapper.map(parkingSpot, ParkingSpot.class)));

		return emptyParkingSpots;
	}

}
