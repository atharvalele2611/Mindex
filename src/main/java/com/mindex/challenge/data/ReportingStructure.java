/*
 * ReportingStructure.java
 *
 * Version:
 *     v1.0
 *
 * Revisions:
 *     $Log$
 */
package com.mindex.challenge.data;

import java.util.Arrays;
import java.util.List;

/**
 * ReportingStructure class containing the numberOfReports field and list of employees who reporting to a particular employee.
 * 
 * 
 * @author atharvalele
 *
 */
public class ReportingStructure {
	private Integer numberOfReports;
	private List<Employee> employeeStructure;

	/**
	 * gets the employee structure
	 * @return employeeStructure
	 */
	public List<Employee> getEmployeeStructure() {
		return employeeStructure;
	}

	public Integer getNumberOfReports() {
		return numberOfReports;
	}

	public String toString() {
		return Arrays.toString(employeeStructure.toArray()) + " " + numberOfReports;
	}

	public void setEmployeeStructure(List<Employee> employeeStructure) {
		this.employeeStructure = employeeStructure;
	}

	public void setNumberOfReports(Integer numberOfReports) {
		this.numberOfReports = numberOfReports;
	}
}
