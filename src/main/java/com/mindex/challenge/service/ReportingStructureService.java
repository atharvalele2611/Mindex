/*
 * ReportingStructureService.java
 *
 * Version:
 *     v1.0
 *
 * Revisions:
 *     $Log$
 */
package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

/**
 * ReportingStructure interface API, anyone who implements this interface should implement the below services.
 * 
 * @author atharvalele
 *
 */
public interface ReportingStructureService {
	ReportingStructure getRS(String id);
}
