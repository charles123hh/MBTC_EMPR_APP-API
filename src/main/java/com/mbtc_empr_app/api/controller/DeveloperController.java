package com.mbtc_empr_app.api.controller;

import java.util.List;

import com.mbtc_empr_app.api.dto.DeveloperDTO;
import com.mbtc_empr_app.api.service.DeveloperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(path = "/{developerID}")
	public DeveloperDTO fetchDeveloper(@PathVariable("developerID") Integer developerID) {
		return this.developerService.getDeveloper(developerID);
	}

    @PostMapping()
    public void createDeveloper(@RequestBody DeveloperDTO developerDTO){
        this.developerService.saveDeveloper(developerDTO);
    }
    
    @PutMapping(path = "/{developerID}")
    public void editDeveloper(@PathVariable("developerID") Integer developerID, @RequestBody DeveloperDTO developerDTO){
        this.developerService.updateDeveloper(developerID, developerDTO);
    }

    @DeleteMapping(path = "/{developerID}")
    public void deleteDeveloper(@PathVariable("developerID") Integer developerID){
        this.developerService.deleteDeveloper(developerID);
    }
}
