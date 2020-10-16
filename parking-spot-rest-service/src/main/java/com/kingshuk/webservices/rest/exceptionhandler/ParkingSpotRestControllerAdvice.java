package com.kingshuk.webservices.rest.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kingshuk.webservices.rest.controller.ParkingSpotController;
import com.kingshuk.webservices.rest.model.dto.MyCustomErrorResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(assignableTypes = { ParkingSpotController.class })
@Slf4j
public class ParkingSpotRestControllerAdvice {

	// Moving the exception handling to this class for controller
	@ExceptionHandler
	public ResponseEntity<MyCustomErrorResponse> handleEmployeeNotFoundException(
			ParkingSpotNotFoundException parkingSpotNotFoundException) {

		MyCustomErrorResponse customErrorResponse = new MyCustomErrorResponse();

		customErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		customErrorResponse.setMessage("No parking spot exists with the given parameter");

		return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<MyCustomErrorResponse> handleGenericException(Exception exception) {

		MyCustomErrorResponse customErrorResponse = new MyCustomErrorResponse();
		
		log.error("Something went wrong", exception);

		customErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		customErrorResponse.setMessage("The request contains invalid information: " + exception.getMessage());

		return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
