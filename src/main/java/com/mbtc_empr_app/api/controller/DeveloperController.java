package com.mbtc_empr_app.api.controller;

import java.util.List;

import com.mbtc_empr_app.api.dto.DeveloperDTO;
import com.mbtc_empr_app.api.service.DeveloperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping
	public List<DeveloperDTO> fetchDevelopers() {
        return this.developerService.getDevelopers();
	}

    @PostMapping
    public void createDeveloper(@RequestBody DeveloperDTO developerDTO){
        this.developerService.saveDeveloper(developerDTO);
    }
    
}
