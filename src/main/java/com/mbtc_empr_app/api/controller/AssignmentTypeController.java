package com.mbtc_empr_app.api.controller;

import java.util.List;

import com.mbtc_empr_app.api.dto.AssignmentTypeDTO;
import com.mbtc_empr_app.api.service.AssignmentTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/AssignmentTypes")
public class AssignmentTypeController {

    @Autowired
    private AssignmentTypeService AssignmentTypeService;

    @GetMapping
	public List<AssignmentTypeDTO> fetchAssignmentTypes() {
		return this.AssignmentTypeService.getAssignmentTypes();
	}

}
