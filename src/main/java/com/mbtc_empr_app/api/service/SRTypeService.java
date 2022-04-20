package com.mbtc_empr_app.api.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mbtc_empr_app.api.dto.SRTypeDTO;
import com.mbtc_empr_app.api.entity.SRType;
import com.mbtc_empr_app.api.repositroy.SRTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SRTypeService {

    @Autowired 
    private  SRTypeRepository SRTypeRepository;

    public List<SRTypeDTO> getSRTypes() {
		return this.DepDTOListConvertsion(this.SRTypeRepository.findAll());
	}

    public SRTypeDTO DepDTOConvertsion(SRType SRType){
		SRTypeDTO SRTypeDTO = new SRTypeDTO();
        SRTypeDTO.SRTypeID = SRType.getSRTypeID();
        SRTypeDTO.SRType = SRType.getSRType();
        SRTypeDTO.DateCreated = SRType.getDateCreated();
        SRTypeDTO.CreatedBy = SRType.getCreatedBy();
		return SRTypeDTO;
	}

	public List<SRTypeDTO> DepDTOListConvertsion(List<SRType> SRTypes){
		return SRTypes.stream().map(SRType -> DepDTOConvertsion(SRType)).collect(Collectors.toList());
	}

	public SRType DepEntityConvertsion(SRTypeDTO SRTypeDTO){
		SRType SRType = new SRType();
        SRType.setSRTypeID(SRTypeDTO.SRTypeID);
        SRType.setSRType(SRTypeDTO.SRType);
        SRType.setDateCreated(SRTypeDTO.DateCreated);
        SRType.setCreatedBy(SRTypeDTO.CreatedBy);
		return SRType;
	}

	public List<SRType> DepEntityListConvertsion(List<SRTypeDTO> SRTypesDTO){
		return SRTypesDTO.stream().map(SRTypeDTO -> DepEntityConvertsion(SRTypeDTO)).collect(Collectors.toList());
	}

}
