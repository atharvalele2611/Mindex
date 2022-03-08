/*
 * Compensation.java
 *
 * Version:
 *     v1.0
 *
 * Revisions:
 *     $Log$
 */
package com.mindex.challenge.data;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Compensation Object structure containing the employeeId, Salary and EffectiveDate.
 * 
 * @author atharvalele
 *
 */
public class Compensation {
	@Id		// binds employeeId to the _id in mongo implying that this is unique.
	@JsonProperty("employeeId")
	private String employeeId;
	@NotNull
	private Salary salary;	// salary type which has amount and currency.
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date effectiveDate;

	public Compensation() {
	}

	public Compensation(String employeeId, Salary salary, Date effectiveDate) {
		this.employeeId = employeeId;
		this.salary = salary;
		this.effectiveDate = effectiveDate;
	}

	/**
	 * getter for employeeId
	 * @return employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * setter for employeeId
	 * @param employeeId
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * getter for salary
	 * @return salary
	 */
	public Salary getSalary() {
		return salary;
	}

	/**
	 * getter for date
	 * @returneffectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	@Override
	public String toString() {
		return employeeId + " " + salary + " " + effectiveDate;
	}
}