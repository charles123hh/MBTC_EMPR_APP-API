package com.mbtc_empr_app.api.controller;


import java.util.List;

import javax.transaction.Transactional;

import com.mbtc_empr_app.api.dto.DevAssignmentDTO;
import com.mbtc_empr_app.api.service.DevAssignmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/developer/assignments")
public class DevAssignmentController {

    @Autowired
    private DevAssignmentService devAssignmentService;
    
    @GetMapping
	public List<DevAssignmentDTO> fetchDevAssignments() {
        return this.devAssignmentService.getDevAssignments();
	}

    @Transactional
    @PostMapping
	public void createDevAssignments(@RequestBody List<DevAssignmentDTO> devAssignmentsDTO) {
        this.devAssignmentService.saveAllDevAssignment(devAssignmentsDTO);
	}

    @DeleteMapping(path = "/{devAssignmentID}")
    public void deleteDevAssignment(@PathVariable("devAssignmentID") Integer devAssignmentID){
        this.devAssignmentService.deleteDevAssignment(devAssignmentID);
    }
}
