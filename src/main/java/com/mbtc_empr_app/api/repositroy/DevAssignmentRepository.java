package com.mbtc_empr_app.api.repositroy;

import com.mbtc_empr_app.api.entity.DevAssignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevAssignmentRepository extends JpaRepository<DevAssignment, Integer>{
}
