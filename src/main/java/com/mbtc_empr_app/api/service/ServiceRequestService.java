package com.mbtc_empr_app.api.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mbtc_empr_app.api.dto.ServiceRequestDTO;
import com.mbtc_empr_app.api.entity.ServiceRequest;
import com.mbtc_empr_app.api.repositroy.SRTypeRepository;
import com.mbtc_empr_app.api.repositroy.ServiceRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRequestService {
    
    @Autowired 
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private SRTypeRepository srTypeRepository;

    public List<ServiceRequestDTO> getServiceRequests() {
        return this.SRDTOListConvertsion(this.serviceRequestRepository.findAll());
    }

    public ServiceRequestDTO getServiceRequest(Integer serviceRequestID) { 
        if(serviceRequestID <= 0) throw new IllegalStateException("Invalid id " + serviceRequestID);
        ServiceRequestDTO foundServiceRequestDTO = SRDTOConvertsion(this.serviceRequestRepository.findById(serviceRequestID).orElseThrow(
            () -> new IllegalStateException("Service Request with id " + serviceRequestID + " does not exist")
        ));
        return foundServiceRequestDTO;
    }

    public void saveServiceRequest(ServiceRequestDTO serviceRequestDTO){
        this.serviceRequestRepository.save(SREntityConversion(serviceRequestDTO));
    }

    public ServiceRequestDTO SRDTOConvertsion(ServiceRequest serviceRequest){
		ServiceRequestDTO serviceRequestDTO = new ServiceRequestDTO();
        serviceRequestDTO.ServiceRequestID = serviceRequest.getServiceRequestID();
        serviceRequestDTO.SRNo = serviceRequest.getSRNo();
        serviceRequestDTO.Title = serviceRequest.getTitle();
        serviceRequestDTO.Description = serviceRequest.getDescription();
        serviceRequestDTO.Status = serviceRequest.getStatus();
        serviceRequestDTO.TargetYear = serviceRequest.getTargetYear();
        serviceRequestDTO.DateModified = serviceRequest.getDateModified();
        serviceRequestDTO.ModifiedBy = serviceRequest.getModifiedBy();
        serviceRequestDTO.DateCreated = serviceRequest.getDateCreated();
        serviceRequestDTO.CreatedBy = serviceRequest.getCreatedBy();
        if (serviceRequest.getSRTypeID() != null) 
            serviceRequestDTO.SRType = this.srTypeRepository.findById(serviceRequest.getSRTypeID()).get().getSRType();
		return serviceRequestDTO;
	}
	public List<ServiceRequestDTO> SRDTOListConvertsion(List<ServiceRequest> ServiceRequests){
		return ServiceRequests.stream().map(serviceRequest -> SRDTOConvertsion(serviceRequest)).collect(Collectors.toList());
	}

    public ServiceRequest SREntityConversion(ServiceRequestDTO serviceRequestDTO){
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setServiceRequestID(serviceRequestDTO.ServiceRequestID);
        serviceRequest.setSRNo(serviceRequestDTO.SRNo);
        serviceRequest.setTitle(serviceRequestDTO.Title);
        serviceRequest.setDescription(serviceRequestDTO.Description);
        serviceRequest.setStatus(serviceRequestDTO.Status);
        serviceRequest.setTargetYear(serviceRequestDTO.TargetYear);
        serviceRequest.setSRTypeID(serviceRequestDTO.SRTypeID);
        serviceRequest.setDateCreated(serviceRequestDTO.DateCreated);
        serviceRequest.setCreatedBy(serviceRequestDTO.CreatedBy);
        serviceRequest.setDateModified(serviceRequestDTO.DateModified);
        serviceRequest.setModifiedBy(serviceRequestDTO.ModifiedBy);
        return serviceRequest;
    }
    public List<ServiceRequest> SREntityListConversion(List<ServiceRequestDTO> serviceRequestsDTO){
        return serviceRequestsDTO.stream().map(serviceRequest -> SREntityConversion(serviceRequest)).collect(Collectors.toList());
  }

}
