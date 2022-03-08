/*
 * ReportingStructureController.java
 *
 * Version:
 *     v1.0
 *
 * Revisions:
 *     $Log$
 */
package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

/**
 * ReportingStructureController for the ReportingStructure Service to support REST
 * endpoints.
 * 
 * @author atharvalele
 *
 */
@RestController
public class ReportingStructureController {
	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);
	
	@Autowired
    private ReportingStructureService reportingStructureService;
	
	/**
	 * Get endpoing to read the reporting structure of a given employeeId
	 * 
	 * @param employeeId employeeId for which we want to read ReportingStructure
	 * @return ReportingStructure Object containing the details of employees who report to employeeId
	 */
	@GetMapping("/reporting/{id}")
    public ReportingStructure getRS(@PathVariable String employeeId) {
		LOG.debug("Received reportingStructure request for id [{}]", employeeId);
		return reportingStructureService.getRS(employeeId); 
    }

}
