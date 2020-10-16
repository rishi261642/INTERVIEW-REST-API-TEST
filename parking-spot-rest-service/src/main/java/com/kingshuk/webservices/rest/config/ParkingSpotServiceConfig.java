package com.kingshuk.webservices.rest.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ParkingSpotServiceConfig {
		
		@Bean
		public DozerBeanMapper getDozerBeanMapper() {
			return new DozerBeanMapper();
		}

}
