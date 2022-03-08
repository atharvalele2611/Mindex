/*
 * Salary.java
 *
 * Version:
 *     v1.0
 *
 * Revisions:
 *     $Log$
 */
package com.mindex.challenge.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Salary object containing the amount and currency for that position.
 * 
 * @author atharvalele
 *
 */
public class Salary {
	@NotNull
	private Integer amount;
	@NotBlank
	private String currency; // can be an enum with values like USD, INR, EUR, etc

	public Salary() {
	}
	
	public Salary(Integer amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return currency + amount;
	}
}
