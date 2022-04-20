package com.mbtc_empr_app.api.controller;

import java.util.List;

import com.mbtc_empr_app.api.dto.DepartmentDTO;
import com.mbtc_empr_app.api.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
	public List<DepartmentDTO> fetchDepartments() {
		return this.departmentService.getDepartments();
	}

}
