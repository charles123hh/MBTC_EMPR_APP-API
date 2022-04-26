package com.mbtc_empr_app.api.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mbtc_empr_app.api.dto.DepartmentDTO;
import com.mbtc_empr_app.api.entity.Department;
import com.mbtc_empr_app.api.repositroy.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired 
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getDepartments() {
		return this.DepDTOListConvertsion(this.departmentRepository.findAll());
	}

    public DepartmentDTO DepDTOConvertsion(Department department){
		DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.DepartmentID = department.getDepartmentID();
        departmentDTO.DepartmentName = department.getDepartmentName();
        departmentDTO.DateCreated = department.getDateCreated();
        departmentDTO.CreatedBy = department.getCreatedBy();
		return departmentDTO;
	}
	public List<DepartmentDTO> DepDTOListConvertsion(List<Department> departments){
		return departments.stream().map(department -> DepDTOConvertsion(department)).collect(Collectors.toList());
	}

	public Department DepEntityConvertsion(DepartmentDTO departmentDTO){
		Department department = new Department();
        department.setDepartmentID(departmentDTO.DepartmentID);
        department.setDepartmentName(departmentDTO.DepartmentName);
        department.setDateCreated(departmentDTO.DateCreated);
        department.setCreatedBy(departmentDTO.CreatedBy);
		return department;
	}
	public List<Department> DepEntityListConvertsion(List<DepartmentDTO> departmentsDTO){
		return departmentsDTO.stream().map(departmentDTO -> DepEntityConvertsion(departmentDTO)).collect(Collectors.toList());
	}

}
