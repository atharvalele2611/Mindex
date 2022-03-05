package com.mindex.challenge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService{

	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
	
	 @Autowired
	 private EmployeeRepository employeeRepository;

	@Override
	public ReportingStructure getRS(String employeeId) {
		LOG.debug("Getting ReportingStructure for employee [{}]", employeeId);
		ReportingStructure rs = new ReportingStructure();
		List<Employee> reporteeList = getReportees(new ArrayList<Employee>(),employeeId);
		rs.setEmployeeStructure(reporteeList);
		rs.setNumberOfReports(reporteeList.size());
		return rs;
	}
	
	private List<Employee> getReportees(List<Employee> employeeList, String employeeId){
		Employee e = employeeRepository.findByEmployeeId(employeeId);
		List<Employee> ls = e.getDirectReports();
		if (ls != null) {
			for (Employee em : ls) {
				employeeList.add(em);
				employeeList = getReportees(employeeList,em.getEmployeeId());
			}
		}
		return employeeList;
	}
	 
	
}
