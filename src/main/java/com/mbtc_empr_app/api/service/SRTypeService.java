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
    private SRTypeRepository srTypeRepository;

    public List<SRTypeDTO> getSRTypes() {
		return this.SRTypeDTOListConvertsion(this.srTypeRepository.findAll());
	}

    public SRTypeDTO SRTypeDTOConvertsion(SRType srType){
		SRTypeDTO srTypeDTO = new SRTypeDTO();
        srTypeDTO.SRTypeID = srType.getSRTypeID();
        srTypeDTO.SRType = srType.getSRType();
        srTypeDTO.DateCreated = srType.getDateCreated();
        srTypeDTO.CreatedBy = srType.getCreatedBy();
		return srTypeDTO;
	}

	public List<SRTypeDTO> SRTypeDTOListConvertsion(List<SRType> srTypes){
		return srTypes.stream().map(srType -> SRTypeDTOConvertsion(srType)).collect(Collectors.toList());
	}
	public SRType SRTypeEntityConvertsion(SRTypeDTO srTypeDTO){
		SRType srType = new SRType();
        srType.setSRTypeID(srTypeDTO.SRTypeID);
        srType.setSRType(srTypeDTO.SRType);
        srType.setDateCreated(srTypeDTO.DateCreated);
        srType.setCreatedBy(srTypeDTO.CreatedBy);
		return srType;
	}
	public List<SRType> SRTypeEntityListConvertsion(List<SRTypeDTO> srTypesDTO){
		return srTypesDTO.stream().map(srTypeDTO -> SRTypeEntityConvertsion(srTypeDTO)).collect(Collectors.toList());
	}

}
