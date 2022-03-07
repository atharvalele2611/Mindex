package com.mindex.challenge.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService {

	private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

	@Autowired
	private CompensationRepository compensationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Compensation createCompensation(@RequestBody Compensation compensation) {
		LOG.debug("Creating compensation for [{}]", compensation);
		Employee employee = employeeRepository.findByEmployeeId(compensation.getEmployeeId());

		// Employee should be present for server to create a compensation
		if (employee == null) {
			throw new RuntimeException("Invalid employeeId: " + compensation.getEmployeeId());
		}
		
		return compensationRepository.insert(compensation);
	}

	@Override
	public Compensation getCompensation(String employeeId) {
		LOG.debug("Getting compensation for employee id [{}] ", employeeId);
		Compensation compensation = compensationRepository.findByEmployeeId(employeeId);
		if (compensation == null) {
			throw new RuntimeException("Compenstaion for employee " + employeeId +  " doesnot exist");
		}
		return compensation;
	}
	
	@Override
    public Compensation updateCompensation(Compensation compensation) {
        LOG.debug("Updating compensation [{}]", compensation);
        return compensationRepository.save(compensation);
    }
	
	public List<Compensation> getAll() {
        LOG.debug("Getting all Compensation");
        return compensationRepository.findAll();
    }

}
