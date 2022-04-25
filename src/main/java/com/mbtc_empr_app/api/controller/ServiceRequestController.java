package com.mbtc_empr_app.api.controller;

import java.util.List;

import com.mbtc_empr_app.api.dto.ServiceRequestDTO;
import com.mbtc_empr_app.api.service.ServiceRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/service/requests")
public class ServiceRequestController {
    
    @Autowired
    private ServiceRequestService serviceRequestService;

    @GetMapping
	public List<ServiceRequestDTO> fetchServiceRequests() {
        return this.serviceRequestService.getServiceRequests();
	}

    @GetMapping(path = "/{serviceRequestID}")
	public ServiceRequestDTO fetchServiceRequest(@PathVariable("serviceRequestID") Integer serviceRequestID) {
		return this.serviceRequestService.getServiceRequest(serviceRequestID);
	}

    @PostMapping()
    public void createServiceRequest(@RequestBody ServiceRequestDTO serviceRequestDTO){
        this.serviceRequestService.saveServiceRequest(serviceRequestDTO);
    }
}
