package com.mbtc_empr_app.api.repositroy;

import com.mbtc_empr_app.api.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
}
