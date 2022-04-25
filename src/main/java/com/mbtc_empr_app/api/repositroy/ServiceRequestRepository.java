package com.mbtc_empr_app.api.repositroy;

import com.mbtc_empr_app.api.entity.ServiceRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Integer>{
}
