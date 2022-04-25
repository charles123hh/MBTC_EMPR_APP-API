package com.mbtc_empr_app.api.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mbtc_empr_app.api.dto.AssignmentTypeDTO;
import com.mbtc_empr_app.api.entity.AssignmentType;
import com.mbtc_empr_app.api.repositroy.AssignmentTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentTypeService {

    @Autowired 
    private AssignmentTypeRepository assignmentTypeRepository;

    public List<AssignmentTypeDTO> getAssignmentTypes() {
		return this.AssigTypeDTOListConvertsion(this.assignmentTypeRepository.findAll());
	}

    public AssignmentTypeDTO AssigTypeDTOConvertsion(AssignmentType assignmentType){
		AssignmentTypeDTO assignmentTypeDTO = new AssignmentTypeDTO();
        assignmentTypeDTO.AssignmentTypeID = assignmentType.getAssignmentTypeID();
        assignmentTypeDTO.AssignmentType = assignmentType.getAssignmentType();
        assignmentTypeDTO.DateCreated = assignmentType.getDateCreated();
        assignmentTypeDTO.CreatedBy = assignmentType.getCreatedBy();
		return assignmentTypeDTO;
	}
	public List<AssignmentTypeDTO> AssigTypeDTOListConvertsion(List<AssignmentType> assignmentTypes){
		return assignmentTypes.stream().map(assignmentType ->AssigTypeDTOConvertsion(assignmentType)).collect(Collectors.toList());
	}
	
	public AssignmentType AssigTypeEntityConvertsion(AssignmentTypeDTO assignmentTypeDTO){
		AssignmentType assignmentType = new AssignmentType();
        assignmentType.setAssignmentTypeID(assignmentTypeDTO.AssignmentTypeID);
        assignmentType.setAssignmentType(assignmentTypeDTO.AssignmentType);
        assignmentType.setDateCreated(assignmentTypeDTO.DateCreated);
        assignmentType.setCreatedBy(assignmentTypeDTO.CreatedBy);
		return assignmentType;
	}
	public List<AssignmentType> AssigTypeEntityListConvertsion(List<AssignmentTypeDTO> assignmentTypesDTO){
		return assignmentTypesDTO.stream().map(assignmentTypeDTO -> AssigTypeEntityConvertsion(assignmentTypeDTO)).collect(Collectors.toList());
	}

}
