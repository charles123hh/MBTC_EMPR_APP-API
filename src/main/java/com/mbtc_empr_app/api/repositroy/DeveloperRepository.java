package com.mbtc_empr_app.api.repositroy;

import com.mbtc_empr_app.api.entity.Developer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer>, JpaSpecificationExecutor<Developer>{
}
