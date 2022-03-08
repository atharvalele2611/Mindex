/*
 * Employee.java
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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Employee {
	// to fix the issue where save inserts instead of updating. 
	// This will bind employeeId to _id making it unique. 
	// Else every Object is treated as a new object
	@Id	 
    private String employeeId;
	@NotBlank
    private String firstName;
	@NotBlank
    private String lastName;
	@NotNull
    private String position;
	@NotNull
    private String department;
    private List<Employee> directReports;

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }
    
    @Override
    public String toString() {
    	String directR = directReports != null ? Arrays.toString(directReports.toArray()) : "";
    	return employeeId + " " + firstName +" " + lastName + " " + position + " " + department + " " + directR; 
    }
}
