package com.mbtc_empr_app.api.controller;


import java.util.List;

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

    @PostMapping
	public void createDevAssignments(@RequestBody List<DevAssignmentDTO> devAssignmentsDTO) {
        for(int index = 0; index < devAssignmentsDTO.size(); index++){
            this.devAssignmentService.saveDevAssignment(devAssignmentsDTO.get(index));
        }
	}

    @DeleteMapping(path = "/{devAssignmentID}")
    public void deleteDeveloper(@PathVariable("devAssignmentID") Integer devAssignmentID){
        this.devAssignmentService.deleteDevAssignment(devAssignmentID);
    }
}
