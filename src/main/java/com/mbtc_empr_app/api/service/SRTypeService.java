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
    private  SRTypeRepository srTypeRepository;

    public List<SRTypeDTO> getSRTypes() {
		return this.SRTypeDTOListConvertsion(this.srTypeRepository.findAll());
	}

    public SRTypeDTO SRTypeDTOConvertsion(SRType SRType){
		SRTypeDTO SRTypeDTO = new SRTypeDTO();
        SRTypeDTO.SRTypeID = SRType.getSRTypeID();
        SRTypeDTO.SRType = SRType.getSRType();
        SRTypeDTO.DateCreated = SRType.getDateCreated();
        SRTypeDTO.CreatedBy = SRType.getCreatedBy();
		return SRTypeDTO;
	}

	public List<SRTypeDTO> SRTypeDTOListConvertsion(List<SRType> SRTypes){
		return SRTypes.stream().map(SRType -> SRTypeDTOConvertsion(SRType)).collect(Collectors.toList());
	}

	public SRType SRTypeEntityConvertsion(SRTypeDTO SRTypeDTO){
		SRType SRType = new SRType();
        SRType.setSRTypeID(SRTypeDTO.SRTypeID);
        SRType.setSRType(SRTypeDTO.SRType);
        SRType.setDateCreated(SRTypeDTO.DateCreated);
        SRType.setCreatedBy(SRTypeDTO.CreatedBy);
		return SRType;
	}

	public List<SRType> SRTypeEntityListConvertsion(List<SRTypeDTO> SRTypesDTO){
		return SRTypesDTO.stream().map(SRTypeDTO -> SRTypeEntityConvertsion(SRTypeDTO)).collect(Collectors.toList());
	}

}
