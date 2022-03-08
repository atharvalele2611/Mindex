/*
 * CompensationService.java
 *
 * Version:
 *     v1.0
 *
 * Revisions:
 *     $Log$
 */
package com.mindex.challenge.service;

import java.util.List;

import com.mindex.challenge.data.Compensation;

/**
 * Compensation Service API. anyone who implements this interface should implement the below services.
 * 
 * @author atharvalele
 *
 */
public interface CompensationService {
	Compensation createCompensation(Compensation compensation);
	Compensation getCompensation(String employeeId);
	List<Compensation> getAll();
	Compensation updateCompensation(Compensation compensation);
}
