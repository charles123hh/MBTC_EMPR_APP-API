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
    private  AssignmentTypeRepository AssignmentTypeRepository;

    public List<AssignmentTypeDTO> getAssignmentTypes() {
		return this.DepDTOListConvertsion(this.AssignmentTypeRepository.findAll());
	}

    public AssignmentTypeDTO DepDTOConvertsion(AssignmentType AssignmentType){
		AssignmentTypeDTO AssignmentTypeDTO = new AssignmentTypeDTO();
        AssignmentTypeDTO.AssignmentTypeID = AssignmentType.getAssignmentTypeID();
        AssignmentTypeDTO.AssignmentType = AssignmentType.getAssignmentType();
        AssignmentTypeDTO.DateCreated = AssignmentType.getDateCreated();
        AssignmentTypeDTO.CreatedBy = AssignmentType.getCreatedBy();
		return AssignmentTypeDTO;
	}

	public List<AssignmentTypeDTO> DepDTOListConvertsion(List<AssignmentType> AssignmentTypes){
		return AssignmentTypes.stream().map(AssignmentType -> DepDTOConvertsion(AssignmentType)).collect(Collectors.toList());
	}

	public AssignmentType DepEntityConvertsion(AssignmentTypeDTO AssignmentTypeDTO){
		AssignmentType AssignmentType = new AssignmentType();
        AssignmentType.setAssignmentTypeID(AssignmentTypeDTO.AssignmentTypeID);
        AssignmentType.setAssignmentType(AssignmentTypeDTO.AssignmentType);
        AssignmentType.setDateCreated(AssignmentTypeDTO.DateCreated);
        AssignmentType.setCreatedBy(AssignmentTypeDTO.CreatedBy);
		return AssignmentType;
	}

	public List<AssignmentType> DepEntityListConvertsion(List<AssignmentTypeDTO> AssignmentTypesDTO){
		return AssignmentTypesDTO.stream().map(AssignmentTypeDTO -> DepEntityConvertsion(AssignmentTypeDTO)).collect(Collectors.toList());
	}

}
