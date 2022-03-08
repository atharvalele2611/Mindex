/*
 * CompensationServiceImpl.java
 *
 * Version:
 *     v1.0
 *
 * Revisions:
 *     $Log$
 */
package com.mindex.challenge.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;

/**
 * CompensationService Implementation which implements CompensationService.
 * This service talks with the backend repository and handles all the calls from the rest controller
 * and provides an accurate output back to the controller.
 * 
 * This class handles all the calls associated with Compensations.
 * 
 * @author atharvalele
 *
 */
@Service
public class CompensationServiceImpl implements CompensationService {

	private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

	@Autowired
	private CompensationRepository compensationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * This create a compensaiton for the a given employee id found in the request body.
	 * Calls the backend repository insert method to add an entry in the compensation Repository
	 * 
	 * @param: compensation contains the compensation details.
	 */
	@Override
	public Compensation createCompensation(Compensation compensation) {
		LOG.debug("Creating compensation for [{}]", compensation);
		Employee employee = employeeRepository.findByEmployeeId(compensation.getEmployeeId());

		// Employee should be present for server to create a compensation
		if (employee == null) {
			throw new RuntimeException("Invalid employeeId: " + compensation.getEmployeeId());
		}
		
		return compensationRepository.insert(compensation);
	}

	/**
	 * gets the compensation of a particular employee.
	 * Calls the backend repository's findByEmployeeId method to find an entry in the compensation Repository 
	 * 
	 * @param employeeId employeeId for which we need compensation details.
	 */
	@Override
	public Compensation getCompensation(String employeeId) {
		LOG.debug("Getting compensation for employee id [{}] ", employeeId);
		Compensation compensation = compensationRepository.findByEmployeeId(employeeId);
		if (compensation == null) {
			throw new RuntimeException("Compenstaion for employee " + employeeId +  " doesnot exist");
		}
		return compensation;
	}
	
	/**
	 * updates the compensation of a particular employeeId
	 * Calls the backend repository's save method to save a particular entry in the compensation Repository.
	 * If compensation with same id is already present it updates or else inserts.
	 */
	@Override
    public Compensation updateCompensation(Compensation compensation) {
        LOG.debug("Updating compensation [{}]", compensation);
        return compensationRepository.save(compensation);
    }
	
	/**
	 * gets a list of all the available compensations in the compensaiton Repository.
	 * Calls the backend repository's findAll method to find all entry in the compensation Repository 
	 */
	public List<Compensation> getAll() {
        LOG.debug("Getting all Compensation");
        return compensationRepository.findAll();
    }

}
