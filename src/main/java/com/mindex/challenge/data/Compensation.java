package com.mindex.challenge.data;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Compensation {
	@Id
	@JsonProperty("employeeId")
	private String employeeId;
	@NotNull
	private Salary salary;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date effectiveDate;

	public Compensation() {
	}

	public Compensation(String employeeId, Salary salary, Date effectiveDate) {
		this.employeeId = employeeId;
		this.salary = salary;
		this.effectiveDate = effectiveDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Salary getSalary() {
		return salary;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public String toString() {
		return employeeId + " " + salary + " " + effectiveDate;
	}
}