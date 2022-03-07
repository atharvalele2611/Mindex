package com.mindex.challenge.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Salary {
	@NotNull
	private Integer amount;
	@NotBlank
	private String currency;

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
