package com.mbtc_empr_app.api.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mbtc_empr_app.api.dto.DevAssignmentDTO;
import com.mbtc_empr_app.api.entity.DevAssignment;
import com.mbtc_empr_app.api.repositroy.AssignmentTypeRepository;
import com.mbtc_empr_app.api.repositroy.DevAssignmentRepository;
import com.mbtc_empr_app.api.repositroy.DeveloperRepository;
import com.mbtc_empr_app.api.repositroy.ServiceRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevAssignmentService {
    
    @Autowired 
    private DevAssignmentRepository devAssignmentRepository;

    @Autowired 
    private DeveloperRepository developerRepository;

    @Autowired 
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired 
    private AssignmentTypeRepository assignmentTypeRepository;

    public List<DevAssignmentDTO> getDevAssignments() {
        return this.DevAssignDTOListConversion(this.devAssignmentRepository.findAll());
    }

    public DevAssignmentDTO getDevAssignment(Integer devAssignmentID) { 
        if(devAssignmentID <= 0) throw new IllegalStateException("Invalid id " + devAssignmentID);
        DevAssignmentDTO foundDevAssignmentDTO = DevAssignDTOConversion(this.devAssignmentRepository.findById(devAssignmentID).orElseThrow(
          () -> new IllegalStateException("Dev Assignment with id " + devAssignmentID + " does not exist")
        ));
        return foundDevAssignmentDTO;
    }

    public void saveDevAssignment(DevAssignmentDTO devAssignmentDTO){
        this.devAssignmentRepository.save(DevAssignEntityConversion(devAssignmentDTO));
    }

    public void deleteDevAssignment(Integer devAssignmentID) { 
        DevAssignmentDTO foundDeveloperDTO = this.getDevAssignment(devAssignmentID);
        foundDeveloperDTO.ServiceRequestID = 0;
        this.saveDevAssignment(foundDeveloperDTO);
    }

    public DevAssignmentDTO DevAssignDTOConversion(DevAssignment devAssignment){
		DevAssignmentDTO devAssignmentDTO = new DevAssignmentDTO();
        devAssignmentDTO.DevAssignmentID = devAssignment.getDevAssignmentID();
        devAssignmentDTO.IsActive = devAssignment.getIsActive();
        devAssignmentDTO.ServiceRequestID = devAssignment.getServiceRequestID();
        devAssignmentDTO.AssignmentTypeID = devAssignment.getAssignmentTypeID();
        devAssignmentDTO.DateCreated = devAssignment.getDateCreated();
        devAssignmentDTO.CreatedBy = devAssignment.getCreatedBy();
        devAssignmentDTO.DateModified = devAssignment.getDateModified();
        devAssignmentDTO.ModifiedBy = devAssignment.getModifiedBy();
        if (devAssignment.getDeveloperID()!= null) 
            devAssignmentDTO.DeveloperName = this.developerRepository.findById(devAssignment.getDeveloperID()).get().getFullName();
        if (devAssignment.getServiceRequestID() != null) 
            devAssignmentDTO.ServiceRequestTitle = this.serviceRequestRepository.findById(devAssignment.getServiceRequestID()).get().getTitle();
        if (devAssignment.getAssignmentTypeID() != null) 
            devAssignmentDTO.AssignmentType = this.assignmentTypeRepository.findById(devAssignment.getAssignmentTypeID()).get().getAssignmentType();
		return devAssignmentDTO;
	}
	public List<DevAssignmentDTO> DevAssignDTOListConversion(List<DevAssignment> devAssignments){
		return devAssignments.stream().map(devAssignment -> DevAssignDTOConversion(devAssignment)).collect(Collectors.toList());
	}

    public DevAssignment DevAssignEntityConversion(DevAssignmentDTO devAssignmentDTO){
		DevAssignment devAssignment = new DevAssignment();
        devAssignment.setDevAssignmentID(devAssignmentDTO.DevAssignmentID);
        devAssignment.setIsActive(devAssignmentDTO.IsActive);
        devAssignment.setDeveloperID(devAssignmentDTO.DeveloperID);
        devAssignment.setServiceRequestID(devAssignmentDTO.ServiceRequestID);
        devAssignment.setAssignmentTypeID(devAssignmentDTO.AssignmentTypeID);
        devAssignment.setDateCreated(devAssignmentDTO.DateCreated);
        devAssignment.setCreatedBy(devAssignmentDTO.CreatedBy);
        devAssignment.setDateModified(devAssignmentDTO.DateModified);
        devAssignment.setModifiedBy(devAssignmentDTO.ModifiedBy);
		return devAssignment;
	}
	public List<DevAssignment> DepEntityListConversion(List<DevAssignmentDTO> devAssignmentsDTO){
		return devAssignmentsDTO.stream().map(devAssignmentDTO -> DevAssignEntityConversion(devAssignmentDTO)).collect(Collectors.toList());
	}
}
