/*
 * CompensationController.java
 *
 * Version:
 *     v1.0
 *
 * Revisions:
 *     $Log$
 */
package com.mindex.challenge.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

/**
 * CompensationController for the Compensation Service to support REST
 * endpoints.
 * 
 * @author atharvalele
 *
 */
@RestController
public class CompensationController {
	private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

	@Autowired
	private CompensationService compensationService;

	/**
	 * Post endpoint for compensation service. This create a compensaiton for the a
	 * given employee id found in the request body.
	 * 
	 * Sample Request : { "employeeId": "b7839309-3348-463b-a7e3-5de1c168beb3",
	 * "salary":{ "amount" : 150000, "currency": "USD" }, 
	 * "effectiveDate": "07-03-2022" }
	 * 
	 * @param compensation
	 * @return Compensation object containing the newly create Compensation
	 */
	@PostMapping("/compensation")
	public Compensation create(@Valid @NotBlank @NotNull @RequestBody Compensation compensation) {
		LOG.debug("Received compensation create request for [{}]", compensation);

		return compensationService.createCompensation(compensation);
	}

	
	/**
	 * Get endpoint to read the compensation for a given employeeId.
	 * 
	 * 
	 * @param employeeId employeeId for which we want to fetch compensation information.
	 * @return Compensation object containing the received Compensation details
	 */
	@GetMapping("/compensation/{id}")
	public Compensation read(@PathVariable String employeeId) {
		LOG.debug("Recieved get request for compensation for employee [{}]", employeeId);

		return compensationService.getCompensation(employeeId);
	}
	
	/**
	 * Get endpoint to fetch all stored compensation information.
	 * 
	 * @return List of all Compensations.
	 */

	@GetMapping("/compensation/")
	public List<Compensation> getAll() {
		LOG.debug("Recieved request for all compensations");
		return compensationService.getAll();
	}

	/**
	 * Put endpoint if we want to update a particular compensation.
	 * 
	 * @param employeeId employeeId for which we want to fetch compensation information.
	 * @param compensation Compensation object containing the updated compensation information.
	 * @return Compensation object containing the updated details.
	 */
	@PutMapping("/compensation/{id}")
	public Compensation update(@PathVariable String employeeId,
			@Valid @NotBlank @NotNull @RequestBody Compensation compensation) {
		LOG.debug("Received compensation update request for id [{}] and employee [{}]", employeeId, compensation);

		compensation.setEmployeeId(employeeId);
		return compensationService.updateCompensation(compensation);
	}

}
