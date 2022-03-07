package com.mindex.challenge.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;
    
    @PostMapping("/compensation")
    public Compensation create(@Valid @NotBlank @NotNull @RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);

        return compensationService.createCompensation(compensation);
    }
    
    
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Recieved get request for compensation for employee [{}]", id);

        return compensationService.getCompensation(id);
    }
    
    @GetMapping("/compensation/")
    public List<Compensation> getAll() {
        LOG.debug("Recieved request for all compensations");

        return compensationService.getAll();
    }
    
    @PutMapping("/compensation/{id}")
    public Compensation update(@PathVariable String id,@Valid @NotBlank @NotNull @RequestBody Compensation compensation) {
        LOG.debug("Received compensation update request for id [{}] and employee [{}]", id, compensation);

        compensation.setEmployeeId(id);
        return compensationService.updateCompensation(compensation);
    }
    
    
    
}
