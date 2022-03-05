package com.mindex.challenge.data;

import java.util.Arrays;
import java.util.List;

public class ReportingStructure {
	private Integer numberOfReports;
	private List<Employee> employeeStructure;

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
