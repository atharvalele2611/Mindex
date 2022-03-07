package com.mindex.challenge.service;

import java.util.List;

import com.mindex.challenge.data.Compensation;

public interface CompensationService {
	Compensation createCompensation(Compensation compensation);
	Compensation getCompensation(String employeeId);
	List<Compensation> getAll();
	Compensation updateCompensation(Compensation compensation);
}
